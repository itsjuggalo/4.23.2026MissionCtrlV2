package Q;

import Q.f;
import Q.g;
import android.graphics.Typeface;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.c f6597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f6598b;

    /* JADX INFO: renamed from: Q.a$a, reason: collision with other inner class name */
    public class RunnableC0091a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f6599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f6600b;

        public RunnableC0091a(g.c cVar, Typeface typeface) {
            this.f6599a = cVar;
            this.f6600b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6599a.b(this.f6600b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f6602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6603b;

        public b(g.c cVar, int i8) {
            this.f6602a = cVar;
            this.f6603b = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6602a.a(this.f6603b);
        }
    }

    public a(g.c cVar, Handler handler) {
        this.f6597a = cVar;
        this.f6598b = handler;
    }

    public final void a(int i8) {
        this.f6598b.post(new b(this.f6597a, i8));
    }

    public void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f6627a);
        } else {
            a(eVar.f6628b);
        }
    }

    public final void c(Typeface typeface) {
        this.f6598b.post(new RunnableC0091a(this.f6597a, typeface));
    }
}
