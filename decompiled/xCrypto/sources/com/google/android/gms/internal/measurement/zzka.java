package com.google.android.gms.internal.measurement;

import android.net.Uri;
import u.C1853a;

/* JADX INFO: loaded from: classes.dex */
public final class zzka {
    public static final /* synthetic */ int zza = 0;
    private static final C1853a zzb = new C1853a();

    public static synchronized Uri zza(String str) {
        C1853a c1853a = zzb;
        Uri uri = (Uri) c1853a.get("com.google.android.gms.measurement");
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
        c1853a.put("com.google.android.gms.measurement", uri2);
        return uri2;
    }
}
