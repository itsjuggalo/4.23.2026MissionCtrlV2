package rb;

import java.util.logging.Level;
import java.util.logging.Logger;
import rb.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p1 extends r.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f19679a = Logger.getLogger(p1.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f19680b = new ThreadLocal();

    @Override // rb.r.c
    public r a() {
        r rVar = (r) f19680b.get();
        return rVar == null ? r.f19688c : rVar;
    }

    @Override // rb.r.c
    public void b(r rVar, r rVar2) {
        if (a() != rVar) {
            f19679a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (rVar2 != r.f19688c) {
            f19680b.set(rVar2);
        } else {
            f19680b.set(null);
        }
    }

    @Override // rb.r.c
    public r c(r rVar) {
        r rVarA = a();
        f19680b.set(rVar);
        return rVarA;
    }
}
