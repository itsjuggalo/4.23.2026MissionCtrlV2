package o4;

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
import l4.C2172e;
import l4.q;
import l4.w;
import l4.x;
import n4.C;
import p4.AbstractC2376a;
import s4.C2645a;
import t4.C2657a;

/* JADX INFO: renamed from: o4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2311c extends w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f20063c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f20064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f20065b;

    /* JADX INFO: renamed from: o4.c$a */
    public class a implements x {
        @Override // l4.x
        public w create(C2172e c2172e, C2645a c2645a) {
            a aVar = null;
            if (c2645a.c() != Date.class) {
                return null;
            }
            int i7 = 2;
            return new C2311c(b.f20066b, i7, i7, aVar);
        }

        public String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
    }

    public /* synthetic */ C2311c(b bVar, int i7, int i8, a aVar) {
        this(bVar, i7, i8);
    }

    public final Date f(C2657a c2657a) throws IOException {
        String strK0 = c2657a.K0();
        synchronized (this.f20065b) {
            try {
                for (DateFormat dateFormat : this.f20065b) {
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            return dateFormat.parse(strK0);
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
                try {
                    return AbstractC2376a.f(strK0, new ParsePosition(0));
                } catch (ParseException e7) {
                    throw new q("Failed parsing '" + strK0 + "' as Date; at path " + c2657a.c0(), e7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // l4.w
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Date c(C2657a c2657a) throws IOException {
        if (c2657a.M0() == t4.b.NULL) {
            c2657a.I0();
            return null;
        }
        return this.f20064a.d(f(c2657a));
    }

    @Override // l4.w
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void e(t4.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.z0();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f20065b.get(0);
        synchronized (this.f20065b) {
            str = dateFormat.format(date);
        }
        cVar.N0(str);
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.f20065b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public /* synthetic */ C2311c(b bVar, String str, a aVar) {
        this(bVar, str);
    }

    public C2311c(b bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f20065b = arrayList;
        Objects.requireNonNull(bVar);
        this.f20064a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    public C2311c(b bVar, int i7, int i8) {
        ArrayList arrayList = new ArrayList();
        this.f20065b = arrayList;
        Objects.requireNonNull(bVar);
        this.f20064a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i7, i8, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i7, i8));
        }
        if (n4.w.c()) {
            arrayList.add(C.c(i7, i8));
        }
    }

    /* JADX INFO: renamed from: o4.c$b */
    public static abstract class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f20066b = new a(Date.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f20067a;

        public b(Class cls) {
            this.f20067a = cls;
        }

        public final x a(int i7, int i8) {
            return c(new C2311c(this, i7, i8, null));
        }

        public final x b(String str) {
            return c(new C2311c(this, str, (a) null));
        }

        public final x c(C2311c c2311c) {
            return p.b(this.f20067a, c2311c);
        }

        public abstract Date d(Date date);

        /* JADX INFO: renamed from: o4.c$b$a */
        public class a extends b {
            public a(Class cls) {
                super(cls);
            }

            @Override // o4.C2311c.b
            public Date d(Date date) {
                return date;
            }
        }
    }
}
