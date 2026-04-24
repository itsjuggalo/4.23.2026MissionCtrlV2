package com.google.android.gms.internal.p002firebaseauthapi;

import W1.a;
import W1.i;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class zzafp {
    private final String zza;
    private final String zzb;

    public zzafp(Context context) {
        this(context, context.getPackageName());
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    private zzafp(Context context, String str) {
        AbstractC1207s.k(context);
        String strE = AbstractC1207s.e(str);
        this.zza = strE;
        try {
            byte[] bArrA = a.a(context, strE);
            if (bArrA != null) {
                this.zzb = i.c(bArrA, false);
                return;
            }
            Log.e("FBA-PackageInfo", "single cert required: " + str);
            this.zzb = null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("FBA-PackageInfo", "no pkg: " + str);
            this.zzb = null;
        }
    }
}
