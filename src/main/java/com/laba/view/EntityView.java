package com.laba.view;

import com.laba.interfaces.views.IEntityView;
import com.laba.utils.json.JacksonUtil;
import com.laba.utils.xml.jaxb.JAXBUtil;

public abstract class EntityView<T> implements IEntityView<T> {

    @Override
    public void systemOutView(String data) {
        System.out.println(data);
    }

    @Override
    public void jsonApiView(String data) {
        System.out.println(data);
    }

    @Override
    public void jsonOutView(String data, String fileName) {
        JacksonUtil.toJsonFile(data, fileName);
    }

    @Override
    public void xmlOutView(String data, String fileName) {
        JAXBUtil.marshallOneXmlOut(data, fileName);
    }

}
