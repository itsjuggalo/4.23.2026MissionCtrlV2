package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.b0;
import com.google.gson.p;
import com.google.gson.v;
import gb.c;
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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f6688c = new v() { // from class: com.google.gson.internal.bind.DefaultDateTypeAdapter.1
        @Override // com.google.gson.v
        public TypeAdapter create(Gson gson, fb.a aVar) {
            if (aVar.c() != Date.class) {
                return null;
            }
            int i10 = 2;
            return new DefaultDateTypeAdapter(a.f6691b, i10, i10);
        }

        public String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f6689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f6690b;

    public final Date f(gb.a aVar) throws IOException {
        String strL0 = aVar.l0();
        synchronized (this.f6690b) {
            try {
                for (DateFormat dateFormat : this.f6690b) {
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            return dateFormat.parse(strL0);
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
                try {
                    return db.a.f(strL0, new ParsePosition(0));
                } catch (ParseException e10) {
                    throw new p("Failed parsing '" + strL0 + "' as Date; at path " + aVar.O(), e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Date c(gb.a aVar) throws IOException {
        if (aVar.n0() == gb.b.NULL) {
            aVar.j0();
            return null;
        }
        return this.f6689a.d(f(aVar));
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void e(c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.a0();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f6690b.get(0);
        synchronized (this.f6690b) {
            str = dateFormat.format(date);
        }
        cVar.o0(str);
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.f6690b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public DefaultDateTypeAdapter(a aVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f6690b = arrayList;
        Objects.requireNonNull(aVar);
        this.f6689a = aVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    public DefaultDateTypeAdapter(a aVar, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f6690b = arrayList;
        Objects.requireNonNull(aVar);
        this.f6689a = aVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (com.google.gson.internal.v.c()) {
            arrayList.add(b0.c(i10, i11));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f6691b = new C0109a(Date.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f6692a;

        public a(Class cls) {
            this.f6692a = cls;
        }

        public final v a(int i10, int i11) {
            return c(new DefaultDateTypeAdapter(this, i10, i11));
        }

        public final v b(String str) {
            return c(new DefaultDateTypeAdapter(this, str));
        }

        public final v c(DefaultDateTypeAdapter defaultDateTypeAdapter) {
            return TypeAdapters.b(this.f6692a, defaultDateTypeAdapter);
        }

        public abstract Date d(Date date);

        /* JADX INFO: renamed from: com.google.gson.internal.bind.DefaultDateTypeAdapter$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0109a extends a {
            public C0109a(Class cls) {
                super(cls);
            }

            @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.a
            public Date d(Date date) {
                return date;
            }
        }
    }
}
