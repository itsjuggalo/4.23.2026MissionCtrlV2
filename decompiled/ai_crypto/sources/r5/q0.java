package r5;

import java.util.logging.Level;
import java.util.logging.Logger;
import r5.r;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends r.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f22789a = Logger.getLogger(q0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f22790b = new ThreadLocal();

    @Override // r5.r.c
    public r a() {
        r rVar = (r) f22790b.get();
        return rVar == null ? r.f22792c : rVar;
    }

    @Override // r5.r.c
    public void b(r rVar, r rVar2) {
        if (a() != rVar) {
            f22789a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (rVar2 != r.f22792c) {
            f22790b.set(rVar2);
        } else {
            f22790b.set(null);
        }
    }

    @Override // r5.r.c
    public r c(r rVar) {
        r rVarA = a();
        f22790b.set(rVar);
        return rVarA;
    }
}
