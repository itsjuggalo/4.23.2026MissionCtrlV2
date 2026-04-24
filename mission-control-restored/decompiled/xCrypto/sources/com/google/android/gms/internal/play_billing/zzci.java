package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public class zzci {
    public static int zzc(int i4, int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
        }
        if (i5 <= i4) {
            return i4;
        }
        int i6 = i4 + (i4 >> 1) + 1;
        if (i6 < i5) {
            int iHighestOneBit = Integer.highestOneBit(i5 - 1);
            i6 = iHighestOneBit + iHighestOneBit;
        }
        if (i6 < 0) {
            return Integer.MAX_VALUE;
        }
        return i6;
    }
}
