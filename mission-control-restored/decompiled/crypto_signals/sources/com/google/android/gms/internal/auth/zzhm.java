package com.google.android.gms.internal.auth;

/* JADX INFO: loaded from: classes.dex */
final class zzhm extends zzhl {
    @Override // com.google.android.gms.internal.auth.zzhl
    public final int zza(int i, byte[] bArr, int i6, int i7) {
        while (i6 < i7 && bArr[i6] >= 0) {
            i6++;
        }
        if (i6 >= i7) {
            return 0;
        }
        while (i6 < i7) {
            int i8 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                i6 = i8;
            } else {
                if (b3 < -32) {
                    if (i8 >= i7) {
                        return b3;
                    }
                    if (b3 >= -62) {
                        i6 += 2;
                        if (bArr[i8] > -65) {
                        }
                    }
                    return -1;
                }
                if (b3 >= -16) {
                    if (i8 >= i7 - 2) {
                        return zzhn.zza(bArr, i8, i7);
                    }
                    int i9 = i6 + 2;
                    byte b6 = bArr[i8];
                    if (b6 <= -65) {
                        if ((((b6 + 112) + (b3 << 28)) >> 30) == 0) {
                            int i10 = i6 + 3;
                            if (bArr[i9] <= -65) {
                                i6 += 4;
                                if (bArr[i10] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                if (i8 >= i7 - 1) {
                    return zzhn.zza(bArr, i8, i7);
                }
                int i11 = i6 + 2;
                byte b7 = bArr[i8];
                if (b7 > -65 || (b3 == -32 && b7 < -96)) {
                    return -1;
                }
                if (b3 == -19 && b7 >= -96) {
                    return -1;
                }
                i6 += 3;
                if (bArr[i11] > -65) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
