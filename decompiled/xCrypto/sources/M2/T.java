package M2;

import io.flutter.embedding.android.KeyboardMap;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes3.dex */
public class T implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Inflater f2006g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2010k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2011l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0449v f2000a = new C0449v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CRC32 f2001b = new CRC32();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f2002c = new b(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f2003d = new byte[512];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f2007h = c.HEADER;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2008i = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2012m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2013n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2014o = true;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2015a;

        static {
            int[] iArr = new int[c.values().length];
            f2015a = iArr;
            try {
                iArr[c.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2015a[c.HEADER_EXTRA_LEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2015a[c.HEADER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2015a[c.HEADER_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2015a[c.HEADER_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2015a[c.HEADER_CRC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2015a[c.INITIALIZE_INFLATER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2015a[c.INFLATING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2015a[c.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2015a[c.TRAILER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public class b {
        public b() {
        }

        public final boolean g() {
            while (k() > 0) {
                if (h() == 0) {
                    return true;
                }
            }
            return false;
        }

        public final int h() {
            int unsignedByte;
            if (T.this.f2005f - T.this.f2004e > 0) {
                unsignedByte = T.this.f2003d[T.this.f2004e] & 255;
                T.g(T.this, 1);
            } else {
                unsignedByte = T.this.f2000a.readUnsignedByte();
            }
            T.this.f2001b.update(unsignedByte);
            T.E(T.this, 1);
            return unsignedByte;
        }

        public final long i() {
            return ((long) j()) | (((long) j()) << 16);
        }

        public final int j() {
            return h() | (h() << 8);
        }

        public final int k() {
            return (T.this.f2005f - T.this.f2004e) + T.this.f2000a.d();
        }

        public final void l(int i4) {
            int i5;
            int i6 = T.this.f2005f - T.this.f2004e;
            if (i6 > 0) {
                int iMin = Math.min(i6, i4);
                T.this.f2001b.update(T.this.f2003d, T.this.f2004e, iMin);
                T.g(T.this, iMin);
                i5 = i4 - iMin;
            } else {
                i5 = i4;
            }
            if (i5 > 0) {
                byte[] bArr = new byte[512];
                int i7 = 0;
                while (i7 < i5) {
                    int iMin2 = Math.min(i5 - i7, 512);
                    T.this.f2000a.z(bArr, 0, iMin2);
                    T.this.f2001b.update(bArr, 0, iMin2);
                    i7 += iMin2;
                }
            }
            T.E(T.this, i4);
        }

        public /* synthetic */ b(T t4, a aVar) {
            this();
        }
    }

    public enum c {
        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER
    }

    public static /* synthetic */ int E(T t4, int i4) {
        int i5 = t4.f2012m + i4;
        t4.f2012m = i5;
        return i5;
    }

    public static /* synthetic */ int g(T t4, int i4) {
        int i5 = t4.f2004e + i4;
        t4.f2004e = i5;
        return i5;
    }

    public void G(y0 y0Var) {
        Z1.m.u(!this.f2008i, "GzipInflatingBuffer is closed");
        this.f2000a.f(y0Var);
        this.f2014o = false;
    }

    public final boolean J() {
        Z1.m.u(this.f2006g != null, "inflater is null");
        Z1.m.u(this.f2004e == this.f2005f, "inflaterInput has unconsumed bytes");
        int iMin = Math.min(this.f2000a.d(), 512);
        if (iMin == 0) {
            return false;
        }
        this.f2004e = 0;
        this.f2005f = iMin;
        this.f2000a.z(this.f2003d, 0, iMin);
        this.f2006g.setInput(this.f2003d, this.f2004e, iMin);
        this.f2007h = c.INFLATING;
        return true;
    }

    public int K() {
        int i4 = this.f2012m;
        this.f2012m = 0;
        return i4;
    }

    public int P() {
        int i4 = this.f2013n;
        this.f2013n = 0;
        return i4;
    }

    public boolean S() {
        Z1.m.u(!this.f2008i, "GzipInflatingBuffer is closed");
        return (this.f2002c.k() == 0 && this.f2007h == c.HEADER) ? false : true;
    }

    public final int a0(byte[] bArr, int i4, int i5) throws DataFormatException {
        Z1.m.u(this.f2006g != null, "inflater is null");
        try {
            int totalIn = this.f2006g.getTotalIn();
            int iInflate = this.f2006g.inflate(bArr, i4, i5);
            int totalIn2 = this.f2006g.getTotalIn() - totalIn;
            this.f2012m += totalIn2;
            this.f2013n += totalIn2;
            this.f2004e += totalIn2;
            this.f2001b.update(bArr, i4, iInflate);
            if (this.f2006g.finished()) {
                this.f2011l = this.f2006g.getBytesWritten() & KeyboardMap.kValueMask;
                this.f2007h = c.TRAILER;
                return iInflate;
            }
            if (this.f2006g.needsInput()) {
                this.f2007h = c.INFLATER_NEEDS_INPUT;
            }
            return iInflate;
        } catch (DataFormatException e4) {
            throw new DataFormatException("Inflater data format exception: " + e4.getMessage());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f2008i) {
            return;
        }
        this.f2008i = true;
        this.f2000a.close();
        Inflater inflater = this.f2006g;
        if (inflater != null) {
            inflater.end();
            this.f2006g = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        if (r2 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
    
        if (r6.f2007h != M2.T.c.f2017a) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0087, code lost:
    
        if (r6.f2002c.k() >= 10) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
    
        r6.f2014o = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008d, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int d0(byte[] r7, int r8, int r9) throws java.util.zip.ZipException {
        /*
            r6 = this;
            boolean r0 = r6.f2008i
            r1 = 1
            r0 = r0 ^ r1
            java.lang.String r2 = "GzipInflatingBuffer is closed"
            Z1.m.u(r0, r2)
            r0 = 0
            r3 = r0
        Lb:
            r2 = r1
        Lc:
            if (r2 == 0) goto L77
            int r4 = r9 - r3
            if (r4 <= 0) goto L77
            int[] r2 = M2.T.a.f2015a
            M2.T$c r5 = r6.f2007h
            int r5 = r5.ordinal()
            r2 = r2[r5]
            switch(r2) {
                case 1: goto L72;
                case 2: goto L6d;
                case 3: goto L68;
                case 4: goto L63;
                case 5: goto L5e;
                case 6: goto L59;
                case 7: goto L54;
                case 8: goto L42;
                case 9: goto L3d;
                case 10: goto L38;
                default: goto L1f;
            }
        L1f:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Invalid state: "
            r8.append(r9)
            M2.T$c r9 = r6.f2007h
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L38:
            boolean r2 = r6.m0()
            goto Lc
        L3d:
            boolean r2 = r6.J()
            goto Lc
        L42:
            int r2 = r8 + r3
            int r2 = r6.a0(r7, r2, r4)
            int r3 = r3 + r2
            M2.T$c r2 = r6.f2007h
            M2.T$c r4 = M2.T.c.TRAILER
            if (r2 != r4) goto Lb
            boolean r2 = r6.m0()
            goto Lc
        L54:
            boolean r2 = r6.e0()
            goto Lc
        L59:
            boolean r2 = r6.i0()
            goto Lc
        L5e:
            boolean r2 = r6.h0()
            goto Lc
        L63:
            boolean r2 = r6.l0()
            goto Lc
        L68:
            boolean r2 = r6.j0()
            goto Lc
        L6d:
            boolean r2 = r6.k0()
            goto Lc
        L72:
            boolean r2 = r6.g0()
            goto Lc
        L77:
            if (r2 == 0) goto L8b
            M2.T$c r7 = r6.f2007h
            M2.T$c r8 = M2.T.c.HEADER
            if (r7 != r8) goto L8a
            M2.T$b r7 = r6.f2002c
            int r7 = M2.T.b.d(r7)
            r8 = 10
            if (r7 >= r8) goto L8a
            goto L8b
        L8a:
            r1 = r0
        L8b:
            r6.f2014o = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: M2.T.d0(byte[], int, int):int");
    }

    public final boolean e0() {
        Inflater inflater = this.f2006g;
        if (inflater == null) {
            this.f2006g = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.f2001b.reset();
        int i4 = this.f2005f;
        int i5 = this.f2004e;
        int i6 = i4 - i5;
        if (i6 > 0) {
            this.f2006g.setInput(this.f2003d, i5, i6);
            this.f2007h = c.INFLATING;
        } else {
            this.f2007h = c.INFLATER_NEEDS_INPUT;
        }
        return true;
    }

    public boolean f0() {
        Z1.m.u(!this.f2008i, "GzipInflatingBuffer is closed");
        return this.f2014o;
    }

    public final boolean g0() throws ZipException {
        if (this.f2002c.k() < 10) {
            return false;
        }
        if (this.f2002c.j() != 35615) {
            throw new ZipException("Not in GZIP format");
        }
        if (this.f2002c.h() != 8) {
            throw new ZipException("Unsupported compression method");
        }
        this.f2009j = this.f2002c.h();
        this.f2002c.l(6);
        this.f2007h = c.HEADER_EXTRA_LEN;
        return true;
    }

    public final boolean h0() {
        if ((this.f2009j & 16) != 16) {
            this.f2007h = c.HEADER_CRC;
            return true;
        }
        if (!this.f2002c.g()) {
            return false;
        }
        this.f2007h = c.HEADER_CRC;
        return true;
    }

    public final boolean i0() throws ZipException {
        if ((this.f2009j & 2) != 2) {
            this.f2007h = c.INITIALIZE_INFLATER;
            return true;
        }
        if (this.f2002c.k() < 2) {
            return false;
        }
        if ((((int) this.f2001b.getValue()) & 65535) != this.f2002c.j()) {
            throw new ZipException("Corrupt GZIP header");
        }
        this.f2007h = c.INITIALIZE_INFLATER;
        return true;
    }

    public final boolean j0() {
        int iK = this.f2002c.k();
        int i4 = this.f2010k;
        if (iK < i4) {
            return false;
        }
        this.f2002c.l(i4);
        this.f2007h = c.HEADER_NAME;
        return true;
    }

    public final boolean k0() {
        if ((this.f2009j & 4) != 4) {
            this.f2007h = c.HEADER_NAME;
            return true;
        }
        if (this.f2002c.k() < 2) {
            return false;
        }
        this.f2010k = this.f2002c.j();
        this.f2007h = c.HEADER_EXTRA;
        return true;
    }

    public final boolean l0() {
        if ((this.f2009j & 8) != 8) {
            this.f2007h = c.HEADER_COMMENT;
            return true;
        }
        if (!this.f2002c.g()) {
            return false;
        }
        this.f2007h = c.HEADER_COMMENT;
        return true;
    }

    public final boolean m0() throws ZipException {
        if (this.f2006g != null && this.f2002c.k() <= 18) {
            this.f2006g.end();
            this.f2006g = null;
        }
        if (this.f2002c.k() < 8) {
            return false;
        }
        if (this.f2001b.getValue() != this.f2002c.i() || this.f2011l != this.f2002c.i()) {
            throw new ZipException("Corrupt GZIP trailer");
        }
        this.f2001b.reset();
        this.f2007h = c.HEADER;
        return true;
    }
}
