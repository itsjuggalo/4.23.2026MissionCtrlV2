package Q4;

import P4.r;
import T4.b;
import V4.e;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e f6726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f6727b;

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
        e eVar = f6726a;
        return eVar == null ? c(callable) : b(eVar, callable);
    }

    public static r e(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        e eVar = f6727b;
        return eVar == null ? rVar : (r) a(eVar, rVar);
    }
}
