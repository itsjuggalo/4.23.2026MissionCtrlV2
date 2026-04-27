package S1;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0875g f7388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b0 f7390c;

    public a0(b0 b0Var, AbstractC0875g abstractC0875g, String str) {
        this.f7388a = abstractC0875g;
        this.f7389b = str;
        this.f7390c = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        b0 b0Var = this.f7390c;
        if (b0Var.f7396b > 0) {
            AbstractC0875g abstractC0875g = this.f7388a;
            if (b0Var.f7397c != null) {
                bundle = b0Var.f7397c.getBundle(this.f7389b);
            } else {
                bundle = null;
            }
            abstractC0875g.f(bundle);
        }
        if (this.f7390c.f7396b >= 2) {
            this.f7388a.j();
        }
        if (this.f7390c.f7396b >= 3) {
            this.f7388a.h();
        }
        if (this.f7390c.f7396b >= 4) {
            this.f7388a.k();
        }
        if (this.f7390c.f7396b >= 5) {
            this.f7388a.g();
        }
    }
}
