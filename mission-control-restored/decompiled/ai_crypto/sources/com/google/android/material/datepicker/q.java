package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f11615c = new q(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f11616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeZone f11617b;

    public q(Long l7, TimeZone timeZone) {
        this.f11616a = l7;
        this.f11617b = timeZone;
    }

    public static q c() {
        return f11615c;
    }

    public Calendar a() {
        return b(this.f11617b);
    }

    public Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l7 = this.f11616a;
        if (l7 != null) {
            calendar.setTimeInMillis(l7.longValue());
        }
        return calendar;
    }
}
