package G4;

import F4.InterfaceC0498l;
import F4.InterfaceC0506u;
import G4.Q0;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.DataFormatException;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0541m0 implements Closeable, InterfaceC0563z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f3056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final O0 f3058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final U0 f3059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InterfaceC0506u f3060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public T f3061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f3062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3063h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C0557v f3067l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f3069n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3072q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f3064i = e.HEADER;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3065j = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C0557v f3068m = new C0557v();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3070o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3071p = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3073r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f3074s = false;

    /* JADX INFO: renamed from: G4.m0$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3075a;

        static {
            int[] iArr = new int[e.values().length];
            f3075a = iArr;
            try {
                iArr[e.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3075a[e.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: G4.m0$b */
    public interface b {
        void a(Q0.a aVar);

        void c(boolean z7);

        void d(int i8);

        void e(Throwable th);
    }

    /* JADX INFO: renamed from: G4.m0$c */
    public static class c implements Q0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputStream f3076a;

        public c(InputStream inputStream) {
            this.f3076a = inputStream;
        }

        @Override // G4.Q0.a
        public InputStream next() {
            InputStream inputStream = this.f3076a;
            this.f3076a = null;
            return inputStream;
        }

        public /* synthetic */ c(InputStream inputStream, a aVar) {
            this(inputStream);
        }
    }

    /* JADX INFO: renamed from: G4.m0$d */
    public static final class d extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final O0 f3078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f3079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f3080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f3081e;

        public d(InputStream inputStream, int i8, O0 o02) {
            super(inputStream);
            this.f3081e = -1L;
            this.f3077a = i8;
            this.f3078b = o02;
        }

        public final void a() {
            long j8 = this.f3080d;
            long j9 = this.f3079c;
            if (j8 > j9) {
                this.f3078b.f(j8 - j9);
                this.f3079c = this.f3080d;
            }
        }

        public final void c() {
            if (this.f3080d <= this.f3077a) {
                return;
            }
            throw F4.j0.f1806n.r("Decompressed gRPC message exceeds maximum size " + this.f3077a).d();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i8) {
            ((FilterInputStream) this).in.mark(i8);
            this.f3081e = this.f3080d;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i8 = ((FilterInputStream) this).in.read();
            if (i8 != -1) {
                this.f3080d++;
            }
            c();
            a();
            return i8;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f3081e == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f3080d = this.f3081e;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j8) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(j8);
            this.f3080d += jSkip;
            c();
            a();
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i8, int i9) throws IOException {
            int i10 = ((FilterInputStream) this).in.read(bArr, i8, i9);
            if (i10 != -1) {
                this.f3080d += (long) i10;
            }
            c();
            a();
            return i10;
        }
    }

    /* JADX INFO: renamed from: G4.m0$e */
    public enum e {
        HEADER,
        BODY
    }

    public C0541m0(b bVar, InterfaceC0506u interfaceC0506u, int i8, O0 o02, U0 u02) {
        this.f3056a = (b) AbstractC2848n.o(bVar, "sink");
        this.f3060e = (InterfaceC0506u) AbstractC2848n.o(interfaceC0506u, "decompressor");
        this.f3057b = i8;
        this.f3058c = (O0) AbstractC2848n.o(o02, "statsTraceCtx");
        this.f3059d = (U0) AbstractC2848n.o(u02, "transportTracer");
    }

    @Override // G4.InterfaceC0563z
    public void B() {
        if (E()) {
            return;
        }
        if (M()) {
            close();
        } else {
            this.f3073r = true;
        }
    }

    public final InputStream D() {
        this.f3058c.f(this.f3067l.d());
        return z0.c(this.f3067l, true);
    }

    public boolean E() {
        return this.f3068m == null && this.f3061f == null;
    }

    public final boolean K() {
        return E() || this.f3073r;
    }

    public final boolean M() {
        T t8 = this.f3061f;
        return t8 != null ? t8.S() : this.f3068m.d() == 0;
    }

    public final void N() {
        this.f3058c.e(this.f3071p, this.f3072q, -1L);
        this.f3072q = 0;
        InputStream inputStreamC = this.f3066k ? c() : D();
        this.f3067l.a0();
        this.f3067l = null;
        this.f3056a.a(new c(inputStreamC, null));
        this.f3064i = e.HEADER;
        this.f3065j = 5;
    }

    public final void O() {
        int unsignedByte = this.f3067l.readUnsignedByte();
        if ((unsignedByte & 254) != 0) {
            throw F4.j0.f1811s.r("gRPC frame header malformed: reserved bits not zero").d();
        }
        this.f3066k = (unsignedByte & 1) != 0;
        int i8 = this.f3067l.readInt();
        this.f3065j = i8;
        if (i8 < 0 || i8 > this.f3057b) {
            throw F4.j0.f1806n.r(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.f3057b), Integer.valueOf(this.f3065j))).d();
        }
        int i9 = this.f3071p + 1;
        this.f3071p = i9;
        this.f3058c.d(i9);
        this.f3059d.d();
        this.f3064i = e.BODY;
    }

    public final boolean Q() throws Throwable {
        int iM;
        int i8;
        int i9 = 0;
        try {
            if (this.f3067l == null) {
                this.f3067l = new C0557v();
            }
            int iK = 0;
            iM = 0;
            while (true) {
                try {
                    int iD = this.f3065j - this.f3067l.d();
                    if (iD <= 0) {
                        if (iK <= 0) {
                            return true;
                        }
                        this.f3056a.d(iK);
                        if (this.f3064i != e.BODY) {
                            return true;
                        }
                        if (this.f3061f != null) {
                            this.f3058c.g(iM);
                            i8 = this.f3072q + iM;
                        } else {
                            this.f3058c.g(iK);
                            i8 = this.f3072q + iK;
                        }
                        this.f3072q = i8;
                        return true;
                    }
                    if (this.f3061f != null) {
                        try {
                            byte[] bArr = this.f3062g;
                            if (bArr == null || this.f3063h == bArr.length) {
                                this.f3062g = new byte[Math.min(iD, 2097152)];
                                this.f3063h = 0;
                            }
                            int iQ = this.f3061f.Q(this.f3062g, this.f3063h, Math.min(iD, this.f3062g.length - this.f3063h));
                            iK += this.f3061f.K();
                            iM += this.f3061f.M();
                            if (iQ == 0) {
                                if (iK > 0) {
                                    this.f3056a.d(iK);
                                    if (this.f3064i == e.BODY) {
                                        if (this.f3061f != null) {
                                            this.f3058c.g(iM);
                                            this.f3072q += iM;
                                        } else {
                                            this.f3058c.g(iK);
                                            this.f3072q += iK;
                                        }
                                    }
                                }
                                return false;
                            }
                            this.f3067l.c(z0.f(this.f3062g, this.f3063h, iQ));
                            this.f3063h += iQ;
                        } catch (IOException e8) {
                            throw new RuntimeException(e8);
                        } catch (DataFormatException e9) {
                            throw new RuntimeException(e9);
                        }
                    } else {
                        if (this.f3068m.d() == 0) {
                            if (iK > 0) {
                                this.f3056a.d(iK);
                                if (this.f3064i == e.BODY) {
                                    if (this.f3061f != null) {
                                        this.f3058c.g(iM);
                                        this.f3072q += iM;
                                    } else {
                                        this.f3058c.g(iK);
                                        this.f3072q += iK;
                                    }
                                }
                            }
                            return false;
                        }
                        int iMin = Math.min(iD, this.f3068m.d());
                        iK += iMin;
                        this.f3067l.c(this.f3068m.t(iMin));
                    }
                } catch (Throwable th) {
                    int i10 = iK;
                    th = th;
                    i9 = i10;
                    if (i9 > 0) {
                        this.f3056a.d(i9);
                        if (this.f3064i == e.BODY) {
                            if (this.f3061f != null) {
                                this.f3058c.g(iM);
                                this.f3072q += iM;
                            } else {
                                this.f3058c.g(i9);
                                this.f3072q += i9;
                            }
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            iM = 0;
        }
    }

    public void R(T t8) {
        AbstractC2848n.u(this.f3060e == InterfaceC0498l.b.f1851a, "per-message decompressor already set");
        AbstractC2848n.u(this.f3061f == null, "full stream decompressor already set");
        this.f3061f = (T) AbstractC2848n.o(t8, "Can't pass a null full stream decompressor");
        this.f3068m = null;
    }

    public void S(b bVar) {
        this.f3056a = bVar;
    }

    public void T() {
        this.f3074s = true;
    }

    public final void a() {
        if (this.f3070o) {
            return;
        }
        this.f3070o = true;
        while (!this.f3074s && this.f3069n > 0 && Q()) {
            try {
                int i8 = a.f3075a[this.f3064i.ordinal()];
                if (i8 == 1) {
                    O();
                } else {
                    if (i8 != 2) {
                        throw new AssertionError("Invalid state: " + this.f3064i);
                    }
                    N();
                    this.f3069n--;
                }
            } catch (Throwable th) {
                this.f3070o = false;
                throw th;
            }
        }
        if (this.f3074s) {
            close();
            this.f3070o = false;
        } else {
            if (this.f3073r && M()) {
                close();
            }
            this.f3070o = false;
        }
    }

    public final InputStream c() {
        InterfaceC0506u interfaceC0506u = this.f3060e;
        if (interfaceC0506u == InterfaceC0498l.b.f1851a) {
            throw F4.j0.f1811s.r("Can't decode compressed gRPC message as compression not configured").d();
        }
        try {
            return new d(interfaceC0506u.b(z0.c(this.f3067l, true)), this.f3057b, this.f3058c);
        } catch (IOException e8) {
            throw new RuntimeException(e8);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, G4.InterfaceC0563z
    public void close() {
        if (E()) {
            return;
        }
        C0557v c0557v = this.f3067l;
        boolean z7 = c0557v != null && c0557v.d() > 0;
        try {
            T t8 = this.f3061f;
            if (t8 != null) {
                boolean z8 = z7 || t8.N();
                this.f3061f.close();
                z7 = z8;
            }
            C0557v c0557v2 = this.f3068m;
            if (c0557v2 != null) {
                c0557v2.close();
            }
            C0557v c0557v3 = this.f3067l;
            if (c0557v3 != null) {
                c0557v3.close();
            }
            this.f3061f = null;
            this.f3068m = null;
            this.f3067l = null;
            this.f3056a.c(z7);
        } catch (Throwable th) {
            this.f3061f = null;
            this.f3068m = null;
            this.f3067l = null;
            throw th;
        }
    }

    @Override // G4.InterfaceC0563z
    public void e(int i8) {
        AbstractC2848n.e(i8 > 0, "numMessages must be > 0");
        if (E()) {
            return;
        }
        this.f3069n += (long) i8;
        a();
    }

    @Override // G4.InterfaceC0563z
    public void f(int i8) {
        this.f3057b = i8;
    }

    @Override // G4.InterfaceC0563z
    public void n(InterfaceC0506u interfaceC0506u) {
        AbstractC2848n.u(this.f3061f == null, "Already set full stream decompressor");
        this.f3060e = (InterfaceC0506u) AbstractC2848n.o(interfaceC0506u, "Can't pass an empty decompressor");
    }

    @Override // G4.InterfaceC0563z
    public void r(y0 y0Var) throws Throwable {
        AbstractC2848n.o(y0Var, "data");
        boolean z7 = true;
        try {
            if (K()) {
                y0Var.close();
                return;
            }
            T t8 = this.f3061f;
            if (t8 != null) {
                t8.D(y0Var);
            } else {
                this.f3068m.c(y0Var);
            }
            try {
                a();
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
}
