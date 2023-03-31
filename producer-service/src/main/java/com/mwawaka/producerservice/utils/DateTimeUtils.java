package com.mwawaka.producerservice.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("MMMM d, yyyy, HH:mm:ss");

    public static String formatTimestamp(long timestamp) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneOffset.UTC);
        return dateTime.format(FORMATTER);
    }
}
