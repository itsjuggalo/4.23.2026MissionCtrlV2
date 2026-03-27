package U3;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import io.flutter.plugin.platform.h;
import s4.G;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3170a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View.OnFocusChangeListener f3171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f3172c;

    public a(View.OnFocusChangeListener onFocusChangeListener, b bVar) {
        this.f3171b = onFocusChangeListener;
        this.f3172c = bVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View view, View view2) {
        switch (this.f3170a) {
            case 0:
                b bVar = (b) this.f3172c;
                this.f3171b.onFocusChange(bVar, y5.a.V(bVar, new G(12)));
                break;
            default:
                h hVar = (h) this.f3172c;
                this.f3171b.onFocusChange(hVar, y5.a.V(hVar, new G(12)));
                break;
        }
    }

    public a(h hVar, View.OnFocusChangeListener onFocusChangeListener) {
        this.f3172c = hVar;
        this.f3171b = onFocusChangeListener;
    }
}
