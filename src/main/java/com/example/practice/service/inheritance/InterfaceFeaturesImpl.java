package com.example.practice.service.inheritance;

public class InterfaceFeaturesImpl implements InterfaceFeatures{
    @Override
    public void get() {
    }

    @Override
    public void set() {
        String var = InterfaceFeatures.var;
    }
}
