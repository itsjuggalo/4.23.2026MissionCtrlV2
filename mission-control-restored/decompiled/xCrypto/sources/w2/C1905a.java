package w2;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import q2.e;
import q2.q;
import q2.w;
import q2.x;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: renamed from: w2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1905a extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f15571b = new C0252a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f15572a;

    /* JADX INFO: renamed from: w2.a$a, reason: collision with other inner class name */
    public class C0252a implements x {
        @Override // q2.x
        public w create(e eVar, C1925a c1925a) {
            C0252a c0252a = null;
            if (c1925a.c() == Date.class) {
                return new C1905a(c0252a);
            }
            return null;
        }
    }

    public /* synthetic */ C1905a(C0252a c0252a) {
        this();
    }

    @Override // q2.w
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date c(C1946a c1946a) throws IOException {
        Date date;
        if (c1946a.r0() == y2.b.NULL) {
            c1946a.n0();
            return null;
        }
        String strP0 = c1946a.p0();
        synchronized (this) {
            TimeZone timeZone = this.f15572a.getTimeZone();
            try {
                try {
                    date = new Date(this.f15572a.parse(strP0).getTime());
                } catch (ParseException e4) {
                    throw new q("Failed parsing '" + strP0 + "' as SQL Date; at path " + c1946a.S(), e4);
                }
            } finally {
                this.f15572a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // q2.w
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(y2.c cVar, Date date) throws IOException {
        String str;
        if (date == null) {
            cVar.e0();
            return;
        }
        synchronized (this) {
            str = this.f15572a.format((java.util.Date) date);
        }
        cVar.s0(str);
    }

    private C1905a() {
        this.f15572a = new SimpleDateFormat("MMM d, yyyy");
    }
}
