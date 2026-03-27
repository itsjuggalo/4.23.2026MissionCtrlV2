package m5;

import P4.q;
import com.amazon.a.a.l.d;
import j5.C2224a;
import j5.g;
import j5.i;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import k5.AbstractC2283a;

/* JADX INFO: renamed from: m5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2379a extends AbstractC2380b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f21459h = new Object[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0356a[] f21460i = new C0356a[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0356a[] f21461j = new C0356a[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f21462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f21463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReadWriteLock f21464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lock f21465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lock f21466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f21467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f21468g;

    /* JADX INFO: renamed from: m5.a$a, reason: collision with other inner class name */
    public static final class C0356a implements S4.b, C2224a.InterfaceC0329a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f21469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2379a f21470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f21471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f21472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C2224a f21473e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f21474f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile boolean f21475g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f21476h;

        public C0356a(q qVar, C2379a c2379a) {
            this.f21469a = qVar;
            this.f21470b = c2379a;
        }

        public void a() {
            if (this.f21475g) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.f21475g) {
                        return;
                    }
                    if (this.f21471c) {
                        return;
                    }
                    C2379a c2379a = this.f21470b;
                    Lock lock = c2379a.f21465d;
                    lock.lock();
                    this.f21476h = c2379a.f21468g;
                    Object obj = c2379a.f21462a.get();
                    lock.unlock();
                    this.f21472d = obj != null;
                    this.f21471c = true;
                    if (obj == null || test(obj)) {
                        return;
                    }
                    b();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b() {
            C2224a c2224a;
            while (!this.f21475g) {
                synchronized (this) {
                    try {
                        c2224a = this.f21473e;
                        if (c2224a == null) {
                            this.f21472d = false;
                            return;
                        }
                        this.f21473e = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                c2224a.b(this);
            }
        }

        public void c(Object obj, long j8) {
            if (this.f21475g) {
                return;
            }
            if (!this.f21474f) {
                synchronized (this) {
                    try {
                        if (this.f21475g) {
                            return;
                        }
                        if (this.f21476h == j8) {
                            return;
                        }
                        if (this.f21472d) {
                            C2224a c2224a = this.f21473e;
                            if (c2224a == null) {
                                c2224a = new C2224a(4);
                                this.f21473e = c2224a;
                            }
                            c2224a.a(obj);
                            return;
                        }
                        this.f21471c = true;
                        this.f21474f = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            test(obj);
        }

        @Override // S4.b
        public void dispose() {
            if (this.f21475g) {
                return;
            }
            this.f21475g = true;
            this.f21470b.x(this);
        }

        @Override // S4.b
        public boolean g() {
            return this.f21475g;
        }

        @Override // j5.C2224a.InterfaceC0329a, V4.g
        public boolean test(Object obj) {
            return this.f21475g || i.a(obj, this.f21469a);
        }
    }

    public C2379a() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f21464c = reentrantReadWriteLock;
        this.f21465d = reentrantReadWriteLock.readLock();
        this.f21466e = reentrantReadWriteLock.writeLock();
        this.f21463b = new AtomicReference(f21460i);
        this.f21462a = new AtomicReference();
        this.f21467f = new AtomicReference();
    }

    public static C2379a w() {
        return new C2379a();
    }

    @Override // P4.q
    public void a() {
        if (d.a(this.f21467f, null, g.f20111a)) {
            Object objB = i.b();
            for (C0356a c0356a : z(objB)) {
                c0356a.c(objB, this.f21468g);
            }
        }
    }

    @Override // P4.q
    public void b(S4.b bVar) {
        if (this.f21467f.get() != null) {
            bVar.dispose();
        }
    }

    @Override // P4.q
    public void c(Object obj) {
        X4.b.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f21467f.get() != null) {
            return;
        }
        Object objM = i.m(obj);
        y(objM);
        for (C0356a c0356a : (C0356a[]) this.f21463b.get()) {
            c0356a.c(objM, this.f21468g);
        }
    }

    @Override // P4.q
    public void onError(Throwable th) {
        X4.b.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!d.a(this.f21467f, null, th)) {
            AbstractC2283a.q(th);
            return;
        }
        Object objG = i.g(th);
        for (C0356a c0356a : z(objG)) {
            c0356a.c(objG, this.f21468g);
        }
    }

    @Override // P4.o
    public void s(q qVar) {
        C0356a c0356a = new C0356a(qVar, this);
        qVar.b(c0356a);
        if (v(c0356a)) {
            if (c0356a.f21475g) {
                x(c0356a);
                return;
            } else {
                c0356a.a();
                return;
            }
        }
        Throwable th = (Throwable) this.f21467f.get();
        if (th == g.f20111a) {
            qVar.a();
        } else {
            qVar.onError(th);
        }
    }

    public boolean v(C0356a c0356a) {
        C0356a[] c0356aArr;
        C0356a[] c0356aArr2;
        do {
            c0356aArr = (C0356a[]) this.f21463b.get();
            if (c0356aArr == f21461j) {
                return false;
            }
            int length = c0356aArr.length;
            c0356aArr2 = new C0356a[length + 1];
            System.arraycopy(c0356aArr, 0, c0356aArr2, 0, length);
            c0356aArr2[length] = c0356a;
        } while (!d.a(this.f21463b, c0356aArr, c0356aArr2));
        return true;
    }

    public void x(C0356a c0356a) {
        C0356a[] c0356aArr;
        C0356a[] c0356aArr2;
        do {
            c0356aArr = (C0356a[]) this.f21463b.get();
            int length = c0356aArr.length;
            if (length == 0) {
                return;
            }
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    i8 = -1;
                    break;
                } else if (c0356aArr[i8] == c0356a) {
                    break;
                } else {
                    i8++;
                }
            }
            if (i8 < 0) {
                return;
            }
            if (length == 1) {
                c0356aArr2 = f21460i;
            } else {
                C0356a[] c0356aArr3 = new C0356a[length - 1];
                System.arraycopy(c0356aArr, 0, c0356aArr3, 0, i8);
                System.arraycopy(c0356aArr, i8 + 1, c0356aArr3, i8, (length - i8) - 1);
                c0356aArr2 = c0356aArr3;
            }
        } while (!d.a(this.f21463b, c0356aArr, c0356aArr2));
    }

    public void y(Object obj) {
        this.f21466e.lock();
        this.f21468g++;
        this.f21462a.lazySet(obj);
        this.f21466e.unlock();
    }

    public C0356a[] z(Object obj) {
        AtomicReference atomicReference = this.f21463b;
        C0356a[] c0356aArr = f21461j;
        C0356a[] c0356aArr2 = (C0356a[]) atomicReference.getAndSet(c0356aArr);
        if (c0356aArr2 != c0356aArr) {
            y(obj);
        }
        return c0356aArr2;
    }
}
