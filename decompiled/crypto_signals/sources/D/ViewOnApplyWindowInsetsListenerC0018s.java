package D;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: renamed from: D.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnApplyWindowInsetsListenerC0018s implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public V f255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f256b;

    public ViewOnApplyWindowInsetsListenerC0018s(View view, InterfaceC0010j interfaceC0010j) {
        this.f256b = view;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        V vC = V.c(windowInsets, view);
        if (Build.VERSION.SDK_INT < 30) {
            AbstractC0019t.a(windowInsets, this.f256b);
            if (vC.equals(this.f255a)) {
                throw null;
            }
        }
        this.f255a = vC;
        throw null;
    }
}
