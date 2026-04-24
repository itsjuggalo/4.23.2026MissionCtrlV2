package w2;

import java.sql.Timestamp;
import java.util.Date;
import q2.e;
import q2.w;
import q2.x;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: renamed from: w2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1907c extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f15575b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f15576a;

    /* JADX INFO: renamed from: w2.c$a */
    public class a implements x {
        @Override // q2.x
        public w create(e eVar, C1925a c1925a) {
            a aVar = null;
            if (c1925a.c() == Timestamp.class) {
                return new C1907c(eVar.k(Date.class), aVar);
            }
            return null;
        }
    }

    public /* synthetic */ C1907c(w wVar, a aVar) {
        this(wVar);
    }

    @Override // q2.w
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Timestamp c(C1946a c1946a) {
        Date date = (Date) this.f15576a.c(c1946a);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // q2.w
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(y2.c cVar, Timestamp timestamp) {
        this.f15576a.e(cVar, timestamp);
    }

    public C1907c(w wVar) {
        this.f15576a = wVar;
    }
}
