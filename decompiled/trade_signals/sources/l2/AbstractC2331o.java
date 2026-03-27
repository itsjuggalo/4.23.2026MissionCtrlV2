package l2;

import com.google.android.gms.common.internal.AbstractC1294n;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: l2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2331o {
    public static Object a(AbstractC2328l abstractC2328l) {
        AbstractC1294n.h();
        AbstractC1294n.f();
        AbstractC1294n.k(abstractC2328l, "Task must not be null");
        if (abstractC2328l.n()) {
            return k(abstractC2328l);
        }
        s sVar = new s(null);
        l(abstractC2328l, sVar);
        sVar.b();
        return k(abstractC2328l);
    }

    public static Object b(AbstractC2328l abstractC2328l, long j8, TimeUnit timeUnit) throws TimeoutException {
        AbstractC1294n.h();
        AbstractC1294n.f();
        AbstractC1294n.k(abstractC2328l, "Task must not be null");
        AbstractC1294n.k(timeUnit, "TimeUnit must not be null");
        if (abstractC2328l.n()) {
            return k(abstractC2328l);
        }
        s sVar = new s(null);
        l(abstractC2328l, sVar);
        if (sVar.c(j8, timeUnit)) {
            return k(abstractC2328l);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static AbstractC2328l c(Executor executor, Callable callable) {
        AbstractC1294n.k(executor, "Executor must not be null");
        AbstractC1294n.k(callable, "Callback must not be null");
        P p8 = new P();
        executor.execute(new Q(p8, callable));
        return p8;
    }

    public static AbstractC2328l d(Exception exc) {
        P p8 = new P();
        p8.r(exc);
        return p8;
    }

    public static AbstractC2328l e(Object obj) {
        P p8 = new P();
        p8.s(obj);
        return p8;
    }

    public static AbstractC2328l f(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return e(null);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((AbstractC2328l) it.next()) == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        P p8 = new P();
        u uVar = new u(collection.size(), p8);
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            l((AbstractC2328l) it2.next(), uVar);
        }
        return p8;
    }

    public static AbstractC2328l g(AbstractC2328l... abstractC2328lArr) {
        return (abstractC2328lArr == null || abstractC2328lArr.length == 0) ? e(null) : f(Arrays.asList(abstractC2328lArr));
    }

    public static AbstractC2328l h(Collection collection) {
        return i(AbstractC2330n.f20575a, collection);
    }

    public static AbstractC2328l i(Executor executor, Collection collection) {
        return (collection == null || collection.isEmpty()) ? e(Collections.emptyList()) : f(collection).i(executor, new C2333q(collection));
    }

    public static AbstractC2328l j(AbstractC2328l... abstractC2328lArr) {
        return (abstractC2328lArr == null || abstractC2328lArr.length == 0) ? e(Collections.emptyList()) : h(Arrays.asList(abstractC2328lArr));
    }

    public static Object k(AbstractC2328l abstractC2328l) throws ExecutionException {
        if (abstractC2328l.o()) {
            return abstractC2328l.k();
        }
        if (abstractC2328l.m()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(abstractC2328l.j());
    }

    public static void l(AbstractC2328l abstractC2328l, t tVar) {
        Executor executor = AbstractC2330n.f20576b;
        abstractC2328l.f(executor, tVar);
        abstractC2328l.d(executor, tVar);
        abstractC2328l.a(executor, tVar);
    }
}
