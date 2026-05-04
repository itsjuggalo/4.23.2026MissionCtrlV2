package u6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import p6.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d extends e {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future f22206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f22207b;

        public a(Future future, c cVar) {
            this.f22206a = future;
            this.f22207b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thA;
            Object obj = this.f22206a;
            if ((obj instanceof v6.a) && (thA = v6.b.a((v6.a) obj)) != null) {
                this.f22207b.onFailure(thA);
                return;
            }
            try {
                this.f22207b.onSuccess(d.b(this.f22206a));
            } catch (Error e10) {
                e = e10;
                this.f22207b.onFailure(e);
            } catch (RuntimeException e11) {
                e = e11;
                this.f22207b.onFailure(e);
            } catch (ExecutionException e12) {
                this.f22207b.onFailure(e12.getCause());
            }
        }

        public String toString() {
            return p6.h.b(this).k(this.f22207b).toString();
        }
    }

    public static void a(f fVar, c cVar, Executor executor) {
        n.n(cVar);
        fVar.a(new a(fVar, cVar), executor);
    }

    public static Object b(Future future) {
        n.x(future.isDone(), "Future was expected to be done: %s", future);
        return k.a(future);
    }
}
