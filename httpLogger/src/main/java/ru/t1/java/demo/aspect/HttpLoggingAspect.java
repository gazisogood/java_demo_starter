package ru.t1.java.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;


@Aspect
@Component
@ConditionalOnProperty(name = "logging.http.enabled", havingValue = "true", matchIfMissing = true)
public class HttpLoggingAspect {

    @Value("${logging.http.level:info}")
    private String logLevel;
    private static final Logger logger = LoggerFactory.getLogger(HttpLoggingAspect.class);

    @Around("@annotation(requestMapping)")
    public Object logHttpRequest(ProceedingJoinPoint joinPoint, RequestMapping requestMapping) throws Throwable {

        log("Incoming request: {} with args: {}", Arrays.toString(requestMapping.value()), Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();

        if (result instanceof ResponseEntity<?>) {
            log("Response: {}", ((ResponseEntity<?>) result).getBody());
        } else {
            log("Response: {}", result);
        }
        return result;
    }

    private void log(String message, Object... args) {
        LoggingTypes loglvl = getLogLevel();

        switch (loglvl) {
            case DEBUG:
                logger.debug(message, args);
                break;
            case WARN:
                logger.warn(message, args);
                break;
            case ERROR:
                logger.error(message, args);
                break;
            default:
                logger.info(message, args);
                break;
        }
    }

    private LoggingTypes getLogLevel() {
        try {
            return LoggingTypes.valueOf(logLevel.toUpperCase());
        } catch (IllegalArgumentException e) {
            return LoggingTypes.INFO;
        }
    }
}
