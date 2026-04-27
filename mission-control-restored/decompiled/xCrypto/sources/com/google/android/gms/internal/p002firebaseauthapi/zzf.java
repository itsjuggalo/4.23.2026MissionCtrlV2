package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzf {
    public int zza(CharSequence charSequence, int i4) {
        int length = charSequence.length();
        zzw.zza(i4, length, FirebaseAnalytics.Param.INDEX);
        while (i4 < length) {
            if (zza(charSequence.charAt(i4))) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public abstract boolean zza(char c4);
}
