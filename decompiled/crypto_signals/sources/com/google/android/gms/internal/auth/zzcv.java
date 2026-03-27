package com.google.android.gms.internal.auth;

import a3.d;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzcv extends zzdc {
    public zzcv(zzcz zzczVar, String str, Long l6, boolean z6) {
        super(zzczVar, str, l6, true, null);
    }

    @Override // com.google.android.gms.internal.auth.zzdc
    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            StringBuilder sbP = d.p("Invalid long value for ", this.zzc, ": ");
            sbP.append((String) obj);
            Log.e("PhenotypeFlag", sbP.toString());
            return null;
        }
    }
}
