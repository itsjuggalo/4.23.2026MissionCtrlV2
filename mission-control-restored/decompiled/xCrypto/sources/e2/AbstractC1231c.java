package e2;

import Z1.m;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: renamed from: e2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1231c extends AbstractC1232d {

    /* JADX INFO: renamed from: e2.c$a */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future f11502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC1230b f11503b;

        public a(Future future, InterfaceC1230b interfaceC1230b) {
            this.f11502a = future;
            this.f11503b = interfaceC1230b;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f11503b.onSuccess(AbstractC1231c.b(this.f11502a));
            } catch (Error e4) {
                e = e4;
                this.f11503b.a(e);
            } catch (RuntimeException e5) {
                e = e5;
                this.f11503b.a(e);
            } catch (ExecutionException e6) {
                this.f11503b.a(e6.getCause());
            }
        }

        public String toString() {
            return Z1.g.b(this).k(this.f11503b).toString();
        }
    }

    public static void a(InterfaceFutureC1233e interfaceFutureC1233e, InterfaceC1230b interfaceC1230b, Executor executor) {
        m.n(interfaceC1230b);
        interfaceFutureC1233e.addListener(new a(interfaceFutureC1233e, interfaceC1230b), executor);
    }

    public static Object b(Future future) {
        m.w(future.isDone(), "Future was expected to be done: %s", future);
        return AbstractC1236h.a(future);
    }
}
