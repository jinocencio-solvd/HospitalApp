package com.laba.utils.xml.jaxb;

import java.sql.Time;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimeAdapter extends XmlAdapter<String, Time> {

    @Override
    public Time unmarshal(String s) {
        return Time.valueOf(s);
    }

    @Override
    public String marshal(Time time) {
        return time.toString();
    }
}
