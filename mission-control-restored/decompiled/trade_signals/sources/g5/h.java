package g5;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends AtomicReferenceArray implements Runnable, Callable, S4.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f18276b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f18277c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f18278d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f18279e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f18280a;

    public h(Runnable runnable, W4.a aVar) {
        super(3);
        this.f18280a = runnable;
        lazySet(0, aVar);
    }

    public void a(Future future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f18279e) {
                return;
            }
            if (obj == f18277c) {
                future.cancel(false);
                return;
            } else if (obj == f18278d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // S4.b
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == f18279e || obj5 == (obj3 = f18277c) || obj5 == (obj4 = f18278d)) {
                break;
            }
            boolean z7 = get(2) != Thread.currentThread();
            if (z7) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z7);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f18279e || obj == (obj2 = f18276b) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((W4.a) obj).c(this);
    }

    @Override // S4.b
    public boolean g() {
        Object obj = get(0);
        return obj == f18276b || obj == f18279e;
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
            this.f18280a.run();
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
        if (obj5 != f18276b && compareAndSet(0, obj5, f18279e) && obj5 != null) {
            ((W4.a) obj5).c(this);
        }
        do {
            obj4 = get(1);
            if (obj4 == f18277c || obj4 == f18278d) {
                return;
            }
        } while (!compareAndSet(1, obj4, f18279e));
    }
}
