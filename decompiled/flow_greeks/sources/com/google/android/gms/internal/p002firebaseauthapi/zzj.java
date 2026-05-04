package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzj extends zzk {
    static final zzf zza = new zzj();

    private zzj() {
        super("CharMatcher.none()");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzf
    public final boolean zza(char c10) {
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzf
    public final int zza(CharSequence charSequence, int i10) {
        zzu.zza(i10, charSequence.length(), FirebaseAnalytics.Param.INDEX);
        return -1;
    }
}
