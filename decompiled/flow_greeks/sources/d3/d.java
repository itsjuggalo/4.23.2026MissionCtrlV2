package d3;

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
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import com.android.billingclient.api.ProxyBillingActivity;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzam;
import com.google.android.gms.internal.play_billing.zzaz;
import com.google.android.gms.internal.play_billing.zzbi;
import com.google.android.gms.internal.play_billing.zzbl;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzby;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzcu;
import com.google.android.gms.internal.play_billing.zzcz;
import com.google.android.gms.internal.play_billing.zzdj;
import com.google.android.gms.internal.play_billing.zzdk;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzig;
import com.google.android.gms.internal.play_billing.zzil;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziz;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import com.google.android.gms.internal.play_billing.zzp;
import com.google.android.gms.internal.play_billing.zzr;
import com.google.android.gms.internal.play_billing.zzu;
import com.revenuecat.purchases.api.BuildConfig;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import d3.c;
import d3.h;
import d3.p;
import d3.t;
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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends c {
    public boolean A;
    public boolean B;
    public boolean C;
    public o D;
    public boolean E;
    public boolean F;
    public volatile e G;
    public ExecutorService H;
    public final Long I;
    public zzbl J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f7603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f7606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile i2 f7607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f7608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p1 f7609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile zzam f7610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile v0 f7611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7614m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7615n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7616o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7617p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7618q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7619r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7620s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7621t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7622u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f7623v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7624w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7625x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f7626y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f7627z;

    public d(String str, Context context, p1 p1Var, ExecutorService executorService, c.a aVar) {
        this.f7602a = new Object();
        this.f7603b = 0;
        this.f7606e = new Handler(Looper.getMainLooper());
        this.f7614m = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.I = lValueOf;
        this.J = zzaz.zza();
        this.f7604c = BuildConfig.BILLING_CLIENT_VERSION;
        String strO0 = o0();
        this.f7605d = strO0;
        this.f7608g = context.getApplicationContext();
        zziq zziqVarZzc = zzis.zzc();
        zziqVarZzc.zzs(BuildConfig.BILLING_CLIENT_VERSION);
        if (strO0 != null) {
            zziqVarZzc.zzt(strO0);
        }
        zziqVarZzc.zzq(this.f7608g.getPackageName());
        zziqVarZzc.zzn(lValueOf.longValue());
        zziqVarZzc.zzr(aVar.f7595f);
        zziqVarZzc.zza(Build.VERSION.SDK_INT);
        zziqVarZzc.zzp(772604006L);
        try {
            zziqVarZzc.zzl(this.f7608g.getPackageManager().getPackageInfo(this.f7608g.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.f7609h = new s1(this.f7608g, (zzis) zziqVarZzc.zze());
        this.f7608g.getPackageName();
        this.E = aVar.f7595f;
    }

    public static /* bridge */ /* synthetic */ com.android.billingclient.api.a I0(Exception exc) {
        return exc instanceof DeadObjectException ? com.android.billingclient.api.c.f5156j : com.android.billingclient.api.c.f5154h;
    }

    public static /* synthetic */ Object N0(d dVar, int i10, zzp zzpVar) {
        dVar.M(new s0(dVar, zzpVar), i10);
        return "reconnectIfNeeded";
    }

    public static /* synthetic */ Object O0(d dVar, j jVar, i iVar) throws Throwable {
        if (dVar.P(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS)) {
            dVar.B(iVar, jVar);
            return null;
        }
        zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
        com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5156j;
        dVar.t0(zzieVar, 4, aVar);
        jVar.a(aVar, iVar.a());
        return null;
    }

    public static /* synthetic */ Object P0(d dVar, q qVar, t tVar) {
        if (!dVar.P(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5156j;
            dVar.t0(zzieVar, 7, aVar);
            qVar.a(aVar, new u(zzbt.zzk(), zzbt.zzk()));
            return null;
        }
        if (dVar.f7622u) {
            x0 x0VarD0 = dVar.D0(tVar);
            qVar.a(com.android.billingclient.api.c.a(x0VarD0.a(), x0VarD0.b()), new u(x0VarD0.c(), x0VarD0.d()));
            return null;
        }
        zzc.zzn("BillingClient", "Querying product details is not supported.");
        zzie zzieVar2 = zzie.PRODUCT_DETAILS_NOT_SUPPORTED;
        com.android.billingclient.api.a aVar2 = com.android.billingclient.api.c.f5164r;
        dVar.t0(zzieVar2, 7, aVar2);
        qVar.a(aVar2, new u(zzbt.zzk(), zzbt.zzk()));
        return null;
    }

    public static /* synthetic */ Object Q0(d dVar, b bVar, a aVar) {
        dVar.k0(bVar, aVar);
        return null;
    }

    public static final String R(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED";
    }

    public static /* synthetic */ Object R0(d dVar, Bundle bundle, Activity activity, ResultReceiver resultReceiver) {
        dVar.m0(bundle, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Object S0(d dVar, g gVar) {
        dVar.l0(gVar);
        return null;
    }

    public static /* bridge */ /* synthetic */ void U(d dVar, int i10) {
        dVar.f7614m = i10;
        dVar.C = i10 >= 26;
        dVar.B = i10 >= 24;
        dVar.A = i10 >= 23;
        dVar.f7627z = i10 >= 22;
        dVar.f7626y = i10 >= 21;
        dVar.f7625x = i10 >= 20;
        dVar.f7624w = i10 >= 19;
        dVar.f7623v = i10 >= 18;
        dVar.f7622u = i10 >= 17;
        dVar.f7621t = i10 >= 16;
        dVar.f7620s = i10 >= 15;
        dVar.f7619r = i10 >= 14;
        dVar.f7618q = i10 >= 12;
        dVar.f7617p = i10 >= 9;
        dVar.f7616o = i10 >= 8;
        dVar.f7615n = i10 >= 6;
    }

    public static /* bridge */ /* synthetic */ void W(d dVar, int i10) {
        if (i10 != 0) {
            dVar.K(0);
            return;
        }
        synchronized (dVar.f7602a) {
            try {
                if (dVar.f7603b == 3) {
                    return;
                }
                dVar.K(2);
                i2 i2Var = dVar.f7607f != null ? dVar.f7607f : null;
                if (i2Var != null) {
                    i2Var.g(dVar.f7626y);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean a0(d dVar) {
        boolean z10;
        synchronized (dVar.f7602a) {
            z10 = true;
            if (dVar.f7603b != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    public static Future o(Callable callable, long j10, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: d3.f0
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    zzc.zzn("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j10 * 0.95d));
            return futureSubmit;
        } catch (Exception e10) {
            zzc.zzo("BillingClient", "Async task throws exception!", e10);
            return null;
        }
    }

    public static String o0() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ void p(d dVar, j jVar, i iVar) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5157k;
        dVar.t0(zzieVar, 4, aVar);
        jVar.a(aVar, iVar.a());
    }

    public static /* synthetic */ void q(d dVar, r rVar) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5157k;
        dVar.t0(zzieVar, 9, aVar);
        rVar.a(aVar, zzbt.zzk());
    }

    public static /* synthetic */ void r(d dVar, g gVar) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5157k;
        dVar.t0(zzieVar, 13, aVar);
        gVar.a(aVar, null);
    }

    public static /* synthetic */ void s(d dVar, b bVar) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5157k;
        dVar.t0(zzieVar, 3, aVar);
        bVar.a(aVar);
    }

    public static /* synthetic */ void t(d dVar, q qVar) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5157k;
        dVar.t0(zzieVar, 7, aVar);
        qVar.a(aVar, new u(zzbt.zzk(), zzbt.zzk()));
    }

    public static /* synthetic */ void u(d dVar, com.android.billingclient.api.a aVar) {
        if (dVar.f7607f.d() != null) {
            dVar.f7607f.d().onPurchasesUpdated(aVar, null);
        } else {
            zzc.zzn("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void B(i iVar, j jVar) throws Throwable {
        zzam zzamVar;
        int iZza;
        String strZzj;
        String strA = iVar.a();
        try {
            zzc.zzm("BillingClient", "Consuming purchase with token: " + strA);
            synchronized (this.f7602a) {
                try {
                    try {
                        zzamVar = this.f7610i;
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
                } catch (DeadObjectException e10) {
                    e = e10;
                    D(jVar, strA, com.android.billingclient.api.c.f5156j, zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
                    return;
                } catch (Exception e11) {
                    e = e11;
                    D(jVar, strA, com.android.billingclient.api.c.f5154h, zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
                    return;
                }
            }
            if (zzamVar == null) {
                try {
                    D(jVar, strA, com.android.billingclient.api.c.f5156j, zzie.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                    return;
                } catch (DeadObjectException e12) {
                    e = e12;
                    D(jVar, strA, com.android.billingclient.api.c.f5156j, zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
                    return;
                } catch (Exception e13) {
                    e = e13;
                    D(jVar, strA, com.android.billingclient.api.c.f5154h, zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
                    return;
                }
            }
            if (this.f7617p) {
                String packageName = this.f7608g.getPackageName();
                boolean z10 = this.f7617p;
                String str = this.f7604c;
                String str2 = this.f7605d;
                long jLongValue = this.I.longValue();
                Bundle bundle = new Bundle();
                if (z10) {
                    zzc.zzc(bundle, str, str2, jLongValue);
                }
                Bundle bundleZze = zzamVar.zze(9, packageName, strA, bundle);
                iZza = bundleZze.getInt("RESPONSE_CODE");
                strZzj = zzc.zzj(bundleZze, "BillingClient");
            } else {
                iZza = zzamVar.zza(3, this.f7608g.getPackageName(), strA);
                strZzj = "";
            }
            com.android.billingclient.api.a aVarA = com.android.billingclient.api.c.a(iZza, strZzj);
            if (iZza == 0) {
                zzc.zzm("BillingClient", "Successfully consumed purchase.");
                jVar.a(aVarA, strA);
                return;
            }
            D(jVar, strA, aVarA, zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY, "Error consuming purchase with token. Response code: " + iZza, null);
        } catch (DeadObjectException e14) {
            e = e14;
        } catch (Exception e15) {
            e = e15;
        }
    }

    public final void C(b bVar, com.android.billingclient.api.a aVar, zzie zzieVar, Exception exc) {
        zzc.zzo("BillingClient", "Error in acknowledge purchase!", exc);
        v0(zzieVar, 3, aVar, o1.a(exc));
        bVar.a(aVar);
    }

    public final void D(j jVar, String str, com.android.billingclient.api.a aVar, zzie zzieVar, String str2, Exception exc) {
        zzc.zzo("BillingClient", str2, exc);
        v0(zzieVar, 4, aVar, o1.a(exc));
        jVar.a(aVar, str);
    }

    public final x0 D0(t tVar) {
        zzam zzamVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strC = tVar.c();
        zzbt zzbtVarB = tVar.b();
        int size = zzbtVarB.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 20;
            ArrayList<t.b> arrayList3 = new ArrayList(zzbtVarB.subList(i10, i11 > size ? size : i11));
            ArrayList<String> arrayList4 = new ArrayList<>();
            int size2 = arrayList3.size();
            for (int i12 = 0; i12 < size2; i12++) {
                arrayList4.add(((t.b) arrayList3.get(i12)).b());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
            String str = this.f7604c;
            bundle.putString("playBillingLibraryVersion", str);
            try {
                synchronized (this.f7602a) {
                    zzamVar = this.f7610i;
                }
                if (zzamVar == null) {
                    return g0(com.android.billingclient.api.c.f5156j, zzie.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                }
                boolean z10 = this.f7624w && this.D.b();
                n0(tVar);
                n0(tVar);
                n0(tVar);
                n0(tVar);
                Bundle bundleZzj = zzamVar.zzj(true != this.f7625x ? 17 : 20, this.f7608g.getPackageName(), strC, bundle, zzc.zzf(str, this.f7605d, arrayList3, null, null, zza.zza(z10, true, false, true, false, true), this.I.longValue()));
                if (bundleZzj == null) {
                    return g0(com.android.billingclient.api.c.B, zzie.NULL_BUNDLE_FROM_GET_SKU_DETAILS_SERVICE_CALL, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!bundleZzj.containsKey("DETAILS_LIST")) {
                    int iZzb = zzc.zzb(bundleZzj, "BillingClient");
                    String strZzj = zzc.zzj(bundleZzj, "BillingClient");
                    if (iZzb == 0) {
                        return g0(com.android.billingclient.api.c.a(6, strZzj), zzie.MISSING_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                    }
                    return g0(com.android.billingclient.api.c.a(iZzb, strZzj), zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY, "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb, null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return g0(com.android.billingclient.api.c.B, zzie.NULL_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "queryProductDetailsAsync got null response list", null);
                }
                ArrayList arrayList5 = new ArrayList();
                int size3 = stringArrayList.size();
                for (int i13 = 0; i13 < size3; i13++) {
                    try {
                        p pVar = new p(stringArrayList.get(i13));
                        zzc.zzm("BillingClient", "Got product details: ".concat(pVar.toString()));
                        arrayList5.add(pVar);
                    } catch (JSONException e10) {
                        return g0(com.android.billingclient.api.c.a(6, "Error trying to decode SkuDetails."), zzie.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e10);
                    }
                }
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("UNFETCHED_PRODUCT_LIST");
                new ArrayList();
                try {
                    ArrayList arrayList6 = new ArrayList();
                    if (stringArrayList2 == null) {
                        for (t.b bVar : arrayList3) {
                            Iterator it = arrayList5.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    arrayList6.add(new x(new JSONObject().put("productId", bVar.b()).put("type", bVar.c()).put("statusCode", 0).toString()));
                                    break;
                                }
                                p pVar2 = (p) it.next();
                                if (!bVar.b().equals(pVar2.e()) || !bVar.c().equals(pVar2.f())) {
                                }
                            }
                        }
                    } else {
                        Iterator<String> it2 = stringArrayList2.iterator();
                        while (it2.hasNext()) {
                            x xVar = new x(it2.next());
                            zzc.zzm("BillingClient", "Got unfetchedProduct: ".concat(xVar.toString()));
                            arrayList6.add(xVar);
                        }
                    }
                    arrayList.addAll(arrayList5);
                    arrayList2.addAll(arrayList6);
                    i10 = i11;
                } catch (JSONException e11) {
                    return g0(com.android.billingclient.api.c.a(6, "Error trying to decode SkuDetails."), zzie.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: ", e11);
                }
            } catch (DeadObjectException e12) {
                return g0(com.android.billingclient.api.c.f5156j, zzie.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e12);
            } catch (Exception e13) {
                return g0(com.android.billingclient.api.c.f5154h, zzie.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e13);
            }
        }
        return new x0(0, "", arrayList, arrayList2);
    }

    public final void E(g gVar, com.android.billingclient.api.a aVar, zzie zzieVar, Exception exc) {
        zzc.zzo("BillingClient", "getBillingConfig got an exception.", exc);
        v0(zzieVar, 13, aVar, o1.a(exc));
        gVar.a(aVar, null);
    }

    public final void F(int i10, zzie zzieVar, Exception exc) {
        zzhx zzhxVar;
        zzc.zzo("BillingClient", "showInAppMessages error.", exc);
        p1 p1Var = this.f7609h;
        String strA = o1.a(exc);
        try {
            zzic zzicVarZzc = zzig.zzc();
            zzicVarZzc.zzo(i10);
            if (zzieVar != null) {
                zzicVarZzc.zzn(zzieVar);
            }
            if (strA != null) {
                zzicVarZzc.zza(strA);
            }
            zzhv zzhvVarZzc = zzhx.zzc();
            zzhvVarZzc.zzl(zzicVarZzc);
            zzhvVarZzc.zzp(30);
            zzhxVar = (zzhx) zzhvVarZzc.zze();
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to create logging payload", th);
            zzhxVar = null;
        }
        p1Var.b(zzhxVar);
    }

    public final void G(zzhx zzhxVar) {
        try {
            this.f7609h.k(zzhxVar, this.f7614m);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final p1 G0() {
        return this.f7609h;
    }

    public final void H(zzhx zzhxVar, long j10, boolean z10) {
        try {
            this.f7609h.a(zzhxVar, this.f7614m, j10, z10);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void I(zzib zzibVar) {
        try {
            this.f7609h.d(zzibVar, this.f7614m);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void J(zzie zzieVar, com.android.billingclient.api.a aVar, int i10) {
        try {
            int i11 = o1.f7730a;
            zzhv zzhvVar = (zzhv) o1.b(zzieVar, 6, aVar, null, zzil.BROADCAST_ACTION_UNSPECIFIED).zzm();
            zzjt zzjtVarZzc = zzjv.zzc();
            zzjtVarZzc.zza(i10 > 0);
            zzjtVarZzc.zzl(i10);
            zzhvVar.zzo(zzjtVarZzc);
            G((zzhx) zzhvVar.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final com.android.billingclient.api.a J0(final com.android.billingclient.api.a aVar) {
        if (Thread.interrupted()) {
            return aVar;
        }
        this.f7606e.post(new Runnable() { // from class: d3.c0
            @Override // java.lang.Runnable
            public final void run() {
                d.u(this.f7596a, aVar);
            }
        });
        return aVar;
    }

    public final void K(int i10) {
        synchronized (this.f7602a) {
            try {
                if (this.f7603b == 3) {
                    return;
                }
                zzc.zzm("BillingClient", "Setting clientState from " + R(this.f7603b) + " to " + R(i10));
                this.f7603b = i10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void L() {
        ExecutorService executorService = this.H;
        if (executorService != null) {
            executorService.shutdownNow();
            this.H = null;
        }
    }

    public final void M(e eVar, int i10) {
        zzie zzieVar;
        com.android.billingclient.api.a aVarH0;
        com.android.billingclient.api.a aVar;
        synchronized (this.f7602a) {
            try {
                if (Q()) {
                    aVarH0 = h0(i10);
                } else {
                    if (this.f7603b == 1) {
                        zzc.zzn("BillingClient", "Client is already in the process of connecting to billing service.");
                        zzie zzieVar2 = zzie.BILLING_CLIENT_CONNECTING;
                        aVar = com.android.billingclient.api.c.f5150d;
                        J(zzieVar2, aVar, i10);
                    } else if (this.f7603b == 3) {
                        zzc.zzn("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                        zzie zzieVar3 = zzie.BILLING_CLIENT_CLOSED;
                        aVar = com.android.billingclient.api.c.f5156j;
                        J(zzieVar3, aVar, i10);
                    } else {
                        K(1);
                        if (i10 == 0) {
                            this.G = eVar;
                            i10 = 0;
                        }
                        N();
                        zzc.zzm("BillingClient", "Starting in-app billing setup.");
                        this.f7611j = new v0(this, eVar, i10, null);
                        this.f7611j.c();
                        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                        intent.setPackage("com.android.vending");
                        List<ResolveInfo> listQueryIntentServices = this.f7608g.getPackageManager().queryIntentServices(intent, 0);
                        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                            zzieVar = zzie.INTENT_SERVICE_NOT_FOUND;
                        } else {
                            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                            if (serviceInfo != null) {
                                String str = serviceInfo.packageName;
                                String str2 = serviceInfo.name;
                                if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                    zzieVar = zzie.INVALID_PHONESKY_PACKAGE;
                                    zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                                } else {
                                    ComponentName componentName = new ComponentName(str, str2);
                                    Intent intent2 = new Intent(intent);
                                    intent2.setComponent(componentName);
                                    intent2.putExtra("playBillingLibraryVersion", this.f7604c);
                                    synchronized (this.f7602a) {
                                        try {
                                            if (this.f7603b == 2) {
                                                aVarH0 = h0(i10);
                                            } else if (this.f7603b != 1) {
                                                zzc.zzn("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                                zzie zzieVar4 = zzie.BILLING_CLIENT_TRANSITIONED_OUT_OF_CONNECTING;
                                                aVar = com.android.billingclient.api.c.f5156j;
                                                J(zzieVar4, aVar, i10);
                                            } else {
                                                v0 v0Var = this.f7611j;
                                                if ((i10 <= 0 || Build.VERSION.SDK_INT < 29) ? this.f7608g.bindService(intent2, v0Var, 1) : this.f7608g.bindService(intent2, 1, n(), v0Var)) {
                                                    zzc.zzm("BillingClient", "Service was bonded successfully.");
                                                    aVarH0 = null;
                                                } else {
                                                    zzieVar = zzie.BILLING_SERVICE_BLOCKED;
                                                    zzc.zzn("BillingClient", "Connection to Billing service is blocked.");
                                                }
                                            }
                                        } finally {
                                        }
                                    }
                                }
                            } else {
                                zzieVar = zzie.INVALID_PHONESKY_PACKAGE;
                                zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                            }
                        }
                        K(0);
                        zzc.zzm("BillingClient", "Billing service unavailable on device.");
                        com.android.billingclient.api.a aVar2 = com.android.billingclient.api.c.f5148b;
                        J(zzieVar, aVar2, i10);
                        aVarH0 = aVar2;
                    }
                    aVarH0 = aVar;
                }
            } finally {
            }
        }
        if (aVarH0 != null) {
            eVar.onBillingSetupFinished(aVarH0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N() {
        synchronized (this.f7602a) {
            if (this.f7611j != null) {
                try {
                    this.f7608g.unbindService(this.f7611j);
                } catch (Throwable th) {
                    try {
                        zzc.zzo("BillingClient", "There was an exception while unbinding service!", th);
                        this.f7610i = null;
                        this.f7611j = null;
                    } finally {
                        this.f7610i = null;
                        this.f7611j = null;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean O(long j10) {
        try {
            com.android.billingclient.api.a aVar = (com.android.billingclient.api.a) j0(1).get(Build.VERSION.SDK_INT < 29 ? 0L : 3000L, TimeUnit.MILLISECONDS);
            if (aVar.c() == 0) {
                zzc.zzm("BillingClient", "Reconnection succeeded with result: " + aVar.c());
            } else {
                zzc.zzn("BillingClient", "Reconnection failed with result: " + aVar.c());
            }
        } catch (Exception e10) {
            if (e10 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            zzc.zzo("BillingClient", "Error during reconnection attempt: ", e10);
        }
        return Q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean P(long j10) {
        long jMax;
        zzbi zzbiVarZzb = zzbi.zzb(this.J);
        long jZza = 30000;
        for (int i10 = 1; i10 <= 3; i10++) {
            try {
                jMax = Math.max(0L, jZza);
            } catch (Exception e10) {
                if (e10 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                zzc.zzo("BillingClient", "Error during reconnection attempt: ", e10);
            }
            if (jMax <= 0) {
                zzc.zzn("BillingClient", "No time remaining for reconnection attempt.");
                return Q();
            }
            com.android.billingclient.api.a aVar = (com.android.billingclient.api.a) j0(i10).get(jMax, TimeUnit.MILLISECONDS);
            if (aVar.c() == 0) {
                zzc.zzm("BillingClient", "Reconnection succeeded with result: " + aVar.c());
                return Q();
            }
            zzc.zzn("BillingClient", "Reconnection failed with result: " + aVar.c());
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            jZza = HTTPTimeoutManager.DEFAULT_TIMEOUT_MS - zzbiVarZzb.zza(timeUnit);
            long jPow = ((long) Math.pow(2.0d, i10 - 1)) * 1000;
            if (jZza < jPow) {
                zzc.zzn("BillingClient", "Reconnection failed due to timeout limit reached.");
                return Q();
            }
            if (i10 < 3 && jPow > 0) {
                try {
                    Thread.sleep(jPow);
                    jZza = HTTPTimeoutManager.DEFAULT_TIMEOUT_MS - zzbiVarZzb.zza(timeUnit);
                } catch (InterruptedException e11) {
                    Thread.currentThread().interrupt();
                    zzc.zzo("BillingClient", "Error sleeping during reconnection attempt: ", e11);
                }
            }
        }
        zzc.zzn("BillingClient", "Max retries reached.");
        return Q();
    }

    public final boolean Q() {
        boolean z10;
        synchronized (this.f7602a) {
            try {
                z10 = false;
                if (this.f7603b == 2 && this.f7610i != null && this.f7611j != null) {
                    z10 = true;
                }
            } finally {
            }
        }
        return z10;
    }

    public final void Y(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f7606e.post(runnable);
        }
    }

    @Override // d3.c
    public void a(final a aVar, final b bVar) {
        if (o(new Callable() { // from class: d3.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                d.Q0(this.f7578a, bVar, aVar);
                return null;
            }
        }, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, new Runnable() { // from class: d3.b0
            @Override // java.lang.Runnable
            public final void run() {
                d.s(this.f7585a, bVar);
            }
        }, f0(), n()) == null) {
            com.android.billingclient.api.a aVarI0 = i0();
            t0(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 3, aVarI0);
            bVar.a(aVarI0);
        }
    }

    @Override // d3.c
    public void b(final i iVar, final j jVar) {
        if (o(new Callable() { // from class: d3.g0
            @Override // java.util.concurrent.Callable
            public final Object call() throws Throwable {
                d.O0(this.f7643a, jVar, iVar);
                return null;
            }
        }, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, new Runnable() { // from class: d3.i0
            @Override // java.lang.Runnable
            public final void run() {
                d.p(this.f7682a, jVar, iVar);
            }
        }, f0(), n()) == null) {
            com.android.billingclient.api.a aVarI0 = i0();
            t0(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 4, aVarI0);
            jVar.a(aVarI0, iVar.a());
        }
    }

    @Override // d3.c
    public void c() {
        y0(12);
        synchronized (this.f7602a) {
            try {
            } finally {
            }
            if (this.f7607f != null) {
                this.f7607f.f();
                try {
                    zzc.zzm("BillingClient", "Unbinding from service.");
                    N();
                } catch (Throwable th) {
                    zzc.zzo("BillingClient", "There was an exception while unbinding from the service while ending connection!", th);
                }
                try {
                    L();
                } finally {
                    try {
                    } finally {
                    }
                }
            } else {
                zzc.zzm("BillingClient", "Unbinding from service.");
                N();
                L();
            }
        }
    }

    @Override // d3.c
    public void d(k kVar, final g gVar) {
        if (o(new Callable() { // from class: d3.d0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                d.S0(this.f7628a, gVar);
                return null;
            }
        }, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, new Runnable() { // from class: d3.e0
            @Override // java.lang.Runnable
            public final void run() {
                d.r(this.f7634a, gVar);
            }
        }, f0(), n()) == null) {
            com.android.billingclient.api.a aVarI0 = i0();
            t0(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 13, aVarI0);
            gVar.a(aVarI0, null);
        }
    }

    public final /* synthetic */ Bundle d0(int i10, String str, String str2, h hVar, Bundle bundle) {
        zzam zzamVar;
        try {
            synchronized (this.f7602a) {
                zzamVar = this.f7610i;
            }
            return zzamVar == null ? zzc.zzd(com.android.billingclient.api.c.f5156j, zzie.SERVICE_RESET_TO_NULL) : zzamVar.zzg(i10, this.f7608g.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e10) {
            return zzc.zze(com.android.billingclient.api.c.f5156j, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, o1.a(e10));
        } catch (Exception e11) {
            return zzc.zze(com.android.billingclient.api.c.f5154h, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, o1.a(e11));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // d3.c
    public final com.android.billingclient.api.a e(String str) {
        if (!O(3000L)) {
            com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5156j;
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            if (aVar.c() != 0) {
                t0(zzieVar, 5, aVar);
                return aVar;
            }
            y0(5);
            return aVar;
        }
        com.android.billingclient.api.a aVar2 = com.android.billingclient.api.c.f5147a;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals("subscriptionsUpdate")) {
                    com.android.billingclient.api.a aVar3 = this.f7613l ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5159m;
                    s0(aVar3, zzie.SUBSCRIPTIONS_UPDATE_NOT_SUPPORTED, 3);
                    return aVar3;
                }
                break;
            case 96321:
                if (str.equals("aaa")) {
                    com.android.billingclient.api.a aVar4 = this.f7620s ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5161o;
                    s0(aVar4, zzie.CROSS_APP_NOT_SUPPORTED, 6);
                    return aVar4;
                }
                break;
            case 97314:
                if (str.equals("bbb")) {
                    com.android.billingclient.api.a aVar5 = this.f7618q ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5165s;
                    s0(aVar5, zzie.IN_APP_MESSAGE_NOT_SUPPORTED, 5);
                    return aVar5;
                }
                break;
            case 98307:
                if (str.equals("ccc")) {
                    com.android.billingclient.api.a aVar6 = this.f7621t ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5162p;
                    s0(aVar6, zzie.MULTI_ITEM_NOT_SUPPORTED, 8);
                    return aVar6;
                }
                break;
            case 99300:
                if (str.equals("ddd")) {
                    com.android.billingclient.api.a aVar7 = this.f7619r ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5163q;
                    s0(aVar7, zzie.OFFER_ID_TOKEN_NOT_SUPPORTED, 7);
                    return aVar7;
                }
                break;
            case 100293:
                if (str.equals("eee")) {
                    com.android.billingclient.api.a aVar8 = this.f7621t ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5162p;
                    s0(aVar8, zzie.PBL_FOR_PAYMENTS_GATEWAY_BUYFLOW_NOT_SUPPORTED, 9);
                    return aVar8;
                }
                break;
            case 101286:
                if (str.equals("fff")) {
                    com.android.billingclient.api.a aVar9 = this.f7622u ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5164r;
                    s0(aVar9, zzie.PRODUCT_DETAILS_NOT_SUPPORTED, 10);
                    return aVar9;
                }
                break;
            case 102279:
                if (str.equals("ggg")) {
                    com.android.billingclient.api.a aVar10 = this.f7623v ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5171y;
                    s0(aVar10, zzie.GET_BILLING_CONFIG_NOT_SUPPORTED, 11);
                    return aVar10;
                }
                break;
            case 103272:
                if (str.equals("hhh")) {
                    com.android.billingclient.api.a aVar11 = this.f7623v ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5172z;
                    s0(aVar11, zzie.QUERY_PRODUCT_DETAILS_WITH_SERIALIZED_DOCID_NOT_SUPPORTED, 12);
                    return aVar11;
                }
                break;
            case 104265:
                if (str.equals("iii")) {
                    com.android.billingclient.api.a aVar12 = this.f7625x ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.C;
                    s0(aVar12, zzie.QUERY_PRODUCT_DETAILS_WITH_DEVELOPER_SPECIFIED_ACCOUNT_NOT_SUPPORTED, 13);
                    return aVar12;
                }
                break;
            case 105258:
                if (str.equals("jjj")) {
                    com.android.billingclient.api.a aVar13 = this.f7626y ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.D;
                    s0(aVar13, zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, 14);
                    return aVar13;
                }
                break;
            case 106251:
                if (str.equals("kkk")) {
                    com.android.billingclient.api.a aVar14 = this.B ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.A;
                    s0(aVar14, zzie.LAUNCH_EXTERNAL_OFFER_FLOW_NOT_SUPPORTED, 18);
                    return aVar14;
                }
                break;
            case 107244:
                if (str.equals("lll")) {
                    com.android.billingclient.api.a aVar15 = this.A ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5167u;
                    s0(aVar15, zzie.MULTI_ITEM_WITH_SEASON_PASS_NOT_SUPPORTED, 19);
                    return aVar15;
                }
                break;
            case 108237:
                if (str.equals("mmm")) {
                    com.android.billingclient.api.a aVar16 = this.B ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5168v;
                    s0(aVar16, zzie.AUTO_PAY_NOT_SUPPORTED, 20);
                    return aVar16;
                }
                break;
            case 109230:
                if (str.equals("nnn")) {
                    com.android.billingclient.api.a aVar17 = this.C ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5169w;
                    s0(aVar17, zzie.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, 21);
                    return aVar17;
                }
                break;
            case 207616302:
                if (str.equals("priceChangeConfirmation")) {
                    com.android.billingclient.api.a aVar18 = this.f7616o ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5160n;
                    s0(aVar18, zzie.PRICE_CHANGE_CONFIRMATION_NOT_SUPPORTED, 4);
                    return aVar18;
                }
                break;
            case 1987365622:
                if (str.equals(CustomerInfoResponseJsonKeys.SUBSCRIPTIONS)) {
                    com.android.billingclient.api.a aVar19 = this.f7612k ? com.android.billingclient.api.c.f5155i : com.android.billingclient.api.c.f5158l;
                    s0(aVar19, zzie.SUBSCRIPTIONS_NOT_SUPPORTED, 2);
                    return aVar19;
                }
                break;
        }
        zzc.zzn("BillingClient", "Unsupported feature: ".concat(str));
        com.android.billingclient.api.a aVar20 = com.android.billingclient.api.c.f5170x;
        s0(aVar20, zzie.UNKNOWN_FEATURE, 1);
        return aVar20;
    }

    public final /* synthetic */ Bundle e0(String str, String str2) {
        zzam zzamVar;
        try {
            synchronized (this.f7602a) {
                zzamVar = this.f7610i;
            }
            return zzamVar == null ? zzc.zzd(com.android.billingclient.api.c.f5156j, zzie.SERVICE_RESET_TO_NULL) : zzamVar.zzf(3, this.f7608g.getPackageName(), str, str2, null);
        } catch (DeadObjectException e10) {
            return zzc.zze(com.android.billingclient.api.c.f5156j, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, o1.a(e10));
        } catch (Exception e11) {
            return zzc.zze(com.android.billingclient.api.c.f5154h, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, o1.a(e11));
        }
    }

    @Override // d3.c
    public final boolean f() {
        if (this.E) {
            return true;
        }
        return Q();
    }

    public final Handler f0() {
        return Looper.myLooper() == null ? this.f7606e : new Handler(Looper.myLooper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v0, types: [d3.d] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    @Override // d3.c
    public com.android.billingclient.api.a g(Activity activity, h hVar) {
        boolean zD;
        long j10;
        Future futureO;
        ?? r52;
        ?? r53;
        ?? r54;
        zzie zzieVarZzb;
        Object obj;
        String str;
        boolean z10;
        h.b bVar;
        long j11;
        boolean z11;
        long jNextLong = new Random().nextLong();
        if (this.f7607f == null || this.f7607f.d() == null) {
            zzie zzieVar = zzie.MISSING_LISTENER;
            com.android.billingclient.api.a aVar = com.android.billingclient.api.c.E;
            u0(zzieVar, 2, aVar, jNextLong);
            return aVar;
        }
        if (!O(3000L)) {
            zzie zzieVar2 = zzie.SERVICE_CONNECTION_NOT_READY;
            com.android.billingclient.api.a aVar2 = com.android.billingclient.api.c.f5156j;
            u0(zzieVar2, 2, aVar2, jNextLong);
            J0(aVar2);
            return aVar2;
        }
        synchronized (this.f7602a) {
            try {
                zD = this.f7611j != null ? this.f7611j.d() : false;
            } finally {
            }
        }
        ArrayList arrayListK = hVar.k();
        List listL = hVar.l();
        String string = null;
        android.support.v4.media.session.b.a(zzby.zza(arrayListK, null));
        h.b bVar2 = (h.b) zzby.zza(listL, null);
        final String strE = bVar2.b().e();
        final String strF = bVar2.b().f();
        if (strF.equals("subs") && !this.f7612k) {
            zzc.zzn("BillingClient", "Current client doesn't support subscriptions.");
            zzie zzieVar3 = zzie.SUBSCRIPTIONS_NOT_SUPPORTED;
            com.android.billingclient.api.a aVar3 = com.android.billingclient.api.c.f5158l;
            w0(zzieVar3, 2, aVar3, jNextLong, zD);
            J0(aVar3);
            return aVar3;
        }
        if (hVar.u() && !this.f7615n) {
            zzc.zzn("BillingClient", "Current client doesn't support extra params for buy intent.");
            zzie zzieVar4 = zzie.EXTRA_PARAMS_NOT_SUPPORTED;
            com.android.billingclient.api.a aVar4 = com.android.billingclient.api.c.f5152f;
            w0(zzieVar4, 2, aVar4, jNextLong, zD);
            J0(aVar4);
            return aVar4;
        }
        if (arrayListK.size() > 1 && !this.f7621t) {
            zzc.zzn("BillingClient", "Current client doesn't support multi-item purchases.");
            zzie zzieVar5 = zzie.MULTI_ITEM_NOT_SUPPORTED;
            com.android.billingclient.api.a aVar5 = com.android.billingclient.api.c.f5162p;
            w0(zzieVar5, 2, aVar5, jNextLong, zD);
            J0(aVar5);
            return aVar5;
        }
        if (!listL.isEmpty() && !this.f7622u) {
            zzc.zzn("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            zzie zzieVar6 = zzie.PRODUCT_DETAILS_NOT_SUPPORTED;
            com.android.billingclient.api.a aVar6 = com.android.billingclient.api.c.f5164r;
            w0(zzieVar6, 2, aVar6, jNextLong, zD);
            J0(aVar6);
            return aVar6;
        }
        com.android.billingclient.api.a aVarE = hVar.e();
        if (aVarE != com.android.billingclient.api.c.f5155i) {
            w0(zzie.INVALID_BILLING_FLOW_PARAMS, 2, aVarE, jNextLong, zD);
            J0(aVarE);
            return aVarE;
        }
        if (this.f7615n) {
            boolean z12 = this.f7617p;
            boolean z13 = this.f7624w;
            boolean zA = this.D.a();
            boolean zB = this.D.b();
            boolean z14 = this.F;
            String str2 = this.f7604c;
            String str3 = this.f7605d;
            boolean z15 = zD;
            long jLongValue = this.I.longValue();
            this.f7608g.getPackageName();
            int i10 = zzc.zza;
            final Bundle bundle = new Bundle();
            zzc.zzc(bundle, str2, str3, jLongValue);
            bundle.putLong("billingClientTransactionId", jNextLong);
            if (hVar.c() != 0) {
                bundle.putInt(com.amazon.a.a.o.b.f4558l, hVar.c());
            }
            if (!TextUtils.isEmpty(hVar.f())) {
                bundle.putString("accountId", hVar.f());
            }
            if (!TextUtils.isEmpty(hVar.g())) {
                bundle.putString("obfuscatedProfileId", hVar.g());
            }
            if (hVar.t()) {
                bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
            }
            if (!TextUtils.isEmpty(hVar.i())) {
                bundle.putString("oldSkuPurchaseToken", hVar.i());
            }
            hVar.h();
            if (TextUtils.isEmpty(null)) {
                str = null;
            } else {
                hVar.h();
                str = null;
                bundle.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(hVar.j())) {
                bundle.putString("originalExternalTransactionId", hVar.j());
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("paymentsPurchaseParams", str);
            }
            if (z12 && zA) {
                z10 = true;
                bundle.putBoolean(com.amazon.a.a.o.b.f4542ac, true);
            } else {
                z10 = true;
            }
            if (z13 && zB) {
                bundle.putBoolean("enablePendingPurchaseForSubscriptions", z10);
            }
            if (z14) {
                bundle.putBoolean("enableAlternativeBilling", z10);
            }
            hVar.d();
            hVar.b();
            ArrayList arrayList = new ArrayList();
            for (h.b bVar3 : hVar.l()) {
            }
            if (!arrayList.isEmpty()) {
                zzdj zzdjVarZza = zzdk.zza();
                zzdjVarZza.zza(arrayList);
                bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzdk) zzdjVarZza.zze()).zzM());
            }
            if (arrayListK.isEmpty()) {
                ArrayList<String> arrayList2 = new ArrayList<>(listL.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>(listL.size() - 1);
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<String> arrayList6 = new ArrayList<>();
                ArrayList<Integer> arrayList7 = new ArrayList<>();
                long j12 = jNextLong;
                for (int i11 = 0; i11 < listL.size(); i11++) {
                    h.b bVar4 = (h.b) listL.get(i11);
                    p pVarB = bVar4.b();
                    if (pVarB.j().isEmpty()) {
                        bVar = bVar4;
                    } else {
                        bVar = bVar4;
                        arrayList4.add(pVarB.j());
                    }
                    arrayList5.add(bVar.c());
                    String strK = pVarB.k();
                    if (pVarB.l() != null && !pVarB.l().isEmpty()) {
                        Iterator it = pVarB.l().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            p.b bVar5 = (p.b) it.next();
                            if (!TextUtils.isEmpty(bVar5.f())) {
                                strK = bVar5.f();
                                break;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(strK)) {
                        arrayList6.add(strK);
                    }
                    if (i11 > 0) {
                        arrayList2.add(((h.b) listL.get(i11)).b().e());
                        arrayList3.add(((h.b) listL.get(i11)).b().f());
                    }
                }
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList5);
                if (!arrayList7.isEmpty()) {
                    bundle.putIntegerArrayList("autoPayBalanceThresholdList", arrayList7);
                }
                if (!arrayList4.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList4);
                }
                if (!arrayList6.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList6);
                }
                j11 = j12;
                if (!arrayList2.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList2);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList3);
                    j11 = j12;
                }
            } else {
                ArrayList<String> arrayList8 = new ArrayList<>();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                Iterator it2 = arrayListK.iterator();
                if (it2.hasNext()) {
                    android.support.v4.media.session.b.a(it2.next());
                    throw null;
                }
                if (!arrayList8.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList8);
                }
                if (arrayListK.size() > 1) {
                    ArrayList<String> arrayList9 = new ArrayList<>(arrayListK.size() - 1);
                    ArrayList<String> arrayList10 = new ArrayList<>(arrayListK.size() - 1);
                    if (1 < arrayListK.size()) {
                        android.support.v4.media.session.b.a(arrayListK.get(1));
                        throw null;
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList9);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList10);
                }
                j11 = jNextLong;
            }
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.f7619r) {
                zzie zzieVar7 = zzie.OFFER_ID_TOKEN_NOT_SUPPORTED;
                com.android.billingclient.api.a aVar7 = com.android.billingclient.api.c.f5163q;
                w0(zzieVar7, 2, aVar7, j11, z15);
                J0(aVar7);
                return aVar7;
            }
            zD = z15;
            if (bVar2 == null || TextUtils.isEmpty(bVar2.b().i())) {
                string = null;
                z11 = false;
            } else {
                bundle.putString("skuPackageName", bVar2.b().i());
                string = null;
                z11 = true;
            }
            if (!TextUtils.isEmpty(string)) {
                bundle.putString("accountName", string);
            }
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzc.zzn("BillingClient", "Activity's intent is null.");
            } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                bundle.putString("proxyPackage", stringExtra);
                try {
                    bundle.putString("proxyPackageVersion", this.f7608g.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                } catch (PackageManager.NameNotFoundException unused) {
                    bundle.putString("proxyPackageVersion", "package not found");
                }
            }
            final int i12 = (!this.f7622u || listL.isEmpty()) ? (this.f7620s && z11) ? 15 : this.f7617p ? 9 : 6 : 17;
            final h hVar2 = hVar;
            futureO = o(new Callable() { // from class: d3.l2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f7709a.d0(i12, strE, strF, hVar2, bundle);
                }
            }, 5000L, null, this.f7606e, n());
            r52 = hVar2;
            j10 = j11;
        } else {
            j10 = jNextLong;
            futureO = o(new Callable() { // from class: d3.m2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f7717a.e0(strE, strF);
                }
            }, 5000L, null, this.f7606e, n());
            r52 = jNextLong;
        }
        try {
            if (futureO != null) {
                long j13 = j10;
                Bundle bundle2 = (Bundle) futureO.get(5000L, TimeUnit.MILLISECONDS);
                int iZzb = zzc.zzb(bundle2, "BillingClient");
                String strZzj = zzc.zzj(bundle2, "BillingClient");
                if (iZzb == 0) {
                    Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                    intent2.putExtra("BUY_INTENT", (PendingIntent) bundle2.getParcelable("BUY_INTENT"));
                    intent2.putExtra("billingClientTransactionId", j13);
                    intent2.putExtra("wasServiceAutoReconnected", zD);
                    activity.startActivity(intent2);
                    return com.android.billingclient.api.c.f5155i;
                }
                zzc.zzn("BillingClient", "Unable to buy item, Error response code: " + iZzb);
                com.android.billingclient.api.a aVarA = com.android.billingclient.api.c.a(iZzb, strZzj);
                try {
                    if (bundle2 == null || (obj = bundle2.get("LOG_REASON")) == null) {
                        zzieVarZzb = zzie.REASON_UNSPECIFIED;
                    } else if (obj instanceof Integer) {
                        zzieVarZzb = zzie.zzb(((Integer) obj).intValue());
                    } else {
                        zzc.zzn("BillingClient", "Unexpected type for bundle log reason: " + obj.getClass().getName());
                        zzieVarZzb = zzie.REASON_UNSPECIFIED;
                    }
                } catch (Throwable th) {
                    zzc.zzn("BillingClient", "Failed to get log reason from bundle: ".concat(String.valueOf(th.getMessage())));
                    zzieVarZzb = zzie.REASON_UNSPECIFIED;
                }
                if (zzieVarZzb == zzie.REASON_UNSPECIFIED) {
                    zzieVarZzb = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                }
                zzie zzieVar8 = zzieVarZzb;
                if (bundle2 != null) {
                    try {
                        string = bundle2.getString("ADDITIONAL_LOG_DETAILS");
                    } catch (Throwable th2) {
                        zzc.zzn("BillingClient", "Failed to get additional log details from bundle: ".concat(String.valueOf(th2.getMessage())));
                    }
                }
                try {
                    x0(zzieVar8, 2, aVarA, string, j13, zD);
                    J0(aVarA);
                    return aVarA;
                } catch (CancellationException e10) {
                    e = e10;
                    r54 = j13;
                    zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar9 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    com.android.billingclient.api.a aVar8 = com.android.billingclient.api.c.f5157k;
                    x0(zzieVar9, 2, aVar8, o1.a(e), r54, zD);
                    J0(aVar8);
                    return aVar8;
                } catch (TimeoutException e11) {
                    e = e11;
                    r54 = j13;
                    zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar92 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    com.android.billingclient.api.a aVar82 = com.android.billingclient.api.c.f5157k;
                    x0(zzieVar92, 2, aVar82, o1.a(e), r54, zD);
                    J0(aVar82);
                    return aVar82;
                } catch (Exception e12) {
                    e = e12;
                    r53 = j13;
                    zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                    zzie zzieVar10 = zzie.LAUNCH_BILLING_FLOW_EXCEPTION;
                    com.android.billingclient.api.a aVar9 = com.android.billingclient.api.c.f5156j;
                    x0(zzieVar10, 2, aVar9, o1.a(e), r53, zD);
                    J0(aVar9);
                    return aVar9;
                }
            }
            try {
                zzie zzieVar11 = zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC;
                com.android.billingclient.api.a aVar10 = com.android.billingclient.api.c.f5149c;
                boolean z16 = zD;
                long j14 = j10;
                try {
                    w0(zzieVar11, 2, aVar10, j14, z16);
                    J0(aVar10);
                    return aVar10;
                } catch (CancellationException e13) {
                    e = e13;
                    zD = z16;
                    r54 = j14;
                    zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar922 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    com.android.billingclient.api.a aVar822 = com.android.billingclient.api.c.f5157k;
                    x0(zzieVar922, 2, aVar822, o1.a(e), r54, zD);
                    J0(aVar822);
                    return aVar822;
                } catch (TimeoutException e14) {
                    e = e14;
                    zD = z16;
                    r54 = j14;
                    zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar9222 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    com.android.billingclient.api.a aVar8222 = com.android.billingclient.api.c.f5157k;
                    x0(zzieVar9222, 2, aVar8222, o1.a(e), r54, zD);
                    J0(aVar8222);
                    return aVar8222;
                } catch (Exception e15) {
                    e = e15;
                    zD = z16;
                    r53 = j14;
                    zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                    zzie zzieVar102 = zzie.LAUNCH_BILLING_FLOW_EXCEPTION;
                    com.android.billingclient.api.a aVar92 = com.android.billingclient.api.c.f5156j;
                    x0(zzieVar102, 2, aVar92, o1.a(e), r53, zD);
                    J0(aVar92);
                    return aVar92;
                }
            } catch (CancellationException e16) {
                e = e16;
                r54 = j10;
                zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzie zzieVar92222 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                com.android.billingclient.api.a aVar82222 = com.android.billingclient.api.c.f5157k;
                x0(zzieVar92222, 2, aVar82222, o1.a(e), r54, zD);
                J0(aVar82222);
                return aVar82222;
            } catch (TimeoutException e17) {
                e = e17;
                r54 = j10;
                zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzie zzieVar922222 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                com.android.billingclient.api.a aVar822222 = com.android.billingclient.api.c.f5157k;
                x0(zzieVar922222, 2, aVar822222, o1.a(e), r54, zD);
                J0(aVar822222);
                return aVar822222;
            } catch (Exception e18) {
                e = e18;
                r53 = j10;
            }
        } catch (CancellationException e19) {
            e = e19;
        } catch (TimeoutException e20) {
            e = e20;
            r54 = r52;
        } catch (Exception e21) {
            e = e21;
        }
    }

    public final x0 g0(com.android.billingclient.api.a aVar, zzie zzieVar, String str, Exception exc) {
        zzc.zzo("BillingClient", str, exc);
        v0(zzieVar, 7, aVar, o1.a(exc));
        return new x0(aVar.c(), aVar.a(), new ArrayList(), new ArrayList());
    }

    public final com.android.billingclient.api.a h0(int i10) {
        zzc.zzm("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzhz zzhzVarZzc = zzib.zzc();
        zzhzVarZzc.zzo(6);
        zzjt zzjtVarZzc = zzjv.zzc();
        zzjtVarZzc.zzn(true);
        zzjtVarZzc.zza(i10 > 0);
        zzjtVarZzc.zzl(i10);
        zzhzVarZzc.zzn(zzjtVarZzc);
        I((zzib) zzhzVarZzc.zze());
        return com.android.billingclient.api.c.f5155i;
    }

    @Override // d3.c
    public void i(final t tVar, final q qVar) {
        if (o(new Callable() { // from class: d3.h0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                d.P0(this.f7671a, qVar, tVar);
                return null;
            }
        }, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, new Runnable() { // from class: d3.j0
            @Override // java.lang.Runnable
            public final void run() {
                d.t(this.f7695a, qVar);
            }
        }, f0(), n()) == null) {
            com.android.billingclient.api.a aVarI0 = i0();
            t0(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 7, aVarI0);
            qVar.a(aVarI0, new u(zzbt.zzk(), zzbt.zzk()));
        }
    }

    public final com.android.billingclient.api.a i0() {
        int[] iArr = {0, 3};
        synchronized (this.f7602a) {
            for (int i10 = 0; i10 < 2; i10++) {
                if (this.f7603b == iArr[i10]) {
                    return com.android.billingclient.api.c.f5156j;
                }
            }
            return com.android.billingclient.api.c.f5154h;
        }
    }

    @Override // d3.c
    public final void j(w wVar, final r rVar) {
        if (o(new n0(this, rVar, wVar.b(), false), HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, new Runnable() { // from class: d3.l0
            @Override // java.lang.Runnable
            public final void run() {
                d.q(this.f7707a, rVar);
            }
        }, f0(), n()) == null) {
            com.android.billingclient.api.a aVarI0 = i0();
            t0(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 9, aVarI0);
            rVar.a(aVarI0, zzbt.zzk());
        }
    }

    public final zzcz j0(final int i10) {
        if (this.E && !Q()) {
            return zzu.zza(new zzr() { // from class: d3.k2
                @Override // com.google.android.gms.internal.play_billing.zzr
                public final Object zza(zzp zzpVar) {
                    return d.N0(this.f7703a, i10, zzpVar);
                }
            });
        }
        zzc.zzm("BillingClient", "Already connected or not opted into auto reconnection.");
        return zzcu.zza(com.android.billingclient.api.c.f5155i);
    }

    @Override // d3.c
    public final com.android.billingclient.api.a k(final Activity activity, l lVar, m mVar) {
        if (!O(3000L)) {
            zzc.zzn("BillingClient", "Service disconnected.");
            return com.android.billingclient.api.c.f5156j;
        }
        if (!this.f7618q) {
            zzc.zzn("BillingClient", "Current client doesn't support showing in-app messages.");
            return com.android.billingclient.api.c.f5165s;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        h0.e.a(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.f7604c);
        String str = this.f7605d;
        if (str != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str);
        }
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", lVar.b());
        Handler handler = this.f7606e;
        final o0 o0Var = new o0(this, handler, mVar);
        o(new Callable() { // from class: d3.k0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                d.R0(this.f7698a, bundle, activity, o0Var);
                return null;
            }
        }, 5000L, null, handler, n());
        return com.android.billingclient.api.c.f5155i;
    }

    public final /* synthetic */ Object k0(b bVar, a aVar) {
        zzam zzamVar;
        try {
            if (!P(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS)) {
                zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
                com.android.billingclient.api.a aVar2 = com.android.billingclient.api.c.f5156j;
                t0(zzieVar, 3, aVar2);
                bVar.a(aVar2);
            } else if (TextUtils.isEmpty(aVar.a())) {
                zzc.zzn("BillingClient", "Please provide a valid purchase token.");
                zzie zzieVar2 = zzie.EMPTY_PURCHASE_TOKEN;
                com.android.billingclient.api.a aVar3 = com.android.billingclient.api.c.f5153g;
                t0(zzieVar2, 3, aVar3);
                bVar.a(aVar3);
            } else if (this.f7617p) {
                synchronized (this.f7602a) {
                    zzamVar = this.f7610i;
                }
                if (zzamVar != null) {
                    String packageName = this.f7608g.getPackageName();
                    String strA = aVar.a();
                    String str = this.f7604c;
                    String str2 = this.f7605d;
                    long jLongValue = this.I.longValue();
                    int i10 = zzc.zza;
                    Bundle bundle = new Bundle();
                    zzc.zzc(bundle, str, str2, jLongValue);
                    Bundle bundleZzd = zzamVar.zzd(9, packageName, strA, bundle);
                    bVar.a(com.android.billingclient.api.c.a(zzc.zzb(bundleZzd, "BillingClient"), zzc.zzj(bundleZzd, "BillingClient")));
                    return null;
                }
                C(bVar, com.android.billingclient.api.c.f5156j, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzie zzieVar3 = zzie.API_VERSION_NOT_V9;
                com.android.billingclient.api.a aVar4 = com.android.billingclient.api.c.f5147a;
                t0(zzieVar3, 3, aVar4);
                bVar.a(aVar4);
            }
            return null;
        } catch (DeadObjectException e10) {
            C(bVar, com.android.billingclient.api.c.f5156j, zzie.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e10);
            return null;
        } catch (Exception e11) {
            C(bVar, com.android.billingclient.api.c.f5154h, zzie.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e11);
            return null;
        }
    }

    @Override // d3.c
    public void l(e eVar) {
        M(eVar, 0);
    }

    public final /* synthetic */ Object l0(g gVar) {
        zzam zzamVar;
        y0 y0Var = null;
        try {
            if (!P(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS)) {
                zzc.zzn("BillingClient", "Service disconnected.");
                zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
                com.android.billingclient.api.a aVar = com.android.billingclient.api.c.f5156j;
                t0(zzieVar, 13, aVar);
                gVar.a(aVar, null);
            } else if (this.f7623v) {
                synchronized (this.f7602a) {
                    zzamVar = this.f7610i;
                }
                if (zzamVar == null) {
                    E(gVar, com.android.billingclient.api.c.f5156j, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.f7608g.getPackageName();
                    String str = this.f7604c;
                    String str2 = this.f7605d;
                    long jLongValue = this.I.longValue();
                    int i10 = zzc.zza;
                    Bundle bundle = new Bundle();
                    zzc.zzc(bundle, str, str2, jLongValue);
                    zzamVar.zzn(18, packageName, bundle, new com.android.billingclient.api.b(gVar, this.f7609h, this.f7614m, y0Var));
                }
            } else {
                zzc.zzn("BillingClient", "Current client doesn't support get billing config.");
                zzie zzieVar2 = zzie.GET_BILLING_CONFIG_NOT_SUPPORTED;
                com.android.billingclient.api.a aVar2 = com.android.billingclient.api.c.f5171y;
                t0(zzieVar2, 13, aVar2);
                gVar.a(aVar2, null);
            }
        } catch (DeadObjectException e10) {
            E(gVar, com.android.billingclient.api.c.f5156j, zzie.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e10);
        } catch (Exception e11) {
            E(gVar, com.android.billingclient.api.c.f5154h, zzie.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e11);
        }
        return null;
    }

    public final void m(Context context, s sVar, o oVar, p0 p0Var, String str, p1 p1Var, c.a aVar) {
        this.f7608g = context.getApplicationContext();
        zziq zziqVarZzc = zzis.zzc();
        zziqVarZzc.zzs(str);
        String str2 = this.f7605d;
        if (str2 != null) {
            zziqVarZzc.zzt(str2);
        }
        zziqVarZzc.zzq(this.f7608g.getPackageName());
        zziqVarZzc.zzn(this.I.longValue());
        zziqVarZzc.zzr(aVar.f7595f);
        zziqVarZzc.zza(Build.VERSION.SDK_INT);
        zziqVarZzc.zzp(772604006L);
        try {
            zziqVarZzc.zzl(this.f7608g.getPackageManager().getPackageInfo(this.f7608g.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (p1Var != null) {
            this.f7609h = p1Var;
        } else {
            this.f7609h = new s1(this.f7608g, (zzis) zziqVarZzc.zze());
        }
        if (sVar == null) {
            zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.f7607f = new i2(this.f7608g, sVar, null, p0Var, null, this.f7609h);
        this.D = oVar;
        this.F = p0Var != null;
        this.f7608g.getPackageName();
        this.E = aVar.f7595f;
    }

    public final /* synthetic */ Object m0(Bundle bundle, Activity activity, ResultReceiver resultReceiver) {
        zzam zzamVar;
        try {
            synchronized (this.f7602a) {
                zzamVar = this.f7610i;
            }
            if (zzamVar == null) {
                F(-1, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzamVar.zzr(12, this.f7608g.getPackageName(), bundle, new w0(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e10) {
            F(-1, zzie.SERVICE_CALL_EXCEPTION, e10);
        } catch (Exception e11) {
            F(6, zzie.SERVICE_CALL_EXCEPTION, e11);
        }
        return null;
    }

    public final synchronized ExecutorService n() {
        try {
            if (this.H == null) {
                this.H = Executors.newFixedThreadPool(zzc.zza, new m0(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.H;
    }

    public final String n0(t tVar) {
        if (TextUtils.isEmpty(null)) {
            return this.f7608g.getPackageName();
        }
        return null;
    }

    public final d2 q0(int i10, com.android.billingclient.api.a aVar, zzie zzieVar, String str, Exception exc) {
        v0(zzieVar, 9, aVar, o1.a(exc));
        zzc.zzo("BillingClient", str, exc);
        return new d2(aVar, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0165 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d3.d2 r0(java.lang.String r17, boolean r18, int r19) {
        /*
            Method dump skipped, instruction units count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.d.r0(java.lang.String, boolean, int):d3.d2");
    }

    public final void s0(com.android.billingclient.api.a aVar, zzie zzieVar, int i10) {
        zzib zzibVar = null;
        zzhx zzhxVar = null;
        if (aVar.c() == 0) {
            int i11 = o1.f7730a;
            try {
                zzhz zzhzVarZzc = zzib.zzc();
                zzhzVarZzc.zzo(5);
                zziw zziwVarZzc = zziz.zzc();
                zziwVarZzc.zza(i10);
                zzhzVarZzc.zzl((zziz) zziwVarZzc.zze());
                zzibVar = (zzib) zzhzVarZzc.zze();
            } catch (Exception e10) {
                zzc.zzo("BillingLogger", "Unable to create logging payload", e10);
            }
            I(zzibVar);
            return;
        }
        int i12 = o1.f7730a;
        try {
            zzhv zzhvVarZzc = zzhx.zzc();
            zzic zzicVarZzc = zzig.zzc();
            zzicVarZzc.zzo(aVar.c());
            zzicVarZzc.zzl(aVar.a());
            zzicVarZzc.zzn(zzieVar);
            zzhvVarZzc.zzl(zzicVarZzc);
            zzhvVarZzc.zzp(5);
            zziw zziwVarZzc2 = zziz.zzc();
            zziwVarZzc2.zza(i10);
            zzhvVarZzc.zzm((zziz) zziwVarZzc2.zze());
            zzhxVar = (zzhx) zzhvVarZzc.zze();
        } catch (Exception e11) {
            zzc.zzo("BillingLogger", "Unable to create logging payload", e11);
        }
        G(zzhxVar);
    }

    public final void t0(zzie zzieVar, int i10, com.android.billingclient.api.a aVar) {
        try {
            int i11 = o1.f7730a;
            G(o1.b(zzieVar, i10, aVar, null, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void u0(zzie zzieVar, int i10, com.android.billingclient.api.a aVar, long j10) {
        try {
            int i11 = o1.f7730a;
            try {
                this.f7609h.j(o1.b(zzieVar, 2, aVar, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.f7614m, j10);
            } catch (Throwable th) {
                zzc.zzo("BillingClient", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            zzc.zzo("BillingClient", "Unable to log.", th2);
        }
    }

    public final void v0(zzie zzieVar, int i10, com.android.billingclient.api.a aVar, String str) {
        try {
            int i11 = o1.f7730a;
            G(o1.b(zzieVar, i10, aVar, str, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void w0(zzie zzieVar, int i10, com.android.billingclient.api.a aVar, long j10, boolean z10) {
        try {
            int i11 = o1.f7730a;
            H(o1.b(zzieVar, 2, aVar, null, zzil.BROADCAST_ACTION_UNSPECIFIED), j10, z10);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void x0(zzie zzieVar, int i10, com.android.billingclient.api.a aVar, String str, long j10, boolean z10) {
        try {
            int i11 = o1.f7730a;
            H(o1.b(zzieVar, 2, aVar, str, zzil.BROADCAST_ACTION_UNSPECIFIED), j10, z10);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void y0(int i10) {
        try {
            int i11 = o1.f7730a;
            I(o1.c(i10, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public d(String str, o oVar, Context context, v1 v1Var, p1 p1Var, ExecutorService executorService, c.a aVar) {
        this.f7602a = new Object();
        this.f7603b = 0;
        this.f7606e = new Handler(Looper.getMainLooper());
        this.f7614m = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.I = lValueOf;
        this.J = zzaz.zza();
        this.f7604c = BuildConfig.BILLING_CLIENT_VERSION;
        String strO0 = o0();
        this.f7605d = strO0;
        this.f7608g = context.getApplicationContext();
        zziq zziqVarZzc = zzis.zzc();
        zziqVarZzc.zzs(BuildConfig.BILLING_CLIENT_VERSION);
        if (strO0 != null) {
            zziqVarZzc.zzt(strO0);
        }
        zziqVarZzc.zzq(this.f7608g.getPackageName());
        zziqVarZzc.zzn(lValueOf.longValue());
        zziqVarZzc.zzr(aVar.f7595f);
        zziqVarZzc.zza(Build.VERSION.SDK_INT);
        zziqVarZzc.zzp(772604006L);
        try {
            zziqVarZzc.zzl(this.f7608g.getPackageManager().getPackageInfo(this.f7608g.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.f7609h = new s1(this.f7608g, (zzis) zziqVarZzc.zze());
        zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.f7607f = new i2(this.f7608g, null, null, null, null, this.f7609h);
        this.D = oVar;
        this.f7608g.getPackageName();
        this.E = aVar.f7595f;
    }

    public d(String str, o oVar, Context context, s sVar, p0 p0Var, p1 p1Var, ExecutorService executorService, c.a aVar) {
        this.f7602a = new Object();
        this.f7603b = 0;
        this.f7606e = new Handler(Looper.getMainLooper());
        this.f7614m = 0;
        this.I = Long.valueOf(new Random().nextLong());
        this.J = zzaz.zza();
        this.f7604c = BuildConfig.BILLING_CLIENT_VERSION;
        this.f7605d = o0();
        m(context, sVar, oVar, null, BuildConfig.BILLING_CLIENT_VERSION, null, aVar);
    }
}
