package com.laba.enums;

public enum FileType {
    XML(".xml"),
    JSON(".json");

    private final String extension;

    FileType(String extension){
        this.extension=extension;
    }

    public String getExtension() {
        return extension;
    }
}
