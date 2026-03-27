package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0474m extends AbstractC0480p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f5751d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5752f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f5754l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5755m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5756n = com.google.android.gms.common.api.f.API_PRIORITY_OTHER;

    public C0474m(byte[] bArr, int i, int i6, boolean z6) {
        this.f5751d = bArr;
        this.e = i6 + i;
        this.f5753k = i;
        this.f5754l = i;
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final int A() throws O {
        if (g()) {
            this.f5755m = 0;
            return 0;
        }
        int iH = H();
        this.f5755m = iH;
        if ((iH >>> 3) != 0) {
            return iH;
        }
        throw O.b();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final int B() {
        return H();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final long C() {
        return I();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final boolean D(int i) throws O {
        int i6 = i & 7;
        int i7 = 0;
        if (i6 != 0) {
            if (i6 == 1) {
                L(8);
                return true;
            }
            if (i6 == 2) {
                L(H());
                return true;
            }
            if (i6 == 3) {
                E();
                a(((i >>> 3) << 3) | 4);
                return true;
            }
            if (i6 == 4) {
                return false;
            }
            if (i6 != 5) {
                throw O.d();
            }
            L(4);
            return true;
        }
        int i8 = this.e - this.f5753k;
        byte[] bArr = this.f5751d;
        if (i8 >= 10) {
            while (i7 < 10) {
                int i9 = this.f5753k;
                this.f5753k = i9 + 1;
                if (bArr[i9] < 0) {
                    i7++;
                }
            }
            throw O.e();
        }
        while (i7 < 10) {
            int i10 = this.f5753k;
            if (i10 == this.e) {
                throw O.h();
            }
            this.f5753k = i10 + 1;
            if (bArr[i10] < 0) {
                i7++;
            }
        }
        throw O.e();
        return true;
    }

    public final int F() throws O {
        int i = this.f5753k;
        if (this.e - i < 4) {
            throw O.h();
        }
        this.f5753k = i + 4;
        byte[] bArr = this.f5751d;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long G() throws O {
        int i = this.f5753k;
        if (this.e - i < 8) {
            throw O.h();
        }
        this.f5753k = i + 8;
        byte[] bArr = this.f5751d;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int H() {
        int i;
        int i6 = this.f5753k;
        int i7 = this.e;
        if (i7 != i6) {
            int i8 = i6 + 1;
            byte[] bArr = this.f5751d;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                this.f5753k = i8;
                return b3;
            }
            if (i7 - i8 >= 9) {
                int i9 = i6 + 2;
                int i10 = (bArr[i8] << 7) ^ b3;
                if (i10 < 0) {
                    i = i10 ^ (-128);
                } else {
                    int i11 = i6 + 3;
                    int i12 = (bArr[i9] << 14) ^ i10;
                    if (i12 >= 0) {
                        i = i12 ^ 16256;
                    } else {
                        int i13 = i6 + 4;
                        int i14 = i12 ^ (bArr[i11] << 21);
                        if (i14 < 0) {
                            i = (-2080896) ^ i14;
                        } else {
                            i11 = i6 + 5;
                            byte b6 = bArr[i13];
                            int i15 = (i14 ^ (b6 << 28)) ^ 266354560;
                            if (b6 < 0) {
                                i13 = i6 + 6;
                                if (bArr[i11] < 0) {
                                    i11 = i6 + 7;
                                    if (bArr[i13] < 0) {
                                        i13 = i6 + 8;
                                        if (bArr[i11] < 0) {
                                            i11 = i6 + 9;
                                            if (bArr[i13] < 0) {
                                                int i16 = i6 + 10;
                                                if (bArr[i11] >= 0) {
                                                    i9 = i16;
                                                    i = i15;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i15;
                            }
                            i = i15;
                        }
                        i9 = i13;
                    }
                    i9 = i11;
                }
                this.f5753k = i9;
                return i;
            }
        }
        return (int) J();
    }

    public final long I() {
        long j4;
        long j6;
        long j7;
        long j8;
        int i = this.f5753k;
        int i6 = this.e;
        if (i6 != i) {
            int i7 = i + 1;
            byte[] bArr = this.f5751d;
            byte b3 = bArr[i];
            if (b3 >= 0) {
                this.f5753k = i7;
                return b3;
            }
            if (i6 - i7 >= 9) {
                int i8 = i + 2;
                int i9 = (bArr[i7] << 7) ^ b3;
                if (i9 < 0) {
                    j4 = i9 ^ (-128);
                } else {
                    int i10 = i + 3;
                    int i11 = (bArr[i8] << 14) ^ i9;
                    if (i11 >= 0) {
                        j4 = i11 ^ 16256;
                        i8 = i10;
                    } else {
                        int i12 = i + 4;
                        int i13 = i11 ^ (bArr[i10] << 21);
                        if (i13 < 0) {
                            j8 = (-2080896) ^ i13;
                        } else {
                            long j9 = i13;
                            i8 = i + 5;
                            long j10 = j9 ^ (((long) bArr[i12]) << 28);
                            if (j10 >= 0) {
                                j7 = 266354560;
                            } else {
                                i12 = i + 6;
                                long j11 = j10 ^ (((long) bArr[i8]) << 35);
                                if (j11 < 0) {
                                    j6 = -34093383808L;
                                } else {
                                    i8 = i + 7;
                                    j10 = j11 ^ (((long) bArr[i12]) << 42);
                                    if (j10 >= 0) {
                                        j7 = 4363953127296L;
                                    } else {
                                        i12 = i + 8;
                                        j11 = j10 ^ (((long) bArr[i8]) << 49);
                                        if (j11 < 0) {
                                            j6 = -558586000294016L;
                                        } else {
                                            i8 = i + 9;
                                            long j12 = (j11 ^ (((long) bArr[i12]) << 56)) ^ 71499008037633920L;
                                            if (j12 < 0) {
                                                int i14 = i + 10;
                                                if (bArr[i8] >= 0) {
                                                    i8 = i14;
                                                }
                                            }
                                            j4 = j12;
                                        }
                                    }
                                }
                                j8 = j6 ^ j11;
                            }
                            j4 = j7 ^ j10;
                        }
                        i8 = i12;
                        j4 = j8;
                    }
                }
                this.f5753k = i8;
                return j4;
            }
        }
        return J();
    }

    public final long J() throws O {
        long j4 = 0;
        for (int i = 0; i < 64; i += 7) {
            int i6 = this.f5753k;
            if (i6 == this.e) {
                throw O.h();
            }
            this.f5753k = i6 + 1;
            byte b3 = this.f5751d[i6];
            j4 |= ((long) (b3 & 127)) << i;
            if ((b3 & 128) == 0) {
                return j4;
            }
        }
        throw O.e();
    }

    public final void K() {
        int i = this.e + this.f5752f;
        this.e = i;
        int i6 = i - this.f5754l;
        int i7 = this.f5756n;
        if (i6 <= i7) {
            this.f5752f = 0;
            return;
        }
        int i8 = i6 - i7;
        this.f5752f = i8;
        this.e = i - i8;
    }

    public final void L(int i) throws O {
        if (i >= 0) {
            int i6 = this.e;
            int i7 = this.f5753k;
            if (i <= i6 - i7) {
                this.f5753k = i7 + i;
                return;
            }
        }
        if (i >= 0) {
            throw O.h();
        }
        throw O.f();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final void a(int i) throws O {
        if (this.f5755m != i) {
            throw O.a();
        }
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final int f() {
        return this.f5753k - this.f5754l;
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final boolean g() {
        return this.f5753k == this.e;
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final void i(int i) {
        this.f5756n = i;
        K();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final int j(int i) throws O {
        if (i < 0) {
            throw O.f();
        }
        int iF = f() + i;
        if (iF < 0) {
            throw O.g();
        }
        int i6 = this.f5756n;
        if (iF > i6) {
            throw O.h();
        }
        this.f5756n = iF;
        K();
        return i6;
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final boolean k() {
        return I() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    @Override // com.google.protobuf.AbstractC0480p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.protobuf.C0470k l() throws com.google.protobuf.O {
        /*
            r4 = this;
            int r0 = r4.H()
            byte[] r1 = r4.f5751d
            if (r0 <= 0) goto L19
            int r2 = r4.e
            int r3 = r4.f5753k
            int r2 = r2 - r3
            if (r0 > r2) goto L19
            com.google.protobuf.k r1 = com.google.protobuf.AbstractC0472l.k(r1, r3, r0)
            int r2 = r4.f5753k
            int r2 = r2 + r0
            r4.f5753k = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.protobuf.k r0 = com.google.protobuf.AbstractC0472l.f5744b
            return r0
        L1e:
            if (r0 <= 0) goto L2f
            int r2 = r4.e
            int r3 = r4.f5753k
            int r2 = r2 - r3
            if (r0 > r2) goto L2f
            int r0 = r0 + r3
            r4.f5753k = r0
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r3, r0)
            goto L35
        L2f:
            if (r0 > 0) goto L42
            if (r0 != 0) goto L3d
            byte[] r0 = com.google.protobuf.M.f5652b
        L35:
            com.google.protobuf.k r1 = com.google.protobuf.AbstractC0472l.f5744b
            com.google.protobuf.k r1 = new com.google.protobuf.k
            r1.<init>(r0)
            return r1
        L3d:
            com.google.protobuf.O r0 = com.google.protobuf.O.f()
            throw r0
        L42:
            com.google.protobuf.O r0 = com.google.protobuf.O.h()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0474m.l():com.google.protobuf.k");
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final double m() {
        return Double.longBitsToDouble(G());
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final int o() {
        return H();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final int p() {
        return F();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final long q() {
        return G();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final float r() {
        return Float.intBitsToFloat(F());
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final int s() {
        return H();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final long t() {
        return I();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final int u() {
        return F();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final long v() {
        return G();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final int w() {
        return AbstractC0480p.b(H());
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final long x() {
        return AbstractC0480p.d(I());
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final String y() throws O {
        int iH = H();
        if (iH > 0) {
            int i = this.e;
            int i6 = this.f5753k;
            if (iH <= i - i6) {
                String str = new String(this.f5751d, i6, iH, M.f5651a);
                this.f5753k += iH;
                return str;
            }
        }
        if (iH == 0) {
            return "";
        }
        if (iH < 0) {
            throw O.f();
        }
        throw O.h();
    }

    @Override // com.google.protobuf.AbstractC0480p
    public final String z() throws O {
        int iH = H();
        if (iH > 0) {
            int i = this.e;
            int i6 = this.f5753k;
            if (iH <= i - i6) {
                String strI = P0.f5671a.i(this.f5751d, i6, iH);
                this.f5753k += iH;
                return strI;
            }
        }
        if (iH == 0) {
            return "";
        }
        if (iH <= 0) {
            throw O.f();
        }
        throw O.h();
    }
}
