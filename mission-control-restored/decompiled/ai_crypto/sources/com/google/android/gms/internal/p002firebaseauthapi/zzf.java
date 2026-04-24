package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzf {
    public int zza(CharSequence charSequence, int i7) {
        int length = charSequence.length();
        zzw.zza(i7, length, "index");
        while (i7 < length) {
            if (zza(charSequence.charAt(i7))) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public abstract boolean zza(char c7);
}
