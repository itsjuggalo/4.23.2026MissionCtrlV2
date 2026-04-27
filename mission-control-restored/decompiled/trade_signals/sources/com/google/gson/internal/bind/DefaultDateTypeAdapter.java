package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.B;
import com.google.gson.p;
import com.google.gson.v;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import m4.AbstractC2378a;
import o4.C2462a;
import p4.C2568a;
import p4.C2570c;
import p4.EnumC2569b;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f16052c = new v() { // from class: com.google.gson.internal.bind.DefaultDateTypeAdapter.1
        @Override // com.google.gson.v
        public TypeAdapter create(Gson gson, C2462a c2462a) {
            if (c2462a.c() != Date.class) {
                return null;
            }
            int i8 = 2;
            return new DefaultDateTypeAdapter(a.f16055b, i8, i8);
        }

        public String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f16053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f16054b;

    public static abstract class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f16055b = new C0260a(Date.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f16056a;

        /* JADX INFO: renamed from: com.google.gson.internal.bind.DefaultDateTypeAdapter$a$a, reason: collision with other inner class name */
        public class C0260a extends a {
            public C0260a(Class cls) {
                super(cls);
            }

            @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.a
            public Date d(Date date) {
                return date;
            }
        }

        public a(Class cls) {
            this.f16056a = cls;
        }

        public final v a(int i8, int i9) {
            return c(new DefaultDateTypeAdapter(this, i8, i9));
        }

        public final v b(String str) {
            return c(new DefaultDateTypeAdapter(this, str));
        }

        public final v c(DefaultDateTypeAdapter defaultDateTypeAdapter) {
            return TypeAdapters.a(this.f16056a, defaultDateTypeAdapter);
        }

        public abstract Date d(Date date);
    }

    public DefaultDateTypeAdapter(a aVar, int i8, int i9) {
        ArrayList arrayList = new ArrayList();
        this.f16054b = arrayList;
        Objects.requireNonNull(aVar);
        this.f16053a = aVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i8, i9, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i8, i9));
        }
        if (com.google.gson.internal.v.c()) {
            arrayList.add(B.c(i8, i9));
        }
    }

    public final Date f(C2568a c2568a) throws IOException {
        String strV0 = c2568a.v0();
        synchronized (this.f16054b) {
            try {
                for (DateFormat dateFormat : this.f16054b) {
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            return dateFormat.parse(strV0);
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
                try {
                    return AbstractC2378a.f(strV0, new ParsePosition(0));
                } catch (ParseException e8) {
                    throw new p("Failed parsing '" + strV0 + "' as Date; at path " + c2568a.N(), e8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Date c(C2568a c2568a) throws IOException {
        if (c2568a.x0() == EnumC2569b.NULL) {
            c2568a.r0();
            return null;
        }
        return this.f16053a.d(f(c2568a));
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void e(C2570c c2570c, Date date) throws IOException {
        String str;
        if (date == null) {
            c2570c.R();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f16054b.get(0);
        synchronized (this.f16054b) {
            str = dateFormat.format(date);
        }
        c2570c.y0(str);
    }

    public String toString() {
        StringBuilder sb;
        String simpleName;
        DateFormat dateFormat = (DateFormat) this.f16054b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            sb = new StringBuilder();
            sb.append("DefaultDateTypeAdapter(");
            simpleName = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            sb = new StringBuilder();
            sb.append("DefaultDateTypeAdapter(");
            simpleName = dateFormat.getClass().getSimpleName();
        }
        sb.append(simpleName);
        sb.append(')');
        return sb.toString();
    }

    public DefaultDateTypeAdapter(a aVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f16054b = arrayList;
        Objects.requireNonNull(aVar);
        this.f16053a = aVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }
}
