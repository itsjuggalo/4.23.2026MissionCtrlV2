package H0;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0313o f705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0303f0 f706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y0 f707d = new y0(this, true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y0 f708e = new y0(this, false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f709f;

    public z0(Context context, InterfaceC0313o interfaceC0313o, l0 l0Var, I i4, r rVar, InterfaceC0303f0 interfaceC0303f0) {
        this.f704a = context;
        this.f705b = interfaceC0313o;
        this.f706c = interfaceC0303f0;
    }

    public static /* bridge */ /* synthetic */ I a(z0 z0Var) {
        z0Var.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ r e(z0 z0Var) {
        z0Var.getClass();
        return null;
    }

    public final InterfaceC0313o d() {
        return this.f705b;
    }

    public final void f() {
        this.f707d.c(this.f704a);
        this.f708e.c(this.f704a);
    }

    public final void g(boolean z4) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f709f = z4;
        this.f708e.a(this.f704a, intentFilter2);
        if (this.f709f) {
            this.f707d.b(this.f704a, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            this.f707d.a(this.f704a, intentFilter);
        }
    }
}
