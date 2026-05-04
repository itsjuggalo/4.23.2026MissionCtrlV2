package oc;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends oc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.e f17704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xc.f f17706e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17707a;

        static {
            int[] iArr = new int[xc.f.values().length];
            f17707a = iArr;
            try {
                iArr[xc.f.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17707a[xc.f.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: oc.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractC0306b extends AtomicInteger implements cc.i, f, kh.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.e f17709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f17711d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public kh.c f17712e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f17713f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public lc.i f17714g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile boolean f17715h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile boolean f17716i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public volatile boolean f17718k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f17719l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f17708a = new e(this);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final xc.c f17717j = new xc.c();

        public AbstractC0306b(ic.e eVar, int i10) {
            this.f17709b = eVar;
            this.f17710c = i10;
            this.f17711d = i10 - (i10 >> 2);
        }

        @Override // cc.i, kh.b
        public final void b(kh.c cVar) {
            if (wc.g.m(this.f17712e, cVar)) {
                this.f17712e = cVar;
                if (cVar instanceof lc.f) {
                    lc.f fVar = (lc.f) cVar;
                    int iH = fVar.h(7);
                    if (iH == 1) {
                        this.f17719l = iH;
                        this.f17714g = fVar;
                        this.f17715h = true;
                        g();
                        f();
                        return;
                    }
                    if (iH == 2) {
                        this.f17719l = iH;
                        this.f17714g = fVar;
                        g();
                        cVar.request(this.f17710c);
                        return;
                    }
                }
                this.f17714g = new tc.a(this.f17710c);
                g();
                cVar.request(this.f17710c);
            }
        }

        @Override // oc.b.f
        public final void c() {
            this.f17718k = false;
            f();
        }

        public abstract void f();

        public abstract void g();

        @Override // kh.b
        public final void onComplete() {
            this.f17715h = true;
            f();
        }

        @Override // kh.b
        public final void onNext(Object obj) {
            if (this.f17719l == 2 || this.f17714g.offer(obj)) {
                f();
            } else {
                this.f17712e.cancel();
                onError(new IllegalStateException("Queue full?!"));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends AbstractC0306b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final kh.b f17720m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f17721n;

        public c(kh.b bVar, ic.e eVar, int i10, boolean z10) {
            super(eVar, i10);
            this.f17720m = bVar;
            this.f17721n = z10;
        }

        @Override // oc.b.f
        public void a(Object obj) {
            this.f17720m.onNext(obj);
        }

        @Override // kh.c
        public void cancel() {
            if (this.f17716i) {
                return;
            }
            this.f17716i = true;
            this.f17708a.cancel();
            this.f17712e.cancel();
        }

        @Override // oc.b.f
        public void e(Throwable th) {
            if (!this.f17717j.a(th)) {
                yc.a.q(th);
                return;
            }
            if (!this.f17721n) {
                this.f17712e.cancel();
                this.f17715h = true;
            }
            this.f17718k = false;
            f();
        }

        @Override // oc.b.AbstractC0306b
        public void f() {
            Object objCall;
            if (getAndIncrement() == 0) {
                while (!this.f17716i) {
                    if (!this.f17718k) {
                        boolean z10 = this.f17715h;
                        if (z10 && !this.f17721n && ((Throwable) this.f17717j.get()) != null) {
                            this.f17720m.onError(this.f17717j.b());
                            return;
                        }
                        try {
                            Object objPoll = this.f17714g.poll();
                            boolean z11 = objPoll == null;
                            if (z10 && z11) {
                                Throwable thB = this.f17717j.b();
                                if (thB != null) {
                                    this.f17720m.onError(thB);
                                    return;
                                } else {
                                    this.f17720m.onComplete();
                                    return;
                                }
                            }
                            if (!z11) {
                                try {
                                    kh.a aVar = (kh.a) kc.b.d(this.f17709b.apply(objPoll), "The mapper returned a null Publisher");
                                    if (this.f17719l != 1) {
                                        int i10 = this.f17713f + 1;
                                        if (i10 == this.f17711d) {
                                            this.f17713f = 0;
                                            this.f17712e.request(i10);
                                        } else {
                                            this.f17713f = i10;
                                        }
                                    }
                                    if (aVar instanceof Callable) {
                                        try {
                                            objCall = ((Callable) aVar).call();
                                        } catch (Throwable th) {
                                            gc.b.b(th);
                                            this.f17717j.a(th);
                                            if (!this.f17721n) {
                                                this.f17712e.cancel();
                                                this.f17720m.onError(this.f17717j.b());
                                                return;
                                            }
                                            objCall = null;
                                        }
                                        if (objCall == null) {
                                            continue;
                                        } else if (this.f17708a.e()) {
                                            this.f17720m.onNext(objCall);
                                        } else {
                                            this.f17718k = true;
                                            this.f17708a.g(new g(objCall, this.f17708a));
                                        }
                                    } else {
                                        this.f17718k = true;
                                        aVar.a(this.f17708a);
                                    }
                                } catch (Throwable th2) {
                                    gc.b.b(th2);
                                    this.f17712e.cancel();
                                    this.f17717j.a(th2);
                                    this.f17720m.onError(this.f17717j.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            gc.b.b(th3);
                            this.f17712e.cancel();
                            this.f17717j.a(th3);
                            this.f17720m.onError(this.f17717j.b());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // oc.b.AbstractC0306b
        public void g() {
            this.f17720m.b(this);
        }

        @Override // kh.b
        public void onError(Throwable th) {
            if (!this.f17717j.a(th)) {
                yc.a.q(th);
            } else {
                this.f17715h = true;
                f();
            }
        }

        @Override // kh.c
        public void request(long j10) {
            this.f17708a.request(j10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends AbstractC0306b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final kh.b f17722m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final AtomicInteger f17723n;

        public d(kh.b bVar, ic.e eVar, int i10) {
            super(eVar, i10);
            this.f17722m = bVar;
            this.f17723n = new AtomicInteger();
        }

        @Override // oc.b.f
        public void a(Object obj) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f17722m.onNext(obj);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.f17722m.onError(this.f17717j.b());
            }
        }

        @Override // kh.c
        public void cancel() {
            if (this.f17716i) {
                return;
            }
            this.f17716i = true;
            this.f17708a.cancel();
            this.f17712e.cancel();
        }

        @Override // oc.b.f
        public void e(Throwable th) {
            if (!this.f17717j.a(th)) {
                yc.a.q(th);
                return;
            }
            this.f17712e.cancel();
            if (getAndIncrement() == 0) {
                this.f17722m.onError(this.f17717j.b());
            }
        }

        @Override // oc.b.AbstractC0306b
        public void f() {
            if (this.f17723n.getAndIncrement() == 0) {
                while (!this.f17716i) {
                    if (!this.f17718k) {
                        boolean z10 = this.f17715h;
                        try {
                            Object objPoll = this.f17714g.poll();
                            boolean z11 = objPoll == null;
                            if (z10 && z11) {
                                this.f17722m.onComplete();
                                return;
                            }
                            if (!z11) {
                                try {
                                    kh.a aVar = (kh.a) kc.b.d(this.f17709b.apply(objPoll), "The mapper returned a null Publisher");
                                    if (this.f17719l != 1) {
                                        int i10 = this.f17713f + 1;
                                        if (i10 == this.f17711d) {
                                            this.f17713f = 0;
                                            this.f17712e.request(i10);
                                        } else {
                                            this.f17713f = i10;
                                        }
                                    }
                                    if (aVar instanceof Callable) {
                                        try {
                                            Object objCall = ((Callable) aVar).call();
                                            if (objCall == null) {
                                                continue;
                                            } else if (!this.f17708a.e()) {
                                                this.f17718k = true;
                                                this.f17708a.g(new g(objCall, this.f17708a));
                                            } else if (get() == 0 && compareAndSet(0, 1)) {
                                                this.f17722m.onNext(objCall);
                                                if (!compareAndSet(1, 0)) {
                                                    this.f17722m.onError(this.f17717j.b());
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            gc.b.b(th);
                                            this.f17712e.cancel();
                                            this.f17717j.a(th);
                                            this.f17722m.onError(this.f17717j.b());
                                            return;
                                        }
                                    } else {
                                        this.f17718k = true;
                                        aVar.a(this.f17708a);
                                    }
                                } catch (Throwable th2) {
                                    gc.b.b(th2);
                                    this.f17712e.cancel();
                                    this.f17717j.a(th2);
                                    this.f17722m.onError(this.f17717j.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            gc.b.b(th3);
                            this.f17712e.cancel();
                            this.f17717j.a(th3);
                            this.f17722m.onError(this.f17717j.b());
                            return;
                        }
                    }
                    if (this.f17723n.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // oc.b.AbstractC0306b
        public void g() {
            this.f17722m.b(this);
        }

        @Override // kh.b
        public void onError(Throwable th) {
            if (!this.f17717j.a(th)) {
                yc.a.q(th);
                return;
            }
            this.f17708a.cancel();
            if (getAndIncrement() == 0) {
                this.f17722m.onError(this.f17717j.b());
            }
        }

        @Override // kh.c
        public void request(long j10) {
            this.f17708a.request(j10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends wc.f implements cc.i {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final f f17724i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f17725j;

        public e(f fVar) {
            super(false);
            this.f17724i = fVar;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            g(cVar);
        }

        @Override // kh.b
        public void onComplete() {
            long j10 = this.f17725j;
            if (j10 != 0) {
                this.f17725j = 0L;
                f(j10);
            }
            this.f17724i.c();
        }

        @Override // kh.b
        public void onError(Throwable th) {
            long j10 = this.f17725j;
            if (j10 != 0) {
                this.f17725j = 0L;
                f(j10);
            }
            this.f17724i.e(th);
        }

        @Override // kh.b
        public void onNext(Object obj) {
            this.f17725j++;
            this.f17724i.a(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface f {
        void a(Object obj);

        void c();

        void e(Throwable th);
    }

    public b(cc.f fVar, ic.e eVar, int i10, xc.f fVar2) {
        super(fVar);
        this.f17704c = eVar;
        this.f17705d = i10;
        this.f17706e = fVar2;
    }

    public static kh.b K(kh.b bVar, ic.e eVar, int i10, xc.f fVar) {
        int i11 = a.f17707a[fVar.ordinal()];
        return i11 != 1 ? i11 != 2 ? new d(bVar, eVar, i10) : new c(bVar, eVar, i10, true) : new c(bVar, eVar, i10, false);
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        if (x.b(this.f17703b, bVar, this.f17704c)) {
            return;
        }
        this.f17703b.a(K(bVar, this.f17704c, this.f17705d, this.f17706e));
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends AtomicBoolean implements kh.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kh.b f17726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f17727b;

        public g(Object obj, kh.b bVar) {
            this.f17727b = obj;
            this.f17726a = bVar;
        }

        @Override // kh.c
        public void request(long j10) {
            if (j10 <= 0 || !compareAndSet(false, true)) {
                return;
            }
            kh.b bVar = this.f17726a;
            bVar.onNext(this.f17727b);
            bVar.onComplete();
        }

        @Override // kh.c
        public void cancel() {
        }
    }
}
