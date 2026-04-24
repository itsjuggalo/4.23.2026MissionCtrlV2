package r4;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import l4.C2172e;
import l4.q;
import l4.w;
import l4.x;
import s4.C2645a;
import t4.C2657a;

/* JADX INFO: renamed from: r4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2581a extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f22485b = new C0347a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f22486a;

    /* JADX INFO: renamed from: r4.a$a, reason: collision with other inner class name */
    public class C0347a implements x {
        @Override // l4.x
        public w create(C2172e c2172e, C2645a c2645a) {
            C0347a c0347a = null;
            if (c2645a.c() == Date.class) {
                return new C2581a(c0347a);
            }
            return null;
        }
    }

    public /* synthetic */ C2581a(C0347a c0347a) {
        this();
    }

    @Override // l4.w
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date c(C2657a c2657a) throws IOException {
        Date date;
        if (c2657a.M0() == t4.b.NULL) {
            c2657a.I0();
            return null;
        }
        String strK0 = c2657a.K0();
        synchronized (this) {
            TimeZone timeZone = this.f22486a.getTimeZone();
            try {
                try {
                    date = new Date(this.f22486a.parse(strK0).getTime());
                } catch (ParseException e7) {
                    throw new q("Failed parsing '" + strK0 + "' as SQL Date; at path " + c2657a.c0(), e7);
                }
            } finally {
                this.f22486a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // l4.w
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(t4.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.z0();
            return;
        }
        synchronized (this) {
            str = this.f22486a.format((java.util.Date) date);
        }
        cVar.N0(str);
    }

    private C2581a() {
        this.f22486a = new SimpleDateFormat("MMM d, yyyy");
    }
}
