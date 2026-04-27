package u5;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: u5.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1250g implements i, InterfaceC1251h, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f10525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10526b;

    public final long A(E source) {
        kotlin.jvm.internal.j.e(source, "source");
        long j4 = 0;
        while (true) {
            long jA = source.a(8192L, this);
            if (jA == -1) {
                return j4;
            }
            j4 += jA;
        }
    }

    public final void B(int i) {
        z zVarW = w(1);
        int i6 = zVarW.f10560c;
        zVarW.f10560c = i6 + 1;
        zVarW.f10558a[i6] = (byte) i;
        this.f10526b++;
    }

    public final void C(long j4) {
        if (j4 == 0) {
            B(48);
            return;
        }
        long j6 = (j4 >>> 1) | j4;
        long j7 = j6 | (j6 >>> 2);
        long j8 = j7 | (j7 >>> 4);
        long j9 = j8 | (j8 >>> 8);
        long j10 = j9 | (j9 >>> 16);
        long j11 = j10 | (j10 >>> 32);
        long j12 = j11 - ((j11 >>> 1) & 6148914691236517205L);
        long j13 = ((j12 >>> 2) & 3689348814741910323L) + (j12 & 3689348814741910323L);
        long j14 = ((j13 >>> 4) + j13) & 1085102592571150095L;
        long j15 = j14 + (j14 >>> 8);
        long j16 = j15 + (j15 >>> 16);
        int i = (int) ((((j16 & 63) + ((j16 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        z zVarW = w(i);
        int i6 = zVarW.f10560c;
        for (int i7 = (i6 + i) - 1; i7 >= i6; i7--) {
            zVarW.f10558a[i7] = v5.a.f10654a[(int) (15 & j4)];
            j4 >>>= 4;
        }
        zVarW.f10560c += i;
        this.f10526b += (long) i;
    }

    public final void D(int i, int i6, String string) {
        char cCharAt;
        kotlin.jvm.internal.j.e(string, "string");
        if (i < 0) {
            throw new IllegalArgumentException(a3.d.f(i, "beginIndex < 0: ").toString());
        }
        if (i6 < i) {
            throw new IllegalArgumentException(a3.d.h("endIndex < beginIndex: ", i6, i, " < ").toString());
        }
        if (i6 > string.length()) {
            StringBuilder sbO = a3.d.o("endIndex > string.length: ", i6, " > ");
            sbO.append(string.length());
            throw new IllegalArgumentException(sbO.toString().toString());
        }
        while (i < i6) {
            char cCharAt2 = string.charAt(i);
            if (cCharAt2 < 128) {
                z zVarW = w(1);
                int i7 = zVarW.f10560c - i;
                int iMin = Math.min(i6, 8192 - i7);
                int i8 = i + 1;
                byte[] bArr = zVarW.f10558a;
                bArr[i + i7] = (byte) cCharAt2;
                while (true) {
                    i = i8;
                    if (i >= iMin || (cCharAt = string.charAt(i)) >= 128) {
                        break;
                    }
                    i8 = i + 1;
                    bArr[i + i7] = (byte) cCharAt;
                }
                int i9 = zVarW.f10560c;
                int i10 = (i7 + i) - i9;
                zVarW.f10560c = i9 + i10;
                this.f10526b += (long) i10;
            } else {
                if (cCharAt2 < 2048) {
                    z zVarW2 = w(2);
                    int i11 = zVarW2.f10560c;
                    byte[] bArr2 = zVarW2.f10558a;
                    bArr2[i11] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i11 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    zVarW2.f10560c = i11 + 2;
                    this.f10526b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    z zVarW3 = w(3);
                    int i12 = zVarW3.f10560c;
                    byte[] bArr3 = zVarW3.f10558a;
                    bArr3[i12] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i12 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i12 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    zVarW3.f10560c = i12 + 3;
                    this.f10526b += 3;
                } else {
                    int i13 = i + 1;
                    char cCharAt3 = i13 < i6 ? string.charAt(i13) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        B(63);
                        i = i13;
                    } else {
                        int i14 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        z zVarW4 = w(4);
                        int i15 = zVarW4.f10560c;
                        byte[] bArr4 = zVarW4.f10558a;
                        bArr4[i15] = (byte) ((i14 >> 18) | 240);
                        bArr4[i15 + 1] = (byte) (((i14 >> 12) & 63) | 128);
                        bArr4[i15 + 2] = (byte) (((i14 >> 6) & 63) | 128);
                        bArr4[i15 + 3] = (byte) ((i14 & 63) | 128);
                        zVarW4.f10560c = i15 + 4;
                        this.f10526b += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    public final void E(String string) {
        kotlin.jvm.internal.j.e(string, "string");
        D(0, string.length(), string);
    }

    @Override // u5.E
    public final long a(long j4, C1250g sink) {
        kotlin.jvm.internal.j.e(sink, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(k0.a.f("byteCount < 0: ", j4).toString());
        }
        long j6 = this.f10526b;
        if (j6 == 0) {
            return -1L;
        }
        if (j4 > j6) {
            j4 = j6;
        }
        sink.c(j4, this);
        return j4;
    }

    @Override // u5.E
    public final G b() {
        return G.f10504d;
    }

    @Override // u5.C
    public final void c(long j4, C1250g source) {
        z zVarB;
        kotlin.jvm.internal.j.e(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        AbstractC1245b.d(source.f10526b, 0L, j4);
        while (j4 > 0) {
            z zVar = source.f10525a;
            kotlin.jvm.internal.j.b(zVar);
            int i = zVar.f10560c;
            z zVar2 = source.f10525a;
            kotlin.jvm.internal.j.b(zVar2);
            long j6 = i - zVar2.f10559b;
            int i6 = 0;
            if (j4 < j6) {
                z zVar3 = this.f10525a;
                z zVar4 = zVar3 != null ? zVar3.f10563g : null;
                if (zVar4 != null && zVar4.e) {
                    if ((((long) zVar4.f10560c) + j4) - ((long) (zVar4.f10561d ? 0 : zVar4.f10559b)) <= 8192) {
                        z zVar5 = source.f10525a;
                        kotlin.jvm.internal.j.b(zVar5);
                        zVar5.d(zVar4, (int) j4);
                        source.f10526b -= j4;
                        this.f10526b += j4;
                        return;
                    }
                }
                z zVar6 = source.f10525a;
                kotlin.jvm.internal.j.b(zVar6);
                int i7 = (int) j4;
                if (i7 <= 0 || i7 > zVar6.f10560c - zVar6.f10559b) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i7 >= 1024) {
                    zVarB = zVar6.c();
                } else {
                    zVarB = A.b();
                    int i8 = zVar6.f10559b;
                    H4.g.e0(zVar6.f10558a, 0, zVarB.f10558a, i8, i8 + i7);
                }
                zVarB.f10560c = zVarB.f10559b + i7;
                zVar6.f10559b += i7;
                z zVar7 = zVar6.f10563g;
                kotlin.jvm.internal.j.b(zVar7);
                zVar7.b(zVarB);
                source.f10525a = zVarB;
            }
            z zVar8 = source.f10525a;
            kotlin.jvm.internal.j.b(zVar8);
            long j7 = zVar8.f10560c - zVar8.f10559b;
            source.f10525a = zVar8.a();
            z zVar9 = this.f10525a;
            if (zVar9 == null) {
                this.f10525a = zVar8;
                zVar8.f10563g = zVar8;
                zVar8.f10562f = zVar8;
            } else {
                z zVar10 = zVar9.f10563g;
                kotlin.jvm.internal.j.b(zVar10);
                zVar10.b(zVar8);
                z zVar11 = zVar8.f10563g;
                if (zVar11 == zVar8) {
                    throw new IllegalStateException("cannot compact");
                }
                kotlin.jvm.internal.j.b(zVar11);
                if (zVar11.e) {
                    int i9 = zVar8.f10560c - zVar8.f10559b;
                    z zVar12 = zVar8.f10563g;
                    kotlin.jvm.internal.j.b(zVar12);
                    int i10 = 8192 - zVar12.f10560c;
                    z zVar13 = zVar8.f10563g;
                    kotlin.jvm.internal.j.b(zVar13);
                    if (!zVar13.f10561d) {
                        z zVar14 = zVar8.f10563g;
                        kotlin.jvm.internal.j.b(zVar14);
                        i6 = zVar14.f10559b;
                    }
                    if (i9 <= i10 + i6) {
                        z zVar15 = zVar8.f10563g;
                        kotlin.jvm.internal.j.b(zVar15);
                        zVar8.d(zVar15, i9);
                        zVar8.a();
                        A.a(zVar8);
                    }
                }
            }
            source.f10526b -= j7;
            this.f10526b += j7;
            j4 -= j7;
        }
    }

    public final Object clone() {
        C1250g c1250g = new C1250g();
        if (this.f10526b == 0) {
            return c1250g;
        }
        z zVar = this.f10525a;
        kotlin.jvm.internal.j.b(zVar);
        z zVarC = zVar.c();
        c1250g.f10525a = zVarC;
        zVarC.f10563g = zVarC;
        zVarC.f10562f = zVarC;
        for (z zVar2 = zVar.f10562f; zVar2 != zVar; zVar2 = zVar2.f10562f) {
            z zVar3 = zVarC.f10563g;
            kotlin.jvm.internal.j.b(zVar3);
            kotlin.jvm.internal.j.b(zVar2);
            zVar3.b(zVar2.c());
        }
        c1250g.f10526b = this.f10526b;
        return c1250g;
    }

    public final void d() throws EOFException {
        t(this.f10526b);
    }

    @Override // u5.InterfaceC1251h
    public final /* bridge */ /* synthetic */ InterfaceC1251h e(String str) {
        E(str);
        return this;
    }

    public final boolean equals(Object obj) {
        boolean z6 = true;
        if (this == obj) {
            return true;
        }
        boolean z7 = false;
        if (!(obj instanceof C1250g)) {
            return false;
        }
        long j4 = this.f10526b;
        C1250g c1250g = (C1250g) obj;
        if (j4 != c1250g.f10526b) {
            return false;
        }
        if (j4 == 0) {
            return true;
        }
        z zVar = this.f10525a;
        kotlin.jvm.internal.j.b(zVar);
        z zVar2 = c1250g.f10525a;
        kotlin.jvm.internal.j.b(zVar2);
        int i = zVar.f10559b;
        int i6 = zVar2.f10559b;
        long j6 = 0;
        while (j6 < this.f10526b) {
            long jMin = Math.min(zVar.f10560c - i, zVar2.f10560c - i6);
            long j7 = 0;
            while (j7 < jMin) {
                int i7 = i + 1;
                boolean z8 = z6;
                byte b3 = zVar.f10558a[i];
                int i8 = i6 + 1;
                boolean z9 = z7;
                if (b3 != zVar2.f10558a[i6]) {
                    return z9;
                }
                j7++;
                i6 = i8;
                i = i7;
                z6 = z8;
                z7 = z9;
            }
            boolean z10 = z6;
            boolean z11 = z7;
            if (i == zVar.f10560c) {
                z zVar3 = zVar.f10562f;
                kotlin.jvm.internal.j.b(zVar3);
                i = zVar3.f10559b;
                zVar = zVar3;
            }
            if (i6 == zVar2.f10560c) {
                zVar2 = zVar2.f10562f;
                kotlin.jvm.internal.j.b(zVar2);
                i6 = zVar2.f10559b;
            }
            j6 += jMin;
            z6 = z10;
            z7 = z11;
        }
        return z6;
    }

    public final long f() {
        long j4 = this.f10526b;
        if (j4 == 0) {
            return 0L;
        }
        z zVar = this.f10525a;
        kotlin.jvm.internal.j.b(zVar);
        z zVar2 = zVar.f10563g;
        kotlin.jvm.internal.j.b(zVar2);
        int i = zVar2.f10560c;
        return (i >= 8192 || !zVar2.e) ? j4 : j4 - ((long) (i - zVar2.f10559b));
    }

    public final void g(C1250g out, long j4, long j6) {
        kotlin.jvm.internal.j.e(out, "out");
        long j7 = j4;
        AbstractC1245b.d(this.f10526b, j7, j6);
        if (j6 == 0) {
            return;
        }
        out.f10526b += j6;
        z zVar = this.f10525a;
        while (true) {
            kotlin.jvm.internal.j.b(zVar);
            long j8 = zVar.f10560c - zVar.f10559b;
            if (j7 < j8) {
                break;
            }
            j7 -= j8;
            zVar = zVar.f10562f;
        }
        z zVar2 = zVar;
        long j9 = j6;
        while (j9 > 0) {
            kotlin.jvm.internal.j.b(zVar2);
            z zVarC = zVar2.c();
            int i = zVarC.f10559b + ((int) j7);
            zVarC.f10559b = i;
            zVarC.f10560c = Math.min(i + ((int) j9), zVarC.f10560c);
            z zVar3 = out.f10525a;
            if (zVar3 == null) {
                zVarC.f10563g = zVarC;
                zVarC.f10562f = zVarC;
                out.f10525a = zVarC;
            } else {
                z zVar4 = zVar3.f10563g;
                kotlin.jvm.internal.j.b(zVar4);
                zVar4.b(zVarC);
            }
            j9 -= (long) (zVarC.f10560c - zVarC.f10559b);
            zVar2 = zVar2.f10562f;
            j7 = 0;
        }
    }

    public final boolean h() {
        return this.f10526b == 0;
    }

    public final int hashCode() {
        z zVar = this.f10525a;
        if (zVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i6 = zVar.f10560c;
            for (int i7 = zVar.f10559b; i7 < i6; i7++) {
                i = (i * 31) + zVar.f10558a[i7];
            }
            zVar = zVar.f10562f;
            kotlin.jvm.internal.j.b(zVar);
        } while (zVar != this.f10525a);
        return i;
    }

    public final byte i(long j4) {
        AbstractC1245b.d(this.f10526b, j4, 1L);
        z zVar = this.f10525a;
        if (zVar == null) {
            kotlin.jvm.internal.j.b(null);
            throw null;
        }
        long j6 = this.f10526b;
        if (j6 - j4 < j4) {
            while (j6 > j4) {
                zVar = zVar.f10563g;
                kotlin.jvm.internal.j.b(zVar);
                j6 -= (long) (zVar.f10560c - zVar.f10559b);
            }
            return zVar.f10558a[(int) ((((long) zVar.f10559b) + j4) - j6)];
        }
        long j7 = 0;
        while (true) {
            int i = zVar.f10560c;
            int i6 = zVar.f10559b;
            long j8 = ((long) (i - i6)) + j7;
            if (j8 > j4) {
                return zVar.f10558a[(int) ((((long) i6) + j4) - j7)];
            }
            zVar = zVar.f10562f;
            kotlin.jvm.internal.j.b(zVar);
            j7 = j8;
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final long j(byte b3, long j4, long j6) {
        z zVar;
        long j7 = 0;
        if (0 > j4 || j4 > j6) {
            throw new IllegalArgumentException(("size=" + this.f10526b + " fromIndex=" + j4 + " toIndex=" + j6).toString());
        }
        long j8 = this.f10526b;
        if (j6 > j8) {
            j6 = j8;
        }
        if (j4 == j6 || (zVar = this.f10525a) == null) {
            return -1L;
        }
        if (j8 - j4 < j4) {
            while (j8 > j4) {
                zVar = zVar.f10563g;
                kotlin.jvm.internal.j.b(zVar);
                j8 -= (long) (zVar.f10560c - zVar.f10559b);
            }
            while (j8 < j6) {
                int iMin = (int) Math.min(zVar.f10560c, (((long) zVar.f10559b) + j6) - j8);
                for (int i = (int) ((((long) zVar.f10559b) + j4) - j8); i < iMin; i++) {
                    if (zVar.f10558a[i] == b3) {
                        return ((long) (i - zVar.f10559b)) + j8;
                    }
                }
                j8 += (long) (zVar.f10560c - zVar.f10559b);
                zVar = zVar.f10562f;
                kotlin.jvm.internal.j.b(zVar);
                j4 = j8;
            }
            return -1L;
        }
        while (true) {
            long j9 = ((long) (zVar.f10560c - zVar.f10559b)) + j7;
            if (j9 > j4) {
                break;
            }
            zVar = zVar.f10562f;
            kotlin.jvm.internal.j.b(zVar);
            j7 = j9;
        }
        while (j7 < j6) {
            int iMin2 = (int) Math.min(zVar.f10560c, (((long) zVar.f10559b) + j6) - j7);
            for (int i6 = (int) ((((long) zVar.f10559b) + j4) - j7); i6 < iMin2; i6++) {
                if (zVar.f10558a[i6] == b3) {
                    return ((long) (i6 - zVar.f10559b)) + j7;
                }
            }
            j7 += (long) (zVar.f10560c - zVar.f10559b);
            zVar = zVar.f10562f;
            kotlin.jvm.internal.j.b(zVar);
            j4 = j7;
        }
        return -1L;
    }

    public final long k(j targetBytes) {
        int i;
        int i6;
        kotlin.jvm.internal.j.e(targetBytes, "targetBytes");
        z zVar = this.f10525a;
        if (zVar == null) {
            return -1L;
        }
        long j4 = this.f10526b;
        long j6 = 0;
        byte[] bArr = targetBytes.f10528a;
        if (j4 < 0) {
            while (j4 > 0) {
                zVar = zVar.f10563g;
                kotlin.jvm.internal.j.b(zVar);
                j4 -= (long) (zVar.f10560c - zVar.f10559b);
            }
            if (bArr.length == 2) {
                byte b3 = bArr[0];
                byte b6 = bArr[1];
                while (j4 < this.f10526b) {
                    i = (int) ((((long) zVar.f10559b) + j6) - j4);
                    int i7 = zVar.f10560c;
                    while (i < i7) {
                        byte b7 = zVar.f10558a[i];
                        if (b7 == b3 || b7 == b6) {
                            i6 = zVar.f10559b;
                        } else {
                            i++;
                        }
                    }
                    j6 = ((long) (zVar.f10560c - zVar.f10559b)) + j4;
                    zVar = zVar.f10562f;
                    kotlin.jvm.internal.j.b(zVar);
                    j4 = j6;
                }
                return -1L;
            }
            while (j4 < this.f10526b) {
                i = (int) ((((long) zVar.f10559b) + j6) - j4);
                int i8 = zVar.f10560c;
                while (i < i8) {
                    byte b8 = zVar.f10558a[i];
                    for (byte b9 : bArr) {
                        if (b8 == b9) {
                            i6 = zVar.f10559b;
                        }
                    }
                    i++;
                }
                j6 = ((long) (zVar.f10560c - zVar.f10559b)) + j4;
                zVar = zVar.f10562f;
                kotlin.jvm.internal.j.b(zVar);
                j4 = j6;
            }
            return -1L;
        }
        j4 = 0;
        while (true) {
            long j7 = ((long) (zVar.f10560c - zVar.f10559b)) + j4;
            if (j7 > 0) {
                break;
            }
            zVar = zVar.f10562f;
            kotlin.jvm.internal.j.b(zVar);
            j4 = j7;
        }
        if (bArr.length == 2) {
            byte b10 = bArr[0];
            byte b11 = bArr[1];
            while (j4 < this.f10526b) {
                i = (int) ((((long) zVar.f10559b) + j6) - j4);
                int i9 = zVar.f10560c;
                while (i < i9) {
                    byte b12 = zVar.f10558a[i];
                    if (b12 == b10 || b12 == b11) {
                        i6 = zVar.f10559b;
                    } else {
                        i++;
                    }
                }
                j6 = ((long) (zVar.f10560c - zVar.f10559b)) + j4;
                zVar = zVar.f10562f;
                kotlin.jvm.internal.j.b(zVar);
                j4 = j6;
            }
            return -1L;
        }
        while (j4 < this.f10526b) {
            i = (int) ((((long) zVar.f10559b) + j6) - j4);
            int i10 = zVar.f10560c;
            while (i < i10) {
                byte b13 = zVar.f10558a[i];
                for (byte b14 : bArr) {
                    if (b13 == b14) {
                        i6 = zVar.f10559b;
                    }
                }
                i++;
            }
            j6 = ((long) (zVar.f10560c - zVar.f10559b)) + j4;
            zVar = zVar.f10562f;
            kotlin.jvm.internal.j.b(zVar);
            j4 = j6;
        }
        return -1L;
        return ((long) (i - i6)) + j4;
    }

    public final boolean l(j bytes) {
        kotlin.jvm.internal.j.e(bytes, "bytes");
        byte[] bArr = bytes.f10528a;
        int length = bArr.length;
        if (length >= 0 && this.f10526b >= length && bArr.length >= length) {
            for (int i = 0; i < length; i++) {
                if (i(i) == bArr[i]) {
                }
            }
            return true;
        }
        return false;
    }

    public final byte m() throws EOFException {
        if (this.f10526b == 0) {
            throw new EOFException();
        }
        z zVar = this.f10525a;
        kotlin.jvm.internal.j.b(zVar);
        int i = zVar.f10559b;
        int i6 = zVar.f10560c;
        int i7 = i + 1;
        byte b3 = zVar.f10558a[i];
        this.f10526b--;
        if (i7 != i6) {
            zVar.f10559b = i7;
            return b3;
        }
        this.f10525a = zVar.a();
        A.a(zVar);
        return b3;
    }

    public final byte[] n(long j4) throws EOFException {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(k0.a.f("byteCount: ", j4).toString());
        }
        if (this.f10526b < j4) {
            throw new EOFException();
        }
        byte[] sink = new byte[(int) j4];
        kotlin.jvm.internal.j.e(sink, "sink");
        int i = 0;
        while (i < sink.length) {
            int i6 = read(sink, i, sink.length - i);
            if (i6 == -1) {
                throw new EOFException();
            }
            i += i6;
        }
        return sink;
    }

    public final j o(long j4) throws EOFException {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(k0.a.f("byteCount: ", j4).toString());
        }
        if (this.f10526b < j4) {
            throw new EOFException();
        }
        if (j4 < 4096) {
            return new j(n(j4));
        }
        j jVarV = v((int) j4);
        t(j4);
        return jVarV;
    }

    public final int p() throws EOFException {
        if (this.f10526b < 4) {
            throw new EOFException();
        }
        z zVar = this.f10525a;
        kotlin.jvm.internal.j.b(zVar);
        int i = zVar.f10559b;
        int i6 = zVar.f10560c;
        if (i6 - i < 4) {
            return ((m() & 255) << 24) | ((m() & 255) << 16) | ((m() & 255) << 8) | (m() & 255);
        }
        byte[] bArr = zVar.f10558a;
        int i7 = i + 3;
        int i8 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i9 = i + 4;
        int i10 = i8 | (bArr[i7] & 255);
        this.f10526b -= 4;
        if (i9 != i6) {
            zVar.f10559b = i9;
            return i10;
        }
        this.f10525a = zVar.a();
        A.a(zVar);
        return i10;
    }

    public final short q() throws EOFException {
        if (this.f10526b < 2) {
            throw new EOFException();
        }
        z zVar = this.f10525a;
        kotlin.jvm.internal.j.b(zVar);
        int i = zVar.f10559b;
        int i6 = zVar.f10560c;
        if (i6 - i < 2) {
            return (short) (((m() & 255) << 8) | (m() & 255));
        }
        int i7 = i + 1;
        byte[] bArr = zVar.f10558a;
        int i8 = (bArr[i] & 255) << 8;
        int i9 = i + 2;
        int i10 = (bArr[i7] & 255) | i8;
        this.f10526b -= 2;
        if (i9 == i6) {
            this.f10525a = zVar.a();
            A.a(zVar);
        } else {
            zVar.f10559b = i9;
        }
        return (short) i10;
    }

    public final String r(long j4, Charset charset) throws EOFException {
        kotlin.jvm.internal.j.e(charset, "charset");
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(k0.a.f("byteCount: ", j4).toString());
        }
        if (this.f10526b < j4) {
            throw new EOFException();
        }
        if (j4 == 0) {
            return "";
        }
        z zVar = this.f10525a;
        kotlin.jvm.internal.j.b(zVar);
        int i = zVar.f10559b;
        if (((long) i) + j4 > zVar.f10560c) {
            return new String(n(j4), charset);
        }
        int i6 = (int) j4;
        String str = new String(zVar.f10558a, i, i6, charset);
        int i7 = zVar.f10559b + i6;
        zVar.f10559b = i7;
        this.f10526b -= j4;
        if (i7 == zVar.f10560c) {
            this.f10525a = zVar.a();
            A.a(zVar);
        }
        return str;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.j.e(sink, "sink");
        z zVar = this.f10525a;
        if (zVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), zVar.f10560c - zVar.f10559b);
        sink.put(zVar.f10558a, zVar.f10559b, iMin);
        int i = zVar.f10559b + iMin;
        zVar.f10559b = i;
        this.f10526b -= (long) iMin;
        if (i == zVar.f10560c) {
            this.f10525a = zVar.a();
            A.a(zVar);
        }
        return iMin;
    }

    public final String s() {
        return r(this.f10526b, Y4.a.f3689a);
    }

    public final void t(long j4) throws EOFException {
        while (j4 > 0) {
            z zVar = this.f10525a;
            if (zVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j4, zVar.f10560c - zVar.f10559b);
            long j6 = iMin;
            this.f10526b -= j6;
            j4 -= j6;
            int i = zVar.f10559b + iMin;
            zVar.f10559b = i;
            if (i == zVar.f10560c) {
                this.f10525a = zVar.a();
                A.a(zVar);
            }
        }
    }

    public final String toString() {
        return u().toString();
    }

    public final j u() {
        long j4 = this.f10526b;
        if (j4 <= 2147483647L) {
            return v((int) j4);
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f10526b).toString());
    }

    public final j v(int i) {
        if (i == 0) {
            return j.f10527d;
        }
        AbstractC1245b.d(this.f10526b, 0L, i);
        z zVar = this.f10525a;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i) {
            kotlin.jvm.internal.j.b(zVar);
            int i9 = zVar.f10560c;
            int i10 = zVar.f10559b;
            if (i9 == i10) {
                throw new AssertionError("s.limit == s.pos");
            }
            i7 += i9 - i10;
            i8++;
            zVar = zVar.f10562f;
        }
        byte[][] bArr = new byte[i8][];
        int[] iArr = new int[i8 * 2];
        z zVar2 = this.f10525a;
        int i11 = 0;
        while (i6 < i) {
            kotlin.jvm.internal.j.b(zVar2);
            bArr[i11] = zVar2.f10558a;
            i6 += zVar2.f10560c - zVar2.f10559b;
            iArr[i11] = Math.min(i6, i);
            iArr[i11 + i8] = zVar2.f10559b;
            zVar2.f10561d = true;
            i11++;
            zVar2 = zVar2.f10562f;
        }
        return new B(bArr, iArr);
    }

    public final z w(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        z zVar = this.f10525a;
        if (zVar == null) {
            z zVarB = A.b();
            this.f10525a = zVarB;
            zVarB.f10563g = zVarB;
            zVarB.f10562f = zVarB;
            return zVarB;
        }
        z zVar2 = zVar.f10563g;
        kotlin.jvm.internal.j.b(zVar2);
        if (zVar2.f10560c + i <= 8192 && zVar2.e) {
            return zVar2;
        }
        z zVarB2 = A.b();
        zVar2.b(zVarB2);
        return zVarB2;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.j.e(source, "source");
        int iRemaining = source.remaining();
        int i = iRemaining;
        while (i > 0) {
            z zVarW = w(1);
            int iMin = Math.min(i, 8192 - zVarW.f10560c);
            source.get(zVarW.f10558a, zVarW.f10560c, iMin);
            i -= iMin;
            zVarW.f10560c += iMin;
        }
        this.f10526b += (long) iRemaining;
        return iRemaining;
    }

    public final void x(j byteString) {
        kotlin.jvm.internal.j.e(byteString, "byteString");
        byteString.t(this, byteString.d());
    }

    public final void y(byte[] source) {
        kotlin.jvm.internal.j.e(source, "source");
        z(source, 0, source.length);
    }

    public final void z(byte[] source, int i, int i6) {
        kotlin.jvm.internal.j.e(source, "source");
        long j4 = i6;
        AbstractC1245b.d(source.length, i, j4);
        int i7 = i6 + i;
        while (i < i7) {
            z zVarW = w(1);
            int iMin = Math.min(i7 - i, 8192 - zVarW.f10560c);
            int i8 = i + iMin;
            H4.g.e0(source, zVarW.f10560c, zVarW.f10558a, i, i8);
            zVarW.f10560c += iMin;
            i = i8;
        }
        this.f10526b += j4;
    }

    public final int read(byte[] sink, int i, int i6) {
        kotlin.jvm.internal.j.e(sink, "sink");
        AbstractC1245b.d(sink.length, i, i6);
        z zVar = this.f10525a;
        if (zVar == null) {
            return -1;
        }
        int iMin = Math.min(i6, zVar.f10560c - zVar.f10559b);
        int i7 = zVar.f10559b;
        H4.g.e0(zVar.f10558a, i, sink, i7, i7 + iMin);
        int i8 = zVar.f10559b + iMin;
        zVar.f10559b = i8;
        this.f10526b -= (long) iMin;
        if (i8 == zVar.f10560c) {
            this.f10525a = zVar.a();
            A.a(zVar);
        }
        return iMin;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, u5.C
    public final void close() {
    }

    @Override // u5.C, java.io.Flushable
    public final void flush() {
    }
}
