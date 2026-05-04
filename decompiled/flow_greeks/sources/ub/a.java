package ub;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.net.Socket;
import tb.i2;
import ub.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements hh.r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i2 f22727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b.a f22728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f22729e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public hh.r f22733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Socket f22734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f22735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22736l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22737m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f22725a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hh.d f22726b = new hh.d();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22730f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f22731g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f22732h = false;

    /* JADX INFO: renamed from: ub.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0391a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final bc.b f22738b;

        public C0391a() {
            super(a.this, null);
            this.f22738b = bc.c.f();
        }

        @Override // ub.a.e
        public void a() {
            int i10;
            hh.d dVar = new hh.d();
            bc.e eVarH = bc.c.h("WriteRunnable.runWrite");
            try {
                bc.c.e(this.f22738b);
                synchronized (a.this.f22725a) {
                    dVar.L(a.this.f22726b, a.this.f22726b.C());
                    a.this.f22730f = false;
                    i10 = a.this.f22737m;
                }
                a.this.f22733i.L(dVar, dVar.size());
                synchronized (a.this.f22725a) {
                    a.u(a.this, i10);
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final bc.b f22740b;

        public b() {
            super(a.this, null);
            this.f22740b = bc.c.f();
        }

        @Override // ub.a.e
        public void a() {
            hh.d dVar = new hh.d();
            bc.e eVarH = bc.c.h("WriteRunnable.runFlush");
            try {
                bc.c.e(this.f22740b);
                synchronized (a.this.f22725a) {
                    dVar.L(a.this.f22726b, a.this.f22726b.size());
                    a.this.f22731g = false;
                }
                a.this.f22733i.L(dVar, dVar.size());
                a.this.f22733i.flush();
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.f22733i != null && a.this.f22726b.size() > 0) {
                    a.this.f22733i.L(a.this.f22726b, a.this.f22726b.size());
                }
            } catch (IOException e10) {
                a.this.f22728d.e(e10);
            }
            a.this.f22726b.close();
            try {
                if (a.this.f22733i != null) {
                    a.this.f22733i.close();
                }
            } catch (IOException e11) {
                a.this.f22728d.e(e11);
            }
            try {
                if (a.this.f22734j != null) {
                    a.this.f22734j.close();
                }
            } catch (IOException e12) {
                a.this.f22728d.e(e12);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d extends ub.c {
        public d(wb.c cVar) {
            super(cVar);
        }

        @Override // ub.c, wb.c
        public void f(boolean z10, int i10, int i11) {
            if (z10) {
                a.K(a.this);
            }
            super.f(z10, i10, i11);
        }

        @Override // ub.c, wb.c
        public void g(int i10, wb.a aVar) {
            a.K(a.this);
            super.g(i10, aVar);
        }

        @Override // ub.c, wb.c
        public void v(wb.i iVar) {
            a.K(a.this);
            super.v(iVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public abstract class e implements Runnable {
        public e() {
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (a.this.f22733i == null) {
                    throw new IOException("Unable to perform write due to unavailable sink.");
                }
                a();
            } catch (Exception e10) {
                a.this.f22728d.e(e10);
            }
        }

        public /* synthetic */ e(a aVar, C0391a c0391a) {
            this();
        }
    }

    public a(i2 i2Var, b.a aVar, int i10) {
        this.f22727c = (i2) p6.n.o(i2Var, "executor");
        this.f22728d = (b.a) p6.n.o(aVar, "exceptionHandler");
        this.f22729e = i10;
    }

    public static /* synthetic */ int K(a aVar) {
        int i10 = aVar.f22736l;
        aVar.f22736l = i10 + 1;
        return i10;
    }

    public static a R(i2 i2Var, b.a aVar, int i10) {
        return new a(i2Var, aVar, i10);
    }

    public static /* synthetic */ int u(a aVar, int i10) {
        int i11 = aVar.f22737m - i10;
        aVar.f22737m = i11;
        return i11;
    }

    @Override // hh.r
    public void L(hh.d dVar, long j10) throws IOException {
        p6.n.o(dVar, FirebaseAnalytics.Param.SOURCE);
        if (this.f22732h) {
            throw new IOException("closed");
        }
        bc.e eVarH = bc.c.h("AsyncSink.write");
        try {
            synchronized (this.f22725a) {
                try {
                    this.f22726b.L(dVar, j10);
                    int i10 = this.f22737m + this.f22736l;
                    this.f22737m = i10;
                    boolean z10 = false;
                    this.f22736l = 0;
                    if (this.f22735k || i10 <= this.f22729e) {
                        if (!this.f22730f && !this.f22731g && this.f22726b.C() > 0) {
                            this.f22730f = true;
                        }
                        if (eVarH != null) {
                            eVarH.close();
                            return;
                        }
                        return;
                    }
                    this.f22735k = true;
                    z10 = true;
                    if (!z10) {
                        this.f22727c.execute(new C0391a());
                        if (eVarH != null) {
                            eVarH.close();
                            return;
                        }
                        return;
                    }
                    try {
                        this.f22734j.close();
                    } catch (IOException e10) {
                        this.f22728d.e(e10);
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

    public void N(hh.r rVar, Socket socket) {
        p6.n.u(this.f22733i == null, "AsyncSink's becomeConnected should only be called once.");
        this.f22733i = (hh.r) p6.n.o(rVar, "sink");
        this.f22734j = (Socket) p6.n.o(socket, "socket");
    }

    public wb.c O(wb.c cVar) {
        return new d(cVar);
    }

    @Override // hh.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f22732h) {
            return;
        }
        this.f22732h = true;
        this.f22727c.execute(new c());
    }

    @Override // hh.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.f22732h) {
            throw new IOException("closed");
        }
        bc.e eVarH = bc.c.h("AsyncSink.flush");
        try {
            synchronized (this.f22725a) {
                if (this.f22731g) {
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } else {
                    this.f22731g = true;
                    this.f22727c.execute(new b());
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
