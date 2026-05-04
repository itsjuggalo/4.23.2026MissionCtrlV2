package ad;

import cc.q;
import com.amazon.a.a.l.d;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import xc.a;
import xc.g;
import xc.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f732h = new Object[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0009a[] f733i = new C0009a[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0009a[] f734j = new C0009a[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReadWriteLock f737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lock f738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lock f739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f741g;

    /* JADX INFO: renamed from: ad.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0009a implements fc.b, a.InterfaceC0452a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f744c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f745d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public xc.a f746e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f747f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile boolean f748g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f749h;

        public C0009a(q qVar, a aVar) {
            this.f742a = qVar;
            this.f743b = aVar;
        }

        public void a() {
            if (this.f748g) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.f748g) {
                        return;
                    }
                    if (this.f744c) {
                        return;
                    }
                    a aVar = this.f743b;
                    Lock lock = aVar.f738d;
                    lock.lock();
                    this.f749h = aVar.f741g;
                    Object obj = aVar.f735a.get();
                    lock.unlock();
                    this.f745d = obj != null;
                    this.f744c = true;
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
            xc.a aVar;
            while (!this.f748g) {
                synchronized (this) {
                    try {
                        aVar = this.f746e;
                        if (aVar == null) {
                            this.f745d = false;
                            return;
                        }
                        this.f746e = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                aVar.b(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f748g;
        }

        public void d(Object obj, long j10) {
            if (this.f748g) {
                return;
            }
            if (!this.f747f) {
                synchronized (this) {
                    try {
                        if (this.f748g) {
                            return;
                        }
                        if (this.f749h == j10) {
                            return;
                        }
                        if (this.f745d) {
                            xc.a aVar = this.f746e;
                            if (aVar == null) {
                                aVar = new xc.a(4);
                                this.f746e = aVar;
                            }
                            aVar.a(obj);
                            return;
                        }
                        this.f744c = true;
                        this.f747f = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            test(obj);
        }

        @Override // fc.b
        public void dispose() {
            if (this.f748g) {
                return;
            }
            this.f748g = true;
            this.f743b.p(this);
        }

        @Override // xc.a.InterfaceC0452a, ic.g
        public boolean test(Object obj) {
            return this.f748g || i.a(obj, this.f742a);
        }
    }

    public a() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f737c = reentrantReadWriteLock;
        this.f738d = reentrantReadWriteLock.readLock();
        this.f739e = reentrantReadWriteLock.writeLock();
        this.f736b = new AtomicReference(f733i);
        this.f735a = new AtomicReference();
        this.f740f = new AtomicReference();
    }

    public static a o() {
        return new a();
    }

    @Override // cc.q
    public void a(fc.b bVar) {
        if (this.f740f.get() != null) {
            bVar.dispose();
        }
    }

    @Override // cc.o
    public void k(q qVar) {
        C0009a c0009a = new C0009a(qVar, this);
        qVar.a(c0009a);
        if (n(c0009a)) {
            if (c0009a.f748g) {
                p(c0009a);
                return;
            } else {
                c0009a.a();
                return;
            }
        }
        Throwable th = (Throwable) this.f740f.get();
        if (th == g.f24803a) {
            qVar.onComplete();
        } else {
            qVar.onError(th);
        }
    }

    public boolean n(C0009a c0009a) {
        C0009a[] c0009aArr;
        C0009a[] c0009aArr2;
        do {
            c0009aArr = (C0009a[]) this.f736b.get();
            if (c0009aArr == f734j) {
                return false;
            }
            int length = c0009aArr.length;
            c0009aArr2 = new C0009a[length + 1];
            System.arraycopy(c0009aArr, 0, c0009aArr2, 0, length);
            c0009aArr2[length] = c0009a;
        } while (!d.a(this.f736b, c0009aArr, c0009aArr2));
        return true;
    }

    @Override // cc.q
    public void onComplete() {
        if (d.a(this.f740f, null, g.f24803a)) {
            Object objB = i.b();
            for (C0009a c0009a : r(objB)) {
                c0009a.d(objB, this.f741g);
            }
        }
    }

    @Override // cc.q
    public void onError(Throwable th) {
        kc.b.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!d.a(this.f740f, null, th)) {
            yc.a.q(th);
            return;
        }
        Object objC = i.c(th);
        for (C0009a c0009a : r(objC)) {
            c0009a.d(objC, this.f741g);
        }
    }

    @Override // cc.q
    public void onNext(Object obj) {
        kc.b.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f740f.get() != null) {
            return;
        }
        Object objL = i.l(obj);
        q(objL);
        for (C0009a c0009a : (C0009a[]) this.f736b.get()) {
            c0009a.d(objL, this.f741g);
        }
    }

    public void p(C0009a c0009a) {
        C0009a[] c0009aArr;
        C0009a[] c0009aArr2;
        do {
            c0009aArr = (C0009a[]) this.f736b.get();
            int length = c0009aArr.length;
            if (length == 0) {
                return;
            }
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i10 = -1;
                    break;
                } else if (c0009aArr[i10] == c0009a) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                c0009aArr2 = f733i;
            } else {
                C0009a[] c0009aArr3 = new C0009a[length - 1];
                System.arraycopy(c0009aArr, 0, c0009aArr3, 0, i10);
                System.arraycopy(c0009aArr, i10 + 1, c0009aArr3, i10, (length - i10) - 1);
                c0009aArr2 = c0009aArr3;
            }
        } while (!d.a(this.f736b, c0009aArr, c0009aArr2));
    }

    public void q(Object obj) {
        this.f739e.lock();
        this.f741g++;
        this.f735a.lazySet(obj);
        this.f739e.unlock();
    }

    public C0009a[] r(Object obj) {
        AtomicReference atomicReference = this.f736b;
        C0009a[] c0009aArr = f734j;
        C0009a[] c0009aArr2 = (C0009a[]) atomicReference.getAndSet(c0009aArr);
        if (c0009aArr2 != c0009aArr) {
            q(obj);
        }
        return c0009aArr2;
    }
}
