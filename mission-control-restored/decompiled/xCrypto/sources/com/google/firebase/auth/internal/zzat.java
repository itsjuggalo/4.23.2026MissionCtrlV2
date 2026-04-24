package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;

/* JADX INFO: loaded from: classes.dex */
final class zzat implements Runnable {
    final /* synthetic */ zzaq zza;
    private final String zzb;

    public zzat(zzaq zzaqVar, String str) {
        this.zza = zzaqVar;
        this.zzb = AbstractC0940s.e(str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzb));
        if (firebaseAuth.getCurrentUser() != null) {
            Task<GetTokenResult> accessToken = firebaseAuth.getAccessToken(true);
            zzaq.zzc.g("Token refreshing started", new Object[0]);
            accessToken.addOnFailureListener(new zzas(this));
        }
    }
}
