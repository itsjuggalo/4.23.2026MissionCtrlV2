package com.google.android.gms.internal.auth;

import android.net.Uri;
import u.C1853a;

/* JADX INFO: loaded from: classes.dex */
public final class zzcr {
    private static final C1853a zza = new C1853a();

    public static synchronized Uri zza(String str) {
        C1853a c1853a = zza;
        Uri uri = (Uri) c1853a.get("com.google.android.gms.auth_account");
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.auth_account"))));
        c1853a.put("com.google.android.gms.auth_account", uri2);
        return uri2;
    }
}
