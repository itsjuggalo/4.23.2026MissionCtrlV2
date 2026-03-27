package z3;

import java.sql.Timestamp;
import java.util.Date;
import t3.s;

/* JADX INFO: renamed from: z3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1469d extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1468c f11762b = new C1468c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f11763a;

    public C1469d(s sVar) {
        this.f11763a = sVar;
    }

    @Override // t3.s
    public final Object b(B3.a aVar) {
        Date date = (Date) this.f11763a.b(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) {
        this.f11763a.c(bVar, (Timestamp) obj);
    }
}
