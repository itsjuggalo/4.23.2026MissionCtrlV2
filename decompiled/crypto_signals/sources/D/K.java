package D;

import android.view.WindowInsets;
import w.C1264c;

/* JADX INFO: loaded from: classes.dex */
public class K extends M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowInsets.Builder f207a;

    public K() {
        this.f207a = A1.a.h();
    }

    @Override // D.M
    public V b() {
        a();
        V vC = V.c(this.f207a.build(), null);
        vC.f219a.k(null);
        return vC;
    }

    @Override // D.M
    public void c(C1264c c1264c) {
        this.f207a.setStableInsets(c1264c.b());
    }

    @Override // D.M
    public void d(C1264c c1264c) {
        this.f207a.setSystemWindowInsets(c1264c.b());
    }

    public K(V v2) {
        WindowInsets.Builder builderH;
        super(v2);
        WindowInsets windowInsetsB = v2.b();
        if (windowInsetsB != null) {
            builderH = A1.a.i(windowInsetsB);
        } else {
            builderH = A1.a.h();
        }
        this.f207a = builderH;
    }
}
