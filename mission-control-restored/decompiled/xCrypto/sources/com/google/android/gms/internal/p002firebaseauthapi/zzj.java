package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
final class zzj extends zzk {
    static final zzf zza = new zzj();

    private zzj() {
        super("CharMatcher.none()");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzf
    public final boolean zza(char c4) {
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzf
    public final int zza(CharSequence charSequence, int i4) {
        zzw.zza(i4, charSequence.length(), FirebaseAnalytics.Param.INDEX);
        return -1;
    }
}
