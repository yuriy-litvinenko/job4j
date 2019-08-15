package ru.job4j.parser;

import org.apache.log4j.Level;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class StorageSQL implements AutoCloseable {
    private Properties properties;
    private Connection connection;
    private static final String SELECT_LAST_DATE_SQL = String.join("",
            "select value from params where name = 'last_run_date'");
    private static final String REPLACE_LAST_DATE_SQL = String.join("",
            "update params set value = ? where name = 'last_run_date'");
    private static final String INSERT_VACANCY_SQL = String.join("",
            "insert into vacancy (name, text, link) values (?, ?, ?);");

    StorageSQL(Properties properties) {
        this.properties = properties;
    }

    void setConnection() {
        try {
            Class.forName(properties.getProperty("jdbc.driver"));
            connection = DriverManager.getConnection(
                    properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password")
            );
            connection.setAutoCommit(false);
        } catch (Exception e) {
            SqlRuParser.log(Level.ERROR, e.getMessage());
        }
    }

    Date getLastDate() {
        Timestamp timestamp = null;
        Date result = null;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(SELECT_LAST_DATE_SQL);
            rs.next();
            timestamp = rs.getTimestamp("value");
        } catch (Exception e) {
            SqlRuParser.log(Level.ERROR, e.getMessage());
        }
        if (timestamp != null) {
            result = new Date(timestamp.getTime());
        }
        return result;
    }

    void setLastDate(Date lastDate) {
        try (PreparedStatement ps = connection.prepareStatement(REPLACE_LAST_DATE_SQL)) {
            Timestamp lastDateSql = new Timestamp(lastDate.getTime());
            try {
                ps.setTimestamp(1, lastDateSql);
                ps.execute();
                connection.commit();
            } catch (SQLException se) {
                connection.rollback();
            }
        } catch (Exception e) {
            SqlRuParser.log(Level.ERROR, e.getMessage());
        }
    }

    void insVacancies(List<Vacancy> vacancies) {
        int number = 0;
        try (PreparedStatement ps = connection.prepareStatement(INSERT_VACANCY_SQL)) {
            for (Vacancy vac : vacancies) {
                try {
                    ps.setString(1, vac.getName());
                    ps.setString(2, vac.getText());
                    ps.setString(3, vac.getLink());
                    ps.execute();
                    connection.commit();
                    number++;
                    SqlRuParser.log(Level.INFO, "Добавлена новая запись. Имя вакансии: \"" + vac.getName() + "\"");
                } catch (SQLException se) {
                    SqlRuParser.log(Level.ERROR, se.getMessage());
                    connection.rollback();
                }
            }
            if (number == 0) {
                SqlRuParser.log(Level.INFO, "Новых записей не было найдено");
            }
        } catch (Exception e) {
            SqlRuParser.log(Level.ERROR, e.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
