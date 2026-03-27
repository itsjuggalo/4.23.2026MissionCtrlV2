package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
final class zzhm extends zzhl {
    @Override // com.google.android.gms.internal.auth.zzhl
    public final int zza(int i4, byte[] bArr, int i5, int i6) {
        while (i5 < i6 && bArr[i5] >= 0) {
            i5++;
        }
        if (i5 >= i6) {
            return 0;
        }
        while (i5 < i6) {
            int i7 = i5 + 1;
            byte b4 = bArr[i5];
            if (b4 >= 0) {
                i5 = i7;
            } else {
                if (b4 < -32) {
                    if (i7 >= i6) {
                        return b4;
                    }
                    if (b4 >= -62) {
                        i5 += 2;
                        if (bArr[i7] > -65) {
                        }
                    }
                    return -1;
                }
                if (b4 >= -16) {
                    if (i7 >= i6 - 2) {
                        return zzhn.zza(bArr, i7, i6);
                    }
                    int i8 = i5 + 2;
                    byte b5 = bArr[i7];
                    if (b5 <= -65 && (((b4 << 28) + (b5 + 112)) >> 30) == 0) {
                        int i9 = i5 + 3;
                        if (bArr[i8] <= -65) {
                            i5 += 4;
                            if (bArr[i9] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i7 >= i6 - 1) {
                    return zzhn.zza(bArr, i7, i6);
                }
                int i10 = i5 + 2;
                byte b6 = bArr[i7];
                if (b6 > -65 || (b4 == -32 && b6 < -96)) {
                    return -1;
                }
                if (b4 == -19 && b6 >= -96) {
                    return -1;
                }
                i5 += 3;
                if (bArr[i10] > -65) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
