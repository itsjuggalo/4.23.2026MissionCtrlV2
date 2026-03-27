package k0;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.a;
import com.revenuecat.purchases.common.Constants;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import k0.AbstractC2064b;
import k4.C2105D;

/* JADX INFO: renamed from: k0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2063a {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static SimpleDateFormat f17482U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static SimpleDateFormat f17483V;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static final e[] f17487Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final e[] f17488a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final e[] f17489b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final e[] f17490c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final e[] f17491d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final e f17492e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final e[] f17493f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final e[] f17494g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final e[] f17495h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final e[] f17496i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final e[][] f17497j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final e[] f17498k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final HashMap[] f17499l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final HashMap[] f17500m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final HashSet f17501n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final HashMap f17502o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final Charset f17503p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final byte[] f17504q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final byte[] f17505r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final Pattern f17506s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final Pattern f17507t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final Pattern f17508u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final Pattern f17510v0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileDescriptor f17516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AssetManager.AssetInputStream f17517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f17519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap[] f17520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set f17521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ByteOrder f17522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f17523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f17524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f17525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17526l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f17527m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f17528n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17529o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f17530p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f17531q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f17532r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f17533s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f17534t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f17535u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f17509v = Log.isLoggable("ExifInterface", 3);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final List f17511w = Arrays.asList(1, 6, 3, 8);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final List f17512x = Arrays.asList(2, 7, 4, 5);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f17513y = {8, 8, 8};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f17514z = {4};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final int[] f17462A = {8};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final byte[] f17463B = {-1, -40, -1};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final byte[] f17464C = {102, 116, 121, 112};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final byte[] f17465D = {109, 105, 102, 49};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final byte[] f17466E = {104, 101, 105, 99};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final byte[] f17467F = {79, 76, 89, 77, 80, 0};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final byte[] f17468G = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final byte[] f17469H = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final byte[] f17470I = {101, 88, 73, 102};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final byte[] f17471J = {73, 72, 68, 82};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final byte[] f17472K = {73, 69, 78, 68};

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final byte[] f17473L = {82, 73, 70, 70};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final byte[] f17474M = {87, 69, 66, 80};

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final byte[] f17475N = {69, 88, 73, 70};

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final byte[] f17476O = {-99, 1, 42};

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final byte[] f17477P = "VP8X".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final byte[] f17478Q = "VP8L".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final byte[] f17479R = "VP8 ".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final byte[] f17480S = "ANIM".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final byte[] f17481T = "ANMF".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final String[] f17484W = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static final int[] f17485X = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static final byte[] f17486Y = {65, 83, 67, 73, 73, 0, 0, 0};

    /* JADX INFO: renamed from: k0.a$c */
    public static class c extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f17544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteOrder f17545b;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f17544a = outputStream;
            this.f17545b = byteOrder;
        }

        public void A(int i7) throws IOException {
            ByteOrder byteOrder = this.f17545b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f17544a.write(i7 & 255);
                this.f17544a.write((i7 >>> 8) & 255);
                this.f17544a.write((i7 >>> 16) & 255);
                this.f17544a.write((i7 >>> 24) & 255);
                return;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f17544a.write((i7 >>> 24) & 255);
                this.f17544a.write((i7 >>> 16) & 255);
                this.f17544a.write((i7 >>> 8) & 255);
                this.f17544a.write(i7 & 255);
            }
        }

        public void G(short s7) throws IOException {
            ByteOrder byteOrder = this.f17545b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f17544a.write(s7 & 255);
                this.f17544a.write((s7 >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f17544a.write((s7 >>> 8) & 255);
                this.f17544a.write(s7 & 255);
            }
        }

        public void H(long j7) throws IOException {
            if (j7 > 4294967295L) {
                throw new IllegalArgumentException("val is larger than the maximum value of a 32-bit unsigned integer");
            }
            A((int) j7);
        }

        public void K(int i7) throws IOException {
            if (i7 > 65535) {
                throw new IllegalArgumentException("val is larger than the maximum value of a 16-bit unsigned integer");
            }
            G((short) i7);
        }

        public void h(ByteOrder byteOrder) {
            this.f17545b = byteOrder;
        }

        public void i(int i7) throws IOException {
            this.f17544a.write(i7);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f17544a.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i7, int i8) throws IOException {
            this.f17544a.write(bArr, i7, i8);
        }
    }

    /* JADX INFO: renamed from: k0.a$d */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f17548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f17549d;

        public d(int i7, int i8, byte[] bArr) {
            this(i7, i8, -1L, bArr);
        }

        public static d a(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(C2063a.f17503p0);
            return new d(1, bytes.length, bytes);
        }

        public static d b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2063a.f17485X[12] * dArr.length]);
            byteBufferWrap.order(byteOrder);
            for (double d7 : dArr) {
                byteBufferWrap.putDouble(d7);
            }
            return new d(12, dArr.length, byteBufferWrap.array());
        }

        public static d c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2063a.f17485X[9] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i7 : iArr) {
                byteBufferWrap.putInt(i7);
            }
            return new d(9, iArr.length, byteBufferWrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2063a.f17485X[10] * fVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (f fVar : fVarArr) {
                byteBufferWrap.putInt((int) fVar.f17554a);
                byteBufferWrap.putInt((int) fVar.f17555b);
            }
            return new d(10, fVarArr.length, byteBufferWrap.array());
        }

        public static d e(String str) {
            byte[] bytes = (str + (char) 0).getBytes(C2063a.f17503p0);
            return new d(2, bytes.length, bytes);
        }

        public static d f(long j7, ByteOrder byteOrder) {
            return g(new long[]{j7}, byteOrder);
        }

        public static d g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2063a.f17485X[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j7 : jArr) {
                byteBufferWrap.putInt((int) j7);
            }
            return new d(4, jArr.length, byteBufferWrap.array());
        }

        public static d h(f fVar, ByteOrder byteOrder) {
            return i(new f[]{fVar}, byteOrder);
        }

        public static d i(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2063a.f17485X[5] * fVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (f fVar : fVarArr) {
                byteBufferWrap.putInt((int) fVar.f17554a);
                byteBufferWrap.putInt((int) fVar.f17555b);
            }
            return new d(5, fVarArr.length, byteBufferWrap.array());
        }

        public static d j(int i7, ByteOrder byteOrder) {
            return k(new int[]{i7}, byteOrder);
        }

        public static d k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C2063a.f17485X[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i7 : iArr) {
                byteBufferWrap.putShort((short) i7);
            }
            return new d(3, iArr.length, byteBufferWrap.array());
        }

        public double l(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objO instanceof String) {
                return Double.parseDouble((String) objO);
            }
            if (objO instanceof long[]) {
                if (((long[]) objO).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objO instanceof int[]) {
                if (((int[]) objO).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objO instanceof double[]) {
                double[] dArr = (double[]) objO;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objO instanceof f[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            f[] fVarArr = (f[]) objO;
            if (fVarArr.length == 1) {
                return fVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int m(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objO instanceof String) {
                return Integer.parseInt((String) objO);
            }
            if (objO instanceof long[]) {
                long[] jArr = (long[]) objO;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objO instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objO;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String n(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                return null;
            }
            if (objO instanceof String) {
                return (String) objO;
            }
            StringBuilder sb = new StringBuilder();
            int i7 = 0;
            if (objO instanceof long[]) {
                long[] jArr = (long[]) objO;
                while (i7 < jArr.length) {
                    sb.append(jArr[i7]);
                    i7++;
                    if (i7 != jArr.length) {
                        sb.append(com.amazon.a.a.o.b.f.f9989a);
                    }
                }
                return sb.toString();
            }
            if (objO instanceof int[]) {
                int[] iArr = (int[]) objO;
                while (i7 < iArr.length) {
                    sb.append(iArr[i7]);
                    i7++;
                    if (i7 != iArr.length) {
                        sb.append(com.amazon.a.a.o.b.f.f9989a);
                    }
                }
                return sb.toString();
            }
            if (objO instanceof double[]) {
                double[] dArr = (double[]) objO;
                while (i7 < dArr.length) {
                    sb.append(dArr[i7]);
                    i7++;
                    if (i7 != dArr.length) {
                        sb.append(com.amazon.a.a.o.b.f.f9989a);
                    }
                }
                return sb.toString();
            }
            if (!(objO instanceof f[])) {
                return null;
            }
            f[] fVarArr = (f[]) objO;
            while (i7 < fVarArr.length) {
                sb.append(fVarArr[i7].f17554a);
                sb.append('/');
                sb.append(fVarArr[i7].f17555b);
                i7++;
                if (i7 != fVarArr.length) {
                    sb.append(com.amazon.a.a.o.b.f.f9989a);
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:49), block:B:17:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:162:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object o(java.nio.ByteOrder r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 436
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: k0.C2063a.d.o(java.nio.ByteOrder):java.lang.Object");
        }

        public int p() {
            return C2063a.f17485X[this.f17546a] * this.f17547b;
        }

        public String toString() {
            return "(" + C2063a.f17484W[this.f17546a] + ", data length:" + this.f17549d.length + ")";
        }

        public d(int i7, int i8, long j7, byte[] bArr) {
            this.f17546a = i7;
            this.f17547b = i8;
            this.f17548c = j7;
            this.f17549d = bArr;
        }
    }

    /* JADX INFO: renamed from: k0.a$f */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f17554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17555b;

        public f(double d7) {
            this((long) (d7 * 10000.0d), 10000L);
        }

        public double a() {
            return this.f17554a / this.f17555b;
        }

        public String toString() {
            return this.f17554a + "/" + this.f17555b;
        }

        public f(long j7, long j8) {
            if (j8 == 0) {
                this.f17554a = 0L;
                this.f17555b = 1L;
            } else {
                this.f17554a = j7;
                this.f17555b = j8;
            }
        }
    }

    static {
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        f17487Z = eVarArr;
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f17488a0 = eVarArr2;
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5, 10), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5, 10), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        f17489b0 = eVarArr3;
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        f17490c0 = eVarArr4;
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f17491d0 = eVarArr5;
        f17492e0 = new e("StripOffsets", 273, 3);
        e[] eVarArr6 = {new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
        f17493f0 = eVarArr6;
        e[] eVarArr7 = {new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)};
        f17494g0 = eVarArr7;
        e[] eVarArr8 = {new e("AspectFrame", 4371, 3)};
        f17495h0 = eVarArr8;
        e[] eVarArr9 = {new e("ColorSpace", 55, 3)};
        f17496i0 = eVarArr9;
        e[][] eVarArr10 = {eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, eVarArr6, eVarArr7, eVarArr8, eVarArr9};
        f17497j0 = eVarArr10;
        f17498k0 = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        f17499l0 = new HashMap[eVarArr10.length];
        f17500m0 = new HashMap[eVarArr10.length];
        f17501n0 = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f17502o0 = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        f17503p0 = charsetForName;
        f17504q0 = "Exif\u0000\u0000".getBytes(charsetForName);
        f17505r0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        f17482U = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        f17483V = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i7 = 0;
        while (true) {
            e[][] eVarArr11 = f17497j0;
            if (i7 >= eVarArr11.length) {
                HashMap map = f17502o0;
                e[] eVarArr12 = f17498k0;
                map.put(Integer.valueOf(eVarArr12[0].f17550a), 5);
                map.put(Integer.valueOf(eVarArr12[1].f17550a), 1);
                map.put(Integer.valueOf(eVarArr12[2].f17550a), 2);
                map.put(Integer.valueOf(eVarArr12[3].f17550a), 3);
                map.put(Integer.valueOf(eVarArr12[4].f17550a), 7);
                map.put(Integer.valueOf(eVarArr12[5].f17550a), 8);
                f17506s0 = Pattern.compile(".*[1-9].*");
                f17507t0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f17508u0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f17510v0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f17499l0[i7] = new HashMap();
            f17500m0[i7] = new HashMap();
            for (e eVar : eVarArr11[i7]) {
                f17499l0[i7].put(Integer.valueOf(eVar.f17550a), eVar);
                f17500m0[i7].put(eVar.f17551b, eVar);
            }
            i7++;
        }
    }

    public C2063a(String str) throws Throwable {
        e[][] eVarArr = f17497j0;
        this.f17520f = new HashMap[eVarArr.length];
        this.f17521g = new HashSet(eVarArr.length);
        this.f17522h = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        w(str);
    }

    public static boolean E(FileDescriptor fileDescriptor) {
        try {
            AbstractC2064b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!f17509v) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    public static boolean G(int i7) {
        return i7 == 4 || i7 == 13 || i7 == 14;
    }

    public static boolean Y(int i7) {
        return (i7 == 4 || i7 == 9 || i7 == 13 || i7 == 14) ? false : true;
    }

    public static Pair t(String str) {
        if (str.contains(com.amazon.a.a.o.b.f.f9989a)) {
            String[] strArrSplit = str.split(com.amazon.a.a.o.b.f.f9989a, -1);
            Pair pairT = t(strArrSplit[0]);
            if (((Integer) pairT.first).intValue() == 2) {
                return pairT;
            }
            for (int i7 = 1; i7 < strArrSplit.length; i7++) {
                Pair pairT2 = t(strArrSplit[i7]);
                int iIntValue = (((Integer) pairT2.first).equals(pairT.first) || ((Integer) pairT2.second).equals(pairT.first)) ? ((Integer) pairT.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairT.second).intValue() == -1 || !(((Integer) pairT2.first).equals(pairT.second) || ((Integer) pairT2.second).equals(pairT.second))) ? -1 : ((Integer) pairT.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair(2, -1);
                }
                if (iIntValue == -1) {
                    pairT = new Pair(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairT = new Pair(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairT;
        }
        if (!str.contains("/")) {
            try {
                try {
                    long j7 = Long.parseLong(str);
                    return (j7 < 0 || j7 > 65535) ? j7 < 0 ? new Pair(9, -1) : new Pair(4, -1) : new Pair(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair(12, -1);
            }
        }
        String[] strArrSplit2 = str.split("/", -1);
        if (strArrSplit2.length == 2) {
            try {
                long j8 = (long) Double.parseDouble(strArrSplit2[0]);
                long j9 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j8 >= 0 && j9 >= 0) {
                    if (j8 <= 2147483647L && j9 <= 2147483647L) {
                        return new Pair(10, 5);
                    }
                    return new Pair(5, -1);
                }
                return new Pair(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair(2, -1);
    }

    public static boolean x(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f17504q0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i7 = 0;
        while (true) {
            byte[] bArr3 = f17504q0;
            if (i7 >= bArr3.length) {
                return true;
            }
            if (bArr2[i7] != bArr3[i7]) {
                return false;
            }
            i7++;
        }
    }

    public static boolean z(byte[] bArr) {
        int i7 = 0;
        while (true) {
            byte[] bArr2 = f17463B;
            if (i7 >= bArr2.length) {
                return true;
            }
            if (bArr[i7] != bArr2[i7]) {
                return false;
            }
            i7++;
        }
    }

    public final boolean A(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderM = M(bVar2);
                this.f17522h = byteOrderM;
                bVar2.G(byteOrderM);
                short s7 = bVar2.readShort();
                boolean z7 = s7 == 20306 || s7 == 21330;
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

    public final boolean B(byte[] bArr) {
        int i7 = 0;
        while (true) {
            byte[] bArr2 = f17469H;
            if (i7 >= bArr2.length) {
                return true;
            }
            if (bArr[i7] != bArr2[i7]) {
                return false;
            }
            i7++;
        }
    }

    public final boolean C(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i7 = 0; i7 < bytes.length; i7++) {
            if (bArr[i7] != bytes[i7]) {
                return false;
            }
        }
        return true;
    }

    public final boolean D(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderM = M(bVar2);
                this.f17522h = byteOrderM;
                bVar2.G(byteOrderM);
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

    public final boolean F(HashMap map) {
        d dVar;
        int iM;
        d dVar2 = (d) map.get("BitsPerSample");
        if (dVar2 != null) {
            int[] iArr = (int[]) dVar2.o(this.f17522h);
            int[] iArr2 = f17513y;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f17518d == 3 && (dVar = (d) map.get("PhotometricInterpretation")) != null && (((iM = dVar.m(this.f17522h)) == 1 && Arrays.equals(iArr, f17462A)) || (iM == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f17509v) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    public final boolean H(HashMap map) {
        d dVar = (d) map.get("ImageLength");
        d dVar2 = (d) map.get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            return false;
        }
        return dVar.m(this.f17522h) <= 512 && dVar2.m(this.f17522h) <= 512;
    }

    public final boolean I(byte[] bArr) {
        int i7 = 0;
        while (true) {
            byte[] bArr2 = f17473L;
            if (i7 >= bArr2.length) {
                int i8 = 0;
                while (true) {
                    byte[] bArr3 = f17474M;
                    if (i8 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[f17473L.length + i8 + 4] != bArr3[i8]) {
                        return false;
                    }
                    i8++;
                }
            } else {
                if (bArr[i7] != bArr2[i7]) {
                    return false;
                }
                i7++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x009f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0004, B:6:0x0009, B:13:0x001e, B:15:0x0022, B:16:0x0030, B:18:0x0038, B:20:0x0041, B:31:0x0061, B:21:0x0045, B:23:0x004b, B:26:0x0052, B:29:0x005a, B:30:0x005e, B:32:0x006b, B:34:0x0075, B:37:0x007d, B:40:0x0085, B:43:0x008d, B:47:0x009b, B:49:0x009f), top: B:60:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(java.io.InputStream r5) {
        /*
            r4 = this;
            if (r5 == 0) goto Lb8
            r0 = 0
            r1 = r0
        L4:
            k0.a$e[][] r2 = k0.C2063a.f17497j0     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r2.length     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 >= r2) goto L1e
            java.util.HashMap[] r2 = r4.f17520f     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
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
            boolean r1 = r4.f17519e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 != 0) goto L30
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.i(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.f17518d = r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r5 = r1
        L30:
            int r1 = r4.f17518d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r1 = Y(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 == 0) goto L6b
            k0.a$g r0 = new k0.a$g     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r5 = r4.f17519e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r5 == 0) goto L45
            r4.p(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L45:
            int r5 = r4.f17518d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1 = 12
            if (r5 != r1) goto L4f
            r4.g(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L4f:
            r1 = 7
            if (r5 != r1) goto L56
            r4.j(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L56:
            r1 = 10
            if (r5 != r1) goto L5e
            r4.o(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L5e:
            r4.m(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L61:
            int r5 = r4.f17530p     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            long r1 = (long) r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.K(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.X(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L6b:
            k0.a$b r1 = new k0.a$b     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.f17518d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 4
            if (r5 != r2) goto L79
            r4.h(r1, r0, r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L79:
            r0 = 13
            if (r5 != r0) goto L81
            r4.k(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L81:
            r0 = 9
            if (r5 != r0) goto L89
            r4.l(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L89:
            r0 = 14
            if (r5 != r0) goto L90
            r4.s(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L90:
            r4.a()
            boolean r5 = k0.C2063a.f17509v
            if (r5 == 0) goto Lac
        L97:
            r4.L()
            goto Lac
        L9b:
            boolean r0 = k0.C2063a.f17509v     // Catch: java.lang.Throwable -> L15
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
            boolean r0 = k0.C2063a.f17509v
            if (r0 == 0) goto Lb7
            r4.L()
        Lb7:
            throw r5
        Lb8:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.C2063a.J(java.io.InputStream):void");
    }

    public final void K(b bVar) throws IOException {
        ByteOrder byteOrderM = M(bVar);
        this.f17522h = byteOrderM;
        bVar.G(byteOrderM);
        int unsignedShort = bVar.readUnsignedShort();
        int i7 = this.f17518d;
        if (i7 != 7 && i7 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i8 = bVar.readInt();
        if (i8 < 8) {
            throw new IOException("Invalid first Ifd offset: " + i8);
        }
        int i9 = i8 - 8;
        if (i9 > 0) {
            bVar.H(i9);
        }
    }

    public final void L() {
        for (int i7 = 0; i7 < this.f17520f.length; i7++) {
            Log.d("ExifInterface", "The size of tag group[" + i7 + "]: " + this.f17520f[i7].size());
            for (Map.Entry entry : this.f17520f[i7].entrySet()) {
                d dVar = (d) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + dVar.toString() + ", tagValue: '" + dVar.n(this.f17522h) + "'");
            }
        }
    }

    public final ByteOrder M(b bVar) throws IOException {
        short s7 = bVar.readShort();
        if (s7 == 18761) {
            if (f17509v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s7 == 19789) {
            if (f17509v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s7));
    }

    public final void N(byte[] bArr, int i7) throws IOException {
        g gVar = new g(bArr);
        K(gVar);
        O(gVar, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0280  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(k0.C2063a.g r26, int r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 956
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.C2063a.O(k0.a$g, int):void");
    }

    public final void P(String str) {
        for (int i7 = 0; i7 < f17497j0.length; i7++) {
            this.f17520f[i7].remove(str);
        }
    }

    public final void Q(int i7, String str, String str2) {
        if (this.f17520f[i7].isEmpty() || this.f17520f[i7].get(str) == null) {
            return;
        }
        HashMap map = this.f17520f[i7];
        map.put(str2, map.get(str));
        this.f17520f[i7].remove(str);
    }

    public final void R(g gVar, int i7) throws Throwable {
        d dVar = (d) this.f17520f[i7].get("ImageLength");
        d dVar2 = (d) this.f17520f[i7].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            d dVar3 = (d) this.f17520f[i7].get("JPEGInterchangeFormat");
            d dVar4 = (d) this.f17520f[i7].get("JPEGInterchangeFormatLength");
            if (dVar3 == null || dVar4 == null) {
                return;
            }
            int iM = dVar3.m(this.f17522h);
            int iM2 = dVar3.m(this.f17522h);
            gVar.K(iM);
            byte[] bArr = new byte[iM2];
            gVar.readFully(bArr);
            h(new b(bArr), iM, i7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00f1 A[Catch: all -> 0x0101, Exception -> 0x0104, TryCatch #20 {Exception -> 0x0104, all -> 0x0101, blocks: (B:68:0x00ed, B:70:0x00f1, B:77:0x010e, B:76:0x0106), top: B:120:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0106 A[Catch: all -> 0x0101, Exception -> 0x0104, TryCatch #20 {Exception -> 0x0104, all -> 0x0101, blocks: (B:68:0x00ed, B:70:0x00f1, B:77:0x010e, B:76:0x0106), top: B:120:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void S() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.C2063a.S():void");
    }

    public final void T(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (f17509v) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        cVar.i(-1);
        if (bVar.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        cVar.i(-40);
        d dVar = (d("Xmp") == null || !this.f17535u) ? null : (d) this.f17520f[0].remove("Xmp");
        cVar.i(-1);
        cVar.i(-31);
        c0(cVar);
        if (dVar != null) {
            this.f17520f[0].put("Xmp", dVar);
        }
        byte[] bArr = new byte[4096];
        while (bVar.readByte() == -1) {
            byte b7 = bVar.readByte();
            if (b7 == -39 || b7 == -38) {
                cVar.i(-1);
                cVar.i(b7);
                AbstractC2064b.d(bVar, cVar);
                return;
            }
            if (b7 != -31) {
                cVar.i(-1);
                cVar.i(b7);
                int unsignedShort = bVar.readUnsignedShort();
                cVar.K(unsignedShort);
                int i7 = unsignedShort - 2;
                if (i7 < 0) {
                    throw new IOException("Invalid length");
                }
                while (i7 > 0) {
                    int i8 = bVar.read(bArr, 0, Math.min(i7, 4096));
                    if (i8 >= 0) {
                        cVar.write(bArr, 0, i8);
                        i7 -= i8;
                    }
                }
            } else {
                int unsignedShort2 = bVar.readUnsignedShort();
                int i9 = unsignedShort2 - 2;
                if (i9 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (i9 >= 6) {
                    bVar.readFully(bArr2);
                    if (Arrays.equals(bArr2, f17504q0)) {
                        bVar.H(unsignedShort2 - 8);
                    }
                }
                cVar.i(-1);
                cVar.i(b7);
                cVar.K(unsignedShort2);
                if (i9 >= 6) {
                    i9 = unsignedShort2 - 8;
                    cVar.write(bArr2);
                }
                while (i9 > 0) {
                    int i10 = bVar.read(bArr, 0, Math.min(i9, 4096));
                    if (i10 >= 0) {
                        cVar.write(bArr, 0, i10);
                        i9 -= i10;
                    }
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    public final void U(InputStream inputStream, OutputStream outputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        if (f17509v) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        AbstractC2064b.e(bVar, cVar, f17469H.length);
        if (this.f17530p == 0) {
            int i7 = bVar.readInt();
            cVar.A(i7);
            AbstractC2064b.e(bVar, cVar, i7 + 8);
        } else {
            AbstractC2064b.e(bVar, cVar, (r2 - r7.length) - 8);
            bVar.H(bVar.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            c cVar2 = new c(byteArrayOutputStream, byteOrder);
            c0(cVar2);
            byte[] byteArray = ((ByteArrayOutputStream) cVar2.f17544a).toByteArray();
            cVar.write(byteArray);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArray, 4, byteArray.length - 4);
            cVar.A((int) crc32.getValue());
            AbstractC2064b.b(byteArrayOutputStream);
            AbstractC2064b.d(bVar, cVar);
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            AbstractC2064b.b(byteArrayOutputStream2);
            throw th;
        }
    }

    public final void V(InputStream inputStream, OutputStream outputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        int i7;
        int i8;
        int i9;
        boolean z7;
        if (f17509v) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        b bVar = new b(inputStream, byteOrder);
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = f17473L;
        AbstractC2064b.e(bVar, cVar, bArr.length);
        byte[] bArr2 = f17474M;
        bVar.H(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            c cVar2 = new c(byteArrayOutputStream, byteOrder);
            int i10 = this.f17530p;
            if (i10 != 0) {
                AbstractC2064b.e(bVar, cVar2, (i10 - ((bArr.length + 4) + bArr2.length)) - 8);
                bVar.H(4);
                int i11 = bVar.readInt();
                if (i11 % 2 != 0) {
                    i11++;
                }
                bVar.H(i11);
                c0(cVar2);
            } else {
                byte[] bArr3 = new byte[4];
                bVar.readFully(bArr3);
                byte[] bArr4 = f17477P;
                boolean z8 = true;
                if (Arrays.equals(bArr3, bArr4)) {
                    int i12 = bVar.readInt();
                    byte[] bArr5 = new byte[i12 % 2 == 1 ? i12 + 1 : i12];
                    bVar.readFully(bArr5);
                    byte b7 = (byte) (8 | bArr5[0]);
                    bArr5[0] = b7;
                    boolean z9 = ((b7 >> 1) & 1) == 1;
                    cVar2.write(bArr4);
                    cVar2.A(i12);
                    cVar2.write(bArr5);
                    if (z9) {
                        b(bVar, cVar2, f17480S, null);
                        while (true) {
                            byte[] bArr6 = new byte[4];
                            try {
                                bVar.readFully(bArr6);
                                z7 = !Arrays.equals(bArr6, f17481T);
                            } catch (EOFException unused) {
                                z7 = true;
                            }
                            if (z7) {
                                break;
                            } else {
                                c(bVar, cVar2, bArr6);
                            }
                        }
                        c0(cVar2);
                    } else {
                        b(bVar, cVar2, f17479R, f17478Q);
                        c0(cVar2);
                    }
                } else {
                    byte[] bArr7 = f17479R;
                    if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, f17478Q)) {
                        int i13 = bVar.readInt();
                        int i14 = i13 % 2 == 1 ? i13 + 1 : i13;
                        byte[] bArr8 = new byte[3];
                        if (Arrays.equals(bArr3, bArr7)) {
                            bVar.readFully(bArr8);
                            byte[] bArr9 = new byte[3];
                            bVar.readFully(bArr9);
                            if (!Arrays.equals(f17476O, bArr9)) {
                                throw new IOException("Error checking VP8 signature");
                            }
                            int i15 = bVar.readInt();
                            i9 = (i15 << 2) >> 18;
                            i14 -= 10;
                            i7 = (i15 << 18) >> 18;
                            i8 = i15;
                            z8 = false;
                        } else if (!Arrays.equals(bArr3, f17478Q)) {
                            i7 = 0;
                            z8 = false;
                            i8 = 0;
                            i9 = 0;
                        } else {
                            if (bVar.readByte() != 47) {
                                throw new IOException("Error checking VP8L signature");
                            }
                            i8 = bVar.readInt();
                            i7 = (i8 & 16383) + 1;
                            i9 = ((i8 & 268419072) >>> 14) + 1;
                            if ((i8 & 268435456) == 0) {
                                z8 = false;
                            }
                            i14 -= 5;
                        }
                        cVar2.write(bArr4);
                        cVar2.A(10);
                        byte[] bArr10 = new byte[10];
                        if (z8) {
                            bArr10[0] = (byte) (bArr10[0] | 16);
                        }
                        bArr10[0] = (byte) (bArr10[0] | 8);
                        int i16 = i7 - 1;
                        int i17 = i9 - 1;
                        bArr10[4] = (byte) i16;
                        bArr10[5] = (byte) (i16 >> 8);
                        bArr10[6] = (byte) (i16 >> 16);
                        bArr10[7] = (byte) i17;
                        bArr10[8] = (byte) (i17 >> 8);
                        bArr10[9] = (byte) (i17 >> 16);
                        cVar2.write(bArr10);
                        cVar2.write(bArr3);
                        cVar2.A(i13);
                        if (Arrays.equals(bArr3, bArr7)) {
                            cVar2.write(bArr8);
                            cVar2.write(f17476O);
                            cVar2.A(i8);
                        } else if (Arrays.equals(bArr3, f17478Q)) {
                            cVar2.write(47);
                            cVar2.A(i8);
                        }
                        AbstractC2064b.e(bVar, cVar2, i14);
                        c0(cVar2);
                    }
                }
            }
            AbstractC2064b.d(bVar, cVar2);
            int size = byteArrayOutputStream.size();
            byte[] bArr11 = f17474M;
            cVar.A(size + bArr11.length);
            cVar.write(bArr11);
            byteArrayOutputStream.writeTo(cVar);
            AbstractC2064b.b(byteArrayOutputStream);
        } catch (Exception e8) {
            e = e8;
            byteArrayOutputStream2 = byteArrayOutputStream;
            throw new IOException("Failed to save WebP file", e);
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            AbstractC2064b.b(byteArrayOutputStream2);
            throw th;
        }
    }

    public void W(String str, String str2) {
        e eVar;
        int i7;
        int i8;
        String str3 = str;
        String strReplaceAll = str2;
        if (str3 == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if (("DateTime".equals(str3) || "DateTimeOriginal".equals(str3) || "DateTimeDigitized".equals(str3)) && strReplaceAll != null) {
            boolean zFind = f17508u0.matcher(strReplaceAll).find();
            boolean zFind2 = f17510v0.matcher(strReplaceAll).find();
            if (str2.length() != 19 || (!zFind && !zFind2)) {
                Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                return;
            }
            if (zFind2) {
                strReplaceAll = strReplaceAll.replaceAll("-", Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            }
        }
        if ("ISOSpeedRatings".equals(str3)) {
            if (f17509v) {
                Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str3 = "PhotographicSensitivity";
        }
        int i9 = 2;
        int i10 = 1;
        if (strReplaceAll != null && f17501n0.contains(str3)) {
            if (str3.equals("GPSTimeStamp")) {
                Matcher matcher = f17507t0.matcher(strReplaceAll);
                if (!matcher.find()) {
                    Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
                strReplaceAll = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    strReplaceAll = new f(Double.parseDouble(strReplaceAll)).toString();
                } catch (NumberFormatException unused) {
                    Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
            }
        }
        int i11 = 0;
        int i12 = 0;
        while (i12 < f17497j0.length) {
            if ((i12 != 4 || this.f17523i) && (eVar = (e) f17500m0[i12].get(str3)) != null) {
                if (strReplaceAll != null) {
                    Pair pairT = t(strReplaceAll);
                    int i13 = -1;
                    if (eVar.f17552c == ((Integer) pairT.first).intValue() || eVar.f17552c == ((Integer) pairT.second).intValue()) {
                        i7 = eVar.f17552c;
                    } else {
                        int i14 = eVar.f17553d;
                        if (i14 == -1 || !(i14 == ((Integer) pairT.first).intValue() || eVar.f17553d == ((Integer) pairT.second).intValue())) {
                            int i15 = eVar.f17552c;
                            if (i15 == i10 || i15 == 7 || i15 == i9) {
                                i7 = i15;
                            } else if (f17509v) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Given tag (");
                                sb.append(str3);
                                sb.append(") value didn't match with one of expected formats: ");
                                String[] strArr = f17484W;
                                sb.append(strArr[eVar.f17552c]);
                                sb.append(eVar.f17553d == -1 ? "" : ", " + strArr[eVar.f17553d]);
                                sb.append(" (guess: ");
                                sb.append(strArr[((Integer) pairT.first).intValue()]);
                                sb.append(((Integer) pairT.second).intValue() != -1 ? ", " + strArr[((Integer) pairT.second).intValue()] : "");
                                sb.append(")");
                                Log.d("ExifInterface", sb.toString());
                            }
                        } else {
                            i7 = eVar.f17553d;
                        }
                    }
                    switch (i7) {
                        case 1:
                            i8 = i10;
                            this.f17520f[i12].put(str3, d.a(strReplaceAll));
                            break;
                        case 2:
                        case 7:
                            i8 = i10;
                            this.f17520f[i12].put(str3, d.e(strReplaceAll));
                            break;
                        case 3:
                            i8 = i10;
                            String[] strArrSplit = strReplaceAll.split(com.amazon.a.a.o.b.f.f9989a, -1);
                            int[] iArr = new int[strArrSplit.length];
                            for (int i16 = 0; i16 < strArrSplit.length; i16++) {
                                iArr[i16] = Integer.parseInt(strArrSplit[i16]);
                            }
                            this.f17520f[i12].put(str3, d.k(iArr, this.f17522h));
                            break;
                        case 4:
                            i8 = i10;
                            String[] strArrSplit2 = strReplaceAll.split(com.amazon.a.a.o.b.f.f9989a, -1);
                            long[] jArr = new long[strArrSplit2.length];
                            for (int i17 = 0; i17 < strArrSplit2.length; i17++) {
                                jArr[i17] = Long.parseLong(strArrSplit2[i17]);
                            }
                            this.f17520f[i12].put(str3, d.g(jArr, this.f17522h));
                            break;
                        case 5:
                            String[] strArrSplit3 = strReplaceAll.split(com.amazon.a.a.o.b.f.f9989a, -1);
                            f[] fVarArr = new f[strArrSplit3.length];
                            int i18 = 0;
                            while (i18 < strArrSplit3.length) {
                                String[] strArrSplit4 = strArrSplit3[i18].split("/", i13);
                                fVarArr[i18] = new f((long) Double.parseDouble(strArrSplit4[0]), (long) Double.parseDouble(strArrSplit4[1]));
                                i18++;
                                i13 = -1;
                            }
                            i8 = 1;
                            this.f17520f[i12].put(str3, d.i(fVarArr, this.f17522h));
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            if (f17509v) {
                                Log.d("ExifInterface", "Data format isn't one of expected formats: " + i7);
                            }
                            break;
                        case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            String[] strArrSplit5 = strReplaceAll.split(com.amazon.a.a.o.b.f.f9989a, -1);
                            int[] iArr2 = new int[strArrSplit5.length];
                            for (int i19 = 0; i19 < strArrSplit5.length; i19++) {
                                iArr2[i19] = Integer.parseInt(strArrSplit5[i19]);
                            }
                            this.f17520f[i12].put(str3, d.c(iArr2, this.f17522h));
                            i8 = 1;
                            break;
                        case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            String[] strArrSplit6 = strReplaceAll.split(com.amazon.a.a.o.b.f.f9989a, -1);
                            f[] fVarArr2 = new f[strArrSplit6.length];
                            int i20 = i11;
                            while (i20 < strArrSplit6.length) {
                                String[] strArrSplit7 = strArrSplit6[i20].split("/", -1);
                                fVarArr2[i20] = new f((long) Double.parseDouble(strArrSplit7[i11]), (long) Double.parseDouble(strArrSplit7[i10]));
                                i20++;
                                strArrSplit6 = strArrSplit6;
                                i11 = 0;
                                i10 = 1;
                            }
                            this.f17520f[i12].put(str3, d.d(fVarArr2, this.f17522h));
                            i8 = 1;
                            break;
                        case 12:
                            String[] strArrSplit8 = strReplaceAll.split(com.amazon.a.a.o.b.f.f9989a, -1);
                            double[] dArr = new double[strArrSplit8.length];
                            for (int i21 = i11; i21 < strArrSplit8.length; i21++) {
                                dArr[i21] = Double.parseDouble(strArrSplit8[i21]);
                            }
                            this.f17520f[i12].put(str3, d.b(dArr, this.f17522h));
                            break;
                    }
                } else {
                    this.f17520f[i12].remove(str3);
                }
                i8 = i10;
            } else {
                i8 = i10;
            }
            i12++;
            i10 = i8;
            i9 = 2;
            i11 = 0;
        }
    }

    public final void X(b bVar) throws Throwable {
        HashMap map = this.f17520f[4];
        d dVar = (d) map.get("Compression");
        if (dVar == null) {
            this.f17529o = 6;
            u(bVar, map);
            return;
        }
        int iM = dVar.m(this.f17522h);
        this.f17529o = iM;
        if (iM != 1) {
            if (iM == 6) {
                u(bVar, map);
                return;
            } else if (iM != 7) {
                return;
            }
        }
        if (F(map)) {
            v(bVar, map);
        }
    }

    public final void Z(int i7, int i8) throws Throwable {
        if (this.f17520f[i7].isEmpty() || this.f17520f[i8].isEmpty()) {
            if (f17509v) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        d dVar = (d) this.f17520f[i7].get("ImageLength");
        d dVar2 = (d) this.f17520f[i7].get("ImageWidth");
        d dVar3 = (d) this.f17520f[i8].get("ImageLength");
        d dVar4 = (d) this.f17520f[i8].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            if (f17509v) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (dVar3 == null || dVar4 == null) {
            if (f17509v) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iM = dVar.m(this.f17522h);
        int iM2 = dVar2.m(this.f17522h);
        int iM3 = dVar3.m(this.f17522h);
        int iM4 = dVar4.m(this.f17522h);
        if (iM >= iM3 || iM2 >= iM4) {
            return;
        }
        HashMap[] mapArr = this.f17520f;
        HashMap map = mapArr[i7];
        mapArr[i7] = mapArr[i8];
        mapArr[i8] = map;
    }

    public final void a() {
        String strD = d("DateTimeOriginal");
        if (strD != null && d("DateTime") == null) {
            this.f17520f[0].put("DateTime", d.e(strD));
        }
        if (d("ImageWidth") == null) {
            this.f17520f[0].put("ImageWidth", d.f(0L, this.f17522h));
        }
        if (d("ImageLength") == null) {
            this.f17520f[0].put("ImageLength", d.f(0L, this.f17522h));
        }
        if (d("Orientation") == null) {
            this.f17520f[0].put("Orientation", d.f(0L, this.f17522h));
        }
        if (d("LightSource") == null) {
            this.f17520f[1].put("LightSource", d.f(0L, this.f17522h));
        }
    }

    public final void a0(g gVar, int i7) throws Throwable {
        d dVarJ;
        d dVarJ2;
        d dVar = (d) this.f17520f[i7].get("DefaultCropSize");
        d dVar2 = (d) this.f17520f[i7].get("SensorTopBorder");
        d dVar3 = (d) this.f17520f[i7].get("SensorLeftBorder");
        d dVar4 = (d) this.f17520f[i7].get("SensorBottomBorder");
        d dVar5 = (d) this.f17520f[i7].get("SensorRightBorder");
        if (dVar == null) {
            if (dVar2 == null || dVar3 == null || dVar4 == null || dVar5 == null) {
                R(gVar, i7);
                return;
            }
            int iM = dVar2.m(this.f17522h);
            int iM2 = dVar4.m(this.f17522h);
            int iM3 = dVar5.m(this.f17522h);
            int iM4 = dVar3.m(this.f17522h);
            if (iM2 <= iM || iM3 <= iM4) {
                return;
            }
            d dVarJ3 = d.j(iM2 - iM, this.f17522h);
            d dVarJ4 = d.j(iM3 - iM4, this.f17522h);
            this.f17520f[i7].put("ImageLength", dVarJ3);
            this.f17520f[i7].put("ImageWidth", dVarJ4);
            return;
        }
        if (dVar.f17546a == 5) {
            f[] fVarArr = (f[]) dVar.o(this.f17522h);
            if (fVarArr == null || fVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(fVarArr));
                return;
            }
            dVarJ = d.h(fVarArr[0], this.f17522h);
            dVarJ2 = d.h(fVarArr[1], this.f17522h);
        } else {
            int[] iArr = (int[]) dVar.o(this.f17522h);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            dVarJ = d.j(iArr[0], this.f17522h);
            dVarJ2 = d.j(iArr[1], this.f17522h);
        }
        this.f17520f[i7].put("ImageWidth", dVarJ);
        this.f17520f[i7].put("ImageLength", dVarJ2);
    }

    public final void b(b bVar, c cVar, byte[] bArr, byte[] bArr2) throws IOException {
        while (true) {
            byte[] bArr3 = new byte[4];
            bVar.readFully(bArr3);
            c(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    public final void b0() throws Throwable {
        Z(0, 5);
        Z(0, 4);
        Z(5, 4);
        d dVar = (d) this.f17520f[1].get("PixelXDimension");
        d dVar2 = (d) this.f17520f[1].get("PixelYDimension");
        if (dVar != null && dVar2 != null) {
            this.f17520f[0].put("ImageWidth", dVar);
            this.f17520f[0].put("ImageLength", dVar2);
        }
        if (this.f17520f[4].isEmpty() && H(this.f17520f[5])) {
            HashMap[] mapArr = this.f17520f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!H(this.f17520f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        Q(0, "ThumbnailOrientation", "Orientation");
        Q(0, "ThumbnailImageLength", "ImageLength");
        Q(0, "ThumbnailImageWidth", "ImageWidth");
        Q(5, "ThumbnailOrientation", "Orientation");
        Q(5, "ThumbnailImageLength", "ImageLength");
        Q(5, "ThumbnailImageWidth", "ImageWidth");
        Q(4, "Orientation", "ThumbnailOrientation");
        Q(4, "ImageLength", "ThumbnailImageLength");
        Q(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public final void c(b bVar, c cVar, byte[] bArr) throws IOException {
        int i7 = bVar.readInt();
        cVar.write(bArr);
        cVar.A(i7);
        if (i7 % 2 == 1) {
            i7++;
        }
        AbstractC2064b.e(bVar, cVar, i7);
    }

    public final int c0(c cVar) throws IOException {
        e[][] eVarArr = f17497j0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : f17498k0) {
            P(eVar.f17551b);
        }
        if (this.f17523i) {
            if (this.f17524j) {
                P("StripOffsets");
                P("StripByteCounts");
            } else {
                P("JPEGInterchangeFormat");
                P("JPEGInterchangeFormatLength");
            }
        }
        for (int i7 = 0; i7 < f17497j0.length; i7++) {
            for (Object obj : this.f17520f[i7].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f17520f[i7].remove(entry.getKey());
                }
            }
        }
        if (!this.f17520f[1].isEmpty()) {
            this.f17520f[0].put(f17498k0[1].f17551b, d.f(0L, this.f17522h));
        }
        if (!this.f17520f[2].isEmpty()) {
            this.f17520f[0].put(f17498k0[2].f17551b, d.f(0L, this.f17522h));
        }
        if (!this.f17520f[3].isEmpty()) {
            this.f17520f[1].put(f17498k0[3].f17551b, d.f(0L, this.f17522h));
        }
        if (this.f17523i) {
            if (this.f17524j) {
                this.f17520f[4].put("StripOffsets", d.j(0, this.f17522h));
                this.f17520f[4].put("StripByteCounts", d.j(this.f17527m, this.f17522h));
            } else {
                this.f17520f[4].put("JPEGInterchangeFormat", d.f(0L, this.f17522h));
                this.f17520f[4].put("JPEGInterchangeFormatLength", d.f(this.f17527m, this.f17522h));
            }
        }
        for (int i8 = 0; i8 < f17497j0.length; i8++) {
            Iterator it = this.f17520f[i8].entrySet().iterator();
            int i9 = 0;
            while (it.hasNext()) {
                int iP = ((d) ((Map.Entry) it.next()).getValue()).p();
                if (iP > 4) {
                    i9 += iP;
                }
            }
            iArr2[i8] = iArr2[i8] + i9;
        }
        int size = 8;
        for (int i10 = 0; i10 < f17497j0.length; i10++) {
            if (!this.f17520f[i10].isEmpty()) {
                iArr[i10] = size;
                size += (this.f17520f[i10].size() * 12) + 6 + iArr2[i10];
            }
        }
        if (this.f17523i) {
            if (this.f17524j) {
                this.f17520f[4].put("StripOffsets", d.j(size, this.f17522h));
            } else {
                this.f17520f[4].put("JPEGInterchangeFormat", d.f(size, this.f17522h));
            }
            this.f17526l = size;
            size += this.f17527m;
        }
        if (this.f17518d == 4) {
            size += 8;
        }
        if (f17509v) {
            for (int i11 = 0; i11 < f17497j0.length; i11++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i11), Integer.valueOf(iArr[i11]), Integer.valueOf(this.f17520f[i11].size()), Integer.valueOf(iArr2[i11]), Integer.valueOf(size)));
            }
        }
        if (!this.f17520f[1].isEmpty()) {
            this.f17520f[0].put(f17498k0[1].f17551b, d.f(iArr[1], this.f17522h));
        }
        if (!this.f17520f[2].isEmpty()) {
            this.f17520f[0].put(f17498k0[2].f17551b, d.f(iArr[2], this.f17522h));
        }
        if (!this.f17520f[3].isEmpty()) {
            this.f17520f[1].put(f17498k0[3].f17551b, d.f(iArr[3], this.f17522h));
        }
        int i12 = this.f17518d;
        if (i12 == 4) {
            if (size > 65535) {
                throw new IllegalStateException("Size of exif data (" + size + " bytes) exceeds the max size of a JPEG APP1 segment (65536 bytes)");
            }
            cVar.K(size);
            cVar.write(f17504q0);
        } else if (i12 == 13) {
            cVar.A(size);
            cVar.write(f17470I);
        } else if (i12 == 14) {
            cVar.write(f17475N);
            cVar.A(size);
        }
        cVar.G(this.f17522h == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        cVar.h(this.f17522h);
        cVar.K(42);
        cVar.H(8L);
        for (int i13 = 0; i13 < f17497j0.length; i13++) {
            if (!this.f17520f[i13].isEmpty()) {
                cVar.K(this.f17520f[i13].size());
                int size2 = iArr[i13] + 2 + (this.f17520f[i13].size() * 12) + 4;
                for (Map.Entry entry2 : this.f17520f[i13].entrySet()) {
                    int i14 = ((e) f17500m0[i13].get(entry2.getKey())).f17550a;
                    d dVar = (d) entry2.getValue();
                    int iP2 = dVar.p();
                    cVar.K(i14);
                    cVar.K(dVar.f17546a);
                    cVar.A(dVar.f17547b);
                    if (iP2 > 4) {
                        cVar.H(size2);
                        size2 += iP2;
                    } else {
                        cVar.write(dVar.f17549d);
                        if (iP2 < 4) {
                            while (iP2 < 4) {
                                cVar.i(0);
                                iP2++;
                            }
                        }
                    }
                }
                if (i13 != 0 || this.f17520f[4].isEmpty()) {
                    cVar.H(0L);
                } else {
                    cVar.H(iArr[4]);
                }
                Iterator it2 = this.f17520f[i13].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = ((d) ((Map.Entry) it2.next()).getValue()).f17549d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f17523i) {
            cVar.write(r());
        }
        if (this.f17518d == 14 && size % 2 == 1) {
            cVar.i(0);
        }
        cVar.h(ByteOrder.BIG_ENDIAN);
        return size;
    }

    public String d(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d dVarF = f(str);
        if (dVarF != null) {
            if (!f17501n0.contains(str)) {
                return dVarF.n(this.f17522h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i7 = dVarF.f17546a;
                if (i7 != 5 && i7 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + dVarF.f17546a);
                    return null;
                }
                f[] fVarArr = (f[]) dVarF.o(this.f17522h);
                if (fVarArr == null || fVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr));
                    return null;
                }
                f fVar = fVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (fVar.f17554a / fVar.f17555b));
                f fVar2 = fVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (fVar2.f17554a / fVar2.f17555b));
                f fVar3 = fVarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (fVar3.f17554a / fVar3.f17555b)));
            }
            try {
                return Double.toString(dVarF.l(this.f17522h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int e(String str, int i7) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d dVarF = f(str);
        if (dVarF == null) {
            return i7;
        }
        try {
            return dVarF.m(this.f17522h);
        } catch (NumberFormatException unused) {
            return i7;
        }
    }

    public final d f(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (f17509v) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i7 = 0; i7 < f17497j0.length; i7++) {
            d dVar = (d) this.f17520f[i7].get(str);
            if (dVar != null) {
                return dVar;
            }
        }
        return null;
    }

    public final void g(g gVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                AbstractC2064b.C0268b.a(mediaMetadataRetriever, new C0267a(gVar));
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
                    this.f17520f[0].put("ImageWidth", d.j(Integer.parseInt(strExtractMetadata), this.f17522h));
                }
                if (strExtractMetadata2 != null) {
                    this.f17520f[0].put("ImageLength", d.j(Integer.parseInt(strExtractMetadata2), this.f17522h));
                }
                if (strExtractMetadata3 != null) {
                    int i7 = Integer.parseInt(strExtractMetadata3);
                    this.f17520f[0].put("Orientation", d.j(i7 != 90 ? i7 != 180 ? i7 != 270 ? 1 : 8 : 3 : 6, this.f17522h));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i8 = Integer.parseInt(strExtractMetadata4);
                    int i9 = Integer.parseInt(strExtractMetadata5);
                    if (i9 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    gVar.K(i8);
                    byte[] bArr = new byte[6];
                    gVar.readFully(bArr);
                    int i10 = i8 + 6;
                    int i11 = i9 - 6;
                    if (!Arrays.equals(bArr, f17504q0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i11];
                    gVar.readFully(bArr2);
                    this.f17530p = i10;
                    N(bArr2, 0);
                }
                if (f17509v) {
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

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0186, code lost:
    
        r22.G(r21.f17522h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x018b, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0170 A[LOOP:0: B:10:0x0037->B:59:0x0170, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0177 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(k0.C2063a.b r22, int r23, int r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.C2063a.h(k0.a$b, int, int):void");
    }

    public final int i(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (z(bArr)) {
            return 4;
        }
        if (C(bArr)) {
            return 9;
        }
        if (y(bArr)) {
            return 12;
        }
        if (A(bArr)) {
            return 7;
        }
        if (D(bArr)) {
            return 10;
        }
        if (B(bArr)) {
            return 13;
        }
        return I(bArr) ? 14 : 0;
    }

    public final void j(g gVar) throws Throwable {
        int i7;
        int i8;
        m(gVar);
        d dVar = (d) this.f17520f[1].get("MakerNote");
        if (dVar != null) {
            g gVar2 = new g(dVar.f17549d);
            gVar2.G(this.f17522h);
            byte[] bArr = f17467F;
            byte[] bArr2 = new byte[bArr.length];
            gVar2.readFully(bArr2);
            gVar2.K(0L);
            byte[] bArr3 = f17468G;
            byte[] bArr4 = new byte[bArr3.length];
            gVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                gVar2.K(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                gVar2.K(12L);
            }
            O(gVar2, 6);
            d dVar2 = (d) this.f17520f[7].get("PreviewImageStart");
            d dVar3 = (d) this.f17520f[7].get("PreviewImageLength");
            if (dVar2 != null && dVar3 != null) {
                this.f17520f[5].put("JPEGInterchangeFormat", dVar2);
                this.f17520f[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = (d) this.f17520f[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.o(this.f17522h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i9 = iArr[2];
                int i10 = iArr[0];
                if (i9 <= i10 || (i7 = iArr[3]) <= (i8 = iArr[1])) {
                    return;
                }
                int i11 = (i9 - i10) + 1;
                int i12 = (i7 - i8) + 1;
                if (i11 < i12) {
                    int i13 = i11 + i12;
                    i12 = i13 - i12;
                    i11 = i13 - i12;
                }
                d dVarJ = d.j(i11, this.f17522h);
                d dVarJ2 = d.j(i12, this.f17522h);
                this.f17520f[0].put("ImageWidth", dVarJ);
                this.f17520f[0].put("ImageLength", dVarJ2);
            }
        }
    }

    public final void k(b bVar) throws Throwable {
        if (f17509v) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.G(ByteOrder.BIG_ENDIAN);
        byte[] bArr = f17469H;
        bVar.H(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i7 = bVar.readInt();
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int i8 = length + 8;
                if (i8 == 16 && !Arrays.equals(bArr2, f17471J)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, f17472K)) {
                    return;
                }
                if (Arrays.equals(bArr2, f17470I)) {
                    byte[] bArr3 = new byte[i7];
                    bVar.readFully(bArr3);
                    int i9 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i9) {
                        this.f17530p = i8;
                        N(bArr3, 0);
                        b0();
                        X(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i9 + ", calculated CRC value: " + crc32.getValue());
                }
                int i10 = i7 + 4;
                bVar.H(i10);
                length = i8 + i10;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void l(b bVar) throws Throwable {
        boolean z7 = f17509v;
        if (z7) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.H(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.readFully(bArr);
        bVar.readFully(bArr2);
        bVar.readFully(bArr3);
        int i7 = ByteBuffer.wrap(bArr).getInt();
        int i8 = ByteBuffer.wrap(bArr2).getInt();
        int i9 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i8];
        bVar.H(i7 - bVar.i());
        bVar.readFully(bArr4);
        h(new b(bArr4), i7, 5);
        bVar.H(i9 - bVar.i());
        bVar.G(ByteOrder.BIG_ENDIAN);
        int i10 = bVar.readInt();
        if (z7) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i10);
        }
        for (int i11 = 0; i11 < i10; i11++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == f17492e0.f17550a) {
                short s7 = bVar.readShort();
                short s8 = bVar.readShort();
                d dVarJ = d.j(s7, this.f17522h);
                d dVarJ2 = d.j(s8, this.f17522h);
                this.f17520f[0].put("ImageLength", dVarJ);
                this.f17520f[0].put("ImageWidth", dVarJ2);
                if (f17509v) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s7) + ", width: " + ((int) s8));
                    return;
                }
                return;
            }
            bVar.H(unsignedShort2);
        }
    }

    public final void m(g gVar) throws Throwable {
        d dVar;
        K(gVar);
        O(gVar, 0);
        a0(gVar, 0);
        a0(gVar, 5);
        a0(gVar, 4);
        b0();
        if (this.f17518d != 8 || (dVar = (d) this.f17520f[1].get("MakerNote")) == null) {
            return;
        }
        g gVar2 = new g(dVar.f17549d);
        gVar2.G(this.f17522h);
        gVar2.H(6);
        O(gVar2, 9);
        d dVar2 = (d) this.f17520f[9].get("ColorSpace");
        if (dVar2 != null) {
            this.f17520f[1].put("ColorSpace", dVar2);
        }
    }

    public int n() {
        switch (e("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public final void o(g gVar) throws Throwable {
        if (f17509v) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + gVar);
        }
        m(gVar);
        d dVar = (d) this.f17520f[0].get("JpgFromRaw");
        if (dVar != null) {
            h(new b(dVar.f17549d), (int) dVar.f17548c, 5);
        }
        d dVar2 = (d) this.f17520f[0].get("ISO");
        d dVar3 = (d) this.f17520f[1].get("PhotographicSensitivity");
        if (dVar2 == null || dVar3 != null) {
            return;
        }
        this.f17520f[1].put("PhotographicSensitivity", dVar2);
    }

    public final void p(g gVar) throws IOException {
        byte[] bArr = f17504q0;
        gVar.H(bArr.length);
        byte[] bArr2 = new byte[gVar.available()];
        gVar.readFully(bArr2);
        this.f17530p = bArr.length;
        N(bArr2, 0);
    }

    public byte[] q() {
        int i7 = this.f17529o;
        if (i7 == 6 || i7 == 7) {
            return r();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] r() throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "ExifInterface"
            boolean r1 = r8.f17523i
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            byte[] r1 = r8.f17528n
            if (r1 == 0) goto Ld
            return r1
        Ld:
            android.content.res.AssetManager$AssetInputStream r1 = r8.f17517c     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            if (r1 == 0) goto L2f
            boolean r3 = r1.markSupported()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L21
            if (r3 == 0) goto L26
            r1.reset()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L21
        L1a:
            r3 = r2
            goto L58
        L1c:
            r0 = move-exception
            r3 = r2
        L1e:
            r2 = r1
            goto L90
        L21:
            r3 = move-exception
            r4 = r3
            r3 = r2
            goto L82
        L26:
            java.lang.String r3 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r0, r3)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L21
            k0.AbstractC2064b.b(r1)
            return r2
        L2f:
            java.lang.String r1 = r8.f17515a     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            if (r1 == 0) goto L43
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            java.lang.String r3 = r8.f17515a     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            goto L1a
        L3b:
            r0 = move-exception
            r3 = r2
            goto L90
        L3e:
            r3 = move-exception
            r1 = r2
            r4 = r3
            r3 = r1
            goto L82
        L43:
            java.io.FileDescriptor r1 = r8.f17516b     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            java.io.FileDescriptor r1 = k0.AbstractC2064b.a.b(r1)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            int r3 = android.system.OsConstants.SEEK_SET     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r4 = 0
            k0.AbstractC2064b.a.c(r1, r4, r3)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L7e
            r7 = r3
            r3 = r1
            r1 = r7
        L58:
            k0.a$b r4 = new k0.a$b     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            int r5 = r8.f17526l     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            int r6 = r8.f17530p     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            int r5 = r5 + r6
            r4.H(r5)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            int r5 = r8.f17527m     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r4.readFully(r5)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            r8.f17528n = r5     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            k0.AbstractC2064b.b(r1)
            if (r3 == 0) goto L76
            k0.AbstractC2064b.a(r3)
        L76:
            return r5
        L77:
            r0 = move-exception
            goto L1e
        L79:
            r4 = move-exception
            goto L82
        L7b:
            r0 = move-exception
            r3 = r1
            goto L90
        L7e:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r2
        L82:
            java.lang.String r5 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r0, r5, r4)     // Catch: java.lang.Throwable -> L77
            k0.AbstractC2064b.b(r1)
            if (r3 == 0) goto L8f
            k0.AbstractC2064b.a(r3)
        L8f:
            return r2
        L90:
            k0.AbstractC2064b.b(r2)
            if (r3 == 0) goto L98
            k0.AbstractC2064b.a(r3)
        L98:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.C2063a.r():byte[]");
    }

    public final void s(b bVar) throws Throwable {
        if (f17509v) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.G(ByteOrder.LITTLE_ENDIAN);
        bVar.H(f17473L.length);
        int i7 = bVar.readInt() + 8;
        byte[] bArr = f17474M;
        bVar.H(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int i8 = bVar.readInt();
                int i9 = length + 8;
                if (Arrays.equals(f17475N, bArr2)) {
                    byte[] bArr3 = new byte[i8];
                    bVar.readFully(bArr3);
                    this.f17530p = i9;
                    N(bArr3, 0);
                    X(new b(bArr3));
                    return;
                }
                if (i8 % 2 == 1) {
                    i8++;
                }
                length = i9 + i8;
                if (length == i7) {
                    return;
                }
                if (length > i7) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.H(i8);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void u(b bVar, HashMap map) throws Throwable {
        d dVar = (d) map.get("JPEGInterchangeFormat");
        d dVar2 = (d) map.get("JPEGInterchangeFormatLength");
        if (dVar == null || dVar2 == null) {
            return;
        }
        int iM = dVar.m(this.f17522h);
        int iM2 = dVar2.m(this.f17522h);
        if (this.f17518d == 7) {
            iM += this.f17531q;
        }
        if (iM > 0 && iM2 > 0) {
            this.f17523i = true;
            if (this.f17515a == null && this.f17517c == null && this.f17516b == null) {
                byte[] bArr = new byte[iM2];
                bVar.H(iM);
                bVar.readFully(bArr);
                this.f17528n = bArr;
            }
            this.f17526l = iM;
            this.f17527m = iM2;
        }
        if (f17509v) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iM + ", length: " + iM2);
        }
    }

    public final void v(b bVar, HashMap map) throws IOException {
        byte[] bArr;
        d dVar = (d) map.get("StripOffsets");
        d dVar2 = (d) map.get("StripByteCounts");
        if (dVar == null || dVar2 == null) {
            return;
        }
        long[] jArrC = AbstractC2064b.c(dVar.o(this.f17522h));
        long[] jArrC2 = AbstractC2064b.c(dVar2.o(this.f17522h));
        if (jArrC == null || jArrC.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrC2 == null || jArrC2.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrC.length != jArrC2.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j7 = 0;
        for (long j8 : jArrC2) {
            j7 += j8;
        }
        int i7 = (int) j7;
        byte[] bArr2 = new byte[i7];
        this.f17525k = true;
        this.f17524j = true;
        this.f17523i = true;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < jArrC.length) {
            int i11 = (int) jArrC[i8];
            int i12 = (int) jArrC2[i8];
            if (i8 < jArrC.length - 1) {
                bArr = bArr2;
                if (i11 + i12 != jArrC[i8 + 1]) {
                    this.f17525k = false;
                }
            } else {
                bArr = bArr2;
            }
            int i13 = i11 - i9;
            if (i13 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
                return;
            }
            try {
                bVar.H(i13);
                int i14 = i9 + i13;
                byte[] bArr3 = new byte[i12];
                try {
                    bVar.readFully(bArr3);
                    i9 = i14 + i12;
                    byte[] bArr4 = bArr;
                    System.arraycopy(bArr3, 0, bArr4, i10, i12);
                    i10 += i12;
                    i8++;
                    bArr2 = bArr4;
                } catch (EOFException unused) {
                    Log.d("ExifInterface", "Failed to read " + i12 + " bytes.");
                    return;
                }
            } catch (EOFException unused2) {
                Log.d("ExifInterface", "Failed to skip " + i13 + " bytes.");
                return;
            }
        }
        this.f17528n = bArr2;
        if (this.f17525k) {
            this.f17526l = (int) jArrC[0];
            this.f17527m = i7;
        }
    }

    public final void w(String str) throws Throwable {
        FileInputStream fileInputStream;
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        FileInputStream fileInputStream2 = null;
        this.f17517c = null;
        this.f17515a = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (E(fileInputStream.getFD())) {
                this.f17516b = fileInputStream.getFD();
            } else {
                this.f17516b = null;
            }
            J(fileInputStream);
            AbstractC2064b.b(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            AbstractC2064b.b(fileInputStream2);
            throw th;
        }
    }

    public final boolean y(byte[] bArr) throws Throwable {
        b bVar;
        long j7;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            long length = bVar.readInt();
            byte[] bArr2 = new byte[4];
            bVar.readFully(bArr2);
            if (!Arrays.equals(bArr2, f17464C)) {
                bVar.close();
                return false;
            }
            if (length == 1) {
                length = bVar.readLong();
                j7 = 16;
                if (length < 16) {
                    bVar.close();
                    return false;
                }
            } else {
                j7 = 8;
            }
            if (length > bArr.length) {
                length = bArr.length;
            }
            long j8 = length - j7;
            if (j8 < 8) {
                bVar.close();
                return false;
            }
            byte[] bArr3 = new byte[4];
            boolean z7 = false;
            boolean z8 = false;
            for (long j9 = 0; j9 < j8 / 4; j9++) {
                try {
                    bVar.readFully(bArr3);
                    if (j9 != 1) {
                        if (Arrays.equals(bArr3, f17465D)) {
                            z7 = true;
                        } else if (Arrays.equals(bArr3, f17466E)) {
                            z8 = true;
                        }
                        if (z7 && z8) {
                            bVar.close();
                            return true;
                        }
                    }
                } catch (EOFException unused) {
                    bVar.close();
                    return false;
                }
            }
            bVar.close();
        } catch (Exception e8) {
            e = e8;
            bVar2 = bVar;
            if (f17509v) {
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

    /* JADX INFO: renamed from: k0.a$b */
    public static class b extends InputStream implements DataInput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataInputStream f17539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ByteOrder f17541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f17542d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f17543e;

        public b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
            this.f17543e = bArr.length;
        }

        public long A() {
            return ((long) readInt()) & 4294967295L;
        }

        public void G(ByteOrder byteOrder) {
            this.f17541c = byteOrder;
        }

        public void H(int i7) throws IOException {
            int i8 = 0;
            while (i8 < i7) {
                int i9 = i7 - i8;
                int iSkip = (int) this.f17539a.skip(i9);
                if (iSkip <= 0) {
                    if (this.f17542d == null) {
                        this.f17542d = new byte[8192];
                    }
                    iSkip = this.f17539a.read(this.f17542d, 0, Math.min(8192, i9));
                    if (iSkip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i7 + " bytes.");
                    }
                }
                i8 += iSkip;
            }
            this.f17540b += i8;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f17539a.available();
        }

        public int h() {
            return this.f17543e;
        }

        public int i() {
            return this.f17540b;
        }

        @Override // java.io.InputStream
        public void mark(int i7) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() {
            this.f17540b++;
            return this.f17539a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f17540b++;
            return this.f17539a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.f17540b++;
            int i7 = this.f17539a.read();
            if (i7 >= 0) {
                return (byte) i7;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f17540b += 2;
            return this.f17539a.readChar();
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
        public void readFully(byte[] bArr, int i7, int i8) throws IOException {
            this.f17540b += i8;
            this.f17539a.readFully(bArr, i7, i8);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f17540b += 4;
            int i7 = this.f17539a.read();
            int i8 = this.f17539a.read();
            int i9 = this.f17539a.read();
            int i10 = this.f17539a.read();
            if ((i7 | i8 | i9 | i10) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f17541c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i10 << 24) + (i9 << 16) + (i8 << 8) + i7;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i7 << 24) + (i8 << 16) + (i9 << 8) + i10;
            }
            throw new IOException("Invalid byte order: " + this.f17541c);
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f17540b += 8;
            int i7 = this.f17539a.read();
            int i8 = this.f17539a.read();
            int i9 = this.f17539a.read();
            int i10 = this.f17539a.read();
            int i11 = this.f17539a.read();
            int i12 = this.f17539a.read();
            int i13 = this.f17539a.read();
            int i14 = this.f17539a.read();
            if ((i7 | i8 | i9 | i10 | i11 | i12 | i13 | i14) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f17541c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (((long) i14) << 56) + (((long) i13) << 48) + (((long) i12) << 40) + (((long) i11) << 32) + (((long) i10) << 24) + (((long) i9) << 16) + (((long) i8) << 8) + ((long) i7);
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (((long) i7) << 56) + (((long) i8) << 48) + (((long) i9) << 40) + (((long) i10) << 32) + (((long) i11) << 24) + (((long) i12) << 16) + (((long) i13) << 8) + ((long) i14);
            }
            throw new IOException("Invalid byte order: " + this.f17541c);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.f17540b += 2;
            int i7 = this.f17539a.read();
            int i8 = this.f17539a.read();
            if ((i7 | i8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f17541c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (short) ((i8 << 8) + i7);
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (short) ((i7 << 8) + i8);
            }
            throw new IOException("Invalid byte order: " + this.f17541c);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f17540b += 2;
            return this.f17539a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f17540b++;
            return this.f17539a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f17540b += 2;
            int i7 = this.f17539a.read();
            int i8 = this.f17539a.read();
            if ((i7 | i8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f17541c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i8 << 8) + i7;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i7 << 8) + i8;
            }
            throw new IOException("Invalid byte order: " + this.f17541c);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i7) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) throws IOException {
            int i9 = this.f17539a.read(bArr, i7, i8);
            this.f17540b += i9;
            return i9;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f17540b += bArr.length;
            this.f17539a.readFully(bArr);
        }

        public b(InputStream inputStream, ByteOrder byteOrder) {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f17539a = dataInputStream;
            dataInputStream.mark(0);
            this.f17540b = 0;
            this.f17541c = byteOrder;
            this.f17543e = inputStream instanceof b ? ((b) inputStream).h() : -1;
        }
    }

    /* JADX INFO: renamed from: k0.a$g */
    public static class g extends b {
        public g(byte[] bArr) {
            super(bArr);
            this.f17539a.mark(a.e.API_PRIORITY_OTHER);
        }

        public void K(long j7) throws IOException {
            int i7 = this.f17540b;
            if (i7 > j7) {
                this.f17540b = 0;
                this.f17539a.reset();
            } else {
                j7 -= (long) i7;
            }
            H((int) j7);
        }

        public g(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f17539a.mark(a.e.API_PRIORITY_OTHER);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    /* JADX INFO: renamed from: k0.a$e */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f17553d;

        public e(String str, int i7, int i8) {
            this.f17551b = str;
            this.f17550a = i7;
            this.f17552c = i8;
            this.f17553d = -1;
        }

        public boolean a(int i7) {
            int i8;
            int i9 = this.f17552c;
            if (i9 == 7 || i7 == 7 || i9 == i7 || (i8 = this.f17553d) == i7) {
                return true;
            }
            if ((i9 == 4 || i8 == 4) && i7 == 3) {
                return true;
            }
            if ((i9 == 9 || i8 == 9) && i7 == 8) {
                return true;
            }
            return (i9 == 12 || i8 == 12) && i7 == 11;
        }

        public e(String str, int i7, int i8, int i9) {
            this.f17551b = str;
            this.f17550a = i7;
            this.f17552c = i8;
            this.f17553d = i9;
        }
    }

    public C2063a(InputStream inputStream) {
        this(inputStream, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C2063a(java.io.InputStream r4, int r5) {
        /*
            r3 = this;
            r3.<init>()
            k0.a$e[][] r0 = k0.C2063a.f17497j0
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r3.f17520f = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r3.f17521g = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r3.f17522h = r0
            if (r4 == 0) goto L6a
            r0 = 0
            r3.f17515a = r0
            r1 = 1
            if (r5 != r1) goto L3c
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream
            byte[] r2 = k0.C2063a.f17504q0
            int r2 = r2.length
            r5.<init>(r4, r2)
            boolean r4 = x(r5)
            if (r4 != 0) goto L34
            java.lang.String r4 = "ExifInterface"
            java.lang.String r5 = "Given data does not follow the structure of an Exif-only data."
            android.util.Log.w(r4, r5)
            return
        L34:
            r3.f17519e = r1
            r3.f17517c = r0
            r3.f17516b = r0
            r4 = r5
            goto L66
        L3c:
            boolean r5 = r4 instanceof android.content.res.AssetManager.AssetInputStream
            if (r5 == 0) goto L48
            r5 = r4
            android.content.res.AssetManager$AssetInputStream r5 = (android.content.res.AssetManager.AssetInputStream) r5
            r3.f17517c = r5
            r3.f17516b = r0
            goto L66
        L48:
            boolean r5 = r4 instanceof java.io.FileInputStream
            if (r5 == 0) goto L62
            r5 = r4
            java.io.FileInputStream r5 = (java.io.FileInputStream) r5
            java.io.FileDescriptor r1 = r5.getFD()
            boolean r1 = E(r1)
            if (r1 == 0) goto L62
            r3.f17517c = r0
            java.io.FileDescriptor r5 = r5.getFD()
            r3.f17516b = r5
            goto L66
        L62:
            r3.f17517c = r0
            r3.f17516b = r0
        L66:
            r3.J(r4)
            return
        L6a:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "inputStream cannot be null"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.C2063a.<init>(java.io.InputStream, int):void");
    }

    /* JADX INFO: renamed from: k0.a$a, reason: collision with other inner class name */
    public class C0267a extends MediaDataSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f17536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f17537b;

        public C0267a(g gVar) {
            this.f17537b = gVar;
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j7, byte[] bArr, int i7, int i8) {
            if (i8 == 0) {
                return 0;
            }
            if (j7 < 0) {
                return -1;
            }
            try {
                long j8 = this.f17536a;
                if (j8 != j7) {
                    if (j8 >= 0 && j7 >= j8 + ((long) this.f17537b.available())) {
                        return -1;
                    }
                    this.f17537b.K(j7);
                    this.f17536a = j7;
                }
                if (i8 > this.f17537b.available()) {
                    i8 = this.f17537b.available();
                }
                int i9 = this.f17537b.read(bArr, i7, i8);
                if (i9 >= 0) {
                    this.f17536a += (long) i9;
                    return i9;
                }
            } catch (IOException unused) {
            }
            this.f17536a = -1L;
            return -1;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
