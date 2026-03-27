package d5;

import P4.o;
import P4.p;
import P4.q;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    public static final class a extends AtomicInteger implements Y4.e, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f16964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f16965b;

        public a(q qVar, Object obj) {
            this.f16964a = qVar;
            this.f16965b = obj;
        }

        @Override // Y4.j
        public void clear() {
            lazySet(3);
        }

        @Override // S4.b
        public void dispose() {
            set(3);
        }

        @Override // S4.b
        public boolean g() {
            return get() == 3;
        }

        @Override // Y4.j
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // Y4.f
        public int k(int i8) {
            if ((i8 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // Y4.j
        public boolean offer(Object obj) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // Y4.j
        public Object poll() {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.f16965b;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f16964a.c(this.f16965b);
                if (get() == 2) {
                    lazySet(3);
                    this.f16964a.a();
                }
            }
        }
    }

    public static final class b extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f16966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V4.e f16967b;

        public b(Object obj, V4.e eVar) {
            this.f16966a = obj;
            this.f16967b = eVar;
        }

        @Override // P4.o
        public void s(q qVar) {
            try {
                p pVar = (p) X4.b.d(this.f16967b.apply(this.f16966a), "The mapper returned a null ObservableSource");
                if (!(pVar instanceof Callable)) {
                    pVar.d(qVar);
                    return;
                }
                try {
                    Object objCall = ((Callable) pVar).call();
                    if (objCall == null) {
                        W4.c.i(qVar);
                        return;
                    }
                    a aVar = new a(qVar, objCall);
                    qVar.b(aVar);
                    aVar.run();
                } catch (Throwable th) {
                    T4.b.b(th);
                    W4.c.n(th, qVar);
                }
            } catch (Throwable th2) {
                W4.c.n(th2, qVar);
            }
        }
    }

    public static o a(Object obj, V4.e eVar) {
        return AbstractC2283a.m(new b(obj, eVar));
    }

    public static boolean b(p pVar, q qVar, V4.e eVar) {
        if (!(pVar instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) pVar).call();
            if (objCall == null) {
                W4.c.i(qVar);
                return true;
            }
            p pVar2 = (p) X4.b.d(eVar.apply(objCall), "The mapper returned a null ObservableSource");
            if (pVar2 instanceof Callable) {
                Object objCall2 = ((Callable) pVar2).call();
                if (objCall2 == null) {
                    W4.c.i(qVar);
                    return true;
                }
                a aVar = new a(qVar, objCall2);
                qVar.b(aVar);
                aVar.run();
            } else {
                pVar2.d(qVar);
            }
            return true;
        } catch (Throwable th) {
            T4.b.b(th);
            W4.c.n(th, qVar);
            return true;
        }
    }
}
