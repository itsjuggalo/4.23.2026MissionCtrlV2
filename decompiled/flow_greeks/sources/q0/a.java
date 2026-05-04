package q0;

import android.graphics.Typeface;
import java.util.concurrent.Executor;
import q0.f;
import q0.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.c f18701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18702b;

    /* JADX INFO: renamed from: q0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class RunnableC0319a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f18703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f18704b;

        public RunnableC0319a(g.c cVar, Typeface typeface) {
            this.f18703a = cVar;
            this.f18704b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18703a.b(this.f18704b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f18706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f18707b;

        public b(g.c cVar, int i10) {
            this.f18706a = cVar;
            this.f18707b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18706a.a(this.f18707b);
        }
    }

    public a(g.c cVar, Executor executor) {
        this.f18701a = cVar;
        this.f18702b = executor;
    }

    public final void a(int i10) {
        this.f18702b.execute(new b(this.f18701a, i10));
    }

    public void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f18735a);
        } else {
            a(eVar.f18736b);
        }
    }

    public final void c(Typeface typeface) {
        this.f18702b.execute(new RunnableC0319a(this.f18701a, typeface));
    }
}
