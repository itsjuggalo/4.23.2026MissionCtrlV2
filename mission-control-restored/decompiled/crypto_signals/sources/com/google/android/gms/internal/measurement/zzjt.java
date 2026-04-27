package com.google.android.gms.internal.measurement;

import android.net.Uri;
import q.k;

/* JADX INFO: loaded from: classes.dex */
public final class zzjt {
    private final k zza;

    public zzjt(k kVar) {
        this.zza = kVar;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        k kVar = uri != null ? (k) this.zza.getOrDefault(uri.toString(), null) : null;
        if (kVar == null) {
            return null;
        }
        return (String) kVar.getOrDefault("".concat(str3), null);
    }
}
