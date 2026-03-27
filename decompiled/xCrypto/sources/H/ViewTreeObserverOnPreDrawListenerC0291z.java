package H;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: H.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0291z implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f591c;

    public ViewTreeObserverOnPreDrawListenerC0291z(View view, Runnable runnable) {
        this.f589a = view;
        this.f590b = view.getViewTreeObserver();
        this.f591c = runnable;
    }

    public static ViewTreeObserverOnPreDrawListenerC0291z a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        ViewTreeObserverOnPreDrawListenerC0291z viewTreeObserverOnPreDrawListenerC0291z = new ViewTreeObserverOnPreDrawListenerC0291z(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0291z);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0291z);
        return viewTreeObserverOnPreDrawListenerC0291z;
    }

    public void b() {
        if (this.f590b.isAlive()) {
            this.f590b.removeOnPreDrawListener(this);
        } else {
            this.f589a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f589a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f591c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f590b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
