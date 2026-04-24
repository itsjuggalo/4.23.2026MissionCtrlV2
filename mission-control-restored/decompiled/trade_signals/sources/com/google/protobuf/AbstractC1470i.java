package com.google.protobuf;

import com.google.protobuf.k0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.protobuf.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1470i extends AbstractC1466e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f16408c = Logger.getLogger(AbstractC1470i.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f16409d = j0.E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1471j f16410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16411b;

    /* JADX INFO: renamed from: com.google.protobuf.i$b */
    public static abstract class b extends AbstractC1470i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f16412e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f16413f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f16414g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f16415h;

        public b(int i8) {
            super();
            if (i8 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i8, 20)];
            this.f16412e = bArr;
            this.f16413f = bArr.length;
        }

        public final void V0(byte b8) {
            byte[] bArr = this.f16412e;
            int i8 = this.f16414g;
            this.f16414g = i8 + 1;
            bArr[i8] = b8;
            this.f16415h++;
        }

        public final void W0(int i8) {
            byte[] bArr = this.f16412e;
            int i9 = this.f16414g;
            int i10 = i9 + 1;
            this.f16414g = i10;
            bArr[i9] = (byte) (i8 & 255);
            int i11 = i9 + 2;
            this.f16414g = i11;
            bArr[i10] = (byte) ((i8 >> 8) & 255);
            int i12 = i9 + 3;
            this.f16414g = i12;
            bArr[i11] = (byte) ((i8 >> 16) & 255);
            this.f16414g = i9 + 4;
            bArr[i12] = (byte) ((i8 >> 24) & 255);
            this.f16415h += 4;
        }

        public final void X0(long j8) {
            byte[] bArr = this.f16412e;
            int i8 = this.f16414g;
            int i9 = i8 + 1;
            this.f16414g = i9;
            bArr[i8] = (byte) (j8 & 255);
            int i10 = i8 + 2;
            this.f16414g = i10;
            bArr[i9] = (byte) ((j8 >> 8) & 255);
            int i11 = i8 + 3;
            this.f16414g = i11;
            bArr[i10] = (byte) ((j8 >> 16) & 255);
            int i12 = i8 + 4;
            this.f16414g = i12;
            bArr[i11] = (byte) (255 & (j8 >> 24));
            int i13 = i8 + 5;
            this.f16414g = i13;
            bArr[i12] = (byte) (((int) (j8 >> 32)) & 255);
            int i14 = i8 + 6;
            this.f16414g = i14;
            bArr[i13] = (byte) (((int) (j8 >> 40)) & 255);
            int i15 = i8 + 7;
            this.f16414g = i15;
            bArr[i14] = (byte) (((int) (j8 >> 48)) & 255);
            this.f16414g = i8 + 8;
            bArr[i15] = (byte) (((int) (j8 >> 56)) & 255);
            this.f16415h += 8;
        }

        public final void Y0(int i8) {
            if (i8 >= 0) {
                a1(i8);
            } else {
                b1(i8);
            }
        }

        public final void Z0(int i8, int i9) {
            a1(l0.c(i8, i9));
        }

        public final void a1(int i8) {
            if (!AbstractC1470i.f16409d) {
                while ((i8 & (-128)) != 0) {
                    byte[] bArr = this.f16412e;
                    int i9 = this.f16414g;
                    this.f16414g = i9 + 1;
                    bArr[i9] = (byte) ((i8 & 127) | 128);
                    this.f16415h++;
                    i8 >>>= 7;
                }
                byte[] bArr2 = this.f16412e;
                int i10 = this.f16414g;
                this.f16414g = i10 + 1;
                bArr2[i10] = (byte) i8;
                this.f16415h++;
                return;
            }
            long j8 = this.f16414g;
            while ((i8 & (-128)) != 0) {
                byte[] bArr3 = this.f16412e;
                int i11 = this.f16414g;
                this.f16414g = i11 + 1;
                j0.K(bArr3, i11, (byte) ((i8 & 127) | 128));
                i8 >>>= 7;
            }
            byte[] bArr4 = this.f16412e;
            int i12 = this.f16414g;
            this.f16414g = i12 + 1;
            j0.K(bArr4, i12, (byte) i8);
            this.f16415h += (int) (((long) this.f16414g) - j8);
        }

        public final void b1(long j8) {
            if (!AbstractC1470i.f16409d) {
                while ((j8 & (-128)) != 0) {
                    byte[] bArr = this.f16412e;
                    int i8 = this.f16414g;
                    this.f16414g = i8 + 1;
                    bArr[i8] = (byte) ((((int) j8) & 127) | 128);
                    this.f16415h++;
                    j8 >>>= 7;
                }
                byte[] bArr2 = this.f16412e;
                int i9 = this.f16414g;
                this.f16414g = i9 + 1;
                bArr2[i9] = (byte) j8;
                this.f16415h++;
                return;
            }
            long j9 = this.f16414g;
            while ((j8 & (-128)) != 0) {
                byte[] bArr3 = this.f16412e;
                int i10 = this.f16414g;
                this.f16414g = i10 + 1;
                j0.K(bArr3, i10, (byte) ((((int) j8) & 127) | 128));
                j8 >>>= 7;
            }
            byte[] bArr4 = this.f16412e;
            int i11 = this.f16414g;
            this.f16414g = i11 + 1;
            j0.K(bArr4, i11, (byte) j8);
            this.f16415h += (int) (((long) this.f16414g) - j9);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final int c0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$c */
    public static class c extends AbstractC1470i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f16416e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f16417f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f16418g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f16419h;

        public c(byte[] bArr, int i8, int i9) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i10 = i8 + i9;
            if ((i8 | i9 | (bArr.length - i10)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i8), Integer.valueOf(i9)));
            }
            this.f16416e = bArr;
            this.f16417f = i8;
            this.f16419h = i8;
            this.f16418g = i10;
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void C0(int i8, J j8, Y y7) throws d {
            Q0(i8, 2);
            S0(((AbstractC1462a) j8).k(y7));
            y7.h(j8, this.f16410a);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void D0(J j8) throws d {
            S0(j8.c());
            j8.h(this);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void E0(int i8, J j8) throws d {
            Q0(1, 3);
            R0(2, i8);
            W0(3, j8);
            Q0(1, 4);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void F0(int i8, AbstractC1467f abstractC1467f) throws d {
            Q0(1, 3);
            R0(2, i8);
            i0(3, abstractC1467f);
            Q0(1, 4);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void O0(int i8, String str) throws d {
            Q0(i8, 2);
            P0(str);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void P0(String str) throws d {
            int iF;
            int i8 = this.f16419h;
            try {
                int iR = AbstractC1470i.R(str.length() * 3);
                int iR2 = AbstractC1470i.R(str.length());
                if (iR2 == iR) {
                    int i9 = i8 + iR2;
                    this.f16419h = i9;
                    iF = k0.f(str, this.f16416e, i9, c0());
                    this.f16419h = i8;
                    S0((iF - i8) - iR2);
                } else {
                    S0(k0.g(str));
                    iF = k0.f(str, this.f16416e, this.f16419h, c0());
                }
                this.f16419h = iF;
            } catch (k0.d e8) {
                this.f16419h = i8;
                X(str, e8);
            } catch (IndexOutOfBoundsException e9) {
                throw new d(e9);
            }
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void Q0(int i8, int i9) throws d {
            S0(l0.c(i8, i9));
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void R0(int i8, int i9) throws d {
            Q0(i8, 0);
            S0(i9);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void S0(int i8) throws d {
            while ((i8 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f16416e;
                    int i9 = this.f16419h;
                    this.f16419h = i9 + 1;
                    bArr[i9] = (byte) ((i8 & 127) | 128);
                    i8 >>>= 7;
                } catch (IndexOutOfBoundsException e8) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f16419h), Integer.valueOf(this.f16418g), 1), e8);
                }
            }
            byte[] bArr2 = this.f16416e;
            int i10 = this.f16419h;
            this.f16419h = i10 + 1;
            bArr2[i10] = (byte) i8;
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void T0(int i8, long j8) throws d {
            Q0(i8, 0);
            U0(j8);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void U0(long j8) throws d {
            if (AbstractC1470i.f16409d && c0() >= 10) {
                while ((j8 & (-128)) != 0) {
                    byte[] bArr = this.f16416e;
                    int i8 = this.f16419h;
                    this.f16419h = i8 + 1;
                    j0.K(bArr, i8, (byte) ((((int) j8) & 127) | 128));
                    j8 >>>= 7;
                }
                byte[] bArr2 = this.f16416e;
                int i9 = this.f16419h;
                this.f16419h = i9 + 1;
                j0.K(bArr2, i9, (byte) j8);
                return;
            }
            while ((j8 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f16416e;
                    int i10 = this.f16419h;
                    this.f16419h = i10 + 1;
                    bArr3[i10] = (byte) ((((int) j8) & 127) | 128);
                    j8 >>>= 7;
                } catch (IndexOutOfBoundsException e8) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f16419h), Integer.valueOf(this.f16418g), 1), e8);
                }
            }
            byte[] bArr4 = this.f16416e;
            int i11 = this.f16419h;
            this.f16419h = i11 + 1;
            bArr4[i11] = (byte) j8;
        }

        public final void V0(byte[] bArr, int i8, int i9) throws d {
            try {
                System.arraycopy(bArr, i8, this.f16416e, this.f16419h, i9);
                this.f16419h += i9;
            } catch (IndexOutOfBoundsException e8) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f16419h), Integer.valueOf(this.f16418g), Integer.valueOf(i9)), e8);
            }
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void W() {
        }

        public final void W0(int i8, J j8) throws d {
            Q0(i8, 2);
            D0(j8);
        }

        @Override // com.google.protobuf.AbstractC1470i, com.google.protobuf.AbstractC1466e
        public final void a(byte[] bArr, int i8, int i9) throws d {
            V0(bArr, i8, i9);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final int c0() {
            return this.f16418g - this.f16419h;
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void d0(byte b8) throws d {
            try {
                byte[] bArr = this.f16416e;
                int i8 = this.f16419h;
                this.f16419h = i8 + 1;
                bArr[i8] = b8;
            } catch (IndexOutOfBoundsException e8) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f16419h), Integer.valueOf(this.f16418g), 1), e8);
            }
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void e0(int i8, boolean z7) throws d {
            Q0(i8, 0);
            d0(z7 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void h0(byte[] bArr, int i8, int i9) throws d {
            S0(i9);
            V0(bArr, i8, i9);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void i0(int i8, AbstractC1467f abstractC1467f) throws d {
            Q0(i8, 2);
            j0(abstractC1467f);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void j0(AbstractC1467f abstractC1467f) throws d {
            S0(abstractC1467f.size());
            abstractC1467f.U(this);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void o0(int i8, int i9) throws d {
            Q0(i8, 5);
            p0(i9);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void p0(int i8) throws d {
            try {
                byte[] bArr = this.f16416e;
                int i9 = this.f16419h;
                int i10 = i9 + 1;
                this.f16419h = i10;
                bArr[i9] = (byte) (i8 & 255);
                int i11 = i9 + 2;
                this.f16419h = i11;
                bArr[i10] = (byte) ((i8 >> 8) & 255);
                int i12 = i9 + 3;
                this.f16419h = i12;
                bArr[i11] = (byte) ((i8 >> 16) & 255);
                this.f16419h = i9 + 4;
                bArr[i12] = (byte) ((i8 >> 24) & 255);
            } catch (IndexOutOfBoundsException e8) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f16419h), Integer.valueOf(this.f16418g), 1), e8);
            }
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void q0(int i8, long j8) throws d {
            Q0(i8, 1);
            r0(j8);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void r0(long j8) throws d {
            try {
                byte[] bArr = this.f16416e;
                int i8 = this.f16419h;
                int i9 = i8 + 1;
                this.f16419h = i9;
                bArr[i8] = (byte) (((int) j8) & 255);
                int i10 = i8 + 2;
                this.f16419h = i10;
                bArr[i9] = (byte) (((int) (j8 >> 8)) & 255);
                int i11 = i8 + 3;
                this.f16419h = i11;
                bArr[i10] = (byte) (((int) (j8 >> 16)) & 255);
                int i12 = i8 + 4;
                this.f16419h = i12;
                bArr[i11] = (byte) (((int) (j8 >> 24)) & 255);
                int i13 = i8 + 5;
                this.f16419h = i13;
                bArr[i12] = (byte) (((int) (j8 >> 32)) & 255);
                int i14 = i8 + 6;
                this.f16419h = i14;
                bArr[i13] = (byte) (((int) (j8 >> 40)) & 255);
                int i15 = i8 + 7;
                this.f16419h = i15;
                bArr[i14] = (byte) (((int) (j8 >> 48)) & 255);
                this.f16419h = i8 + 8;
                bArr[i15] = (byte) (((int) (j8 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e8) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f16419h), Integer.valueOf(this.f16418g), 1), e8);
            }
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void y0(int i8, int i9) throws d {
            Q0(i8, 0);
            z0(i9);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public final void z0(int i8) throws d {
            if (i8 >= 0) {
                S0(i8);
            } else {
                U0(i8);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$d */
    public static class d extends IOException {
        public d(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        public d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$e */
    public static final class e extends b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final OutputStream f16420i;

        public e(OutputStream outputStream, int i8) {
            super(i8);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f16420i = outputStream;
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void C0(int i8, J j8, Y y7) throws IOException {
            Q0(i8, 2);
            g1(j8, y7);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void D0(J j8) throws IOException {
            S0(j8.c());
            j8.h(this);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void E0(int i8, J j8) throws IOException {
            Q0(1, 3);
            R0(2, i8);
            f1(3, j8);
            Q0(1, 4);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void F0(int i8, AbstractC1467f abstractC1467f) throws IOException {
            Q0(1, 3);
            R0(2, i8);
            i0(3, abstractC1467f);
            Q0(1, 4);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void O0(int i8, String str) throws IOException {
            Q0(i8, 2);
            P0(str);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void P0(String str) throws IOException {
            int iG;
            try {
                int length = str.length() * 3;
                int iR = AbstractC1470i.R(length);
                int i8 = iR + length;
                int i9 = this.f16413f;
                if (i8 > i9) {
                    byte[] bArr = new byte[length];
                    int iF = k0.f(str, bArr, 0, length);
                    S0(iF);
                    a(bArr, 0, iF);
                    return;
                }
                if (i8 > i9 - this.f16414g) {
                    c1();
                }
                int iR2 = AbstractC1470i.R(str.length());
                int i10 = this.f16414g;
                try {
                    if (iR2 == iR) {
                        int i11 = i10 + iR2;
                        this.f16414g = i11;
                        int iF2 = k0.f(str, this.f16412e, i11, this.f16413f - i11);
                        this.f16414g = i10;
                        iG = (iF2 - i10) - iR2;
                        a1(iG);
                        this.f16414g = iF2;
                    } else {
                        iG = k0.g(str);
                        a1(iG);
                        this.f16414g = k0.f(str, this.f16412e, this.f16414g, iG);
                    }
                    this.f16415h += iG;
                } catch (k0.d e8) {
                    this.f16415h -= this.f16414g - i10;
                    this.f16414g = i10;
                    throw e8;
                } catch (ArrayIndexOutOfBoundsException e9) {
                    throw new d(e9);
                }
            } catch (k0.d e10) {
                X(str, e10);
            }
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void Q0(int i8, int i9) throws IOException {
            S0(l0.c(i8, i9));
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void R0(int i8, int i9) throws IOException {
            d1(20);
            Z0(i8, 0);
            a1(i9);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void S0(int i8) throws IOException {
            d1(5);
            a1(i8);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void T0(int i8, long j8) throws IOException {
            d1(20);
            Z0(i8, 0);
            b1(j8);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void U0(long j8) throws IOException {
            d1(10);
            b1(j8);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void W() throws IOException {
            if (this.f16414g > 0) {
                c1();
            }
        }

        @Override // com.google.protobuf.AbstractC1470i, com.google.protobuf.AbstractC1466e
        public void a(byte[] bArr, int i8, int i9) throws IOException {
            e1(bArr, i8, i9);
        }

        public final void c1() throws IOException {
            this.f16420i.write(this.f16412e, 0, this.f16414g);
            this.f16414g = 0;
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void d0(byte b8) throws IOException {
            if (this.f16414g == this.f16413f) {
                c1();
            }
            V0(b8);
        }

        public final void d1(int i8) throws IOException {
            if (this.f16413f - this.f16414g < i8) {
                c1();
            }
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void e0(int i8, boolean z7) throws IOException {
            d1(11);
            Z0(i8, 0);
            V0(z7 ? (byte) 1 : (byte) 0);
        }

        public void e1(byte[] bArr, int i8, int i9) throws IOException {
            int i10 = this.f16413f;
            int i11 = this.f16414g;
            if (i10 - i11 >= i9) {
                System.arraycopy(bArr, i8, this.f16412e, i11, i9);
                this.f16414g += i9;
            } else {
                int i12 = i10 - i11;
                System.arraycopy(bArr, i8, this.f16412e, i11, i12);
                int i13 = i8 + i12;
                i9 -= i12;
                this.f16414g = this.f16413f;
                this.f16415h += i12;
                c1();
                if (i9 <= this.f16413f) {
                    System.arraycopy(bArr, i13, this.f16412e, 0, i9);
                    this.f16414g = i9;
                } else {
                    this.f16420i.write(bArr, i13, i9);
                }
            }
            this.f16415h += i9;
        }

        public void f1(int i8, J j8) throws IOException {
            Q0(i8, 2);
            D0(j8);
        }

        public void g1(J j8, Y y7) throws IOException {
            S0(((AbstractC1462a) j8).k(y7));
            y7.h(j8, this.f16410a);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void h0(byte[] bArr, int i8, int i9) throws IOException {
            S0(i9);
            e1(bArr, i8, i9);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void i0(int i8, AbstractC1467f abstractC1467f) throws IOException {
            Q0(i8, 2);
            j0(abstractC1467f);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void j0(AbstractC1467f abstractC1467f) throws IOException {
            S0(abstractC1467f.size());
            abstractC1467f.U(this);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void o0(int i8, int i9) throws IOException {
            d1(14);
            Z0(i8, 5);
            W0(i9);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void p0(int i8) throws IOException {
            d1(4);
            W0(i8);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void q0(int i8, long j8) throws IOException {
            d1(18);
            Z0(i8, 1);
            X0(j8);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void r0(long j8) throws IOException {
            d1(8);
            X0(j8);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void y0(int i8, int i9) throws IOException {
            d1(20);
            Z0(i8, 0);
            Y0(i9);
        }

        @Override // com.google.protobuf.AbstractC1470i
        public void z0(int i8) throws IOException {
            if (i8 >= 0) {
                S0(i8);
            } else {
                U0(i8);
            }
        }
    }

    public AbstractC1470i() {
    }

    public static int A(int i8, J j8, Y y7) {
        return P(i8) + C(j8, y7);
    }

    public static int B(J j8) {
        return z(j8.c());
    }

    public static int C(J j8, Y y7) {
        return z(((AbstractC1462a) j8).k(y7));
    }

    public static int D(int i8) {
        if (i8 > 4096) {
            return 4096;
        }
        return i8;
    }

    public static int E(int i8, AbstractC1467f abstractC1467f) {
        return (P(1) * 2) + Q(2, i8) + g(3, abstractC1467f);
    }

    public static int F(int i8, int i9) {
        return P(i8) + G(i9);
    }

    public static int G(int i8) {
        return 4;
    }

    public static int H(int i8, long j8) {
        return P(i8) + I(j8);
    }

    public static int I(long j8) {
        return 8;
    }

    public static int J(int i8, int i9) {
        return P(i8) + K(i9);
    }

    public static int K(int i8) {
        return R(U(i8));
    }

    public static int L(int i8, long j8) {
        return P(i8) + M(j8);
    }

    public static int M(long j8) {
        return T(V(j8));
    }

    public static int N(int i8, String str) {
        return P(i8) + O(str);
    }

    public static int O(String str) {
        int length;
        try {
            length = k0.g(str);
        } catch (k0.d unused) {
            length = str.getBytes(AbstractC1481u.f16588b).length;
        }
        return z(length);
    }

    public static int P(int i8) {
        return R(l0.c(i8, 0));
    }

    public static int Q(int i8, int i9) {
        return P(i8) + R(i9);
    }

    public static int R(int i8) {
        if ((i8 & (-128)) == 0) {
            return 1;
        }
        if ((i8 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i8) == 0) {
            return 3;
        }
        return (i8 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int S(int i8, long j8) {
        return P(i8) + T(j8);
    }

    public static int T(long j8) {
        int i8;
        if (((-128) & j8) == 0) {
            return 1;
        }
        if (j8 < 0) {
            return 10;
        }
        if (((-34359738368L) & j8) != 0) {
            j8 >>>= 28;
            i8 = 6;
        } else {
            i8 = 2;
        }
        if (((-2097152) & j8) != 0) {
            i8 += 2;
            j8 >>>= 14;
        }
        return (j8 & (-16384)) != 0 ? i8 + 1 : i8;
    }

    public static int U(int i8) {
        return (i8 >> 31) ^ (i8 << 1);
    }

    public static long V(long j8) {
        return (j8 >> 63) ^ (j8 << 1);
    }

    public static AbstractC1470i Z(OutputStream outputStream, int i8) {
        return new e(outputStream, i8);
    }

    public static AbstractC1470i a0(byte[] bArr) {
        return b0(bArr, 0, bArr.length);
    }

    public static AbstractC1470i b0(byte[] bArr, int i8, int i9) {
        return new c(bArr, i8, i9);
    }

    public static int d(int i8, boolean z7) {
        return P(i8) + e(z7);
    }

    public static int e(boolean z7) {
        return 1;
    }

    public static int f(byte[] bArr) {
        return z(bArr.length);
    }

    public static int g(int i8, AbstractC1467f abstractC1467f) {
        return P(i8) + h(abstractC1467f);
    }

    public static int h(AbstractC1467f abstractC1467f) {
        return z(abstractC1467f.size());
    }

    public static int i(int i8, double d8) {
        return P(i8) + j(d8);
    }

    public static int j(double d8) {
        return 8;
    }

    public static int k(int i8, int i9) {
        return P(i8) + l(i9);
    }

    public static int l(int i8) {
        return w(i8);
    }

    public static int m(int i8, int i9) {
        return P(i8) + n(i9);
    }

    public static int n(int i8) {
        return 4;
    }

    public static int o(int i8, long j8) {
        return P(i8) + p(j8);
    }

    public static int p(long j8) {
        return 8;
    }

    public static int q(int i8, float f8) {
        return P(i8) + r(f8);
    }

    public static int r(float f8) {
        return 4;
    }

    public static int s(int i8, J j8, Y y7) {
        return (P(i8) * 2) + u(j8, y7);
    }

    public static int t(J j8) {
        return j8.c();
    }

    public static int u(J j8, Y y7) {
        return ((AbstractC1462a) j8).k(y7);
    }

    public static int v(int i8, int i9) {
        return P(i8) + w(i9);
    }

    public static int w(int i8) {
        if (i8 >= 0) {
            return R(i8);
        }
        return 10;
    }

    public static int x(int i8, long j8) {
        return P(i8) + y(j8);
    }

    public static int y(long j8) {
        return T(j8);
    }

    public static int z(int i8) {
        return R(i8) + i8;
    }

    public final void A0(int i8, long j8) {
        T0(i8, j8);
    }

    public final void B0(long j8) {
        U0(j8);
    }

    public abstract void C0(int i8, J j8, Y y7);

    public abstract void D0(J j8);

    public abstract void E0(int i8, J j8);

    public abstract void F0(int i8, AbstractC1467f abstractC1467f);

    public final void G0(int i8, int i9) {
        o0(i8, i9);
    }

    public final void H0(int i8) {
        p0(i8);
    }

    public final void I0(int i8, long j8) {
        q0(i8, j8);
    }

    public final void J0(long j8) {
        r0(j8);
    }

    public final void K0(int i8, int i9) {
        R0(i8, U(i9));
    }

    public final void L0(int i8) {
        S0(U(i8));
    }

    public final void M0(int i8, long j8) {
        T0(i8, V(j8));
    }

    public final void N0(long j8) {
        U0(V(j8));
    }

    public abstract void O0(int i8, String str);

    public abstract void P0(String str);

    public abstract void Q0(int i8, int i9);

    public abstract void R0(int i8, int i9);

    public abstract void S0(int i8);

    public abstract void T0(int i8, long j8);

    public abstract void U0(long j8);

    public abstract void W();

    public final void X(String str, k0.d dVar) throws d {
        f16408c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(AbstractC1481u.f16588b);
        try {
            S0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e8) {
            throw new d(e8);
        }
    }

    public boolean Y() {
        return this.f16411b;
    }

    @Override // com.google.protobuf.AbstractC1466e
    public abstract void a(byte[] bArr, int i8, int i9);

    public final void c() {
        if (c0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract int c0();

    public abstract void d0(byte b8);

    public abstract void e0(int i8, boolean z7);

    public final void f0(boolean z7) {
        d0(z7 ? (byte) 1 : (byte) 0);
    }

    public final void g0(byte[] bArr) {
        h0(bArr, 0, bArr.length);
    }

    public abstract void h0(byte[] bArr, int i8, int i9);

    public abstract void i0(int i8, AbstractC1467f abstractC1467f);

    public abstract void j0(AbstractC1467f abstractC1467f);

    public final void k0(int i8, double d8) {
        q0(i8, Double.doubleToRawLongBits(d8));
    }

    public final void l0(double d8) {
        r0(Double.doubleToRawLongBits(d8));
    }

    public final void m0(int i8, int i9) {
        y0(i8, i9);
    }

    public final void n0(int i8) {
        z0(i8);
    }

    public abstract void o0(int i8, int i9);

    public abstract void p0(int i8);

    public abstract void q0(int i8, long j8);

    public abstract void r0(long j8);

    public final void s0(int i8, float f8) {
        o0(i8, Float.floatToRawIntBits(f8));
    }

    public final void t0(float f8) {
        p0(Float.floatToRawIntBits(f8));
    }

    public final void u0(int i8, J j8) {
        Q0(i8, 3);
        w0(j8);
        Q0(i8, 4);
    }

    public final void v0(int i8, J j8, Y y7) {
        Q0(i8, 3);
        x0(j8, y7);
        Q0(i8, 4);
    }

    public final void w0(J j8) {
        j8.h(this);
    }

    public final void x0(J j8, Y y7) {
        y7.h(j8, this.f16410a);
    }

    public abstract void y0(int i8, int i9);

    public abstract void z0(int i8);
}
