package H4;

import G4.J0;
import H4.b;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.net.Socket;
import u7.C2811d;
import u7.T;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements T {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final J0 f3735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b.a f3736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3737e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public T f3741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Socket f3742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3745m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3733a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2811d f3734b = new C2811d();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3738f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3739g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3740h = false;

    /* JADX INFO: renamed from: H4.a$a, reason: collision with other inner class name */
    public class C0047a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final O4.b f3746b;

        public C0047a() {
            super(a.this, null);
            this.f3746b = O4.c.f();
        }

        @Override // H4.a.e
        public void a() {
            int i8;
            C2811d c2811d = new C2811d();
            O4.e eVarH = O4.c.h("WriteRunnable.runWrite");
            try {
                O4.c.e(this.f3746b);
                synchronized (a.this.f3733a) {
                    c2811d.H(a.this.f3734b, a.this.f3734b.B());
                    a.this.f3738f = false;
                    i8 = a.this.f3745m;
                }
                a.this.f3741i.H(c2811d, c2811d.s0());
                synchronized (a.this.f3733a) {
                    a.n(a.this, i8);
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
        public final O4.b f3748b;

        public b() {
            super(a.this, null);
            this.f3748b = O4.c.f();
        }

        @Override // H4.a.e
        public void a() {
            C2811d c2811d = new C2811d();
            O4.e eVarH = O4.c.h("WriteRunnable.runFlush");
            try {
                O4.c.e(this.f3748b);
                synchronized (a.this.f3733a) {
                    c2811d.H(a.this.f3734b, a.this.f3734b.s0());
                    a.this.f3739g = false;
                }
                a.this.f3741i.H(c2811d, c2811d.s0());
                a.this.f3741i.flush();
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
                if (a.this.f3741i != null && a.this.f3734b.s0() > 0) {
                    a.this.f3741i.H(a.this.f3734b, a.this.f3734b.s0());
                }
            } catch (IOException e8) {
                a.this.f3736d.g(e8);
            }
            a.this.f3734b.close();
            try {
                if (a.this.f3741i != null) {
                    a.this.f3741i.close();
                }
            } catch (IOException e9) {
                a.this.f3736d.g(e9);
            }
            try {
                if (a.this.f3742j != null) {
                    a.this.f3742j.close();
                }
            } catch (IOException e10) {
                a.this.f3736d.g(e10);
            }
        }
    }

    public class d extends H4.c {
        public d(J4.c cVar) {
            super(cVar);
        }

        @Override // H4.c, J4.c
        public void g(boolean z7, int i8, int i9) {
            if (z7) {
                a.K(a.this);
            }
            super.g(z7, i8, i9);
        }

        @Override // H4.c, J4.c
        public void h(int i8, J4.a aVar) {
            a.K(a.this);
            super.h(i8, aVar);
        }

        @Override // H4.c, J4.c
        public void m(J4.i iVar) {
            a.K(a.this);
            super.m(iVar);
        }
    }

    public abstract class e implements Runnable {
        public e() {
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (a.this.f3741i == null) {
                    throw new IOException("Unable to perform write due to unavailable sink.");
                }
                a();
            } catch (Exception e8) {
                a.this.f3736d.g(e8);
            }
        }

        public /* synthetic */ e(a aVar, C0047a c0047a) {
            this();
        }
    }

    public a(J0 j02, b.a aVar, int i8) {
        this.f3735c = (J0) AbstractC2848n.o(j02, "executor");
        this.f3736d = (b.a) AbstractC2848n.o(aVar, "exceptionHandler");
        this.f3737e = i8;
    }

    public static /* synthetic */ int K(a aVar) {
        int i8 = aVar.f3744l;
        aVar.f3744l = i8 + 1;
        return i8;
    }

    public static a O(J0 j02, b.a aVar, int i8) {
        return new a(j02, aVar, i8);
    }

    public static /* synthetic */ int n(a aVar, int i8) {
        int i9 = aVar.f3745m - i8;
        aVar.f3745m = i9;
        return i9;
    }

    @Override // u7.T
    public void H(C2811d c2811d, long j8) throws IOException {
        AbstractC2848n.o(c2811d, FirebaseAnalytics.Param.SOURCE);
        if (this.f3740h) {
            throw new IOException("closed");
        }
        O4.e eVarH = O4.c.h("AsyncSink.write");
        try {
            synchronized (this.f3733a) {
                try {
                    this.f3734b.H(c2811d, j8);
                    int i8 = this.f3745m + this.f3744l;
                    this.f3745m = i8;
                    boolean z7 = false;
                    this.f3744l = 0;
                    if (this.f3743k || i8 <= this.f3737e) {
                        if (!this.f3738f && !this.f3739g && this.f3734b.B() > 0) {
                            this.f3738f = true;
                        }
                        if (eVarH != null) {
                            eVarH.close();
                            return;
                        }
                        return;
                    }
                    this.f3743k = true;
                    z7 = true;
                    if (!z7) {
                        this.f3735c.execute(new C0047a());
                        if (eVarH != null) {
                            eVarH.close();
                            return;
                        }
                        return;
                    }
                    try {
                        this.f3742j.close();
                    } catch (IOException e8) {
                        this.f3736d.g(e8);
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

    public void M(T t8, Socket socket) {
        AbstractC2848n.u(this.f3741i == null, "AsyncSink's becomeConnected should only be called once.");
        this.f3741i = (T) AbstractC2848n.o(t8, "sink");
        this.f3742j = (Socket) AbstractC2848n.o(socket, "socket");
    }

    public J4.c N(J4.c cVar) {
        return new d(cVar);
    }

    @Override // u7.T, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f3740h) {
            return;
        }
        this.f3740h = true;
        this.f3735c.execute(new c());
    }

    @Override // u7.T, java.io.Flushable
    public void flush() throws IOException {
        if (this.f3740h) {
            throw new IOException("closed");
        }
        O4.e eVarH = O4.c.h("AsyncSink.flush");
        try {
            synchronized (this.f3733a) {
                if (this.f3739g) {
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } else {
                    this.f3739g = true;
                    this.f3735c.execute(new b());
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
