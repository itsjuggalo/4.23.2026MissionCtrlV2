package com.google.android.gms.internal.auth;

import a3.d;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzcw extends zzdc {
    public zzcw(zzcz zzczVar, String str, Boolean bool, boolean z6) {
        super(zzczVar, str, bool, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.auth.zzdc
    public final /* synthetic */ Object zza(Object obj) {
        if (zzcb.zzc.matcher(obj).matches()) {
            return Boolean.TRUE;
        }
        if (zzcb.zzd.matcher(obj).matches()) {
            return Boolean.FALSE;
        }
        StringBuilder sbP = d.p("Invalid boolean value for ", this.zzc, ": ");
        sbP.append((String) obj);
        Log.e("PhenotypeFlag", sbP.toString());
        return null;
    }
}
