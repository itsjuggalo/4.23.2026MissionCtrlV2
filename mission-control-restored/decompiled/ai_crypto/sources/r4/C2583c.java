package r4;

import java.sql.Timestamp;
import java.util.Date;
import l4.C2172e;
import l4.w;
import l4.x;
import s4.C2645a;
import t4.C2657a;

/* JADX INFO: renamed from: r4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2583c extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f22489b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f22490a;

    /* JADX INFO: renamed from: r4.c$a */
    public class a implements x {
        @Override // l4.x
        public w create(C2172e c2172e, C2645a c2645a) {
            a aVar = null;
            if (c2645a.c() == Timestamp.class) {
                return new C2583c(c2172e.k(Date.class), aVar);
            }
            return null;
        }
    }

    public /* synthetic */ C2583c(w wVar, a aVar) {
        this(wVar);
    }

    @Override // l4.w
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Timestamp c(C2657a c2657a) {
        Date date = (Date) this.f22490a.c(c2657a);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // l4.w
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(t4.c cVar, Timestamp timestamp) {
        this.f22490a.e(cVar, timestamp);
    }

    public C2583c(w wVar) {
        this.f22490a = wVar;
    }
}
