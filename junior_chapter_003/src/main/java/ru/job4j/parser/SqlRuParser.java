package ru.job4j.parser;

import java.io.InputStream;
import java.util.*;
import java.util.Calendar;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SqlRuParser implements Job {
    private static Properties properties;
    private static final Logger LOGGER = Logger.getLogger(SqlRuParser.class);
    private StorageSQL storage = new StorageSQL(properties);
    private ParseJSOUP parser = new ParseJSOUP();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log(Level.INFO, "Выполнен запуск приложения \"Парсер вакансий на sql.ru\"");
        storage.setConnection();
        Date lastDate = storage.getLastDate();
        if (lastDate == null) {
            lastDate = getFirstDate();
        }
        List<Vacancy> vacancies = parser.getVacancies(lastDate);
        storage.insVacancies(vacancies);
        storage.setLastDate(new Date());
    }

    public static void main(String[] args) throws SchedulerException {
        setProperties(args[0]);
        String exp = properties.getProperty("cron.time");
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        JobDetail job = JobBuilder.newJob(SqlRuParser.class).build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(exp))
                .build();
        scheduler.scheduleJob(job, trigger);
    }

    static void log(Level level, String msg) {
        LOGGER.log(level, msg);
    }

    private static void setProperties(String fileName) {
        try (InputStream in = SqlRuParser.class.getClassLoader().getResourceAsStream(fileName)) {
            properties = new Properties();
            properties.load(Objects.requireNonNull(in));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Date getFirstDate() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_YEAR, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }
}
