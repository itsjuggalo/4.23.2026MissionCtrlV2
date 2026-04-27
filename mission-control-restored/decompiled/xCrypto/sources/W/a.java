package W;

import W.b;
import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.revenuecat.purchases.common.Constants;
import io.flutter.embedding.android.KeyboardMap;
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

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static SimpleDateFormat f5339U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static SimpleDateFormat f5340V;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static final e[] f5344Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final e[] f5345a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final e[] f5346b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final e[] f5347c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final e[] f5348d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final e f5349e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final e[] f5350f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final e[] f5351g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final e[] f5352h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final e[] f5353i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final e[][] f5354j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final e[] f5355k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final HashMap[] f5356l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final HashMap[] f5357m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final HashSet f5358n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final HashMap f5359o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final Charset f5360p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final byte[] f5361q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final byte[] f5362r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final Pattern f5363s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final Pattern f5364t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final Pattern f5365u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final Pattern f5367v0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileDescriptor f5373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AssetManager.AssetInputStream f5374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap[] f5377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set f5378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ByteOrder f5379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5382k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5383l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5384m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f5385n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5386o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5387p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5388q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f5389r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5390s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f5391t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f5392u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f5366v = Log.isLoggable("ExifInterface", 3);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final List f5368w = Arrays.asList(1, 6, 3, 8);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final List f5369x = Arrays.asList(2, 7, 4, 5);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f5370y = {8, 8, 8};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f5371z = {4};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final int[] f5319A = {8};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final byte[] f5320B = {-1, -40, -1};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final byte[] f5321C = {102, 116, 121, 112};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final byte[] f5322D = {109, 105, 102, 49};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final byte[] f5323E = {104, 101, 105, 99};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final byte[] f5324F = {79, 76, 89, 77, 80, 0};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final byte[] f5325G = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final byte[] f5326H = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final byte[] f5327I = {101, 88, 73, 102};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final byte[] f5328J = {73, 72, 68, 82};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final byte[] f5329K = {73, 69, 78, 68};

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final byte[] f5330L = {82, 73, 70, 70};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final byte[] f5331M = {87, 69, 66, 80};

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final byte[] f5332N = {69, 88, 73, 70};

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final byte[] f5333O = {-99, 1, 42};

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final byte[] f5334P = "VP8X".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final byte[] f5335Q = "VP8L".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final byte[] f5336R = "VP8 ".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final byte[] f5337S = "ANIM".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final byte[] f5338T = "ANMF".getBytes(Charset.defaultCharset());

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final String[] f5341W = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static final int[] f5342X = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static final byte[] f5343Y = {65, 83, 67, 73, 73, 0, 0, 0};

    public static class b extends InputStream implements DataInput {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final ByteOrder f5396e = ByteOrder.LITTLE_ENDIAN;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final ByteOrder f5397f = ByteOrder.BIG_ENDIAN;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataInputStream f5398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteOrder f5399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f5401d;

        public b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f5398a.available();
        }

        public int e() {
            return this.f5400c;
        }

        public long f() {
            return ((long) readInt()) & KeyboardMap.kValueMask;
        }

        public void g(ByteOrder byteOrder) {
            this.f5399b = byteOrder;
        }

        @Override // java.io.InputStream
        public void mark(int i4) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public void p(int i4) throws IOException {
            int i5 = 0;
            while (i5 < i4) {
                int i6 = i4 - i5;
                int iSkip = (int) this.f5398a.skip(i6);
                if (iSkip <= 0) {
                    if (this.f5401d == null) {
                        this.f5401d = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                    }
                    iSkip = this.f5398a.read(this.f5401d, 0, Math.min(UserMetadata.MAX_INTERNAL_KEY_SIZE, i6));
                    if (iSkip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i4 + " bytes.");
                    }
                }
                i5 += iSkip;
            }
            this.f5400c += i5;
        }

        @Override // java.io.InputStream
        public int read() {
            this.f5400c++;
            return this.f5398a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f5400c++;
            return this.f5398a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.f5400c++;
            int i4 = this.f5398a.read();
            if (i4 >= 0) {
                return (byte) i4;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f5400c += 2;
            return this.f5398a.readChar();
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
        public void readFully(byte[] bArr, int i4, int i5) throws IOException {
            this.f5400c += i5;
            this.f5398a.readFully(bArr, i4, i5);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f5400c += 4;
            int i4 = this.f5398a.read();
            int i5 = this.f5398a.read();
            int i6 = this.f5398a.read();
            int i7 = this.f5398a.read();
            if ((i4 | i5 | i6 | i7) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f5399b;
            if (byteOrder == f5396e) {
                return (i7 << 24) + (i6 << 16) + (i5 << 8) + i4;
            }
            if (byteOrder == f5397f) {
                return (i4 << 24) + (i5 << 16) + (i6 << 8) + i7;
            }
            throw new IOException("Invalid byte order: " + this.f5399b);
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f5400c += 8;
            int i4 = this.f5398a.read();
            int i5 = this.f5398a.read();
            int i6 = this.f5398a.read();
            int i7 = this.f5398a.read();
            int i8 = this.f5398a.read();
            int i9 = this.f5398a.read();
            int i10 = this.f5398a.read();
            int i11 = this.f5398a.read();
            if ((i4 | i5 | i6 | i7 | i8 | i9 | i10 | i11) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f5399b;
            if (byteOrder == f5396e) {
                return (((long) i11) << 56) + (((long) i10) << 48) + (((long) i9) << 40) + (((long) i8) << 32) + (((long) i7) << 24) + (((long) i6) << 16) + (((long) i5) << 8) + ((long) i4);
            }
            if (byteOrder == f5397f) {
                return (((long) i4) << 56) + (((long) i5) << 48) + (((long) i6) << 40) + (((long) i7) << 32) + (((long) i8) << 24) + (((long) i9) << 16) + (((long) i10) << 8) + ((long) i11);
            }
            throw new IOException("Invalid byte order: " + this.f5399b);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.f5400c += 2;
            int i4 = this.f5398a.read();
            int i5 = this.f5398a.read();
            if ((i4 | i5) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f5399b;
            if (byteOrder == f5396e) {
                return (short) ((i5 << 8) + i4);
            }
            if (byteOrder == f5397f) {
                return (short) ((i4 << 8) + i5);
            }
            throw new IOException("Invalid byte order: " + this.f5399b);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f5400c += 2;
            return this.f5398a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f5400c++;
            return this.f5398a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f5400c += 2;
            int i4 = this.f5398a.read();
            int i5 = this.f5398a.read();
            if ((i4 | i5) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f5399b;
            if (byteOrder == f5396e) {
                return (i5 << 8) + i4;
            }
            if (byteOrder == f5397f) {
                return (i4 << 8) + i5;
            }
            throw new IOException("Invalid byte order: " + this.f5399b);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i4) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public b(InputStream inputStream, ByteOrder byteOrder) {
            this.f5399b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f5398a = dataInputStream;
            dataInputStream.mark(0);
            this.f5400c = 0;
            this.f5399b = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) throws IOException {
            int i6 = this.f5398a.read(bArr, i4, i5);
            this.f5400c += i6;
            return i6;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f5400c += bArr.length;
            this.f5398a.readFully(bArr);
        }
    }

    public static class c extends FilterOutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f5402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteOrder f5403b;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f5402a = outputStream;
            this.f5403b = byteOrder;
        }

        public void A(int i4) throws IOException {
            p((short) i4);
        }

        public void e(ByteOrder byteOrder) {
            this.f5403b = byteOrder;
        }

        public void f(int i4) throws IOException {
            this.f5402a.write(i4);
        }

        public void g(int i4) throws IOException {
            ByteOrder byteOrder = this.f5403b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f5402a.write(i4 & 255);
                this.f5402a.write((i4 >>> 8) & 255);
                this.f5402a.write((i4 >>> 16) & 255);
                this.f5402a.write((i4 >>> 24) & 255);
                return;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f5402a.write((i4 >>> 24) & 255);
                this.f5402a.write((i4 >>> 16) & 255);
                this.f5402a.write((i4 >>> 8) & 255);
                this.f5402a.write(i4 & 255);
            }
        }

        public void p(short s4) throws IOException {
            ByteOrder byteOrder = this.f5403b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f5402a.write(s4 & 255);
                this.f5402a.write((s4 >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f5402a.write((s4 >>> 8) & 255);
                this.f5402a.write(s4 & 255);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f5402a.write(bArr);
        }

        public void x(long j4) throws IOException {
            g((int) j4);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i4, int i5) throws IOException {
            this.f5402a.write(bArr, i4, i5);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f5406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f5407d;

        public d(int i4, int i5, byte[] bArr) {
            this(i4, i5, -1L, bArr);
        }

        public static d a(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(a.f5360p0);
            return new d(1, bytes.length, bytes);
        }

        public static d b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f5342X[12] * dArr.length]);
            byteBufferWrap.order(byteOrder);
            for (double d4 : dArr) {
                byteBufferWrap.putDouble(d4);
            }
            return new d(12, dArr.length, byteBufferWrap.array());
        }

        public static d c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f5342X[9] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i4 : iArr) {
                byteBufferWrap.putInt(i4);
            }
            return new d(9, iArr.length, byteBufferWrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f5342X[10] * fVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (f fVar : fVarArr) {
                byteBufferWrap.putInt((int) fVar.f5412a);
                byteBufferWrap.putInt((int) fVar.f5413b);
            }
            return new d(10, fVarArr.length, byteBufferWrap.array());
        }

        public static d e(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f5360p0);
            return new d(2, bytes.length, bytes);
        }

        public static d f(long j4, ByteOrder byteOrder) {
            return g(new long[]{j4}, byteOrder);
        }

        public static d g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f5342X[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j4 : jArr) {
                byteBufferWrap.putInt((int) j4);
            }
            return new d(4, jArr.length, byteBufferWrap.array());
        }

        public static d h(f fVar, ByteOrder byteOrder) {
            return i(new f[]{fVar}, byteOrder);
        }

        public static d i(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f5342X[5] * fVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (f fVar : fVarArr) {
                byteBufferWrap.putInt((int) fVar.f5412a);
                byteBufferWrap.putInt((int) fVar.f5413b);
            }
            return new d(5, fVarArr.length, byteBufferWrap.array());
        }

        public static d j(int i4, ByteOrder byteOrder) {
            return k(new int[]{i4}, byteOrder);
        }

        public static d k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.f5342X[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i4 : iArr) {
                byteBufferWrap.putShort((short) i4);
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
            int i4 = 0;
            if (objO instanceof long[]) {
                long[] jArr = (long[]) objO;
                while (i4 < jArr.length) {
                    sb.append(jArr[i4]);
                    i4++;
                    if (i4 != jArr.length) {
                        sb.append(com.amazon.a.a.o.b.f.f8804a);
                    }
                }
                return sb.toString();
            }
            if (objO instanceof int[]) {
                int[] iArr = (int[]) objO;
                while (i4 < iArr.length) {
                    sb.append(iArr[i4]);
                    i4++;
                    if (i4 != iArr.length) {
                        sb.append(com.amazon.a.a.o.b.f.f8804a);
                    }
                }
                return sb.toString();
            }
            if (objO instanceof double[]) {
                double[] dArr = (double[]) objO;
                while (i4 < dArr.length) {
                    sb.append(dArr[i4]);
                    i4++;
                    if (i4 != dArr.length) {
                        sb.append(com.amazon.a.a.o.b.f.f8804a);
                    }
                }
                return sb.toString();
            }
            if (!(objO instanceof f[])) {
                return null;
            }
            f[] fVarArr = (f[]) objO;
            while (i4 < fVarArr.length) {
                sb.append(fVarArr[i4].f5412a);
                sb.append('/');
                sb.append(fVarArr[i4].f5413b);
                i4++;
                if (i4 != fVarArr.length) {
                    sb.append(com.amazon.a.a.o.b.f.f8804a);
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
            throw new UnsupportedOperationException("Method not decompiled: W.a.d.o(java.nio.ByteOrder):java.lang.Object");
        }

        public int p() {
            return a.f5342X[this.f5404a] * this.f5405b;
        }

        public String toString() {
            return "(" + a.f5341W[this.f5404a] + ", data length:" + this.f5407d.length + ")";
        }

        public d(int i4, int i5, long j4, byte[] bArr) {
            this.f5404a = i4;
            this.f5405b = i5;
            this.f5406c = j4;
            this.f5407d = bArr;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f5413b;

        public f(double d4) {
            this((long) (d4 * 10000.0d), 10000L);
        }

        public double a() {
            return this.f5412a / this.f5413b;
        }

        public String toString() {
            return this.f5412a + RemoteSettings.FORWARD_SLASH_STRING + this.f5413b;
        }

        public f(long j4, long j5) {
            if (j5 == 0) {
                this.f5412a = 0L;
                this.f5413b = 1L;
            } else {
                this.f5412a = j4;
                this.f5413b = j5;
            }
        }
    }

    static {
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        f5344Z = eVarArr;
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f5345a0 = eVarArr2;
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5, 10), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5, 10), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        f5346b0 = eVarArr3;
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        f5347c0 = eVarArr4;
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Xmp", 700, 1), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f5348d0 = eVarArr5;
        f5349e0 = new e("StripOffsets", 273, 3);
        e[] eVarArr6 = {new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
        f5350f0 = eVarArr6;
        e[] eVarArr7 = {new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)};
        f5351g0 = eVarArr7;
        e[] eVarArr8 = {new e("AspectFrame", 4371, 3)};
        f5352h0 = eVarArr8;
        e[] eVarArr9 = {new e("ColorSpace", 55, 3)};
        f5353i0 = eVarArr9;
        e[][] eVarArr10 = {eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, eVarArr6, eVarArr7, eVarArr8, eVarArr9};
        f5354j0 = eVarArr10;
        f5355k0 = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        f5356l0 = new HashMap[eVarArr10.length];
        f5357m0 = new HashMap[eVarArr10.length];
        f5358n0 = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f5359o0 = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        f5360p0 = charsetForName;
        f5361q0 = "Exif\u0000\u0000".getBytes(charsetForName);
        f5362r0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        f5339U = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        f5340V = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i4 = 0;
        while (true) {
            e[][] eVarArr11 = f5354j0;
            if (i4 >= eVarArr11.length) {
                HashMap map = f5359o0;
                e[] eVarArr12 = f5355k0;
                map.put(Integer.valueOf(eVarArr12[0].f5408a), 5);
                map.put(Integer.valueOf(eVarArr12[1].f5408a), 1);
                map.put(Integer.valueOf(eVarArr12[2].f5408a), 2);
                map.put(Integer.valueOf(eVarArr12[3].f5408a), 3);
                map.put(Integer.valueOf(eVarArr12[4].f5408a), 7);
                map.put(Integer.valueOf(eVarArr12[5].f5408a), 8);
                f5363s0 = Pattern.compile(".*[1-9].*");
                f5364t0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f5365u0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f5367v0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f5356l0[i4] = new HashMap();
            f5357m0[i4] = new HashMap();
            for (e eVar : eVarArr11[i4]) {
                f5356l0[i4].put(Integer.valueOf(eVar.f5408a), eVar);
                f5357m0[i4].put(eVar.f5409b, eVar);
            }
            i4++;
        }
    }

    public a(String str) throws Throwable {
        e[][] eVarArr = f5354j0;
        this.f5377f = new HashMap[eVarArr.length];
        this.f5378g = new HashSet(eVarArr.length);
        this.f5379h = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        w(str);
    }

    public static boolean E(FileDescriptor fileDescriptor) {
        try {
            b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!f5366v) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    public static boolean G(int i4) {
        return i4 == 4 || i4 == 13 || i4 == 14 || i4 == 3 || i4 == 0;
    }

    public static boolean Y(int i4) {
        return (i4 == 4 || i4 == 9 || i4 == 13 || i4 == 14) ? false : true;
    }

    public static Pair t(String str) {
        if (str.contains(com.amazon.a.a.o.b.f.f8804a)) {
            String[] strArrSplit = str.split(com.amazon.a.a.o.b.f.f8804a, -1);
            Pair pairT = t(strArrSplit[0]);
            if (((Integer) pairT.first).intValue() == 2) {
                return pairT;
            }
            for (int i4 = 1; i4 < strArrSplit.length; i4++) {
                Pair pairT2 = t(strArrSplit[i4]);
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
        if (!str.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
            try {
                try {
                    long j4 = Long.parseLong(str);
                    return (j4 < 0 || j4 > 65535) ? j4 < 0 ? new Pair(9, -1) : new Pair(4, -1) : new Pair(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair(12, -1);
            }
        }
        String[] strArrSplit2 = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        if (strArrSplit2.length == 2) {
            try {
                long j5 = (long) Double.parseDouble(strArrSplit2[0]);
                long j6 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j5 >= 0 && j6 >= 0) {
                    if (j5 <= 2147483647L && j6 <= 2147483647L) {
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
        byte[] bArr = f5361q0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i4 = 0;
        while (true) {
            byte[] bArr3 = f5361q0;
            if (i4 >= bArr3.length) {
                return true;
            }
            if (bArr2[i4] != bArr3[i4]) {
                return false;
            }
            i4++;
        }
    }

    public static boolean z(byte[] bArr) {
        int i4 = 0;
        while (true) {
            byte[] bArr2 = f5320B;
            if (i4 >= bArr2.length) {
                return true;
            }
            if (bArr[i4] != bArr2[i4]) {
                return false;
            }
            i4++;
        }
    }

    public final boolean A(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderM = M(bVar2);
                this.f5379h = byteOrderM;
                bVar2.g(byteOrderM);
                short s4 = bVar2.readShort();
                boolean z4 = s4 == 20306 || s4 == 21330;
                bVar2.close();
                return z4;
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
        int i4 = 0;
        while (true) {
            byte[] bArr2 = f5326H;
            if (i4 >= bArr2.length) {
                return true;
            }
            if (bArr[i4] != bArr2[i4]) {
                return false;
            }
            i4++;
        }
    }

    public final boolean C(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i4 = 0; i4 < bytes.length; i4++) {
            if (bArr[i4] != bytes[i4]) {
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
                this.f5379h = byteOrderM;
                bVar2.g(byteOrderM);
                boolean z4 = bVar2.readShort() == 85;
                bVar2.close();
                return z4;
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
            int[] iArr = (int[]) dVar2.o(this.f5379h);
            int[] iArr2 = f5370y;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f5375d == 3 && (dVar = (d) map.get("PhotometricInterpretation")) != null && (((iM = dVar.m(this.f5379h)) == 1 && Arrays.equals(iArr, f5319A)) || (iM == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f5366v) {
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
        return dVar.m(this.f5379h) <= 512 && dVar2.m(this.f5379h) <= 512;
    }

    public final boolean I(byte[] bArr) {
        int i4 = 0;
        while (true) {
            byte[] bArr2 = f5330L;
            if (i4 >= bArr2.length) {
                int i5 = 0;
                while (true) {
                    byte[] bArr3 = f5331M;
                    if (i5 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[f5330L.length + i5 + 4] != bArr3[i5]) {
                        return false;
                    }
                    i5++;
                }
            } else {
                if (bArr[i4] != bArr2[i4]) {
                    return false;
                }
                i4++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x009f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0004, B:6:0x0009, B:13:0x001e, B:15:0x0022, B:16:0x0030, B:18:0x0038, B:20:0x0041, B:31:0x0061, B:21:0x0045, B:23:0x004b, B:26:0x0052, B:29:0x005a, B:30:0x005e, B:32:0x006b, B:34:0x0075, B:37:0x007d, B:40:0x0085, B:43:0x008d, B:48:0x009b, B:50:0x009f), top: B:61:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(java.io.InputStream r5) {
        /*
            r4 = this;
            if (r5 == 0) goto Lba
            r0 = 0
            r1 = r0
        L4:
            W.a$e[][] r2 = W.a.f5354j0     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r2.length     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 >= r2) goto L1e
            java.util.HashMap[] r2 = r4.f5377f     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3.<init>()     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2[r1] = r3     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r1 = r1 + 1
            goto L4
        L15:
            r5 = move-exception
            goto Laf
        L18:
            r5 = move-exception
            goto L9b
        L1b:
            r5 = move-exception
            goto L9b
        L1e:
            boolean r1 = r4.f5376e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 != 0) goto L30
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.i(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.f5375d = r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r5 = r1
        L30:
            int r1 = r4.f5375d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r1 = Y(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 == 0) goto L6b
            W.a$g r0 = new W.a$g     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r5 = r4.f5376e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r5 == 0) goto L45
            r4.p(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L45:
            int r5 = r4.f5375d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
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
            int r5 = r4.f5387p     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            long r1 = (long) r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.x(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.X(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L6b:
            W.a$b r1 = new W.a$b     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.f5375d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
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
            boolean r5 = W.a.f5366v
            if (r5 == 0) goto Lae
            r4.L()
            return
        L9b:
            boolean r0 = W.a.f5366v     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto La6
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r5)     // Catch: java.lang.Throwable -> L15
        La6:
            r4.a()
            if (r0 == 0) goto Lae
            r4.L()
        Lae:
            return
        Laf:
            r4.a()
            boolean r0 = W.a.f5366v
            if (r0 == 0) goto Lb9
            r4.L()
        Lb9:
            throw r5
        Lba:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: W.a.J(java.io.InputStream):void");
    }

    public final void K(b bVar) throws IOException {
        ByteOrder byteOrderM = M(bVar);
        this.f5379h = byteOrderM;
        bVar.g(byteOrderM);
        int unsignedShort = bVar.readUnsignedShort();
        int i4 = this.f5375d;
        if (i4 != 7 && i4 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i5 = bVar.readInt();
        if (i5 < 8) {
            throw new IOException("Invalid first Ifd offset: " + i5);
        }
        int i6 = i5 - 8;
        if (i6 > 0) {
            bVar.p(i6);
        }
    }

    public final void L() {
        for (int i4 = 0; i4 < this.f5377f.length; i4++) {
            Log.d("ExifInterface", "The size of tag group[" + i4 + "]: " + this.f5377f[i4].size());
            for (Map.Entry entry : this.f5377f[i4].entrySet()) {
                d dVar = (d) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + dVar.toString() + ", tagValue: '" + dVar.n(this.f5379h) + "'");
            }
        }
    }

    public final ByteOrder M(b bVar) throws IOException {
        short s4 = bVar.readShort();
        if (s4 == 18761) {
            if (f5366v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s4 == 19789) {
            if (f5366v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s4));
    }

    public final void N(byte[] bArr, int i4) throws IOException {
        g gVar = new g(bArr);
        K(gVar);
        O(gVar, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0279  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(W.a.g r26, int r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W.a.O(W.a$g, int):void");
    }

    public final void P(String str) {
        for (int i4 = 0; i4 < f5354j0.length; i4++) {
            this.f5377f[i4].remove(str);
        }
    }

    public final void Q(int i4, String str, String str2) {
        if (this.f5377f[i4].isEmpty() || this.f5377f[i4].get(str) == null) {
            return;
        }
        HashMap map = this.f5377f[i4];
        map.put(str2, map.get(str));
        this.f5377f[i4].remove(str);
    }

    public final void R(g gVar, int i4) throws Throwable {
        d dVar = (d) this.f5377f[i4].get("ImageLength");
        d dVar2 = (d) this.f5377f[i4].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            d dVar3 = (d) this.f5377f[i4].get("JPEGInterchangeFormat");
            d dVar4 = (d) this.f5377f[i4].get("JPEGInterchangeFormatLength");
            if (dVar3 == null || dVar4 == null) {
                return;
            }
            int iM = dVar3.m(this.f5379h);
            int iM2 = dVar3.m(this.f5379h);
            gVar.x(iM);
            byte[] bArr = new byte[iM2];
            gVar.read(bArr);
            h(new b(bArr), iM, i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0101 A[Catch: all -> 0x0111, Exception -> 0x0114, TryCatch #17 {Exception -> 0x0114, all -> 0x0111, blocks: (B:72:0x00fd, B:74:0x0101, B:81:0x011e, B:80:0x0116), top: B:130:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0116 A[Catch: all -> 0x0111, Exception -> 0x0114, TryCatch #17 {Exception -> 0x0114, all -> 0x0111, blocks: (B:72:0x00fd, B:74:0x0101, B:81:0x011e, B:80:0x0116), top: B:130:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void S() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W.a.S():void");
    }

    public final void T(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (f5366v) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        cVar.f(-1);
        if (bVar.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        cVar.f(-40);
        d dVar = (d("Xmp") == null || !this.f5392u) ? null : (d) this.f5377f[0].remove("Xmp");
        cVar.f(-1);
        cVar.f(-31);
        c0(cVar);
        if (dVar != null) {
            this.f5377f[0].put("Xmp", dVar);
        }
        byte[] bArr = new byte[4096];
        while (bVar.readByte() == -1) {
            byte b4 = bVar.readByte();
            if (b4 == -39 || b4 == -38) {
                cVar.f(-1);
                cVar.f(b4);
                W.b.e(bVar, cVar);
                return;
            }
            if (b4 != -31) {
                cVar.f(-1);
                cVar.f(b4);
                int unsignedShort = bVar.readUnsignedShort();
                cVar.A(unsignedShort);
                int i4 = unsignedShort - 2;
                if (i4 < 0) {
                    throw new IOException("Invalid length");
                }
                while (i4 > 0) {
                    int i5 = bVar.read(bArr, 0, Math.min(i4, 4096));
                    if (i5 >= 0) {
                        cVar.write(bArr, 0, i5);
                        i4 -= i5;
                    }
                }
            } else {
                int unsignedShort2 = bVar.readUnsignedShort();
                int i6 = unsignedShort2 - 2;
                if (i6 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (i6 >= 6) {
                    if (bVar.read(bArr2) != 6) {
                        throw new IOException("Invalid exif");
                    }
                    if (Arrays.equals(bArr2, f5361q0)) {
                        bVar.p(unsignedShort2 - 8);
                    }
                }
                cVar.f(-1);
                cVar.f(b4);
                cVar.A(unsignedShort2);
                if (i6 >= 6) {
                    i6 = unsignedShort2 - 8;
                    cVar.write(bArr2);
                }
                while (i6 > 0) {
                    int i7 = bVar.read(bArr, 0, Math.min(i6, 4096));
                    if (i7 >= 0) {
                        cVar.write(bArr, 0, i7);
                        i6 -= i7;
                    }
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    public final void U(InputStream inputStream, OutputStream outputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        if (f5366v) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        W.b.f(bVar, cVar, f5326H.length);
        if (this.f5387p == 0) {
            int i4 = bVar.readInt();
            cVar.g(i4);
            W.b.f(bVar, cVar, i4 + 8);
        } else {
            W.b.f(bVar, cVar, (r2 - r7.length) - 8);
            bVar.p(bVar.readInt() + 8);
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
            byte[] byteArray = ((ByteArrayOutputStream) cVar2.f5402a).toByteArray();
            cVar.write(byteArray);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArray, 4, byteArray.length - 4);
            cVar.g((int) crc32.getValue());
            W.b.c(byteArrayOutputStream);
            W.b.e(bVar, cVar);
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            W.b.c(byteArrayOutputStream2);
            throw th;
        }
    }

    public final void V(InputStream inputStream, OutputStream outputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        char c4;
        int i4;
        int i5;
        int i6;
        int i7;
        if (f5366v) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        b bVar = new b(inputStream, byteOrder);
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = f5330L;
        W.b.f(bVar, cVar, bArr.length);
        byte[] bArr2 = f5331M;
        bVar.p(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e4) {
            e = e4;
        }
        try {
            c cVar2 = new c(byteArrayOutputStream, byteOrder);
            int i8 = this.f5387p;
            if (i8 != 0) {
                W.b.f(bVar, cVar2, (i8 - ((bArr.length + 4) + bArr2.length)) - 8);
                bVar.p(4);
                bVar.p(bVar.readInt());
                c0(cVar2);
            } else {
                byte[] bArr3 = new byte[4];
                if (bVar.read(bArr3) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunk type");
                }
                byte[] bArr4 = f5334P;
                if (Arrays.equals(bArr3, bArr4)) {
                    int i9 = bVar.readInt();
                    byte[] bArr5 = new byte[i9 % 2 == 1 ? i9 + 1 : i9];
                    bVar.read(bArr5);
                    byte b4 = (byte) (8 | bArr5[0]);
                    bArr5[0] = b4;
                    boolean z4 = ((b4 >> 1) & 1) == 1;
                    cVar2.write(bArr4);
                    cVar2.g(i9);
                    cVar2.write(bArr5);
                    if (z4) {
                        b(bVar, cVar2, f5337S, null);
                        while (true) {
                            byte[] bArr6 = new byte[4];
                            inputStream.read(bArr6);
                            if (!Arrays.equals(bArr6, f5338T)) {
                                break;
                            } else {
                                c(bVar, cVar2, bArr6);
                            }
                        }
                        c0(cVar2);
                    } else {
                        b(bVar, cVar2, f5336R, f5335Q);
                        c0(cVar2);
                    }
                } else {
                    byte[] bArr7 = f5336R;
                    if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, f5335Q)) {
                        int i10 = bVar.readInt();
                        int i11 = i10 % 2 == 1 ? i10 + 1 : i10;
                        byte[] bArr8 = new byte[3];
                        if (Arrays.equals(bArr3, bArr7)) {
                            bVar.read(bArr8);
                            byte[] bArr9 = new byte[3];
                            c4 = '\b';
                            if (bVar.read(bArr9) != 3 || !Arrays.equals(f5333O, bArr9)) {
                                throw new IOException("Encountered error while checking VP8 signature");
                            }
                            i4 = bVar.readInt();
                            i5 = (i4 << 18) >> 18;
                            i6 = (i4 << 2) >> 18;
                            i11 -= 10;
                            i7 = 0;
                        } else {
                            c4 = '\b';
                            if (!Arrays.equals(bArr3, f5335Q)) {
                                i4 = 0;
                                i5 = 0;
                                i6 = 0;
                                i7 = 0;
                            } else {
                                if (bVar.readByte() != 47) {
                                    throw new IOException("Encountered error while checking VP8L signature");
                                }
                                i4 = bVar.readInt();
                                i7 = i4 & 8;
                                i11 -= 5;
                                i6 = ((i4 << 4) >> 18) + 1;
                                i5 = ((i4 << 18) >> 18) + 1;
                            }
                        }
                        cVar2.write(bArr4);
                        cVar2.g(10);
                        byte[] bArr10 = new byte[10];
                        byte b5 = (byte) (bArr10[0] | 8);
                        bArr10[0] = b5;
                        bArr10[0] = (byte) (b5 | (i7 << 4));
                        int i12 = i5 - 1;
                        int i13 = i6 - 1;
                        bArr10[4] = (byte) i12;
                        bArr10[5] = (byte) (i12 >> 8);
                        bArr10[6] = (byte) (i12 >> 16);
                        bArr10[7] = (byte) i13;
                        bArr10[c4] = (byte) (i13 >> 8);
                        bArr10[9] = (byte) (i13 >> 16);
                        cVar2.write(bArr10);
                        cVar2.write(bArr3);
                        cVar2.g(i10);
                        if (Arrays.equals(bArr3, bArr7)) {
                            cVar2.write(bArr8);
                            cVar2.write(f5333O);
                            cVar2.g(i4);
                        } else if (Arrays.equals(bArr3, f5335Q)) {
                            cVar2.write(47);
                            cVar2.g(i4);
                        }
                        W.b.f(bVar, cVar2, i11);
                        c0(cVar2);
                    }
                }
            }
            W.b.e(bVar, cVar2);
            int size = byteArrayOutputStream.size();
            byte[] bArr11 = f5331M;
            cVar.g(size + bArr11.length);
            cVar.write(bArr11);
            byteArrayOutputStream.writeTo(cVar);
            W.b.c(byteArrayOutputStream);
        } catch (Exception e5) {
            e = e5;
            throw new IOException("Failed to save WebP file", e);
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            W.b.c(byteArrayOutputStream2);
            throw th;
        }
    }

    public void W(String str, String str2) {
        e eVar;
        int i4;
        int i5;
        int i6;
        String str3;
        int i7;
        String str4 = str;
        String strReplaceAll = str2;
        if (str4 == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        String str5 = "ExifInterface";
        if (("DateTime".equals(str4) || "DateTimeOriginal".equals(str4) || "DateTimeDigitized".equals(str4)) && strReplaceAll != null) {
            boolean zFind = f5365u0.matcher(strReplaceAll).find();
            boolean zFind2 = f5367v0.matcher(strReplaceAll).find();
            if (strReplaceAll.length() != 19 || (!zFind && !zFind2)) {
                Log.w("ExifInterface", "Invalid value for " + str4 + " : " + strReplaceAll);
                return;
            }
            if (zFind2) {
                strReplaceAll = strReplaceAll.replaceAll("-", Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            }
        }
        if ("ISOSpeedRatings".equals(str4)) {
            if (f5366v) {
                Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str4 = "PhotographicSensitivity";
        }
        int i8 = 2;
        int i9 = 1;
        if (strReplaceAll != null && f5358n0.contains(str4)) {
            if (str4.equals("GPSTimeStamp")) {
                Matcher matcher = f5364t0.matcher(strReplaceAll);
                if (!matcher.find()) {
                    Log.w("ExifInterface", "Invalid value for " + str4 + " : " + strReplaceAll);
                    return;
                }
                strReplaceAll = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    strReplaceAll = new f(Double.parseDouble(strReplaceAll)).toString();
                } catch (NumberFormatException unused) {
                    Log.w("ExifInterface", "Invalid value for " + str4 + " : " + strReplaceAll);
                    return;
                }
            }
        }
        int i10 = 0;
        int i11 = 0;
        while (i11 < f5354j0.length) {
            if ((i11 != 4 || this.f5380i) && (eVar = (e) f5357m0[i11].get(str4)) != null) {
                if (strReplaceAll != null) {
                    Pair pairT = t(strReplaceAll);
                    if (eVar.f5410c == ((Integer) pairT.first).intValue() || eVar.f5410c == ((Integer) pairT.second).intValue()) {
                        i4 = eVar.f5410c;
                    } else {
                        int i12 = eVar.f5411d;
                        if (i12 == -1 || !(i12 == ((Integer) pairT.first).intValue() || eVar.f5411d == ((Integer) pairT.second).intValue())) {
                            int i13 = eVar.f5410c;
                            if (i13 == i9 || i13 == 7 || i13 == i8) {
                                i4 = i13;
                            } else if (f5366v) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Given tag (");
                                sb.append(str4);
                                sb.append(") value didn't match with one of expected formats: ");
                                String[] strArr = f5341W;
                                sb.append(strArr[eVar.f5410c]);
                                sb.append(eVar.f5411d == -1 ? "" : ", " + strArr[eVar.f5411d]);
                                sb.append(" (guess: ");
                                sb.append(strArr[((Integer) pairT.first).intValue()]);
                                sb.append(((Integer) pairT.second).intValue() != -1 ? ", " + strArr[((Integer) pairT.second).intValue()] : "");
                                sb.append(")");
                                Log.d(str5, sb.toString());
                            }
                        } else {
                            i4 = eVar.f5411d;
                        }
                    }
                    switch (i4) {
                        case 1:
                            i5 = i10;
                            i6 = i11;
                            str3 = str5;
                            i7 = i9;
                            this.f5377f[i6].put(str4, d.a(strReplaceAll));
                            break;
                        case 2:
                        case 7:
                            i5 = i10;
                            i6 = i11;
                            str3 = str5;
                            i7 = i9;
                            this.f5377f[i6].put(str4, d.e(strReplaceAll));
                            break;
                        case 3:
                            i5 = i10;
                            i6 = i11;
                            str3 = str5;
                            i7 = i9;
                            String[] strArrSplit = strReplaceAll.split(com.amazon.a.a.o.b.f.f8804a, -1);
                            int[] iArr = new int[strArrSplit.length];
                            for (int i14 = i5; i14 < strArrSplit.length; i14++) {
                                iArr[i14] = Integer.parseInt(strArrSplit[i14]);
                            }
                            this.f5377f[i6].put(str4, d.k(iArr, this.f5379h));
                            break;
                        case 4:
                            i5 = i10;
                            i6 = i11;
                            str3 = str5;
                            i7 = i9;
                            String[] strArrSplit2 = strReplaceAll.split(com.amazon.a.a.o.b.f.f8804a, -1);
                            long[] jArr = new long[strArrSplit2.length];
                            for (int i15 = i5; i15 < strArrSplit2.length; i15++) {
                                jArr[i15] = Long.parseLong(strArrSplit2[i15]);
                            }
                            this.f5377f[i6].put(str4, d.g(jArr, this.f5379h));
                            break;
                        case 5:
                            i5 = i10;
                            i7 = i9;
                            String[] strArrSplit3 = strReplaceAll.split(com.amazon.a.a.o.b.f.f8804a, -1);
                            f[] fVarArr = new f[strArrSplit3.length];
                            int i16 = i5;
                            while (i16 < strArrSplit3.length) {
                                String[] strArrSplit4 = strArrSplit3[i16].split(RemoteSettings.FORWARD_SLASH_STRING, -1);
                                fVarArr[i16] = new f((long) Double.parseDouble(strArrSplit4[i5]), (long) Double.parseDouble(strArrSplit4[i7]));
                                i16++;
                                str5 = str5;
                                i11 = i11;
                            }
                            i6 = i11;
                            str3 = str5;
                            this.f5377f[i6].put(str4, d.i(fVarArr, this.f5379h));
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            if (f5366v) {
                                Log.d(str5, "Data format isn't one of expected formats: " + i4);
                            }
                            break;
                        case 9:
                            i5 = i10;
                            i7 = i9;
                            String[] strArrSplit5 = strReplaceAll.split(com.amazon.a.a.o.b.f.f8804a, -1);
                            int[] iArr2 = new int[strArrSplit5.length];
                            for (int i17 = i5; i17 < strArrSplit5.length; i17++) {
                                iArr2[i17] = Integer.parseInt(strArrSplit5[i17]);
                            }
                            this.f5377f[i11].put(str4, d.c(iArr2, this.f5379h));
                            i6 = i11;
                            str3 = str5;
                            break;
                        case 10:
                            String[] strArrSplit6 = strReplaceAll.split(com.amazon.a.a.o.b.f.f8804a, -1);
                            f[] fVarArr2 = new f[strArrSplit6.length];
                            int i18 = i10;
                            while (i18 < strArrSplit6.length) {
                                String[] strArrSplit7 = strArrSplit6[i18].split(RemoteSettings.FORWARD_SLASH_STRING, -1);
                                fVarArr2[i18] = new f((long) Double.parseDouble(strArrSplit7[i10]), (long) Double.parseDouble(strArrSplit7[i9]));
                                i18++;
                                i10 = i10;
                                i9 = i9;
                                strArrSplit6 = strArrSplit6;
                            }
                            i5 = i10;
                            i7 = i9;
                            this.f5377f[i11].put(str4, d.d(fVarArr2, this.f5379h));
                            i6 = i11;
                            str3 = str5;
                            break;
                        case 12:
                            String[] strArrSplit8 = strReplaceAll.split(com.amazon.a.a.o.b.f.f8804a, -1);
                            double[] dArr = new double[strArrSplit8.length];
                            for (int i19 = i10; i19 < strArrSplit8.length; i19++) {
                                dArr[i19] = Double.parseDouble(strArrSplit8[i19]);
                            }
                            this.f5377f[i11].put(str4, d.b(dArr, this.f5379h));
                            break;
                    }
                } else {
                    this.f5377f[i11].remove(str4);
                }
                i5 = i10;
                i6 = i11;
                str3 = str5;
                i7 = i9;
            } else {
                i5 = i10;
                i6 = i11;
                str3 = str5;
                i7 = i9;
            }
            i11 = i6 + 1;
            i10 = i5;
            str5 = str3;
            i9 = i7;
            i8 = 2;
        }
    }

    public final void X(b bVar) throws Throwable {
        HashMap map = this.f5377f[4];
        d dVar = (d) map.get("Compression");
        if (dVar == null) {
            this.f5386o = 6;
            u(bVar, map);
            return;
        }
        int iM = dVar.m(this.f5379h);
        this.f5386o = iM;
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

    public final void Z(int i4, int i5) throws Throwable {
        if (this.f5377f[i4].isEmpty() || this.f5377f[i5].isEmpty()) {
            if (f5366v) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        d dVar = (d) this.f5377f[i4].get("ImageLength");
        d dVar2 = (d) this.f5377f[i4].get("ImageWidth");
        d dVar3 = (d) this.f5377f[i5].get("ImageLength");
        d dVar4 = (d) this.f5377f[i5].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            if (f5366v) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (dVar3 == null || dVar4 == null) {
            if (f5366v) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iM = dVar.m(this.f5379h);
        int iM2 = dVar2.m(this.f5379h);
        int iM3 = dVar3.m(this.f5379h);
        int iM4 = dVar4.m(this.f5379h);
        if (iM >= iM3 || iM2 >= iM4) {
            return;
        }
        HashMap[] mapArr = this.f5377f;
        HashMap map = mapArr[i4];
        mapArr[i4] = mapArr[i5];
        mapArr[i5] = map;
    }

    public final void a() {
        String strD = d("DateTimeOriginal");
        if (strD != null && d("DateTime") == null) {
            this.f5377f[0].put("DateTime", d.e(strD));
        }
        if (d("ImageWidth") == null) {
            this.f5377f[0].put("ImageWidth", d.f(0L, this.f5379h));
        }
        if (d("ImageLength") == null) {
            this.f5377f[0].put("ImageLength", d.f(0L, this.f5379h));
        }
        if (d("Orientation") == null) {
            this.f5377f[0].put("Orientation", d.f(0L, this.f5379h));
        }
        if (d("LightSource") == null) {
            this.f5377f[1].put("LightSource", d.f(0L, this.f5379h));
        }
    }

    public final void a0(g gVar, int i4) throws Throwable {
        d dVarJ;
        d dVarJ2;
        d dVar = (d) this.f5377f[i4].get("DefaultCropSize");
        d dVar2 = (d) this.f5377f[i4].get("SensorTopBorder");
        d dVar3 = (d) this.f5377f[i4].get("SensorLeftBorder");
        d dVar4 = (d) this.f5377f[i4].get("SensorBottomBorder");
        d dVar5 = (d) this.f5377f[i4].get("SensorRightBorder");
        if (dVar == null) {
            if (dVar2 == null || dVar3 == null || dVar4 == null || dVar5 == null) {
                R(gVar, i4);
                return;
            }
            int iM = dVar2.m(this.f5379h);
            int iM2 = dVar4.m(this.f5379h);
            int iM3 = dVar5.m(this.f5379h);
            int iM4 = dVar3.m(this.f5379h);
            if (iM2 <= iM || iM3 <= iM4) {
                return;
            }
            d dVarJ3 = d.j(iM2 - iM, this.f5379h);
            d dVarJ4 = d.j(iM3 - iM4, this.f5379h);
            this.f5377f[i4].put("ImageLength", dVarJ3);
            this.f5377f[i4].put("ImageWidth", dVarJ4);
            return;
        }
        if (dVar.f5404a == 5) {
            f[] fVarArr = (f[]) dVar.o(this.f5379h);
            if (fVarArr == null || fVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(fVarArr));
                return;
            }
            dVarJ = d.h(fVarArr[0], this.f5379h);
            dVarJ2 = d.h(fVarArr[1], this.f5379h);
        } else {
            int[] iArr = (int[]) dVar.o(this.f5379h);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            dVarJ = d.j(iArr[0], this.f5379h);
            dVarJ2 = d.j(iArr[1], this.f5379h);
        }
        this.f5377f[i4].put("ImageWidth", dVarJ);
        this.f5377f[i4].put("ImageLength", dVarJ2);
    }

    public final void b(b bVar, c cVar, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = f5360p0;
                sb.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
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
        d dVar = (d) this.f5377f[1].get("PixelXDimension");
        d dVar2 = (d) this.f5377f[1].get("PixelYDimension");
        if (dVar != null && dVar2 != null) {
            this.f5377f[0].put("ImageWidth", dVar);
            this.f5377f[0].put("ImageLength", dVar2);
        }
        if (this.f5377f[4].isEmpty() && H(this.f5377f[5])) {
            HashMap[] mapArr = this.f5377f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!H(this.f5377f[4])) {
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
        int i4 = bVar.readInt();
        cVar.write(bArr);
        cVar.g(i4);
        if (i4 % 2 == 1) {
            i4++;
        }
        W.b.f(bVar, cVar, i4);
    }

    public final int c0(c cVar) throws IOException {
        char c4;
        char c5;
        long j4;
        e[][] eVarArr = f5354j0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : f5355k0) {
            P(eVar.f5409b);
        }
        if (this.f5380i) {
            if (this.f5381j) {
                P("StripOffsets");
                P("StripByteCounts");
            } else {
                P("JPEGInterchangeFormat");
                P("JPEGInterchangeFormatLength");
            }
        }
        for (int i4 = 0; i4 < f5354j0.length; i4++) {
            for (Object obj : this.f5377f[i4].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f5377f[i4].remove(entry.getKey());
                }
            }
        }
        long j5 = 0;
        if (!this.f5377f[1].isEmpty()) {
            this.f5377f[0].put(f5355k0[1].f5409b, d.f(0L, this.f5379h));
        }
        if (!this.f5377f[2].isEmpty()) {
            this.f5377f[0].put(f5355k0[2].f5409b, d.f(0L, this.f5379h));
        }
        if (this.f5377f[3].isEmpty()) {
            c4 = 2;
        } else {
            c4 = 2;
            this.f5377f[1].put(f5355k0[3].f5409b, d.f(0L, this.f5379h));
        }
        if (!this.f5380i) {
            c5 = 3;
        } else if (this.f5381j) {
            this.f5377f[4].put("StripOffsets", d.j(0, this.f5379h));
            this.f5377f[4].put("StripByteCounts", d.j(this.f5384m, this.f5379h));
            c5 = 3;
        } else {
            this.f5377f[4].put("JPEGInterchangeFormat", d.f(0L, this.f5379h));
            c5 = 3;
            this.f5377f[4].put("JPEGInterchangeFormatLength", d.f(this.f5384m, this.f5379h));
        }
        for (int i5 = 0; i5 < f5354j0.length; i5++) {
            Iterator it = this.f5377f[i5].entrySet().iterator();
            int i6 = 0;
            while (it.hasNext()) {
                int iP = ((d) ((Map.Entry) it.next()).getValue()).p();
                if (iP > 4) {
                    i6 += iP;
                }
            }
            iArr2[i5] = iArr2[i5] + i6;
        }
        int size = 8;
        for (int i7 = 0; i7 < f5354j0.length; i7++) {
            if (!this.f5377f[i7].isEmpty()) {
                iArr[i7] = size;
                size += (this.f5377f[i7].size() * 12) + 6 + iArr2[i7];
            }
        }
        if (this.f5380i) {
            if (this.f5381j) {
                this.f5377f[4].put("StripOffsets", d.j(size, this.f5379h));
            } else {
                this.f5377f[4].put("JPEGInterchangeFormat", d.f(size, this.f5379h));
            }
            this.f5383l = size;
            size += this.f5384m;
        }
        if (this.f5375d == 4) {
            size += 8;
        }
        if (f5366v) {
            for (int i8 = 0; i8 < f5354j0.length; i8++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i8), Integer.valueOf(iArr[i8]), Integer.valueOf(this.f5377f[i8].size()), Integer.valueOf(iArr2[i8]), Integer.valueOf(size)));
            }
        }
        if (!this.f5377f[1].isEmpty()) {
            this.f5377f[0].put(f5355k0[1].f5409b, d.f(iArr[1], this.f5379h));
        }
        if (!this.f5377f[c4].isEmpty()) {
            this.f5377f[0].put(f5355k0[c4].f5409b, d.f(iArr[c4], this.f5379h));
        }
        if (!this.f5377f[c5].isEmpty()) {
            this.f5377f[1].put(f5355k0[c5].f5409b, d.f(iArr[c5], this.f5379h));
        }
        int i9 = this.f5375d;
        if (i9 == 4) {
            cVar.A(size);
            cVar.write(f5361q0);
        } else if (i9 == 13) {
            cVar.g(size);
            cVar.write(f5327I);
        } else if (i9 == 14) {
            cVar.write(f5332N);
            cVar.g(size);
        }
        cVar.p(this.f5379h == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        cVar.e(this.f5379h);
        cVar.A(42);
        cVar.x(8L);
        int i10 = 0;
        while (i10 < f5354j0.length) {
            if (this.f5377f[i10].isEmpty()) {
                j4 = j5;
            } else {
                cVar.A(this.f5377f[i10].size());
                int size2 = iArr[i10] + 2 + (this.f5377f[i10].size() * 12) + 4;
                for (Map.Entry entry2 : this.f5377f[i10].entrySet()) {
                    int i11 = ((e) f5357m0[i10].get(entry2.getKey())).f5408a;
                    d dVar = (d) entry2.getValue();
                    int iP2 = dVar.p();
                    cVar.A(i11);
                    cVar.A(dVar.f5404a);
                    cVar.g(dVar.f5405b);
                    if (iP2 > 4) {
                        cVar.x(size2);
                        size2 += iP2;
                    } else {
                        cVar.write(dVar.f5407d);
                        if (iP2 < 4) {
                            while (iP2 < 4) {
                                cVar.f(0);
                                iP2++;
                            }
                        }
                    }
                }
                if (i10 != 0 || this.f5377f[4].isEmpty()) {
                    j4 = 0;
                    cVar.x(0L);
                } else {
                    cVar.x(iArr[4]);
                    j4 = 0;
                }
                Iterator it2 = this.f5377f[i10].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = ((d) ((Map.Entry) it2.next()).getValue()).f5407d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
            }
            i10++;
            j5 = j4;
        }
        if (this.f5380i) {
            cVar.write(r());
        }
        if (this.f5375d == 14 && size % 2 == 1) {
            cVar.f(0);
        }
        cVar.e(ByteOrder.BIG_ENDIAN);
        return size;
    }

    public String d(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d dVarF = f(str);
        if (dVarF != null) {
            if (!f5358n0.contains(str)) {
                return dVarF.n(this.f5379h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i4 = dVarF.f5404a;
                if (i4 != 5 && i4 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + dVarF.f5404a);
                    return null;
                }
                f[] fVarArr = (f[]) dVarF.o(this.f5379h);
                if (fVarArr == null || fVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr));
                    return null;
                }
                f fVar = fVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (fVar.f5412a / fVar.f5413b));
                f fVar2 = fVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (fVar2.f5412a / fVar2.f5413b));
                f fVar3 = fVarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (fVar3.f5412a / fVar3.f5413b)));
            }
            try {
                return Double.toString(dVarF.l(this.f5379h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int e(String str, int i4) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d dVarF = f(str);
        if (dVarF != null) {
            try {
                return dVarF.m(this.f5379h);
            } catch (NumberFormatException unused) {
            }
        }
        return i4;
    }

    public final d f(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (f5366v) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i4 = 0; i4 < f5354j0.length; i4++) {
            d dVar = (d) this.f5377f[i4].get(str);
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
                b.C0076b.a(mediaMetadataRetriever, new C0075a(gVar));
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
                    this.f5377f[0].put("ImageWidth", d.j(Integer.parseInt(strExtractMetadata), this.f5379h));
                }
                if (strExtractMetadata2 != null) {
                    this.f5377f[0].put("ImageLength", d.j(Integer.parseInt(strExtractMetadata2), this.f5379h));
                }
                if (strExtractMetadata3 != null) {
                    int i4 = Integer.parseInt(strExtractMetadata3);
                    this.f5377f[0].put("Orientation", d.j(i4 != 90 ? i4 != 180 ? i4 != 270 ? 1 : 8 : 3 : 6, this.f5379h));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i5 = Integer.parseInt(strExtractMetadata4);
                    int i6 = Integer.parseInt(strExtractMetadata5);
                    if (i6 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    gVar.x(i5);
                    byte[] bArr = new byte[6];
                    if (gVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i7 = i5 + 6;
                    int i8 = i6 - 6;
                    if (!Arrays.equals(bArr, f5361q0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i8];
                    if (gVar.read(bArr2) != i8) {
                        throw new IOException("Can't read exif");
                    }
                    this.f5387p = i7;
                    N(bArr2, 0);
                }
                if (f5366v) {
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

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5 A[FALL_THROUGH] */
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
    public final void h(W.a.b r21, int r22, int r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W.a.h(W.a$b, int, int):void");
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
        int i4;
        int i5;
        m(gVar);
        d dVar = (d) this.f5377f[1].get("MakerNote");
        if (dVar != null) {
            g gVar2 = new g(dVar.f5407d);
            gVar2.g(this.f5379h);
            byte[] bArr = f5324F;
            byte[] bArr2 = new byte[bArr.length];
            gVar2.readFully(bArr2);
            gVar2.x(0L);
            byte[] bArr3 = f5325G;
            byte[] bArr4 = new byte[bArr3.length];
            gVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                gVar2.x(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                gVar2.x(12L);
            }
            O(gVar2, 6);
            d dVar2 = (d) this.f5377f[7].get("PreviewImageStart");
            d dVar3 = (d) this.f5377f[7].get("PreviewImageLength");
            if (dVar2 != null && dVar3 != null) {
                this.f5377f[5].put("JPEGInterchangeFormat", dVar2);
                this.f5377f[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = (d) this.f5377f[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.o(this.f5379h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i6 = iArr[2];
                int i7 = iArr[0];
                if (i6 <= i7 || (i4 = iArr[3]) <= (i5 = iArr[1])) {
                    return;
                }
                int i8 = (i6 - i7) + 1;
                int i9 = (i4 - i5) + 1;
                if (i8 < i9) {
                    int i10 = i8 + i9;
                    i9 = i10 - i9;
                    i8 = i10 - i9;
                }
                d dVarJ = d.j(i8, this.f5379h);
                d dVarJ2 = d.j(i9, this.f5379h);
                this.f5377f[0].put("ImageWidth", dVarJ);
                this.f5377f[0].put("ImageLength", dVarJ2);
            }
        }
    }

    public final void k(b bVar) throws Throwable {
        if (f5366v) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.g(ByteOrder.BIG_ENDIAN);
        byte[] bArr = f5326H;
        bVar.p(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i4 = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i5 = length + 8;
                if (i5 == 16 && !Arrays.equals(bArr2, f5328J)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, f5329K)) {
                    return;
                }
                if (Arrays.equals(bArr2, f5327I)) {
                    byte[] bArr3 = new byte[i4];
                    if (bVar.read(bArr3) != i4) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + W.b.a(bArr2));
                    }
                    int i6 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i6) {
                        this.f5387p = i5;
                        N(bArr3, 0);
                        b0();
                        X(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i6 + ", calculated CRC value: " + crc32.getValue());
                }
                int i7 = i4 + 4;
                bVar.p(i7);
                length = i5 + i7;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void l(b bVar) throws Throwable {
        boolean z4 = f5366v;
        if (z4) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.p(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i4 = ByteBuffer.wrap(bArr).getInt();
        int i5 = ByteBuffer.wrap(bArr2).getInt();
        int i6 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i5];
        bVar.p(i4 - bVar.e());
        bVar.read(bArr4);
        h(new b(bArr4), i4, 5);
        bVar.p(i6 - bVar.e());
        bVar.g(ByteOrder.BIG_ENDIAN);
        int i7 = bVar.readInt();
        if (z4) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i7);
        }
        for (int i8 = 0; i8 < i7; i8++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == f5349e0.f5408a) {
                short s4 = bVar.readShort();
                short s5 = bVar.readShort();
                d dVarJ = d.j(s4, this.f5379h);
                d dVarJ2 = d.j(s5, this.f5379h);
                this.f5377f[0].put("ImageLength", dVarJ);
                this.f5377f[0].put("ImageWidth", dVarJ2);
                if (f5366v) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s4) + ", width: " + ((int) s5));
                    return;
                }
                return;
            }
            bVar.p(unsignedShort2);
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
        if (this.f5375d != 8 || (dVar = (d) this.f5377f[1].get("MakerNote")) == null) {
            return;
        }
        g gVar2 = new g(dVar.f5407d);
        gVar2.g(this.f5379h);
        gVar2.p(6);
        O(gVar2, 9);
        d dVar2 = (d) this.f5377f[9].get("ColorSpace");
        if (dVar2 != null) {
            this.f5377f[1].put("ColorSpace", dVar2);
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
        if (f5366v) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + gVar);
        }
        m(gVar);
        d dVar = (d) this.f5377f[0].get("JpgFromRaw");
        if (dVar != null) {
            h(new b(dVar.f5407d), (int) dVar.f5406c, 5);
        }
        d dVar2 = (d) this.f5377f[0].get("ISO");
        d dVar3 = (d) this.f5377f[1].get("PhotographicSensitivity");
        if (dVar2 == null || dVar3 != null) {
            return;
        }
        this.f5377f[1].put("PhotographicSensitivity", dVar2);
    }

    public final void p(g gVar) throws IOException {
        byte[] bArr = f5361q0;
        gVar.p(bArr.length);
        byte[] bArr2 = new byte[gVar.available()];
        gVar.readFully(bArr2);
        this.f5387p = bArr.length;
        N(bArr2, 0);
    }

    public byte[] q() {
        int i4 = this.f5386o;
        if (i4 == 6 || i4 == 7) {
            return r();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b0  */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] r() throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "ExifInterface"
            boolean r1 = r9.f5380i
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            byte[] r1 = r9.f5385n
            if (r1 == 0) goto Ld
            return r1
        Ld:
            android.content.res.AssetManager$AssetInputStream r1 = r9.f5374c     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            if (r1 == 0) goto L2f
            boolean r3 = r1.markSupported()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L21
            if (r3 == 0) goto L26
            r1.reset()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L21
        L1a:
            r3 = r2
            goto L59
        L1c:
            r0 = move-exception
            r3 = r2
        L1e:
            r2 = r1
            goto Lab
        L21:
            r3 = move-exception
            r4 = r3
            r3 = r2
            goto L9d
        L26:
            java.lang.String r3 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r0, r3)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L21
            W.b.c(r1)
            return r2
        L2f:
            java.lang.String r1 = r9.f5372a     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            if (r1 == 0) goto L44
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            java.lang.String r3 = r9.f5372a     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            goto L1a
        L3b:
            r0 = move-exception
            r3 = r2
            goto Lab
        L3f:
            r3 = move-exception
            r1 = r2
            r4 = r3
            r3 = r1
            goto L9d
        L44:
            java.io.FileDescriptor r1 = r9.f5373b     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            java.io.FileDescriptor r1 = W.b.a.b(r1)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            int r3 = android.system.OsConstants.SEEK_SET     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            r4 = 0
            W.b.a.c(r1, r4, r3)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            r8 = r3
            r3 = r1
            r1 = r8
        L59:
            int r4 = r9.f5383l     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            int r5 = r9.f5387p     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            int r4 = r4 + r5
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            long r4 = r1.skip(r4)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            int r6 = r9.f5383l     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            int r7 = r9.f5387p     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            int r6 = r6 + r7
            long r6 = (long) r6
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            java.lang.String r5 = "Corrupted image"
            if (r4 != 0) goto L90
            int r4 = r9.f5384m     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            int r6 = r1.read(r4)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            int r7 = r9.f5384m     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            if (r6 != r7) goto L8a
            r9.f5385n = r4     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            W.b.c(r1)
            if (r3 == 0) goto L85
            W.b.b(r3)
        L85:
            return r4
        L86:
            r0 = move-exception
            goto L1e
        L88:
            r4 = move-exception
            goto L9d
        L8a:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            throw r4     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
        L90:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
            throw r4     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L88
        L96:
            r0 = move-exception
            r3 = r1
            goto Lab
        L99:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r2
        L9d:
            java.lang.String r5 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r0, r5, r4)     // Catch: java.lang.Throwable -> L86
            W.b.c(r1)
            if (r3 == 0) goto Laa
            W.b.b(r3)
        Laa:
            return r2
        Lab:
            W.b.c(r2)
            if (r3 == 0) goto Lb3
            W.b.b(r3)
        Lb3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W.a.r():byte[]");
    }

    public final void s(b bVar) throws Throwable {
        if (f5366v) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.g(ByteOrder.LITTLE_ENDIAN);
        bVar.p(f5330L.length);
        int i4 = bVar.readInt() + 8;
        byte[] bArr = f5331M;
        bVar.p(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i5 = bVar.readInt();
                int i6 = length + 8;
                if (Arrays.equals(f5332N, bArr2)) {
                    byte[] bArr3 = new byte[i5];
                    if (bVar.read(bArr3) == i5) {
                        this.f5387p = i6;
                        N(bArr3, 0);
                        X(new b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + W.b.a(bArr2));
                    }
                }
                if (i5 % 2 == 1) {
                    i5++;
                }
                length = i6 + i5;
                if (length == i4) {
                    return;
                }
                if (length > i4) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.p(i5);
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
        int iM = dVar.m(this.f5379h);
        int iM2 = dVar2.m(this.f5379h);
        if (this.f5375d == 7) {
            iM += this.f5388q;
        }
        if (iM > 0 && iM2 > 0) {
            this.f5380i = true;
            if (this.f5372a == null && this.f5374c == null && this.f5373b == null) {
                byte[] bArr = new byte[iM2];
                bVar.skip(iM);
                bVar.read(bArr);
                this.f5385n = bArr;
            }
            this.f5383l = iM;
            this.f5384m = iM2;
        }
        if (f5366v) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iM + ", length: " + iM2);
        }
    }

    public final void v(b bVar, HashMap map) {
        d dVar = (d) map.get("StripOffsets");
        d dVar2 = (d) map.get("StripByteCounts");
        if (dVar == null || dVar2 == null) {
            return;
        }
        long[] jArrD = W.b.d(dVar.o(this.f5379h));
        long[] jArrD2 = W.b.d(dVar2.o(this.f5379h));
        if (jArrD == null || jArrD.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrD2 == null || jArrD2.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrD.length != jArrD2.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j4 = 0;
        for (long j5 : jArrD2) {
            j4 += j5;
        }
        int i4 = (int) j4;
        byte[] bArr = new byte[i4];
        this.f5382k = true;
        this.f5381j = true;
        this.f5380i = true;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < jArrD.length; i7++) {
            int i8 = (int) jArrD[i7];
            int i9 = (int) jArrD2[i7];
            if (i7 < jArrD.length - 1 && i8 + i9 != jArrD[i7 + 1]) {
                this.f5382k = false;
            }
            int i10 = i8 - i5;
            if (i10 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
                return;
            }
            long j6 = i10;
            if (bVar.skip(j6) != j6) {
                Log.d("ExifInterface", "Failed to skip " + i10 + " bytes.");
                return;
            }
            int i11 = i5 + i10;
            byte[] bArr2 = new byte[i9];
            if (bVar.read(bArr2) != i9) {
                Log.d("ExifInterface", "Failed to read " + i9 + " bytes.");
                return;
            }
            i5 = i11 + i9;
            System.arraycopy(bArr2, 0, bArr, i6, i9);
            i6 += i9;
        }
        this.f5385n = bArr;
        if (this.f5382k) {
            this.f5383l = (int) jArrD[0];
            this.f5384m = i4;
        }
    }

    public final void w(String str) throws Throwable {
        FileInputStream fileInputStream;
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        FileInputStream fileInputStream2 = null;
        this.f5374c = null;
        this.f5372a = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (E(fileInputStream.getFD())) {
                this.f5373b = fileInputStream.getFD();
            } else {
                this.f5373b = null;
            }
            J(fileInputStream);
            W.b.c(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            W.b.c(fileInputStream2);
            throw th;
        }
    }

    public final boolean y(byte[] bArr) throws Throwable {
        b bVar;
        long j4;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            long length = bVar.readInt();
            byte[] bArr2 = new byte[4];
            bVar.read(bArr2);
            if (!Arrays.equals(bArr2, f5321C)) {
                bVar.close();
                return false;
            }
            if (length == 1) {
                length = bVar.readLong();
                j4 = 16;
                if (length < 16) {
                    bVar.close();
                    return false;
                }
            } else {
                j4 = 8;
            }
            if (length > bArr.length) {
                length = bArr.length;
            }
            long j5 = length - j4;
            if (j5 < 8) {
                bVar.close();
                return false;
            }
            byte[] bArr3 = new byte[4];
            boolean z4 = false;
            boolean z5 = false;
            for (long j6 = 0; j6 < j5 / 4; j6++) {
                if (bVar.read(bArr3) != 4) {
                    bVar.close();
                    return false;
                }
                if (j6 != 1) {
                    if (Arrays.equals(bArr3, f5322D)) {
                        z4 = true;
                    } else if (Arrays.equals(bArr3, f5323E)) {
                        z5 = true;
                    }
                    if (z4 && z5) {
                        bVar.close();
                        return true;
                    }
                }
            }
            bVar.close();
        } catch (Exception e5) {
            e = e5;
            bVar2 = bVar;
            if (f5366v) {
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

    public static class g extends b {
        public g(byte[] bArr) {
            super(bArr);
            this.f5398a.mark(Integer.MAX_VALUE);
        }

        public void x(long j4) throws IOException {
            int i4 = this.f5400c;
            if (i4 > j4) {
                this.f5400c = 0;
                this.f5398a.reset();
            } else {
                j4 -= (long) i4;
            }
            p((int) j4);
        }

        public g(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f5398a.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f5409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5411d;

        public e(String str, int i4, int i5) {
            this.f5409b = str;
            this.f5408a = i4;
            this.f5410c = i5;
            this.f5411d = -1;
        }

        public boolean a(int i4) {
            int i5;
            int i6 = this.f5410c;
            if (i6 == 7 || i4 == 7 || i6 == i4 || (i5 = this.f5411d) == i4) {
                return true;
            }
            if ((i6 == 4 || i5 == 4) && i4 == 3) {
                return true;
            }
            if ((i6 == 9 || i5 == 9) && i4 == 8) {
                return true;
            }
            return (i6 == 12 || i5 == 12) && i4 == 11;
        }

        public e(String str, int i4, int i5, int i6) {
            this.f5409b = str;
            this.f5408a = i4;
            this.f5410c = i5;
            this.f5411d = i6;
        }
    }

    public a(InputStream inputStream) {
        this(inputStream, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(java.io.InputStream r4, int r5) {
        /*
            r3 = this;
            r3.<init>()
            W.a$e[][] r0 = W.a.f5354j0
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r3.f5377f = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r3.f5378g = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r3.f5379h = r0
            if (r4 == 0) goto L6a
            r0 = 0
            r3.f5372a = r0
            r1 = 1
            if (r5 != r1) goto L3c
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream
            byte[] r2 = W.a.f5361q0
            int r2 = r2.length
            r5.<init>(r4, r2)
            boolean r4 = x(r5)
            if (r4 != 0) goto L34
            java.lang.String r4 = "ExifInterface"
            java.lang.String r5 = "Given data does not follow the structure of an Exif-only data."
            android.util.Log.w(r4, r5)
            return
        L34:
            r3.f5376e = r1
            r3.f5374c = r0
            r3.f5373b = r0
            r4 = r5
            goto L66
        L3c:
            boolean r5 = r4 instanceof android.content.res.AssetManager.AssetInputStream
            if (r5 == 0) goto L48
            r5 = r4
            android.content.res.AssetManager$AssetInputStream r5 = (android.content.res.AssetManager.AssetInputStream) r5
            r3.f5374c = r5
            r3.f5373b = r0
            goto L66
        L48:
            boolean r5 = r4 instanceof java.io.FileInputStream
            if (r5 == 0) goto L62
            r5 = r4
            java.io.FileInputStream r5 = (java.io.FileInputStream) r5
            java.io.FileDescriptor r1 = r5.getFD()
            boolean r1 = E(r1)
            if (r1 == 0) goto L62
            r3.f5374c = r0
            java.io.FileDescriptor r5 = r5.getFD()
            r3.f5373b = r5
            goto L66
        L62:
            r3.f5374c = r0
            r3.f5373b = r0
        L66:
            r3.J(r4)
            return
        L6a:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "inputStream cannot be null"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: W.a.<init>(java.io.InputStream, int):void");
    }

    /* JADX INFO: renamed from: W.a$a, reason: collision with other inner class name */
    public class C0075a extends MediaDataSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f5394b;

        public C0075a(g gVar) {
            this.f5394b = gVar;
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j4, byte[] bArr, int i4, int i5) {
            if (i5 == 0) {
                return 0;
            }
            if (j4 < 0) {
                return -1;
            }
            try {
                long j5 = this.f5393a;
                if (j5 != j4) {
                    if (j5 >= 0 && j4 >= j5 + ((long) this.f5394b.available())) {
                        return -1;
                    }
                    this.f5394b.x(j4);
                    this.f5393a = j4;
                }
                if (i5 > this.f5394b.available()) {
                    i5 = this.f5394b.available();
                }
                int i6 = this.f5394b.read(bArr, i4, i5);
                if (i6 >= 0) {
                    this.f5393a += (long) i6;
                    return i6;
                }
            } catch (IOException unused) {
            }
            this.f5393a = -1L;
            return -1;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
