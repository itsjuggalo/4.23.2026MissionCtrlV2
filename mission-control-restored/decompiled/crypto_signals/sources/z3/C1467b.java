package z3;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import t3.i;
import t3.s;
import t3.t;

/* JADX INFO: renamed from: z3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1467b extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11760b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f11761a;

    /* JADX INFO: renamed from: z3.b$a */
    public class a implements t {
        @Override // t3.t
        public final s create(t3.e eVar, A3.a aVar) {
            if (aVar.f61a == Time.class) {
                return new C1467b(0);
            }
            return null;
        }
    }

    public /* synthetic */ C1467b(int i) {
        this();
    }

    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        Time time;
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        String strZ = aVar.z();
        synchronized (this) {
            TimeZone timeZone = this.f11761a.getTimeZone();
            try {
                try {
                    time = new Time(this.f11761a.parse(strZ).getTime());
                } catch (ParseException e) {
                    throw new i("Failed parsing '" + strZ + "' as SQL Time; at path " + aVar.n(), e);
                }
            } finally {
                this.f11761a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        String str;
        Time time = (Time) obj;
        if (time == null) {
            bVar.m();
            return;
        }
        synchronized (this) {
            str = this.f11761a.format((Date) time);
        }
        bVar.v(str);
    }

    private C1467b() {
        this.f11761a = new SimpleDateFormat("hh:mm:ss a");
    }
}
