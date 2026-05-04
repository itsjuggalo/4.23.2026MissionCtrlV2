package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.p;
import com.google.gson.v;
import gb.b;
import gb.c;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class SqlDateTypeAdapter extends TypeAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f6832b = new v() { // from class: com.google.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // com.google.gson.v
        public TypeAdapter create(Gson gson, fb.a aVar) {
            if (aVar.c() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f6833a;

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date c(gb.a aVar) throws IOException {
        Date date;
        if (aVar.n0() == b.NULL) {
            aVar.j0();
            return null;
        }
        String strL0 = aVar.l0();
        synchronized (this) {
            TimeZone timeZone = this.f6833a.getTimeZone();
            try {
                try {
                    date = new Date(this.f6833a.parse(strL0).getTime());
                } catch (ParseException e10) {
                    throw new p("Failed parsing '" + strL0 + "' as SQL Date; at path " + aVar.O(), e10);
                }
            } finally {
                this.f6833a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.a0();
            return;
        }
        synchronized (this) {
            str = this.f6833a.format((java.util.Date) date);
        }
        cVar.o0(str);
    }

    private SqlDateTypeAdapter() {
        this.f6833a = new SimpleDateFormat("MMM d, yyyy");
    }
}
