package com.google.android.gms.internal.play_billing;

import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
public class zzci {
    public static int zzc(int i7, int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
        }
        if (i8 <= i7) {
            return i7;
        }
        int i9 = i7 + (i7 >> 1) + 1;
        if (i9 < i8) {
            int iHighestOneBit = Integer.highestOneBit(i8 - 1);
            i9 = iHighestOneBit + iHighestOneBit;
        }
        return i9 < 0 ? a.e.API_PRIORITY_OTHER : i9;
    }
}
