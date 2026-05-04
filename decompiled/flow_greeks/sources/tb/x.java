package tb;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f21800a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile rb.p f21801b = rb.p.IDLE;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f21802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f21803b;

        public a(Runnable runnable, Executor executor) {
            this.f21802a = runnable;
            this.f21803b = executor;
        }

        public void a() {
            this.f21803b.execute(this.f21802a);
        }
    }

    public rb.p a() {
        rb.p pVar = this.f21801b;
        if (pVar != null) {
            return pVar;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    public void b(rb.p pVar) {
        p6.n.o(pVar, "newState");
        if (this.f21801b == pVar || this.f21801b == rb.p.SHUTDOWN) {
            return;
        }
        this.f21801b = pVar;
        if (this.f21800a.isEmpty()) {
            return;
        }
        ArrayList arrayList = this.f21800a;
        this.f21800a = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    public void c(Runnable runnable, Executor executor, rb.p pVar) {
        p6.n.o(runnable, "callback");
        p6.n.o(executor, "executor");
        p6.n.o(pVar, FirebaseAnalytics.Param.SOURCE);
        a aVar = new a(runnable, executor);
        if (this.f21801b != pVar) {
            aVar.a();
        } else {
            this.f21800a.add(aVar);
        }
    }
}
