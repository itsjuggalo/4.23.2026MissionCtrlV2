package com.google.android.gms.internal.p002firebaseauthapi;

import B1.c;
import a3.d;
import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.I;

/* JADX INFO: loaded from: classes.dex */
public final class zzafx {
    private final String zza;
    private final String zzb;

    public zzafx(Context context) {
        this(context, context.getPackageName());
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    private zzafx(Context context, String str) {
        I.g(context);
        I.d(str);
        this.zza = str;
        try {
            byte[] bArrC = c.c(context, str);
            if (bArrC != null) {
                this.zzb = c.a(bArrC);
            } else {
                d.s("single cert required: ", str, "FBA-PackageInfo");
                this.zzb = null;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            d.s("no pkg: ", str, "FBA-PackageInfo");
            this.zzb = null;
        }
    }
}
