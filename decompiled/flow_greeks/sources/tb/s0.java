package tb;

import io.flutter.embedding.android.KeyboardMap;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class s0 implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Inflater f21706g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21709j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21710k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f21711l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f21700a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CRC32 f21701b = new CRC32();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f21702c = new b(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f21703d = new byte[512];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f21707h = c.HEADER;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21708i = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f21712m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f21713n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f21714o = true;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21715a;

        static {
            int[] iArr = new int[c.values().length];
            f21715a = iArr;
            try {
                iArr[c.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21715a[c.HEADER_EXTRA_LEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21715a[c.HEADER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21715a[c.HEADER_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21715a[c.HEADER_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21715a[c.HEADER_CRC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21715a[c.INITIALIZE_INFLATER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f21715a[c.INFLATING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f21715a[c.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f21715a[c.TRAILER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
            if (s0.this.f21705f - s0.this.f21704e > 0) {
                unsignedByte = s0.this.f21703d[s0.this.f21704e] & 255;
                s0.e(s0.this, 1);
            } else {
                unsignedByte = s0.this.f21700a.readUnsignedByte();
            }
            s0.this.f21701b.update(unsignedByte);
            s0.E(s0.this, 1);
            return unsignedByte;
        }

        public final long i() {
            return ((long) j()) | (((long) j()) << 16);
        }

        public final int j() {
            return h() | (h() << 8);
        }

        public final int k() {
            return (s0.this.f21705f - s0.this.f21704e) + s0.this.f21700a.d();
        }

        public final void l(int i10) {
            int i11;
            int i12 = s0.this.f21705f - s0.this.f21704e;
            if (i12 > 0) {
                int iMin = Math.min(i12, i10);
                s0.this.f21701b.update(s0.this.f21703d, s0.this.f21704e, iMin);
                s0.e(s0.this, iMin);
                i11 = i10 - iMin;
            } else {
                i11 = i10;
            }
            if (i11 > 0) {
                byte[] bArr = new byte[512];
                int i13 = 0;
                while (i13 < i11) {
                    int iMin2 = Math.min(i11 - i13, 512);
                    s0.this.f21700a.z(bArr, 0, iMin2);
                    s0.this.f21701b.update(bArr, 0, iMin2);
                    i13 += iMin2;
                }
            }
            s0.E(s0.this, i10);
        }

        public /* synthetic */ b(s0 s0Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    public static /* synthetic */ int E(s0 s0Var, int i10) {
        int i11 = s0Var.f21712m + i10;
        s0Var.f21712m = i11;
        return i11;
    }

    public static /* synthetic */ int e(s0 s0Var, int i10) {
        int i11 = s0Var.f21704e + i10;
        s0Var.f21704e = i11;
        return i11;
    }

    public void G(x1 x1Var) {
        p6.n.u(!this.f21708i, "GzipInflatingBuffer is closed");
        this.f21700a.c(x1Var);
        this.f21714o = false;
    }

    public final boolean H() {
        p6.n.u(this.f21706g != null, "inflater is null");
        p6.n.u(this.f21704e == this.f21705f, "inflaterInput has unconsumed bytes");
        int iMin = Math.min(this.f21700a.d(), 512);
        if (iMin == 0) {
            return false;
        }
        this.f21704e = 0;
        this.f21705f = iMin;
        this.f21700a.z(this.f21703d, 0, iMin);
        this.f21706g.setInput(this.f21703d, this.f21704e, iMin);
        this.f21707h = c.INFLATING;
        return true;
    }

    public int K() {
        int i10 = this.f21712m;
        this.f21712m = 0;
        return i10;
    }

    public int N() {
        int i10 = this.f21713n;
        this.f21713n = 0;
        return i10;
    }

    public boolean O() {
        p6.n.u(!this.f21708i, "GzipInflatingBuffer is closed");
        return (this.f21702c.k() == 0 && this.f21707h == c.HEADER) ? false : true;
    }

    public final int R(byte[] bArr, int i10, int i11) throws DataFormatException {
        p6.n.u(this.f21706g != null, "inflater is null");
        try {
            int totalIn = this.f21706g.getTotalIn();
            int iInflate = this.f21706g.inflate(bArr, i10, i11);
            int totalIn2 = this.f21706g.getTotalIn() - totalIn;
            this.f21712m += totalIn2;
            this.f21713n += totalIn2;
            this.f21704e += totalIn2;
            this.f21701b.update(bArr, i10, iInflate);
            if (this.f21706g.finished()) {
                this.f21711l = this.f21706g.getBytesWritten() & KeyboardMap.kValueMask;
                this.f21707h = c.TRAILER;
                return iInflate;
            }
            if (this.f21706g.needsInput()) {
                this.f21707h = c.INFLATER_NEEDS_INPUT;
            }
            return iInflate;
        } catch (DataFormatException e10) {
            throw new DataFormatException("Inflater data format exception: " + e10.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        if (r2 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
    
        if (r6.f21707h != tb.s0.c.f21717a) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0087, code lost:
    
        if (r6.f21702c.k() >= 10) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
    
        r6.f21714o = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008d, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int Z(byte[] r7, int r8, int r9) throws java.util.zip.ZipException {
        /*
            r6 = this;
            boolean r0 = r6.f21708i
            r1 = 1
            r0 = r0 ^ r1
            java.lang.String r2 = "GzipInflatingBuffer is closed"
            p6.n.u(r0, r2)
            r0 = 0
            r3 = r0
        Lb:
            r2 = r1
        Lc:
            if (r2 == 0) goto L77
            int r4 = r9 - r3
            if (r4 <= 0) goto L77
            int[] r2 = tb.s0.a.f21715a
            tb.s0$c r5 = r6.f21707h
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
            tb.s0$c r9 = r6.f21707h
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L38:
            boolean r2 = r6.i0()
            goto Lc
        L3d:
            boolean r2 = r6.H()
            goto Lc
        L42:
            int r2 = r8 + r3
            int r2 = r6.R(r7, r2, r4)
            int r3 = r3 + r2
            tb.s0$c r2 = r6.f21707h
            tb.s0$c r4 = tb.s0.c.TRAILER
            if (r2 != r4) goto Lb
            boolean r2 = r6.i0()
            goto Lc
        L54:
            boolean r2 = r6.a0()
            goto Lc
        L59:
            boolean r2 = r6.e0()
            goto Lc
        L5e:
            boolean r2 = r6.d0()
            goto Lc
        L63:
            boolean r2 = r6.h0()
            goto Lc
        L68:
            boolean r2 = r6.f0()
            goto Lc
        L6d:
            boolean r2 = r6.g0()
            goto Lc
        L72:
            boolean r2 = r6.c0()
            goto Lc
        L77:
            if (r2 == 0) goto L8b
            tb.s0$c r7 = r6.f21707h
            tb.s0$c r8 = tb.s0.c.HEADER
            if (r7 != r8) goto L8a
            tb.s0$b r7 = r6.f21702c
            int r7 = tb.s0.b.d(r7)
            r8 = 10
            if (r7 >= r8) goto L8a
            goto L8b
        L8a:
            r1 = r0
        L8b:
            r6.f21714o = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.s0.Z(byte[], int, int):int");
    }

    public final boolean a0() {
        Inflater inflater = this.f21706g;
        if (inflater == null) {
            this.f21706g = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.f21701b.reset();
        int i10 = this.f21705f;
        int i11 = this.f21704e;
        int i12 = i10 - i11;
        if (i12 > 0) {
            this.f21706g.setInput(this.f21703d, i11, i12);
            this.f21707h = c.INFLATING;
        } else {
            this.f21707h = c.INFLATER_NEEDS_INPUT;
        }
        return true;
    }

    public boolean b0() {
        p6.n.u(!this.f21708i, "GzipInflatingBuffer is closed");
        return this.f21714o;
    }

    public final boolean c0() throws ZipException {
        if (this.f21702c.k() < 10) {
            return false;
        }
        if (this.f21702c.j() != 35615) {
            throw new ZipException("Not in GZIP format");
        }
        if (this.f21702c.h() != 8) {
            throw new ZipException("Unsupported compression method");
        }
        this.f21709j = this.f21702c.h();
        this.f21702c.l(6);
        this.f21707h = c.HEADER_EXTRA_LEN;
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f21708i) {
            return;
        }
        this.f21708i = true;
        this.f21700a.close();
        Inflater inflater = this.f21706g;
        if (inflater != null) {
            inflater.end();
            this.f21706g = null;
        }
    }

    public final boolean d0() {
        if ((this.f21709j & 16) != 16) {
            this.f21707h = c.HEADER_CRC;
            return true;
        }
        if (!this.f21702c.g()) {
            return false;
        }
        this.f21707h = c.HEADER_CRC;
        return true;
    }

    public final boolean e0() throws ZipException {
        if ((this.f21709j & 2) != 2) {
            this.f21707h = c.INITIALIZE_INFLATER;
            return true;
        }
        if (this.f21702c.k() < 2) {
            return false;
        }
        if ((((int) this.f21701b.getValue()) & 65535) != this.f21702c.j()) {
            throw new ZipException("Corrupt GZIP header");
        }
        this.f21707h = c.INITIALIZE_INFLATER;
        return true;
    }

    public final boolean f0() {
        int iK = this.f21702c.k();
        int i10 = this.f21710k;
        if (iK < i10) {
            return false;
        }
        this.f21702c.l(i10);
        this.f21707h = c.HEADER_NAME;
        return true;
    }

    public final boolean g0() {
        if ((this.f21709j & 4) != 4) {
            this.f21707h = c.HEADER_NAME;
            return true;
        }
        if (this.f21702c.k() < 2) {
            return false;
        }
        this.f21710k = this.f21702c.j();
        this.f21707h = c.HEADER_EXTRA;
        return true;
    }

    public final boolean h0() {
        if ((this.f21709j & 8) != 8) {
            this.f21707h = c.HEADER_COMMENT;
            return true;
        }
        if (!this.f21702c.g()) {
            return false;
        }
        this.f21707h = c.HEADER_COMMENT;
        return true;
    }

    public final boolean i0() throws ZipException {
        if (this.f21706g != null && this.f21702c.k() <= 18) {
            this.f21706g.end();
            this.f21706g = null;
        }
        if (this.f21702c.k() < 8) {
            return false;
        }
        if (this.f21701b.getValue() != this.f21702c.i() || this.f21711l != this.f21702c.i()) {
            throw new ZipException("Corrupt GZIP trailer");
        }
        this.f21701b.reset();
        this.f21707h = c.HEADER;
        return true;
    }
}
