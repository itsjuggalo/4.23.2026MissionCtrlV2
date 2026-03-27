package S2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: renamed from: S2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0899f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Float f7537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7538b;

    public C0899f(Float f8, boolean z7) {
        this.f7538b = z7;
        this.f7537a = f8;
    }

    public static C0899f a(Context context) {
        boolean zE = false;
        Float fD = null;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                zE = e(intentRegisterReceiver);
                fD = d(intentRegisterReceiver);
            }
        } catch (IllegalStateException e8) {
            P2.g.f().e("An error occurred getting battery state.", e8);
        }
        return new C0899f(fD, zE);
    }

    public static Float d(Intent intent) {
        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(intExtra / intExtra2);
    }

    public static boolean e(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }

    public Float b() {
        return this.f7537a;
    }

    public int c() {
        Float f8;
        if (!this.f7538b || (f8 = this.f7537a) == null) {
            return 1;
        }
        return ((double) f8.floatValue()) < 0.99d ? 2 : 3;
    }
}
