package tb;

import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.DataFormatException;
import rb.l;
import tb.p2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class l1 implements Closeable, z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f21474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n2 f21476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t2 f21477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public rb.u f21478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s0 f21479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f21480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21481h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f21484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public v f21485l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f21487n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21490q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f21482i = e.HEADER;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21483j = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public v f21486m = new v();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f21488o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21489p = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f21491r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f21492s = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21493a;

        static {
            int[] iArr = new int[e.values().length];
            f21493a = iArr;
            try {
                iArr[e.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21493a[e.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void a(p2.a aVar);

        void c(boolean z10);

        void d(int i10);

        void e(Throwable th);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements p2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputStream f21494a;

        public /* synthetic */ c(InputStream inputStream, a aVar) {
            this(inputStream);
        }

        @Override // tb.p2.a
        public InputStream next() {
            InputStream inputStream = this.f21494a;
            this.f21494a = null;
            return inputStream;
        }

        public c(InputStream inputStream) {
            this.f21494a = inputStream;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum e {
        HEADER,
        BODY
    }

    public l1(b bVar, rb.u uVar, int i10, n2 n2Var, t2 t2Var) {
        this.f21474a = (b) p6.n.o(bVar, "sink");
        this.f21478e = (rb.u) p6.n.o(uVar, "decompressor");
        this.f21475b = i10;
        this.f21476c = (n2) p6.n.o(n2Var, "statsTraceCtx");
        this.f21477d = (t2) p6.n.o(t2Var, "transportTracer");
    }

    public final void C() {
        if (this.f21488o) {
            return;
        }
        this.f21488o = true;
        while (!this.f21492s && this.f21487n > 0 && R()) {
            try {
                int i10 = a.f21493a[this.f21482i.ordinal()];
                if (i10 == 1) {
                    O();
                } else {
                    if (i10 != 2) {
                        throw new AssertionError("Invalid state: " + this.f21482i);
                    }
                    N();
                    this.f21487n--;
                }
            } catch (Throwable th) {
                this.f21488o = false;
                throw th;
            }
        }
        if (this.f21492s) {
            close();
            this.f21488o = false;
        } else {
            if (this.f21491r && K()) {
                close();
            }
            this.f21488o = false;
        }
    }

    public final InputStream E() {
        rb.u uVar = this.f21478e;
        if (uVar == l.b.f19636a) {
            throw rb.k1.f19606s.r("Can't decode compressed gRPC message as compression not configured").d();
        }
        try {
            return new d(uVar.b(y1.c(this.f21485l, true)), this.f21475b, this.f21476c);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final InputStream G() {
        this.f21476c.f(this.f21485l.d());
        return y1.c(this.f21485l, true);
    }

    public final boolean H() {
        return isClosed() || this.f21491r;
    }

    public final boolean K() {
        s0 s0Var = this.f21479f;
        return s0Var != null ? s0Var.b0() : this.f21486m.d() == 0;
    }

    public final void N() {
        this.f21476c.e(this.f21489p, this.f21490q, -1L);
        this.f21490q = 0;
        InputStream inputStreamE = this.f21484k ? E() : G();
        this.f21485l.M();
        this.f21485l = null;
        this.f21474a.a(new c(inputStreamE, null));
        this.f21482i = e.HEADER;
        this.f21483j = 5;
    }

    public final void O() {
        int unsignedByte = this.f21485l.readUnsignedByte();
        if ((unsignedByte & 254) != 0) {
            throw rb.k1.f19606s.r("gRPC frame header malformed: reserved bits not zero").d();
        }
        this.f21484k = (unsignedByte & 1) != 0;
        int i10 = this.f21485l.readInt();
        this.f21483j = i10;
        if (i10 < 0 || i10 > this.f21475b) {
            throw rb.k1.f19601n.r(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.f21475b), Integer.valueOf(this.f21483j))).d();
        }
        int i11 = this.f21489p + 1;
        this.f21489p = i11;
        this.f21476c.d(i11);
        this.f21477d.d();
        this.f21482i = e.BODY;
    }

    public final boolean R() throws Throwable {
        int iN;
        int i10 = 0;
        try {
            if (this.f21485l == null) {
                this.f21485l = new v();
            }
            int iK = 0;
            iN = 0;
            while (true) {
                try {
                    int iD = this.f21483j - this.f21485l.d();
                    if (iD <= 0) {
                        if (iK > 0) {
                            this.f21474a.d(iK);
                            if (this.f21482i == e.BODY) {
                                if (this.f21479f != null) {
                                    this.f21476c.g(iN);
                                    this.f21490q += iN;
                                    return true;
                                }
                                this.f21476c.g(iK);
                                this.f21490q += iK;
                            }
                        }
                        return true;
                    }
                    if (this.f21479f != null) {
                        try {
                            byte[] bArr = this.f21480g;
                            if (bArr == null || this.f21481h == bArr.length) {
                                this.f21480g = new byte[Math.min(iD, 2097152)];
                                this.f21481h = 0;
                            }
                            int iZ = this.f21479f.Z(this.f21480g, this.f21481h, Math.min(iD, this.f21480g.length - this.f21481h));
                            iK += this.f21479f.K();
                            iN += this.f21479f.N();
                            if (iZ == 0) {
                                if (iK > 0) {
                                    this.f21474a.d(iK);
                                    if (this.f21482i == e.BODY) {
                                        if (this.f21479f != null) {
                                            this.f21476c.g(iN);
                                            this.f21490q += iN;
                                            return false;
                                        }
                                        this.f21476c.g(iK);
                                        this.f21490q += iK;
                                    }
                                }
                                return false;
                            }
                            this.f21485l.c(y1.f(this.f21480g, this.f21481h, iZ));
                            this.f21481h += iZ;
                        } catch (IOException e10) {
                            throw new RuntimeException(e10);
                        } catch (DataFormatException e11) {
                            throw new RuntimeException(e11);
                        }
                    } else {
                        if (this.f21486m.d() == 0) {
                            if (iK > 0) {
                                this.f21474a.d(iK);
                                if (this.f21482i == e.BODY) {
                                    if (this.f21479f != null) {
                                        this.f21476c.g(iN);
                                        this.f21490q += iN;
                                        return false;
                                    }
                                    this.f21476c.g(iK);
                                    this.f21490q += iK;
                                }
                            }
                            return false;
                        }
                        int iMin = Math.min(iD, this.f21486m.d());
                        iK += iMin;
                        this.f21485l.c(this.f21486m.n(iMin));
                    }
                } catch (Throwable th) {
                    int i11 = iK;
                    th = th;
                    i10 = i11;
                    if (i10 > 0) {
                        this.f21474a.d(i10);
                        if (this.f21482i == e.BODY) {
                            if (this.f21479f != null) {
                                this.f21476c.g(iN);
                                this.f21490q += iN;
                            } else {
                                this.f21476c.g(i10);
                                this.f21490q += i10;
                            }
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            iN = 0;
        }
    }

    public void Z(s0 s0Var) {
        p6.n.u(this.f21478e == l.b.f19636a, "per-message decompressor already set");
        p6.n.u(this.f21479f == null, "full stream decompressor already set");
        this.f21479f = (s0) p6.n.o(s0Var, "Can't pass a null full stream decompressor");
        this.f21486m = null;
    }

    public void a0(b bVar) {
        this.f21474a = bVar;
    }

    @Override // tb.z
    public void b(int i10) {
        p6.n.e(i10 > 0, "numMessages must be > 0");
        if (isClosed()) {
            return;
        }
        this.f21487n += (long) i10;
        C();
    }

    public void b0() {
        this.f21492s = true;
    }

    @Override // tb.z
    public void c(int i10) {
        this.f21475b = i10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, tb.z
    public void close() {
        if (isClosed()) {
            return;
        }
        v vVar = this.f21485l;
        boolean z10 = vVar != null && vVar.d() > 0;
        try {
            s0 s0Var = this.f21479f;
            if (s0Var != null) {
                boolean z11 = z10 || s0Var.O();
                this.f21479f.close();
                z10 = z11;
            }
            v vVar2 = this.f21486m;
            if (vVar2 != null) {
                vVar2.close();
            }
            v vVar3 = this.f21485l;
            if (vVar3 != null) {
                vVar3.close();
            }
            this.f21479f = null;
            this.f21486m = null;
            this.f21485l = null;
            this.f21474a.c(z10);
        } catch (Throwable th) {
            this.f21479f = null;
            this.f21486m = null;
            this.f21485l = null;
            throw th;
        }
    }

    @Override // tb.z
    public void e(x1 x1Var) throws Throwable {
        p6.n.o(x1Var, "data");
        boolean z10 = true;
        try {
            if (H()) {
                x1Var.close();
                return;
            }
            s0 s0Var = this.f21479f;
            if (s0Var != null) {
                s0Var.G(x1Var);
            } else {
                this.f21486m.c(x1Var);
            }
            try {
                C();
            } catch (Throwable th) {
                th = th;
                z10 = false;
                if (z10) {
                    x1Var.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean isClosed() {
        return this.f21486m == null && this.f21479f == null;
    }

    @Override // tb.z
    public void o(rb.u uVar) {
        p6.n.u(this.f21479f == null, "Already set full stream decompressor");
        this.f21478e = (rb.u) p6.n.o(uVar, "Can't pass an empty decompressor");
    }

    @Override // tb.z
    public void u() {
        if (isClosed()) {
            return;
        }
        if (K()) {
            close();
        } else {
            this.f21491r = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n2 f21496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f21497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f21498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f21499e;

        public d(InputStream inputStream, int i10, n2 n2Var) {
            super(inputStream);
            this.f21499e = -1L;
            this.f21495a = i10;
            this.f21496b = n2Var;
        }

        public final void b() {
            long j10 = this.f21498d;
            long j11 = this.f21497c;
            if (j10 > j11) {
                this.f21496b.f(j10 - j11);
                this.f21497c = this.f21498d;
            }
        }

        public final void c() {
            if (this.f21498d <= this.f21495a) {
                return;
            }
            throw rb.k1.f19601n.r("Decompressed gRPC message exceeds maximum size " + this.f21495a).d();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i10) {
            ((FilterInputStream) this).in.mark(i10);
            this.f21499e = this.f21498d;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i10 = ((FilterInputStream) this).in.read();
            if (i10 != -1) {
                this.f21498d++;
            }
            c();
            b();
            return i10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f21499e == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f21498d = this.f21499e;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j10) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(j10);
            this.f21498d += jSkip;
            c();
            b();
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
            if (i12 != -1) {
                this.f21498d += (long) i12;
            }
            c();
            b();
            return i12;
        }
    }
}
