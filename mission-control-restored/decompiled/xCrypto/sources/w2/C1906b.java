package w2;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import q2.e;
import q2.q;
import q2.w;
import q2.x;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: renamed from: w2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1906b extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f15573b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f15574a;

    /* JADX INFO: renamed from: w2.b$a */
    public class a implements x {
        @Override // q2.x
        public w create(e eVar, C1925a c1925a) {
            a aVar = null;
            if (c1925a.c() == Time.class) {
                return new C1906b(aVar);
            }
            return null;
        }
    }

    public /* synthetic */ C1906b(a aVar) {
        this();
    }

    @Override // q2.w
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Time c(C1946a c1946a) throws IOException {
        Time time;
        if (c1946a.r0() == y2.b.NULL) {
            c1946a.n0();
            return null;
        }
        String strP0 = c1946a.p0();
        synchronized (this) {
            TimeZone timeZone = this.f15574a.getTimeZone();
            try {
                try {
                    time = new Time(this.f15574a.parse(strP0).getTime());
                } catch (ParseException e4) {
                    throw new q("Failed parsing '" + strP0 + "' as SQL Time; at path " + c1946a.S(), e4);
                }
            } finally {
                this.f15574a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // q2.w
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(y2.c cVar, Time time) throws IOException {
        String str;
        if (time == null) {
            cVar.e0();
            return;
        }
        synchronized (this) {
            str = this.f15574a.format((Date) time);
        }
        cVar.s0(str);
    }

    private C1906b() {
        this.f15574a = new SimpleDateFormat("hh:mm:ss a");
    }
}
