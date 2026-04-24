package com.google.protobuf;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.protobuf.B0;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1065l extends AbstractC1061h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f11100c = Logger.getLogger(AbstractC1065l.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f11101d = A0.I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1066m f11102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11103b;

    /* JADX INFO: renamed from: com.google.protobuf.l$b */
    public static abstract class b extends AbstractC1065l {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f11104e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f11105f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11106g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11107h;

        public b(int i4) {
            super();
            if (i4 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i4, 20)];
            this.f11104e = bArr;
            this.f11105f = bArr.length;
        }

        public final void Y0(byte b4) {
            byte[] bArr = this.f11104e;
            int i4 = this.f11106g;
            this.f11106g = i4 + 1;
            bArr[i4] = b4;
            this.f11107h++;
        }

        public final void Z0(int i4) {
            byte[] bArr = this.f11104e;
            int i5 = this.f11106g;
            int i6 = i5 + 1;
            this.f11106g = i6;
            bArr[i5] = (byte) (i4 & 255);
            int i7 = i5 + 2;
            this.f11106g = i7;
            bArr[i6] = (byte) ((i4 >> 8) & 255);
            int i8 = i5 + 3;
            this.f11106g = i8;
            bArr[i7] = (byte) ((i4 >> 16) & 255);
            this.f11106g = i5 + 4;
            bArr[i8] = (byte) ((i4 >> 24) & 255);
            this.f11107h += 4;
        }

        public final void a1(long j4) {
            byte[] bArr = this.f11104e;
            int i4 = this.f11106g;
            int i5 = i4 + 1;
            this.f11106g = i5;
            bArr[i4] = (byte) (j4 & 255);
            int i6 = i4 + 2;
            this.f11106g = i6;
            bArr[i5] = (byte) ((j4 >> 8) & 255);
            int i7 = i4 + 3;
            this.f11106g = i7;
            bArr[i6] = (byte) ((j4 >> 16) & 255);
            int i8 = i4 + 4;
            this.f11106g = i8;
            bArr[i7] = (byte) (255 & (j4 >> 24));
            int i9 = i4 + 5;
            this.f11106g = i9;
            bArr[i8] = (byte) (((int) (j4 >> 32)) & 255);
            int i10 = i4 + 6;
            this.f11106g = i10;
            bArr[i9] = (byte) (((int) (j4 >> 40)) & 255);
            int i11 = i4 + 7;
            this.f11106g = i11;
            bArr[i10] = (byte) (((int) (j4 >> 48)) & 255);
            this.f11106g = i4 + 8;
            bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
            this.f11107h += 8;
        }

        public final void b1(int i4) {
            if (i4 >= 0) {
                d1(i4);
            } else {
                e1(i4);
            }
        }

        public final void c1(int i4, int i5) {
            d1(C0.c(i4, i5));
        }

        public final void d1(int i4) {
            if (!AbstractC1065l.f11101d) {
                while ((i4 & (-128)) != 0) {
                    byte[] bArr = this.f11104e;
                    int i5 = this.f11106g;
                    this.f11106g = i5 + 1;
                    bArr[i5] = (byte) ((i4 & 127) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                    this.f11107h++;
                    i4 >>>= 7;
                }
                byte[] bArr2 = this.f11104e;
                int i6 = this.f11106g;
                this.f11106g = i6 + 1;
                bArr2[i6] = (byte) i4;
                this.f11107h++;
                return;
            }
            long j4 = this.f11106g;
            while ((i4 & (-128)) != 0) {
                byte[] bArr3 = this.f11104e;
                int i7 = this.f11106g;
                this.f11106g = i7 + 1;
                A0.O(bArr3, i7, (byte) ((i4 & 127) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                i4 >>>= 7;
            }
            byte[] bArr4 = this.f11104e;
            int i8 = this.f11106g;
            this.f11106g = i8 + 1;
            A0.O(bArr4, i8, (byte) i4);
            this.f11107h += (int) (((long) this.f11106g) - j4);
        }

        public final void e1(long j4) {
            if (!AbstractC1065l.f11101d) {
                while ((j4 & (-128)) != 0) {
                    byte[] bArr = this.f11104e;
                    int i4 = this.f11106g;
                    this.f11106g = i4 + 1;
                    bArr[i4] = (byte) ((((int) j4) & 127) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                    this.f11107h++;
                    j4 >>>= 7;
                }
                byte[] bArr2 = this.f11104e;
                int i5 = this.f11106g;
                this.f11106g = i5 + 1;
                bArr2[i5] = (byte) j4;
                this.f11107h++;
                return;
            }
            long j5 = this.f11106g;
            while ((j4 & (-128)) != 0) {
                byte[] bArr3 = this.f11104e;
                int i6 = this.f11106g;
                this.f11106g = i6 + 1;
                A0.O(bArr3, i6, (byte) ((((int) j4) & 127) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                j4 >>>= 7;
            }
            byte[] bArr4 = this.f11104e;
            int i7 = this.f11106g;
            this.f11106g = i7 + 1;
            A0.O(bArr4, i7, (byte) j4);
            this.f11107h += (int) (((long) this.f11106g) - j5);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final int f0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.l$c */
    public static class c extends AbstractC1065l {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f11108e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f11109f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f11110g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11111h;

        public c(byte[] bArr, int i4, int i5) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i6 = i4 + i5;
            if ((i4 | i5 | (bArr.length - i6)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)));
            }
            this.f11108e = bArr;
            this.f11109f = i4;
            this.f11111h = i4;
            this.f11110g = i6;
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void B0(int i4, int i5) throws d {
            T0(i4, 0);
            C0(i5);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void C0(int i4) throws d {
            if (i4 >= 0) {
                V0(i4);
            } else {
                X0(i4);
            }
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void F0(int i4, W w4, o0 o0Var) throws d {
            T0(i4, 2);
            V0(((AbstractC1050a) w4).getSerializedSize(o0Var));
            o0Var.h(w4, this.f11102a);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void G0(W w4) throws d {
            V0(w4.getSerializedSize());
            w4.writeTo(this);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void H0(int i4, W w4) throws d {
            T0(1, 3);
            U0(2, i4);
            a1(3, w4);
            T0(1, 4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void I0(int i4, AbstractC1062i abstractC1062i) throws d {
            T0(1, 3);
            U0(2, i4);
            l0(3, abstractC1062i);
            T0(1, 4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void R0(int i4, String str) throws d {
            T0(i4, 2);
            S0(str);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void S0(String str) throws d {
            int i4 = this.f11111h;
            try {
                int iU = AbstractC1065l.U(str.length() * 3);
                int iU2 = AbstractC1065l.U(str.length());
                if (iU2 != iU) {
                    V0(B0.j(str));
                    this.f11111h = B0.i(str, this.f11108e, this.f11111h, f0());
                    return;
                }
                int i5 = i4 + iU2;
                this.f11111h = i5;
                int i6 = B0.i(str, this.f11108e, i5, f0());
                this.f11111h = i4;
                V0((i6 - i4) - iU2);
                this.f11111h = i6;
            } catch (B0.d e4) {
                this.f11111h = i4;
                a0(str, e4);
            } catch (IndexOutOfBoundsException e5) {
                throw new d(e5);
            }
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void T0(int i4, int i5) throws d {
            V0(C0.c(i4, i5));
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void U0(int i4, int i5) throws d {
            T0(i4, 0);
            V0(i5);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void V0(int i4) throws d {
            while ((i4 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f11108e;
                    int i5 = this.f11111h;
                    this.f11111h = i5 + 1;
                    bArr[i5] = (byte) ((i4 & 127) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                    i4 >>>= 7;
                } catch (IndexOutOfBoundsException e4) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f11111h), Integer.valueOf(this.f11110g), 1), e4);
                }
            }
            byte[] bArr2 = this.f11108e;
            int i6 = this.f11111h;
            this.f11111h = i6 + 1;
            bArr2[i6] = (byte) i4;
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void W0(int i4, long j4) throws d {
            T0(i4, 0);
            X0(j4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void X0(long j4) throws d {
            if (AbstractC1065l.f11101d && f0() >= 10) {
                while ((j4 & (-128)) != 0) {
                    byte[] bArr = this.f11108e;
                    int i4 = this.f11111h;
                    this.f11111h = i4 + 1;
                    A0.O(bArr, i4, (byte) ((((int) j4) & 127) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                    j4 >>>= 7;
                }
                byte[] bArr2 = this.f11108e;
                int i5 = this.f11111h;
                this.f11111h = i5 + 1;
                A0.O(bArr2, i5, (byte) j4);
                return;
            }
            while ((j4 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f11108e;
                    int i6 = this.f11111h;
                    this.f11111h = i6 + 1;
                    bArr3[i6] = (byte) ((((int) j4) & 127) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                    j4 >>>= 7;
                } catch (IndexOutOfBoundsException e4) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f11111h), Integer.valueOf(this.f11110g), 1), e4);
                }
            }
            byte[] bArr4 = this.f11108e;
            int i7 = this.f11111h;
            this.f11111h = i7 + 1;
            bArr4[i7] = (byte) j4;
        }

        public final void Y0(ByteBuffer byteBuffer) throws d {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f11108e, this.f11111h, iRemaining);
                this.f11111h += iRemaining;
            } catch (IndexOutOfBoundsException e4) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f11111h), Integer.valueOf(this.f11110g), Integer.valueOf(iRemaining)), e4);
            }
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void Z() {
        }

        public final void Z0(byte[] bArr, int i4, int i5) throws d {
            try {
                System.arraycopy(bArr, i4, this.f11108e, this.f11111h, i5);
                this.f11111h += i5;
            } catch (IndexOutOfBoundsException e4) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f11111h), Integer.valueOf(this.f11110g), Integer.valueOf(i5)), e4);
            }
        }

        @Override // com.google.protobuf.AbstractC1061h
        public final void a(ByteBuffer byteBuffer) throws d {
            Y0(byteBuffer);
        }

        public final void a1(int i4, W w4) throws d {
            T0(i4, 2);
            G0(w4);
        }

        @Override // com.google.protobuf.AbstractC1065l, com.google.protobuf.AbstractC1061h
        public final void b(byte[] bArr, int i4, int i5) throws d {
            Z0(bArr, i4, i5);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final int f0() {
            return this.f11110g - this.f11111h;
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void g0(byte b4) throws d {
            try {
                byte[] bArr = this.f11108e;
                int i4 = this.f11111h;
                this.f11111h = i4 + 1;
                bArr[i4] = b4;
            } catch (IndexOutOfBoundsException e4) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f11111h), Integer.valueOf(this.f11110g), 1), e4);
            }
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void h0(int i4, boolean z4) throws d {
            T0(i4, 0);
            g0(z4 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void k0(byte[] bArr, int i4, int i5) throws d {
            V0(i5);
            Z0(bArr, i4, i5);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void l0(int i4, AbstractC1062i abstractC1062i) throws d {
            T0(i4, 2);
            m0(abstractC1062i);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void m0(AbstractC1062i abstractC1062i) throws d {
            V0(abstractC1062i.size());
            abstractC1062i.P(this);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void r0(int i4, int i5) throws d {
            T0(i4, 5);
            s0(i5);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void s0(int i4) throws d {
            try {
                byte[] bArr = this.f11108e;
                int i5 = this.f11111h;
                int i6 = i5 + 1;
                this.f11111h = i6;
                bArr[i5] = (byte) (i4 & 255);
                int i7 = i5 + 2;
                this.f11111h = i7;
                bArr[i6] = (byte) ((i4 >> 8) & 255);
                int i8 = i5 + 3;
                this.f11111h = i8;
                bArr[i7] = (byte) ((i4 >> 16) & 255);
                this.f11111h = i5 + 4;
                bArr[i8] = (byte) ((i4 >> 24) & 255);
            } catch (IndexOutOfBoundsException e4) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f11111h), Integer.valueOf(this.f11110g), 1), e4);
            }
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void t0(int i4, long j4) throws d {
            T0(i4, 1);
            u0(j4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public final void u0(long j4) throws d {
            try {
                byte[] bArr = this.f11108e;
                int i4 = this.f11111h;
                int i5 = i4 + 1;
                this.f11111h = i5;
                bArr[i4] = (byte) (((int) j4) & 255);
                int i6 = i4 + 2;
                this.f11111h = i6;
                bArr[i5] = (byte) (((int) (j4 >> 8)) & 255);
                int i7 = i4 + 3;
                this.f11111h = i7;
                bArr[i6] = (byte) (((int) (j4 >> 16)) & 255);
                int i8 = i4 + 4;
                this.f11111h = i8;
                bArr[i7] = (byte) (((int) (j4 >> 24)) & 255);
                int i9 = i4 + 5;
                this.f11111h = i9;
                bArr[i8] = (byte) (((int) (j4 >> 32)) & 255);
                int i10 = i4 + 6;
                this.f11111h = i10;
                bArr[i9] = (byte) (((int) (j4 >> 40)) & 255);
                int i11 = i4 + 7;
                this.f11111h = i11;
                bArr[i10] = (byte) (((int) (j4 >> 48)) & 255);
                this.f11111h = i4 + 8;
                bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e4) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f11111h), Integer.valueOf(this.f11110g), 1), e4);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.l$d */
    public static class d extends IOException {
        public d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        public d(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.l$e */
    public static final class e extends b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final OutputStream f11112i;

        public e(OutputStream outputStream, int i4) {
            super(i4);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f11112i = outputStream;
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void B0(int i4, int i5) throws IOException {
            g1(20);
            c1(i4, 0);
            b1(i5);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void C0(int i4) throws IOException {
            if (i4 >= 0) {
                V0(i4);
            } else {
                X0(i4);
            }
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void F0(int i4, W w4, o0 o0Var) throws IOException {
            T0(i4, 2);
            k1(w4, o0Var);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void G0(W w4) throws IOException {
            V0(w4.getSerializedSize());
            w4.writeTo(this);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void H0(int i4, W w4) throws IOException {
            T0(1, 3);
            U0(2, i4);
            j1(3, w4);
            T0(1, 4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void I0(int i4, AbstractC1062i abstractC1062i) throws IOException {
            T0(1, 3);
            U0(2, i4);
            l0(3, abstractC1062i);
            T0(1, 4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void R0(int i4, String str) throws IOException {
            T0(i4, 2);
            S0(str);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void S0(String str) throws IOException {
            int iJ;
            try {
                int length = str.length() * 3;
                int iU = AbstractC1065l.U(length);
                int i4 = iU + length;
                int i5 = this.f11105f;
                if (i4 > i5) {
                    byte[] bArr = new byte[length];
                    int i6 = B0.i(str, bArr, 0, length);
                    V0(i6);
                    b(bArr, 0, i6);
                    return;
                }
                if (i4 > i5 - this.f11106g) {
                    f1();
                }
                int iU2 = AbstractC1065l.U(str.length());
                int i7 = this.f11106g;
                try {
                    if (iU2 == iU) {
                        int i8 = i7 + iU2;
                        this.f11106g = i8;
                        int i9 = B0.i(str, this.f11104e, i8, this.f11105f - i8);
                        this.f11106g = i7;
                        iJ = (i9 - i7) - iU2;
                        d1(iJ);
                        this.f11106g = i9;
                    } else {
                        iJ = B0.j(str);
                        d1(iJ);
                        this.f11106g = B0.i(str, this.f11104e, this.f11106g, iJ);
                    }
                    this.f11107h += iJ;
                } catch (B0.d e4) {
                    this.f11107h -= this.f11106g - i7;
                    this.f11106g = i7;
                    throw e4;
                } catch (ArrayIndexOutOfBoundsException e5) {
                    throw new d(e5);
                }
            } catch (B0.d e6) {
                a0(str, e6);
            }
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void T0(int i4, int i5) throws IOException {
            V0(C0.c(i4, i5));
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void U0(int i4, int i5) throws IOException {
            g1(20);
            c1(i4, 0);
            d1(i5);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void V0(int i4) throws IOException {
            g1(5);
            d1(i4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void W0(int i4, long j4) throws IOException {
            g1(20);
            c1(i4, 0);
            e1(j4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void X0(long j4) throws IOException {
            g1(10);
            e1(j4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void Z() throws IOException {
            if (this.f11106g > 0) {
                f1();
            }
        }

        @Override // com.google.protobuf.AbstractC1061h
        public void a(ByteBuffer byteBuffer) throws IOException {
            h1(byteBuffer);
        }

        @Override // com.google.protobuf.AbstractC1065l, com.google.protobuf.AbstractC1061h
        public void b(byte[] bArr, int i4, int i5) throws IOException {
            i1(bArr, i4, i5);
        }

        public final void f1() throws IOException {
            this.f11112i.write(this.f11104e, 0, this.f11106g);
            this.f11106g = 0;
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void g0(byte b4) throws IOException {
            if (this.f11106g == this.f11105f) {
                f1();
            }
            Y0(b4);
        }

        public final void g1(int i4) throws IOException {
            if (this.f11105f - this.f11106g < i4) {
                f1();
            }
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void h0(int i4, boolean z4) throws IOException {
            g1(11);
            c1(i4, 0);
            Y0(z4 ? (byte) 1 : (byte) 0);
        }

        public void h1(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            int i4 = this.f11105f;
            int i5 = this.f11106g;
            if (i4 - i5 >= iRemaining) {
                byteBuffer.get(this.f11104e, i5, iRemaining);
                this.f11106g += iRemaining;
                this.f11107h += iRemaining;
                return;
            }
            int i6 = i4 - i5;
            byteBuffer.get(this.f11104e, i5, i6);
            int i7 = iRemaining - i6;
            this.f11106g = this.f11105f;
            this.f11107h += i6;
            f1();
            while (true) {
                int i8 = this.f11105f;
                if (i7 <= i8) {
                    byteBuffer.get(this.f11104e, 0, i7);
                    this.f11106g = i7;
                    this.f11107h += i7;
                    return;
                } else {
                    byteBuffer.get(this.f11104e, 0, i8);
                    this.f11112i.write(this.f11104e, 0, this.f11105f);
                    int i9 = this.f11105f;
                    i7 -= i9;
                    this.f11107h += i9;
                }
            }
        }

        public void i1(byte[] bArr, int i4, int i5) throws IOException {
            int i6 = this.f11105f;
            int i7 = this.f11106g;
            if (i6 - i7 >= i5) {
                System.arraycopy(bArr, i4, this.f11104e, i7, i5);
                this.f11106g += i5;
                this.f11107h += i5;
                return;
            }
            int i8 = i6 - i7;
            System.arraycopy(bArr, i4, this.f11104e, i7, i8);
            int i9 = i4 + i8;
            int i10 = i5 - i8;
            this.f11106g = this.f11105f;
            this.f11107h += i8;
            f1();
            if (i10 <= this.f11105f) {
                System.arraycopy(bArr, i9, this.f11104e, 0, i10);
                this.f11106g = i10;
            } else {
                this.f11112i.write(bArr, i9, i10);
            }
            this.f11107h += i10;
        }

        public void j1(int i4, W w4) throws IOException {
            T0(i4, 2);
            G0(w4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void k0(byte[] bArr, int i4, int i5) throws IOException {
            V0(i5);
            i1(bArr, i4, i5);
        }

        public void k1(W w4, o0 o0Var) throws IOException {
            V0(((AbstractC1050a) w4).getSerializedSize(o0Var));
            o0Var.h(w4, this.f11102a);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void l0(int i4, AbstractC1062i abstractC1062i) throws IOException {
            T0(i4, 2);
            m0(abstractC1062i);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void m0(AbstractC1062i abstractC1062i) throws IOException {
            V0(abstractC1062i.size());
            abstractC1062i.P(this);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void r0(int i4, int i5) throws IOException {
            g1(14);
            c1(i4, 5);
            Z0(i5);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void s0(int i4) throws IOException {
            g1(4);
            Z0(i4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void t0(int i4, long j4) throws IOException {
            g1(18);
            c1(i4, 1);
            a1(j4);
        }

        @Override // com.google.protobuf.AbstractC1065l
        public void u0(long j4) throws IOException {
            g1(8);
            a1(j4);
        }
    }

    public static int A(int i4) {
        return U(i4) + i4;
    }

    public static int B(int i4, W w4) {
        return (S(1) * 2) + T(2, i4) + C(3, w4);
    }

    public static int C(int i4, W w4) {
        return S(i4) + E(w4);
    }

    public static int D(int i4, W w4, o0 o0Var) {
        return S(i4) + F(w4, o0Var);
    }

    public static int E(W w4) {
        return A(w4.getSerializedSize());
    }

    public static int F(W w4, o0 o0Var) {
        return A(((AbstractC1050a) w4).getSerializedSize(o0Var));
    }

    public static int G(int i4) {
        if (i4 > 4096) {
            return 4096;
        }
        return i4;
    }

    public static int H(int i4, AbstractC1062i abstractC1062i) {
        return (S(1) * 2) + T(2, i4) + h(3, abstractC1062i);
    }

    public static int I(int i4, int i5) {
        return S(i4) + J(i5);
    }

    public static int J(int i4) {
        return 4;
    }

    public static int K(int i4, long j4) {
        return S(i4) + L(j4);
    }

    public static int L(long j4) {
        return 8;
    }

    public static int M(int i4, int i5) {
        return S(i4) + N(i5);
    }

    public static int N(int i4) {
        return U(X(i4));
    }

    public static int O(int i4, long j4) {
        return S(i4) + P(j4);
    }

    public static int P(long j4) {
        return W(Y(j4));
    }

    public static int Q(int i4, String str) {
        return S(i4) + R(str);
    }

    public static int R(String str) {
        int length;
        try {
            length = B0.j(str);
        } catch (B0.d unused) {
            length = str.getBytes(C.f10882b).length;
        }
        return A(length);
    }

    public static int S(int i4) {
        return U(C0.c(i4, 0));
    }

    public static int T(int i4, int i5) {
        return S(i4) + U(i5);
    }

    public static int U(int i4) {
        if ((i4 & (-128)) == 0) {
            return 1;
        }
        if ((i4 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i4) == 0) {
            return 3;
        }
        return (i4 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int V(int i4, long j4) {
        return S(i4) + W(j4);
    }

    public static int W(long j4) {
        int i4;
        if (((-128) & j4) == 0) {
            return 1;
        }
        if (j4 < 0) {
            return 10;
        }
        if (((-34359738368L) & j4) != 0) {
            j4 >>>= 28;
            i4 = 6;
        } else {
            i4 = 2;
        }
        if (((-2097152) & j4) != 0) {
            i4 += 2;
            j4 >>>= 14;
        }
        return (j4 & (-16384)) != 0 ? i4 + 1 : i4;
    }

    public static int X(int i4) {
        return (i4 >> 31) ^ (i4 << 1);
    }

    public static long Y(long j4) {
        return (j4 >> 63) ^ (j4 << 1);
    }

    public static AbstractC1065l c0(OutputStream outputStream, int i4) {
        return new e(outputStream, i4);
    }

    public static AbstractC1065l d0(byte[] bArr) {
        return e0(bArr, 0, bArr.length);
    }

    public static int e(int i4, boolean z4) {
        return S(i4) + f(z4);
    }

    public static AbstractC1065l e0(byte[] bArr, int i4, int i5) {
        return new c(bArr, i4, i5);
    }

    public static int f(boolean z4) {
        return 1;
    }

    public static int g(byte[] bArr) {
        return A(bArr.length);
    }

    public static int h(int i4, AbstractC1062i abstractC1062i) {
        return S(i4) + i(abstractC1062i);
    }

    public static int i(AbstractC1062i abstractC1062i) {
        return A(abstractC1062i.size());
    }

    public static int j(int i4, double d4) {
        return S(i4) + k(d4);
    }

    public static int k(double d4) {
        return 8;
    }

    public static int l(int i4, int i5) {
        return S(i4) + m(i5);
    }

    public static int m(int i4) {
        return x(i4);
    }

    public static int n(int i4, int i5) {
        return S(i4) + o(i5);
    }

    public static int o(int i4) {
        return 4;
    }

    public static int p(int i4, long j4) {
        return S(i4) + q(j4);
    }

    public static int q(long j4) {
        return 8;
    }

    public static int r(int i4, float f4) {
        return S(i4) + s(f4);
    }

    public static int s(float f4) {
        return 4;
    }

    public static int t(int i4, W w4, o0 o0Var) {
        return (S(i4) * 2) + v(w4, o0Var);
    }

    public static int u(W w4) {
        return w4.getSerializedSize();
    }

    public static int v(W w4, o0 o0Var) {
        return ((AbstractC1050a) w4).getSerializedSize(o0Var);
    }

    public static int w(int i4, int i5) {
        return S(i4) + x(i5);
    }

    public static int x(int i4) {
        if (i4 >= 0) {
            return U(i4);
        }
        return 10;
    }

    public static int y(int i4, long j4) {
        return S(i4) + z(j4);
    }

    public static int z(long j4) {
        return W(j4);
    }

    public final void A0(W w4, o0 o0Var) {
        o0Var.h(w4, this.f11102a);
    }

    public abstract void B0(int i4, int i5);

    public abstract void C0(int i4);

    public final void D0(int i4, long j4) {
        W0(i4, j4);
    }

    public final void E0(long j4) {
        X0(j4);
    }

    public abstract void F0(int i4, W w4, o0 o0Var);

    public abstract void G0(W w4);

    public abstract void H0(int i4, W w4);

    public abstract void I0(int i4, AbstractC1062i abstractC1062i);

    public final void J0(int i4, int i5) {
        r0(i4, i5);
    }

    public final void K0(int i4) {
        s0(i4);
    }

    public final void L0(int i4, long j4) {
        t0(i4, j4);
    }

    public final void M0(long j4) {
        u0(j4);
    }

    public final void N0(int i4, int i5) {
        U0(i4, X(i5));
    }

    public final void O0(int i4) {
        V0(X(i4));
    }

    public final void P0(int i4, long j4) {
        W0(i4, Y(j4));
    }

    public final void Q0(long j4) {
        X0(Y(j4));
    }

    public abstract void R0(int i4, String str);

    public abstract void S0(String str);

    public abstract void T0(int i4, int i5);

    public abstract void U0(int i4, int i5);

    public abstract void V0(int i4);

    public abstract void W0(int i4, long j4);

    public abstract void X0(long j4);

    public abstract void Z();

    public final void a0(String str, B0.d dVar) throws d {
        f11100c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(C.f10882b);
        try {
            V0(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e4) {
            throw new d(e4);
        }
    }

    @Override // com.google.protobuf.AbstractC1061h
    public abstract void b(byte[] bArr, int i4, int i5);

    public boolean b0() {
        return this.f11103b;
    }

    public final void d() {
        if (f0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract int f0();

    public abstract void g0(byte b4);

    public abstract void h0(int i4, boolean z4);

    public final void i0(boolean z4) {
        g0(z4 ? (byte) 1 : (byte) 0);
    }

    public final void j0(byte[] bArr) {
        k0(bArr, 0, bArr.length);
    }

    public abstract void k0(byte[] bArr, int i4, int i5);

    public abstract void l0(int i4, AbstractC1062i abstractC1062i);

    public abstract void m0(AbstractC1062i abstractC1062i);

    public final void n0(int i4, double d4) {
        t0(i4, Double.doubleToRawLongBits(d4));
    }

    public final void o0(double d4) {
        u0(Double.doubleToRawLongBits(d4));
    }

    public final void p0(int i4, int i5) {
        B0(i4, i5);
    }

    public final void q0(int i4) {
        C0(i4);
    }

    public abstract void r0(int i4, int i5);

    public abstract void s0(int i4);

    public abstract void t0(int i4, long j4);

    public abstract void u0(long j4);

    public final void v0(int i4, float f4) {
        r0(i4, Float.floatToRawIntBits(f4));
    }

    public final void w0(float f4) {
        s0(Float.floatToRawIntBits(f4));
    }

    public final void x0(int i4, W w4) {
        T0(i4, 3);
        z0(w4);
        T0(i4, 4);
    }

    public final void y0(int i4, W w4, o0 o0Var) {
        T0(i4, 3);
        A0(w4, o0Var);
        T0(i4, 4);
    }

    public final void z0(W w4) {
        w4.writeTo(this);
    }

    public AbstractC1065l() {
    }
}
