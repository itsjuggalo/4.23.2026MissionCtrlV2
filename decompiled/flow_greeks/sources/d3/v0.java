package d3;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzal;
import com.google.android.gms.internal.play_billing.zzam;
import com.google.android.gms.internal.play_billing.zzbi;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzig;
import com.google.android.gms.internal.play_billing.zzij;
import com.google.android.gms.internal.play_billing.zzjm;
import com.google.android.gms.internal.play_billing.zzjo;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f7803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzbi f7804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zzbi f7805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d f7807e;

    public /* synthetic */ v0(d dVar, e eVar, int i10, y0 y0Var) {
        Objects.requireNonNull(dVar);
        this.f7807e = dVar;
        this.f7804b = zzbi.zzc(dVar.J);
        this.f7805c = zzbi.zzc(dVar.J);
        this.f7803a = eVar;
        this.f7806d = i10;
    }

    public static /* synthetic */ Object a(v0 v0Var) {
        Bundle bundle;
        zzam zzamVar;
        d dVar = v0Var.f7807e;
        synchronized (dVar.f7602a) {
            try {
                if (dVar.f7603b != 3) {
                    boolean z10 = dVar.f7603b == 1;
                    if (TextUtils.isEmpty(null)) {
                        bundle = null;
                    } else {
                        bundle = new Bundle();
                        bundle.putString("accountName", null);
                        zzc.zzc(bundle, dVar.f7604c, dVar.f7605d, dVar.I.longValue());
                    }
                    zzie zzieVar = zzie.REASON_UNSPECIFIED;
                    synchronized (dVar.f7602a) {
                        zzamVar = dVar.f7610i;
                    }
                    if (zzamVar == null) {
                        d dVar2 = v0Var.f7807e;
                        dVar2.K(0);
                        int i10 = v0Var.f7806d;
                        zzie zzieVar2 = zzie.SERVICE_RESET_TO_NULL;
                        com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5156j;
                        dVar2.J(zzieVar2, aVar, i10);
                        v0Var.g(aVar);
                    } else {
                        d dVar3 = v0Var.f7807e;
                        String packageName = dVar3.f7608g.getPackageName();
                        int i11 = 25;
                        int iZzw = 3;
                        int i12 = 25;
                        while (true) {
                            if (i12 < 3) {
                                i12 = 0;
                                break;
                            }
                            if (bundle == null) {
                                try {
                                    iZzw = zzamVar.zzw(i12, packageName, "subs");
                                } catch (Exception e10) {
                                    zzc.zzo("BillingClient", "Exception while checking if billing is supported; try to reconnect", e10);
                                    zzie zzieVar3 = e10 instanceof DeadObjectException ? zzie.IS_BILLING_SUPPORTED_DEAD_OBJECT_EXCEPTION : e10 instanceof RemoteException ? zzie.IS_BILLING_SUPPORTED_REMOTE_EXCEPTION : e10 instanceof SecurityException ? zzie.IS_BILLING_SUPPORTED_SECURITY_EXCEPTION : zzie.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION;
                                    String strA = zzieVar3.equals(zzie.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION) ? o1.a(e10) : null;
                                    v0Var.f7807e.K(0);
                                    v0Var.f(d.I0(e10), zzieVar3, strA, z10);
                                    v0Var.g(d.I0(e10));
                                }
                            } else {
                                iZzw = zzamVar.zzc(i12, packageName, "subs", bundle);
                            }
                            if (iZzw == 0) {
                                zzc.zzm("BillingClient", "highestLevelSupportedForSubs: " + i12);
                                break;
                            }
                            i12--;
                        }
                        dVar3.f7613l = i12 >= 5;
                        dVar3.f7612k = i12 >= 3;
                        if (i12 < 3) {
                            zzieVar = zzie.SUBSCRIPTIONS_NOT_SUPPORTED;
                            zzc.zzm("BillingClient", "In-app billing API does not support subscription on this device.");
                        }
                        while (true) {
                            if (i11 < 3) {
                                break;
                            }
                            iZzw = bundle == null ? zzamVar.zzw(i11, packageName, "inapp") : zzamVar.zzc(i11, packageName, "inapp", bundle);
                            if (iZzw == 0) {
                                dVar3.f7614m = i11;
                                zzc.zzm("BillingClient", "mHighestLevelSupportedForInApp: " + dVar3.f7614m);
                                break;
                            }
                            i11--;
                        }
                        d.U(dVar3, dVar3.f7614m);
                        if (dVar3.f7614m < 3) {
                            zzieVar = zzie.ONE_TIME_PRODUCT_NOT_SUPPORTED;
                            zzc.zzn("BillingClient", "In-app billing API version 3 is not supported on this device.");
                        }
                        d.W(dVar3, iZzw);
                        if (iZzw != 0) {
                            com.android.billingclient.api.a aVar2 = com.android.billingclient.api.c.f5148b;
                            v0Var.f(aVar2, zzieVar, null, z10);
                            v0Var.g(aVar2);
                        } else {
                            try {
                                Long lE = v0Var.e(z10);
                                if (z10) {
                                    zzhz zzhzVarZzc = zzib.zzc();
                                    zzhzVarZzc.zzo(6);
                                    zzjt zzjtVarZzc = zzjv.zzc();
                                    int i13 = v0Var.f7806d;
                                    zzjtVarZzc.zza(i13 > 0);
                                    zzjtVarZzc.zzl(i13);
                                    if (lE != null) {
                                        zzjtVarZzc.zzm(lE.longValue());
                                    }
                                    d dVar4 = v0Var.f7807e;
                                    zzhzVarZzc.zzn(zzjtVarZzc);
                                    dVar4.I((zzib) zzhzVarZzc.zze());
                                } else {
                                    zzjm zzjmVarZzc = zzjo.zzc();
                                    zzic zzicVarZzc = zzig.zzc();
                                    zzicVarZzc.zzo(0);
                                    zzjmVarZzc.zza(zzicVarZzc);
                                    if (lE != null) {
                                        zzjmVarZzc.zzl(lE.longValue());
                                    }
                                    v0Var.f7807e.f7609h.e((zzjo) zzjmVarZzc.zze());
                                }
                            } catch (Throwable th) {
                                zzc.zzo("BillingClient", "Unable to log.", th);
                            }
                            v0Var.g(com.android.billingclient.api.c.f5155i);
                        }
                    }
                }
            } finally {
            }
        }
        return null;
    }

    public static /* synthetic */ void b(v0 v0Var) {
        d dVar = v0Var.f7807e;
        dVar.K(0);
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5157k;
        dVar.J(zzieVar, aVar, v0Var.f7806d);
        v0Var.g(aVar);
    }

    public final void c() {
        zzbi zzbiVar = this.f7804b;
        zzbiVar.zzd();
        zzbiVar.zze();
    }

    public final boolean d() {
        return this.f7806d > 0;
    }

    public final Long e(boolean z10) {
        if (z10) {
            zzbi zzbiVar = this.f7804b;
            if (!zzbiVar.zzg()) {
                return null;
            }
            zzbiVar.zzf();
            return Long.valueOf(zzbiVar.zza(TimeUnit.MILLISECONDS));
        }
        zzbi zzbiVar2 = this.f7805c;
        if (!zzbiVar2.zzg()) {
            return null;
        }
        zzbiVar2.zzf();
        return Long.valueOf(zzbiVar2.zza(TimeUnit.MILLISECONDS));
    }

    public final void f(com.android.billingclient.api.a aVar, zzie zzieVar, String str, boolean z10) {
        try {
            zzic zzicVarZzc = zzig.zzc();
            zzicVarZzc.zzo(aVar.c());
            zzicVarZzc.zzl(aVar.a());
            zzicVarZzc.zzn(zzieVar);
            if (str != null) {
                zzicVarZzc.zza(str);
            }
            Long lE = e(z10);
            if (!z10) {
                zzjm zzjmVarZzc = zzjo.zzc();
                zzjmVarZzc.zza(zzicVarZzc);
                if (lE != null) {
                    zzjmVarZzc.zzl(lE.longValue());
                }
                this.f7807e.f7609h.e((zzjo) zzjmVarZzc.zze());
                return;
            }
            zzjt zzjtVarZzc = zzjv.zzc();
            int i10 = this.f7806d;
            zzjtVarZzc.zza(i10 > 0);
            zzjtVarZzc.zzl(i10);
            if (lE != null) {
                zzjtVarZzc.zzm(lE.longValue());
            }
            d dVar = this.f7807e;
            zzhv zzhvVarZzc = zzhx.zzc();
            zzhvVarZzc.zzl(zzicVarZzc);
            zzhvVarZzc.zzp(6);
            zzhvVarZzc.zzo(zzjtVarZzc);
            dVar.G((zzhx) zzhvVarZzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void g(com.android.billingclient.api.a aVar) {
        d dVar = this.f7807e;
        synchronized (dVar.f7602a) {
            try {
                if (dVar.f7603b == 3) {
                    return;
                }
                try {
                    this.f7803a.onBillingSetupFinished(aVar);
                } catch (Throwable th) {
                    zzc.zzo("BillingClient", "Exception while calling onBillingSetupFinished.", th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        zzc.zzn("BillingClient", "Billing service died.");
        try {
            d dVar = this.f7807e;
            if (d.a0(dVar)) {
                p1 p1Var = dVar.f7609h;
                zzhv zzhvVarZzc = zzhx.zzc();
                zzhvVarZzc.zzp(6);
                zzic zzicVarZzc = zzig.zzc();
                zzicVarZzc.zzn(zzie.BINDING_DIED);
                zzhvVarZzc.zzl(zzicVarZzc);
                zzjt zzjtVarZzc = zzjv.zzc();
                int i10 = this.f7806d;
                zzjtVarZzc.zza(i10 > 0);
                zzjtVarZzc.zzl(i10);
                zzhvVarZzc.zzo(zzjtVarZzc);
                p1Var.b((zzhx) zzhvVarZzc.zze());
            } else {
                dVar.f7609h.c(zzij.zzd());
            }
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
        d dVar2 = this.f7807e;
        synchronized (dVar2.f7602a) {
            if (dVar2.f7603b != 3 && dVar2.f7603b != 0) {
                dVar2.K(0);
                dVar2.N();
                try {
                    this.f7803a.onBillingServiceDisconnected();
                } catch (Throwable th2) {
                    zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzc.zzm("BillingClient", "Billing service connected.");
        d dVar = this.f7807e;
        synchronized (dVar.f7602a) {
            try {
                if (dVar.f7603b == 3) {
                    return;
                }
                dVar.f7610i = zzal.zzs(iBinder);
                if (d.o(new Callable() { // from class: d3.t0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        v0.a(this.f7796a);
                        return null;
                    }
                }, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, new Runnable() { // from class: d3.u0
                    @Override // java.lang.Runnable
                    public final void run() {
                        v0.b(this.f7799a);
                    }
                }, dVar.f0(), dVar.n()) == null) {
                    int i10 = this.f7806d;
                    com.android.billingclient.api.a aVarI0 = dVar.i0();
                    dVar.J(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, aVarI0, i10);
                    g(aVarI0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzc.zzn("BillingClient", "Billing service disconnected.");
        try {
            d dVar = this.f7807e;
            if (d.a0(dVar)) {
                p1 p1Var = dVar.f7609h;
                zzhv zzhvVarZzc = zzhx.zzc();
                zzhvVarZzc.zzp(6);
                zzic zzicVarZzc = zzig.zzc();
                zzicVarZzc.zzn(zzie.SERVICE_DISCONNECTED);
                zzhvVarZzc.zzl(zzicVarZzc);
                zzjt zzjtVarZzc = zzjv.zzc();
                int i10 = this.f7806d;
                zzjtVarZzc.zza(i10 > 0);
                zzjtVarZzc.zzl(i10);
                zzhvVarZzc.zzo(zzjtVarZzc);
                p1Var.b((zzhx) zzhvVarZzc.zze());
            } else {
                dVar.f7609h.i(zzjs.zzd());
            }
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
        zzbi zzbiVar = this.f7805c;
        zzbiVar.zzd();
        zzbiVar.zze();
        d dVar2 = this.f7807e;
        synchronized (dVar2.f7602a) {
            try {
                if (dVar2.f7603b == 3) {
                    return;
                }
                dVar2.K(0);
                try {
                    this.f7803a.onBillingServiceDisconnected();
                } catch (Throwable th2) {
                    zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                }
            } finally {
            }
        }
    }
}
