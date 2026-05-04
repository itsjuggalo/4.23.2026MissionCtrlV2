package zb;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import p6.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.d f25645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rb.c f25646b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        c a(rb.d dVar, rb.c cVar);
    }

    public c(rb.d dVar, rb.c cVar) {
        this.f25645a = (rb.d) n.o(dVar, "channel");
        this.f25646b = (rb.c) n.o(cVar, "callOptions");
    }

    public abstract c a(rb.d dVar, rb.c cVar);

    public final rb.c b() {
        return this.f25646b;
    }

    public final rb.d c() {
        return this.f25645a;
    }

    public final c d(rb.b bVar) {
        return a(this.f25645a, this.f25646b.l(bVar));
    }

    public final c e(long j10, TimeUnit timeUnit) {
        return a(this.f25645a, this.f25646b.n(j10, timeUnit));
    }

    public final c f(Executor executor) {
        return a(this.f25645a, this.f25646b.o(executor));
    }
}
