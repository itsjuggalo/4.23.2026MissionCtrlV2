package t5;

import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.DataFormatException;
import r5.InterfaceC2596l;
import r5.InterfaceC2604u;
import t5.Q0;

/* JADX INFO: renamed from: t5.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2688m0 implements Closeable, InterfaceC2710z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f24029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final O0 f24031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final U0 f24032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InterfaceC2604u f24033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T f24034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f24035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f24036h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f24039k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C2704v f24040l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f24042n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f24045q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f24037i = e.HEADER;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f24038j = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C2704v f24041m = new C2704v();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f24043o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f24044p = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f24046r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f24047s = false;

    /* JADX INFO: renamed from: t5.m0$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24048a;

        static {
            int[] iArr = new int[e.values().length];
            f24048a = iArr;
            try {
                iArr[e.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24048a[e.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: t5.m0$b */
    public interface b {
        void a(Q0.a aVar);

        void c(boolean z7);

        void d(int i7);

        void e(Throwable th);
    }

    /* JADX INFO: renamed from: t5.m0$c */
    public static class c implements Q0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputStream f24049a;

        public /* synthetic */ c(InputStream inputStream, a aVar) {
            this(inputStream);
        }

        @Override // t5.Q0.a
        public InputStream next() {
            InputStream inputStream = this.f24049a;
            this.f24049a = null;
            return inputStream;
        }

        public c(InputStream inputStream) {
            this.f24049a = inputStream;
        }
    }

    /* JADX INFO: renamed from: t5.m0$e */
    public enum e {
        HEADER,
        BODY
    }

    public C2688m0(b bVar, InterfaceC2604u interfaceC2604u, int i7, O0 o02, U0 u02) {
        this.f24029a = (b) H2.m.o(bVar, "sink");
        this.f24033e = (InterfaceC2604u) H2.m.o(interfaceC2604u, "decompressor");
        this.f24030b = i7;
        this.f24031c = (O0) H2.m.o(o02, "statsTraceCtx");
        this.f24032d = (U0) H2.m.o(u02, "transportTracer");
    }

    @Override // t5.InterfaceC2710z
    public void A() {
        if (T()) {
            return;
        }
        if (X()) {
            close();
        } else {
            this.f24046r = true;
        }
    }

    public void A0(b bVar) {
        this.f24029a = bVar;
    }

    public void B0() {
        this.f24047s = true;
    }

    @Override // t5.InterfaceC2710z
    public void G(y0 y0Var) throws Throwable {
        H2.m.o(y0Var, "data");
        boolean z7 = true;
        try {
            if (V()) {
                y0Var.close();
                return;
            }
            T t7 = this.f24034f;
            if (t7 != null) {
                t7.O(y0Var);
            } else {
                this.f24041m.i(y0Var);
            }
            try {
                K();
            } catch (Throwable th) {
                th = th;
                z7 = false;
                if (z7) {
                    y0Var.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // t5.InterfaceC2710z
    public void H(InterfaceC2604u interfaceC2604u) {
        H2.m.u(this.f24034f == null, "Already set full stream decompressor");
        this.f24033e = (InterfaceC2604u) H2.m.o(interfaceC2604u, "Can't pass an empty decompressor");
    }

    public final void K() {
        if (this.f24043o) {
            return;
        }
        this.f24043o = true;
        while (!this.f24047s && this.f24042n > 0 && y0()) {
            try {
                int i7 = a.f24048a[this.f24037i.ordinal()];
                if (i7 == 1) {
                    i0();
                } else {
                    if (i7 != 2) {
                        throw new AssertionError("Invalid state: " + this.f24037i);
                    }
                    c0();
                    this.f24042n--;
                }
            } catch (Throwable th) {
                this.f24043o = false;
                throw th;
            }
        }
        if (this.f24047s) {
            close();
            this.f24043o = false;
        } else {
            if (this.f24046r && X()) {
                close();
            }
            this.f24043o = false;
        }
    }

    public final InputStream M() {
        InterfaceC2604u interfaceC2604u = this.f24033e;
        if (interfaceC2604u == InterfaceC2596l.b.f22703a) {
            throw r5.l0.f22719s.q("Can't decode compressed gRPC message as compression not configured").d();
        }
        try {
            return new d(interfaceC2604u.b(z0.c(this.f24040l, true)), this.f24030b, this.f24031c);
        } catch (IOException e7) {
            throw new RuntimeException(e7);
        }
    }

    public final InputStream O() {
        this.f24031c.f(this.f24040l.e());
        return z0.c(this.f24040l, true);
    }

    public boolean T() {
        return this.f24041m == null && this.f24034f == null;
    }

    public final boolean V() {
        return T() || this.f24046r;
    }

    public final boolean X() {
        T t7 = this.f24034f;
        return t7 != null ? t7.A0() : this.f24041m.e() == 0;
    }

    public final void c0() {
        this.f24031c.e(this.f24044p, this.f24045q, -1L);
        this.f24045q = 0;
        InputStream inputStreamM = this.f24039k ? M() : O();
        this.f24040l.b0();
        this.f24040l = null;
        this.f24029a.a(new c(inputStreamM, null));
        this.f24037i = e.HEADER;
        this.f24038j = 5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, t5.InterfaceC2710z
    public void close() {
        if (T()) {
            return;
        }
        C2704v c2704v = this.f24040l;
        boolean z7 = c2704v != null && c2704v.e() > 0;
        try {
            T t7 = this.f24034f;
            if (t7 != null) {
                boolean z8 = z7 || t7.c0();
                this.f24034f.close();
                z7 = z8;
            }
            C2704v c2704v2 = this.f24041m;
            if (c2704v2 != null) {
                c2704v2.close();
            }
            C2704v c2704v3 = this.f24040l;
            if (c2704v3 != null) {
                c2704v3.close();
            }
            this.f24034f = null;
            this.f24041m = null;
            this.f24040l = null;
            this.f24029a.c(z7);
        } catch (Throwable th) {
            this.f24034f = null;
            this.f24041m = null;
            this.f24040l = null;
            throw th;
        }
    }

    @Override // t5.InterfaceC2710z
    public void h(int i7) {
        H2.m.e(i7 > 0, "numMessages must be > 0");
        if (T()) {
            return;
        }
        this.f24042n += (long) i7;
        K();
    }

    @Override // t5.InterfaceC2710z
    public void i(int i7) {
        this.f24030b = i7;
    }

    public final void i0() {
        int unsignedByte = this.f24040l.readUnsignedByte();
        if ((unsignedByte & 254) != 0) {
            throw r5.l0.f22719s.q("gRPC frame header malformed: reserved bits not zero").d();
        }
        this.f24039k = (unsignedByte & 1) != 0;
        int i7 = this.f24040l.readInt();
        this.f24038j = i7;
        if (i7 < 0 || i7 > this.f24030b) {
            throw r5.l0.f22714n.q(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.f24030b), Integer.valueOf(this.f24038j))).d();
        }
        int i8 = this.f24044p + 1;
        this.f24044p = i8;
        this.f24031c.d(i8);
        this.f24032d.d();
        this.f24037i = e.BODY;
    }

    public final boolean y0() throws Throwable {
        int iX;
        int i7 = 0;
        try {
            if (this.f24040l == null) {
                this.f24040l = new C2704v();
            }
            int iV = 0;
            iX = 0;
            while (true) {
                try {
                    int iE = this.f24038j - this.f24040l.e();
                    if (iE <= 0) {
                        if (iV <= 0) {
                            return true;
                        }
                        this.f24029a.d(iV);
                        if (this.f24037i != e.BODY) {
                            return true;
                        }
                        if (this.f24034f != null) {
                            this.f24031c.g(iX);
                            this.f24045q += iX;
                            return true;
                        }
                        this.f24031c.g(iV);
                        this.f24045q += iV;
                        return true;
                    }
                    if (this.f24034f != null) {
                        try {
                            byte[] bArr = this.f24035g;
                            if (bArr == null || this.f24036h == bArr.length) {
                                this.f24035g = new byte[Math.min(iE, 2097152)];
                                this.f24036h = 0;
                            }
                            int iY0 = this.f24034f.y0(this.f24035g, this.f24036h, Math.min(iE, this.f24035g.length - this.f24036h));
                            iV += this.f24034f.V();
                            iX += this.f24034f.X();
                            if (iY0 == 0) {
                                if (iV > 0) {
                                    this.f24029a.d(iV);
                                    if (this.f24037i == e.BODY) {
                                        if (this.f24034f != null) {
                                            this.f24031c.g(iX);
                                            this.f24045q += iX;
                                        } else {
                                            this.f24031c.g(iV);
                                            this.f24045q += iV;
                                        }
                                    }
                                }
                                return false;
                            }
                            this.f24040l.i(z0.f(this.f24035g, this.f24036h, iY0));
                            this.f24036h += iY0;
                        } catch (IOException e7) {
                            throw new RuntimeException(e7);
                        } catch (DataFormatException e8) {
                            throw new RuntimeException(e8);
                        }
                    } else {
                        if (this.f24041m.e() == 0) {
                            if (iV > 0) {
                                this.f24029a.d(iV);
                                if (this.f24037i == e.BODY) {
                                    if (this.f24034f != null) {
                                        this.f24031c.g(iX);
                                        this.f24045q += iX;
                                    } else {
                                        this.f24031c.g(iV);
                                        this.f24045q += iV;
                                    }
                                }
                            }
                            return false;
                        }
                        int iMin = Math.min(iE, this.f24041m.e());
                        iV += iMin;
                        this.f24040l.i(this.f24041m.s(iMin));
                    }
                } catch (Throwable th) {
                    int i8 = iV;
                    th = th;
                    i7 = i8;
                    if (i7 > 0) {
                        this.f24029a.d(i7);
                        if (this.f24037i == e.BODY) {
                            if (this.f24034f != null) {
                                this.f24031c.g(iX);
                                this.f24045q += iX;
                            } else {
                                this.f24031c.g(i7);
                                this.f24045q += i7;
                            }
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            iX = 0;
        }
    }

    public void z0(T t7) {
        H2.m.u(this.f24033e == InterfaceC2596l.b.f22703a, "per-message decompressor already set");
        H2.m.u(this.f24034f == null, "full stream decompressor already set");
        this.f24034f = (T) H2.m.o(t7, "Can't pass a null full stream decompressor");
        this.f24041m = null;
    }

    /* JADX INFO: renamed from: t5.m0$d */
    public static final class d extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final O0 f24051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f24052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f24053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f24054e;

        public d(InputStream inputStream, int i7, O0 o02) {
            super(inputStream);
            this.f24054e = -1L;
            this.f24050a = i7;
            this.f24051b = o02;
        }

        public final void h() {
            long j7 = this.f24053d;
            long j8 = this.f24052c;
            if (j7 > j8) {
                this.f24051b.f(j7 - j8);
                this.f24052c = this.f24053d;
            }
        }

        public final void i() {
            if (this.f24053d <= this.f24050a) {
                return;
            }
            throw r5.l0.f22714n.q("Decompressed gRPC message exceeds maximum size " + this.f24050a).d();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i7) {
            ((FilterInputStream) this).in.mark(i7);
            this.f24054e = this.f24053d;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i7 = ((FilterInputStream) this).in.read();
            if (i7 != -1) {
                this.f24053d++;
            }
            i();
            h();
            return i7;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f24054e == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f24053d = this.f24054e;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j7) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(j7);
            this.f24053d += jSkip;
            i();
            h();
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) throws IOException {
            int i9 = ((FilterInputStream) this).in.read(bArr, i7, i8);
            if (i9 != -1) {
                this.f24053d += (long) i9;
            }
            i();
            h();
            return i9;
        }
    }
}
