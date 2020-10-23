package ru.job4j.jdbc;

import org.apache.log4j.Logger;

public class UsageLog4j2 {
    private static final Logger LOG = Logger.getLogger(UsageLog4j2.class);

    public static void main(String[] args) {
        LOG.debug("debug"); // all
        LOG.info("info"); // except debug
        LOG.warn("warn"); // except debug and info
        LOG.error("error"); // except debug, info and warn
        LOG.fatal("fatal"); // only fatal
    }
}
