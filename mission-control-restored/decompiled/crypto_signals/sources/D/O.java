package D;

import android.view.WindowInsets;
import w.C1264c;

/* JADX INFO: loaded from: classes.dex */
public class O extends N {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C1264c f214k;

    public O(V v2, WindowInsets windowInsets) {
        super(v2, windowInsets);
        this.f214k = null;
    }

    @Override // D.U
    public V b() {
        return V.c(this.f212c.consumeStableInsets(), null);
    }

    @Override // D.U
    public V c() {
        return V.c(this.f212c.consumeSystemWindowInsets(), null);
    }

    @Override // D.U
    public final C1264c f() {
        if (this.f214k == null) {
            WindowInsets windowInsets = this.f212c;
            this.f214k = C1264c.a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f214k;
    }

    @Override // D.U
    public boolean i() {
        return this.f212c.isConsumed();
    }

    @Override // D.U
    public void m(C1264c c1264c) {
        this.f214k = c1264c;
    }
}
