package com.android.billingclient.api;

import H0.AbstractC0293a0;
import H0.AbstractC0301e0;
import H0.C0292a;
import H0.C0302f;
import H0.I;
import H0.InterfaceC0294b;
import H0.InterfaceC0296c;
import H0.InterfaceC0303f0;
import H0.InterfaceC0304g;
import H0.InterfaceC0310l;
import H0.InterfaceC0313o;
import H0.T;
import H0.X;
import H0.Y;
import H0.Z;
import H0.l0;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.google.android.gms.internal.play_billing.zzav;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzel;
import com.google.android.gms.internal.play_billing.zzeu;
import com.google.android.gms.internal.play_billing.zzew;
import com.google.android.gms.internal.play_billing.zzfb;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzr;
import com.google.android.gms.internal.play_billing.zzv;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class j extends b {

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final Context f9485G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public volatile int f9486H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public volatile zzav f9487I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public volatile Z f9488J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public volatile zzew f9489K;

    public j(String str, Context context, InterfaceC0303f0 interfaceC0303f0, ExecutorService executorService) {
        super(null, context, null, null);
        this.f9486H = 0;
        this.f9485G = context;
    }

    public static final boolean l1(int i4) {
        return i4 > 0;
    }

    public final /* synthetic */ void X0(C0292a c0292a, InterfaceC0294b interfaceC0294b) {
        super.a(c0292a, interfaceC0294b);
    }

    public final /* synthetic */ void Y0(C0302f c0302f, InterfaceC0304g interfaceC0304g) {
        super.b(c0302f, interfaceC0304g);
    }

    public final /* synthetic */ void Z0(d dVar) {
        super.N0(dVar);
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final void a(final C0292a c0292a, final InterfaceC0294b interfaceC0294b) {
        Objects.requireNonNull(interfaceC0294b);
        q1(3, new Consumer() { // from class: H0.U
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                interfaceC0294b.a((com.android.billingclient.api.d) obj);
            }
        }, new Runnable() { // from class: H0.V
            @Override // java.lang.Runnable
            public final void run() {
                this.f649a.X0(c0292a, interfaceC0294b);
            }
        });
    }

    public final /* synthetic */ void a1(g gVar, InterfaceC0310l interfaceC0310l) {
        super.i(gVar, interfaceC0310l);
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final void b(final C0302f c0302f, final InterfaceC0304g interfaceC0304g) {
        q1(4, new Consumer() { // from class: H0.Q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                interfaceC0304g.a((com.android.billingclient.api.d) obj, c0302f.a());
            }
        }, new Runnable() { // from class: H0.S
            @Override // java.lang.Runnable
            public final void run() {
                this.f643a.Y0(c0302f, interfaceC0304g);
            }
        });
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final void c() {
        j1();
        super.c();
    }

    public final synchronized boolean c1() {
        if (this.f9486H == 2 && this.f9487I != null) {
            if (this.f9488J != null) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Object e1(int i4, zzr zzrVar) {
        String str;
        try {
            if (this.f9487I == null) {
                throw null;
            }
            zzav zzavVar = this.f9487I;
            String packageName = this.f9485G.getPackageName();
            switch (i4) {
                case 2:
                    str = "LAUNCH_BILLING_FLOW";
                    break;
                case 3:
                    str = "ACKNOWLEDGE_PURCHASE";
                    break;
                case 4:
                    str = "CONSUME_ASYNC";
                    break;
                case 5:
                    str = "IS_FEATURE_SUPPORTED";
                    break;
                case 6:
                    str = "START_CONNECTION";
                    break;
                case 7:
                    str = "QUERY_PRODUCT_DETAILS_ASYNC";
                    break;
                default:
                    str = "QUERY_SKU_DETAILS_ASYNC";
                    break;
            }
            zzavVar.zza(packageName, str, new Y(zzrVar));
            return "billingOverrideService.getBillingOverride";
        } catch (Exception e4) {
            o1(107, 28, k.f9496G);
            zze.zzm("BillingClientTesting", "An error occurred while retrieving billing override.", e4);
            zzrVar.zzb(0);
            return "billingOverrideService.getBillingOverride";
        }
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final d g(final Activity activity, final c cVar) {
        Consumer consumer = new Consumer() { // from class: H0.W
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f652a.Z0((com.android.billingclient.api.d) obj);
            }
        };
        Callable callable = new Callable() { // from class: H0.O
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f635a.r1(activity, cVar);
            }
        };
        int iH1 = h1(n1(2));
        if (l1(iH1)) {
            d dVarM1 = m1(2, iH1);
            consumer.accept(dVarM1);
            return dVarM1;
        }
        try {
            return (d) callable.call();
        } catch (Exception e4) {
            d dVar = k.f9507k;
            o1(115, 2, dVar);
            zze.zzm("BillingClientTesting", "An internal error occurred.", e4);
            return dVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int h1(zzeu zzeuVar) {
        try {
            return ((Integer) zzeuVar.get(28500L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException e4) {
            o1(114, 28, k.f9496G);
            zze.zzm("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", e4);
            return 0;
        } catch (Exception e5) {
            if (e5 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            o1(107, 28, k.f9496G);
            zze.zzm("BillingClientTesting", "An error occurred while retrieving billing override.", e5);
            return 0;
        }
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final void i(final g gVar, final InterfaceC0310l interfaceC0310l) {
        q1(7, new Consumer() { // from class: H0.N
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ArrayList arrayList = new ArrayList();
                interfaceC0310l.a((com.android.billingclient.api.d) obj, arrayList);
            }
        }, new Runnable() { // from class: H0.P
            @Override // java.lang.Runnable
            public final void run() {
                this.f638a.a1(gVar, interfaceC0310l);
            }
        });
    }

    public final synchronized zzew i1() {
        try {
            if (this.f9489K == null) {
                this.f9489K = zzfb.zzb(Executors.newSingleThreadScheduledExecutor());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9489K;
    }

    public final synchronized void j1() {
        p1(27);
        try {
            try {
                AbstractC0293a0 abstractC0293a0 = null;
                if (this.f9488J != null && this.f9487I != null) {
                    zze.zzk("BillingClientTesting", "Unbinding from Billing Override Service.");
                    this.f9485G.unbindService(this.f9488J);
                    this.f9488J = new Z(this, abstractC0293a0);
                }
                this.f9487I = null;
                if (this.f9489K != null) {
                    this.f9489K.shutdownNow();
                    this.f9489K = null;
                }
            } catch (RuntimeException e4) {
                zze.zzm("BillingClientTesting", "There was an exception while ending Billing Override Service connection!", e4);
            }
            this.f9486H = 3;
        } catch (Throwable th) {
            this.f9486H = 3;
            throw th;
        }
    }

    public final synchronized void k1() {
        if (c1()) {
            zze.zzk("BillingClientTesting", "Billing Override Service connection is valid. No need to re-initialize.");
            p1(26);
            return;
        }
        int i4 = 1;
        if (this.f9486H == 1) {
            zze.zzl("BillingClientTesting", "Client is already in the process of connecting to Billing Override Service.");
            return;
        }
        if (this.f9486H == 3) {
            zze.zzl("BillingClientTesting", "Billing Override Service Client was already closed and can't be reused. Please create another instance.");
            o1(38, 26, k.a(-1, "Billing Override Service connection is disconnected."));
            return;
        }
        this.f9486H = 1;
        zze.zzk("BillingClientTesting", "Starting Billing Override Service setup.");
        this.f9488J = new Z(this, null);
        Intent intent = new Intent("com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND");
        intent.setPackage("com.google.android.apps.play.billingtestcompanion");
        List<ResolveInfo> listQueryIntentServices = this.f9485G.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            i4 = 41;
        } else {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!Objects.equals(str, "com.google.android.apps.play.billingtestcompanion") || str2 == null) {
                    zze.zzl("BillingClientTesting", "The device doesn't have valid Play Billing Lab.");
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    if (this.f9485G.bindService(intent2, this.f9488J, 1)) {
                        zze.zzk("BillingClientTesting", "Billing Override Service was bonded successfully.");
                        return;
                    }
                    zze.zzl("BillingClientTesting", "Connection to Billing Override Service is blocked.");
                }
                i4 = 39;
            }
        }
        this.f9486H = 0;
        zze.zzk("BillingClientTesting", "Billing Override Service unavailable on device.");
        o1(i4, 26, k.a(2, "Billing Override Service unavailable on device."));
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final void m(InterfaceC0296c interfaceC0296c) {
        k1();
        super.m(interfaceC0296c);
    }

    public final d m1(int i4, int i5) {
        d dVarA = k.a(i5, "Billing override value was set by a license tester.");
        o1(105, i4, dVarA);
        return dVarA;
    }

    public final zzeu n1(int i4) {
        if (c1()) {
            return zzv.zza(new T(this, i4));
        }
        zze.zzl("BillingClientTesting", "Billing Override Service is not ready.");
        o1(106, 28, k.a(-1, "Billing Override Service connection is disconnected."));
        return zzel.zza(0);
    }

    public final void o1(int i4, int i5, d dVar) {
        zzjz zzjzVarB = AbstractC0301e0.b(i4, i5, dVar);
        Objects.requireNonNull(zzjzVarB, "ApiFailure should not be null");
        L0().d(zzjzVarB);
    }

    public final void p1(int i4) {
        zzkd zzkdVarD = AbstractC0301e0.d(i4);
        Objects.requireNonNull(zzkdVarD, "ApiSuccess should not be null");
        L0().g(zzkdVarD);
    }

    public final void q1(int i4, Consumer consumer, Runnable runnable) {
        zzel.zzc(zzel.zzb(n1(i4), 28500L, TimeUnit.MILLISECONDS, i1()), new X(this, i4, consumer, runnable), P0());
    }

    public final /* synthetic */ d r1(Activity activity, c cVar) {
        return super.g(activity, cVar);
    }

    public j(String str, e eVar, Context context, l0 l0Var, InterfaceC0303f0 interfaceC0303f0, ExecutorService executorService) {
        super(null, eVar, context, null, null, null);
        this.f9486H = 0;
        this.f9485G = context;
    }

    public j(String str, e eVar, Context context, InterfaceC0313o interfaceC0313o, I i4, InterfaceC0303f0 interfaceC0303f0, ExecutorService executorService) {
        super(null, eVar, context, interfaceC0313o, null, null, null);
        this.f9486H = 0;
        this.f9485G = context;
    }
}
