package T;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: T.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0942y implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f7881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f7882c;

    public ViewTreeObserverOnPreDrawListenerC0942y(View view, Runnable runnable) {
        this.f7880a = view;
        this.f7881b = view.getViewTreeObserver();
        this.f7882c = runnable;
    }

    public static ViewTreeObserverOnPreDrawListenerC0942y a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        ViewTreeObserverOnPreDrawListenerC0942y viewTreeObserverOnPreDrawListenerC0942y = new ViewTreeObserverOnPreDrawListenerC0942y(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0942y);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0942y);
        return viewTreeObserverOnPreDrawListenerC0942y;
    }

    public void b() {
        (this.f7881b.isAlive() ? this.f7881b : this.f7880a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f7880a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f7882c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f7881b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
