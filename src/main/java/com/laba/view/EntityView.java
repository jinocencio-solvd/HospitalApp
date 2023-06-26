package com.laba.view;

import com.laba.interfaces.views.IEntityView;
import com.laba.utils.json.JacksonUtil;
import com.laba.utils.xml.jaxb.JAXBUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class EntityView<T> implements IEntityView<T> {
    private static final Logger LOG = LogManager.getLogger(EntityView.class);

    @Override
    public void logOutView(String data) {
        LOG.info(data);
    }

    @Override
    public void jsonApiView(String data) {
        LOG.info(data);
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
