package com.laba.utils.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateAdapterJSON extends StdSerializer<Date> {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    protected DateAdapterJSON() {
        this((Class<Date>) null);
    }

    protected DateAdapterJSON(Class<Date> t) {
        super(t);
    }

    protected DateAdapterJSON(JavaType type) {
        super(type);
    }

    protected DateAdapterJSON(Class<?> t, boolean dummy) {
        super(t, dummy);
    }

    protected DateAdapterJSON(StdSerializer<?> src) {
        super(src);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider) throws IOException {
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        jsonGenerator.writeString(formattedDate);
    }
}
