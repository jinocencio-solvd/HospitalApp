package com.laba.interfaces.controllers;

public interface IEntityController<T> {

    void generateSystemOutView();

    void generateJsonApiView();

    void generateJsonOutView(String fileName);

    void generateXmlOutView(String fileName);

}
