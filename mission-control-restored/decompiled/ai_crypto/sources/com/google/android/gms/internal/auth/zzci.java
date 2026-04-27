package com.google.android.gms.internal.auth;

import android.net.Uri;
import u.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzci {
    private final g zza;

    public zzci(g gVar) {
        this.zza = gVar;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        g gVar;
        if (uri != null) {
            gVar = (g) this.zza.get(uri.toString());
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return null;
        }
        return (String) gVar.get("".concat(str3));
    }
}
