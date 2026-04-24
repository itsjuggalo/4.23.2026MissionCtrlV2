package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzw implements Runnable {
    private final /* synthetic */ FirebaseAuth zza;

    public zzw(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.zza.zzd.iterator();
        while (it.hasNext()) {
            ((FirebaseAuth.AuthStateListener) it.next()).onAuthStateChanged(this.zza);
        }
    }
}
