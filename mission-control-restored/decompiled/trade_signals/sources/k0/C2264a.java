package k0;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import io.flutter.embedding.android.KeyboardMap;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import k0.b;

/* JADX INFO: renamed from: k0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2264a {

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static SimpleDateFormat f20260T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static SimpleDateFormat f20261U;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static final d[] f20265Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static final d[] f20266Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final d[] f20267a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final d[] f20268b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final d[] f20269c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final d f20270d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final d[] f20271e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final d[] f20272f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final d[] f20273g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final d[] f20274h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final d[][] f20275i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final d[] f20276j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final HashMap[] f20277k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final HashMap[] f20278l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final HashSet f20279m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final HashMap f20280n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final Charset f20281o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final byte[] f20282p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final byte[] f20283q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final Pattern f20284r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final Pattern f20285s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final Pattern f20286t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final Pattern f20288u0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileDescriptor f20295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AssetManager.AssetInputStream f20296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f20298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap[] f20299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set f20300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ByteOrder f20301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f20302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f20303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f20304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20305l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f20306m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f20307n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f20308o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f20309p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20310q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20311r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f20312s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f20313t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f20287u = Log.isLoggable("ExifInterface", 3);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final List f20289v = Arrays.asList(1, 6, 3, 8);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final List f20290w = Arrays.asList(2, 7, 4, 5);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f20291x = {8, 8, 8};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f20292y = {4};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f20293z = {8};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final byte[] f20241A = {-1, -40, -1};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final byte[] f20242B = {102, 116, 121, 112};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final byte[] f20243C = {109, 105, 102, 49};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final byte[] f20244D = {104, 101, 105, 99};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final byte[] f20245E = {79, 76, 89, 77, 80, 0};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final byte[] f20246F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final byte[] f20247G = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final byte[] f20248H = {101, 88, 73, 102};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final byte[] f20249I = {73, 72, 68, 82};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final byte[] f20250J = {73, 69, 78, 68};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final byte[] f20251K = {82, 73, 70, 70};

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final byte[] f20252L = {87, 69, 66, 80};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final byte[] f20253M = {69, 88, 73, 70};

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final byte[] f20254N = {-99, 1, 42};

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final byte[] f20255O = "VP8X".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final byte[] f20256P = "VP8L".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final byte[] f20257Q = "VP8 ".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final byte[] f20258R = "ANIM".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final byte[] f20259S = "ANMF".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final String[] f20262V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final int[] f20263W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static final byte[] f20264X = {65, 83, 67, 73, 73, 0, 0, 0};

    /* JADX INFO: renamed from: k0.a$b */
    public static class b extends InputStream implements DataInput {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final ByteOrder f20317e = ByteOrder.LITTLE_ENDIAN;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final ByteOrder f20318f = ByteOrder.BIG_ENDIAN;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataInputStream f20319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteOrder f20320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20321c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f20322d;

        public b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f20321c;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f20319a.available();
        }

        public long c() {
            return ((long) readInt()) & KeyboardMap.kValueMask;
        }

        public void e(ByteOrder byteOrder) {
            this.f20320b = byteOrder;
        }

        public void f(int i8) throws IOException {
            int i9 = 0;
            while (i9 < i8) {
                int i10 = i8 - i9;
                int iSkip = (int) this.f20319a.skip(i10);
                if (iSkip <= 0) {
                    if (this.f20322d == null) {
                        this.f20322d = new byte[8192];
                    }
                    iSkip = this.f20319a.read(this.f20322d, 0, Math.min(8192, i10));
                    if (iSkip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i8 + " bytes.");
                    }
                }
                i9 += iSkip;
            }
            this.f20321c += i9;
        }

        @Override // java.io.InputStream
        public void mark(int i8) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() {
            this.f20321c++;
            return this.f20319a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f20321c++;
            return this.f20319a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.f20321c++;
            int i8 = this.f20319a.read();
            if (i8 >= 0) {
                return (byte) i8;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f20321c += 2;
            return this.f20319a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f20321c += bArr.length;
            this.f20319a.readFully(bArr);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f20321c += 4;
            int i8 = this.f20319a.read();
            int i9 = this.f20319a.read();
            int i10 = this.f20319a.read();
            int i11 = this.f20319a.read();
            if ((i8 | i9 | i10 | i11) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f20320b;
            if (byteOrder == f20317e) {
                return (i11 << 24) + (i10 << 16) + (i9 << 8) + i8;
            }
            if (byteOrder == f20318f) {
                return (i8 << 24) + (i9 << 16) + (i10 << 8) + i11;
            }
            throw new IOException("Invalid byte order: " + this.f20320b);
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f20321c += 8;
            int i8 = this.f20319a.read();
            int i9 = this.f20319a.read();
            int i10 = this.f20319a.read();
            int i11 = this.f20319a.read();
            int i12 = this.f20319a.read();
            int i13 = this.f20319a.read();
            int i14 = this.f20319a.read();
            int i15 = this.f20319a.read();
            if ((i8 | i9 | i10 | i11 | i12 | i13 | i14 | i15) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f20320b;
            if (byteOrder == f20317e) {
                return (((long) i15) << 56) + (((long) i14) << 48) + (((long) i13) << 40) + (((long) i12) << 32) + (((long) i11) << 24) + (((long) i10) << 16) + (((long) i9) << 8) + ((long) i8);
            }
            if (byteOrder == f20318f) {
                return (((long) i8) << 56) + (((long) i9) << 48) + (((long) i10) << 40) + (((long) i11) << 32) + (((long) i12) << 24) + (((long) i13) << 16) + (((long) i14) << 8) + ((long) i15);
            }
            throw new IOException("Invalid byte order: " + this.f20320b);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.f20321c += 2;
            int i8 = this.f20319a.read();
            int i9 = this.f20319a.read();
            if ((i8 | i9) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f20320b;
            if (byteOrder == f20317e) {
                return (short) ((i9 << 8) + i8);
            }
            if (byteOrder == f20318f) {
                return (short) ((i8 << 8) + i9);
            }
            throw new IOException("Invalid byte order: " + this.f20320b);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f20321c += 2;
            return this.f20319a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f20321c++;
            return this.f20319a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f20321c += 2;
            int i8 = this.f20319a.read();
            int i9 = this.f20319a.read();
            if ((i8 | i9) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f20320b;
            if (byteOrder == f20317e) {
                return (i9 << 8) + i8;
            }
            if (byteOrder == f20318f) {
                return (i8 << 8) + i9;
            }
            throw new IOException("Invalid byte order: " + this.f20320b);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i8) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public b(InputStream inputStream, ByteOrder byteOrder) {
            this.f20320b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f20319a = dataInputStream;
            dataInputStream.mark(0);
            this.f20321c = 0;
            this.f20320b = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i8, int i9) throws IOException {
            int i10 = this.f20319a.read(bArr, i8, i9);
            this.f20321c += i10;
            return i10;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i8, int i9) throws IOException {
            this.f20321c += i9;
            this.f20319a.readFully(bArr, i8, i9);
        }

        public b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }
    }

    /* JADX INFO: renamed from: k0.a$c */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f20324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f20325c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f20326d;

        public c(int i8, int i9, long j8, byte[] bArr) {
            this.f20323a = i8;
            this.f20324b = i9;
            this.f20325c = j8;
            this.f20326d = bArr;
        }

        public static c a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(C2264a.f20281o0);
            return new c(2, bytes.length, bytes);
        }

        public static c b(long j8, ByteOrder byteOrder) {
            return c(new long[]{j8}, byteOrder);
        }

        public static c c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2264a.f20263W[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j8 : jArr) {
                byteBufferWrap.putInt((int) j8);
            }
            return new c(4, jArr.length, byteBufferWrap.array());
        }

        public static c d(e eVar, ByteOrder byteOrder) {
            return e(new e[]{eVar}, byteOrder);
        }

        public static c e(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2264a.f20263W[5] * eVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (e eVar : eVarArr) {
                byteBufferWrap.putInt((int) eVar.f20331a);
                byteBufferWrap.putInt((int) eVar.f20332b);
            }
            return new c(5, eVarArr.length, byteBufferWrap.array());
        }

        public static c f(int i8, ByteOrder byteOrder) {
            return g(new int[]{i8}, byteOrder);
        }

        public static c g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2264a.f20263W[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i8 : iArr) {
                byteBufferWrap.putShort((short) i8);
            }
            return new c(3, iArr.length, byteBufferWrap.array());
        }

        public double h(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objK instanceof String) {
                return Double.parseDouble((String) objK);
            }
            if (objK instanceof long[]) {
                if (((long[]) objK).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof int[]) {
                if (((int[]) objK).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objK instanceof e[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            e[] eVarArr = (e[]) objK;
            if (eVarArr.length == 1) {
                return eVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int i(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objK instanceof String) {
                return Integer.parseInt((String) objK);
            }
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objK instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objK;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String j(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                return null;
            }
            if (objK instanceof String) {
                return (String) objK;
            }
            StringBuilder sb = new StringBuilder();
            int i8 = 0;
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                while (i8 < jArr.length) {
                    sb.append(jArr[i8]);
                    i8++;
                    if (i8 != jArr.length) {
                        sb.append(com.amazon.a.a.o.b.f.f14100a);
                    }
                }
                return sb.toString();
            }
            if (objK instanceof int[]) {
                int[] iArr = (int[]) objK;
                while (i8 < iArr.length) {
                    sb.append(iArr[i8]);
                    i8++;
                    if (i8 != iArr.length) {
                        sb.append(com.amazon.a.a.o.b.f.f14100a);
                    }
                }
                return sb.toString();
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                while (i8 < dArr.length) {
                    sb.append(dArr[i8]);
                    i8++;
                    if (i8 != dArr.length) {
                        sb.append(com.amazon.a.a.o.b.f.f14100a);
                    }
                }
                return sb.toString();
            }
            if (!(objK instanceof e[])) {
                return null;
            }
            e[] eVarArr = (e[]) objK;
            while (i8 < eVarArr.length) {
                sb.append(eVarArr[i8].f20331a);
                sb.append('/');
                sb.append(eVarArr[i8].f20332b);
                i8++;
                if (i8 != eVarArr.length) {
                    sb.append(com.amazon.a.a.o.b.f.f14100a);
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:17:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:162:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object k(java.nio.ByteOrder r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 436
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: k0.C2264a.c.k(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + C2264a.f20262V[this.f20323a] + ", data length:" + this.f20326d.length + ")";
        }

        public c(int i8, int i9, byte[] bArr) {
            this(i8, i9, -1L, bArr);
        }
    }

    /* JADX INFO: renamed from: k0.a$d */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f20328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f20329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f20330d;

        public d(String str, int i8, int i9) {
            this.f20328b = str;
            this.f20327a = i8;
            this.f20329c = i9;
            this.f20330d = -1;
        }

        public boolean a(int i8) {
            int i9;
            int i10 = this.f20329c;
            if (i10 == 7 || i8 == 7 || i10 == i8 || (i9 = this.f20330d) == i8) {
                return true;
            }
            if ((i10 == 4 || i9 == 4) && i8 == 3) {
                return true;
            }
            if ((i10 == 9 || i9 == 9) && i8 == 8) {
                return true;
            }
            return (i10 == 12 || i9 == 12) && i8 == 11;
        }

        public d(String str, int i8, int i9, int i10) {
            this.f20328b = str;
            this.f20327a = i8;
            this.f20329c = i9;
            this.f20330d = i10;
        }
    }

    /* JADX INFO: renamed from: k0.a$e */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f20331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f20332b;

        public e(long j8, long j9) {
            if (j9 == 0) {
                this.f20331a = 0L;
                this.f20332b = 1L;
            } else {
                this.f20331a = j8;
                this.f20332b = j9;
            }
        }

        public double a() {
            return this.f20331a / this.f20332b;
        }

        public String toString() {
            return this.f20331a + "/" + this.f20332b;
        }
    }

    /* JADX INFO: renamed from: k0.a$f */
    public static class f extends b {
        public f(InputStream inputStream) {
            super(inputStream);
            if (!inputStream.markSupported()) {
                throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            }
            this.f20319a.mark(Integer.MAX_VALUE);
        }

        public void n(long j8) throws IOException {
            int i8 = this.f20321c;
            if (i8 > j8) {
                this.f20321c = 0;
                this.f20319a.reset();
            } else {
                j8 -= (long) i8;
            }
            f((int) j8);
        }

        public f(byte[] bArr) {
            super(bArr);
            this.f20319a.mark(Integer.MAX_VALUE);
        }
    }

    static {
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1)};
        f20265Y = dVarArr;
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f20266Z = dVarArr2;
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        f20267a0 = dVarArr3;
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        f20268b0 = dVarArr4;
        d[] dVarArr5 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f20269c0 = dVarArr5;
        f20270d0 = new d("StripOffsets", 273, 3);
        d[] dVarArr6 = {new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
        f20271e0 = dVarArr6;
        d[] dVarArr7 = {new d("PreviewImageStart", 257, 4), new d("PreviewImageLength", 258, 4)};
        f20272f0 = dVarArr7;
        d[] dVarArr8 = {new d("AspectFrame", 4371, 3)};
        f20273g0 = dVarArr8;
        d[] dVarArr9 = {new d("ColorSpace", 55, 3)};
        f20274h0 = dVarArr9;
        d[][] dVarArr10 = {dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, dVarArr6, dVarArr7, dVarArr8, dVarArr9};
        f20275i0 = dVarArr10;
        f20276j0 = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
        f20277k0 = new HashMap[dVarArr10.length];
        f20278l0 = new HashMap[dVarArr10.length];
        f20279m0 = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f20280n0 = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        f20281o0 = charsetForName;
        f20282p0 = "Exif\u0000\u0000".getBytes(charsetForName);
        f20283q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        f20260T = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        f20261U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i8 = 0;
        while (true) {
            d[][] dVarArr11 = f20275i0;
            if (i8 >= dVarArr11.length) {
                HashMap map = f20280n0;
                d[] dVarArr12 = f20276j0;
                map.put(Integer.valueOf(dVarArr12[0].f20327a), 5);
                map.put(Integer.valueOf(dVarArr12[1].f20327a), 1);
                map.put(Integer.valueOf(dVarArr12[2].f20327a), 2);
                map.put(Integer.valueOf(dVarArr12[3].f20327a), 3);
                map.put(Integer.valueOf(dVarArr12[4].f20327a), 7);
                map.put(Integer.valueOf(dVarArr12[5].f20327a), 8);
                f20284r0 = Pattern.compile(".*[1-9].*");
                f20285s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f20286t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f20288u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f20277k0[i8] = new HashMap();
            f20278l0[i8] = new HashMap();
            for (d dVar : dVarArr11[i8]) {
                f20277k0[i8].put(Integer.valueOf(dVar.f20327a), dVar);
                f20278l0[i8].put(dVar.f20328b, dVar);
            }
            i8++;
        }
    }

    public C2264a(InputStream inputStream) {
        this(inputStream, 0);
    }

    public static boolean K(int i8) {
        return (i8 == 4 || i8 == 9 || i8 == 13 || i8 == 14) ? false : true;
    }

    public static boolean q(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f20282p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i8 = 0;
        while (true) {
            byte[] bArr3 = f20282p0;
            if (i8 >= bArr3.length) {
                return true;
            }
            if (bArr2[i8] != bArr3[i8]) {
                return false;
            }
            i8++;
        }
    }

    public static boolean s(byte[] bArr) {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = f20241A;
            if (i8 >= bArr2.length) {
                return true;
            }
            if (bArr[i8] != bArr2[i8]) {
                return false;
            }
            i8++;
        }
    }

    public static boolean x(FileDescriptor fileDescriptor) {
        try {
            b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!f20287u) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    public final boolean A(byte[] bArr) {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = f20251K;
            if (i8 >= bArr2.length) {
                int i9 = 0;
                while (true) {
                    byte[] bArr3 = f20252L;
                    if (i9 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[f20251K.length + i9 + 4] != bArr3[i9]) {
                        return false;
                    }
                    i9++;
                }
            } else {
                if (bArr[i8] != bArr2[i8]) {
                    return false;
                }
                i8++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x009f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0004, B:6:0x0009, B:13:0x001e, B:15:0x0022, B:16:0x0030, B:18:0x0038, B:20:0x0041, B:31:0x0061, B:21:0x0045, B:23:0x004b, B:26:0x0052, B:29:0x005a, B:30:0x005e, B:32:0x006b, B:34:0x0075, B:37:0x007d, B:40:0x0085, B:43:0x008d, B:47:0x009b, B:49:0x009f), top: B:60:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(java.io.InputStream r5) {
        /*
            r4 = this;
            if (r5 == 0) goto Lb8
            r0 = 0
            r1 = r0
        L4:
            k0.a$d[][] r2 = k0.C2264a.f20275i0     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r2.length     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 >= r2) goto L1e
            java.util.HashMap[] r2 = r4.f20299f     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3.<init>()     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2[r1] = r3     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r1 = r1 + 1
            goto L4
        L15:
            r5 = move-exception
            goto Lad
        L18:
            r5 = move-exception
            goto L9b
        L1b:
            r5 = move-exception
            goto L9b
        L1e:
            boolean r1 = r4.f20298e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 != 0) goto L30
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.g(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.f20297d = r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r5 = r1
        L30:
            int r1 = r4.f20297d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r1 = K(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 == 0) goto L6b
            k0.a$f r0 = new k0.a$f     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r5 = r4.f20298e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r5 == 0) goto L45
            r4.m(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L45:
            int r5 = r4.f20297d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1 = 12
            if (r5 != r1) goto L4f
            r4.e(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L4f:
            r1 = 7
            if (r5 != r1) goto L56
            r4.h(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L56:
            r1 = 10
            if (r5 != r1) goto L5e
            r4.l(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L5e:
            r4.k(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L61:
            int r5 = r4.f20309p     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            long r1 = (long) r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.n(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.J(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L6b:
            k0.a$b r1 = new k0.a$b     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.f20297d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 4
            if (r5 != r2) goto L79
            r4.f(r1, r0, r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L79:
            r0 = 13
            if (r5 != r0) goto L81
            r4.i(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L81:
            r0 = 9
            if (r5 != r0) goto L89
            r4.j(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L89:
            r0 = 14
            if (r5 != r0) goto L90
            r4.n(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L90:
            r4.a()
            boolean r5 = k0.C2264a.f20287u
            if (r5 == 0) goto Lac
        L97:
            r4.D()
            goto Lac
        L9b:
            boolean r0 = k0.C2264a.f20287u     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto La6
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r5)     // Catch: java.lang.Throwable -> L15
        La6:
            r4.a()
            if (r0 == 0) goto Lac
            goto L97
        Lac:
            return
        Lad:
            r4.a()
            boolean r0 = k0.C2264a.f20287u
            if (r0 == 0) goto Lb7
            r4.D()
        Lb7:
            throw r5
        Lb8:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.C2264a.B(java.io.InputStream):void");
    }

    public final void C(b bVar) throws IOException {
        ByteOrder byteOrderE = E(bVar);
        this.f20301h = byteOrderE;
        bVar.e(byteOrderE);
        int unsignedShort = bVar.readUnsignedShort();
        int i8 = this.f20297d;
        if (i8 != 7 && i8 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i9 = bVar.readInt();
        if (i9 < 8) {
            throw new IOException("Invalid first Ifd offset: " + i9);
        }
        int i10 = i9 - 8;
        if (i10 > 0) {
            bVar.f(i10);
        }
    }

    public final void D() {
        for (int i8 = 0; i8 < this.f20299f.length; i8++) {
            Log.d("ExifInterface", "The size of tag group[" + i8 + "]: " + this.f20299f[i8].size());
            for (Map.Entry entry : this.f20299f[i8].entrySet()) {
                c cVar = (c) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + cVar.toString() + ", tagValue: '" + cVar.j(this.f20301h) + "'");
            }
        }
    }

    public final ByteOrder E(b bVar) throws IOException {
        short s8 = bVar.readShort();
        if (s8 == 18761) {
            if (f20287u) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s8 == 19789) {
            if (f20287u) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s8));
    }

    public final void F(byte[] bArr, int i8) throws IOException {
        f fVar = new f(bArr);
        C(fVar);
        G(fVar, i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0268  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(k0.C2264a.f r26, int r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 875
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.C2264a.G(k0.a$f, int):void");
    }

    public final void H(int i8, String str, String str2) {
        if (this.f20299f[i8].isEmpty() || this.f20299f[i8].get(str) == null) {
            return;
        }
        HashMap map = this.f20299f[i8];
        map.put(str2, map.get(str));
        this.f20299f[i8].remove(str);
    }

    public final void I(f fVar, int i8) throws Throwable {
        c cVar = (c) this.f20299f[i8].get("ImageLength");
        c cVar2 = (c) this.f20299f[i8].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            c cVar3 = (c) this.f20299f[i8].get("JPEGInterchangeFormat");
            c cVar4 = (c) this.f20299f[i8].get("JPEGInterchangeFormatLength");
            if (cVar3 == null || cVar4 == null) {
                return;
            }
            int i9 = cVar3.i(this.f20301h);
            int i10 = cVar3.i(this.f20301h);
            fVar.n(i9);
            byte[] bArr = new byte[i10];
            fVar.read(bArr);
            f(new b(bArr), i9, i8);
        }
    }

    public final void J(b bVar) throws Throwable {
        HashMap map = this.f20299f[4];
        c cVar = (c) map.get("Compression");
        if (cVar != null) {
            int i8 = cVar.i(this.f20301h);
            this.f20308o = i8;
            if (i8 != 1) {
                if (i8 != 6) {
                    if (i8 != 7) {
                        return;
                    }
                }
            }
            if (y(map)) {
                p(bVar, map);
                return;
            }
            return;
        }
        this.f20308o = 6;
        o(bVar, map);
    }

    public final void L(int i8, int i9) throws Throwable {
        String str;
        if (this.f20299f[i8].isEmpty() || this.f20299f[i9].isEmpty()) {
            if (f20287u) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        c cVar = (c) this.f20299f[i8].get("ImageLength");
        c cVar2 = (c) this.f20299f[i8].get("ImageWidth");
        c cVar3 = (c) this.f20299f[i9].get("ImageLength");
        c cVar4 = (c) this.f20299f[i9].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            if (!f20287u) {
                return;
            } else {
                str = "First image does not contain valid size information";
            }
        } else {
            if (cVar3 != null && cVar4 != null) {
                int i10 = cVar.i(this.f20301h);
                int i11 = cVar2.i(this.f20301h);
                int i12 = cVar3.i(this.f20301h);
                int i13 = cVar4.i(this.f20301h);
                if (i10 >= i12 || i11 >= i13) {
                    return;
                }
                HashMap[] mapArr = this.f20299f;
                HashMap map = mapArr[i8];
                mapArr[i8] = mapArr[i9];
                mapArr[i9] = map;
                return;
            }
            if (!f20287u) {
                return;
            } else {
                str = "Second image does not contain valid size information";
            }
        }
        Log.d("ExifInterface", str);
    }

    public final void M(f fVar, int i8) throws Throwable {
        StringBuilder sb;
        String string;
        c cVarF;
        c cVarF2;
        c cVar = (c) this.f20299f[i8].get("DefaultCropSize");
        c cVar2 = (c) this.f20299f[i8].get("SensorTopBorder");
        c cVar3 = (c) this.f20299f[i8].get("SensorLeftBorder");
        c cVar4 = (c) this.f20299f[i8].get("SensorBottomBorder");
        c cVar5 = (c) this.f20299f[i8].get("SensorRightBorder");
        if (cVar == null) {
            if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
                I(fVar, i8);
                return;
            }
            int i9 = cVar2.i(this.f20301h);
            int i10 = cVar4.i(this.f20301h);
            int i11 = cVar5.i(this.f20301h);
            int i12 = cVar3.i(this.f20301h);
            if (i10 <= i9 || i11 <= i12) {
                return;
            }
            c cVarF3 = c.f(i10 - i9, this.f20301h);
            c cVarF4 = c.f(i11 - i12, this.f20301h);
            this.f20299f[i8].put("ImageLength", cVarF3);
            this.f20299f[i8].put("ImageWidth", cVarF4);
            return;
        }
        if (cVar.f20323a == 5) {
            e[] eVarArr = (e[]) cVar.k(this.f20301h);
            if (eVarArr != null && eVarArr.length == 2) {
                cVarF = c.d(eVarArr[0], this.f20301h);
                cVarF2 = c.d(eVarArr[1], this.f20301h);
                this.f20299f[i8].put("ImageWidth", cVarF);
                this.f20299f[i8].put("ImageLength", cVarF2);
                return;
            }
            sb = new StringBuilder();
            sb.append("Invalid crop size values. cropSize=");
            string = Arrays.toString(eVarArr);
            sb.append(string);
            Log.w("ExifInterface", sb.toString());
        }
        int[] iArr = (int[]) cVar.k(this.f20301h);
        if (iArr != null && iArr.length == 2) {
            cVarF = c.f(iArr[0], this.f20301h);
            cVarF2 = c.f(iArr[1], this.f20301h);
            this.f20299f[i8].put("ImageWidth", cVarF);
            this.f20299f[i8].put("ImageLength", cVarF2);
            return;
        }
        sb = new StringBuilder();
        sb.append("Invalid crop size values. cropSize=");
        string = Arrays.toString(iArr);
        sb.append(string);
        Log.w("ExifInterface", sb.toString());
    }

    public final void N() throws Throwable {
        L(0, 5);
        L(0, 4);
        L(5, 4);
        c cVar = (c) this.f20299f[1].get("PixelXDimension");
        c cVar2 = (c) this.f20299f[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            this.f20299f[0].put("ImageWidth", cVar);
            this.f20299f[0].put("ImageLength", cVar2);
        }
        if (this.f20299f[4].isEmpty() && z(this.f20299f[5])) {
            HashMap[] mapArr = this.f20299f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!z(this.f20299f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        H(0, "ThumbnailOrientation", "Orientation");
        H(0, "ThumbnailImageLength", "ImageLength");
        H(0, "ThumbnailImageWidth", "ImageWidth");
        H(5, "ThumbnailOrientation", "Orientation");
        H(5, "ThumbnailImageLength", "ImageLength");
        H(5, "ThumbnailImageWidth", "ImageWidth");
        H(4, "Orientation", "ThumbnailOrientation");
        H(4, "ImageLength", "ThumbnailImageLength");
        H(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public final void a() {
        String strB = b("DateTimeOriginal");
        if (strB != null && b("DateTime") == null) {
            this.f20299f[0].put("DateTime", c.a(strB));
        }
        if (b("ImageWidth") == null) {
            this.f20299f[0].put("ImageWidth", c.b(0L, this.f20301h));
        }
        if (b("ImageLength") == null) {
            this.f20299f[0].put("ImageLength", c.b(0L, this.f20301h));
        }
        if (b("Orientation") == null) {
            this.f20299f[0].put("Orientation", c.b(0L, this.f20301h));
        }
        if (b("LightSource") == null) {
            this.f20299f[1].put("LightSource", c.b(0L, this.f20301h));
        }
    }

    public String b(String str) {
        String str2;
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c cVarD = d(str);
        if (cVarD != null) {
            if (!f20279m0.contains(str)) {
                return cVarD.j(this.f20301h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i8 = cVarD.f20323a;
                if (i8 == 5 || i8 == 10) {
                    e[] eVarArr = (e[]) cVarD.k(this.f20301h);
                    if (eVarArr != null && eVarArr.length == 3) {
                        e eVar = eVarArr[0];
                        Integer numValueOf = Integer.valueOf((int) (eVar.f20331a / eVar.f20332b));
                        e eVar2 = eVarArr[1];
                        Integer numValueOf2 = Integer.valueOf((int) (eVar2.f20331a / eVar2.f20332b));
                        e eVar3 = eVarArr[2];
                        return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (eVar3.f20331a / eVar3.f20332b)));
                    }
                    str2 = "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr);
                } else {
                    str2 = "GPS Timestamp format is not rational. format=" + cVarD.f20323a;
                }
                Log.w("ExifInterface", str2);
                return null;
            }
            try {
                return Double.toString(cVarD.h(this.f20301h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int c(String str, int i8) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c cVarD = d(str);
        if (cVarD == null) {
            return i8;
        }
        try {
            return cVarD.i(this.f20301h);
        } catch (NumberFormatException unused) {
            return i8;
        }
    }

    public final c d(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (f20287u) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i8 = 0; i8 < f20275i0.length; i8++) {
            c cVar = (c) this.f20299f[i8].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(f fVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                b.C0338b.a(mediaMetadataRetriever, new C0337a(fVar));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                if (strExtractMetadata != null) {
                    this.f20299f[0].put("ImageWidth", c.f(Integer.parseInt(strExtractMetadata), this.f20301h));
                }
                if (strExtractMetadata2 != null) {
                    this.f20299f[0].put("ImageLength", c.f(Integer.parseInt(strExtractMetadata2), this.f20301h));
                }
                if (strExtractMetadata3 != null) {
                    int i8 = Integer.parseInt(strExtractMetadata3);
                    this.f20299f[0].put("Orientation", c.f(i8 != 90 ? i8 != 180 ? i8 != 270 ? 1 : 8 : 3 : 6, this.f20301h));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i9 = Integer.parseInt(strExtractMetadata4);
                    int i10 = Integer.parseInt(strExtractMetadata5);
                    if (i10 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.n(i9);
                    byte[] bArr = new byte[6];
                    if (fVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i11 = i9 + 6;
                    int i12 = i10 - 6;
                    if (!Arrays.equals(bArr, f20282p0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i12];
                    if (fVar.read(bArr2) != i12) {
                        throw new IOException("Can't read exif");
                    }
                    this.f20309p = i11;
                    F(bArr2, 0);
                }
                if (f20287u) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017b A[LOOP:0: B:10:0x0037->B:63:0x017b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0182 A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1060)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1085)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(k0.C2264a.b r22, int r23, int r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.C2264a.f(k0.a$b, int, int):void");
    }

    public final int g(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (s(bArr)) {
            return 4;
        }
        if (v(bArr)) {
            return 9;
        }
        if (r(bArr)) {
            return 12;
        }
        if (t(bArr)) {
            return 7;
        }
        if (w(bArr)) {
            return 10;
        }
        if (u(bArr)) {
            return 13;
        }
        return A(bArr) ? 14 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(k0.C2264a.f r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.C2264a.h(k0.a$f):void");
    }

    public final void i(b bVar) throws Throwable {
        if (f20287u) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.e(ByteOrder.BIG_ENDIAN);
        byte[] bArr = f20247G;
        bVar.f(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i8 = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i9 = length + 8;
                if (i9 == 16 && !Arrays.equals(bArr2, f20249I)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, f20250J)) {
                    return;
                }
                if (Arrays.equals(bArr2, f20248H)) {
                    byte[] bArr3 = new byte[i8];
                    if (bVar.read(bArr3) != i8) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + k0.b.a(bArr2));
                    }
                    int i10 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i10) {
                        this.f20309p = i9;
                        F(bArr3, 0);
                        N();
                        J(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i10 + ", calculated CRC value: " + crc32.getValue());
                }
                int i11 = i8 + 4;
                bVar.f(i11);
                length = i9 + i11;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void j(b bVar) throws Throwable {
        boolean z7 = f20287u;
        if (z7) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.f(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i8 = ByteBuffer.wrap(bArr).getInt();
        int i9 = ByteBuffer.wrap(bArr2).getInt();
        int i10 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i9];
        bVar.f(i8 - bVar.a());
        bVar.read(bArr4);
        f(new b(bArr4), i8, 5);
        bVar.f(i10 - bVar.a());
        bVar.e(ByteOrder.BIG_ENDIAN);
        int i11 = bVar.readInt();
        if (z7) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i11);
        }
        for (int i12 = 0; i12 < i11; i12++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == f20270d0.f20327a) {
                short s8 = bVar.readShort();
                short s9 = bVar.readShort();
                c cVarF = c.f(s8, this.f20301h);
                c cVarF2 = c.f(s9, this.f20301h);
                this.f20299f[0].put("ImageLength", cVarF);
                this.f20299f[0].put("ImageWidth", cVarF2);
                if (f20287u) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s8) + ", width: " + ((int) s9));
                    return;
                }
                return;
            }
            bVar.f(unsignedShort2);
        }
    }

    public final void k(f fVar) throws Throwable {
        c cVar;
        C(fVar);
        G(fVar, 0);
        M(fVar, 0);
        M(fVar, 5);
        M(fVar, 4);
        N();
        if (this.f20297d != 8 || (cVar = (c) this.f20299f[1].get("MakerNote")) == null) {
            return;
        }
        f fVar2 = new f(cVar.f20326d);
        fVar2.e(this.f20301h);
        fVar2.f(6);
        G(fVar2, 9);
        c cVar2 = (c) this.f20299f[9].get("ColorSpace");
        if (cVar2 != null) {
            this.f20299f[1].put("ColorSpace", cVar2);
        }
    }

    public final void l(f fVar) throws Throwable {
        if (f20287u) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + fVar);
        }
        k(fVar);
        c cVar = (c) this.f20299f[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new b(cVar.f20326d), (int) cVar.f20325c, 5);
        }
        c cVar2 = (c) this.f20299f[0].get("ISO");
        c cVar3 = (c) this.f20299f[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        this.f20299f[1].put("PhotographicSensitivity", cVar2);
    }

    public final void m(f fVar) throws IOException {
        byte[] bArr = f20282p0;
        fVar.f(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.f20309p = bArr.length;
        F(bArr2, 0);
    }

    public final void n(b bVar) throws Throwable {
        if (f20287u) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.e(ByteOrder.LITTLE_ENDIAN);
        bVar.f(f20251K.length);
        int i8 = bVar.readInt() + 8;
        byte[] bArr = f20252L;
        bVar.f(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i9 = bVar.readInt();
                int i10 = length + 8;
                if (Arrays.equals(f20253M, bArr2)) {
                    byte[] bArr3 = new byte[i9];
                    if (bVar.read(bArr3) == i9) {
                        this.f20309p = i10;
                        F(bArr3, 0);
                        J(new b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + k0.b.a(bArr2));
                    }
                }
                if (i9 % 2 == 1) {
                    i9++;
                }
                length = i10 + i9;
                if (length == i8) {
                    return;
                }
                if (length > i8) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.f(i9);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void o(b bVar, HashMap map) throws Throwable {
        c cVar = (c) map.get("JPEGInterchangeFormat");
        c cVar2 = (c) map.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int i8 = cVar.i(this.f20301h);
        int i9 = cVar2.i(this.f20301h);
        if (this.f20297d == 7) {
            i8 += this.f20310q;
        }
        if (i8 > 0 && i9 > 0) {
            this.f20302i = true;
            if (this.f20294a == null && this.f20296c == null && this.f20295b == null) {
                byte[] bArr = new byte[i9];
                bVar.skip(i8);
                bVar.read(bArr);
                this.f20307n = bArr;
            }
            this.f20305l = i8;
            this.f20306m = i9;
        }
        if (f20287u) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + i8 + ", length: " + i9);
        }
    }

    public final void p(b bVar, HashMap map) {
        c cVar = (c) map.get("StripOffsets");
        c cVar2 = (c) map.get("StripByteCounts");
        if (cVar == null || cVar2 == null) {
            return;
        }
        long[] jArrB = k0.b.b(cVar.k(this.f20301h));
        long[] jArrB2 = k0.b.b(cVar2.k(this.f20301h));
        if (jArrB == null || jArrB.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrB2 == null || jArrB2.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrB.length != jArrB2.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j8 = 0;
        for (long j9 : jArrB2) {
            j8 += j9;
        }
        int i8 = (int) j8;
        byte[] bArr = new byte[i8];
        this.f20304k = true;
        this.f20303j = true;
        this.f20302i = true;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < jArrB.length; i11++) {
            int i12 = (int) jArrB[i11];
            int i13 = (int) jArrB2[i11];
            if (i11 < jArrB.length - 1 && i12 + i13 != jArrB[i11 + 1]) {
                this.f20304k = false;
            }
            int i14 = i12 - i9;
            if (i14 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
                return;
            }
            long j10 = i14;
            if (bVar.skip(j10) != j10) {
                Log.d("ExifInterface", "Failed to skip " + i14 + " bytes.");
                return;
            }
            int i15 = i9 + i14;
            byte[] bArr2 = new byte[i13];
            if (bVar.read(bArr2) != i13) {
                Log.d("ExifInterface", "Failed to read " + i13 + " bytes.");
                return;
            }
            i9 = i15 + i13;
            System.arraycopy(bArr2, 0, bArr, i10, i13);
            i10 += i13;
        }
        this.f20307n = bArr;
        if (this.f20304k) {
            this.f20305l = (int) jArrB[0];
            this.f20306m = i8;
        }
    }

    public final boolean r(byte[] bArr) throws Throwable {
        b bVar;
        long j8;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            long length = bVar.readInt();
            byte[] bArr2 = new byte[4];
            bVar.read(bArr2);
            if (!Arrays.equals(bArr2, f20242B)) {
                bVar.close();
                return false;
            }
            if (length == 1) {
                length = bVar.readLong();
                j8 = 16;
                if (length < 16) {
                    bVar.close();
                    return false;
                }
            } else {
                j8 = 8;
            }
            if (length > bArr.length) {
                length = bArr.length;
            }
            long j9 = length - j8;
            if (j9 < 8) {
                bVar.close();
                return false;
            }
            byte[] bArr3 = new byte[4];
            boolean z7 = false;
            boolean z8 = false;
            for (long j10 = 0; j10 < j9 / 4; j10++) {
                if (bVar.read(bArr3) != 4) {
                    bVar.close();
                    return false;
                }
                if (j10 != 1) {
                    if (Arrays.equals(bArr3, f20243C)) {
                        z7 = true;
                    } else if (Arrays.equals(bArr3, f20244D)) {
                        z8 = true;
                    }
                    if (z7 && z8) {
                        bVar.close();
                        return true;
                    }
                }
            }
            bVar.close();
        } catch (Exception e9) {
            e = e9;
            bVar2 = bVar;
            if (f20287u) {
                Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
            }
            if (bVar2 != null) {
                bVar2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
        return false;
    }

    public final boolean t(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderE = E(bVar2);
                this.f20301h = byteOrderE;
                bVar2.e(byteOrderE);
                short s8 = bVar2.readShort();
                boolean z7 = s8 == 20306 || s8 == 21330;
                bVar2.close();
                return z7;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean u(byte[] bArr) {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = f20247G;
            if (i8 >= bArr2.length) {
                return true;
            }
            if (bArr[i8] != bArr2[i8]) {
                return false;
            }
            i8++;
        }
    }

    public final boolean v(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i8 = 0; i8 < bytes.length; i8++) {
            if (bArr[i8] != bytes[i8]) {
                return false;
            }
        }
        return true;
    }

    public final boolean w(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderE = E(bVar2);
                this.f20301h = byteOrderE;
                bVar2.e(byteOrderE);
                boolean z7 = bVar2.readShort() == 85;
                bVar2.close();
                return z7;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean y(HashMap map) {
        c cVar;
        int i8;
        c cVar2 = (c) map.get("BitsPerSample");
        if (cVar2 != null) {
            int[] iArr = (int[]) cVar2.k(this.f20301h);
            int[] iArr2 = f20291x;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f20297d == 3 && (cVar = (c) map.get("PhotometricInterpretation")) != null && (((i8 = cVar.i(this.f20301h)) == 1 && Arrays.equals(iArr, f20293z)) || (i8 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f20287u) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    public final boolean z(HashMap map) {
        c cVar = (c) map.get("ImageLength");
        c cVar2 = (c) map.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.i(this.f20301h) <= 512 && cVar2.i(this.f20301h) <= 512;
    }

    public C2264a(InputStream inputStream, int i8) {
        d[][] dVarArr = f20275i0;
        this.f20299f = new HashMap[dVarArr.length];
        this.f20300g = new HashSet(dVarArr.length);
        this.f20301h = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new NullPointerException("inputStream cannot be null");
        }
        this.f20294a = null;
        if (i8 == 1) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f20282p0.length);
            if (!q(bufferedInputStream)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.f20298e = true;
            this.f20296c = null;
            this.f20295b = null;
            inputStream = bufferedInputStream;
        } else {
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f20296c = (AssetManager.AssetInputStream) inputStream;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (x(fileInputStream.getFD())) {
                        this.f20296c = null;
                        this.f20295b = fileInputStream.getFD();
                    }
                }
                this.f20296c = null;
            }
            this.f20295b = null;
        }
        B(inputStream);
    }

    /* JADX INFO: renamed from: k0.a$a, reason: collision with other inner class name */
    public class C0337a extends MediaDataSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f20314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f20315b;

        public C0337a(f fVar) {
            this.f20315b = fVar;
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j8, byte[] bArr, int i8, int i9) {
            if (i9 == 0) {
                return 0;
            }
            if (j8 < 0) {
                return -1;
            }
            try {
                long j9 = this.f20314a;
                if (j9 != j8) {
                    if (j9 >= 0 && j8 >= j9 + ((long) this.f20315b.available())) {
                        return -1;
                    }
                    this.f20315b.n(j8);
                    this.f20314a = j8;
                }
                if (i9 > this.f20315b.available()) {
                    i9 = this.f20315b.available();
                }
                int i10 = this.f20315b.read(bArr, i8, i9);
                if (i10 >= 0) {
                    this.f20314a += (long) i10;
                    return i10;
                }
            } catch (IOException unused) {
            }
            this.f20314a = -1L;
            return -1;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
