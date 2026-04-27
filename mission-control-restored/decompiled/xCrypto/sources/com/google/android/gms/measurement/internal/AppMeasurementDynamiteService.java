package com.google.android.gms.measurement.internal;

import J1.a;
import J1.b;
import S1.AbstractC0620l5;
import S1.B4;
import S1.C0540b5;
import S1.C0658q3;
import S1.H;
import S1.InterfaceC0571f4;
import S1.J;
import S1.N4;
import S1.P3;
import S1.Q4;
import S1.RunnableC0610k3;
import S1.RunnableC0635n4;
import S1.RunnableC0651p4;
import S1.RunnableC0659q4;
import S1.RunnableC0683t5;
import S1.T5;
import S1.V6;
import S1.l7;
import S1.m7;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzcq;
import com.google.android.gms.internal.measurement.zzcu;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdc;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzdf;
import java.util.Map;
import u.C1853a;

/* JADX INFO: loaded from: classes.dex */
public class AppMeasurementDynamiteService extends zzcq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0658q3 f10063a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f10064b = new C1853a();

    public final void a0() {
        if (this.f10063a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public final void b0(zzcu zzcuVar, String str) {
        a0();
        this.f10063a.C().a0(zzcuVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void beginAdUnitExposure(String str, long j4) {
        a0();
        this.f10063a.M().i(str, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        a0();
        this.f10063a.B().O(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void clearMeasurementEnabled(long j4) {
        a0();
        this.f10063a.B().m0(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void endAdUnitExposure(String str, long j4) {
        a0();
        this.f10063a.M().j(str, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void generateEventId(zzcu zzcuVar) {
        a0();
        long jP0 = this.f10063a.C().p0();
        a0();
        this.f10063a.C().b0(zzcuVar, jP0);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getAppInstanceId(zzcu zzcuVar) {
        a0();
        this.f10063a.b().t(new RunnableC0610k3(this, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCachedAppInstanceId(zzcu zzcuVar) {
        a0();
        b0(zzcuVar, this.f10063a.B().D());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getConditionalUserProperties(String str, String str2, zzcu zzcuVar) {
        a0();
        this.f10063a.b().t(new RunnableC0683t5(this, zzcuVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenClass(zzcu zzcuVar) {
        a0();
        b0(zzcuVar, this.f10063a.B().R());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenName(zzcu zzcuVar) {
        a0();
        b0(zzcuVar, this.f10063a.B().Q());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getGmpAppId(zzcu zzcuVar) {
        String strA;
        a0();
        C0540b5 c0540b5B = this.f10063a.B();
        try {
            strA = AbstractC0620l5.a(c0540b5B.f4245a.e(), "google_app_id", c0540b5B.f4245a.H());
        } catch (IllegalStateException e4) {
            c0540b5B.f4245a.a().o().b("getGoogleAppId failed with exception", e4);
            strA = null;
        }
        b0(zzcuVar, strA);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getMaxUserProperties(String str, zzcu zzcuVar) {
        a0();
        this.f10063a.B().L(str);
        a0();
        this.f10063a.C().c0(zzcuVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getSessionId(zzcu zzcuVar) {
        a0();
        C0540b5 c0540b5B = this.f10063a.B();
        c0540b5B.f4245a.b().t(new B4(c0540b5B, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getTestFlag(zzcu zzcuVar, int i4) {
        a0();
        if (i4 == 0) {
            this.f10063a.C().a0(zzcuVar, this.f10063a.B().i0());
            return;
        }
        if (i4 == 1) {
            this.f10063a.C().b0(zzcuVar, this.f10063a.B().j0().longValue());
            return;
        }
        if (i4 != 2) {
            if (i4 == 3) {
                this.f10063a.C().c0(zzcuVar, this.f10063a.B().k0().intValue());
                return;
            } else {
                if (i4 != 4) {
                    return;
                }
                this.f10063a.C().e0(zzcuVar, this.f10063a.B().h0().booleanValue());
                return;
            }
        }
        l7 l7VarC = this.f10063a.C();
        double dDoubleValue = this.f10063a.B().l0().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e4) {
            l7VarC.f4245a.a().r().b("Error returning double value to wrapper", e4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getUserProperties(String str, String str2, boolean z4, zzcu zzcuVar) {
        a0();
        this.f10063a.b().t(new RunnableC0659q4(this, zzcuVar, str, str2, z4));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void initForTests(Map map) {
        a0();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void initialize(a aVar, zzdd zzddVar, long j4) {
        C0658q3 c0658q3 = this.f10063a;
        if (c0658q3 == null) {
            this.f10063a = C0658q3.O((Context) AbstractC0940s.k((Context) b.c(aVar)), zzddVar, Long.valueOf(j4));
        } else {
            c0658q3.a().r().a("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void isDataCollectionEnabled(zzcu zzcuVar) {
        a0();
        this.f10063a.b().t(new T5(this, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logEvent(String str, String str2, Bundle bundle, boolean z4, boolean z5, long j4) {
        a0();
        this.f10063a.B().q(str, str2, bundle, z4, z5, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcu zzcuVar, long j4) {
        a0();
        AbstractC0940s.e(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.f10063a.b().t(new P3(this, zzcuVar, new J(str2, new H(bundle), "app", j4), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logHealthData(int i4, String str, a aVar, a aVar2, a aVar3) {
        a0();
        this.f10063a.a().y(i4, true, false, str, aVar == null ? null : b.c(aVar), aVar2 == null ? null : b.c(aVar2), aVar3 != null ? b.c(aVar3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreated(a aVar, Bundle bundle, long j4) {
        a0();
        onActivityCreatedByScionActivityInfo(zzdf.zza((Activity) AbstractC0940s.k((Activity) b.c(aVar))), bundle, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreatedByScionActivityInfo(zzdf zzdfVar, Bundle bundle, long j4) {
        a0();
        N4 n4 = this.f10063a.B().f4354c;
        if (n4 != null) {
            this.f10063a.B().g0();
            n4.e(zzdfVar, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyed(a aVar, long j4) {
        a0();
        onActivityDestroyedByScionActivityInfo(zzdf.zza((Activity) AbstractC0940s.k((Activity) b.c(aVar))), j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyedByScionActivityInfo(zzdf zzdfVar, long j4) {
        a0();
        N4 n4 = this.f10063a.B().f4354c;
        if (n4 != null) {
            this.f10063a.B().g0();
            n4.b(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPaused(a aVar, long j4) {
        a0();
        onActivityPausedByScionActivityInfo(zzdf.zza((Activity) AbstractC0940s.k((Activity) b.c(aVar))), j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPausedByScionActivityInfo(zzdf zzdfVar, long j4) {
        a0();
        N4 n4 = this.f10063a.B().f4354c;
        if (n4 != null) {
            this.f10063a.B().g0();
            n4.a(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumed(a aVar, long j4) {
        a0();
        onActivityResumedByScionActivityInfo(zzdf.zza((Activity) AbstractC0940s.k((Activity) b.c(aVar))), j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumedByScionActivityInfo(zzdf zzdfVar, long j4) {
        a0();
        N4 n4 = this.f10063a.B().f4354c;
        if (n4 != null) {
            this.f10063a.B().g0();
            n4.d(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceState(a aVar, zzcu zzcuVar, long j4) {
        a0();
        onActivitySaveInstanceStateByScionActivityInfo(zzdf.zza((Activity) AbstractC0940s.k((Activity) b.c(aVar))), zzcuVar, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdfVar, zzcu zzcuVar, long j4) {
        a0();
        N4 n4 = this.f10063a.B().f4354c;
        Bundle bundle = new Bundle();
        if (n4 != null) {
            this.f10063a.B().g0();
            n4.c(zzdfVar, bundle);
        }
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e4) {
            this.f10063a.a().r().b("Error returning bundle value to wrapper", e4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStarted(a aVar, long j4) {
        a0();
        onActivityStartedByScionActivityInfo(zzdf.zza((Activity) AbstractC0940s.k((Activity) b.c(aVar))), j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStartedByScionActivityInfo(zzdf zzdfVar, long j4) {
        a0();
        if (this.f10063a.B().f4354c != null) {
            this.f10063a.B().g0();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStopped(a aVar, long j4) {
        a0();
        onActivityStoppedByScionActivityInfo(zzdf.zza((Activity) AbstractC0940s.k((Activity) b.c(aVar))), j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStoppedByScionActivityInfo(zzdf zzdfVar, long j4) {
        a0();
        if (this.f10063a.B().f4354c != null) {
            this.f10063a.B().g0();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void performAction(Bundle bundle, zzcu zzcuVar, long j4) {
        a0();
        zzcuVar.zzb(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void registerOnMeasurementEventListener(zzda zzdaVar) {
        InterfaceC0571f4 m7Var;
        a0();
        Map map = this.f10064b;
        synchronized (map) {
            try {
                m7Var = (InterfaceC0571f4) map.get(Integer.valueOf(zzdaVar.zzf()));
                if (m7Var == null) {
                    m7Var = new m7(this, zzdaVar);
                    map.put(Integer.valueOf(zzdaVar.zzf()), m7Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f10063a.B().J(m7Var);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void resetAnalyticsData(long j4) {
        a0();
        this.f10063a.B().G(j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void retrieveAndUploadBatches(final zzcx zzcxVar) {
        a0();
        this.f10063a.B().q0(new Runnable() { // from class: S1.u6
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    zzcxVar.zze();
                } catch (RemoteException e4) {
                    ((C0658q3) AbstractC0940s.k(this.f4980a.f10063a)).a().r().b("Failed to call IDynamiteUploadBatchesCallback", e4);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConditionalUserProperty(Bundle bundle, long j4) {
        a0();
        if (bundle == null) {
            this.f10063a.a().o().a("Conditional user property must not be null");
        } else {
            this.f10063a.B().N(bundle, j4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConsent(Bundle bundle, long j4) {
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConsentThirdParty(Bundle bundle, long j4) {
        a0();
        this.f10063a.B().n0(bundle, -20, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setCurrentScreen(a aVar, String str, String str2, long j4) {
        a0();
        setCurrentScreenByScionActivityInfo(zzdf.zza((Activity) AbstractC0940s.k((Activity) b.c(aVar))), str, str2, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setCurrentScreenByScionActivityInfo(zzdf zzdfVar, String str, String str2, long j4) {
        a0();
        this.f10063a.I().t(zzdfVar, str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setDataCollectionEnabled(boolean z4) {
        a0();
        C0540b5 c0540b5B = this.f10063a.B();
        c0540b5B.j();
        c0540b5B.f4245a.b().t(new RunnableC0635n4(c0540b5B, z4));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setDefaultEventParameters(Bundle bundle) {
        a0();
        final C0540b5 c0540b5B = this.f10063a.B();
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        c0540b5B.f4245a.b().t(new Runnable() { // from class: S1.W4
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                c0540b5B.T(bundle2);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setEventInterceptor(zzda zzdaVar) {
        a0();
        V6 v6 = new V6(this, zzdaVar);
        if (this.f10063a.b().p()) {
            this.f10063a.B().I(v6);
        } else {
            this.f10063a.b().t(new Q4(this, v6));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setInstanceIdProvider(zzdc zzdcVar) {
        a0();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setMeasurementEnabled(boolean z4, long j4) {
        a0();
        this.f10063a.B().m0(Boolean.valueOf(z4));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setMinimumSessionDuration(long j4) {
        a0();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setSessionTimeoutDuration(long j4) {
        a0();
        C0540b5 c0540b5B = this.f10063a.B();
        c0540b5B.f4245a.b().t(new RunnableC0651p4(c0540b5B, j4));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setSgtmDebugInfo(Intent intent) {
        a0();
        C0540b5 c0540b5B = this.f10063a.B();
        Uri data = intent.getData();
        if (data == null) {
            c0540b5B.f4245a.a().u().a("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals("1")) {
            C0658q3 c0658q3 = c0540b5B.f4245a;
            c0658q3.a().u().a("[sgtm] Preview Mode was not enabled.");
            c0658q3.w().Q(null);
        } else {
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            C0658q3 c0658q32 = c0540b5B.f4245a;
            c0658q32.a().u().b("[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            c0658q32.w().Q(queryParameter2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setUserId(final String str, long j4) {
        a0();
        final C0540b5 c0540b5B = this.f10063a.B();
        if (str != null && TextUtils.isEmpty(str)) {
            c0540b5B.f4245a.a().r().a("User ID must be non-empty or null");
        } else {
            c0540b5B.f4245a.b().t(new Runnable() { // from class: S1.X4
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    C0658q3 c0658q3 = c0540b5B.f4245a;
                    if (c0658q3.L().x(str)) {
                        c0658q3.L().p();
                    }
                }
            });
            c0540b5B.z(null, "_id", str, true, j4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setUserProperty(String str, String str2, a aVar, boolean z4, long j4) {
        a0();
        this.f10063a.B().z(str, str2, b.c(aVar), z4, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void unregisterOnMeasurementEventListener(zzda zzdaVar) {
        InterfaceC0571f4 m7Var;
        a0();
        Map map = this.f10064b;
        synchronized (map) {
            m7Var = (InterfaceC0571f4) map.remove(Integer.valueOf(zzdaVar.zzf()));
        }
        if (m7Var == null) {
            m7Var = new m7(this, zzdaVar);
        }
        this.f10063a.B().K(m7Var);
    }
}
