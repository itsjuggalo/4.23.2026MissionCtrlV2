package D;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: D.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0011k implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f244c;

    public ViewTreeObserverOnPreDrawListenerC0011k(View view, Runnable runnable) {
        this.f242a = view;
        this.f243b = view.getViewTreeObserver();
        this.f244c = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        ViewTreeObserverOnPreDrawListenerC0011k viewTreeObserverOnPreDrawListenerC0011k = new ViewTreeObserverOnPreDrawListenerC0011k(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0011k);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0011k);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zIsAlive = this.f243b.isAlive();
        View view = this.f242a;
        if (zIsAlive) {
            this.f243b.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f244c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f243b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.f243b.isAlive();
        View view2 = this.f242a;
        if (zIsAlive) {
            this.f243b.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
