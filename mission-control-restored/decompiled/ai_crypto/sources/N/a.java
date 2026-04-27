package N;

import N.f;
import N.g;
import android.graphics.Typeface;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.c f3894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f3895b;

    /* JADX INFO: renamed from: N.a$a, reason: collision with other inner class name */
    public class RunnableC0053a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f3896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f3897b;

        public RunnableC0053a(g.c cVar, Typeface typeface) {
            this.f3896a = cVar;
            this.f3897b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3896a.b(this.f3897b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f3899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3900b;

        public b(g.c cVar, int i7) {
            this.f3899a = cVar;
            this.f3900b = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3899a.a(this.f3900b);
        }
    }

    public a(g.c cVar, Handler handler) {
        this.f3894a = cVar;
        this.f3895b = handler;
    }

    public final void a(int i7) {
        this.f3895b.post(new b(this.f3894a, i7));
    }

    public void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f3924a);
        } else {
            a(eVar.f3925b);
        }
    }

    public final void c(Typeface typeface) {
        this.f3895b.post(new RunnableC0053a(this.f3894a, typeface));
    }
}
