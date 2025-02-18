package ru.t1.java.demo.aspect;

enum LoggingTypes {
    INFO("info"),
    WARN("warn"),
    DEBUG("debug"),
    ERROR("error");

    private final String level;

    LoggingTypes(String level) {
        this.level = level;
    }
}
