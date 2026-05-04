package tb;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface t extends rb.j0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(long j10);

        void onFailure(Throwable th);
    }

    void b(a aVar, Executor executor);

    r g(rb.z0 z0Var, rb.y0 y0Var, rb.c cVar, rb.k[] kVarArr);
}
