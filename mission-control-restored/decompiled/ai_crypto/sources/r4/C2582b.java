package r4;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import l4.C2172e;
import l4.q;
import l4.w;
import l4.x;
import s4.C2645a;
import t4.C2657a;

/* JADX INFO: renamed from: r4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2582b extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f22487b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f22488a;

    /* JADX INFO: renamed from: r4.b$a */
    public class a implements x {
        @Override // l4.x
        public w create(C2172e c2172e, C2645a c2645a) {
            a aVar = null;
            if (c2645a.c() == Time.class) {
                return new C2582b(aVar);
            }
            return null;
        }
    }

    public /* synthetic */ C2582b(a aVar) {
        this();
    }

    @Override // l4.w
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Time c(C2657a c2657a) throws IOException {
        Time time;
        if (c2657a.M0() == t4.b.NULL) {
            c2657a.I0();
            return null;
        }
        String strK0 = c2657a.K0();
        synchronized (this) {
            TimeZone timeZone = this.f22488a.getTimeZone();
            try {
                try {
                    time = new Time(this.f22488a.parse(strK0).getTime());
                } catch (ParseException e7) {
                    throw new q("Failed parsing '" + strK0 + "' as SQL Time; at path " + c2657a.c0(), e7);
                }
            } finally {
                this.f22488a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // l4.w
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(t4.c cVar, Time time) throws IOException {
        String str;
        if (time == null) {
            cVar.z0();
            return;
        }
        synchronized (this) {
            str = this.f22488a.format((Date) time);
        }
        cVar.N0(str);
    }

    private C2582b() {
        this.f22488a = new SimpleDateFormat("hh:mm:ss a");
    }
}
