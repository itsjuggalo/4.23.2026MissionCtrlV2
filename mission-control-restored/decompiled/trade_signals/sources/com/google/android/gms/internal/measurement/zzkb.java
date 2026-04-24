package com.google.android.gms.internal.measurement;

import android.net.Uri;
import w.C2882a;

/* JADX INFO: loaded from: classes.dex */
public final class zzkb {
    public static final /* synthetic */ int zza = 0;
    private static final C2882a zzb = new C2882a();

    public static synchronized Uri zza(String str) {
        C2882a c2882a = zzb;
        Uri uri = (Uri) c2882a.get("com.google.android.gms.measurement");
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
        c2882a.put("com.google.android.gms.measurement", uri2);
        return uri2;
    }
}
