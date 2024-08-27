package com.chud.ntm.item.enums;

public enum EShape {
    INGOT("ingot"),
    POWDER("dust"),
    POWDER_TINY("dust", "Tiny"),
    BILLET("billet"),
    NUGGET("nugget"),
    PLATE("plate"),
    WIRE("wire");

    public String ODPrefix, ODSuffix;

    EShape(String ODPrefix, String ODSuffix) {
        this.ODPrefix = ODPrefix;
        this.ODSuffix = ODSuffix;
    }

    EShape(String ODPrefix) {
        this(ODPrefix, "");
    }

    public String snake_case() {
        return toString().toLowerCase();
    }

}
