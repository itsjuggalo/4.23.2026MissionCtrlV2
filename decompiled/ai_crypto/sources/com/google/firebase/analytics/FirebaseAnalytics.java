package com.google.firebase.analytics;

import O3.g;
import R2.c;
import R2.d;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import i2.InterfaceC1788c5;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile FirebaseAnalytics f11988c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzfb f11989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExecutorService f11990b;

    public enum a {
        GRANTED,
        DENIED
    }

    public enum b {
        AD_STORAGE,
        ANALYTICS_STORAGE,
        AD_USER_DATA,
        AD_PERSONALIZATION
    }

    public FirebaseAnalytics(zzfb zzfbVar) {
        AbstractC1207s.k(zzfbVar);
        this.f11989a = zzfbVar;
    }

    public static FirebaseAnalytics getInstance(Context context) {
        if (f11988c == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f11988c == null) {
                        f11988c = new FirebaseAnalytics(zzfb.zza(context, null));
                    }
                } finally {
                }
            }
        }
        return f11988c;
    }

    public static InterfaceC1788c5 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzfb zzfbVarZza = zzfb.zza(context, bundle);
        if (zzfbVarZza == null) {
            return null;
        }
        return new d(zzfbVarZza);
    }

    public Task a() {
        try {
            return Tasks.call(l(), new R2.b(this));
        } catch (RuntimeException e7) {
            this.f11989a.zzD(5, "Failed to schedule task for getAppInstanceId", null, null, null);
            return Tasks.forException(e7);
        }
    }

    public Task b() {
        try {
            return Tasks.call(l(), new c(this));
        } catch (RuntimeException e7) {
            this.f11989a.zzD(5, "Failed to schedule task for getSessionId", null, null, null);
            return Tasks.forException(e7);
        }
    }

    public void c(String str, Bundle bundle) {
        this.f11989a.zzh(str, bundle);
    }

    public void d() {
        this.f11989a.zzs();
    }

    public void e(boolean z7) {
        this.f11989a.zzq(Boolean.valueOf(z7));
    }

    public void f(Map map) {
        Bundle bundle = new Bundle();
        a aVar = (a) map.get(b.AD_STORAGE);
        if (aVar != null) {
            int iOrdinal = aVar.ordinal();
            if (iOrdinal == 0) {
                bundle.putString("ad_storage", "granted");
            } else if (iOrdinal == 1) {
                bundle.putString("ad_storage", "denied");
            }
        }
        a aVar2 = (a) map.get(b.ANALYTICS_STORAGE);
        if (aVar2 != null) {
            int iOrdinal2 = aVar2.ordinal();
            if (iOrdinal2 == 0) {
                bundle.putString("analytics_storage", "granted");
            } else if (iOrdinal2 == 1) {
                bundle.putString("analytics_storage", "denied");
            }
        }
        a aVar3 = (a) map.get(b.AD_USER_DATA);
        if (aVar3 != null) {
            int iOrdinal3 = aVar3.ordinal();
            if (iOrdinal3 == 0) {
                bundle.putString("ad_user_data", "granted");
            } else if (iOrdinal3 == 1) {
                bundle.putString("ad_user_data", "denied");
            }
        }
        a aVar4 = (a) map.get(b.AD_PERSONALIZATION);
        if (aVar4 != null) {
            int iOrdinal4 = aVar4.ordinal();
            if (iOrdinal4 == 0) {
                bundle.putString("ad_personalization", "granted");
            } else if (iOrdinal4 == 1) {
                bundle.putString("ad_personalization", "denied");
            }
        }
        this.f11989a.zzr(bundle);
    }

    public void g(Bundle bundle) {
        if (bundle != null) {
            bundle = new Bundle(bundle);
        }
        this.f11989a.zzL(bundle);
    }

    public String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(g.p().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e7) {
            throw new IllegalStateException(e7);
        } catch (ExecutionException e8) {
            throw new IllegalStateException(e8.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    public void h(long j7) {
        this.f11989a.zzt(j7);
    }

    public void i(String str) {
        this.f11989a.zzo(str);
    }

    public void j(String str, String str2) {
        this.f11989a.zzk(null, str, str2, false);
    }

    public final /* synthetic */ zzfb k() {
        return this.f11989a;
    }

    public final ExecutorService l() {
        ExecutorService executorService;
        synchronized (FirebaseAnalytics.class) {
            try {
                if (this.f11990b == null) {
                    this.f11990b = new R2.a(this, 0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
                }
                executorService = this.f11990b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    @Deprecated
    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.f11989a.zzp(zzdf.zza(activity), str, str2);
    }
}
