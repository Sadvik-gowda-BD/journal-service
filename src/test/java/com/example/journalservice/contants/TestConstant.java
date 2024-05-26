package com.example.journalservice.contants;

import org.apache.kafka.common.protocol.types.Field;

import java.time.LocalDateTime;
import java.time.Month;

public final class TestConstant {

    public static final String KEY = "101";
    public static final String MESSAGE_1 = "message 1";
    public static final String MESSAGE_2 = "message 1";
    public static final String ACCESS_BY = "access by";
    public static final String ACCESS_FOR = "access for";
    public static final LocalDateTime LOCAL_DATE_TIME_1 = LocalDateTime.of(2023, Month.APRIL, 10, 5, 20, 7);
    public static final LocalDateTime LOCAL_DATE_TIME_2 = LocalDateTime.of(2024, Month.APRIL, 10, 5, 20, 7);
    public static final String DATE_TIME_1 = LOCAL_DATE_TIME_1.toString();
    public static final String DATE_TIME_2 = LOCAL_DATE_TIME_2.toString();

    private TestConstant() {
    }
}
