package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
final class zzaka extends zzakb {
    private final byte[] zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    private final int zzaa() {
        int i4;
        int i5 = this.zzg;
        int i6 = this.zze;
        if (i6 != i5) {
            byte[] bArr = this.zzd;
            int i7 = i5 + 1;
            byte b4 = bArr[i5];
            if (b4 >= 0) {
                this.zzg = i7;
                return b4;
            }
            if (i6 - i7 >= 9) {
                int i8 = i5 + 2;
                int i9 = (bArr[i7] << 7) ^ b4;
                if (i9 < 0) {
                    i4 = i9 ^ (-128);
                } else {
                    int i10 = i5 + 3;
                    int i11 = (bArr[i8] << 14) ^ i9;
                    if (i11 >= 0) {
                        i4 = i11 ^ 16256;
                    } else {
                        int i12 = i5 + 4;
                        int i13 = i11 ^ (bArr[i10] << 21);
                        if (i13 < 0) {
                            i4 = (-2080896) ^ i13;
                        } else {
                            i10 = i5 + 5;
                            byte b5 = bArr[i12];
                            int i14 = (i13 ^ (b5 << 28)) ^ 266354560;
                            if (b5 < 0) {
                                i12 = i5 + 6;
                                if (bArr[i10] < 0) {
                                    i10 = i5 + 7;
                                    if (bArr[i12] < 0) {
                                        i12 = i5 + 8;
                                        if (bArr[i10] < 0) {
                                            i10 = i5 + 9;
                                            if (bArr[i12] < 0) {
                                                int i15 = i5 + 10;
                                                if (bArr[i10] >= 0) {
                                                    i8 = i15;
                                                    i4 = i14;
                                                }
                                            }
                                        }
                                    }
                                }
                                i4 = i14;
                            }
                            i4 = i14;
                        }
                        i8 = i12;
                    }
                    i8 = i10;
                }
                this.zzg = i8;
                return i4;
            }
        }
        return (int) zzm();
    }

    private final long zzab() throws zzalf {
        int i4 = this.zzg;
        if (this.zze - i4 < 8) {
            throw zzalf.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i4 + 8;
        return ((((long) bArr[i4 + 7]) & 255) << 56) | (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48);
    }

    private final long zzac() {
        long j4;
        long j5;
        long j6;
        int i4 = this.zzg;
        int i5 = this.zze;
        if (i5 != i4) {
            byte[] bArr = this.zzd;
            int i6 = i4 + 1;
            byte b4 = bArr[i4];
            if (b4 >= 0) {
                this.zzg = i6;
                return b4;
            }
            if (i5 - i6 >= 9) {
                int i7 = i4 + 2;
                int i8 = (bArr[i6] << 7) ^ b4;
                if (i8 < 0) {
                    j4 = i8 ^ (-128);
                } else {
                    int i9 = i4 + 3;
                    int i10 = (bArr[i7] << 14) ^ i8;
                    if (i10 >= 0) {
                        j4 = i10 ^ 16256;
                        i7 = i9;
                    } else {
                        int i11 = i4 + 4;
                        int i12 = i10 ^ (bArr[i9] << 21);
                        if (i12 < 0) {
                            long j7 = (-2080896) ^ i12;
                            i7 = i11;
                            j4 = j7;
                        } else {
                            long j8 = i12;
                            i7 = i4 + 5;
                            long j9 = j8 ^ (((long) bArr[i11]) << 28);
                            if (j9 >= 0) {
                                j6 = 266354560;
                            } else {
                                int i13 = i4 + 6;
                                long j10 = j9 ^ (((long) bArr[i7]) << 35);
                                if (j10 < 0) {
                                    j5 = -34093383808L;
                                } else {
                                    i7 = i4 + 7;
                                    j9 = j10 ^ (((long) bArr[i13]) << 42);
                                    if (j9 >= 0) {
                                        j6 = 4363953127296L;
                                    } else {
                                        i13 = i4 + 8;
                                        j10 = j9 ^ (((long) bArr[i7]) << 49);
                                        if (j10 < 0) {
                                            j5 = -558586000294016L;
                                        } else {
                                            i7 = i4 + 9;
                                            long j11 = (j10 ^ (((long) bArr[i13]) << 56)) ^ 71499008037633920L;
                                            if (j11 < 0) {
                                                int i14 = i4 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i7 = i14;
                                                }
                                            }
                                            j4 = j11;
                                        }
                                    }
                                }
                                j4 = j10 ^ j5;
                                i7 = i13;
                            }
                            j4 = j9 ^ j6;
                        }
                    }
                }
                this.zzg = i7;
                return j4;
            }
        }
        return zzm();
    }

    private final void zzad() {
        int i4 = this.zze + this.zzf;
        this.zze = i4;
        int i5 = i4 - this.zzh;
        int i6 = this.zzj;
        if (i5 <= i6) {
            this.zzf = 0;
            return;
        }
        int i7 = i5 - i6;
        this.zzf = i7;
        this.zze = i4 - i7;
    }

    private final byte zzy() throws zzalf {
        int i4 = this.zzg;
        if (i4 == this.zze) {
            throw zzalf.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i4 + 1;
        return bArr[i4];
    }

    private final int zzz() throws zzalf {
        int i4 = this.zzg;
        if (this.zze - i4 < 4) {
            throw zzalf.zzj();
        }
        byte[] bArr = this.zzd;
        this.zzg = i4 + 4;
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final double zza() {
        return Double.longBitsToDouble(zzab());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final float zzb() {
        return Float.intBitsToFloat(zzz());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzc() {
        return this.zzg - this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzd() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zze() {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzf() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzg() {
        return zzz();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzh() {
        return zzakb.zze(zzaa());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzi() throws zzalf {
        if (zzt()) {
            this.zzi = 0;
            return 0;
        }
        int iZzaa = zzaa();
        this.zzi = iZzaa;
        if ((iZzaa >>> 3) != 0) {
            return iZzaa;
        }
        throw zzalf.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zzj() {
        return zzaa();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzk() {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzl() {
        return zzac();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzm() throws zzalf {
        long j4 = 0;
        for (int i4 = 0; i4 < 64; i4 += 7) {
            byte bZzy = zzy();
            j4 |= ((long) (bZzy & 127)) << i4;
            if ((bZzy & 128) == 0) {
                return j4;
            }
        }
        throw zzalf.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzn() {
        return zzab();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzo() {
        return zzakb.zza(zzac());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final long zzp() {
        return zzac();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.p002firebaseauthapi.zzajp zzq() throws com.google.android.gms.internal.p002firebaseauthapi.zzalf {
        /*
            r3 = this;
            int r0 = r3.zzaa()
            if (r0 <= 0) goto L19
            int r1 = r3.zze
            int r2 = r3.zzg
            int r1 = r1 - r2
            if (r0 > r1) goto L19
            byte[] r1 = r3.zzd
            com.google.android.gms.internal.firebase-auth-api.zzajp r1 = com.google.android.gms.internal.p002firebaseauthapi.zzajp.zza(r1, r2, r0)
            int r2 = r3.zzg
            int r2 = r2 + r0
            r3.zzg = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.android.gms.internal.firebase-auth-api.zzajp r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajp.zza
            return r0
        L1e:
            if (r0 <= 0) goto L31
            int r1 = r3.zze
            int r2 = r3.zzg
            int r1 = r1 - r2
            if (r0 > r1) goto L31
            int r0 = r0 + r2
            r3.zzg = r0
            byte[] r1 = r3.zzd
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r2, r0)
            goto L37
        L31:
            if (r0 > 0) goto L41
            if (r0 != 0) goto L3c
            byte[] r0 = com.google.android.gms.internal.p002firebaseauthapi.zzalb.zzb
        L37:
            com.google.android.gms.internal.firebase-auth-api.zzajp r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajp.zzb(r0)
            return r0
        L3c:
            com.google.android.gms.internal.firebase-auth-api.zzalf r0 = com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzf()
            throw r0
        L41:
            com.google.android.gms.internal.firebase-auth-api.zzalf r0 = com.google.android.gms.internal.p002firebaseauthapi.zzalf.zzj()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaka.zzq():com.google.android.gms.internal.firebase-auth-api.zzajp");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final String zzr() throws zzalf {
        int iZzaa = zzaa();
        if (iZzaa > 0) {
            int i4 = this.zze;
            int i5 = this.zzg;
            if (iZzaa <= i4 - i5) {
                String str = new String(this.zzd, i5, iZzaa, zzalb.zza);
                this.zzg += iZzaa;
                return str;
            }
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa < 0) {
            throw zzalf.zzf();
        }
        throw zzalf.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final String zzs() throws zzalf {
        int iZzaa = zzaa();
        if (iZzaa > 0) {
            int i4 = this.zze;
            int i5 = this.zzg;
            if (iZzaa <= i4 - i5) {
                String strZzb = zzant.zzb(this.zzd, i5, iZzaa);
                this.zzg += iZzaa;
                return strZzb;
            }
        }
        if (iZzaa == 0) {
            return "";
        }
        if (iZzaa <= 0) {
            throw zzalf.zzf();
        }
        throw zzalf.zzj();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzt() {
        return this.zzg == this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzu() {
        return zzac() != 0;
    }

    private zzaka(byte[] bArr, int i4, int i5, boolean z4) {
        super();
        this.zzj = Integer.MAX_VALUE;
        this.zzd = bArr;
        this.zze = i5 + i4;
        this.zzg = i4;
        this.zzh = i4;
    }

    private final void zzf(int i4) throws zzalf {
        if (i4 >= 0) {
            int i5 = this.zze;
            int i6 = this.zzg;
            if (i4 <= i5 - i6) {
                this.zzg = i6 + i4;
                return;
            }
        }
        if (i4 >= 0) {
            throw zzalf.zzj();
        }
        throw zzalf.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final int zza(int i4) throws zzalf {
        if (i4 < 0) {
            throw zzalf.zzf();
        }
        int iZzc = i4 + zzc();
        if (iZzc < 0) {
            throw zzalf.zzi();
        }
        int i5 = this.zzj;
        if (iZzc > i5) {
            throw zzalf.zzj();
        }
        this.zzj = iZzc;
        zzad();
        return i5;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final void zzb(int i4) throws zzalf {
        if (this.zzi != i4) {
            throw zzalf.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final void zzc(int i4) {
        this.zzj = i4;
        zzad();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakb
    public final boolean zzd(int i4) throws zzalf {
        int i5 = i4 & 7;
        int i6 = 0;
        if (i5 == 0) {
            if (this.zze - this.zzg < 10) {
                while (i6 < 10) {
                    if (zzy() < 0) {
                        i6++;
                    }
                }
                throw zzalf.zze();
            }
            while (i6 < 10) {
                byte[] bArr = this.zzd;
                int i7 = this.zzg;
                this.zzg = i7 + 1;
                if (bArr[i7] < 0) {
                    i6++;
                }
            }
            throw zzalf.zze();
            return true;
        }
        if (i5 == 1) {
            zzf(8);
            return true;
        }
        if (i5 == 2) {
            zzf(zzaa());
            return true;
        }
        if (i5 == 3) {
            zzx();
            zzb(((i4 >>> 3) << 3) | 4);
            return true;
        }
        if (i5 == 4) {
            zzw();
            return false;
        }
        if (i5 != 5) {
            throw zzalf.zza();
        }
        zzf(4);
        return true;
    }
}
