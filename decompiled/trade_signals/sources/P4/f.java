package P4;

import b5.C1204b;
import b5.C1205c;
import b5.C1206d;
import b5.C1208f;
import b5.C1209g;
import b5.C1210h;
import b5.C1211i;
import b5.C1212j;
import b5.C1213k;
import b5.C1214l;
import b5.C1215m;
import b5.C1218p;
import b5.C1219q;
import b5.C1220r;
import b5.C1221s;
import b5.C1222t;
import b5.C1224v;
import b5.EnumC1217o;
import b5.w;
import b5.x;
import b5.z;
import h5.C1886c;
import h5.C1887d;
import java.util.Comparator;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements x7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6438a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int b() {
        return f6438a;
    }

    public static f e(h hVar, a aVar) {
        X4.b.d(hVar, "source is null");
        X4.b.d(aVar, "mode is null");
        return AbstractC2283a.k(new C1205c(hVar, aVar));
    }

    public static f i() {
        return AbstractC2283a.k(C1209g.f13019b);
    }

    public static f r(Object... objArr) {
        X4.b.d(objArr, "items is null");
        return objArr.length == 0 ? i() : objArr.length == 1 ? t(objArr[0]) : AbstractC2283a.k(new C1214l(objArr));
    }

    public static f s(Iterable iterable) {
        X4.b.d(iterable, "source is null");
        return AbstractC2283a.k(new C1215m(iterable));
    }

    public static f t(Object obj) {
        X4.b.d(obj, "item is null");
        return AbstractC2283a.k(new C1218p(obj));
    }

    public static f v(x7.a aVar, x7.a aVar2, x7.a aVar3) {
        X4.b.d(aVar, "source1 is null");
        X4.b.d(aVar2, "source2 is null");
        X4.b.d(aVar3, "source3 is null");
        return r(aVar, aVar2, aVar3).l(X4.a.d(), false, 3);
    }

    public final f A() {
        return AbstractC2283a.k(new C1222t(this));
    }

    public final f B() {
        return AbstractC2283a.k(new C1224v(this));
    }

    public final U4.a C() {
        return D(b());
    }

    public final U4.a D(int i8) {
        X4.b.e(i8, "bufferSize");
        return w.M(this, i8);
    }

    public final f E(Comparator comparator) {
        X4.b.d(comparator, "sortFunction");
        return J().l().u(X4.a.f(comparator)).n(X4.a.d());
    }

    public final S4.b F(V4.d dVar) {
        return G(dVar, X4.a.f9380f, X4.a.f9377c, EnumC1217o.INSTANCE);
    }

    public final S4.b G(V4.d dVar, V4.d dVar2, V4.a aVar, V4.d dVar3) {
        X4.b.d(dVar, "onNext is null");
        X4.b.d(dVar2, "onError is null");
        X4.b.d(aVar, "onComplete is null");
        X4.b.d(dVar3, "onSubscribe is null");
        C1886c c1886c = new C1886c(dVar, dVar2, aVar, dVar3);
        H(c1886c);
        return c1886c;
    }

    public final void H(i iVar) {
        X4.b.d(iVar, "s is null");
        try {
            x7.b bVarX = AbstractC2283a.x(this, iVar);
            X4.b.d(bVarX, "Plugin returned null Subscriber");
            I(bVarX);
        } catch (NullPointerException e8) {
            throw e8;
        } catch (Throwable th) {
            T4.b.b(th);
            AbstractC2283a.q(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void I(x7.b bVar);

    public final s J() {
        return AbstractC2283a.n(new z(this));
    }

    @Override // x7.a
    public final void a(x7.b bVar) {
        if (bVar instanceof i) {
            H((i) bVar);
        } else {
            X4.b.d(bVar, "s is null");
            H(new C1887d(bVar));
        }
    }

    public final f c(V4.e eVar) {
        return d(eVar, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f d(V4.e eVar, int i8) {
        X4.b.d(eVar, "mapper is null");
        X4.b.e(i8, "prefetch");
        if (!(this instanceof Y4.h)) {
            return AbstractC2283a.k(new C1204b(this, eVar, i8, j5.f.IMMEDIATE));
        }
        Object objCall = ((Y4.h) this).call();
        return objCall == null ? i() : x.a(objCall, eVar);
    }

    public final f f(V4.d dVar, V4.d dVar2, V4.a aVar, V4.a aVar2) {
        X4.b.d(dVar, "onNext is null");
        X4.b.d(dVar2, "onError is null");
        X4.b.d(aVar, "onComplete is null");
        X4.b.d(aVar2, "onAfterTerminate is null");
        return AbstractC2283a.k(new C1206d(this, dVar, dVar2, aVar, aVar2));
    }

    public final f g(V4.d dVar) {
        V4.d dVarB = X4.a.b();
        V4.a aVar = X4.a.f9377c;
        return f(dVar, dVarB, aVar, aVar);
    }

    public final j h(long j8) {
        if (j8 >= 0) {
            return AbstractC2283a.l(new C1208f(this, j8));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j8);
    }

    public final f j(V4.g gVar) {
        X4.b.d(gVar, "predicate is null");
        return AbstractC2283a.k(new C1210h(this, gVar));
    }

    public final j k() {
        return h(0L);
    }

    public final f l(V4.e eVar, boolean z7, int i8) {
        return m(eVar, z7, i8, b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f m(V4.e eVar, boolean z7, int i8, int i9) {
        X4.b.d(eVar, "mapper is null");
        X4.b.e(i8, "maxConcurrency");
        X4.b.e(i9, "bufferSize");
        if (!(this instanceof Y4.h)) {
            return AbstractC2283a.k(new C1211i(this, eVar, z7, i8, i9));
        }
        Object objCall = ((Y4.h) this).call();
        return objCall == null ? i() : x.a(objCall, eVar);
    }

    public final f n(V4.e eVar) {
        return o(eVar, b());
    }

    public final f o(V4.e eVar, int i8) {
        X4.b.d(eVar, "mapper is null");
        X4.b.e(i8, "bufferSize");
        return AbstractC2283a.k(new C1213k(this, eVar, i8));
    }

    public final f p(V4.e eVar) {
        return q(eVar, false, Integer.MAX_VALUE);
    }

    public final f q(V4.e eVar, boolean z7, int i8) {
        X4.b.d(eVar, "mapper is null");
        X4.b.e(i8, "maxConcurrency");
        return AbstractC2283a.k(new C1212j(this, eVar, z7, i8));
    }

    public final f u(V4.e eVar) {
        X4.b.d(eVar, "mapper is null");
        return AbstractC2283a.k(new C1219q(this, eVar));
    }

    public final f w(r rVar) {
        return x(rVar, false, b());
    }

    public final f x(r rVar, boolean z7, int i8) {
        X4.b.d(rVar, "scheduler is null");
        X4.b.e(i8, "bufferSize");
        return AbstractC2283a.k(new C1220r(this, rVar, z7, i8));
    }

    public final f y() {
        return z(b(), false, true);
    }

    public final f z(int i8, boolean z7, boolean z8) {
        X4.b.e(i8, "bufferSize");
        return AbstractC2283a.k(new C1221s(this, i8, z8, z7, X4.a.f9377c));
    }
}
