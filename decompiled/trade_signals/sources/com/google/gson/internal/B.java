package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class B {
    public static String a(int i8) {
        if (i8 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i8 == 1) {
            return "MMMM d, yyyy";
        }
        if (i8 == 2) {
            return "MMM d, yyyy";
        }
        if (i8 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i8);
    }

    public static String b(int i8) {
        if (i8 == 0 || i8 == 1) {
            return "h:mm:ss a z";
        }
        if (i8 == 2) {
            return "h:mm:ss a";
        }
        if (i8 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i8);
    }

    public static DateFormat c(int i8, int i9) {
        return new SimpleDateFormat(a(i8) + " " + b(i9), Locale.US);
    }
}
