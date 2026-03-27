package com.google.android.gms.internal.measurement;

import android.net.Uri;
import u.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzjs {
    private final g zza;

    public zzjs(g gVar) {
        this.zza = gVar;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        g gVar = uri != null ? (g) this.zza.get(uri.toString()) : null;
        if (gVar == null) {
            return null;
        }
        return (String) gVar.get("".concat(str3));
    }
}
