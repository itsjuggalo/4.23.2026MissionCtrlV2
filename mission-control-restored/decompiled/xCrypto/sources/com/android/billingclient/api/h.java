package com.android.billingclient.api;

import H0.InterfaceC0296c;
import H0.InterfaceC0303f0;
import H0.M;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zzam;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzjx;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzki;
import com.google.android.gms.internal.play_billing.zzkl;
import com.google.android.gms.internal.play_billing.zzlu;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class h implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0296c f9480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f9481b;

    public /* synthetic */ h(b bVar, InterfaceC0296c interfaceC0296c, M m4) {
        this.f9481b = bVar;
        this.f9480a = interfaceC0296c;
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0278  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object a() {
        /*
            Method dump skipped, instruction units count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.h.a():java.lang.Object");
    }

    public final /* synthetic */ void b() {
        this.f9481b.U(0);
        d dVar = k.f9510n;
        this.f9481b.A0(24, 6, dVar);
        c(dVar);
    }

    public final void c(d dVar) {
        synchronized (this.f9481b.f9384a) {
            try {
                if (this.f9481b.f9385b == 3) {
                    return;
                }
                this.f9480a.onBillingSetupFinished(dVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        zze.zzl("BillingClient", "Billing service died.");
        try {
            if (b.p0(this.f9481b)) {
                InterfaceC0303f0 interfaceC0303f0 = this.f9481b.f9390g;
                zzjx zzjxVarZzc = zzjz.zzc();
                zzjxVarZzc.zzn(6);
                zzke zzkeVarZzc = zzki.zzc();
                zzkeVarZzc.zzo(122);
                zzjxVarZzc.zza(zzkeVarZzc);
                interfaceC0303f0.d((zzjz) zzjxVarZzc.zzf());
            } else {
                this.f9481b.f9390g.a(zzkl.zzB());
            }
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
        synchronized (this.f9481b.f9384a) {
            if (this.f9481b.f9385b != 3 && this.f9481b.f9385b != 0) {
                this.f9481b.U(0);
                this.f9481b.W();
                this.f9480a.onBillingServiceDisconnected();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zze.zzk("BillingClient", "Billing service connected.");
        synchronized (this.f9481b.f9384a) {
            try {
                if (this.f9481b.f9385b == 3) {
                    return;
                }
                this.f9481b.f9391h = zzam.zzu(iBinder);
                b bVar = this.f9481b;
                if (b.p(new Callable() { // from class: H0.G
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        this.f623a.a();
                        return null;
                    }
                }, 30000L, new Runnable() { // from class: H0.H
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f626a.b();
                    }
                }, bVar.u0(), bVar.O()) == null) {
                    b bVar2 = this.f9481b;
                    d dVarL = bVar2.L();
                    bVar2.A0(25, 6, dVarL);
                    c(dVarL);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zze.zzl("BillingClient", "Billing service disconnected.");
        try {
            if (b.p0(this.f9481b)) {
                InterfaceC0303f0 interfaceC0303f0 = this.f9481b.f9390g;
                zzjx zzjxVarZzc = zzjz.zzc();
                zzjxVarZzc.zzn(6);
                zzke zzkeVarZzc = zzki.zzc();
                zzkeVarZzc.zzo(121);
                zzjxVarZzc.zza(zzkeVarZzc);
                interfaceC0303f0.d((zzjz) zzjxVarZzc.zzf());
            } else {
                this.f9481b.f9390g.b(zzlu.zzB());
            }
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
        synchronized (this.f9481b.f9384a) {
            try {
                if (this.f9481b.f9385b == 3) {
                    return;
                }
                this.f9481b.U(0);
                this.f9480a.onBillingServiceDisconnected();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
