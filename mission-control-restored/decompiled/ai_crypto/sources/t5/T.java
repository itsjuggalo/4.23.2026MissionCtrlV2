package t5;

import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes2.dex */
public class T implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f23555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f23556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Inflater f23557g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f23560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f23561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f23562l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2704v f23551a = new C2704v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CRC32 f23552b = new CRC32();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f23553c = new b(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f23554d = new byte[512];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f23558h = c.HEADER;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f23559i = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f23563m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f23564n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f23565o = true;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23566a;

        static {
            int[] iArr = new int[c.values().length];
            f23566a = iArr;
            try {
                iArr[c.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23566a[c.HEADER_EXTRA_LEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23566a[c.HEADER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23566a[c.HEADER_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23566a[c.HEADER_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23566a[c.HEADER_CRC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23566a[c.INITIALIZE_INFLATER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23566a[c.INFLATING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23566a[c.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23566a[c.TRAILER.ordinal()] = 10;
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
            if (T.this.f23556f - T.this.f23555e > 0) {
                unsignedByte = T.this.f23554d[T.this.f23555e] & 255;
                T.A(T.this, 1);
            } else {
                unsignedByte = T.this.f23551a.readUnsignedByte();
            }
            T.this.f23552b.update(unsignedByte);
            T.M(T.this, 1);
            return unsignedByte;
        }

        public final long i() {
            return ((long) j()) | (((long) j()) << 16);
        }

        public final int j() {
            return h() | (h() << 8);
        }

        public final int k() {
            return (T.this.f23556f - T.this.f23555e) + T.this.f23551a.e();
        }

        public final void l(int i7) {
            int i8;
            int i9 = T.this.f23556f - T.this.f23555e;
            if (i9 > 0) {
                int iMin = Math.min(i9, i7);
                T.this.f23552b.update(T.this.f23554d, T.this.f23555e, iMin);
                T.A(T.this, iMin);
                i8 = i7 - iMin;
            } else {
                i8 = i7;
            }
            if (i8 > 0) {
                byte[] bArr = new byte[512];
                int i10 = 0;
                while (i10 < i8) {
                    int iMin2 = Math.min(i8 - i10, 512);
                    T.this.f23551a.J(bArr, 0, iMin2);
                    T.this.f23552b.update(bArr, 0, iMin2);
                    i10 += iMin2;
                }
            }
            T.M(T.this, i7);
        }

        public /* synthetic */ b(T t7, a aVar) {
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

    public static /* synthetic */ int A(T t7, int i7) {
        int i8 = t7.f23555e + i7;
        t7.f23555e = i8;
        return i8;
    }

    public static /* synthetic */ int M(T t7, int i7) {
        int i8 = t7.f23563m + i7;
        t7.f23563m = i8;
        return i8;
    }

    public boolean A0() {
        H2.m.u(!this.f23559i, "GzipInflatingBuffer is closed");
        return this.f23565o;
    }

    public final boolean B0() throws ZipException {
        if (this.f23553c.k() < 10) {
            return false;
        }
        if (this.f23553c.j() != 35615) {
            throw new ZipException("Not in GZIP format");
        }
        if (this.f23553c.h() != 8) {
            throw new ZipException("Unsupported compression method");
        }
        this.f23560j = this.f23553c.h();
        this.f23553c.l(6);
        this.f23558h = c.HEADER_EXTRA_LEN;
        return true;
    }

    public final boolean C0() {
        if ((this.f23560j & 16) != 16) {
            this.f23558h = c.HEADER_CRC;
            return true;
        }
        if (!this.f23553c.g()) {
            return false;
        }
        this.f23558h = c.HEADER_CRC;
        return true;
    }

    public final boolean D0() throws ZipException {
        if ((this.f23560j & 2) != 2) {
            this.f23558h = c.INITIALIZE_INFLATER;
            return true;
        }
        if (this.f23553c.k() < 2) {
            return false;
        }
        if ((((int) this.f23552b.getValue()) & 65535) != this.f23553c.j()) {
            throw new ZipException("Corrupt GZIP header");
        }
        this.f23558h = c.INITIALIZE_INFLATER;
        return true;
    }

    public final boolean E0() {
        int iK = this.f23553c.k();
        int i7 = this.f23561k;
        if (iK < i7) {
            return false;
        }
        this.f23553c.l(i7);
        this.f23558h = c.HEADER_NAME;
        return true;
    }

    public final boolean F0() {
        if ((this.f23560j & 4) != 4) {
            this.f23558h = c.HEADER_NAME;
            return true;
        }
        if (this.f23553c.k() < 2) {
            return false;
        }
        this.f23561k = this.f23553c.j();
        this.f23558h = c.HEADER_EXTRA;
        return true;
    }

    public final boolean G0() {
        if ((this.f23560j & 8) != 8) {
            this.f23558h = c.HEADER_COMMENT;
            return true;
        }
        if (!this.f23553c.g()) {
            return false;
        }
        this.f23558h = c.HEADER_COMMENT;
        return true;
    }

    public final boolean H0() throws ZipException {
        if (this.f23557g != null && this.f23553c.k() <= 18) {
            this.f23557g.end();
            this.f23557g = null;
        }
        if (this.f23553c.k() < 8) {
            return false;
        }
        if (this.f23552b.getValue() != this.f23553c.i() || this.f23562l != this.f23553c.i()) {
            throw new ZipException("Corrupt GZIP trailer");
        }
        this.f23552b.reset();
        this.f23558h = c.HEADER;
        return true;
    }

    public void O(y0 y0Var) {
        H2.m.u(!this.f23559i, "GzipInflatingBuffer is closed");
        this.f23551a.i(y0Var);
        this.f23565o = false;
    }

    public final boolean T() {
        H2.m.u(this.f23557g != null, "inflater is null");
        H2.m.u(this.f23555e == this.f23556f, "inflaterInput has unconsumed bytes");
        int iMin = Math.min(this.f23551a.e(), 512);
        if (iMin == 0) {
            return false;
        }
        this.f23555e = 0;
        this.f23556f = iMin;
        this.f23551a.J(this.f23554d, 0, iMin);
        this.f23557g.setInput(this.f23554d, this.f23555e, iMin);
        this.f23558h = c.INFLATING;
        return true;
    }

    public int V() {
        int i7 = this.f23563m;
        this.f23563m = 0;
        return i7;
    }

    public int X() {
        int i7 = this.f23564n;
        this.f23564n = 0;
        return i7;
    }

    public boolean c0() {
        H2.m.u(!this.f23559i, "GzipInflatingBuffer is closed");
        return (this.f23553c.k() == 0 && this.f23558h == c.HEADER) ? false : true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f23559i) {
            return;
        }
        this.f23559i = true;
        this.f23551a.close();
        Inflater inflater = this.f23557g;
        if (inflater != null) {
            inflater.end();
            this.f23557g = null;
        }
    }

    public final int i0(byte[] bArr, int i7, int i8) throws DataFormatException {
        H2.m.u(this.f23557g != null, "inflater is null");
        try {
            int totalIn = this.f23557g.getTotalIn();
            int iInflate = this.f23557g.inflate(bArr, i7, i8);
            int totalIn2 = this.f23557g.getTotalIn() - totalIn;
            this.f23563m += totalIn2;
            this.f23564n += totalIn2;
            this.f23555e += totalIn2;
            this.f23552b.update(bArr, i7, iInflate);
            if (this.f23557g.finished()) {
                this.f23562l = this.f23557g.getBytesWritten() & 4294967295L;
                this.f23558h = c.TRAILER;
            } else if (this.f23557g.needsInput()) {
                this.f23558h = c.INFLATER_NEEDS_INPUT;
            }
            return iInflate;
        } catch (DataFormatException e7) {
            throw new DataFormatException("Inflater data format exception: " + e7.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        if (r2 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
    
        if (r6.f23558h != t5.T.c.f23568a) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0087, code lost:
    
        if (r6.f23553c.k() >= 10) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
    
        r6.f23565o = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008d, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int y0(byte[] r7, int r8, int r9) throws java.util.zip.ZipException {
        /*
            r6 = this;
            boolean r0 = r6.f23559i
            r1 = 1
            r0 = r0 ^ r1
            java.lang.String r2 = "GzipInflatingBuffer is closed"
            H2.m.u(r0, r2)
            r0 = 0
            r3 = r0
        Lb:
            r2 = r1
        Lc:
            if (r2 == 0) goto L77
            int r4 = r9 - r3
            if (r4 <= 0) goto L77
            int[] r2 = t5.T.a.f23566a
            t5.T$c r5 = r6.f23558h
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
            t5.T$c r9 = r6.f23558h
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L38:
            boolean r2 = r6.H0()
            goto Lc
        L3d:
            boolean r2 = r6.T()
            goto Lc
        L42:
            int r2 = r8 + r3
            int r2 = r6.i0(r7, r2, r4)
            int r3 = r3 + r2
            t5.T$c r2 = r6.f23558h
            t5.T$c r4 = t5.T.c.TRAILER
            if (r2 != r4) goto Lb
            boolean r2 = r6.H0()
            goto Lc
        L54:
            boolean r2 = r6.z0()
            goto Lc
        L59:
            boolean r2 = r6.D0()
            goto Lc
        L5e:
            boolean r2 = r6.C0()
            goto Lc
        L63:
            boolean r2 = r6.G0()
            goto Lc
        L68:
            boolean r2 = r6.E0()
            goto Lc
        L6d:
            boolean r2 = r6.F0()
            goto Lc
        L72:
            boolean r2 = r6.B0()
            goto Lc
        L77:
            if (r2 == 0) goto L8b
            t5.T$c r7 = r6.f23558h
            t5.T$c r8 = t5.T.c.HEADER
            if (r7 != r8) goto L8a
            t5.T$b r7 = r6.f23553c
            int r7 = t5.T.b.d(r7)
            r8 = 10
            if (r7 >= r8) goto L8a
            goto L8b
        L8a:
            r1 = r0
        L8b:
            r6.f23565o = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t5.T.y0(byte[], int, int):int");
    }

    public final boolean z0() {
        Inflater inflater = this.f23557g;
        if (inflater == null) {
            this.f23557g = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.f23552b.reset();
        int i7 = this.f23556f;
        int i8 = this.f23555e;
        int i9 = i7 - i8;
        if (i9 > 0) {
            this.f23557g.setInput(this.f23554d, i8, i9);
            this.f23558h = c.INFLATING;
        } else {
            this.f23558h = c.INFLATER_NEEDS_INPUT;
        }
        return true;
    }
}
