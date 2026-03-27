package l;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: l.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC0788d implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f7949b;

    public /* synthetic */ ViewOnAttachStateChangeListenerC0788d(k kVar, int i) {
        this.f7948a = i;
        this.f7949b = kVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i = this.f7948a;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.f7948a) {
            case 0:
                f fVar = (f) this.f7949b;
                ViewTreeObserver viewTreeObserver = fVar.f7954B;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        fVar.f7954B = view.getViewTreeObserver();
                    }
                    fVar.f7954B.removeGlobalOnLayoutListener(fVar.f7963m);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            default:
                s sVar = (s) this.f7949b;
                ViewTreeObserver viewTreeObserver2 = sVar.f8048s;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        sVar.f8048s = view.getViewTreeObserver();
                    }
                    sVar.f8048s.removeGlobalOnLayoutListener(sVar.f8042m);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }
}
