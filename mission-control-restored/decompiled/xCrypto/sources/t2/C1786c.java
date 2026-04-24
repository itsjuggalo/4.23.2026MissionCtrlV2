package t2;

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
import q2.q;
import q2.w;
import q2.x;
import s2.AbstractC1770C;
import u2.AbstractC1868a;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: renamed from: t2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1786c extends w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f14754c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f14755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f14756b;

    /* JADX INFO: renamed from: t2.c$a */
    public class a implements x {
        @Override // q2.x
        public w create(q2.e eVar, C1925a c1925a) {
            a aVar = null;
            if (c1925a.c() != Date.class) {
                return null;
            }
            int i4 = 2;
            return new C1786c(b.f14757b, i4, i4, aVar);
        }

        public String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
    }

    public /* synthetic */ C1786c(b bVar, int i4, int i5, a aVar) {
        this(bVar, i4, i5);
    }

    public final Date f(C1946a c1946a) throws IOException {
        String strP0 = c1946a.p0();
        synchronized (this.f14756b) {
            try {
                for (DateFormat dateFormat : this.f14756b) {
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            return dateFormat.parse(strP0);
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
                try {
                    return AbstractC1868a.f(strP0, new ParsePosition(0));
                } catch (ParseException e4) {
                    throw new q("Failed parsing '" + strP0 + "' as Date; at path " + c1946a.S(), e4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // q2.w
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Date c(C1946a c1946a) throws IOException {
        if (c1946a.r0() == y2.b.NULL) {
            c1946a.n0();
            return null;
        }
        return this.f14755a.d(f(c1946a));
    }

    @Override // q2.w
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void e(y2.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.e0();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f14756b.get(0);
        synchronized (this.f14756b) {
            str = dateFormat.format(date);
        }
        cVar.s0(str);
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.f14756b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public /* synthetic */ C1786c(b bVar, String str, a aVar) {
        this(bVar, str);
    }

    public C1786c(b bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f14756b = arrayList;
        Objects.requireNonNull(bVar);
        this.f14755a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    public C1786c(b bVar, int i4, int i5) {
        ArrayList arrayList = new ArrayList();
        this.f14756b = arrayList;
        Objects.requireNonNull(bVar);
        this.f14755a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i4, i5, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i4, i5));
        }
        if (s2.w.c()) {
            arrayList.add(AbstractC1770C.c(i4, i5));
        }
    }

    /* JADX INFO: renamed from: t2.c$b */
    public static abstract class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f14757b = new a(Date.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f14758a;

        public b(Class cls) {
            this.f14758a = cls;
        }

        public final x a(int i4, int i5) {
            return c(new C1786c(this, i4, i5, null));
        }

        public final x b(String str) {
            return c(new C1786c(this, str, (a) null));
        }

        public final x c(C1786c c1786c) {
            return p.b(this.f14758a, c1786c);
        }

        public abstract Date d(Date date);

        /* JADX INFO: renamed from: t2.c$b$a */
        public class a extends b {
            public a(Class cls) {
                super(cls);
            }

            @Override // t2.C1786c.b
            public Date d(Date date) {
                return date;
            }
        }
    }
}
