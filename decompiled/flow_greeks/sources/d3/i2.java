package d3;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f7690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p1 f7691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h2 f7692d = new h2(this, true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h2 f7693e = new h2(this, false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7694f;

    public i2(Context context, s sVar, v1 v1Var, p0 p0Var, y yVar, p1 p1Var) {
        this.f7689a = context;
        this.f7690b = sVar;
        this.f7691c = p1Var;
    }

    public static /* bridge */ /* synthetic */ p0 a(i2 i2Var) {
        i2Var.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ y e(i2 i2Var) {
        i2Var.getClass();
        return null;
    }

    public final s d() {
        return this.f7690b;
    }

    public final void f() {
        h2 h2Var = this.f7692d;
        Context context = this.f7689a;
        h2Var.c(context);
        this.f7693e.c(context);
    }

    public final void g(boolean z10) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f7694f = z10;
        h2 h2Var = this.f7693e;
        Context context = this.f7689a;
        h2Var.a(context, intentFilter2);
        if (this.f7694f) {
            this.f7692d.b(context, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            this.f7692d.a(context, intentFilter);
        }
    }
}
