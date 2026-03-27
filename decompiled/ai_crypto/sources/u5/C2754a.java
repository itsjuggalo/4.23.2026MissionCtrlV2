package u5;

import java.io.IOException;
import java.net.Socket;
import t5.J0;
import u5.C2755b;
import w5.C2786i;
import w5.EnumC2778a;
import w5.InterfaceC2780c;
import w6.C2792e;
import w6.X;
import w6.a0;

/* JADX INFO: renamed from: u5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2754a implements X {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final J0 f24470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C2755b.a f24471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f24472e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public X f24476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Socket f24477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f24478k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f24479l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f24480m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f24468a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2792e f24469b = new C2792e();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f24473f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f24474g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f24475h = false;

    /* JADX INFO: renamed from: u5.a$a, reason: collision with other inner class name */
    public class C0379a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C5.b f24481b;

        public C0379a() {
            super(C2754a.this, null);
            this.f24481b = C5.c.f();
        }

        @Override // u5.C2754a.e
        public void a() {
            int i7;
            C2792e c2792e = new C2792e();
            C5.e eVarH = C5.c.h("WriteRunnable.runWrite");
            try {
                C5.c.e(this.f24481b);
                synchronized (C2754a.this.f24468a) {
                    c2792e.L(C2754a.this.f24469b, C2754a.this.f24469b.G());
                    C2754a.this.f24473f = false;
                    i7 = C2754a.this.f24480m;
                }
                C2754a.this.f24476i.L(c2792e, c2792e.E0());
                synchronized (C2754a.this.f24468a) {
                    C2754a.H(C2754a.this, i7);
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

    /* JADX INFO: renamed from: u5.a$b */
    public class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C5.b f24483b;

        public b() {
            super(C2754a.this, null);
            this.f24483b = C5.c.f();
        }

        @Override // u5.C2754a.e
        public void a() {
            C2792e c2792e = new C2792e();
            C5.e eVarH = C5.c.h("WriteRunnable.runFlush");
            try {
                C5.c.e(this.f24483b);
                synchronized (C2754a.this.f24468a) {
                    c2792e.L(C2754a.this.f24469b, C2754a.this.f24469b.E0());
                    C2754a.this.f24474g = false;
                }
                C2754a.this.f24476i.L(c2792e, c2792e.E0());
                C2754a.this.f24476i.flush();
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

    /* JADX INFO: renamed from: u5.a$c */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (C2754a.this.f24476i != null && C2754a.this.f24469b.E0() > 0) {
                    C2754a.this.f24476i.L(C2754a.this.f24469b, C2754a.this.f24469b.E0());
                }
            } catch (IOException e7) {
                C2754a.this.f24471d.g(e7);
            }
            C2754a.this.f24469b.close();
            try {
                if (C2754a.this.f24476i != null) {
                    C2754a.this.f24476i.close();
                }
            } catch (IOException e8) {
                C2754a.this.f24471d.g(e8);
            }
            try {
                if (C2754a.this.f24477j != null) {
                    C2754a.this.f24477j.close();
                }
            } catch (IOException e9) {
                C2754a.this.f24471d.g(e9);
            }
        }
    }

    /* JADX INFO: renamed from: u5.a$d */
    public class d extends AbstractC2756c {
        public d(InterfaceC2780c interfaceC2780c) {
            super(interfaceC2780c);
        }

        @Override // u5.AbstractC2756c, w5.InterfaceC2780c
        public void S(C2786i c2786i) {
            C2754a.V(C2754a.this);
            super.S(c2786i);
        }

        @Override // u5.AbstractC2756c, w5.InterfaceC2780c
        public void b(boolean z7, int i7, int i8) {
            if (z7) {
                C2754a.V(C2754a.this);
            }
            super.b(z7, i7, i8);
        }

        @Override // u5.AbstractC2756c, w5.InterfaceC2780c
        public void c(int i7, EnumC2778a enumC2778a) {
            C2754a.V(C2754a.this);
            super.c(i7, enumC2778a);
        }
    }

    /* JADX INFO: renamed from: u5.a$e */
    public abstract class e implements Runnable {
        public e() {
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (C2754a.this.f24476i == null) {
                    throw new IOException("Unable to perform write due to unavailable sink.");
                }
                a();
            } catch (Exception e7) {
                C2754a.this.f24471d.g(e7);
            }
        }

        public /* synthetic */ e(C2754a c2754a, C0379a c0379a) {
            this();
        }
    }

    public C2754a(J0 j02, C2755b.a aVar, int i7) {
        this.f24470c = (J0) H2.m.o(j02, "executor");
        this.f24471d = (C2755b.a) H2.m.o(aVar, "exceptionHandler");
        this.f24472e = i7;
    }

    public static /* synthetic */ int H(C2754a c2754a, int i7) {
        int i8 = c2754a.f24480m - i7;
        c2754a.f24480m = i8;
        return i8;
    }

    public static /* synthetic */ int V(C2754a c2754a) {
        int i7 = c2754a.f24479l;
        c2754a.f24479l = i7 + 1;
        return i7;
    }

    public static C2754a i0(J0 j02, C2755b.a aVar, int i7) {
        return new C2754a(j02, aVar, i7);
    }

    @Override // w6.X
    public void L(C2792e c2792e, long j7) throws IOException {
        H2.m.o(c2792e, "source");
        if (this.f24475h) {
            throw new IOException("closed");
        }
        C5.e eVarH = C5.c.h("AsyncSink.write");
        try {
            synchronized (this.f24468a) {
                try {
                    this.f24469b.L(c2792e, j7);
                    int i7 = this.f24480m + this.f24479l;
                    this.f24480m = i7;
                    boolean z7 = false;
                    this.f24479l = 0;
                    if (this.f24478k || i7 <= this.f24472e) {
                        if (!this.f24473f && !this.f24474g && this.f24469b.G() > 0) {
                            this.f24473f = true;
                        }
                        if (eVarH != null) {
                            eVarH.close();
                            return;
                        }
                        return;
                    }
                    this.f24478k = true;
                    z7 = true;
                    if (!z7) {
                        this.f24470c.execute(new C0379a());
                        if (eVarH != null) {
                            eVarH.close();
                            return;
                        }
                        return;
                    }
                    try {
                        this.f24477j.close();
                    } catch (IOException e7) {
                        this.f24471d.g(e7);
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

    public void X(X x7, Socket socket) {
        H2.m.u(this.f24476i == null, "AsyncSink's becomeConnected should only be called once.");
        this.f24476i = (X) H2.m.o(x7, "sink");
        this.f24477j = (Socket) H2.m.o(socket, "socket");
    }

    public InterfaceC2780c c0(InterfaceC2780c interfaceC2780c) {
        return new d(interfaceC2780c);
    }

    @Override // w6.X, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f24475h) {
            return;
        }
        this.f24475h = true;
        this.f24470c.execute(new c());
    }

    @Override // w6.X
    public a0 f() {
        return a0.f25070e;
    }

    @Override // w6.X, java.io.Flushable
    public void flush() throws IOException {
        if (this.f24475h) {
            throw new IOException("closed");
        }
        C5.e eVarH = C5.c.h("AsyncSink.flush");
        try {
            synchronized (this.f24468a) {
                if (this.f24474g) {
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } else {
                    this.f24474g = true;
                    this.f24470c.execute(new b());
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
