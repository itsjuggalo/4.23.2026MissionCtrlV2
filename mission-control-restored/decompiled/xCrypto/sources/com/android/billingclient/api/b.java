package com.android.billingclient.api;

import H0.AbstractC0301e0;
import H0.C;
import H0.C0292a;
import H0.C0302f;
import H0.C0306h;
import H0.C0307i;
import H0.C0314p;
import H0.C0315q;
import H0.D;
import H0.E;
import H0.F;
import H0.I;
import H0.InterfaceC0294b;
import H0.InterfaceC0296c;
import H0.InterfaceC0300e;
import H0.InterfaceC0303f0;
import H0.InterfaceC0304g;
import H0.InterfaceC0308j;
import H0.InterfaceC0310l;
import H0.InterfaceC0311m;
import H0.InterfaceC0312n;
import H0.InterfaceC0313o;
import H0.J;
import H0.K;
import H0.L;
import H0.i0;
import H0.l0;
import H0.r0;
import H0.s0;
import H0.z0;
import android.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import com.android.billingclient.api.c;
import com.android.billingclient.api.f;
import com.android.billingclient.api.g;
import com.google.android.gms.internal.play_billing.zzan;
import com.google.android.gms.internal.play_billing.zzbe;
import com.google.android.gms.internal.play_billing.zzco;
import com.google.android.gms.internal.play_billing.zzcx;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzev;
import com.google.android.gms.internal.play_billing.zzfb;
import com.google.android.gms.internal.play_billing.zzfm;
import com.google.android.gms.internal.play_billing.zzfn;
import com.google.android.gms.internal.play_billing.zzjx;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzkb;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzkg;
import com.google.android.gms.internal.play_billing.zzki;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzku;
import com.google.android.gms.internal.play_billing.zzky;
import com.google.android.gms.internal.play_billing.zzlb;
import com.google.android.gms.internal.play_billing.zzlv;
import com.google.android.gms.internal.play_billing.zzlx;
import com.revenuecat.purchases.common.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Predicate;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f9378A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public e f9379B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f9380C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public ExecutorService f9381D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public volatile zzev f9382E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final Long f9383F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f9385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f9387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile z0 f9388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f9389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InterfaceC0303f0 f9390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile zzan f9391h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile h f9392i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9393j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f9394k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f9395l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9396m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9397n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9398o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f9399p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f9400q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f9401r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f9402s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f9403t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f9404u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f9405v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f9406w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f9407x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f9408y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f9409z;

    public b(String str, Context context, InterfaceC0303f0 interfaceC0303f0, ExecutorService executorService) {
        this.f9384a = new Object();
        this.f9385b = 0;
        this.f9387d = new Handler(Looper.getMainLooper());
        this.f9395l = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.f9383F = lValueOf;
        String strN = N();
        this.f9386c = strN;
        this.f9389f = context.getApplicationContext();
        zzks zzksVarZzc = zzku.zzc();
        zzksVarZzc.zzo(strN);
        zzksVarZzc.zzn(this.f9389f.getPackageName());
        zzksVarZzc.zzm(lValueOf.longValue());
        this.f9390g = new i0(this.f9389f, (zzku) zzksVarZzc.zzf());
        this.f9389f.getPackageName();
    }

    public static String N() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return "7.1.1";
        }
    }

    public static final String Y(int i4) {
        return i4 != 0 ? i4 != 1 ? i4 != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED";
    }

    public static Future p(Callable callable, long j4, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: H0.u
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    zze.zzl("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j4 * 0.95d));
            return futureSubmit;
        } catch (Exception e4) {
            zze.zzm("BillingClient", "Async task throws exception!", e4);
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ boolean p0(b bVar) {
        boolean z4;
        synchronized (bVar.f9384a) {
            z4 = true;
            if (bVar.f9385b != 1) {
                z4 = false;
            }
        }
        return z4;
    }

    public final void A0(int i4, int i5, d dVar) {
        try {
            Q(AbstractC0301e0.b(i4, i5, dVar));
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    public final void B0(int i4, int i5, d dVar, String str) {
        try {
            Q(AbstractC0301e0.c(i4, i5, dVar, str));
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    public final void C0(int i4) {
        try {
            R(AbstractC0301e0.d(i4));
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    public final /* synthetic */ Bundle E0(int i4, String str, String str2, c cVar, Bundle bundle) {
        zzan zzanVar;
        try {
            synchronized (this.f9384a) {
                zzanVar = this.f9391h;
            }
            return zzanVar == null ? zze.zzn(k.f9509m, 119) : zzanVar.zzg(i4, this.f9389f.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e4) {
            return zze.zzo(k.f9509m, 5, AbstractC0301e0.a(e4));
        } catch (Exception e5) {
            return zze.zzo(k.f9507k, 5, AbstractC0301e0.a(e5));
        }
    }

    public final /* synthetic */ Bundle F0(String str, String str2) {
        zzan zzanVar;
        try {
            synchronized (this.f9384a) {
                zzanVar = this.f9391h;
            }
            return zzanVar == null ? zze.zzn(k.f9509m, 119) : zzanVar.zzf(3, this.f9389f.getPackageName(), str, str2, null);
        } catch (DeadObjectException e4) {
            return zze.zzo(k.f9509m, 5, AbstractC0301e0.a(e4));
        } catch (Exception e5) {
            return zze.zzo(k.f9507k, 5, AbstractC0301e0.a(e5));
        }
    }

    public final K I0(g gVar) {
        zzan zzanVar;
        ArrayList arrayList = new ArrayList();
        String strC = gVar.c();
        zzco zzcoVarB = gVar.b();
        int size = zzcoVarB.size();
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 20;
            ArrayList arrayList2 = new ArrayList(zzcoVarB.subList(i4, i5 > size ? size : i5));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                arrayList3.add(((g.b) arrayList2.get(i6)).b());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", this.f9386c);
            try {
                synchronized (this.f9384a) {
                    zzanVar = this.f9391h;
                }
                if (zzanVar == null) {
                    return Z(k.f9509m, 119, "Service has been reset to null.", null);
                }
                boolean z4 = true;
                int i7 = true != this.f9407x ? 17 : 20;
                String packageName = this.f9389f.getPackageName();
                boolean zX = X();
                String str = this.f9386c;
                M(gVar);
                M(gVar);
                M(gVar);
                M(gVar);
                long jLongValue = this.f9383F.longValue();
                Bundle bundle2 = new Bundle();
                zze.zzc(bundle2, str, jLongValue);
                bundle2.putBoolean(com.amazon.a.a.o.b.ac, true);
                bundle2.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                if (zX) {
                    bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                }
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                int size3 = arrayList2.size();
                int i8 = 0;
                boolean z5 = false;
                boolean z6 = false;
                while (i8 < size3) {
                    g.b bVar = (g.b) arrayList2.get(i8);
                    boolean z7 = z4;
                    arrayList4.add(null);
                    z5 |= !TextUtils.isEmpty(null);
                    String strC2 = bVar.c();
                    zzan zzanVar2 = zzanVar;
                    if (strC2.equals("first_party")) {
                        zzbe.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList5.add(null);
                        z6 = z7;
                    }
                    i8++;
                    zzanVar = zzanVar2;
                    z4 = z7;
                }
                zzan zzanVar3 = zzanVar;
                if (z5) {
                    bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                }
                if (!arrayList5.isEmpty()) {
                    bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (z6 && !TextUtils.isEmpty(null)) {
                    bundle2.putString("accountName", null);
                }
                Bundle bundleZzl = zzanVar3.zzl(i7, packageName, strC, bundle, bundle2);
                if (bundleZzl == null) {
                    return Z(k.f9492C, 44, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!bundleZzl.containsKey("DETAILS_LIST")) {
                    int iZzb = zze.zzb(bundleZzl, "BillingClient");
                    String strZzh = zze.zzh(bundleZzl, "BillingClient");
                    if (iZzb == 0) {
                        return Z(k.a(6, strZzh), 45, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                    }
                    return Z(k.a(iZzb, strZzh), 23, "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb, null);
                }
                ArrayList<String> stringArrayList = bundleZzl.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return Z(k.f9492C, 46, "queryProductDetailsAsync got null response list", null);
                }
                for (int i9 = 0; i9 < stringArrayList.size(); i9++) {
                    try {
                        f fVar = new f(stringArrayList.get(i9));
                        zze.zzk("BillingClient", "Got product details: ".concat(fVar.toString()));
                        arrayList.add(fVar);
                    } catch (JSONException e4) {
                        return Z(k.a(6, "Error trying to decode SkuDetails."), 47, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e4);
                    }
                }
                i4 = i5;
            } catch (DeadObjectException e5) {
                return Z(k.f9509m, 43, "queryProductDetailsAsync got a remote exception (try to reconnect).", e5);
            } catch (Exception e6) {
                return Z(k.f9507k, 43, "queryProductDetailsAsync got a remote exception (try to reconnect).", e6);
            }
        }
        return new K(0, "", arrayList);
    }

    public final d L() {
        int[] iArr = {0, 3};
        synchronized (this.f9384a) {
            for (int i4 = 0; i4 < 2; i4++) {
                if (this.f9385b == iArr[i4]) {
                    return k.f9509m;
                }
            }
            return k.f9507k;
        }
    }

    public final InterfaceC0303f0 L0() {
        return this.f9390g;
    }

    public final String M(g gVar) {
        if (TextUtils.isEmpty(null)) {
            return this.f9389f.getPackageName();
        }
        return null;
    }

    public final d N0(final d dVar) {
        if (Thread.interrupted()) {
            return dVar;
        }
        this.f9387d.post(new Runnable() { // from class: H0.B0
            @Override // java.lang.Runnable
            public final void run() {
                this.f602a.i0(dVar);
            }
        });
        return dVar;
    }

    public final synchronized ExecutorService O() {
        try {
            if (this.f9381D == null) {
                this.f9381D = Executors.newFixedThreadPool(zze.zza, new C(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9381D;
    }

    /* JADX WARN: Finally extract failed */
    public final void P(C0302f c0302f, InterfaceC0304g interfaceC0304g) throws Throwable {
        zzan zzanVar;
        int iZza;
        String strZzh;
        String strA = c0302f.a();
        try {
            zze.zzk("BillingClient", "Consuming purchase with token: " + strA);
            synchronized (this.f9384a) {
                try {
                    try {
                        zzanVar = this.f9391h;
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                } catch (DeadObjectException e4) {
                    e = e4;
                    f0(interfaceC0304g, strA, k.f9509m, 29, "Error consuming purchase!", e);
                    return;
                } catch (Exception e5) {
                    e = e5;
                    f0(interfaceC0304g, strA, k.f9507k, 29, "Error consuming purchase!", e);
                    return;
                }
            }
            if (zzanVar == null) {
                try {
                    f0(interfaceC0304g, strA, k.f9509m, 119, "Service has been reset to null.", null);
                    return;
                } catch (DeadObjectException e6) {
                    e = e6;
                    f0(interfaceC0304g, strA, k.f9509m, 29, "Error consuming purchase!", e);
                    return;
                } catch (Exception e7) {
                    e = e7;
                    f0(interfaceC0304g, strA, k.f9507k, 29, "Error consuming purchase!", e);
                    return;
                }
            }
            if (this.f9398o) {
                String packageName = this.f9389f.getPackageName();
                boolean z4 = this.f9398o;
                String str = this.f9386c;
                long jLongValue = this.f9383F.longValue();
                Bundle bundle = new Bundle();
                if (z4) {
                    zze.zzc(bundle, str, jLongValue);
                }
                Bundle bundleZze = zzanVar.zze(9, packageName, strA, bundle);
                iZza = bundleZze.getInt("RESPONSE_CODE");
                strZzh = zze.zzh(bundleZze, "BillingClient");
            } else {
                iZza = zzanVar.zza(3, this.f9389f.getPackageName(), strA);
                strZzh = "";
            }
            d dVarA = k.a(iZza, strZzh);
            if (iZza == 0) {
                zze.zzk("BillingClient", "Successfully consumed purchase.");
                interfaceC0304g.a(dVarA, strA);
            } else {
                f0(interfaceC0304g, strA, dVarA, 23, "Error consuming purchase with token. Response code: " + iZza, null);
            }
        } catch (DeadObjectException e8) {
            e = e8;
        } catch (Exception e9) {
            e = e9;
        }
    }

    public final synchronized zzev P0() {
        try {
            if (this.f9382E == null) {
                this.f9382E = zzfb.zza(O());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9382E;
    }

    public final void Q(zzjz zzjzVar) {
        try {
            this.f9390g.e(zzjzVar, this.f9395l);
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    public final void R(zzkd zzkdVar) {
        try {
            this.f9390g.f(zzkdVar, this.f9395l);
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    public final void S(String str, final InterfaceC0311m interfaceC0311m) {
        if (!f()) {
            d dVar = k.f9509m;
            A0(2, 11, dVar);
            interfaceC0311m.a(dVar, null);
        } else if (p(new E(this, str, interfaceC0311m), 30000L, new Runnable() { // from class: H0.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f694a.m0(interfaceC0311m);
            }
        }, u0(), O()) == null) {
            d dVarL = L();
            A0(25, 11, dVarL);
            interfaceC0311m.a(dVarL, null);
        }
    }

    public final /* synthetic */ Object S0(InterfaceC0294b interfaceC0294b, C0292a c0292a) {
        zzan zzanVar;
        try {
            synchronized (this.f9384a) {
                zzanVar = this.f9391h;
            }
            if (zzanVar == null) {
                e0(interfaceC0294b, k.f9509m, 119, null);
                return null;
            }
            String packageName = this.f9389f.getPackageName();
            String strA = c0292a.a();
            String str = this.f9386c;
            long jLongValue = this.f9383F.longValue();
            Bundle bundle = new Bundle();
            zze.zzc(bundle, str, jLongValue);
            Bundle bundleZzd = zzanVar.zzd(9, packageName, strA, bundle);
            interfaceC0294b.a(k.a(zze.zzb(bundleZzd, "BillingClient"), zze.zzh(bundleZzd, "BillingClient")));
            return null;
        } catch (DeadObjectException e4) {
            e0(interfaceC0294b, k.f9509m, 28, e4);
            return null;
        } catch (Exception e5) {
            e0(interfaceC0294b, k.f9507k, 28, e5);
            return null;
        }
    }

    public final void T(String str, final InterfaceC0312n interfaceC0312n) {
        if (!f()) {
            d dVar = k.f9509m;
            A0(2, 9, dVar);
            interfaceC0312n.a(dVar, zzco.zzl());
        } else {
            if (TextUtils.isEmpty(str)) {
                zze.zzl("BillingClient", "Please provide a valid product type.");
                d dVar2 = k.f9504h;
                A0(50, 9, dVar2);
                interfaceC0312n.a(dVar2, zzco.zzl());
                return;
            }
            if (p(new D(this, str, interfaceC0312n), 30000L, new Runnable() { // from class: H0.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f684a.n0(interfaceC0312n);
                }
            }, u0(), O()) == null) {
                d dVarL = L();
                A0(25, 9, dVarL);
                interfaceC0312n.a(dVarL, zzco.zzl());
            }
        }
    }

    public final /* synthetic */ Object T0(C0302f c0302f, InterfaceC0304g interfaceC0304g) throws Throwable {
        P(c0302f, interfaceC0304g);
        return null;
    }

    public final void U(int i4) {
        synchronized (this.f9384a) {
            try {
                if (this.f9385b == 3) {
                    return;
                }
                zze.zzk("BillingClient", "Setting clientState from " + Y(this.f9385b) + " to " + Y(i4));
                this.f9385b = i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ Object U0(InterfaceC0300e interfaceC0300e) {
        zzan zzanVar;
        try {
            synchronized (this.f9384a) {
                zzanVar = this.f9391h;
            }
            if (zzanVar == null) {
                y0(interfaceC0300e, k.f9509m, 119, null);
            } else {
                String packageName = this.f9389f.getPackageName();
                String str = this.f9386c;
                long jLongValue = this.f9383F.longValue();
                Bundle bundle = new Bundle();
                zze.zzc(bundle, str, jLongValue);
                zzanVar.zzp(18, packageName, bundle, new i(interfaceC0300e, this.f9390g, this.f9395l, null));
            }
        } catch (DeadObjectException e4) {
            y0(interfaceC0300e, k.f9509m, 62, e4);
        } catch (Exception e5) {
            y0(interfaceC0300e, k.f9507k, 62, e5);
        }
        return null;
    }

    public final synchronized void V() {
        ExecutorService executorService = this.f9381D;
        if (executorService != null) {
            executorService.shutdownNow();
            this.f9381D = null;
            this.f9382E = null;
        }
    }

    public final /* synthetic */ Object V0(Bundle bundle, Activity activity, ResultReceiver resultReceiver) {
        zzan zzanVar;
        try {
            synchronized (this.f9384a) {
                zzanVar = this.f9391h;
            }
            if (zzanVar == null) {
                z0(-1, 119, null);
            } else {
                zzanVar.zzt(12, this.f9389f.getPackageName(), bundle, new J(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e4) {
            z0(-1, 118, e4);
        } catch (Exception e5) {
            z0(6, 118, e5);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W() {
        synchronized (this.f9384a) {
            if (this.f9392i != null) {
                try {
                    this.f9389f.unbindService(this.f9392i);
                } catch (Throwable th) {
                    try {
                        zze.zzm("BillingClient", "There was an exception while unbinding service!", th);
                        this.f9391h = null;
                        this.f9392i = null;
                    } finally {
                        this.f9391h = null;
                        this.f9392i = null;
                    }
                }
            }
        }
    }

    public final boolean X() {
        return this.f9406w && this.f9379B.b();
    }

    public final K Z(d dVar, int i4, String str, Exception exc) {
        zze.zzm("BillingClient", str, exc);
        B0(i4, 7, dVar, AbstractC0301e0.a(exc));
        return new K(dVar.b(), dVar.a(), new ArrayList());
    }

    @Override // com.android.billingclient.api.a
    public void a(final C0292a c0292a, final InterfaceC0294b interfaceC0294b) {
        if (!f()) {
            d dVar = k.f9509m;
            A0(2, 3, dVar);
            interfaceC0294b.a(dVar);
            return;
        }
        if (TextUtils.isEmpty(c0292a.a())) {
            zze.zzl("BillingClient", "Please provide a valid purchase token.");
            d dVar2 = k.f9506j;
            A0(26, 3, dVar2);
            interfaceC0294b.a(dVar2);
            return;
        }
        if (!this.f9398o) {
            d dVar3 = k.f9498b;
            A0(27, 3, dVar3);
            interfaceC0294b.a(dVar3);
        } else if (p(new Callable() { // from class: H0.D0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f612a.S0(interfaceC0294b, c0292a);
                return null;
            }
        }, 30000L, new Runnable() { // from class: H0.E0
            @Override // java.lang.Runnable
            public final void run() {
                this.f618a.h0(interfaceC0294b);
            }
        }, u0(), O()) == null) {
            d dVarL = L();
            A0(25, 3, dVarL);
            interfaceC0294b.a(dVarL);
        }
    }

    public final L a0(d dVar, int i4, String str, Exception exc) {
        zze.zzm("BillingClient", str, exc);
        B0(i4, 11, dVar, AbstractC0301e0.a(exc));
        return new L(dVar, null);
    }

    @Override // com.android.billingclient.api.a
    public void b(final C0302f c0302f, final InterfaceC0304g interfaceC0304g) {
        if (!f()) {
            d dVar = k.f9509m;
            A0(2, 4, dVar);
            interfaceC0304g.a(dVar, c0302f.a());
        } else if (p(new Callable() { // from class: H0.v
            @Override // java.util.concurrent.Callable
            public final Object call() throws Throwable {
                this.f688a.T0(c0302f, interfaceC0304g);
                return null;
            }
        }, 30000L, new Runnable() { // from class: H0.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f691a.j0(interfaceC0304g, c0302f);
            }
        }, u0(), O()) == null) {
            d dVarL = L();
            A0(25, 4, dVarL);
            interfaceC0304g.a(dVarL, c0302f.a());
        }
    }

    public final r0 b0(int i4, d dVar, int i5, String str, Exception exc) {
        B0(i5, 9, dVar, AbstractC0301e0.a(exc));
        zze.zzm("BillingClient", str, exc);
        return new r0(dVar, null);
    }

    @Override // com.android.billingclient.api.a
    public void c() {
        C0(12);
        synchronized (this.f9384a) {
            try {
            } finally {
            }
            if (this.f9388e != null) {
                this.f9388e.f();
                try {
                    zze.zzk("BillingClient", "Unbinding from service.");
                    W();
                } catch (Throwable th) {
                    zze.zzm("BillingClient", "There was an exception while unbinding from the service while ending connection!", th);
                }
                try {
                    V();
                } finally {
                    try {
                    } finally {
                    }
                }
            } else {
                zze.zzk("BillingClient", "Unbinding from service.");
                W();
                V();
            }
        }
    }

    public final r0 c0(String str, int i4) {
        zzan zzanVar;
        b bVar = this;
        zze.zzk("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle bundleZzd = zze.zzd(bVar.f9398o, bVar.f9406w, bVar.f9379B.a(), bVar.f9379B.b(), bVar.f9386c, bVar.f9383F.longValue());
        String string = null;
        do {
            try {
                synchronized (bVar.f9384a) {
                    zzanVar = bVar.f9391h;
                }
                if (zzanVar == null) {
                    return bVar.b0(9, k.f9509m, 119, "Service has been reset to null", null);
                }
                Bundle bundleZzj = bVar.f9398o ? zzanVar.zzj(true != bVar.f9406w ? 9 : 19, bVar.f9389f.getPackageName(), str, string, bundleZzd) : zzanVar.zzi(3, bVar.f9389f.getPackageName(), str, string);
                s0 s0VarA = m.a(bundleZzj, "BillingClient", "getPurchase()");
                d dVarA = s0VarA.a();
                if (dVarA != k.f9508l) {
                    return bVar.b0(9, dVarA, s0VarA.b(), "Purchase bundle invalid", null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzj.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z4 = false;
                for (int i5 = 0; i5 < stringArrayList2.size(); i5++) {
                    String str2 = stringArrayList2.get(i5);
                    String str3 = stringArrayList3.get(i5);
                    zze.zzk("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i5))));
                    try {
                        Purchase purchase = new Purchase(str2, str3);
                        if (TextUtils.isEmpty(purchase.f())) {
                            zze.zzl("BillingClient", "BUG: empty/null token!");
                            z4 = true;
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e4) {
                        return b0(9, k.f9507k, 51, "Got an exception trying to decode the purchase!", e4);
                    }
                }
                bVar = this;
                if (z4) {
                    bVar.A0(26, 9, k.f9507k);
                }
                string = bundleZzj.getString("INAPP_CONTINUATION_TOKEN");
                zze.zzk("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
            } catch (DeadObjectException e5) {
                return b0(9, k.f9509m, 52, "Got exception trying to get purchases try to reconnect", e5);
            } catch (Exception e6) {
                return bVar.b0(9, k.f9507k, 52, "Got exception trying to get purchases try to reconnect", e6);
            }
        } while (!TextUtils.isEmpty(string));
        return new r0(k.f9508l, arrayList);
    }

    @Override // com.android.billingclient.api.a
    public void d(C0306h c0306h, final InterfaceC0300e interfaceC0300e) {
        if (!f()) {
            zze.zzl("BillingClient", "Service disconnected.");
            d dVar = k.f9509m;
            A0(2, 13, dVar);
            interfaceC0300e.a(dVar, null);
            return;
        }
        if (!this.f9405v) {
            zze.zzl("BillingClient", "Current client doesn't support get billing config.");
            d dVar2 = k.f9490A;
            A0(32, 13, dVar2);
            interfaceC0300e.a(dVar2, null);
            return;
        }
        if (p(new Callable() { // from class: H0.F0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f621a.U0(interfaceC0300e);
                return null;
            }
        }, 30000L, new Runnable() { // from class: H0.G0
            @Override // java.lang.Runnable
            public final void run() {
                this.f624a.k0(interfaceC0300e);
            }
        }, u0(), O()) == null) {
            d dVarL = L();
            A0(25, 13, dVarL);
            interfaceC0300e.a(dVarL, null);
        }
    }

    public final void d0(d dVar, int i4, int i5) {
        zzkd zzkdVar = null;
        zzjz zzjzVar = null;
        if (dVar.b() == 0) {
            int i6 = AbstractC0301e0.f662a;
            try {
                zzkb zzkbVarZzc = zzkd.zzc();
                zzkbVarZzc.zzn(5);
                zzky zzkyVarZzc = zzlb.zzc();
                zzkyVarZzc.zza(i5);
                zzkbVarZzc.zza((zzlb) zzkyVarZzc.zzf());
                zzkdVar = (zzkd) zzkbVarZzc.zzf();
            } catch (Exception e4) {
                zze.zzm("BillingLogger", "Unable to create logging payload", e4);
            }
            R(zzkdVar);
            return;
        }
        int i7 = AbstractC0301e0.f662a;
        try {
            zzjx zzjxVarZzc = zzjz.zzc();
            zzke zzkeVarZzc = zzki.zzc();
            zzkeVarZzc.zzn(dVar.b());
            zzkeVarZzc.zzm(dVar.a());
            zzkeVarZzc.zzo(i4);
            zzjxVarZzc.zza(zzkeVarZzc);
            zzjxVarZzc.zzn(5);
            zzky zzkyVarZzc2 = zzlb.zzc();
            zzkyVarZzc2.zza(i5);
            zzjxVarZzc.zzm((zzlb) zzkyVarZzc2.zzf());
            zzjzVar = (zzjz) zzjxVarZzc.zzf();
        } catch (Exception e5) {
            zze.zzm("BillingLogger", "Unable to create logging payload", e5);
        }
        Q(zzjzVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d5  */
    @Override // com.android.billingclient.api.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.android.billingclient.api.d e(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.b.e(java.lang.String):com.android.billingclient.api.d");
    }

    public final void e0(InterfaceC0294b interfaceC0294b, d dVar, int i4, Exception exc) {
        zze.zzm("BillingClient", "Error in acknowledge purchase!", exc);
        B0(i4, 3, dVar, AbstractC0301e0.a(exc));
        interfaceC0294b.a(dVar);
    }

    @Override // com.android.billingclient.api.a
    public final boolean f() {
        boolean z4;
        synchronized (this.f9384a) {
            try {
                z4 = false;
                if (this.f9385b == 2 && this.f9391h != null && this.f9392i != null) {
                    z4 = true;
                }
            } finally {
            }
        }
        return z4;
    }

    public final void f0(InterfaceC0304g interfaceC0304g, String str, d dVar, int i4, String str2, Exception exc) {
        zze.zzm("BillingClient", str2, exc);
        B0(i4, 4, dVar, AbstractC0301e0.a(exc));
        interfaceC0304g.a(dVar, str);
    }

    @Override // com.android.billingclient.api.a
    public d g(Activity activity, final c cVar) {
        String str;
        String str2;
        Future futureP;
        int iZza;
        String string;
        String str3;
        boolean z4;
        String str4;
        c.b bVar;
        boolean z5;
        String str5;
        int i4;
        final int i5;
        if (this.f9388e == null || this.f9388e.d() == null) {
            d dVar = k.f9495F;
            A0(12, 2, dVar);
            return dVar;
        }
        if (!f()) {
            d dVar2 = k.f9509m;
            A0(2, 2, dVar2);
            N0(dVar2);
            return dVar2;
        }
        ArrayList arrayListH = cVar.h();
        List listI = cVar.i();
        android.support.v4.media.session.b.a(zzcx.zza(arrayListH, null));
        c.b bVar2 = (c.b) zzcx.zza(listI, null);
        final String strD = bVar2.b().d();
        final String strE = bVar2.b().e();
        if (strE.equals("subs") && !this.f9393j) {
            zze.zzl("BillingClient", "Current client doesn't support subscriptions.");
            d dVar3 = k.f9511o;
            A0(9, 2, dVar3);
            N0(dVar3);
            return dVar3;
        }
        if (cVar.r() && !this.f9396m) {
            zze.zzl("BillingClient", "Current client doesn't support extra params for buy intent.");
            d dVar4 = k.f9505i;
            A0(18, 2, dVar4);
            N0(dVar4);
            return dVar4;
        }
        if (arrayListH.size() > 1 && !this.f9403t) {
            zze.zzl("BillingClient", "Current client doesn't support multi-item purchases.");
            d dVar5 = k.f9516t;
            A0(19, 2, dVar5);
            N0(dVar5);
            return dVar5;
        }
        if (!listI.isEmpty() && !this.f9404u) {
            zze.zzl("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            d dVar6 = k.f9518v;
            A0(20, 2, dVar6);
            N0(dVar6);
            return dVar6;
        }
        d dVarC = cVar.c();
        if (dVarC != k.f9508l) {
            A0(120, 2, dVarC);
            N0(dVarC);
            return dVarC;
        }
        if (this.f9396m) {
            boolean z6 = this.f9398o;
            boolean z7 = this.f9406w;
            boolean zA = this.f9379B.a();
            boolean zB = this.f9379B.b();
            boolean z8 = this.f9380C;
            String str6 = this.f9386c;
            long jLongValue = this.f9383F.longValue();
            final String packageName = this.f9389f.getPackageName();
            final Bundle bundle = new Bundle();
            zze.zzc(bundle, str6, jLongValue);
            if (cVar.b() != 0) {
                bundle.putInt(com.amazon.a.a.o.b.f8764l, cVar.b());
            }
            if (!TextUtils.isEmpty(cVar.d())) {
                bundle.putString("accountId", cVar.d());
            }
            if (!TextUtils.isEmpty(cVar.e())) {
                bundle.putString("obfuscatedProfileId", cVar.e());
            }
            if (cVar.q()) {
                bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
            }
            if (!TextUtils.isEmpty(cVar.f())) {
                bundle.putString("oldSkuPurchaseToken", cVar.f());
            }
            if (TextUtils.isEmpty(null)) {
                str3 = null;
            } else {
                str3 = null;
                bundle.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(cVar.g())) {
                bundle.putString("originalExternalTransactionId", cVar.g());
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("paymentsPurchaseParams", str3);
            }
            if (z6 && zA) {
                z4 = true;
                bundle.putBoolean(com.amazon.a.a.o.b.ac, true);
            } else {
                z4 = true;
            }
            if (z7 && zB) {
                bundle.putBoolean("enablePendingPurchaseForSubscriptions", z4);
            }
            if (z8) {
                bundle.putBoolean("enableAlternativeBilling", z4);
            }
            if (cVar.i().stream().anyMatch(new Predicate() { // from class: com.google.android.gms.internal.play_billing.zza
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    int i6 = zze.zza;
                    return false;
                }
            })) {
                zzfm zzfmVarZza = zzfn.zza();
                zzfmVarZza.zza((Iterable) cVar.i().stream().filter(new Predicate() { // from class: com.google.android.gms.internal.play_billing.zzb
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        int i6 = zze.zza;
                        return false;
                    }
                }).map(new Function() { // from class: com.google.android.gms.internal.play_billing.zzc
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i6 = zze.zza;
                        String strD2 = ((c.b) obj).b().d();
                        zzfk zzfkVarZza = zzfl.zza();
                        zzfp zzfpVarZza = zzfq.zza();
                        zzfpVarZza.zza("subs:" + packageName + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + strD2);
                        zzfkVarZza.zza(zzfpVarZza);
                        zzfq.zza();
                        throw null;
                    }
                }).collect(zzco.zzo()));
                bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzfn) zzfmVarZza.zzf()).zzh());
            }
            if (arrayListH.isEmpty()) {
                ArrayList<String> arrayList = new ArrayList<>(listI.size() - 1);
                ArrayList<String> arrayList2 = new ArrayList<>(listI.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                str = "BUY_INTENT";
                ArrayList<Integer> arrayList6 = new ArrayList<>();
                str4 = "proxyPackageVersion";
                for (int i6 = 0; i6 < listI.size(); i6++) {
                    c.b bVar3 = (c.b) listI.get(i6);
                    f fVarB = bVar3.b();
                    if (fVarB.i().isEmpty()) {
                        bVar = bVar3;
                    } else {
                        bVar = bVar3;
                        arrayList3.add(fVarB.i());
                    }
                    arrayList4.add(bVar.c());
                    String strJ = fVarB.j();
                    if (fVarB.k() != null && !fVarB.k().isEmpty()) {
                        Iterator it = fVarB.k().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            f.b bVar4 = (f.b) it.next();
                            if (!TextUtils.isEmpty(bVar4.f())) {
                                strJ = bVar4.f();
                                break;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(strJ)) {
                        arrayList5.add(strJ);
                    }
                    if (i6 > 0) {
                        arrayList.add(((c.b) listI.get(i6)).b().d());
                        arrayList2.add(((c.b) listI.get(i6)).b().e());
                    }
                }
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                bundle.putIntegerArrayList("AUTO_PAY_BALANCE_THRESHOLD_LIST", arrayList6);
                if (!arrayList3.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList3);
                }
                if (!arrayList5.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (!arrayList.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList2);
                }
            } else {
                ArrayList<String> arrayList7 = new ArrayList<>();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                Iterator it2 = arrayListH.iterator();
                if (it2.hasNext()) {
                    android.support.v4.media.session.b.a(it2.next());
                    throw null;
                }
                if (!arrayList7.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList7);
                }
                if (arrayListH.size() > 1) {
                    ArrayList<String> arrayList8 = new ArrayList<>(arrayListH.size() - 1);
                    ArrayList<String> arrayList9 = new ArrayList<>(arrayListH.size() - 1);
                    if (1 < arrayListH.size()) {
                        android.support.v4.media.session.b.a(arrayListH.get(1));
                        throw null;
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList8);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList9);
                }
                str4 = "proxyPackageVersion";
                str = "BUY_INTENT";
            }
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.f9401r) {
                d dVar7 = k.f9517u;
                A0(21, 2, dVar7);
                N0(dVar7);
                return dVar7;
            }
            if (bVar2 == null || TextUtils.isEmpty(bVar2.b().h())) {
                z5 = false;
            } else {
                bundle.putString("skuPackageName", bVar2.b().h());
                z5 = true;
            }
            str2 = null;
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("accountName", null);
            }
            Intent intent = activity.getIntent();
            if (intent == null) {
                zze.zzl("BillingClient", "Activity's intent is null.");
            } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                bundle.putString("proxyPackage", stringExtra);
                try {
                    str5 = str4;
                    try {
                        bundle.putString(str5, this.f9389f.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                    } catch (PackageManager.NameNotFoundException unused) {
                        bundle.putString(str5, "package not found");
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    str5 = str4;
                }
            }
            if (this.f9404u && !listI.isEmpty()) {
                i4 = 17;
            } else if (this.f9402s && z5) {
                i4 = 15;
            } else if (this.f9398o) {
                i5 = 9;
                futureP = p(new Callable() { // from class: H0.B
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f596a.E0(i5, strD, strE, cVar, bundle);
                    }
                }, 5000L, null, this.f9387d, O());
            } else {
                i4 = 6;
            }
            i5 = i4;
            futureP = p(new Callable() { // from class: H0.B
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f596a.E0(i5, strD, strE, cVar, bundle);
                }
            }, 5000L, null, this.f9387d, O());
        } else {
            str = "BUY_INTENT";
            str2 = null;
            futureP = p(new Callable() { // from class: H0.C0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f606a.F0(strD, strE);
                }
            }, 5000L, null, this.f9387d, O());
        }
        try {
            if (futureP == null) {
                d dVar8 = k.f9500d;
                A0(25, 2, dVar8);
                N0(dVar8);
                return dVar8;
            }
            Bundle bundle2 = (Bundle) futureP.get(5000L, TimeUnit.MILLISECONDS);
            int iZzb = zze.zzb(bundle2, "BillingClient");
            String strZzh = zze.zzh(bundle2, "BillingClient");
            if (iZzb == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                String str7 = str;
                intent2.putExtra(str7, (PendingIntent) bundle2.getParcelable(str7));
                activity.startActivity(intent2);
                return k.f9508l;
            }
            zze.zzl("BillingClient", "Unable to buy item, Error response code: " + iZzb);
            d dVarA = k.a(iZzb, strZzh);
            if (bundle2 == null) {
                iZza = 1;
            } else {
                try {
                    Object obj = bundle2.get("LOG_REASON");
                    if (obj != null) {
                        if (obj instanceof Integer) {
                            iZza = zzkg.zza(((Integer) obj).intValue());
                        } else {
                            zze.zzl("BillingClient", "Unexpected type for bundle log reason: " + obj.getClass().getName());
                        }
                    }
                } catch (Throwable th) {
                    zze.zzl("BillingClient", "Failed to get log reason from bundle: ".concat(String.valueOf(th.getMessage())));
                }
                iZza = 1;
            }
            if (iZza == 1) {
                iZza = 23;
            }
            if (bundle2 == null) {
                string = str2;
            } else {
                try {
                    string = bundle2.getString("ADDITIONAL_LOG_DETAILS");
                } catch (Throwable th2) {
                    zze.zzl("BillingClient", "Failed to get additional log details from bundle: ".concat(String.valueOf(th2.getMessage())));
                    string = str2;
                }
            }
            B0(iZza, 2, dVarA, string);
            N0(dVarA);
            return dVarA;
        } catch (CancellationException e4) {
            e = e4;
            zze.zzm("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
            d dVar9 = k.f9510n;
            B0(4, 2, dVar9, AbstractC0301e0.a(e));
            N0(dVar9);
            return dVar9;
        } catch (TimeoutException e5) {
            e = e5;
            zze.zzm("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
            d dVar92 = k.f9510n;
            B0(4, 2, dVar92, AbstractC0301e0.a(e));
            N0(dVar92);
            return dVar92;
        } catch (Exception e6) {
            zze.zzm("BillingClient", "Exception while launching billing flow. Try to reconnect", e6);
            d dVar10 = k.f9509m;
            B0(5, 2, dVar10, AbstractC0301e0.a(e6));
            N0(dVar10);
            return dVar10;
        }
    }

    public final /* synthetic */ void h0(InterfaceC0294b interfaceC0294b) {
        d dVar = k.f9510n;
        A0(24, 3, dVar);
        interfaceC0294b.a(dVar);
    }

    @Override // com.android.billingclient.api.a
    public void i(final g gVar, final InterfaceC0310l interfaceC0310l) {
        if (!f()) {
            d dVar = k.f9509m;
            A0(2, 7, dVar);
            interfaceC0310l.a(dVar, new ArrayList());
        } else {
            if (!this.f9404u) {
                zze.zzl("BillingClient", "Querying product details is not supported.");
                d dVar2 = k.f9518v;
                A0(20, 7, dVar2);
                interfaceC0310l.a(dVar2, new ArrayList());
                return;
            }
            if (p(new Callable() { // from class: H0.y
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    K kI0 = this.f696a.I0(gVar);
                    interfaceC0310l.a(com.android.billingclient.api.k.a(kI0.a(), kI0.b()), kI0.c());
                    return null;
                }
            }, 30000L, new Runnable() { // from class: H0.z
                @Override // java.lang.Runnable
                public final void run() {
                    this.f702a.l0(interfaceC0310l);
                }
            }, u0(), O()) == null) {
                d dVarL = L();
                A0(25, 7, dVarL);
                interfaceC0310l.a(dVarL, new ArrayList());
            }
        }
    }

    public final /* synthetic */ void i0(d dVar) {
        if (this.f9388e.d() != null) {
            this.f9388e.d().onPurchasesUpdated(dVar, null);
        } else {
            zze.zzl("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    @Override // com.android.billingclient.api.a
    public final void j(C0314p c0314p, InterfaceC0311m interfaceC0311m) {
        S(c0314p.b(), interfaceC0311m);
    }

    public final /* synthetic */ void j0(InterfaceC0304g interfaceC0304g, C0302f c0302f) {
        d dVar = k.f9510n;
        A0(24, 4, dVar);
        interfaceC0304g.a(dVar, c0302f.a());
    }

    @Override // com.android.billingclient.api.a
    public final void k(C0315q c0315q, InterfaceC0312n interfaceC0312n) {
        T(c0315q.b(), interfaceC0312n);
    }

    public final /* synthetic */ void k0(InterfaceC0300e interfaceC0300e) {
        d dVar = k.f9510n;
        A0(24, 13, dVar);
        interfaceC0300e.a(dVar, null);
    }

    @Override // com.android.billingclient.api.a
    public final d l(final Activity activity, C0307i c0307i, InterfaceC0308j interfaceC0308j) {
        if (!f()) {
            zze.zzl("BillingClient", "Service disconnected.");
            return k.f9509m;
        }
        if (!this.f9400q) {
            zze.zzl("BillingClient", "Current client doesn't support showing in-app messages.");
            return k.f9519w;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        w.f.a(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.f9386c);
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", c0307i.b());
        final F f4 = new F(this, this.f9387d, interfaceC0308j);
        p(new Callable() { // from class: H0.A
            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f592a.V0(bundle, activity, f4);
                return null;
            }
        }, 5000L, null, this.f9387d, O());
        return k.f9508l;
    }

    public final /* synthetic */ void l0(InterfaceC0310l interfaceC0310l) {
        d dVar = k.f9510n;
        A0(24, 7, dVar);
        interfaceC0310l.a(dVar, new ArrayList());
    }

    @Override // com.android.billingclient.api.a
    public void m(InterfaceC0296c interfaceC0296c) {
        d dVarW0;
        synchronized (this.f9384a) {
            try {
                if (f()) {
                    dVarW0 = w0();
                } else if (this.f9385b == 1) {
                    zze.zzl("BillingClient", "Client is already in the process of connecting to billing service.");
                    dVarW0 = k.f9501e;
                    A0(37, 6, dVarW0);
                } else if (this.f9385b == 3) {
                    zze.zzl("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                    dVarW0 = k.f9509m;
                    A0(38, 6, dVarW0);
                } else {
                    U(1);
                    W();
                    zze.zzk("BillingClient", "Starting in-app billing setup.");
                    this.f9392i = new h(this, interfaceC0296c, null);
                    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                    intent.setPackage("com.android.vending");
                    List<ResolveInfo> listQueryIntentServices = this.f9389f.getPackageManager().queryIntentServices(intent, 0);
                    int i4 = 41;
                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                        U(0);
                        zze.zzk("BillingClient", "Billing service unavailable on device.");
                        dVarW0 = k.f9499c;
                        A0(i4, 6, dVarW0);
                    } else {
                        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                        i4 = 40;
                        if (serviceInfo != null) {
                            String str = serviceInfo.packageName;
                            String str2 = serviceInfo.name;
                            if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                zze.zzl("BillingClient", "The device doesn't have valid Play Store.");
                            } else {
                                ComponentName componentName = new ComponentName(str, str2);
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(componentName);
                                intent2.putExtra("playBillingLibraryVersion", this.f9386c);
                                synchronized (this.f9384a) {
                                    try {
                                        if (this.f9385b == 2) {
                                            dVarW0 = w0();
                                        } else if (this.f9385b != 1) {
                                            zze.zzl("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                            dVarW0 = k.f9509m;
                                            A0(117, 6, dVarW0);
                                        } else {
                                            h hVar = this.f9392i;
                                            if (this.f9389f.bindService(intent2, hVar, 1)) {
                                                zze.zzk("BillingClient", "Service was bonded successfully.");
                                                dVarW0 = null;
                                            } else {
                                                zze.zzl("BillingClient", "Connection to Billing service is blocked.");
                                                i4 = 39;
                                            }
                                        }
                                    } finally {
                                    }
                                }
                            }
                        } else {
                            zze.zzl("BillingClient", "The device doesn't have valid Play Store.");
                        }
                        U(0);
                        zze.zzk("BillingClient", "Billing service unavailable on device.");
                        dVarW0 = k.f9499c;
                        A0(i4, 6, dVarW0);
                    }
                }
            } finally {
            }
        }
        if (dVarW0 != null) {
            interfaceC0296c.onBillingSetupFinished(dVarW0);
        }
    }

    public final /* synthetic */ void m0(InterfaceC0311m interfaceC0311m) {
        d dVar = k.f9510n;
        A0(24, 11, dVar);
        interfaceC0311m.a(dVar, null);
    }

    public final void n(Context context, InterfaceC0313o interfaceC0313o, e eVar, I i4, String str, InterfaceC0303f0 interfaceC0303f0) {
        this.f9389f = context.getApplicationContext();
        zzks zzksVarZzc = zzku.zzc();
        zzksVarZzc.zzo(str);
        zzksVarZzc.zzn(this.f9389f.getPackageName());
        zzksVarZzc.zzm(this.f9383F.longValue());
        if (interfaceC0303f0 != null) {
            this.f9390g = interfaceC0303f0;
        } else {
            this.f9390g = new i0(this.f9389f, (zzku) zzksVarZzc.zzf());
        }
        if (interfaceC0313o == null) {
            zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.f9388e = new z0(this.f9389f, interfaceC0313o, null, i4, null, this.f9390g);
        this.f9379B = eVar;
        this.f9380C = i4 != null;
        this.f9389f.getPackageName();
    }

    public final /* synthetic */ void n0(InterfaceC0312n interfaceC0312n) {
        d dVar = k.f9510n;
        A0(24, 9, dVar);
        interfaceC0312n.a(dVar, zzco.zzl());
    }

    public final Handler u0() {
        return Looper.myLooper() == null ? this.f9387d : new Handler(Looper.myLooper());
    }

    public final L v0(String str) {
        zzan zzanVar;
        zze.zzk("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle bundleZzd = zze.zzd(this.f9398o, this.f9406w, this.f9379B.a(), this.f9379B.b(), this.f9386c, this.f9383F.longValue());
        String string = null;
        while (this.f9396m) {
            try {
                synchronized (this.f9384a) {
                    zzanVar = this.f9391h;
                }
                if (zzanVar == null) {
                    return a0(k.f9509m, 119, "Service reset to null", null);
                }
                Bundle bundleZzh = zzanVar.zzh(6, this.f9389f.getPackageName(), str, string, bundleZzd);
                s0 s0VarA = m.a(bundleZzh, "BillingClient", "getPurchaseHistory()");
                d dVarA = s0VarA.a();
                if (dVarA != k.f9508l) {
                    A0(s0VarA.b(), 11, dVarA);
                    return new L(dVarA, null);
                }
                ArrayList<String> stringArrayList = bundleZzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z4 = false;
                for (int i4 = 0; i4 < stringArrayList2.size(); i4++) {
                    String str2 = stringArrayList2.get(i4);
                    String str3 = stringArrayList3.get(i4);
                    zze.zzk("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i4))));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str2, str3);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.d())) {
                            zze.zzl("BillingClient", "BUG: empty/null token!");
                            z4 = true;
                        }
                        arrayList.add(purchaseHistoryRecord);
                    } catch (JSONException e4) {
                        return a0(k.f9507k, 51, "Got an exception trying to decode the purchase!", e4);
                    }
                }
                if (z4) {
                    A0(26, 11, k.f9507k);
                }
                string = bundleZzh.getString("INAPP_CONTINUATION_TOKEN");
                zze.zzk("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    return new L(k.f9508l, arrayList);
                }
            } catch (DeadObjectException e5) {
                return a0(k.f9509m, 59, "Got exception trying to get purchase history", e5);
            } catch (Exception e6) {
                return a0(k.f9507k, 59, "Got exception trying to get purchase history", e6);
            }
        }
        zze.zzl("BillingClient", "getPurchaseHistory is not supported on current device");
        return new L(k.f9513q, null);
    }

    public final d w0() {
        zze.zzk("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzkb zzkbVarZzc = zzkd.zzc();
        zzkbVarZzc.zzn(6);
        zzlv zzlvVarZzc = zzlx.zzc();
        zzlvVarZzc.zza(true);
        zzkbVarZzc.zzm(zzlvVarZzc);
        R((zzkd) zzkbVarZzc.zzf());
        return k.f9508l;
    }

    public final void y0(InterfaceC0300e interfaceC0300e, d dVar, int i4, Exception exc) {
        zze.zzm("BillingClient", "getBillingConfig got an exception.", exc);
        B0(i4, 13, dVar, AbstractC0301e0.a(exc));
        interfaceC0300e.a(dVar, null);
    }

    public final void z0(int i4, int i5, Exception exc) {
        zzjz zzjzVar;
        zze.zzm("BillingClient", "showInAppMessages error.", exc);
        InterfaceC0303f0 interfaceC0303f0 = this.f9390g;
        String strA = AbstractC0301e0.a(exc);
        try {
            zzke zzkeVarZzc = zzki.zzc();
            zzkeVarZzc.zzn(i4);
            zzkeVarZzc.zzo(i5);
            if (strA != null) {
                zzkeVarZzc.zza(strA);
            }
            zzjx zzjxVarZzc = zzjz.zzc();
            zzjxVarZzc.zza(zzkeVarZzc);
            zzjxVarZzc.zzn(30);
            zzjzVar = (zzjz) zzjxVarZzc.zzf();
        } catch (Throwable th) {
            zze.zzm("BillingLogger", "Unable to create logging payload", th);
            zzjzVar = null;
        }
        interfaceC0303f0.d(zzjzVar);
    }

    public b(String str, e eVar, Context context, l0 l0Var, InterfaceC0303f0 interfaceC0303f0, ExecutorService executorService) {
        this.f9384a = new Object();
        this.f9385b = 0;
        this.f9387d = new Handler(Looper.getMainLooper());
        this.f9395l = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.f9383F = lValueOf;
        this.f9386c = N();
        this.f9389f = context.getApplicationContext();
        zzks zzksVarZzc = zzku.zzc();
        zzksVarZzc.zzo(N());
        zzksVarZzc.zzn(this.f9389f.getPackageName());
        zzksVarZzc.zzm(lValueOf.longValue());
        this.f9390g = new i0(this.f9389f, (zzku) zzksVarZzc.zzf());
        zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.f9388e = new z0(this.f9389f, null, null, null, null, this.f9390g);
        this.f9379B = eVar;
        this.f9389f.getPackageName();
    }

    public b(String str, e eVar, Context context, InterfaceC0313o interfaceC0313o, I i4, InterfaceC0303f0 interfaceC0303f0, ExecutorService executorService) {
        String strN = N();
        this.f9384a = new Object();
        this.f9385b = 0;
        this.f9387d = new Handler(Looper.getMainLooper());
        this.f9395l = 0;
        this.f9383F = Long.valueOf(new Random().nextLong());
        this.f9386c = strN;
        n(context, interfaceC0313o, eVar, null, strN, null);
    }
}
