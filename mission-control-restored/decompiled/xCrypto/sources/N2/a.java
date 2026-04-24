package N2;

import M2.J0;
import N2.b;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements O3.r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final J0 f2878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b.a f2879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2880e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public O3.r f2884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Socket f2885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2886k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2887l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2888m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2876a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final O3.d f2877b = new O3.d();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2881f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2882g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2883h = false;

    /* JADX INFO: renamed from: N2.a$a, reason: collision with other inner class name */
    public class C0049a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final U2.b f2889b;

        public C0049a() {
            super(a.this, null);
            this.f2889b = U2.c.f();
        }

        @Override // N2.a.e
        public void a() {
            int i4;
            O3.d dVar = new O3.d();
            U2.e eVarH = U2.c.h("WriteRunnable.runWrite");
            try {
                U2.c.e(this.f2889b);
                synchronized (a.this.f2876a) {
                    dVar.c0(a.this.f2877b, a.this.f2877b.p());
                    a.this.f2881f = false;
                    i4 = a.this.f2888m;
                }
                a.this.f2884i.c0(dVar, dVar.i0());
                synchronized (a.this.f2876a) {
                    a.x(a.this, i4);
                }
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final U2.b f2891b;

        public b() {
            super(a.this, null);
            this.f2891b = U2.c.f();
        }

        @Override // N2.a.e
        public void a() {
            O3.d dVar = new O3.d();
            U2.e eVarH = U2.c.h("WriteRunnable.runFlush");
            try {
                U2.c.e(this.f2891b);
                synchronized (a.this.f2876a) {
                    dVar.c0(a.this.f2877b, a.this.f2877b.i0());
                    a.this.f2882g = false;
                }
                a.this.f2884i.c0(dVar, dVar.i0());
                a.this.f2884i.flush();
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.f2884i != null && a.this.f2877b.i0() > 0) {
                    a.this.f2884i.c0(a.this.f2877b, a.this.f2877b.i0());
                }
            } catch (IOException e4) {
                a.this.f2879d.g(e4);
            }
            a.this.f2877b.close();
            try {
                if (a.this.f2884i != null) {
                    a.this.f2884i.close();
                }
            } catch (IOException e5) {
                a.this.f2879d.g(e5);
            }
            try {
                if (a.this.f2885j != null) {
                    a.this.f2885j.close();
                }
            } catch (IOException e6) {
                a.this.f2879d.g(e6);
            }
        }
    }

    public class d extends N2.c {
        public d(P2.c cVar) {
            super(cVar);
        }

        @Override // N2.c, P2.c
        public void H(P2.i iVar) {
            a.K(a.this);
            super.H(iVar);
        }

        @Override // N2.c, P2.c
        public void a(int i4, P2.a aVar) {
            a.K(a.this);
            super.a(i4, aVar);
        }

        @Override // N2.c, P2.c
        public void c(boolean z4, int i4, int i5) {
            if (z4) {
                a.K(a.this);
            }
            super.c(z4, i4, i5);
        }
    }

    public abstract class e implements Runnable {
        public e() {
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (a.this.f2884i == null) {
                    throw new IOException("Unable to perform write due to unavailable sink.");
                }
                a();
            } catch (Exception e4) {
                a.this.f2879d.g(e4);
            }
        }

        public /* synthetic */ e(a aVar, C0049a c0049a) {
            this();
        }
    }

    public a(J0 j02, b.a aVar, int i4) {
        this.f2878c = (J0) Z1.m.o(j02, "executor");
        this.f2879d = (b.a) Z1.m.o(aVar, "exceptionHandler");
        this.f2880e = i4;
    }

    public static /* synthetic */ int K(a aVar) {
        int i4 = aVar.f2887l;
        aVar.f2887l = i4 + 1;
        return i4;
    }

    public static a a0(J0 j02, b.a aVar, int i4) {
        return new a(j02, aVar, i4);
    }

    public static /* synthetic */ int x(a aVar, int i4) {
        int i5 = aVar.f2888m - i4;
        aVar.f2888m = i5;
        return i5;
    }

    public void P(O3.r rVar, Socket socket) {
        Z1.m.u(this.f2884i == null, "AsyncSink's becomeConnected should only be called once.");
        this.f2884i = (O3.r) Z1.m.o(rVar, "sink");
        this.f2885j = (Socket) Z1.m.o(socket, "socket");
    }

    public P2.c S(P2.c cVar) {
        return new d(cVar);
    }

    @Override // O3.r
    public void c0(O3.d dVar, long j4) throws IOException {
        Z1.m.o(dVar, "source");
        if (this.f2883h) {
            throw new IOException("closed");
        }
        U2.e eVarH = U2.c.h("AsyncSink.write");
        try {
            synchronized (this.f2876a) {
                try {
                    this.f2877b.c0(dVar, j4);
                    int i4 = this.f2888m + this.f2887l;
                    this.f2888m = i4;
                    boolean z4 = false;
                    this.f2887l = 0;
                    if (this.f2886k || i4 <= this.f2880e) {
                        if (!this.f2881f && !this.f2882g && this.f2877b.p() > 0) {
                            this.f2881f = true;
                        }
                        if (eVarH != null) {
                            eVarH.close();
                            return;
                        }
                        return;
                    }
                    this.f2886k = true;
                    z4 = true;
                    if (!z4) {
                        this.f2878c.execute(new C0049a());
                        if (eVarH != null) {
                            eVarH.close();
                            return;
                        }
                        return;
                    }
                    try {
                        this.f2885j.close();
                    } catch (IOException e4) {
                        this.f2879d.g(e4);
                    }
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // O3.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f2883h) {
            return;
        }
        this.f2883h = true;
        this.f2878c.execute(new c());
    }

    @Override // O3.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.f2883h) {
            throw new IOException("closed");
        }
        U2.e eVarH = U2.c.h("AsyncSink.flush");
        try {
            synchronized (this.f2876a) {
                if (this.f2882g) {
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } else {
                    this.f2882g = true;
                    this.f2878c.execute(new b());
                    if (eVarH != null) {
                        eVarH.close();
                    }
                }
            }
        } catch (Throwable th) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
