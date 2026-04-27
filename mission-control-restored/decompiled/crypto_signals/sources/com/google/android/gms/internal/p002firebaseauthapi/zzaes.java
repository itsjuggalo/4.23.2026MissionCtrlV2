package com.google.android.gms.internal.p002firebaseauthapi;

import X2.b;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.Status;
import java.net.HttpURLConnection;
import java.net.URL;
import x1.C1402a;

/* JADX INFO: loaded from: classes.dex */
public interface zzaes {
    public static final C1402a zza = new C1402a("FirebaseAuth", "GetAuthDomainTaskResponseHandler");

    Context zza();

    Uri.Builder zza(Intent intent, String str, String str2);

    String zza(String str);

    HttpURLConnection zza(URL url);

    void zza(Uri uri, String str, b bVar);

    void zza(String str, Status status);
}
