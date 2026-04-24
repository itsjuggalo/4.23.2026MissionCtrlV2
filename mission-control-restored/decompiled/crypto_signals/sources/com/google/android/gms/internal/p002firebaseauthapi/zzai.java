package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.f;

/* JADX INFO: loaded from: classes.dex */
public class zzai<E> {
    public static int zza(int i, int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i6 <= i) {
            return i;
        }
        int iHighestOneBit = i + (i >> 1) + 1;
        if (iHighestOneBit < i6) {
            iHighestOneBit = Integer.highestOneBit(i6 - 1) << 1;
        }
        return iHighestOneBit < 0 ? f.API_PRIORITY_OTHER : iHighestOneBit;
    }
}
