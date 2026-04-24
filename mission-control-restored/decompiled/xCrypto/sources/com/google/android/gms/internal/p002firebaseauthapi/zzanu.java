package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* JADX INFO: loaded from: classes.dex */
final class zzanu extends zzanv {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanv
    public final int zza(String str, byte[] bArr, int i4, int i5) {
        int i6;
        int i7;
        char cCharAt;
        int length = str.length();
        int i8 = i5 + i4;
        int i9 = 0;
        while (i9 < length && (i7 = i9 + i4) < i8 && (cCharAt = str.charAt(i9)) < 128) {
            bArr[i7] = (byte) cCharAt;
            i9++;
        }
        if (i9 == length) {
            return i4 + length;
        }
        int i10 = i4 + i9;
        while (i9 < length) {
            char cCharAt2 = str.charAt(i9);
            if (cCharAt2 < 128 && i10 < i8) {
                bArr[i10] = (byte) cCharAt2;
                i10++;
            } else if (cCharAt2 < 2048 && i10 <= i8 - 2) {
                int i11 = i10 + 1;
                bArr[i10] = (byte) ((cCharAt2 >>> 6) | 960);
                i10 += 2;
                bArr[i11] = (byte) ((cCharAt2 & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i10 > i8 - 3) {
                    if (i10 > i8 - 4) {
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i6 = i9 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i6)))) {
                            throw new zzanx(i9, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i10);
                    }
                    int i12 = i9 + 1;
                    if (i12 != str.length()) {
                        char cCharAt3 = str.charAt(i12);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i10] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i10 + 1] = (byte) (((codePoint >>> 12) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                            int i13 = i10 + 3;
                            bArr[i10 + 2] = (byte) (((codePoint >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                            i10 += 4;
                            bArr[i13] = (byte) ((codePoint & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                            i9 = i12;
                        } else {
                            i9 = i12;
                        }
                    }
                    throw new zzanx(i9 - 1, length);
                }
                bArr[i10] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i14 = i10 + 2;
                bArr[i10 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                i10 += 3;
                bArr[i14] = (byte) ((cCharAt2 & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
            }
            i9++;
        }
        return i10;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanv
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
            if (b4 < 0) {
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
                        return zzant.zza(bArr, i7, i6);
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
                    return zzant.zza(bArr, i7, i6);
                }
                int i10 = i5 + 2;
                byte b6 = bArr[i7];
                if (b6 <= -65 && ((b4 != -32 || b6 >= -96) && (b4 != -19 || b6 < -96))) {
                    i5 += 3;
                    if (bArr[i10] > -65) {
                    }
                }
                return -1;
            }
            i5 = i7;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanv
    public final String zza(byte[] bArr, int i4, int i5) throws zzalf {
        if ((i4 | i5 | ((bArr.length - i4) - i5)) >= 0) {
            int i6 = i4 + i5;
            char[] cArr = new char[i5];
            int i7 = 0;
            while (i4 < i6) {
                byte b4 = bArr[i4];
                if (b4 < 0) {
                    break;
                }
                i4++;
                zzans.zza(b4, cArr, i7);
                i7++;
            }
            int i8 = i7;
            while (i4 < i6) {
                int i9 = i4 + 1;
                byte b5 = bArr[i4];
                if (b5 >= 0) {
                    int i10 = i8 + 1;
                    zzans.zza(b5, cArr, i8);
                    int i11 = i9;
                    while (i11 < i6) {
                        byte b6 = bArr[i11];
                        if (b6 < 0) {
                            break;
                        }
                        i11++;
                        zzans.zza(b6, cArr, i10);
                        i10++;
                    }
                    i8 = i10;
                    i4 = i11;
                } else if (b5 < -32) {
                    if (i9 < i6) {
                        i4 += 2;
                        zzans.zza(b5, bArr[i9], cArr, i8);
                        i8++;
                    } else {
                        throw zzalf.zzd();
                    }
                } else if (b5 < -16) {
                    if (i9 < i6 - 1) {
                        int i12 = i4 + 2;
                        i4 += 3;
                        zzans.zza(b5, bArr[i9], bArr[i12], cArr, i8);
                        i8++;
                    } else {
                        throw zzalf.zzd();
                    }
                } else if (i9 < i6 - 2) {
                    byte b7 = bArr[i9];
                    int i13 = i4 + 3;
                    byte b8 = bArr[i4 + 2];
                    i4 += 4;
                    zzans.zza(b5, b7, b8, bArr[i13], cArr, i8);
                    i8 += 2;
                } else {
                    throw zzalf.zzd();
                }
            }
            return new String(cArr, 0, i8);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)));
    }
}
