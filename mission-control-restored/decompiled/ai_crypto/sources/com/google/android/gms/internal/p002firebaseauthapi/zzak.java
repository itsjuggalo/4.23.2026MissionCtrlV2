package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
public class zzak<E> {
    public static int zza(int i7, int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i8 <= i7) {
            return i7;
        }
        int iHighestOneBit = i7 + (i7 >> 1) + 1;
        if (iHighestOneBit < i8) {
            iHighestOneBit = Integer.highestOneBit(i8 - 1) << 1;
        }
        return iHighestOneBit < 0 ? a.e.API_PRIORITY_OTHER : iHighestOneBit;
    }
}
