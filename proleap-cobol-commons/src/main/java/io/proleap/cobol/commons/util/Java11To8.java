package io.proleap.cobol.commons.util;


import org.apache.commons.lang.StringUtils;


public class Java11To8 {

    public static String repeat(String str, int count) {
        return org.apache.commons.lang.StringUtils.repeat(str, count);
    }

    public static String stripTrailing(String input) {
        return StringUtils.stripEnd(input, null);
    }

    public static boolean isBlank(String input) {
        return StringUtils.isBlank(input);
    }

}
