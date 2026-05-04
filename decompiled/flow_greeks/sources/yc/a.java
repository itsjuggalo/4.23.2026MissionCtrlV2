package yc;

import cc.f;
import cc.j;
import cc.l;
import cc.o;
import cc.q;
import cc.r;
import cc.s;
import cc.t;
import gc.c;
import ic.b;
import ic.d;
import ic.e;
import java.util.concurrent.Callable;
import xc.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f25340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f25341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile e f25342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile e f25343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile e f25344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile e f25345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile e f25346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile e f25347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile e f25348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile e f25349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile e f25350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile e f25351l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile e f25352m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile e f25353n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile b f25354o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile b f25355p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile b f25356q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile b f25357r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile b f25358s;

    public static Object a(b bVar, Object obj, Object obj2) {
        try {
            return bVar.apply(obj, obj2);
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
        return (r) kc.b.d(b(eVar, callable), "Scheduler Callable result can't be null");
    }

    public static r d(Callable callable) {
        try {
            return (r) kc.b.d(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw g.d(th);
        }
    }

    public static r e(Callable callable) {
        kc.b.d(callable, "Scheduler Callable can't be null");
        e eVar = f25342c;
        return eVar == null ? d(callable) : c(eVar, callable);
    }

    public static r f(Callable callable) {
        kc.b.d(callable, "Scheduler Callable can't be null");
        e eVar = f25344e;
        return eVar == null ? d(callable) : c(eVar, callable);
    }

    public static r g(Callable callable) {
        kc.b.d(callable, "Scheduler Callable can't be null");
        e eVar = f25345f;
        return eVar == null ? d(callable) : c(eVar, callable);
    }

    public static r h(Callable callable) {
        kc.b.d(callable, "Scheduler Callable can't be null");
        e eVar = f25343d;
        return eVar == null ? d(callable) : c(eVar, callable);
    }

    public static boolean i(Throwable th) {
        return (th instanceof gc.d) || (th instanceof c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof gc.a);
    }

    public static cc.b j(cc.b bVar) {
        e eVar = f25353n;
        return eVar != null ? (cc.b) b(eVar, bVar) : bVar;
    }

    public static f k(f fVar) {
        e eVar = f25348i;
        return eVar != null ? (f) b(eVar, fVar) : fVar;
    }

    public static j l(j jVar) {
        e eVar = f25351l;
        return eVar != null ? (j) b(eVar, jVar) : jVar;
    }

    public static o m(o oVar) {
        e eVar = f25350k;
        return eVar != null ? (o) b(eVar, oVar) : oVar;
    }

    public static s n(s sVar) {
        e eVar = f25352m;
        return eVar != null ? (s) b(eVar, sVar) : sVar;
    }

    public static hc.a o(hc.a aVar) {
        e eVar = f25349j;
        return eVar != null ? (hc.a) b(eVar, aVar) : aVar;
    }

    public static r p(r rVar) {
        e eVar = f25346g;
        return eVar == null ? rVar : (r) b(eVar, rVar);
    }

    public static void q(Throwable th) {
        d dVar = f25340a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th)) {
            th = new gc.f(th);
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
        e eVar = f25347h;
        return eVar == null ? rVar : (r) b(eVar, rVar);
    }

    public static Runnable s(Runnable runnable) {
        kc.b.d(runnable, "run is null");
        e eVar = f25341b;
        return eVar == null ? runnable : (Runnable) b(eVar, runnable);
    }

    public static cc.c t(cc.b bVar, cc.c cVar) {
        b bVar2 = f25358s;
        return bVar2 != null ? (cc.c) a(bVar2, bVar, cVar) : cVar;
    }

    public static l u(j jVar, l lVar) {
        b bVar = f25355p;
        return bVar != null ? (l) a(bVar, jVar, lVar) : lVar;
    }

    public static q v(o oVar, q qVar) {
        b bVar = f25356q;
        return bVar != null ? (q) a(bVar, oVar, qVar) : qVar;
    }

    public static t w(s sVar, t tVar) {
        b bVar = f25357r;
        return bVar != null ? (t) a(bVar, sVar, tVar) : tVar;
    }

    public static kh.b x(f fVar, kh.b bVar) {
        b bVar2 = f25354o;
        return bVar2 != null ? (kh.b) a(bVar2, fVar, bVar) : bVar;
    }

    public static void y(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
