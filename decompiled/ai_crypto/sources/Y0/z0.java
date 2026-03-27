package Y0;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0734o f5632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0724f0 f5633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y0 f5634d = new y0(this, true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y0 f5635e = new y0(this, false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5636f;

    public z0(Context context, InterfaceC0734o interfaceC0734o, l0 l0Var, I i7, r rVar, InterfaceC0724f0 interfaceC0724f0) {
        this.f5631a = context;
        this.f5632b = interfaceC0734o;
        this.f5633c = interfaceC0724f0;
    }

    public static /* bridge */ /* synthetic */ I a(z0 z0Var) {
        z0Var.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ r e(z0 z0Var) {
        z0Var.getClass();
        return null;
    }

    public final InterfaceC0734o d() {
        return this.f5632b;
    }

    public final void f() {
        this.f5634d.c(this.f5631a);
        this.f5635e.c(this.f5631a);
    }

    public final void g(boolean z7) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f5636f = z7;
        this.f5635e.a(this.f5631a, intentFilter2);
        if (this.f5636f) {
            this.f5634d.b(this.f5631a, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            this.f5634d.a(this.f5631a, intentFilter);
        }
    }
}
