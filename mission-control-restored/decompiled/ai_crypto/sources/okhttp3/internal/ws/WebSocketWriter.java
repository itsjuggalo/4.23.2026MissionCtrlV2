package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Random;
import w6.C2792e;
import w6.C2795h;
import w6.InterfaceC2793f;
import w6.X;
import w6.a0;

/* JADX INFO: loaded from: classes2.dex */
final class WebSocketWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f21145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2793f f21146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C2792e f21147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C2792e f21149f = new C2792e();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameSink f21150g = new FrameSink();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f21152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C2792e.a f21153j;

    public final class FrameSink implements X {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f21155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f21156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f21157d;

        public FrameSink() {
        }

        @Override // w6.X
        public void L(C2792e c2792e, long j7) throws IOException {
            if (this.f21157d) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.f21149f.L(c2792e, j7);
            boolean z7 = this.f21156c && this.f21155b != -1 && WebSocketWriter.this.f21149f.E0() > this.f21155b - 8192;
            long jG = WebSocketWriter.this.f21149f.G();
            if (jG <= 0 || z7) {
                return;
            }
            WebSocketWriter.this.d(this.f21154a, jG, this.f21156c, false);
            this.f21156c = false;
        }

        @Override // w6.X, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f21157d) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.d(this.f21154a, webSocketWriter.f21149f.E0(), this.f21156c, true);
            this.f21157d = true;
            WebSocketWriter.this.f21151h = false;
        }

        @Override // w6.X
        public a0 f() {
            return WebSocketWriter.this.f21146c.f();
        }

        @Override // w6.X, java.io.Flushable
        public void flush() throws IOException {
            if (this.f21157d) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.d(this.f21154a, webSocketWriter.f21149f.E0(), this.f21156c, false);
            this.f21156c = false;
        }
    }

    public WebSocketWriter(boolean z7, InterfaceC2793f interfaceC2793f, Random random) {
        if (interfaceC2793f == null) {
            throw new NullPointerException("sink == null");
        }
        if (random == null) {
            throw new NullPointerException("random == null");
        }
        this.f21144a = z7;
        this.f21146c = interfaceC2793f;
        this.f21147d = interfaceC2793f.d();
        this.f21145b = random;
        this.f21152i = z7 ? new byte[4] : null;
        this.f21153j = z7 ? new C2792e.a() : null;
    }

    public X a(int i7, long j7) {
        if (this.f21151h) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.f21151h = true;
        FrameSink frameSink = this.f21150g;
        frameSink.f21154a = i7;
        frameSink.f21155b = j7;
        frameSink.f21156c = true;
        frameSink.f21157d = false;
        return frameSink;
    }

    public void b(int i7, C2795h c2795h) {
        C2795h c2795hA0 = C2795h.f25107e;
        if (i7 != 0 || c2795h != null) {
            if (i7 != 0) {
                WebSocketProtocol.c(i7);
            }
            C2792e c2792e = new C2792e();
            c2792e.q(i7);
            if (c2795h != null) {
                c2792e.m(c2795h);
            }
            c2795hA0 = c2792e.A0();
        }
        try {
            c(8, c2795hA0);
        } finally {
            this.f21148e = true;
        }
    }

    public final void c(int i7, C2795h c2795h) throws IOException {
        if (this.f21148e) {
            throw new IOException("closed");
        }
        int iH = c2795h.H();
        if (iH > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.f21147d.v(i7 | 128);
        if (this.f21144a) {
            this.f21147d.v(iH | 128);
            this.f21145b.nextBytes(this.f21152i);
            this.f21147d.a0(this.f21152i);
            if (iH > 0) {
                long jE0 = this.f21147d.E0();
                this.f21147d.m(c2795h);
                this.f21147d.y0(this.f21153j);
                this.f21153j.A(jE0);
                WebSocketProtocol.b(this.f21153j, this.f21152i);
                this.f21153j.close();
            }
        } else {
            this.f21147d.v(iH);
            this.f21147d.m(c2795h);
        }
        this.f21146c.flush();
    }

    public void d(int i7, long j7, boolean z7, boolean z8) throws IOException {
        if (this.f21148e) {
            throw new IOException("closed");
        }
        if (!z7) {
            i7 = 0;
        }
        if (z8) {
            i7 |= 128;
        }
        this.f21147d.v(i7);
        int i8 = this.f21144a ? 128 : 0;
        if (j7 <= 125) {
            this.f21147d.v(((int) j7) | i8);
        } else if (j7 <= 65535) {
            this.f21147d.v(i8 | 126);
            this.f21147d.q((int) j7);
        } else {
            this.f21147d.v(i8 | 127);
            this.f21147d.P0(j7);
        }
        if (this.f21144a) {
            this.f21145b.nextBytes(this.f21152i);
            this.f21147d.a0(this.f21152i);
            if (j7 > 0) {
                long jE0 = this.f21147d.E0();
                this.f21147d.L(this.f21149f, j7);
                this.f21147d.y0(this.f21153j);
                this.f21153j.A(jE0);
                WebSocketProtocol.b(this.f21153j, this.f21152i);
                this.f21153j.close();
            }
        } else {
            this.f21147d.L(this.f21149f, j7);
        }
        this.f21146c.p();
    }

    public void e(C2795h c2795h) throws IOException {
        c(9, c2795h);
    }

    public void f(C2795h c2795h) throws IOException {
        c(10, c2795h);
    }
}
