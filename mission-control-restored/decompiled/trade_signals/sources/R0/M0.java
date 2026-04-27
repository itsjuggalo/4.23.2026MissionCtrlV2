package R0;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public final class M0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0837t f6870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0 f6871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final L0 f6872d = new L0(this, true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final L0 f6873e = new L0(this, false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6874f;

    public M0(Context context, InterfaceC0837t interfaceC0837t, x0 x0Var, Q q8, InterfaceC0843z interfaceC0843z, r0 r0Var) {
        this.f6869a = context;
        this.f6870b = interfaceC0837t;
        this.f6871c = r0Var;
    }

    public static /* bridge */ /* synthetic */ Q a(M0 m02) {
        m02.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ InterfaceC0843z e(M0 m02) {
        m02.getClass();
        return null;
    }

    public final InterfaceC0837t d() {
        return this.f6870b;
    }

    public final void f() {
        L0 l02 = this.f6872d;
        Context context = this.f6869a;
        l02.c(context);
        this.f6873e.c(context);
    }

    public final void g(boolean z7) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f6874f = z7;
        L0 l02 = this.f6873e;
        Context context = this.f6869a;
        l02.a(context, intentFilter2);
        if (this.f6874f) {
            this.f6872d.b(context, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            this.f6872d.a(context, intentFilter);
        }
    }
}
