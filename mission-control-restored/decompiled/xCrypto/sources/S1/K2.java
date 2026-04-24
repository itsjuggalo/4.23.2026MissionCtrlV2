package S1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class K2 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7 f4067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4069c;

    public K2(b7 b7Var) {
        AbstractC0940s.k(b7Var);
        this.f4067a = b7Var;
    }

    public final void a() {
        b7 b7Var = this.f4067a;
        b7Var.O0();
        b7Var.b().h();
        if (this.f4068b) {
            return;
        }
        b7Var.e().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f4069c = b7Var.E0().m();
        b7Var.a().w().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f4069c));
        this.f4068b = true;
    }

    public final void b() {
        b7 b7Var = this.f4067a;
        b7Var.O0();
        b7Var.b().h();
        b7Var.b().h();
        if (this.f4068b) {
            b7Var.a().w().a("Unregistering connectivity change receiver");
            this.f4068b = false;
            this.f4069c = false;
            try {
                b7Var.e().unregisterReceiver(this);
            } catch (IllegalArgumentException e4) {
                this.f4067a.a().o().b("Failed to unregister the network broadcast receiver", e4);
            }
        }
    }

    public final /* synthetic */ b7 c() {
        return this.f4067a;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        b7 b7Var = this.f4067a;
        b7Var.O0();
        String action = intent.getAction();
        b7Var.a().w().b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            b7Var.a().r().b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zM = b7Var.E0().m();
        if (this.f4069c != zM) {
            this.f4069c = zM;
            b7Var.b().t(new I2(this, zM));
        }
    }
}
