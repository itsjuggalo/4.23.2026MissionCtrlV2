package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.p;
import com.google.gson.v;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import o4.C2462a;
import p4.C2568a;
import p4.C2570c;
import p4.EnumC2569b;

/* JADX INFO: loaded from: classes.dex */
final class SqlDateTypeAdapter extends TypeAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f16208b = new v() { // from class: com.google.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // com.google.gson.v
        public TypeAdapter create(Gson gson, C2462a c2462a) {
            if (c2462a.c() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f16209a;

    private SqlDateTypeAdapter() {
        this.f16209a = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date c(C2568a c2568a) throws IOException {
        Date date;
        if (c2568a.x0() == EnumC2569b.NULL) {
            c2568a.r0();
            return null;
        }
        String strV0 = c2568a.v0();
        synchronized (this) {
            TimeZone timeZone = this.f16209a.getTimeZone();
            try {
                try {
                    date = new Date(this.f16209a.parse(strV0).getTime());
                } catch (ParseException e8) {
                    throw new p("Failed parsing '" + strV0 + "' as SQL Date; at path " + c2568a.N(), e8);
                }
            } finally {
                this.f16209a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(C2570c c2570c, Date date) throws IOException {
        String str;
        if (date == null) {
            c2570c.R();
            return;
        }
        synchronized (this) {
            str = this.f16209a.format((java.util.Date) date);
        }
        c2570c.y0(str);
    }
}
