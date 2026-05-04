package kc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ic.e f14804a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f14805b = new e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ic.a f14806c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ic.d f14807d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ic.d f14808e = new g();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ic.d f14809f = new o();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ic.f f14810g = new d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ic.g f14811h = new p();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ic.g f14812i = new h();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Callable f14813j = new n();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Comparator f14814k = new m();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ic.d f14815l = new l();

    /* JADX INFO: renamed from: kc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0256a implements ic.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ic.b f14816a;

        public C0256a(ic.b bVar) {
            this.f14816a = bVar;
        }

        @Override // ic.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 2) {
                return this.f14816a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements ic.f {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f implements ic.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f14817a;

        public f(Object obj) {
            this.f14817a = obj;
        }

        @Override // ic.g
        public boolean test(Object obj) {
            return kc.b.c(obj, this.f14817a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g implements ic.d {
        @Override // ic.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            yc.a.q(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h implements ic.g {
        @Override // ic.g
        public boolean test(Object obj) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class j implements Callable, ic.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f14818a;

        public j(Object obj) {
            this.f14818a = obj;
        }

        @Override // ic.e
        public Object apply(Object obj) {
            return this.f14818a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.f14818a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class k implements ic.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparator f14819a;

        public k(Comparator comparator) {
            this.f14819a = comparator;
        }

        @Override // ic.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List apply(List list) {
            Collections.sort(list, this.f14819a);
            return list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class l implements ic.d {
        @Override // ic.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(kh.c cVar) {
            cVar.request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class m implements Comparator {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class n implements Callable {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class o implements ic.d {
        @Override // ic.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            yc.a.q(new gc.d(th));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class p implements ic.g {
        @Override // ic.g
        public boolean test(Object obj) {
            return true;
        }
    }

    public static ic.g a() {
        return f14811h;
    }

    public static ic.d b() {
        return f14807d;
    }

    public static ic.g c(Object obj) {
        return new f(obj);
    }

    public static ic.e d() {
        return f14804a;
    }

    public static ic.e e(Object obj) {
        return new j(obj);
    }

    public static ic.e f(Comparator comparator) {
        return new k(comparator);
    }

    public static ic.e g(ic.b bVar) {
        kc.b.d(bVar, "f is null");
        return new C0256a(bVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements ic.a {
        public String toString() {
            return "EmptyAction";
        }

        @Override // ic.a
        public void run() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e implements Runnable {
        public String toString() {
            return "EmptyRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements ic.d {
        public String toString() {
            return "EmptyConsumer";
        }

        @Override // ic.d
        public void accept(Object obj) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class i implements ic.e {
        public String toString() {
            return "IdentityFunction";
        }

        @Override // ic.e
        public Object apply(Object obj) {
            return obj;
        }
    }
}
