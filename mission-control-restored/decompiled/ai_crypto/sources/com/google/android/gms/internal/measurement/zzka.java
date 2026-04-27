package com.google.android.gms.internal.measurement;

import android.net.Uri;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public final class zzka {
    public static final /* synthetic */ int zza = 0;
    private static final C2736a zzb = new C2736a();

    public static synchronized Uri zza(String str) {
        C2736a c2736a = zzb;
        Uri uri = (Uri) c2736a.get("com.google.android.gms.measurement");
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
        c2736a.put("com.google.android.gms.measurement", uri2);
        return uri2;
    }
}
