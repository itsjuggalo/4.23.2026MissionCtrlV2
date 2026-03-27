package com.google.android.gms.internal.auth;

import android.net.Uri;
import q.C0910b;

/* JADX INFO: loaded from: classes.dex */
public final class zzcr {
    private static final C0910b zza = new C0910b();

    public static synchronized Uri zza(String str) {
        C0910b c0910b = zza;
        Uri uri = (Uri) c0910b.getOrDefault("com.google.android.gms.auth_account", null);
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.auth_account"))));
        c0910b.put("com.google.android.gms.auth_account", uri2);
        return uri2;
    }
}
