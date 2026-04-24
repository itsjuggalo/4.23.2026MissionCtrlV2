package X4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final V4.e f9375a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f9376b = new e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final V4.a f9377c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final V4.d f9378d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final V4.d f9379e = new g();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final V4.d f9380f = new o();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final V4.f f9381g = new d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final V4.g f9382h = new p();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final V4.g f9383i = new h();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Callable f9384j = new n();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Comparator f9385k = new m();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final V4.d f9386l = new l();

    /* JADX INFO: renamed from: X4.a$a, reason: collision with other inner class name */
    public static final class C0151a implements V4.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V4.b f9387a;

        public C0151a(V4.b bVar) {
            this.f9387a = bVar;
        }

        @Override // V4.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 2) {
                return this.f9387a.a(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    public static final class d implements V4.f {
    }

    public static final class f implements V4.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f9388a;

        public f(Object obj) {
            this.f9388a = obj;
        }

        @Override // V4.g
        public boolean test(Object obj) {
            return X4.b.c(obj, this.f9388a);
        }
    }

    public static final class g implements V4.d {
        @Override // V4.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            AbstractC2283a.q(th);
        }
    }

    public static final class h implements V4.g {
        @Override // V4.g
        public boolean test(Object obj) {
            return false;
        }
    }

    public static final class j implements Callable, V4.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f9389a;

        public j(Object obj) {
            this.f9389a = obj;
        }

        @Override // V4.e
        public Object apply(Object obj) {
            return this.f9389a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.f9389a;
        }
    }

    public static final class k implements V4.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparator f9390a;

        public k(Comparator comparator) {
            this.f9390a = comparator;
        }

        @Override // V4.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List apply(List list) {
            Collections.sort(list, this.f9390a);
            return list;
        }
    }

    public static final class l implements V4.d {
        @Override // V4.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(x7.c cVar) {
            cVar.i(Long.MAX_VALUE);
        }
    }

    public static final class m implements Comparator {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class n implements Callable {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    public static final class o implements V4.d {
        @Override // V4.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            AbstractC2283a.q(new T4.d(th));
        }
    }

    public static final class p implements V4.g {
        @Override // V4.g
        public boolean test(Object obj) {
            return true;
        }
    }

    public static V4.g a() {
        return f9382h;
    }

    public static V4.d b() {
        return f9378d;
    }

    public static V4.g c(Object obj) {
        return new f(obj);
    }

    public static V4.e d() {
        return f9375a;
    }

    public static V4.e e(Object obj) {
        return new j(obj);
    }

    public static V4.e f(Comparator comparator) {
        return new k(comparator);
    }

    public static V4.e g(V4.b bVar) {
        X4.b.d(bVar, "f is null");
        return new C0151a(bVar);
    }

    public static final class b implements V4.a {
        public String toString() {
            return "EmptyAction";
        }

        @Override // V4.a
        public void run() {
        }
    }

    public static final class e implements Runnable {
        public String toString() {
            return "EmptyRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static final class c implements V4.d {
        public String toString() {
            return "EmptyConsumer";
        }

        @Override // V4.d
        public void accept(Object obj) {
        }
    }

    public static final class i implements V4.e {
        public String toString() {
            return "IdentityFunction";
        }

        @Override // V4.e
        public Object apply(Object obj) {
            return obj;
        }
    }
}
