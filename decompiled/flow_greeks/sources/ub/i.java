package ub;

import com.google.android.gms.common.api.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.Constants;
import hh.t;
import io.flutter.embedding.android.KeyboardMap;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import rb.c0;
import rb.d0;
import rb.e0;
import rb.h1;
import rb.k0;
import rb.k1;
import rb.l1;
import rb.y0;
import rb.z0;
import tb.c1;
import tb.i2;
import tb.k1;
import tb.n2;
import tb.q0;
import tb.r0;
import tb.s;
import tb.t;
import tb.t2;
import tb.v0;
import tb.w;
import tb.w0;
import ub.b;
import ub.f;
import ub.h;
import ub.j;
import ub.r;
import wb.b;
import xb.a;
import xb.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class i implements w, b.a, r.d {
    public static final Map V = Q();
    public static final Logger W = Logger.getLogger(i.class.getName());
    public final SocketFactory A;
    public SSLSocketFactory B;
    public HostnameVerifier C;
    public Socket D;
    public int E;
    public final Deque F;
    public final vb.b G;
    public c1 H;
    public boolean I;
    public long J;
    public long K;
    public boolean L;
    public final Runnable M;
    public final int N;
    public final boolean O;
    public final t2 P;
    public final w0 Q;
    public e0.b R;
    public final d0 S;
    public int T;
    public Runnable U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InetSocketAddress f22822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f22825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p6.s f22826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f22827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final wb.j f22828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k1.a f22829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ub.b f22830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f22831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f22832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k0 f22833l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22834m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f22835n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Executor f22836o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final i2 f22837p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScheduledExecutorService f22838q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f22839r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f22840s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public e f22841t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public rb.a f22842u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public rb.k1 f22843v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f22844w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public v0 f22845x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f22846y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f22847z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends w0 {
        public a() {
        }

        @Override // tb.w0
        public void b() {
            i.this.f22829h.d(true);
        }

        @Override // tb.w0
        public void c() {
            i.this.f22829h.d(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements t2.c {
        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = i.this.U;
            if (runnable != null) {
                runnable.run();
            }
            i.this.f22836o.execute(i.this.f22841t);
            synchronized (i.this.f22832k) {
                i.this.E = a.e.API_PRIORITY_OTHER;
                i.this.k0();
            }
            i.this.getClass();
        }
    }

    public i(f.C0392f c0392f, InetSocketAddress inetSocketAddress, String str, String str2, rb.a aVar, d0 d0Var, Runnable runnable) {
        this(c0392f, inetSocketAddress, str, str2, aVar, r0.f21646w, new wb.g(), d0Var, runnable);
    }

    public static /* synthetic */ int D(i iVar, int i10) {
        int i11 = iVar.f22840s + i10;
        iVar.f22840s = i11;
        return i11;
    }

    public static Map Q() {
        EnumMap enumMap = new EnumMap(wb.a.class);
        wb.a aVar = wb.a.NO_ERROR;
        rb.k1 k1Var = rb.k1.f19606s;
        enumMap.put(aVar, k1Var.r("No error: A GRPC status of OK should have been sent"));
        enumMap.put(wb.a.PROTOCOL_ERROR, k1Var.r("Protocol error"));
        enumMap.put(wb.a.INTERNAL_ERROR, k1Var.r("Internal error"));
        enumMap.put(wb.a.FLOW_CONTROL_ERROR, k1Var.r("Flow control error"));
        enumMap.put(wb.a.STREAM_CLOSED, k1Var.r("Stream closed"));
        enumMap.put(wb.a.FRAME_TOO_LARGE, k1Var.r("Frame too large"));
        enumMap.put(wb.a.REFUSED_STREAM, rb.k1.f19607t.r("Refused stream"));
        enumMap.put(wb.a.CANCEL, rb.k1.f19593f.r("Cancelled"));
        enumMap.put(wb.a.COMPRESSION_ERROR, k1Var.r("Compression error"));
        enumMap.put(wb.a.CONNECT_ERROR, k1Var.r("Connect error"));
        enumMap.put(wb.a.ENHANCE_YOUR_CALM, rb.k1.f19601n.r("Enhance your calm"));
        enumMap.put(wb.a.INADEQUATE_SECURITY, rb.k1.f19599l.r("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    public static String f0(t tVar) throws EOFException {
        hh.d dVar = new hh.d();
        while (tVar.B(dVar, 1L) != -1) {
            if (dVar.H(dVar.size() - 1) == 10) {
                return dVar.d0();
            }
        }
        throw new EOFException("\\n not found: " + dVar.R().o());
    }

    public static rb.k1 o0(wb.a aVar) {
        rb.k1 k1Var = (rb.k1) V.get(aVar);
        if (k1Var != null) {
            return k1Var;
        }
        return rb.k1.f19594g.r("Unknown http2 error code: " + aVar.f23814a);
    }

    public final xb.b R(InetSocketAddress inetSocketAddress, String str, String str2) {
        xb.a aVarA = new a.b().k("https").h(inetSocketAddress.getHostName()).j(inetSocketAddress.getPort()).a();
        b.C0451b c0451bD = new b.C0451b().e(aVarA).d("Host", aVarA.c() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + aVarA.f()).d("User-Agent", this.f22824c);
        if (str != null && str2 != null) {
            c0451bD.d("Proxy-Authorization", vb.c.a(str, str2));
        }
        return c0451bD.c();
    }

    public final Socket S(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws l1 {
        Socket socketCreateSocket = null;
        try {
            socketCreateSocket = inetSocketAddress2.getAddress() != null ? this.A.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : this.A.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            socketCreateSocket.setTcpNoDelay(true);
            socketCreateSocket.setSoTimeout(this.T);
            t tVarE = hh.i.e(socketCreateSocket);
            hh.e eVarA = hh.i.a(hh.i.d(socketCreateSocket));
            xb.b bVarR = R(inetSocketAddress, str, str2);
            xb.a aVarB = bVarR.b();
            eVarA.x(String.format(Locale.US, "CONNECT %s:%d HTTP/1.1", aVarB.c(), Integer.valueOf(aVarB.f()))).x("\r\n");
            int iB = bVarR.a().b();
            for (int i10 = 0; i10 < iB; i10++) {
                eVarA.x(bVarR.a().a(i10)).x(": ").x(bVarR.a().c(i10)).x("\r\n");
            }
            eVarA.x("\r\n");
            eVarA.flush();
            vb.j jVarA = vb.j.a(f0(tVarE));
            while (!f0(tVarE).equals("")) {
            }
            int i11 = jVarA.f23345b;
            if (i11 >= 200 && i11 < 300) {
                socketCreateSocket.setSoTimeout(0);
                return socketCreateSocket;
            }
            hh.d dVar = new hh.d();
            try {
                socketCreateSocket.shutdownOutput();
                tVarE.B(dVar, 1024L);
            } catch (IOException e10) {
                dVar.x("Unable to read body: " + e10.toString());
            }
            try {
                socketCreateSocket.close();
            } catch (IOException unused) {
            }
            throw rb.k1.f19607t.r(String.format(Locale.US, "Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(jVarA.f23345b), jVarA.f23346c, dVar.b0())).c();
        } catch (IOException e11) {
            if (socketCreateSocket != null) {
                r0.d(socketCreateSocket);
            }
            throw rb.k1.f19607t.r("Failed trying to connect with proxy").q(e11).c();
        }
    }

    public void T(boolean z10, long j10, long j11, boolean z11) {
        this.I = z10;
        this.J = j10;
        this.K = j11;
        this.L = z11;
    }

    public void U(int i10, rb.k1 k1Var, s.a aVar, boolean z10, wb.a aVar2, y0 y0Var) {
        synchronized (this.f22832k) {
            try {
                h hVar = (h) this.f22835n.remove(Integer.valueOf(i10));
                if (hVar != null) {
                    if (aVar2 != null) {
                        this.f22830i.g(i10, wb.a.CANCEL);
                    }
                    if (k1Var != null) {
                        h.b bVarM = hVar.t();
                        if (y0Var == null) {
                            y0Var = new y0();
                        }
                        bVarM.M(k1Var, aVar, z10, y0Var);
                    }
                    if (!k0()) {
                        m0();
                        c0(hVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String V() {
        URI uriB = r0.b(this.f22823b);
        return uriB.getHost() != null ? uriB.getHost() : this.f22823b;
    }

    public int W() {
        URI uriB = r0.b(this.f22823b);
        return uriB.getPort() != -1 ? uriB.getPort() : this.f22822a.getPort();
    }

    public final Throwable X() {
        synchronized (this.f22832k) {
            try {
                rb.k1 k1Var = this.f22843v;
                if (k1Var != null) {
                    return k1Var.c();
                }
                return rb.k1.f19607t.r("Connection closed").c();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public h Y(int i10) {
        h hVar;
        synchronized (this.f22832k) {
            hVar = (h) this.f22835n.get(Integer.valueOf(i10));
        }
        return hVar;
    }

    public final void Z() {
        synchronized (this.f22832k) {
            this.P.g(new b());
        }
    }

    @Override // ub.r.d
    public r.c[] a() {
        r.c[] cVarArr;
        synchronized (this.f22832k) {
            try {
                cVarArr = new r.c[this.f22835n.size()];
                Iterator it = this.f22835n.values().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    cVarArr[i10] = ((h) it.next()).t().b0();
                    i10++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVarArr;
    }

    public boolean a0() {
        return this.B == null;
    }

    @Override // tb.t
    public void b(t.a aVar, Executor executor) {
        long jNextLong;
        synchronized (this.f22832k) {
            try {
                boolean z10 = true;
                p6.n.t(this.f22830i != null);
                if (this.f22846y) {
                    v0.g(aVar, executor, X());
                    return;
                }
                v0 v0Var = this.f22845x;
                if (v0Var != null) {
                    jNextLong = 0;
                    z10 = false;
                } else {
                    jNextLong = this.f22825d.nextLong();
                    p6.q qVar = (p6.q) this.f22826e.get();
                    qVar.g();
                    v0 v0Var2 = new v0(jNextLong, qVar);
                    this.f22845x = v0Var2;
                    this.P.b();
                    v0Var = v0Var2;
                }
                if (z10) {
                    this.f22830i.f(false, (int) (jNextLong >>> 32), (int) jNextLong);
                }
                v0Var.a(aVar, executor);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b0(int r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f22832k
            monitor-enter(r0)
            int r1 = r2.f22834m     // Catch: java.lang.Throwable -> Lf
            if (r3 >= r1) goto Lc
            r1 = 1
            r3 = r3 & r1
            if (r3 != r1) goto Lc
            goto Ld
        Lc:
            r1 = 0
        Ld:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            return r1
        Lf:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.i.b0(int):boolean");
    }

    @Override // tb.k1
    public void c(rb.k1 k1Var) {
        synchronized (this.f22832k) {
            try {
                if (this.f22843v != null) {
                    return;
                }
                this.f22843v = k1Var;
                this.f22829h.c(k1Var);
                m0();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c0(h hVar) {
        if (this.f22847z && this.F.isEmpty() && this.f22835n.isEmpty()) {
            this.f22847z = false;
            c1 c1Var = this.H;
            if (c1Var != null) {
                c1Var.o();
            }
        }
        if (hVar.x()) {
            this.Q.e(hVar, false);
        }
    }

    @Override // tb.k1
    public Runnable d(k1.a aVar) {
        this.f22829h = (k1.a) p6.n.o(aVar, "listener");
        if (this.I) {
            c1 c1Var = new c1(new c1.c(this), this.f22838q, this.J, this.K, this.L);
            this.H = c1Var;
            c1Var.p();
        }
        ub.a aVarR = ub.a.R(this.f22837p, this, 10000);
        wb.c cVarO = aVarR.O(this.f22828g.a(hh.i.a(aVarR), true));
        synchronized (this.f22832k) {
            ub.b bVar = new ub.b(this, cVarO);
            this.f22830i = bVar;
            this.f22831j = new r(this, bVar);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f22837p.execute(new c(countDownLatch, aVarR));
        try {
            h0();
            countDownLatch.countDown();
            this.f22837p.execute(new d());
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    @Override // tb.t
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public h g(z0 z0Var, y0 y0Var, rb.c cVar, rb.k[] kVarArr) {
        h hVar;
        p6.n.o(z0Var, FirebaseAnalytics.Param.METHOD);
        p6.n.o(y0Var, "headers");
        n2 n2VarH = n2.h(kVarArr, getAttributes(), y0Var);
        synchronized (this.f22832k) {
            hVar = new h(z0Var, y0Var, this.f22830i, this, this.f22831j, this.f22832k, this.f22839r, this.f22827f, this.f22823b, this.f22824c, n2VarH, this.P, cVar, this.O);
        }
        return hVar;
    }

    @Override // ub.b.a
    public void e(Throwable th) {
        p6.n.o(th, "failureCause");
        j0(0, wb.a.INTERNAL_ERROR, rb.k1.f19607t.q(th));
    }

    public final void e0(wb.a aVar, String str) {
        j0(0, aVar, o0(aVar).f(str));
    }

    @Override // rb.p0
    public k0 f() {
        return this.f22833l;
    }

    public void g0(h hVar) {
        this.F.remove(hVar);
        c0(hVar);
    }

    @Override // tb.w
    public rb.a getAttributes() {
        return this.f22842u;
    }

    @Override // tb.k1
    public void h(rb.k1 k1Var) {
        c(k1Var);
        synchronized (this.f22832k) {
            try {
                Iterator it = this.f22835n.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    it.remove();
                    ((h) entry.getValue()).t().N(k1Var, false, new y0());
                    c0((h) entry.getValue());
                }
                for (h hVar : this.F) {
                    hVar.t().M(k1Var, s.a.MISCARRIED, true, new y0());
                    c0(hVar);
                }
                this.F.clear();
                m0();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h0() {
        synchronized (this.f22832k) {
            try {
                this.f22830i.r();
                wb.i iVar = new wb.i();
                n.c(iVar, 7, this.f22827f);
                this.f22830i.X(iVar);
                if (this.f22827f > 65535) {
                    this.f22830i.a(0, r1 - 65535);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i0(h hVar) {
        if (!this.f22847z) {
            this.f22847z = true;
            c1 c1Var = this.H;
            if (c1Var != null) {
                c1Var.n();
            }
        }
        if (hVar.x()) {
            this.Q.e(hVar, true);
        }
    }

    public final void j0(int i10, wb.a aVar, rb.k1 k1Var) {
        synchronized (this.f22832k) {
            try {
                if (this.f22843v == null) {
                    this.f22843v = k1Var;
                    this.f22829h.c(k1Var);
                }
                if (aVar != null && !this.f22844w) {
                    this.f22844w = true;
                    this.f22830i.m(0, aVar, new byte[0]);
                }
                Iterator it = this.f22835n.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() > i10) {
                        it.remove();
                        ((h) entry.getValue()).t().M(k1Var, s.a.REFUSED, false, new y0());
                        c0((h) entry.getValue());
                    }
                }
                for (h hVar : this.F) {
                    hVar.t().M(k1Var, s.a.MISCARRIED, true, new y0());
                    c0(hVar);
                }
                this.F.clear();
                m0();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean k0() {
        boolean z10 = false;
        while (!this.F.isEmpty() && this.f22835n.size() < this.E) {
            l0((h) this.F.poll());
            z10 = true;
        }
        return z10;
    }

    public final void l0(h hVar) {
        p6.n.u(hVar.t().c0() == -1, "StreamId already assigned");
        this.f22835n.put(Integer.valueOf(this.f22834m), hVar);
        i0(hVar);
        hVar.t().f0(this.f22834m);
        if ((hVar.L() != z0.d.UNARY && hVar.L() != z0.d.SERVER_STREAMING) || hVar.N()) {
            this.f22830i.flush();
        }
        int i10 = this.f22834m;
        if (i10 < 2147483645) {
            this.f22834m = i10 + 2;
        } else {
            this.f22834m = a.e.API_PRIORITY_OTHER;
            j0(a.e.API_PRIORITY_OTHER, wb.a.NO_ERROR, rb.k1.f19607t.r("Stream ids exhausted"));
        }
    }

    public final void m0() {
        if (this.f22843v == null || !this.f22835n.isEmpty() || !this.F.isEmpty() || this.f22846y) {
            return;
        }
        this.f22846y = true;
        c1 c1Var = this.H;
        if (c1Var != null) {
            c1Var.q();
        }
        v0 v0Var = this.f22845x;
        if (v0Var != null) {
            v0Var.f(X());
            this.f22845x = null;
        }
        if (!this.f22844w) {
            this.f22844w = true;
            this.f22830i.m(0, wb.a.NO_ERROR, new byte[0]);
        }
        this.f22830i.close();
    }

    public void n0(h hVar) {
        if (this.f22843v != null) {
            hVar.t().M(this.f22843v, s.a.MISCARRIED, true, new y0());
        } else if (this.f22835n.size() < this.E) {
            l0(hVar);
        } else {
            this.F.add(hVar);
            i0(hVar);
        }
    }

    public String toString() {
        return p6.h.b(this).c("logId", this.f22833l.d()).d("address", this.f22822a).toString();
    }

    public i(f.C0392f c0392f, InetSocketAddress inetSocketAddress, String str, String str2, rb.a aVar, p6.s sVar, wb.j jVar, d0 d0Var, Runnable runnable) {
        this.f22825d = new Random();
        this.f22832k = new Object();
        this.f22835n = new HashMap();
        this.E = 0;
        this.F = new LinkedList();
        this.Q = new a();
        this.T = 30000;
        this.f22822a = (InetSocketAddress) p6.n.o(inetSocketAddress, "address");
        this.f22823b = str;
        this.f22839r = c0392f.f22798j;
        this.f22827f = c0392f.f22803o;
        this.f22836o = (Executor) p6.n.o(c0392f.f22790b, "executor");
        this.f22837p = new i2(c0392f.f22790b);
        this.f22838q = (ScheduledExecutorService) p6.n.o(c0392f.f22792d, "scheduledExecutorService");
        this.f22834m = 3;
        SocketFactory socketFactory = c0392f.f22794f;
        this.A = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.B = c0392f.f22795g;
        this.C = c0392f.f22796h;
        this.G = (vb.b) p6.n.o(c0392f.f22797i, "connectionSpec");
        this.f22826e = (p6.s) p6.n.o(sVar, "stopwatchFactory");
        this.f22828g = (wb.j) p6.n.o(jVar, "variant");
        this.f22824c = r0.h("okhttp", str2);
        this.S = d0Var;
        this.M = (Runnable) p6.n.o(runnable, "tooManyPingsRunnable");
        this.N = c0392f.f22805q;
        this.P = c0392f.f22793e.a();
        this.f22833l = k0.a(getClass(), inetSocketAddress.toString());
        this.f22842u = rb.a.c().d(q0.f21620b, aVar).a();
        this.O = c0392f.f22806r;
        Z();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f22850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ub.a f22851b;

        public c(CountDownLatch countDownLatch, ub.a aVar) {
            this.f22850a = countDownLatch;
            this.f22851b = aVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            i iVar;
            e eVar;
            Socket socketS;
            SSLSession session;
            Socket socket;
            try {
                this.f22850a.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            hh.f fVarB = hh.i.b(new a());
            try {
                try {
                    i iVar2 = i.this;
                    d0 d0Var = iVar2.S;
                    if (d0Var == null) {
                        socketS = iVar2.A.createSocket(i.this.f22822a.getAddress(), i.this.f22822a.getPort());
                    } else {
                        if (!(d0Var.b() instanceof InetSocketAddress)) {
                            throw rb.k1.f19606s.r("Unsupported SocketAddress implementation " + i.this.S.b().getClass()).c();
                        }
                        i iVar3 = i.this;
                        socketS = iVar3.S(iVar3.S.c(), (InetSocketAddress) i.this.S.b(), i.this.S.d(), i.this.S.a());
                    }
                    Socket socket2 = socketS;
                    if (i.this.B != null) {
                        SSLSocket sSLSocketB = o.b(i.this.B, i.this.C, socket2, i.this.V(), i.this.W(), i.this.G);
                        session = sSLSocketB.getSession();
                        socket = sSLSocketB;
                    } else {
                        session = null;
                        socket = socket2;
                    }
                    socket.setTcpNoDelay(true);
                    hh.f fVarB2 = hh.i.b(hh.i.e(socket));
                    this.f22851b.N(hh.i.d(socket), socket);
                    i iVar4 = i.this;
                    iVar4.f22842u = iVar4.f22842u.d().d(c0.f19517a, socket.getRemoteSocketAddress()).d(c0.f19518b, socket.getLocalSocketAddress()).d(c0.f19519c, session).d(q0.f21619a, session == null ? h1.NONE : h1.PRIVACY_AND_INTEGRITY).a();
                    i iVar5 = i.this;
                    iVar5.f22841t = iVar5.new e(iVar5.f22828g.b(fVarB2, true));
                    synchronized (i.this.f22832k) {
                        try {
                            i.this.D = (Socket) p6.n.o(socket, "socket");
                            if (session != null) {
                                i.this.R = new e0.b(new e0.c(session));
                            }
                        } finally {
                        }
                    }
                } catch (l1 e10) {
                    i.this.j0(0, wb.a.INTERNAL_ERROR, e10.a());
                    iVar = i.this;
                    eVar = iVar.new e(iVar.f22828g.b(fVarB, true));
                    iVar.f22841t = eVar;
                } catch (Exception e11) {
                    i.this.e(e11);
                    iVar = i.this;
                    eVar = iVar.new e(iVar.f22828g.b(fVarB, true));
                    iVar.f22841t = eVar;
                }
            } catch (Throwable th) {
                i iVar6 = i.this;
                iVar6.f22841t = iVar6.new e(iVar6.f22828g.b(fVarB, true));
                throw th;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements hh.t {
            public a() {
            }

            @Override // hh.t
            public long B(hh.d dVar, long j10) {
                return -1L;
            }

            @Override // hh.t, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements b.a, Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public wb.b f22856b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f22855a = new j(Level.FINE, i.class);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f22857c = true;

        public e(wb.b bVar) {
            this.f22856b = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        @Override // wb.b.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(int r8, long r9) {
            /*
                r7 = this;
                ub.j r0 = r7.f22855a
                ub.j$a r1 = ub.j.a.INBOUND
                r0.k(r1, r8, r9)
                r0 = 0
                int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r0 != 0) goto L2c
                java.lang.String r9 = "Received 0 flow control window increment."
                if (r8 != 0) goto L19
                ub.i r8 = ub.i.this
                wb.a r10 = wb.a.PROTOCOL_ERROR
                ub.i.A(r8, r10, r9)
                return
            L19:
                ub.i r0 = ub.i.this
                rb.k1 r10 = rb.k1.f19606s
                rb.k1 r2 = r10.r(r9)
                tb.s$a r3 = tb.s.a.PROCESSED
                wb.a r5 = wb.a.PROTOCOL_ERROR
                r6 = 0
                r4 = 0
                r1 = r8
                r0.U(r1, r2, r3, r4, r5, r6)
                return
            L2c:
                r1 = r8
                ub.i r8 = ub.i.this
                java.lang.Object r8 = ub.i.j(r8)
                monitor-enter(r8)
                if (r1 != 0) goto L46
                ub.i r0 = ub.i.this     // Catch: java.lang.Throwable -> L43
                ub.r r0 = ub.i.w(r0)     // Catch: java.lang.Throwable -> L43
                r1 = 0
                int r9 = (int) r9     // Catch: java.lang.Throwable -> L43
                r0.g(r1, r9)     // Catch: java.lang.Throwable -> L43
                monitor-exit(r8)     // Catch: java.lang.Throwable -> L43
                return
            L43:
                r0 = move-exception
                r9 = r0
                goto L92
            L46:
                ub.i r0 = ub.i.this     // Catch: java.lang.Throwable -> L43
                java.util.Map r0 = ub.i.F(r0)     // Catch: java.lang.Throwable -> L43
                java.lang.Integer r2 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L43
                java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L43
                ub.h r0 = (ub.h) r0     // Catch: java.lang.Throwable -> L43
                if (r0 == 0) goto L6b
                ub.i r2 = ub.i.this     // Catch: java.lang.Throwable -> L43
                ub.r r2 = ub.i.w(r2)     // Catch: java.lang.Throwable -> L43
                ub.h$b r0 = r0.t()     // Catch: java.lang.Throwable -> L43
                ub.r$c r0 = r0.b0()     // Catch: java.lang.Throwable -> L43
                int r9 = (int) r9     // Catch: java.lang.Throwable -> L43
                r2.g(r0, r9)     // Catch: java.lang.Throwable -> L43
                goto L75
            L6b:
                ub.i r9 = ub.i.this     // Catch: java.lang.Throwable -> L43
                boolean r9 = r9.b0(r1)     // Catch: java.lang.Throwable -> L43
                if (r9 != 0) goto L75
                r9 = 1
                goto L76
            L75:
                r9 = 0
            L76:
                monitor-exit(r8)     // Catch: java.lang.Throwable -> L43
                if (r9 == 0) goto L91
                ub.i r8 = ub.i.this
                wb.a r9 = wb.a.PROTOCOL_ERROR
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r0 = "Received window_update for unknown stream: "
                r10.append(r0)
                r10.append(r1)
                java.lang.String r10 = r10.toString()
                ub.i.A(r8, r9, r10)
            L91:
                return
            L92:
                monitor-exit(r8)     // Catch: java.lang.Throwable -> L43
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ub.i.e.a(int, long):void");
        }

        public final int b(List list) {
            long jB = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                wb.d dVar = (wb.d) list.get(i10);
                jB += (long) (dVar.f23824a.B() + 32 + dVar.f23825b.B());
            }
            return (int) Math.min(jB, 2147483647L);
        }

        @Override // wb.b.a
        public void f(boolean z10, int i10, int i11) {
            v0 v0Var;
            long j10 = (((long) i10) << 32) | (((long) i11) & KeyboardMap.kValueMask);
            this.f22855a.e(j.a.INBOUND, j10);
            if (!z10) {
                synchronized (i.this.f22832k) {
                    i.this.f22830i.f(true, i10, i11);
                }
                return;
            }
            synchronized (i.this.f22832k) {
                try {
                    v0Var = null;
                    if (i.this.f22845x == null) {
                        i.W.warning("Received unexpected ping ack. No ping outstanding");
                    } else if (i.this.f22845x.h() == j10) {
                        v0 v0Var2 = i.this.f22845x;
                        i.this.f22845x = null;
                        v0Var = v0Var2;
                    } else {
                        i.W.log(Level.WARNING, String.format(Locale.US, "Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(i.this.f22845x.h()), Long.valueOf(j10)));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (v0Var != null) {
                v0Var.d();
            }
        }

        @Override // wb.b.a
        public void g(int i10, wb.a aVar) {
            this.f22855a.h(j.a.INBOUND, i10, aVar);
            rb.k1 k1VarF = i.o0(aVar).f("Rst Stream");
            boolean z10 = k1VarF.n() == k1.b.CANCELLED || k1VarF.n() == k1.b.DEADLINE_EXCEEDED;
            synchronized (i.this.f22832k) {
                try {
                    h hVar = (h) i.this.f22835n.get(Integer.valueOf(i10));
                    if (hVar != null) {
                        bc.c.d("OkHttpClientTransport$ClientFrameHandler.rstStream", hVar.t().h0());
                        i.this.U(i10, k1VarF, aVar == wb.a.REFUSED_STREAM ? s.a.REFUSED : s.a.PROCESSED, z10, null, null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // wb.b.a
        public void i(boolean z10, boolean z11, int i10, int i11, List list, wb.e eVar) {
            rb.k1 k1VarR;
            boolean z12;
            int iB;
            this.f22855a.d(j.a.INBOUND, i10, list, z11);
            if (i.this.N == Integer.MAX_VALUE || (iB = b(list)) <= i.this.N) {
                k1VarR = null;
            } else {
                k1VarR = rb.k1.f19601n.r(String.format(Locale.US, "Response %s metadata larger than %d: %d", z11 ? "trailer" : "header", Integer.valueOf(i.this.N), Integer.valueOf(iB)));
            }
            synchronized (i.this.f22832k) {
                try {
                    h hVar = (h) i.this.f22835n.get(Integer.valueOf(i10));
                    z12 = false;
                    if (hVar == null) {
                        if (i.this.b0(i10)) {
                            i.this.f22830i.g(i10, wb.a.STREAM_CLOSED);
                        } else {
                            z12 = true;
                        }
                    } else if (k1VarR == null) {
                        bc.c.d("OkHttpClientTransport$ClientFrameHandler.headers", hVar.t().h0());
                        hVar.t().j0(list, z11);
                    } else {
                        if (!z11) {
                            i.this.f22830i.g(i10, wb.a.CANCEL);
                        }
                        hVar.t().N(k1VarR, false, new y0());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z12) {
                i.this.e0(wb.a.PROTOCOL_ERROR, "Received header for unknown stream: " + i10);
            }
        }

        @Override // wb.b.a
        public void j(boolean z10, int i10, hh.f fVar, int i11, int i12) {
            this.f22855a.b(j.a.INBOUND, i10, fVar.p(), i11, z10);
            h hVarY = i.this.Y(i10);
            if (hVarY != null) {
                long j10 = i11;
                fVar.V(j10);
                hh.d dVar = new hh.d();
                dVar.L(fVar.p(), j10);
                bc.c.d("OkHttpClientTransport$ClientFrameHandler.data", hVarY.t().h0());
                synchronized (i.this.f22832k) {
                    hVarY.t().i0(dVar, z10, i12 - i11);
                }
            } else {
                if (!i.this.b0(i10)) {
                    i.this.e0(wb.a.PROTOCOL_ERROR, "Received data for unknown stream: " + i10);
                    return;
                }
                synchronized (i.this.f22832k) {
                    i.this.f22830i.g(i10, wb.a.STREAM_CLOSED);
                }
                fVar.skip(i11);
            }
            i.D(i.this, i12);
            if (i.this.f22840s >= i.this.f22827f * 0.5f) {
                synchronized (i.this.f22832k) {
                    i.this.f22830i.a(0, i.this.f22840s);
                }
                i.this.f22840s = 0;
            }
        }

        @Override // wb.b.a
        public void k(boolean z10, wb.i iVar) {
            boolean zF;
            this.f22855a.i(j.a.INBOUND, iVar);
            synchronized (i.this.f22832k) {
                try {
                    if (n.b(iVar, 4)) {
                        i.this.E = n.a(iVar, 4);
                    }
                    if (n.b(iVar, 7)) {
                        zF = i.this.f22831j.f(n.a(iVar, 7));
                    } else {
                        zF = false;
                    }
                    if (this.f22857c) {
                        i iVar2 = i.this;
                        iVar2.f22842u = iVar2.f22829h.e(i.this.f22842u);
                        i.this.f22829h.a();
                        this.f22857c = false;
                    }
                    i.this.f22830i.v(iVar);
                    if (zF) {
                        i.this.f22831j.h();
                    }
                    i.this.k0();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // wb.b.a
        public void l(int i10, wb.a aVar, hh.g gVar) {
            this.f22855a.c(j.a.INBOUND, i10, aVar, gVar);
            if (aVar == wb.a.ENHANCE_YOUR_CALM) {
                String strK = gVar.K();
                i.W.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, strK));
                if ("too_many_pings".equals(strK)) {
                    i.this.M.run();
                }
            }
            rb.k1 k1VarF = r0.h.i(aVar.f23814a).f("Received Goaway");
            if (gVar.B() > 0) {
                k1VarF = k1VarF.f(gVar.K());
            }
            i.this.j0(i10, null, k1VarF);
        }

        @Override // wb.b.a
        public void n(int i10, int i11, List list) {
            this.f22855a.g(j.a.INBOUND, i10, i11, list);
            synchronized (i.this.f22832k) {
                i.this.f22830i.g(i10, wb.a.PROTOCOL_ERROR);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            rb.k1 k1VarR;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.f22856b.l(this)) {
                try {
                    if (i.this.H != null) {
                        i.this.H.m();
                    }
                } catch (Throwable th) {
                    try {
                        i.this.j0(0, wb.a.PROTOCOL_ERROR, rb.k1.f19606s.r("error in frame handler").q(th));
                        try {
                            this.f22856b.close();
                        } catch (IOException e10) {
                            e = e10;
                            i.W.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                        } catch (RuntimeException e11) {
                            if (!"bio == null".equals(e11.getMessage())) {
                                throw e11;
                            }
                        }
                    } catch (Throwable th2) {
                        try {
                            this.f22856b.close();
                        } catch (IOException e12) {
                            i.W.log(Level.INFO, "Exception closing frame reader", (Throwable) e12);
                        } catch (RuntimeException e13) {
                            if (!"bio == null".equals(e13.getMessage())) {
                                throw e13;
                            }
                        }
                        i.this.f22829h.b();
                        Thread.currentThread().setName(name);
                        throw th2;
                    }
                }
            }
            synchronized (i.this.f22832k) {
                k1VarR = i.this.f22843v;
            }
            if (k1VarR == null) {
                k1VarR = rb.k1.f19607t.r("End of stream or IOException");
            }
            i.this.j0(0, wb.a.INTERNAL_ERROR, k1VarR);
            try {
                this.f22856b.close();
            } catch (IOException e14) {
                e = e14;
                i.W.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
            } catch (RuntimeException e15) {
                if (!"bio == null".equals(e15.getMessage())) {
                    throw e15;
                }
            }
            i.this.f22829h.b();
            Thread.currentThread().setName(name);
        }

        @Override // wb.b.a
        public void h() {
        }

        @Override // wb.b.a
        public void m(int i10, int i11, int i12, boolean z10) {
        }
    }
}
