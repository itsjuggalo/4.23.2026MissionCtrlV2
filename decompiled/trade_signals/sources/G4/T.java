package G4;

import io.flutter.embedding.android.KeyboardMap;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public class T implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Inflater f2594g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2598k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2599l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0557v f2588a = new C0557v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CRC32 f2589b = new CRC32();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f2590c = new b(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f2591d = new byte[512];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f2595h = c.HEADER;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2596i = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2600m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2601n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2602o = true;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2603a;

        static {
            int[] iArr = new int[c.values().length];
            f2603a = iArr;
            try {
                iArr[c.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2603a[c.HEADER_EXTRA_LEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2603a[c.HEADER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2603a[c.HEADER_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2603a[c.HEADER_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2603a[c.HEADER_CRC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2603a[c.INITIALIZE_INFLATER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2603a[c.INFLATING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2603a[c.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2603a[c.TRAILER.ordinal()] = 10;
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
            if (T.this.f2593f - T.this.f2592e > 0) {
                unsignedByte = T.this.f2591d[T.this.f2592e] & 255;
                T.e(T.this, 1);
            } else {
                unsignedByte = T.this.f2588a.readUnsignedByte();
            }
            T.this.f2589b.update(unsignedByte);
            T.B(T.this, 1);
            return unsignedByte;
        }

        public final long i() {
            return ((long) j()) | (((long) j()) << 16);
        }

        public final int j() {
            return h() | (h() << 8);
        }

        public final int k() {
            return (T.this.f2593f - T.this.f2592e) + T.this.f2588a.d();
        }

        public final void l(int i8) {
            int i9;
            int i10 = T.this.f2593f - T.this.f2592e;
            if (i10 > 0) {
                int iMin = Math.min(i10, i8);
                T.this.f2589b.update(T.this.f2591d, T.this.f2592e, iMin);
                T.e(T.this, iMin);
                i9 = i8 - iMin;
            } else {
                i9 = i8;
            }
            if (i9 > 0) {
                byte[] bArr = new byte[512];
                int i11 = 0;
                while (i11 < i9) {
                    int iMin2 = Math.min(i9 - i11, 512);
                    T.this.f2588a.J(bArr, 0, iMin2);
                    T.this.f2589b.update(bArr, 0, iMin2);
                    i11 += iMin2;
                }
            }
            T.B(T.this, i8);
        }

        public /* synthetic */ b(T t8, a aVar) {
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

    public static /* synthetic */ int B(T t8, int i8) {
        int i9 = t8.f2600m + i8;
        t8.f2600m = i9;
        return i9;
    }

    public static /* synthetic */ int e(T t8, int i8) {
        int i9 = t8.f2592e + i8;
        t8.f2592e = i9;
        return i9;
    }

    public void D(y0 y0Var) {
        AbstractC2848n.u(!this.f2596i, "GzipInflatingBuffer is closed");
        this.f2588a.c(y0Var);
        this.f2602o = false;
    }

    public final boolean E() {
        AbstractC2848n.u(this.f2594g != null, "inflater is null");
        AbstractC2848n.u(this.f2592e == this.f2593f, "inflaterInput has unconsumed bytes");
        int iMin = Math.min(this.f2588a.d(), 512);
        if (iMin == 0) {
            return false;
        }
        this.f2592e = 0;
        this.f2593f = iMin;
        this.f2588a.J(this.f2591d, 0, iMin);
        this.f2594g.setInput(this.f2591d, this.f2592e, iMin);
        this.f2595h = c.INFLATING;
        return true;
    }

    public int K() {
        int i8 = this.f2600m;
        this.f2600m = 0;
        return i8;
    }

    public int M() {
        int i8 = this.f2601n;
        this.f2601n = 0;
        return i8;
    }

    public boolean N() {
        AbstractC2848n.u(!this.f2596i, "GzipInflatingBuffer is closed");
        return (this.f2590c.k() == 0 && this.f2595h == c.HEADER) ? false : true;
    }

    public final int O(byte[] bArr, int i8, int i9) throws DataFormatException {
        c cVar;
        AbstractC2848n.u(this.f2594g != null, "inflater is null");
        try {
            int totalIn = this.f2594g.getTotalIn();
            int iInflate = this.f2594g.inflate(bArr, i8, i9);
            int totalIn2 = this.f2594g.getTotalIn() - totalIn;
            this.f2600m += totalIn2;
            this.f2601n += totalIn2;
            this.f2592e += totalIn2;
            this.f2589b.update(bArr, i8, iInflate);
            if (!this.f2594g.finished()) {
                if (this.f2594g.needsInput()) {
                    cVar = c.INFLATER_NEEDS_INPUT;
                }
                return iInflate;
            }
            this.f2599l = this.f2594g.getBytesWritten() & KeyboardMap.kValueMask;
            cVar = c.TRAILER;
            this.f2595h = cVar;
            return iInflate;
        } catch (DataFormatException e8) {
            throw new DataFormatException("Inflater data format exception: " + e8.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        if (r2 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (r6.f2595h != G4.T.c.f2605a) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
    
        if (r6.f2590c.k() >= 10) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0086, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        r6.f2602o = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int Q(byte[] r7, int r8, int r9) throws java.util.zip.ZipException {
        /*
            r6 = this;
            boolean r0 = r6.f2596i
            r1 = 1
            r0 = r0 ^ r1
            java.lang.String r2 = "GzipInflatingBuffer is closed"
            v2.AbstractC2848n.u(r0, r2)
            r0 = 0
            r3 = r0
        Lb:
            r2 = r1
        Lc:
            if (r2 == 0) goto L73
            int r4 = r9 - r3
            if (r4 <= 0) goto L73
            int[] r2 = G4.T.a.f2603a
            G4.T$c r5 = r6.f2595h
            int r5 = r5.ordinal()
            r2 = r2[r5]
            switch(r2) {
                case 1: goto L6e;
                case 2: goto L69;
                case 3: goto L64;
                case 4: goto L5f;
                case 5: goto L5a;
                case 6: goto L55;
                case 7: goto L50;
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
            G4.T$c r9 = r6.f2595h
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L38:
            boolean r2 = r6.m0()
            goto Lc
        L3d:
            boolean r2 = r6.E()
            goto Lc
        L42:
            int r2 = r8 + r3
            int r2 = r6.O(r7, r2, r4)
            int r3 = r3 + r2
            G4.T$c r2 = r6.f2595h
            G4.T$c r4 = G4.T.c.TRAILER
            if (r2 != r4) goto Lb
            goto L38
        L50:
            boolean r2 = r6.R()
            goto Lc
        L55:
            boolean r2 = r6.W()
            goto Lc
        L5a:
            boolean r2 = r6.U()
            goto Lc
        L5f:
            boolean r2 = r6.i0()
            goto Lc
        L64:
            boolean r2 = r6.X()
            goto Lc
        L69:
            boolean r2 = r6.b0()
            goto Lc
        L6e:
            boolean r2 = r6.T()
            goto Lc
        L73:
            if (r2 == 0) goto L87
            G4.T$c r7 = r6.f2595h
            G4.T$c r8 = G4.T.c.HEADER
            if (r7 != r8) goto L86
            G4.T$b r7 = r6.f2590c
            int r7 = G4.T.b.d(r7)
            r8 = 10
            if (r7 >= r8) goto L86
            goto L87
        L86:
            r1 = r0
        L87:
            r6.f2602o = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: G4.T.Q(byte[], int, int):int");
    }

    public final boolean R() {
        c cVar;
        Inflater inflater = this.f2594g;
        if (inflater == null) {
            this.f2594g = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.f2589b.reset();
        int i8 = this.f2593f;
        int i9 = this.f2592e;
        int i10 = i8 - i9;
        if (i10 > 0) {
            this.f2594g.setInput(this.f2591d, i9, i10);
            cVar = c.INFLATING;
        } else {
            cVar = c.INFLATER_NEEDS_INPUT;
        }
        this.f2595h = cVar;
        return true;
    }

    public boolean S() {
        AbstractC2848n.u(!this.f2596i, "GzipInflatingBuffer is closed");
        return this.f2602o;
    }

    public final boolean T() throws ZipException {
        if (this.f2590c.k() < 10) {
            return false;
        }
        if (this.f2590c.j() != 35615) {
            throw new ZipException("Not in GZIP format");
        }
        if (this.f2590c.h() != 8) {
            throw new ZipException("Unsupported compression method");
        }
        this.f2597j = this.f2590c.h();
        this.f2590c.l(6);
        this.f2595h = c.HEADER_EXTRA_LEN;
        return true;
    }

    public final boolean U() {
        if ((this.f2597j & 16) == 16 && !this.f2590c.g()) {
            return false;
        }
        this.f2595h = c.HEADER_CRC;
        return true;
    }

    public final boolean W() throws ZipException {
        if ((this.f2597j & 2) == 2) {
            if (this.f2590c.k() < 2) {
                return false;
            }
            if ((((int) this.f2589b.getValue()) & 65535) != this.f2590c.j()) {
                throw new ZipException("Corrupt GZIP header");
            }
        }
        this.f2595h = c.INITIALIZE_INFLATER;
        return true;
    }

    public final boolean X() {
        int iK = this.f2590c.k();
        int i8 = this.f2598k;
        if (iK < i8) {
            return false;
        }
        this.f2590c.l(i8);
        this.f2595h = c.HEADER_NAME;
        return true;
    }

    public final boolean b0() {
        c cVar;
        if ((this.f2597j & 4) != 4) {
            cVar = c.HEADER_NAME;
        } else {
            if (this.f2590c.k() < 2) {
                return false;
            }
            this.f2598k = this.f2590c.j();
            cVar = c.HEADER_EXTRA;
        }
        this.f2595h = cVar;
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f2596i) {
            return;
        }
        this.f2596i = true;
        this.f2588a.close();
        Inflater inflater = this.f2594g;
        if (inflater != null) {
            inflater.end();
            this.f2594g = null;
        }
    }

    public final boolean i0() {
        if ((this.f2597j & 8) == 8 && !this.f2590c.g()) {
            return false;
        }
        this.f2595h = c.HEADER_COMMENT;
        return true;
    }

    public final boolean m0() throws ZipException {
        if (this.f2594g != null && this.f2590c.k() <= 18) {
            this.f2594g.end();
            this.f2594g = null;
        }
        if (this.f2590c.k() < 8) {
            return false;
        }
        if (this.f2589b.getValue() != this.f2590c.i() || this.f2599l != this.f2590c.i()) {
            throw new ZipException("Corrupt GZIP trailer");
        }
        this.f2589b.reset();
        this.f2595h = c.HEADER;
        return true;
    }
}
