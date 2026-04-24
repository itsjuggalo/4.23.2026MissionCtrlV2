package R0;

import R0.AbstractC0806c;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.google.android.gms.internal.play_billing.InterfaceC1371n;
import com.google.android.gms.internal.play_billing.J2;
import com.google.android.gms.internal.play_billing.O2;
import com.google.android.gms.internal.play_billing.O3;
import com.google.android.gms.internal.play_billing.Q3;
import com.google.android.gms.internal.play_billing.R2;
import com.google.android.gms.internal.play_billing.T3;
import com.google.android.gms.internal.play_billing.Y2;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: R0.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0831o0 extends C0810e {

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final Context f7010K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public volatile int f7011L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public volatile InterfaceC1371n f7012M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public volatile ServiceConnectionC0827m0 f7013N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public volatile ScheduledExecutorService f7014O;

    public C0831o0(String str, C0832p c0832p, Context context, InterfaceC0837t interfaceC0837t, Q q8, r0 r0Var, ExecutorService executorService, AbstractC0806c.a aVar) {
        super(null, c0832p, context, interfaceC0837t, null, null, null, aVar);
        this.f7011L = 0;
        this.f7010K = context;
    }

    public static final boolean Y0(int i8) {
        return i8 > 0;
    }

    public static /* synthetic */ Object o1(C0831o0 c0831o0, int i8, O3 o32) {
        try {
            if (c0831o0.f7012M == null) {
                throw null;
            }
            c0831o0.f7012M.u(c0831o0.f7010K.getPackageName(), i8 != 2 ? i8 != 3 ? i8 != 4 ? i8 != 5 ? i8 != 6 ? "QUERY_PRODUCT_DETAILS_ASYNC" : "START_CONNECTION" : "IS_FEATURE_SUPPORTED" : "CONSUME_ASYNC" : "ACKNOWLEDGE_PURCHASE" : "LAUNCH_BILLING_FLOW", new BinderC0825l0(o32));
            return "billingOverrideService.getBillingOverride";
        } catch (Exception e8) {
            c0831o0.b1(R2.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, com.android.billingclient.api.c.f14683F);
            com.google.android.gms.internal.play_billing.V.n("BillingClientTesting", "An error occurred while retrieving billing override.", e8);
            o32.b(0);
            return "billingOverrideService.getBillingOverride";
        }
    }

    public final synchronized void W0() {
        c1(27);
        try {
            try {
                AbstractC0829n0 abstractC0829n0 = null;
                if (this.f7013N != null && this.f7012M != null) {
                    com.google.android.gms.internal.play_billing.V.l("BillingClientTesting", "Unbinding from Billing Override Service.");
                    this.f7010K.unbindService(this.f7013N);
                    this.f7013N = new ServiceConnectionC0827m0(this, abstractC0829n0);
                }
                this.f7012M = null;
                if (this.f7014O != null) {
                    this.f7014O.shutdownNow();
                    this.f7014O = null;
                }
            } catch (RuntimeException e8) {
                com.google.android.gms.internal.play_billing.V.n("BillingClientTesting", "There was an exception while ending Billing Override Service connection!", e8);
            }
            this.f7011L = 3;
        } catch (Throwable th) {
            this.f7011L = 3;
            throw th;
        }
    }

    public final synchronized void X0() {
        String str;
        String str2;
        if (m1()) {
            com.google.android.gms.internal.play_billing.V.l("BillingClientTesting", "Billing Override Service connection is valid. No need to re-initialize.");
            c1(26);
            return;
        }
        if (this.f7011L == 1) {
            com.google.android.gms.internal.play_billing.V.m("BillingClientTesting", "Client is already in the process of connecting to Billing Override Service.");
            return;
        }
        if (this.f7011L == 3) {
            com.google.android.gms.internal.play_billing.V.m("BillingClientTesting", "Billing Override Service Client was already closed and can't be reused. Please create another instance.");
            b1(R2.BILLING_CLIENT_CLOSED, 26, com.android.billingclient.api.c.a(-1, "Billing Override Service connection is disconnected."));
            return;
        }
        this.f7011L = 1;
        com.google.android.gms.internal.play_billing.V.l("BillingClientTesting", "Starting Billing Override Service setup.");
        this.f7013N = new ServiceConnectionC0827m0(this, null);
        Intent intent = new Intent("com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND");
        intent.setPackage("com.google.android.apps.play.billingtestcompanion");
        Context context = this.f7010K;
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        R2 r22 = R2.REASON_UNSPECIFIED;
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            r22 = R2.INTENT_SERVICE_NOT_FOUND;
        } else {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str3 = serviceInfo.packageName;
                String str4 = serviceInfo.name;
                if (!Objects.equals(str3, "com.google.android.apps.play.billingtestcompanion") || str4 == null) {
                    str = "BillingClientTesting";
                    str2 = "The device doesn't have valid Play Billing Lab.";
                    r22 = R2.BILLING_SERVICE_BLOCKED;
                } else {
                    ComponentName componentName = new ComponentName(str3, str4);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    if (context.bindService(intent2, this.f7013N, 1)) {
                        com.google.android.gms.internal.play_billing.V.l("BillingClientTesting", "Billing Override Service was bonded successfully.");
                        return;
                    } else {
                        str = "BillingClientTesting";
                        str2 = "Connection to Billing Override Service is blocked.";
                        r22 = R2.BILLING_SERVICE_BLOCKED;
                    }
                }
                com.google.android.gms.internal.play_billing.V.m(str, str2);
            }
        }
        this.f7011L = 0;
        com.google.android.gms.internal.play_billing.V.l("BillingClientTesting", "Billing Override Service unavailable on device.");
        b1(r22, 26, com.android.billingclient.api.c.a(2, "Billing Override Service unavailable on device."));
    }

    public final com.android.billingclient.api.a Z0(int i8, int i9) {
        com.android.billingclient.api.a aVarA = com.android.billingclient.api.c.a(i9, "Billing override value was set by a license tester.");
        b1(R2.LICENSE_TESTER_BILLING_OVERRIDE, i8, aVarA);
        return aVarA;
    }

    @Override // R0.C0810e, R0.AbstractC0806c
    public final void a(final C0802a c0802a, final InterfaceC0804b interfaceC0804b) {
        Objects.requireNonNull(interfaceC0804b);
        d1(3, new S.a() { // from class: R0.g0
            @Override // S.a
            public final void accept(Object obj) {
                interfaceC0804b.a((com.android.billingclient.api.a) obj);
            }
        }, new Runnable() { // from class: R0.h0
            @Override // java.lang.Runnable
            public final void run() {
                super/*R0.e*/.a(c0802a, interfaceC0804b);
            }
        });
    }

    public final com.google.android.gms.internal.play_billing.G0 a1(final int i8) {
        if (m1()) {
            return T3.a(new Q3() { // from class: R0.f0
                @Override // com.google.android.gms.internal.play_billing.Q3
                public final Object a(O3 o32) {
                    return C0831o0.o1(this.f6963a, i8, o32);
                }
            });
        }
        com.google.android.gms.internal.play_billing.V.m("BillingClientTesting", "Billing Override Service is not ready.");
        b1(R2.BILLING_OVERRIDE_SERVICE_CONNECTION_NOT_READY, 28, com.android.billingclient.api.c.a(-1, "Billing Override Service connection is disconnected."));
        return com.google.android.gms.internal.play_billing.B0.a(0);
    }

    @Override // R0.C0810e, R0.AbstractC0806c
    public final void b(final C0820j c0820j, final InterfaceC0822k interfaceC0822k) {
        d1(4, new S.a() { // from class: R0.d0
            @Override // S.a
            public final void accept(Object obj) {
                interfaceC0822k.a((com.android.billingclient.api.a) obj, c0820j.a());
            }
        }, new Runnable() { // from class: R0.e0
            @Override // java.lang.Runnable
            public final void run() {
                super/*R0.e*/.b(c0820j, interfaceC0822k);
            }
        });
    }

    public final void b1(R2 r22, int i8, com.android.billingclient.api.a aVar) {
        int i9 = AbstractC0835q0.f7070a;
        J2 j2B = AbstractC0835q0.b(r22, i8, aVar, null, Y2.BROADCAST_ACTION_UNSPECIFIED);
        Objects.requireNonNull(j2B, "ApiFailure should not be null");
        G0().b(j2B);
    }

    @Override // R0.C0810e, R0.AbstractC0806c
    public final void c() {
        W0();
        super.c();
    }

    public final void c1(int i8) {
        int i9 = AbstractC0835q0.f7070a;
        O2 o2C = AbstractC0835q0.c(i8, Y2.BROADCAST_ACTION_UNSPECIFIED);
        Objects.requireNonNull(o2C, "ApiSuccess should not be null");
        G0().h(o2C);
    }

    public final void d1(int i8, S.a aVar, Runnable runnable) {
        com.google.android.gms.internal.play_billing.B0.c(com.google.android.gms.internal.play_billing.B0.b(a1(i8), 28500L, TimeUnit.MILLISECONDS, s1()), new C0823k0(this, i8, aVar, runnable), n());
    }

    @Override // R0.C0810e, R0.AbstractC0806c
    public final com.android.billingclient.api.a g(final Activity activity, final C0818i c0818i) {
        S.a aVar = new S.a() { // from class: R0.i0
            @Override // S.a
            public final void accept(Object obj) {
                super/*R0.e*/.J0((com.android.billingclient.api.a) obj);
            }
        };
        Callable callable = new Callable() { // from class: R0.j0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return super/*R0.e*/.g(activity, c0818i);
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
        } catch (Exception e8) {
            R2 r22 = R2.BILLING_OVERRIDE_SERVICE_FALLBACK_ERROR;
            com.android.billingclient.api.a aVar2 = com.android.billingclient.api.c.f14691h;
            b1(r22, 2, aVar2);
            com.google.android.gms.internal.play_billing.V.n("BillingClientTesting", "An internal error occurred.", e8);
            return aVar2;
        }
    }

    @Override // R0.C0810e, R0.AbstractC0806c
    public final void i(final C0838u c0838u, final r rVar) {
        d1(7, new S.a() { // from class: R0.b0
            @Override // S.a
            public final void accept(Object obj) {
                C0839v c0839v = new C0839v(new ArrayList(), new ArrayList());
                rVar.a((com.android.billingclient.api.a) obj, c0839v);
            }
        }, new Runnable() { // from class: R0.c0
            @Override // java.lang.Runnable
            public final void run() {
                super/*R0.e*/.i(c0838u, rVar);
            }
        });
    }

    @Override // R0.C0810e, R0.AbstractC0806c
    public final void l(InterfaceC0812f interfaceC0812f) {
        X0();
        super.l(interfaceC0812f);
    }

    public final synchronized boolean m1() {
        if (this.f7011L == 2 && this.f7012M != null) {
            if (this.f7013N != null) {
                return true;
            }
        }
        return false;
    }

    public final int r1(com.google.android.gms.internal.play_billing.G0 g02) {
        String str;
        try {
            return ((Integer) g02.get(28500L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException e8) {
            e = e8;
            b1(R2.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT, 28, com.android.billingclient.api.c.f14683F);
            str = "Asynchronous call to Billing Override Service timed out.";
            com.google.android.gms.internal.play_billing.V.n("BillingClientTesting", str, e);
            return 0;
        } catch (Exception e9) {
            e = e9;
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            b1(R2.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, com.android.billingclient.api.c.f14683F);
            str = "An error occurred while retrieving billing override.";
            com.google.android.gms.internal.play_billing.V.n("BillingClientTesting", str, e);
            return 0;
        }
    }

    public final synchronized ScheduledExecutorService s1() {
        try {
            if (this.f7014O == null) {
                this.f7014O = Executors.newSingleThreadScheduledExecutor();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f7014O;
    }

    public C0831o0(String str, C0832p c0832p, Context context, x0 x0Var, r0 r0Var, ExecutorService executorService, AbstractC0806c.a aVar) {
        super(null, c0832p, context, null, null, null, aVar);
        this.f7011L = 0;
        this.f7010K = context;
    }

    public C0831o0(String str, Context context, r0 r0Var, ExecutorService executorService, AbstractC0806c.a aVar) {
        super(null, context, null, null, aVar);
        this.f7011L = 0;
        this.f7010K = context;
    }
}
