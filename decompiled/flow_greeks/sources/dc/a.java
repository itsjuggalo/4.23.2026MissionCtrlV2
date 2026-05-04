package dc;

import cc.r;
import gc.b;
import ic.e;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e f7986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f7987b;

    public static Object a(e eVar, Object obj) {
        try {
            return eVar.apply(obj);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    public static r b(e eVar, Callable callable) {
        r rVar = (r) a(eVar, callable);
        if (rVar != null) {
            return rVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    public static r c(Callable callable) {
        try {
            r rVar = (r) callable.call();
            if (rVar != null) {
                return rVar;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    public static r d(Callable callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        e eVar = f7986a;
        return eVar == null ? c(callable) : b(eVar, callable);
    }

    public static r e(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        e eVar = f7987b;
        return eVar == null ? rVar : (r) a(eVar, rVar);
    }
}
