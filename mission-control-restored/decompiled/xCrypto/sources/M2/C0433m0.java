package M2;

import K2.InterfaceC0364l;
import K2.InterfaceC0372u;
import M2.Q0;
import com.google.firebase.messaging.Constants;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.DataFormatException;

/* JADX INFO: renamed from: M2.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0433m0 implements Closeable, InterfaceC0455z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f2478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final O0 f2480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final U0 f2481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InterfaceC0372u f2482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T f2483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f2484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2485h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2488k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C0449v f2489l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f2491n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2494q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f2486i = e.HEADER;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2487j = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C0449v f2490m = new C0449v();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2492o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2493p = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2495r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f2496s = false;

    /* JADX INFO: renamed from: M2.m0$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2497a;

        static {
            int[] iArr = new int[e.values().length];
            f2497a = iArr;
            try {
                iArr[e.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2497a[e.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: M2.m0$b */
    public interface b {
        void a(Q0.a aVar);

        void c(boolean z4);

        void d(int i4);

        void e(Throwable th);
    }

    /* JADX INFO: renamed from: M2.m0$c */
    public static class c implements Q0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputStream f2498a;

        public /* synthetic */ c(InputStream inputStream, a aVar) {
            this(inputStream);
        }

        @Override // M2.Q0.a
        public InputStream next() {
            InputStream inputStream = this.f2498a;
            this.f2498a = null;
            return inputStream;
        }

        public c(InputStream inputStream) {
            this.f2498a = inputStream;
        }
    }

    /* JADX INFO: renamed from: M2.m0$e */
    public enum e {
        HEADER,
        BODY
    }

    public C0433m0(b bVar, InterfaceC0372u interfaceC0372u, int i4, O0 o02, U0 u02) {
        this.f2478a = (b) Z1.m.o(bVar, "sink");
        this.f2482e = (InterfaceC0372u) Z1.m.o(interfaceC0372u, "decompressor");
        this.f2479b = i4;
        this.f2480c = (O0) Z1.m.o(o02, "statsTraceCtx");
        this.f2481d = (U0) Z1.m.o(u02, "transportTracer");
    }

    public final void A() {
        if (this.f2492o) {
            return;
        }
        this.f2492o = true;
        while (!this.f2496s && this.f2491n > 0 && d0()) {
            try {
                int i4 = a.f2497a[this.f2486i.ordinal()];
                if (i4 == 1) {
                    a0();
                } else {
                    if (i4 != 2) {
                        throw new AssertionError("Invalid state: " + this.f2486i);
                    }
                    S();
                    this.f2491n--;
                }
            } catch (Throwable th) {
                this.f2492o = false;
                throw th;
            }
        }
        if (this.f2496s) {
            close();
            this.f2492o = false;
        } else {
            if (this.f2495r && P()) {
                close();
            }
            this.f2492o = false;
        }
    }

    public final InputStream E() {
        InterfaceC0372u interfaceC0372u = this.f2482e;
        if (interfaceC0372u == InterfaceC0364l.b.f1213a) {
            throw K2.l0.f1229s.q("Can't decode compressed gRPC message as compression not configured").d();
        }
        try {
            return new d(interfaceC0372u.b(z0.c(this.f2489l, true)), this.f2479b, this.f2480c);
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }

    public final InputStream G() {
        this.f2480c.f(this.f2489l.d());
        return z0.c(this.f2489l, true);
    }

    public boolean J() {
        return this.f2490m == null && this.f2483f == null;
    }

    public final boolean K() {
        return J() || this.f2495r;
    }

    public final boolean P() {
        T t4 = this.f2483f;
        return t4 != null ? t4.f0() : this.f2490m.d() == 0;
    }

    public final void S() {
        this.f2480c.e(this.f2493p, this.f2494q, -1L);
        this.f2494q = 0;
        InputStream inputStreamE = this.f2488k ? E() : G();
        this.f2489l.O();
        this.f2489l = null;
        this.f2478a.a(new c(inputStreamE, null));
        this.f2486i = e.HEADER;
        this.f2487j = 5;
    }

    public final void a0() {
        int unsignedByte = this.f2489l.readUnsignedByte();
        if ((unsignedByte & 254) != 0) {
            throw K2.l0.f1229s.q("gRPC frame header malformed: reserved bits not zero").d();
        }
        this.f2488k = (unsignedByte & 1) != 0;
        int i4 = this.f2489l.readInt();
        this.f2487j = i4;
        if (i4 < 0 || i4 > this.f2479b) {
            throw K2.l0.f1224n.q(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.f2479b), Integer.valueOf(this.f2487j))).d();
        }
        int i5 = this.f2493p + 1;
        this.f2493p = i5;
        this.f2480c.d(i5);
        this.f2481d.d();
        this.f2486i = e.BODY;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, M2.InterfaceC0455z
    public void close() {
        if (J()) {
            return;
        }
        C0449v c0449v = this.f2489l;
        boolean z4 = c0449v != null && c0449v.d() > 0;
        try {
            T t4 = this.f2483f;
            if (t4 != null) {
                boolean z5 = z4 || t4.S();
                this.f2483f.close();
                z4 = z5;
            }
            C0449v c0449v2 = this.f2490m;
            if (c0449v2 != null) {
                c0449v2.close();
            }
            C0449v c0449v3 = this.f2489l;
            if (c0449v3 != null) {
                c0449v3.close();
            }
            this.f2483f = null;
            this.f2490m = null;
            this.f2489l = null;
            this.f2478a.c(z4);
        } catch (Throwable th) {
            this.f2483f = null;
            this.f2490m = null;
            this.f2489l = null;
            throw th;
        }
    }

    public final boolean d0() throws Throwable {
        int iP;
        int i4 = 0;
        try {
            if (this.f2489l == null) {
                this.f2489l = new C0449v();
            }
            int iK = 0;
            iP = 0;
            while (true) {
                try {
                    int iD = this.f2487j - this.f2489l.d();
                    if (iD <= 0) {
                        if (iK > 0) {
                            this.f2478a.d(iK);
                            if (this.f2486i == e.BODY) {
                                if (this.f2483f != null) {
                                    this.f2480c.g(iP);
                                    this.f2494q += iP;
                                    return true;
                                }
                                this.f2480c.g(iK);
                                this.f2494q += iK;
                            }
                        }
                        return true;
                    }
                    if (this.f2483f != null) {
                        try {
                            byte[] bArr = this.f2484g;
                            if (bArr == null || this.f2485h == bArr.length) {
                                this.f2484g = new byte[Math.min(iD, 2097152)];
                                this.f2485h = 0;
                            }
                            int iD0 = this.f2483f.d0(this.f2484g, this.f2485h, Math.min(iD, this.f2484g.length - this.f2485h));
                            iK += this.f2483f.K();
                            iP += this.f2483f.P();
                            if (iD0 == 0) {
                                if (iK > 0) {
                                    this.f2478a.d(iK);
                                    if (this.f2486i == e.BODY) {
                                        if (this.f2483f != null) {
                                            this.f2480c.g(iP);
                                            this.f2494q += iP;
                                            return false;
                                        }
                                        this.f2480c.g(iK);
                                        this.f2494q += iK;
                                    }
                                }
                                return false;
                            }
                            this.f2489l.f(z0.f(this.f2484g, this.f2485h, iD0));
                            this.f2485h += iD0;
                        } catch (IOException e4) {
                            throw new RuntimeException(e4);
                        } catch (DataFormatException e5) {
                            throw new RuntimeException(e5);
                        }
                    } else {
                        if (this.f2490m.d() == 0) {
                            if (iK > 0) {
                                this.f2478a.d(iK);
                                if (this.f2486i == e.BODY) {
                                    if (this.f2483f != null) {
                                        this.f2480c.g(iP);
                                        this.f2494q += iP;
                                        return false;
                                    }
                                    this.f2480c.g(iK);
                                    this.f2494q += iK;
                                }
                            }
                            return false;
                        }
                        int iMin = Math.min(iD, this.f2490m.d());
                        iK += iMin;
                        this.f2489l.f(this.f2490m.o(iMin));
                    }
                } catch (Throwable th) {
                    int i5 = iK;
                    th = th;
                    i4 = i5;
                    if (i4 > 0) {
                        this.f2478a.d(i4);
                        if (this.f2486i == e.BODY) {
                            if (this.f2483f != null) {
                                this.f2480c.g(iP);
                                this.f2494q += iP;
                            } else {
                                this.f2480c.g(i4);
                                this.f2494q += i4;
                            }
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            iP = 0;
        }
    }

    @Override // M2.InterfaceC0455z
    public void e(int i4) {
        Z1.m.e(i4 > 0, "numMessages must be > 0");
        if (J()) {
            return;
        }
        this.f2491n += (long) i4;
        A();
    }

    public void e0(T t4) {
        Z1.m.u(this.f2482e == InterfaceC0364l.b.f1213a, "per-message decompressor already set");
        Z1.m.u(this.f2483f == null, "full stream decompressor already set");
        this.f2483f = (T) Z1.m.o(t4, "Can't pass a null full stream decompressor");
        this.f2490m = null;
    }

    @Override // M2.InterfaceC0455z
    public void f(int i4) {
        this.f2479b = i4;
    }

    public void f0(b bVar) {
        this.f2478a = bVar;
    }

    @Override // M2.InterfaceC0455z
    public void g(y0 y0Var) throws Throwable {
        Z1.m.o(y0Var, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        boolean z4 = true;
        try {
            if (K()) {
                y0Var.close();
                return;
            }
            T t4 = this.f2483f;
            if (t4 != null) {
                t4.G(y0Var);
            } else {
                this.f2490m.f(y0Var);
            }
            try {
                A();
            } catch (Throwable th) {
                th = th;
                z4 = false;
                if (z4) {
                    y0Var.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void g0() {
        this.f2496s = true;
    }

    @Override // M2.InterfaceC0455z
    public void p() {
        if (J()) {
            return;
        }
        if (P()) {
            close();
        } else {
            this.f2495r = true;
        }
    }

    @Override // M2.InterfaceC0455z
    public void x(InterfaceC0372u interfaceC0372u) {
        Z1.m.u(this.f2483f == null, "Already set full stream decompressor");
        this.f2482e = (InterfaceC0372u) Z1.m.o(interfaceC0372u, "Can't pass an empty decompressor");
    }

    /* JADX INFO: renamed from: M2.m0$d */
    public static final class d extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final O0 f2500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f2501c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f2502d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f2503e;

        public d(InputStream inputStream, int i4, O0 o02) {
            super(inputStream);
            this.f2503e = -1L;
            this.f2499a = i4;
            this.f2500b = o02;
        }

        public final void e() {
            long j4 = this.f2502d;
            long j5 = this.f2501c;
            if (j4 > j5) {
                this.f2500b.f(j4 - j5);
                this.f2501c = this.f2502d;
            }
        }

        public final void f() {
            if (this.f2502d <= this.f2499a) {
                return;
            }
            throw K2.l0.f1224n.q("Decompressed gRPC message exceeds maximum size " + this.f2499a).d();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i4) {
            ((FilterInputStream) this).in.mark(i4);
            this.f2503e = this.f2502d;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i4 = ((FilterInputStream) this).in.read();
            if (i4 != -1) {
                this.f2502d++;
            }
            f();
            e();
            return i4;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f2503e == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f2502d = this.f2503e;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j4) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(j4);
            this.f2502d += jSkip;
            f();
            e();
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) throws IOException {
            int i6 = ((FilterInputStream) this).in.read(bArr, i4, i5);
            if (i6 != -1) {
                this.f2502d += (long) i6;
            }
            f();
            e();
            return i6;
        }
    }
}
