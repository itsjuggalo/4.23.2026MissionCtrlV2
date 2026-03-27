package K2;

import K2.r;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 extends r.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f1299a = Logger.getLogger(q0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f1300b = new ThreadLocal();

    @Override // K2.r.c
    public r a() {
        r rVar = (r) f1300b.get();
        return rVar == null ? r.f1302c : rVar;
    }

    @Override // K2.r.c
    public void b(r rVar, r rVar2) {
        if (a() != rVar) {
            f1299a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (rVar2 != r.f1302c) {
            f1300b.set(rVar2);
        } else {
            f1300b.set(null);
        }
    }

    @Override // K2.r.c
    public r c(r rVar) {
        r rVarA = a();
        f1300b.set(rVar);
        return rVarA;
    }
}
