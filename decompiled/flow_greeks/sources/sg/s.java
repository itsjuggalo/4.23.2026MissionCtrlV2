package sg;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import ng.i2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f20429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i2 f20430b;

    static {
        s sVar = new s();
        f20429a = sVar;
        e0.f("kotlinx.coroutines.fast.service.loader", true);
        f20430b = sVar.a();
    }

    public final i2 a() {
        Object next;
        i2 i2VarE;
        try {
            List listM = jg.t.M(jg.q.g(ServiceLoader.load(r.class, r.class.getClassLoader()).iterator()));
            Iterator it = listM.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((r) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((r) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            r rVar = (r) next;
            if (rVar != null && (i2VarE = t.e(rVar, listM)) != null) {
                return i2VarE;
            }
            return t.b(null, null, 3, null);
        } catch (Throwable th) {
            return t.b(th, null, 2, null);
        }
    }
}
