package z3;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import t3.i;
import t3.s;
import t3.t;

/* JADX INFO: renamed from: z3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1466a extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0000a f11758b = new C0000a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f11759a;

    /* JADX INFO: renamed from: z3.a$a, reason: collision with other inner class name */
    public class C0000a implements t {
        @Override // t3.t
        public final s create(t3.e eVar, A3.a aVar) {
            if (aVar.f61a == Date.class) {
                return new C1466a(0);
            }
            return null;
        }
    }

    public /* synthetic */ C1466a(int i) {
        this();
    }

    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        Date date;
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        String strZ = aVar.z();
        synchronized (this) {
            TimeZone timeZone = this.f11759a.getTimeZone();
            try {
                try {
                    date = new Date(this.f11759a.parse(strZ).getTime());
                } catch (ParseException e) {
                    throw new i("Failed parsing '" + strZ + "' as SQL Date; at path " + aVar.n(), e);
                }
            } finally {
                this.f11759a.setTimeZone(timeZone);
            }
        }
        return date;
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            bVar.m();
            return;
        }
        synchronized (this) {
            str = this.f11759a.format((java.util.Date) date);
        }
        bVar.v(str);
    }

    private C1466a() {
        this.f11759a = new SimpleDateFormat("MMM d, yyyy");
    }
}
