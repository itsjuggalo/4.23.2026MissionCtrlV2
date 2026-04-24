package com.google.android.gms.internal.fido;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
enum zzcm implements Comparator {
    INSTANCE;

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = (byte[]) obj2;
        int iMin = Math.min(bArr.length, bArr2.length);
        for (int i4 = 0; i4 < iMin; i4++) {
            int i5 = (bArr[i4] & 255) - (bArr2[i4] & 255);
            if (i5 != 0) {
                return i5;
            }
        }
        return bArr.length - bArr2.length;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
    }
}
