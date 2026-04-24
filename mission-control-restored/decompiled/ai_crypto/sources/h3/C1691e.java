package h3;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import e3.C1478g;

/* JADX INFO: renamed from: h3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1691e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Float f14803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14804b;

    public C1691e(Float f7, boolean z7) {
        this.f14804b = z7;
        this.f14803a = f7;
    }

    public static C1691e a(Context context) {
        boolean zE = false;
        Float fD = null;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                zE = e(intentRegisterReceiver);
                fD = d(intentRegisterReceiver);
            }
        } catch (IllegalStateException e7) {
            C1478g.f().e("An error occurred getting battery state.", e7);
        }
        return new C1691e(fD, zE);
    }

    public static Float d(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
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
        return this.f14803a;
    }

    public int c() {
        Float f7;
        if (!this.f14804b || (f7 = this.f14803a) == null) {
            return 1;
        }
        return ((double) f7.floatValue()) < 0.99d ? 2 : 3;
    }
}
