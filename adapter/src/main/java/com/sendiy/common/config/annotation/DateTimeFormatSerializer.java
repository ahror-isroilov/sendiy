package com.sendiy.common.config.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sendiy.common.annotation.date_formatter.FormatDate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * author: ahror
 * <p>
 * since: 25/10/2024
 */
public class DateTimeFormatSerializer extends StdSerializer<LocalDateTime> implements ContextualSerializer {
    private DateTimeFormatter formatter;
    private ZoneId zoneId;

    public DateTimeFormatSerializer() {
        super(LocalDateTime.class);
    }

    public DateTimeFormatSerializer(DateTimeFormatter formatter, ZoneId zoneId) {
        super(LocalDateTime.class);
        this.formatter = formatter;
        this.zoneId = zoneId;
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty property) throws JsonMappingException {
        FormatDate annotation = property.getAnnotation(FormatDate.class);
        if (annotation != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(annotation.pattern());
            ZoneId id = ZoneId.of(annotation.timezone());
            return new DateTimeFormatSerializer(formatter, id);
        }
        return this;
    }

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }
        String formatted = value.atZone(ZoneId.systemDefault())
                .withZoneSameInstant(zoneId)
                .format(formatter);
        gen.writeString(formatted);
    }
}
