package com.laba.utils.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.sql.Time;

public class TimeAdapterJSON extends StdSerializer<Time> {

    protected TimeAdapterJSON() {
        this((Class<Time>) null);
    }

    protected TimeAdapterJSON(Class<Time> t) {
        super(t);
    }

    protected TimeAdapterJSON(JavaType type) {
        super(type);
    }

    protected TimeAdapterJSON(Class<?> t, boolean dummy) {
        super(t, dummy);
    }

    protected TimeAdapterJSON(StdSerializer<?> src) {
        super(src);
    }

    @Override
    public void serialize(Time time, JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(time.toString());
    }
}
