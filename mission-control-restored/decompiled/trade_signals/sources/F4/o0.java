package F4;

import F4.r;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class o0 extends r.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f1879a = Logger.getLogger(o0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f1880b = new ThreadLocal();

    @Override // F4.r.c
    public r a() {
        r rVar = (r) f1880b.get();
        return rVar == null ? r.f1894c : rVar;
    }

    @Override // F4.r.c
    public void b(r rVar, r rVar2) {
        ThreadLocal threadLocal;
        if (a() != rVar) {
            f1879a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (rVar2 != r.f1894c) {
            threadLocal = f1880b;
        } else {
            threadLocal = f1880b;
            rVar2 = null;
        }
        threadLocal.set(rVar2);
    }

    @Override // F4.r.c
    public r c(r rVar) {
        r rVarA = a();
        f1880b.set(rVar);
        return rVarA;
    }
}
