package Q;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class I implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f4370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f4371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f4372c;

    public I(View view, Runnable runnable) {
        this.f4370a = view;
        this.f4371b = view.getViewTreeObserver();
        this.f4372c = runnable;
    }

    public static I a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        I i7 = new I(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(i7);
        view.addOnAttachStateChangeListener(i7);
        return i7;
    }

    public void b() {
        if (this.f4371b.isAlive()) {
            this.f4371b.removeOnPreDrawListener(this);
        } else {
            this.f4370a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f4370a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f4372c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f4371b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
