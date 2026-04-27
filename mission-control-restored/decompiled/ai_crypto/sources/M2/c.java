package M2;

import H2.m;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends d {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future f3831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f3832b;

        public a(Future future, b bVar) {
            this.f3831a = future;
            this.f3832b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f3832b.onSuccess(c.b(this.f3831a));
            } catch (Error e7) {
                e = e7;
                this.f3832b.a(e);
            } catch (RuntimeException e8) {
                e = e8;
                this.f3832b.a(e);
            } catch (ExecutionException e9) {
                this.f3832b.a(e9.getCause());
            }
        }

        public String toString() {
            return H2.g.b(this).k(this.f3832b).toString();
        }
    }

    public static void a(e eVar, b bVar, Executor executor) {
        m.n(bVar);
        eVar.a(new a(eVar, bVar), executor);
    }

    public static Object b(Future future) {
        m.w(future.isDone(), "Future was expected to be done: %s", future);
        return h.a(future);
    }
}
