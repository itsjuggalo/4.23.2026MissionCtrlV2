package com.google.android.gms.internal.measurement;

import android.net.Uri;
import w.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjt {
    private final i zza;

    public zzjt(i iVar) {
        this.zza = iVar;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        i iVar = uri != null ? (i) this.zza.get(uri.toString()) : null;
        if (iVar == null) {
            return null;
        }
        return (String) iVar.get("".concat(str3));
    }
}
