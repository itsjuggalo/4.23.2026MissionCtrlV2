package uc;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends AtomicReferenceArray implements Runnable, Callable, fc.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f22953b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f22954c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f22955d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f22956e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f22957a;

    public h(Runnable runnable, jc.a aVar) {
        super(3);
        this.f22957a = runnable;
        lazySet(0, aVar);
    }

    public void a(Future future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f22956e) {
                return;
            }
            if (obj == f22954c) {
                future.cancel(false);
                return;
            } else if (obj == f22955d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // fc.b
    public boolean c() {
        Object obj = get(0);
        return obj == f22953b || obj == f22956e;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // fc.b
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == f22956e || obj5 == (obj3 = f22954c) || obj5 == (obj4 = f22955d)) {
                break;
            }
            boolean z10 = get(2) != Thread.currentThread();
            if (z10) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z10);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f22956e || obj == (obj2 = f22953b) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((jc.a) obj).b(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean zCompareAndSet;
        Object obj4;
        lazySet(2, Thread.currentThread());
        try {
            this.f22957a.run();
        } finally {
            try {
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!zCompareAndSet);
            }
        }
        lazySet(2, null);
        Object obj5 = get(0);
        if (obj5 != f22953b && compareAndSet(0, obj5, f22956e) && obj5 != null) {
            ((jc.a) obj5).b(this);
        }
        do {
            obj4 = get(1);
            if (obj4 == f22954c || obj4 == f22955d) {
                return;
            }
        } while (!compareAndSet(1, obj4, f22956e));
    }
}
