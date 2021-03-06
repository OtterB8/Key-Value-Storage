package com.baopdh.dbserver.util;

import com.baopdh.dbserver.Config;

public class ConfigGetter {
    private ConfigGetter() {}

    public static int getInt(String config, int defaultValue) {
        int res = defaultValue;

        String value = Config.getInstance().getProperty(config);
        try {
            res = Integer.parseInt(value);
        } catch (Exception e) {} // ignore exception

        return res;
    }

    public static String get(String config, String defaultValue) {
        String res = defaultValue;

        String value = Config.getInstance().getProperty(config);
        if (value != null && !value.equals(""))
            res = value;

        return res;
    }
}
