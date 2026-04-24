package H0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zzau;
import com.google.android.gms.internal.play_billing.zze;

/* JADX INFO: loaded from: classes.dex */
public final class Z implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.android.billingclient.api.j f658a;

    public /* synthetic */ Z(com.android.billingclient.api.j jVar, AbstractC0293a0 abstractC0293a0) {
        this.f658a = jVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zze.zzk("BillingClientTesting", "Billing Override Service connected.");
        this.f658a.f9487I = zzau.zzc(iBinder);
        this.f658a.f9486H = 2;
        this.f658a.p1(26);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zze.zzl("BillingClientTesting", "Billing Override Service disconnected.");
        this.f658a.f9487I = null;
        this.f658a.f9486H = 0;
    }
}
