package cc;

import com.google.android.gms.common.api.a;
import java.util.Comparator;
import oc.v;
import oc.w;
import oc.x;
import oc.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements kh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3824a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int b() {
        return f3824a;
    }

    public static f e(h hVar, a aVar) {
        kc.b.d(hVar, "source is null");
        kc.b.d(aVar, "mode is null");
        return yc.a.k(new oc.c(hVar, aVar));
    }

    public static f i() {
        return yc.a.k(oc.g.f17769b);
    }

    public static f r(Object... objArr) {
        kc.b.d(objArr, "items is null");
        return objArr.length == 0 ? i() : objArr.length == 1 ? t(objArr[0]) : yc.a.k(new oc.l(objArr));
    }

    public static f s(Iterable iterable) {
        kc.b.d(iterable, "source is null");
        return yc.a.k(new oc.m(iterable));
    }

    public static f t(Object obj) {
        kc.b.d(obj, "item is null");
        return yc.a.k(new oc.p(obj));
    }

    public static f v(kh.a aVar, kh.a aVar2, kh.a aVar3) {
        kc.b.d(aVar, "source1 is null");
        kc.b.d(aVar2, "source2 is null");
        kc.b.d(aVar3, "source3 is null");
        return r(aVar, aVar2, aVar3).l(kc.a.d(), false, 3);
    }

    public final f A() {
        return yc.a.k(new oc.t(this));
    }

    public final f B() {
        return yc.a.k(new v(this));
    }

    public final hc.a C() {
        return D(b());
    }

    public final hc.a D(int i10) {
        kc.b.e(i10, "bufferSize");
        return w.M(this, i10);
    }

    public final f E(Comparator comparator) {
        kc.b.d(comparator, "sortFunction");
        return J().k().u(kc.a.f(comparator)).n(kc.a.d());
    }

    public final fc.b F(ic.d dVar) {
        return G(dVar, kc.a.f14809f, kc.a.f14806c, oc.o.INSTANCE);
    }

    public final fc.b G(ic.d dVar, ic.d dVar2, ic.a aVar, ic.d dVar3) {
        kc.b.d(dVar, "onNext is null");
        kc.b.d(dVar2, "onError is null");
        kc.b.d(aVar, "onComplete is null");
        kc.b.d(dVar3, "onSubscribe is null");
        vc.c cVar = new vc.c(dVar, dVar2, aVar, dVar3);
        H(cVar);
        return cVar;
    }

    public final void H(i iVar) {
        kc.b.d(iVar, "s is null");
        try {
            kh.b bVarX = yc.a.x(this, iVar);
            kc.b.d(bVarX, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            I(bVarX);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            gc.b.b(th);
            yc.a.q(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void I(kh.b bVar);

    public final s J() {
        return yc.a.n(new z(this));
    }

    @Override // kh.a
    public final void a(kh.b bVar) {
        if (bVar instanceof i) {
            H((i) bVar);
        } else {
            kc.b.d(bVar, "s is null");
            H(new vc.d(bVar));
        }
    }

    public final f c(ic.e eVar) {
        return d(eVar, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f d(ic.e eVar, int i10) {
        kc.b.d(eVar, "mapper is null");
        kc.b.e(i10, "prefetch");
        if (!(this instanceof lc.g)) {
            return yc.a.k(new oc.b(this, eVar, i10, xc.f.IMMEDIATE));
        }
        Object objCall = ((lc.g) this).call();
        return objCall == null ? i() : x.a(objCall, eVar);
    }

    public final f f(ic.d dVar, ic.d dVar2, ic.a aVar, ic.a aVar2) {
        kc.b.d(dVar, "onNext is null");
        kc.b.d(dVar2, "onError is null");
        kc.b.d(aVar, "onComplete is null");
        kc.b.d(aVar2, "onAfterTerminate is null");
        return yc.a.k(new oc.d(this, dVar, dVar2, aVar, aVar2));
    }

    public final f g(ic.d dVar) {
        ic.d dVarB = kc.a.b();
        ic.a aVar = kc.a.f14806c;
        return f(dVar, dVarB, aVar, aVar);
    }

    public final j h(long j10) {
        if (j10 >= 0) {
            return yc.a.l(new oc.f(this, j10));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    public final f j(ic.g gVar) {
        kc.b.d(gVar, "predicate is null");
        return yc.a.k(new oc.h(this, gVar));
    }

    public final j k() {
        return h(0L);
    }

    public final f l(ic.e eVar, boolean z10, int i10) {
        return m(eVar, z10, i10, b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f m(ic.e eVar, boolean z10, int i10, int i11) {
        kc.b.d(eVar, "mapper is null");
        kc.b.e(i10, "maxConcurrency");
        kc.b.e(i11, "bufferSize");
        if (!(this instanceof lc.g)) {
            return yc.a.k(new oc.i(this, eVar, z10, i10, i11));
        }
        Object objCall = ((lc.g) this).call();
        return objCall == null ? i() : x.a(objCall, eVar);
    }

    public final f n(ic.e eVar) {
        return o(eVar, b());
    }

    public final f o(ic.e eVar, int i10) {
        kc.b.d(eVar, "mapper is null");
        kc.b.e(i10, "bufferSize");
        return yc.a.k(new oc.k(this, eVar, i10));
    }

    public final f p(ic.e eVar) {
        return q(eVar, false, a.e.API_PRIORITY_OTHER);
    }

    public final f q(ic.e eVar, boolean z10, int i10) {
        kc.b.d(eVar, "mapper is null");
        kc.b.e(i10, "maxConcurrency");
        return yc.a.k(new oc.j(this, eVar, z10, i10));
    }

    public final f u(ic.e eVar) {
        kc.b.d(eVar, "mapper is null");
        return yc.a.k(new oc.q(this, eVar));
    }

    public final f w(r rVar) {
        return x(rVar, false, b());
    }

    public final f x(r rVar, boolean z10, int i10) {
        kc.b.d(rVar, "scheduler is null");
        kc.b.e(i10, "bufferSize");
        return yc.a.k(new oc.r(this, rVar, z10, i10));
    }

    public final f y() {
        return z(b(), false, true);
    }

    public final f z(int i10, boolean z10, boolean z11) {
        kc.b.e(i10, "capacity");
        return yc.a.k(new oc.s(this, i10, z11, z10, kc.a.f14806c));
    }
}
