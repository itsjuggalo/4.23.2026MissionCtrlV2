package com.android.billingclient.api;

import Y0.AbstractC0714a0;
import Y0.AbstractC0722e0;
import Y0.C0713a;
import Y0.C0723f;
import Y0.I;
import Y0.InterfaceC0715b;
import Y0.InterfaceC0717c;
import Y0.InterfaceC0724f0;
import Y0.InterfaceC0725g;
import Y0.InterfaceC0731l;
import Y0.InterfaceC0734o;
import Y0.T;
import Y0.X;
import Y0.Y;
import Y0.Z;
import Y0.l0;
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
    public final Context f10670G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public volatile int f10671H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public volatile zzav f10672I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public volatile Z f10673J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public volatile zzew f10674K;

    public j(String str, Context context, InterfaceC0724f0 interfaceC0724f0, ExecutorService executorService) {
        super(null, context, null, null);
        this.f10671H = 0;
        this.f10670G = context;
    }

    public static final boolean l1(int i7) {
        return i7 > 0;
    }

    public final /* synthetic */ void X0(C0713a c0713a, InterfaceC0715b interfaceC0715b) {
        super.a(c0713a, interfaceC0715b);
    }

    public final /* synthetic */ void Y0(C0723f c0723f, InterfaceC0725g interfaceC0725g) {
        super.b(c0723f, interfaceC0725g);
    }

    public final /* synthetic */ void Z0(d dVar) {
        super.N0(dVar);
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final void a(final C0713a c0713a, final InterfaceC0715b interfaceC0715b) {
        Objects.requireNonNull(interfaceC0715b);
        q1(3, new Consumer() { // from class: Y0.U
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                interfaceC0715b.a((com.android.billingclient.api.d) obj);
            }
        }, new Runnable() { // from class: Y0.V
            @Override // java.lang.Runnable
            public final void run() {
                this.f5576a.X0(c0713a, interfaceC0715b);
            }
        });
    }

    public final /* synthetic */ void a1(g gVar, InterfaceC0731l interfaceC0731l) {
        super.i(gVar, interfaceC0731l);
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final void b(final C0723f c0723f, final InterfaceC0725g interfaceC0725g) {
        q1(4, new Consumer() { // from class: Y0.Q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                interfaceC0725g.a((com.android.billingclient.api.d) obj, c0723f.a());
            }
        }, new Runnable() { // from class: Y0.S
            @Override // java.lang.Runnable
            public final void run() {
                this.f5570a.Y0(c0723f, interfaceC0725g);
            }
        });
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final void c() {
        j1();
        super.c();
    }

    public final synchronized boolean c1() {
        if (this.f10671H == 2 && this.f10672I != null) {
            if (this.f10673J != null) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Object e1(int i7, zzr zzrVar) {
        String str;
        try {
            if (this.f10672I == null) {
                throw null;
            }
            zzav zzavVar = this.f10672I;
            String packageName = this.f10670G.getPackageName();
            switch (i7) {
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
        } catch (Exception e7) {
            o1(107, 28, k.f10681G);
            zze.zzm("BillingClientTesting", "An error occurred while retrieving billing override.", e7);
            zzrVar.zzb(0);
            return "billingOverrideService.getBillingOverride";
        }
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final d g(final Activity activity, final c cVar) {
        Consumer consumer = new Consumer() { // from class: Y0.W
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f5579a.Z0((com.android.billingclient.api.d) obj);
            }
        };
        Callable callable = new Callable() { // from class: Y0.O
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5562a.r1(activity, cVar);
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
        } catch (Exception e7) {
            d dVar = k.f10692k;
            o1(115, 2, dVar);
            zze.zzm("BillingClientTesting", "An internal error occurred.", e7);
            return dVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int h1(zzeu zzeuVar) {
        try {
            return ((Integer) zzeuVar.get(28500L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException e7) {
            o1(114, 28, k.f10681G);
            zze.zzm("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", e7);
            return 0;
        } catch (Exception e8) {
            if (e8 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            o1(107, 28, k.f10681G);
            zze.zzm("BillingClientTesting", "An error occurred while retrieving billing override.", e8);
            return 0;
        }
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final void i(final g gVar, final InterfaceC0731l interfaceC0731l) {
        q1(7, new Consumer() { // from class: Y0.N
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ArrayList arrayList = new ArrayList();
                interfaceC0731l.a((com.android.billingclient.api.d) obj, arrayList);
            }
        }, new Runnable() { // from class: Y0.P
            @Override // java.lang.Runnable
            public final void run() {
                this.f5565a.a1(gVar, interfaceC0731l);
            }
        });
    }

    public final synchronized zzew i1() {
        try {
            if (this.f10674K == null) {
                this.f10674K = zzfb.zzb(Executors.newSingleThreadScheduledExecutor());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10674K;
    }

    public final synchronized void j1() {
        p1(27);
        try {
            try {
                AbstractC0714a0 abstractC0714a0 = null;
                if (this.f10673J != null && this.f10672I != null) {
                    zze.zzk("BillingClientTesting", "Unbinding from Billing Override Service.");
                    this.f10670G.unbindService(this.f10673J);
                    this.f10673J = new Z(this, abstractC0714a0);
                }
                this.f10672I = null;
                if (this.f10674K != null) {
                    this.f10674K.shutdownNow();
                    this.f10674K = null;
                }
            } catch (RuntimeException e7) {
                zze.zzm("BillingClientTesting", "There was an exception while ending Billing Override Service connection!", e7);
            }
            this.f10671H = 3;
        } catch (Throwable th) {
            this.f10671H = 3;
            throw th;
        }
    }

    public final synchronized void k1() {
        if (c1()) {
            zze.zzk("BillingClientTesting", "Billing Override Service connection is valid. No need to re-initialize.");
            p1(26);
            return;
        }
        int i7 = 1;
        if (this.f10671H == 1) {
            zze.zzl("BillingClientTesting", "Client is already in the process of connecting to Billing Override Service.");
            return;
        }
        if (this.f10671H == 3) {
            zze.zzl("BillingClientTesting", "Billing Override Service Client was already closed and can't be reused. Please create another instance.");
            o1(38, 26, k.a(-1, "Billing Override Service connection is disconnected."));
            return;
        }
        this.f10671H = 1;
        zze.zzk("BillingClientTesting", "Starting Billing Override Service setup.");
        this.f10673J = new Z(this, null);
        Intent intent = new Intent("com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND");
        intent.setPackage("com.google.android.apps.play.billingtestcompanion");
        List<ResolveInfo> listQueryIntentServices = this.f10670G.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            i7 = 41;
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
                    if (this.f10670G.bindService(intent2, this.f10673J, 1)) {
                        zze.zzk("BillingClientTesting", "Billing Override Service was bonded successfully.");
                        return;
                    }
                    zze.zzl("BillingClientTesting", "Connection to Billing Override Service is blocked.");
                }
                i7 = 39;
            }
        }
        this.f10671H = 0;
        zze.zzk("BillingClientTesting", "Billing Override Service unavailable on device.");
        o1(i7, 26, k.a(2, "Billing Override Service unavailable on device."));
    }

    @Override // com.android.billingclient.api.b, com.android.billingclient.api.a
    public final void m(InterfaceC0717c interfaceC0717c) {
        k1();
        super.m(interfaceC0717c);
    }

    public final d m1(int i7, int i8) {
        d dVarA = k.a(i8, "Billing override value was set by a license tester.");
        o1(105, i7, dVarA);
        return dVarA;
    }

    public final zzeu n1(int i7) {
        if (c1()) {
            return zzv.zza(new T(this, i7));
        }
        zze.zzl("BillingClientTesting", "Billing Override Service is not ready.");
        o1(106, 28, k.a(-1, "Billing Override Service connection is disconnected."));
        return zzel.zza(0);
    }

    public final void o1(int i7, int i8, d dVar) {
        zzjz zzjzVarB = AbstractC0722e0.b(i7, i8, dVar);
        Objects.requireNonNull(zzjzVarB, "ApiFailure should not be null");
        L0().d(zzjzVarB);
    }

    public final void p1(int i7) {
        zzkd zzkdVarD = AbstractC0722e0.d(i7);
        Objects.requireNonNull(zzkdVarD, "ApiSuccess should not be null");
        L0().g(zzkdVarD);
    }

    public final void q1(int i7, Consumer consumer, Runnable runnable) {
        zzel.zzc(zzel.zzb(n1(i7), 28500L, TimeUnit.MILLISECONDS, i1()), new X(this, i7, consumer, runnable), P0());
    }

    public final /* synthetic */ d r1(Activity activity, c cVar) {
        return super.g(activity, cVar);
    }

    public j(String str, e eVar, Context context, l0 l0Var, InterfaceC0724f0 interfaceC0724f0, ExecutorService executorService) {
        super(null, eVar, context, null, null, null);
        this.f10671H = 0;
        this.f10670G = context;
    }

    public j(String str, e eVar, Context context, InterfaceC0734o interfaceC0734o, I i7, InterfaceC0724f0 interfaceC0724f0, ExecutorService executorService) {
        super(null, eVar, context, interfaceC0734o, null, null, null);
        this.f10671H = 0;
        this.f10670G = context;
    }
}
