package d3;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.google.android.gms.internal.play_billing.zzau;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzcu;
import com.google.android.gms.internal.play_billing.zzcz;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;
import com.google.android.gms.internal.play_billing.zzp;
import com.google.android.gms.internal.play_billing.zzr;
import com.google.android.gms.internal.play_billing.zzu;
import d3.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 extends d {
    public final Context K;
    public volatile int L;
    public volatile zzau M;
    public volatile k1 N;
    public volatile ScheduledExecutorService O;

    public m1(String str, Context context, p1 p1Var, ExecutorService executorService, c.a aVar) {
        super(null, context, null, null, aVar);
        this.L = 0;
        this.K = context;
    }

    public static final boolean Y0(int i10) {
        return i10 > 0;
    }

    public static /* synthetic */ Object o1(m1 m1Var, int i10, zzp zzpVar) {
        try {
            if (m1Var.M == null) {
                throw null;
            }
            m1Var.M.zza(m1Var.K.getPackageName(), i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? i10 != 6 ? "QUERY_PRODUCT_DETAILS_ASYNC" : "START_CONNECTION" : "IS_FEATURE_SUPPORTED" : "CONSUME_ASYNC" : "ACKNOWLEDGE_PURCHASE" : "LAUNCH_BILLING_FLOW", new j1(zzpVar));
            return "billingOverrideService.getBillingOverride";
        } catch (Exception e10) {
            m1Var.b1(zzie.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, com.android.billingclient.api.c.F);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", e10);
            zzpVar.zzb(0);
            return "billingOverrideService.getBillingOverride";
        }
    }

    public final synchronized void W0() {
        c1(27);
        try {
            try {
                l1 l1Var = null;
                if (this.N != null && this.M != null) {
                    zzc.zzm("BillingClientTesting", "Unbinding from Billing Override Service.");
                    this.K.unbindService(this.N);
                    this.N = new k1(this, l1Var);
                }
                this.M = null;
                if (this.O != null) {
                    this.O.shutdownNow();
                    this.O = null;
                }
            } catch (RuntimeException e10) {
                zzc.zzo("BillingClientTesting", "There was an exception while ending Billing Override Service connection!", e10);
            }
            this.L = 3;
        } catch (Throwable th) {
            this.L = 3;
            throw th;
        }
    }

    public final synchronized void X0() {
        if (m1()) {
            zzc.zzm("BillingClientTesting", "Billing Override Service connection is valid. No need to re-initialize.");
            c1(26);
            return;
        }
        if (this.L == 1) {
            zzc.zzn("BillingClientTesting", "Client is already in the process of connecting to Billing Override Service.");
            return;
        }
        if (this.L == 3) {
            zzc.zzn("BillingClientTesting", "Billing Override Service Client was already closed and can't be reused. Please create another instance.");
            b1(zzie.BILLING_CLIENT_CLOSED, 26, com.android.billingclient.api.c.a(-1, "Billing Override Service connection is disconnected."));
            return;
        }
        this.L = 1;
        zzc.zzm("BillingClientTesting", "Starting Billing Override Service setup.");
        this.N = new k1(this, null);
        Intent intent = new Intent("com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND");
        intent.setPackage("com.google.android.apps.play.billingtestcompanion");
        Context context = this.K;
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        zzie zzieVar = zzie.REASON_UNSPECIFIED;
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            zzieVar = zzie.INTENT_SERVICE_NOT_FOUND;
        } else {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!Objects.equals(str, "com.google.android.apps.play.billingtestcompanion") || str2 == null) {
                    zzieVar = zzie.BILLING_SERVICE_BLOCKED;
                    zzc.zzn("BillingClientTesting", "The device doesn't have valid Play Billing Lab.");
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    if (context.bindService(intent2, this.N, 1)) {
                        zzc.zzm("BillingClientTesting", "Billing Override Service was bonded successfully.");
                        return;
                    } else {
                        zzieVar = zzie.BILLING_SERVICE_BLOCKED;
                        zzc.zzn("BillingClientTesting", "Connection to Billing Override Service is blocked.");
                    }
                }
            }
        }
        this.L = 0;
        zzc.zzm("BillingClientTesting", "Billing Override Service unavailable on device.");
        b1(zzieVar, 26, com.android.billingclient.api.c.a(2, "Billing Override Service unavailable on device."));
    }

    public final com.android.billingclient.api.a Z0(int i10, int i11) {
        com.android.billingclient.api.a aVarA = com.android.billingclient.api.c.a(i11, "Billing override value was set by a license tester.");
        b1(zzie.LICENSE_TESTER_BILLING_OVERRIDE, i10, aVarA);
        return aVarA;
    }

    @Override // d3.d, d3.c
    public final void a(final a aVar, final b bVar) {
        Objects.requireNonNull(bVar);
        d1(3, new s0.a() { // from class: d3.e1
            @Override // s0.a
            public final void accept(Object obj) {
                bVar.a((com.android.billingclient.api.a) obj);
            }
        }, new Runnable() { // from class: d3.f1
            @Override // java.lang.Runnable
            public final void run() {
                super/*d3.d*/.a(aVar, bVar);
            }
        });
    }

    public final zzcz a1(final int i10) {
        if (m1()) {
            return zzu.zza(new zzr() { // from class: d3.d1
                @Override // com.google.android.gms.internal.play_billing.zzr
                public final Object zza(zzp zzpVar) {
                    return m1.o1(this.f7630a, i10, zzpVar);
                }
            });
        }
        zzc.zzn("BillingClientTesting", "Billing Override Service is not ready.");
        b1(zzie.BILLING_OVERRIDE_SERVICE_CONNECTION_NOT_READY, 28, com.android.billingclient.api.c.a(-1, "Billing Override Service connection is disconnected."));
        return zzcu.zza(0);
    }

    @Override // d3.d, d3.c
    public final void b(final i iVar, final j jVar) {
        d1(4, new s0.a() { // from class: d3.b1
            @Override // s0.a
            public final void accept(Object obj) {
                jVar.a((com.android.billingclient.api.a) obj, iVar.a());
            }
        }, new Runnable() { // from class: d3.c1
            @Override // java.lang.Runnable
            public final void run() {
                super/*d3.d*/.b(iVar, jVar);
            }
        });
    }

    public final void b1(zzie zzieVar, int i10, com.android.billingclient.api.a aVar) {
        int i11 = o1.f7730a;
        zzhx zzhxVarB = o1.b(zzieVar, i10, aVar, null, zzil.BROADCAST_ACTION_UNSPECIFIED);
        Objects.requireNonNull(zzhxVarB, "ApiFailure should not be null");
        G0().b(zzhxVarB);
    }

    @Override // d3.d, d3.c
    public final void c() {
        W0();
        super.c();
    }

    public final void c1(int i10) {
        int i11 = o1.f7730a;
        zzib zzibVarC = o1.c(i10, zzil.BROADCAST_ACTION_UNSPECIFIED);
        Objects.requireNonNull(zzibVarC, "ApiSuccess should not be null");
        G0().h(zzibVarC);
    }

    public final void d1(int i10, s0.a aVar, Runnable runnable) {
        zzcu.zzc(zzcu.zzb(a1(i10), 28500L, TimeUnit.MILLISECONDS, s1()), new i1(this, i10, aVar, runnable), n());
    }

    @Override // d3.d, d3.c
    public final com.android.billingclient.api.a g(final Activity activity, final h hVar) {
        s0.a aVar = new s0.a() { // from class: d3.g1
            @Override // s0.a
            public final void accept(Object obj) {
                super/*d3.d*/.J0((com.android.billingclient.api.a) obj);
            }
        };
        Callable callable = new Callable() { // from class: d3.h1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return super/*d3.d*/.g(activity, hVar);
            }
        };
        int iR1 = r1(a1(2));
        if (Y0(iR1)) {
            com.android.billingclient.api.a aVarZ0 = Z0(2, iR1);
            aVar.accept(aVarZ0);
            return aVarZ0;
        }
        try {
            return (com.android.billingclient.api.a) callable.call();
        } catch (Exception e10) {
            zzie zzieVar = zzie.BILLING_OVERRIDE_SERVICE_FALLBACK_ERROR;
            com.android.billingclient.api.a aVar2 = com.android.billingclient.api.c.f5154h;
            b1(zzieVar, 2, aVar2);
            zzc.zzo("BillingClientTesting", "An internal error occurred.", e10);
            return aVar2;
        }
    }

    @Override // d3.d, d3.c
    public final void i(final t tVar, final q qVar) {
        d1(7, new s0.a() { // from class: d3.z0
            @Override // s0.a
            public final void accept(Object obj) {
                u uVar = new u(new ArrayList(), new ArrayList());
                qVar.a((com.android.billingclient.api.a) obj, uVar);
            }
        }, new Runnable() { // from class: d3.a1
            @Override // java.lang.Runnable
            public final void run() {
                super/*d3.d*/.i(tVar, qVar);
            }
        });
    }

    @Override // d3.d, d3.c
    public final void l(e eVar) {
        X0();
        super.l(eVar);
    }

    public final synchronized boolean m1() {
        if (this.L == 2 && this.M != null) {
            if (this.N != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int r1(zzcz zzczVar) {
        try {
            return ((Integer) zzczVar.get(28500L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException e10) {
            b1(zzie.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT, 28, com.android.billingclient.api.c.F);
            zzc.zzo("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", e10);
            return 0;
        } catch (Exception e11) {
            if (e11 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            b1(zzie.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, com.android.billingclient.api.c.F);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", e11);
            return 0;
        }
    }

    public final synchronized ScheduledExecutorService s1() {
        try {
            if (this.O == null) {
                this.O = Executors.newSingleThreadScheduledExecutor();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.O;
    }

    public m1(String str, o oVar, Context context, v1 v1Var, p1 p1Var, ExecutorService executorService, c.a aVar) {
        super(null, oVar, context, null, null, null, aVar);
        this.L = 0;
        this.K = context;
    }

    public m1(String str, o oVar, Context context, s sVar, p0 p0Var, p1 p1Var, ExecutorService executorService, c.a aVar) {
        super(null, oVar, context, sVar, null, null, null, aVar);
        this.L = 0;
        this.K = context;
    }
}
