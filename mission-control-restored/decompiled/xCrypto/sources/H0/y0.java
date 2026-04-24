package H0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzco;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzgw;
import com.google.android.gms.internal.play_billing.zzjz;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class y0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z0 f701c;

    public y0(z0 z0Var, boolean z4) {
        this.f701c = z0Var;
        this.f700b = z4;
    }

    public final synchronized void a(Context context, IntentFilter intentFilter) {
        try {
            if (this.f699a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this, intentFilter, true != this.f700b ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.f699a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Context context, IntentFilter intentFilter, String str) {
        y0 y0Var;
        try {
            try {
                if (this.f699a) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    y0Var = this;
                    context.registerReceiver(y0Var, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.f700b ? 4 : 2);
                } else {
                    y0Var = this;
                    context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                y0Var.f699a = true;
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    public final synchronized void c(Context context) {
        if (!this.f699a) {
            zze.zzl("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.f699a = false;
        }
    }

    public final void d(Bundle bundle, com.android.billingclient.api.d dVar, int i4) {
        try {
            if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
                this.f701c.f706c.d(zzjz.zzC(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzgw.zza()));
            } else {
                this.f701c.f706c.d(AbstractC0301e0.b(23, i4, dVar));
            }
        } catch (Throwable unused) {
            zze.zzl("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            zze.zzl("BillingBroadcastManager", "Bundle is null.");
            InterfaceC0303f0 interfaceC0303f0 = this.f701c.f706c;
            com.android.billingclient.api.d dVar = com.android.billingclient.api.k.f9507k;
            interfaceC0303f0.d(AbstractC0301e0.b(11, 1, dVar));
            z0 z0Var = this.f701c;
            if (z0Var.f705b != null) {
                z0Var.f705b.onPurchasesUpdated(dVar, null);
                return;
            }
            return;
        }
        com.android.billingclient.api.d dVarZzf = zze.zzf(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        int i4 = true == Objects.equals(extras.getString("INTENT_SOURCE"), "LAUNCH_BILLING_FLOW") ? 2 : 1;
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED") || action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            List listZzj = zze.zzj(extras);
            if (dVarZzf.b() == 0) {
                this.f701c.f706c.g(AbstractC0301e0.d(i4));
            } else {
                d(extras, dVarZzf, i4);
            }
            this.f701c.f705b.onPurchasesUpdated(dVarZzf, listZzj);
            return;
        }
        if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            if (dVarZzf.b() != 0) {
                d(extras, dVarZzf, i4);
                this.f701c.f705b.onPurchasesUpdated(dVarZzf, zzco.zzl());
                return;
            }
            z0 z0Var2 = this.f701c;
            z0.a(z0Var2);
            z0.e(z0Var2);
            zze.zzl("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
            InterfaceC0303f0 interfaceC0303f02 = this.f701c.f706c;
            com.android.billingclient.api.d dVar2 = com.android.billingclient.api.k.f9507k;
            interfaceC0303f02.d(AbstractC0301e0.b(77, i4, dVar2));
            this.f701c.f705b.onPurchasesUpdated(dVar2, zzco.zzl());
        }
    }
}
