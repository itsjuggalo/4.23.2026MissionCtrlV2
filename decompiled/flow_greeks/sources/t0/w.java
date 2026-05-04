package t0;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f20557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f20558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f20559c;

    public w(View view, Runnable runnable) {
        this.f20557a = view;
        this.f20558b = view.getViewTreeObserver();
        this.f20559c = runnable;
    }

    public static w a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        w wVar = new w(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(wVar);
        view.addOnAttachStateChangeListener(wVar);
        return wVar;
    }

    public void b() {
        if (this.f20558b.isAlive()) {
            this.f20558b.removeOnPreDrawListener(this);
        } else {
            this.f20557a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f20557a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f20559c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f20558b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
