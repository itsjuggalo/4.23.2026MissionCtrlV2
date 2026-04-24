package com.google.android.material.datepicker;

import android.text.format.DateUtils;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static String a(long j7) {
        return b(j7, Locale.getDefault());
    }

    public static String b(long j7, Locale locale) {
        return r.b(locale).format(new Date(j7));
    }

    public static String c(long j7) {
        return DateUtils.formatDateTime(null, j7, 8228);
    }

    public static String d(long j7) {
        return e(j7, Locale.getDefault());
    }

    public static String e(long j7, Locale locale) {
        return r.k(locale).format(new Date(j7));
    }
}
