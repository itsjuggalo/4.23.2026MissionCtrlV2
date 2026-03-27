package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.p;
import com.google.gson.v;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import o4.C2462a;
import p4.C2568a;
import p4.C2570c;
import p4.EnumC2569b;

/* JADX INFO: loaded from: classes.dex */
final class SqlTimeTypeAdapter extends TypeAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f16210b = new v() { // from class: com.google.gson.internal.sql.SqlTimeTypeAdapter.1
        @Override // com.google.gson.v
        public TypeAdapter create(Gson gson, C2462a c2462a) {
            if (c2462a.c() == Time.class) {
                return new SqlTimeTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f16211a;

    private SqlTimeTypeAdapter() {
        this.f16211a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Time c(C2568a c2568a) throws IOException {
        Time time;
        if (c2568a.x0() == EnumC2569b.NULL) {
            c2568a.r0();
            return null;
        }
        String strV0 = c2568a.v0();
        synchronized (this) {
            TimeZone timeZone = this.f16211a.getTimeZone();
            try {
                try {
                    time = new Time(this.f16211a.parse(strV0).getTime());
                } catch (ParseException e8) {
                    throw new p("Failed parsing '" + strV0 + "' as SQL Time; at path " + c2568a.N(), e8);
                }
            } finally {
                this.f16211a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(C2570c c2570c, Time time) throws IOException {
        String str;
        if (time == null) {
            c2570c.R();
            return;
        }
        synchronized (this) {
            str = this.f16211a.format((Date) time);
        }
        c2570c.y0(str);
    }
}
