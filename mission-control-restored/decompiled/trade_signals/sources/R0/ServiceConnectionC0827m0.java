package R0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.AbstractBinderC1366m;
import java.util.Objects;

/* JADX INFO: renamed from: R0.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC0827m0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0831o0 f7007a;

    public /* synthetic */ ServiceConnectionC0827m0(C0831o0 c0831o0, AbstractC0829n0 abstractC0829n0) {
        Objects.requireNonNull(c0831o0);
        this.f7007a = c0831o0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.V.l("BillingClientTesting", "Billing Override Service connected.");
        C0831o0 c0831o0 = this.f7007a;
        c0831o0.f7012M = AbstractBinderC1366m.E(iBinder);
        c0831o0.f7011L = 2;
        c0831o0.c1(26);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.V.m("BillingClientTesting", "Billing Override Service disconnected.");
        C0831o0 c0831o0 = this.f7007a;
        c0831o0.f7012M = null;
        c0831o0.f7011L = 0;
    }
}
