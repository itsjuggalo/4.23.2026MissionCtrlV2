package com.google.android.gms.internal.auth;

import android.net.Uri;
import w.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzci {
    private final i zza;

    public zzci(i iVar) {
        this.zza = iVar;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        i iVar;
        if (uri != null) {
            iVar = (i) this.zza.get(uri.toString());
        } else {
            iVar = null;
        }
        if (iVar == null) {
            return null;
        }
        return (String) iVar.get("".concat(str3));
    }
}
