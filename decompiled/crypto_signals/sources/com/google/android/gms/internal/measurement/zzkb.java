package com.google.android.gms.internal.measurement;

import android.net.Uri;
import q.C0910b;

/* JADX INFO: loaded from: classes.dex */
public final class zzkb {
    public static final /* synthetic */ int zza = 0;
    private static final C0910b zzb = new C0910b();

    public static synchronized Uri zza(String str) {
        C0910b c0910b = zzb;
        Uri uri = (Uri) c0910b.getOrDefault("com.google.android.gms.measurement", null);
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
        c0910b.put("com.google.android.gms.measurement", uri2);
        return uri2;
    }
}
