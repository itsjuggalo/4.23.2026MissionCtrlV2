package k5;

import P4.f;
import P4.j;
import P4.l;
import P4.o;
import P4.q;
import P4.r;
import P4.s;
import P4.t;
import T4.c;
import V4.b;
import V4.d;
import V4.e;
import j5.g;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: k5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2283a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f20393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f20394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile e f20395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile e f20396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile e f20397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile e f20398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile e f20399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile e f20400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile e f20401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile e f20402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile e f20403k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile e f20404l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile e f20405m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile e f20406n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile b f20407o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile b f20408p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile b f20409q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile b f20410r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile b f20411s;

    public static Object a(b bVar, Object obj, Object obj2) {
        try {
            return bVar.a(obj, obj2);
        } catch (Throwable th) {
            throw g.d(th);
        }
    }

    public static Object b(e eVar, Object obj) {
        try {
            return eVar.apply(obj);
        } catch (Throwable th) {
            throw g.d(th);
        }
    }

    public static r c(e eVar, Callable callable) {
        return (r) X4.b.d(b(eVar, callable), "Scheduler Callable result can't be null");
    }

    public static r d(Callable callable) {
        try {
            return (r) X4.b.d(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw g.d(th);
        }
    }

    public static r e(Callable callable) {
        X4.b.d(callable, "Scheduler Callable can't be null");
        e eVar = f20395c;
        return eVar == null ? d(callable) : c(eVar, callable);
    }

    public static r f(Callable callable) {
        X4.b.d(callable, "Scheduler Callable can't be null");
        e eVar = f20397e;
        return eVar == null ? d(callable) : c(eVar, callable);
    }

    public static r g(Callable callable) {
        X4.b.d(callable, "Scheduler Callable can't be null");
        e eVar = f20398f;
        return eVar == null ? d(callable) : c(eVar, callable);
    }

    public static r h(Callable callable) {
        X4.b.d(callable, "Scheduler Callable can't be null");
        e eVar = f20396d;
        return eVar == null ? d(callable) : c(eVar, callable);
    }

    public static boolean i(Throwable th) {
        return (th instanceof T4.d) || (th instanceof c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof T4.a);
    }

    public static P4.b j(P4.b bVar) {
        e eVar = f20406n;
        return eVar != null ? (P4.b) b(eVar, bVar) : bVar;
    }

    public static f k(f fVar) {
        e eVar = f20401i;
        return eVar != null ? (f) b(eVar, fVar) : fVar;
    }

    public static j l(j jVar) {
        e eVar = f20404l;
        return eVar != null ? (j) b(eVar, jVar) : jVar;
    }

    public static o m(o oVar) {
        e eVar = f20403k;
        return eVar != null ? (o) b(eVar, oVar) : oVar;
    }

    public static s n(s sVar) {
        e eVar = f20405m;
        return eVar != null ? (s) b(eVar, sVar) : sVar;
    }

    public static U4.a o(U4.a aVar) {
        e eVar = f20402j;
        return eVar != null ? (U4.a) b(eVar, aVar) : aVar;
    }

    public static r p(r rVar) {
        e eVar = f20399g;
        return eVar == null ? rVar : (r) b(eVar, rVar);
    }

    public static void q(Throwable th) {
        d dVar = f20393a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th)) {
            th = new T4.f(th);
        }
        if (dVar != null) {
            try {
                dVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                y(th2);
            }
        }
        th.printStackTrace();
        y(th);
    }

    public static r r(r rVar) {
        e eVar = f20400h;
        return eVar == null ? rVar : (r) b(eVar, rVar);
    }

    public static Runnable s(Runnable runnable) {
        X4.b.d(runnable, "run is null");
        e eVar = f20394b;
        return eVar == null ? runnable : (Runnable) b(eVar, runnable);
    }

    public static P4.c t(P4.b bVar, P4.c cVar) {
        b bVar2 = f20411s;
        return bVar2 != null ? (P4.c) a(bVar2, bVar, cVar) : cVar;
    }

    public static l u(j jVar, l lVar) {
        b bVar = f20408p;
        return bVar != null ? (l) a(bVar, jVar, lVar) : lVar;
    }

    public static q v(o oVar, q qVar) {
        b bVar = f20409q;
        return bVar != null ? (q) a(bVar, oVar, qVar) : qVar;
    }

    public static t w(s sVar, t tVar) {
        b bVar = f20410r;
        return bVar != null ? (t) a(bVar, sVar, tVar) : tVar;
    }

    public static x7.b x(f fVar, x7.b bVar) {
        b bVar2 = f20407o;
        return bVar2 != null ? (x7.b) a(bVar2, fVar, bVar) : bVar;
    }

    public static void y(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
