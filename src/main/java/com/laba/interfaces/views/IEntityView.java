package com.laba.interfaces.views;

public interface IEntityView<T> {

    void systemOutView(String data);

    void jsonApiView(String data);

    void jsonOutView(String data, String fileName);

    void xmlOutView(String data, String fileName);

}
