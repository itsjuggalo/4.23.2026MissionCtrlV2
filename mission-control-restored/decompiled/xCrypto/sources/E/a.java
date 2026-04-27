package E;

import E.f;
import E.g;
import android.graphics.Typeface;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.c f328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f329b;

    /* JADX INFO: renamed from: E.a$a, reason: collision with other inner class name */
    public class RunnableC0014a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f331b;

        public RunnableC0014a(g.c cVar, Typeface typeface) {
            this.f330a = cVar;
            this.f331b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f330a.b(this.f331b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f334b;

        public b(g.c cVar, int i4) {
            this.f333a = cVar;
            this.f334b = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f333a.a(this.f334b);
        }
    }

    public a(g.c cVar, Handler handler) {
        this.f328a = cVar;
        this.f329b = handler;
    }

    public final void a(int i4) {
        this.f329b.post(new b(this.f328a, i4));
    }

    public void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f358a);
        } else {
            a(eVar.f359b);
        }
    }

    public final void c(Typeface typeface) {
        this.f329b.post(new RunnableC0014a(this.f328a, typeface));
    }
}
