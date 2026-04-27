package j1;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import d1.v;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f19946a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f19947b;

    public class a implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f19948a;

        /* JADX INFO: renamed from: j1.h$a$a, reason: collision with other inner class name */
        public class RunnableC0325a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnDrawListener f19950a;

            public RunnableC0325a(ViewTreeObserver.OnDrawListener onDrawListener) {
                this.f19950a = onDrawListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                v.b().h();
                h.this.f19947b = true;
                h.b(a.this.f19948a, this.f19950a);
                h.this.f19946a.clear();
            }
        }

        public a(View view) {
            this.f19948a = view;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            AbstractC2629l.u(new RunnableC0325a(this));
        }
    }

    public static void b(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }

    @Override // j1.i
    public void a(Activity activity) {
        if (!this.f19947b && this.f19946a.add(activity)) {
            View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new a(decorView));
        }
    }
}
