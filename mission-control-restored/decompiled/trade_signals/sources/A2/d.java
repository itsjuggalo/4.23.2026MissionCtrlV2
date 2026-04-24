package A2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import v2.AbstractC2842h;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends e {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future f73a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f74b;

        public a(Future future, c cVar) {
            this.f73a = future;
            this.f74b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thA;
            Object obj = this.f73a;
            if ((obj instanceof B2.a) && (thA = B2.b.a((B2.a) obj)) != null) {
                this.f74b.onFailure(thA);
                return;
            }
            try {
                this.f74b.onSuccess(d.b(this.f73a));
            } catch (Error e8) {
                e = e8;
                this.f74b.onFailure(e);
            } catch (RuntimeException e9) {
                e = e9;
                this.f74b.onFailure(e);
            } catch (ExecutionException e10) {
                this.f74b.onFailure(e10.getCause());
            }
        }

        public String toString() {
            return AbstractC2842h.b(this).k(this.f74b).toString();
        }
    }

    public static void a(f fVar, c cVar, Executor executor) {
        AbstractC2848n.n(cVar);
        fVar.a(new a(fVar, cVar), executor);
    }

    public static Object b(Future future) {
        AbstractC2848n.x(future.isDone(), "Future was expected to be done: %s", future);
        return k.a(future);
    }
}
