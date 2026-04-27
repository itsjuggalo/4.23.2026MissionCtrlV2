package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.b;

/* JADX INFO: loaded from: classes.dex */
final class zzafb implements zzafe {
    private final /* synthetic */ String zza;

    public zzafb(zzaez zzaezVar, String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafe
    public final void zza(b.AbstractC0192b abstractC0192b, Object... objArr) {
        abstractC0192b.onCodeSent(this.zza, b.a.A());
    }
}
