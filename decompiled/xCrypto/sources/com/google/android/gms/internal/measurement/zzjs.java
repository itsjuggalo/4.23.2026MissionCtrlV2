package com.google.android.gms.internal.measurement;

import android.net.Uri;
import u.C1859g;

/* JADX INFO: loaded from: classes.dex */
public final class zzjs {
    private final C1859g zza;

    public zzjs(C1859g c1859g) {
        this.zza = c1859g;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        C1859g c1859g = uri != null ? (C1859g) this.zza.get(uri.toString()) : null;
        if (c1859g == null) {
            return null;
        }
        return (String) c1859g.get("".concat(str3));
    }
}
