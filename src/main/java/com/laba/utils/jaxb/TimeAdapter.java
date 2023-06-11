package com.laba.utils.jaxb;

import java.sql.Time;
import java.text.SimpleDateFormat;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimeAdapter extends XmlAdapter<String, Time> {

    @Override
    public Time unmarshal(String s) throws Exception {
        return Time.valueOf(s);
    }

    @Override
    public String marshal(Time time) throws Exception {
        return time.toString();
    }
}
