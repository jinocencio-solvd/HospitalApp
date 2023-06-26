package com.laba.controllers.controller;

import com.laba.interfaces.controllers.IEntityController;
import com.laba.utils.json.JacksonUtil;
import com.laba.view.EntityView;

public abstract class EntityController<T, D extends EntityView<T>> implements IEntityController<T> {

    private T model;
    private D view;


    public EntityController(T model, D view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void generateSystemOutView() {
        view.systemOutView(model.toString());
    }

    @Override
    public void generateJsonApiView() {
        String out = JacksonUtil.toJsonString(model);
        view.jsonApiView(out);
    }

    @Override
    public void generateJsonOutView(String fileName) {
        view.jsonOutView(model.toString(), fileName);
    }

    @Override
    public void generateXmlOutView(String fileName) {
        view.xmlOutView(model.toString(), fileName);
    }


}
