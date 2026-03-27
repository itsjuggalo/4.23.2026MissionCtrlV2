package N2;

import K2.AbstractC0363k;
import K2.C;
import K2.C0353a;
import K2.C0355c;
import K2.D;
import K2.E;
import K2.K;
import K2.Z;
import K2.a0;
import K2.i0;
import K2.l0;
import K2.m0;
import M2.C0415d0;
import M2.InterfaceC0431l0;
import M2.InterfaceC0443s;
import M2.InterfaceC0445t;
import M2.InterfaceC0451w;
import M2.J0;
import M2.O0;
import M2.Q;
import M2.S;
import M2.U0;
import M2.W;
import M2.X;
import N2.b;
import N2.f;
import N2.h;
import N2.j;
import N2.r;
import O3.t;
import P2.b;
import Q2.a;
import Q2.b;
import com.revenuecat.purchases.common.Constants;
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

/* JADX INFO: loaded from: classes3.dex */
public class i implements InterfaceC0451w, b.a, r.d {

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final Map f2988V = R();

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final Logger f2989W = Logger.getLogger(i.class.getName());

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final SocketFactory f2990A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public SSLSocketFactory f2991B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public HostnameVerifier f2992C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public Socket f2993D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f2994E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final Deque f2995F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final O2.b f2996G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public C0415d0 f2997H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f2998I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f2999J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public long f3000K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public boolean f3001L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public final Runnable f3002M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public final int f3003N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public final boolean f3004O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public final U0 f3005P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final X f3006Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public E.b f3007R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final D f3008S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f3009T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public Runnable f3010U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InetSocketAddress f3011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f3014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Z1.r f3015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final P2.j f3017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InterfaceC0431l0.a f3018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public N2.b f3019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f3020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f3021k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final K f3022l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3023m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f3024n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Executor f3025o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final J0 f3026p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScheduledExecutorService f3027q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f3028r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3029s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public e f3030t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public C0353a f3031u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public l0 f3032v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3033w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public W f3034x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3035y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3036z;

    public class a extends X {
        public a() {
        }

        @Override // M2.X
        public void b() {
            i.this.f3018h.c(true);
        }

        @Override // M2.X
        public void c() {
            i.this.f3018h.c(false);
        }
    }

    public class b implements U0.c {
        public b() {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = i.this.f3010U;
            if (runnable != null) {
                runnable.run();
            }
            i.this.f3025o.execute(i.this.f3030t);
            synchronized (i.this.f3021k) {
                i.this.f2994E = Integer.MAX_VALUE;
                i.this.l0();
            }
            i.this.getClass();
        }
    }

    public i(f.C0050f c0050f, InetSocketAddress inetSocketAddress, String str, String str2, C0353a c0353a, D d4, Runnable runnable) {
        this(c0050f, inetSocketAddress, str, str2, c0353a, S.f1977w, new P2.g(), d4, runnable);
    }

    public static /* synthetic */ int E(i iVar, int i4) {
        int i5 = iVar.f3029s + i4;
        iVar.f3029s = i5;
        return i5;
    }

    public static Map R() {
        EnumMap enumMap = new EnumMap(P2.a.class);
        P2.a aVar = P2.a.NO_ERROR;
        l0 l0Var = l0.f1229s;
        enumMap.put(aVar, l0Var.q("No error: A GRPC status of OK should have been sent"));
        enumMap.put(P2.a.PROTOCOL_ERROR, l0Var.q("Protocol error"));
        enumMap.put(P2.a.INTERNAL_ERROR, l0Var.q("Internal error"));
        enumMap.put(P2.a.FLOW_CONTROL_ERROR, l0Var.q("Flow control error"));
        enumMap.put(P2.a.STREAM_CLOSED, l0Var.q("Stream closed"));
        enumMap.put(P2.a.FRAME_TOO_LARGE, l0Var.q("Frame too large"));
        enumMap.put(P2.a.REFUSED_STREAM, l0.f1230t.q("Refused stream"));
        enumMap.put(P2.a.CANCEL, l0.f1216f.q("Cancelled"));
        enumMap.put(P2.a.COMPRESSION_ERROR, l0Var.q("Compression error"));
        enumMap.put(P2.a.CONNECT_ERROR, l0Var.q("Connect error"));
        enumMap.put(P2.a.ENHANCE_YOUR_CALM, l0.f1224n.q("Enhance your calm"));
        enumMap.put(P2.a.INADEQUATE_SECURITY, l0.f1222l.q("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    public static String g0(t tVar) throws EOFException {
        O3.d dVar = new O3.d();
        while (tVar.v(dVar, 1L) != -1) {
            if (dVar.E(dVar.i0() - 1) == 10) {
                return dVar.f0();
            }
        }
        throw new EOFException("\\n not found: " + dVar.P().n());
    }

    public static l0 p0(P2.a aVar) {
        l0 l0Var = (l0) f2988V.get(aVar);
        if (l0Var != null) {
            return l0Var;
        }
        return l0.f1217g.q("Unknown http2 error code: " + aVar.f3465a);
    }

    public final Q2.b S(InetSocketAddress inetSocketAddress, String str, String str2) {
        Q2.a aVarA = new a.b().k("https").h(inetSocketAddress.getHostName()).j(inetSocketAddress.getPort()).a();
        b.C0059b c0059bD = new b.C0059b().e(aVarA).d("Host", aVarA.c() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + aVarA.f()).d("User-Agent", this.f3013c);
        if (str != null && str2 != null) {
            c0059bD.d("Proxy-Authorization", O2.c.a(str, str2));
        }
        return c0059bD.c();
    }

    public final Socket T(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws m0 {
        Socket socketCreateSocket = null;
        try {
            socketCreateSocket = inetSocketAddress2.getAddress() != null ? this.f2990A.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : this.f2990A.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            socketCreateSocket.setTcpNoDelay(true);
            socketCreateSocket.setSoTimeout(this.f3009T);
            t tVarE = O3.i.e(socketCreateSocket);
            O3.e eVarA = O3.i.a(O3.i.d(socketCreateSocket));
            Q2.b bVarS = S(inetSocketAddress, str, str2);
            Q2.a aVarB = bVarS.b();
            eVarA.y(String.format(Locale.US, "CONNECT %s:%d HTTP/1.1", aVarB.c(), Integer.valueOf(aVarB.f()))).y("\r\n");
            int iB = bVarS.a().b();
            for (int i4 = 0; i4 < iB; i4++) {
                eVarA.y(bVarS.a().a(i4)).y(": ").y(bVarS.a().c(i4)).y("\r\n");
            }
            eVarA.y("\r\n");
            eVarA.flush();
            O2.j jVarA = O2.j.a(g0(tVarE));
            while (!g0(tVarE).equals("")) {
            }
            int i5 = jVarA.f3293b;
            if (i5 >= 200 && i5 < 300) {
                socketCreateSocket.setSoTimeout(0);
                return socketCreateSocket;
            }
            O3.d dVar = new O3.d();
            try {
                socketCreateSocket.shutdownOutput();
                tVarE.v(dVar, 1024L);
            } catch (IOException e4) {
                dVar.y("Unable to read body: " + e4.toString());
            }
            try {
                socketCreateSocket.close();
            } catch (IOException unused) {
            }
            throw l0.f1230t.q(String.format(Locale.US, "Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(jVarA.f3293b), jVarA.f3294c, dVar.d0())).c();
        } catch (IOException e5) {
            if (socketCreateSocket != null) {
                S.e(socketCreateSocket);
            }
            throw l0.f1230t.q("Failed trying to connect with proxy").p(e5).c();
        }
    }

    public void U(boolean z4, long j4, long j5, boolean z5) {
        this.f2998I = z4;
        this.f2999J = j4;
        this.f3000K = j5;
        this.f3001L = z5;
    }

    public void V(int i4, l0 l0Var, InterfaceC0443s.a aVar, boolean z4, P2.a aVar2, Z z5) {
        synchronized (this.f3021k) {
            try {
                h hVar = (h) this.f3024n.remove(Integer.valueOf(i4));
                if (hVar != null) {
                    if (aVar2 != null) {
                        this.f3019i.a(i4, P2.a.CANCEL);
                    }
                    if (l0Var != null) {
                        h.b bVarO = hVar.A();
                        if (z5 == null) {
                            z5 = new Z();
                        }
                        bVarO.M(l0Var, aVar, z4, z5);
                    }
                    if (!l0()) {
                        n0();
                        d0(hVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String W() {
        URI uriB = S.b(this.f3012b);
        return uriB.getHost() != null ? uriB.getHost() : this.f3012b;
    }

    public int X() {
        URI uriB = S.b(this.f3012b);
        return uriB.getPort() != -1 ? uriB.getPort() : this.f3011a.getPort();
    }

    public final Throwable Y() {
        synchronized (this.f3021k) {
            try {
                l0 l0Var = this.f3032v;
                if (l0Var != null) {
                    return l0Var.c();
                }
                return l0.f1230t.q("Connection closed").c();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public h Z(int i4) {
        h hVar;
        synchronized (this.f3021k) {
            hVar = (h) this.f3024n.get(Integer.valueOf(i4));
        }
        return hVar;
    }

    @Override // N2.r.d
    public r.c[] a() {
        r.c[] cVarArr;
        synchronized (this.f3021k) {
            try {
                cVarArr = new r.c[this.f3024n.size()];
                Iterator it = this.f3024n.values().iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    cVarArr[i4] = ((h) it.next()).A().b0();
                    i4++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVarArr;
    }

    public final void a0() {
        synchronized (this.f3021k) {
            this.f3005P.g(new b());
        }
    }

    @Override // M2.InterfaceC0431l0
    public void b(l0 l0Var) {
        e(l0Var);
        synchronized (this.f3021k) {
            try {
                Iterator it = this.f3024n.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    it.remove();
                    ((h) entry.getValue()).A().N(l0Var, false, new Z());
                    d0((h) entry.getValue());
                }
                for (h hVar : this.f2995F) {
                    hVar.A().M(l0Var, InterfaceC0443s.a.MISCARRIED, true, new Z());
                    d0(hVar);
                }
                this.f2995F.clear();
                n0();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b0() {
        return this.f2991B == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c0(int r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f3021k
            monitor-enter(r0)
            int r1 = r2.f3023m     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: N2.i.c0(int):boolean");
    }

    @Override // M2.InterfaceC0451w
    public C0353a d() {
        return this.f3031u;
    }

    public final void d0(h hVar) {
        if (this.f3036z && this.f2995F.isEmpty() && this.f3024n.isEmpty()) {
            this.f3036z = false;
            C0415d0 c0415d0 = this.f2997H;
            if (c0415d0 != null) {
                c0415d0.o();
            }
        }
        if (hVar.z()) {
            this.f3006Q.e(hVar, false);
        }
    }

    @Override // M2.InterfaceC0431l0
    public void e(l0 l0Var) {
        synchronized (this.f3021k) {
            try {
                if (this.f3032v != null) {
                    return;
                }
                this.f3032v = l0Var;
                this.f3018h.d(l0Var);
                n0();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // M2.InterfaceC0445t
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public h c(a0 a0Var, Z z4, C0355c c0355c, AbstractC0363k[] abstractC0363kArr) {
        h hVar;
        Z1.m.o(a0Var, "method");
        Z1.m.o(z4, "headers");
        O0 o0H = O0.h(abstractC0363kArr, d(), z4);
        synchronized (this.f3021k) {
            hVar = new h(a0Var, z4, this.f3019i, this, this.f3020j, this.f3021k, this.f3028r, this.f3016f, this.f3012b, this.f3013c, o0H, this.f3005P, c0355c, this.f3004O);
        }
        return hVar;
    }

    @Override // M2.InterfaceC0445t
    public void f(InterfaceC0445t.a aVar, Executor executor) {
        long jNextLong;
        synchronized (this.f3021k) {
            try {
                boolean z4 = true;
                Z1.m.t(this.f3019i != null);
                if (this.f3035y) {
                    W.g(aVar, executor, Y());
                    return;
                }
                W w4 = this.f3034x;
                if (w4 != null) {
                    jNextLong = 0;
                    z4 = false;
                } else {
                    jNextLong = this.f3014d.nextLong();
                    Z1.p pVar = (Z1.p) this.f3015e.get();
                    pVar.g();
                    W w5 = new W(jNextLong, pVar);
                    this.f3034x = w5;
                    this.f3005P.b();
                    w4 = w5;
                }
                if (z4) {
                    this.f3019i.c(false, (int) (jNextLong >>> 32), (int) jNextLong);
                }
                w4.a(aVar, executor);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f0(P2.a aVar, String str) {
        k0(0, aVar, p0(aVar).e(str));
    }

    @Override // N2.b.a
    public void g(Throwable th) {
        Z1.m.o(th, "failureCause");
        k0(0, P2.a.INTERNAL_ERROR, l0.f1230t.p(th));
    }

    @Override // K2.P
    public K h() {
        return this.f3022l;
    }

    public void h0(h hVar) {
        this.f2995F.remove(hVar);
        d0(hVar);
    }

    @Override // M2.InterfaceC0431l0
    public Runnable i(InterfaceC0431l0.a aVar) {
        this.f3018h = (InterfaceC0431l0.a) Z1.m.o(aVar, "listener");
        if (this.f2998I) {
            C0415d0 c0415d0 = new C0415d0(new C0415d0.c(this), this.f3027q, this.f2999J, this.f3000K, this.f3001L);
            this.f2997H = c0415d0;
            c0415d0.p();
        }
        N2.a aVarA0 = N2.a.a0(this.f3026p, this, 10000);
        P2.c cVarS = aVarA0.S(this.f3017g.b(O3.i.a(aVarA0), true));
        synchronized (this.f3021k) {
            N2.b bVar = new N2.b(this, cVarS);
            this.f3019i = bVar;
            this.f3020j = new r(this, bVar);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f3026p.execute(new c(countDownLatch, aVarA0));
        try {
            i0();
            countDownLatch.countDown();
            this.f3026p.execute(new d());
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    public final void i0() {
        synchronized (this.f3021k) {
            try {
                this.f3019i.t();
                P2.i iVar = new P2.i();
                n.c(iVar, 7, this.f3016f);
                this.f3019i.F(iVar);
                if (this.f3016f > 65535) {
                    this.f3019i.b(0, r1 - 65535);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j0(h hVar) {
        if (!this.f3036z) {
            this.f3036z = true;
            C0415d0 c0415d0 = this.f2997H;
            if (c0415d0 != null) {
                c0415d0.n();
            }
        }
        if (hVar.z()) {
            this.f3006Q.e(hVar, true);
        }
    }

    public final void k0(int i4, P2.a aVar, l0 l0Var) {
        synchronized (this.f3021k) {
            try {
                if (this.f3032v == null) {
                    this.f3032v = l0Var;
                    this.f3018h.d(l0Var);
                }
                if (aVar != null && !this.f3033w) {
                    this.f3033w = true;
                    this.f3019i.N(0, aVar, new byte[0]);
                }
                Iterator it = this.f3024n.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() > i4) {
                        it.remove();
                        ((h) entry.getValue()).A().M(l0Var, InterfaceC0443s.a.REFUSED, false, new Z());
                        d0((h) entry.getValue());
                    }
                }
                for (h hVar : this.f2995F) {
                    hVar.A().M(l0Var, InterfaceC0443s.a.MISCARRIED, true, new Z());
                    d0(hVar);
                }
                this.f2995F.clear();
                n0();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean l0() {
        boolean z4 = false;
        while (!this.f2995F.isEmpty() && this.f3024n.size() < this.f2994E) {
            m0((h) this.f2995F.poll());
            z4 = true;
        }
        return z4;
    }

    public final void m0(h hVar) {
        Z1.m.u(hVar.A().c0() == -1, "StreamId already assigned");
        this.f3024n.put(Integer.valueOf(this.f3023m), hVar);
        j0(hVar);
        hVar.A().f0(this.f3023m);
        if ((hVar.N() != a0.d.UNARY && hVar.N() != a0.d.SERVER_STREAMING) || hVar.P()) {
            this.f3019i.flush();
        }
        int i4 = this.f3023m;
        if (i4 < 2147483645) {
            this.f3023m = i4 + 2;
        } else {
            this.f3023m = Integer.MAX_VALUE;
            k0(Integer.MAX_VALUE, P2.a.NO_ERROR, l0.f1230t.q("Stream ids exhausted"));
        }
    }

    public final void n0() {
        if (this.f3032v == null || !this.f3024n.isEmpty() || !this.f2995F.isEmpty() || this.f3035y) {
            return;
        }
        this.f3035y = true;
        C0415d0 c0415d0 = this.f2997H;
        if (c0415d0 != null) {
            c0415d0.q();
        }
        W w4 = this.f3034x;
        if (w4 != null) {
            w4.f(Y());
            this.f3034x = null;
        }
        if (!this.f3033w) {
            this.f3033w = true;
            this.f3019i.N(0, P2.a.NO_ERROR, new byte[0]);
        }
        this.f3019i.close();
    }

    public void o0(h hVar) {
        if (this.f3032v != null) {
            hVar.A().M(this.f3032v, InterfaceC0443s.a.MISCARRIED, true, new Z());
        } else if (this.f3024n.size() < this.f2994E) {
            m0(hVar);
        } else {
            this.f2995F.add(hVar);
            j0(hVar);
        }
    }

    public String toString() {
        return Z1.g.b(this).c("logId", this.f3022l.d()).d("address", this.f3011a).toString();
    }

    public i(f.C0050f c0050f, InetSocketAddress inetSocketAddress, String str, String str2, C0353a c0353a, Z1.r rVar, P2.j jVar, D d4, Runnable runnable) {
        this.f3014d = new Random();
        this.f3021k = new Object();
        this.f3024n = new HashMap();
        this.f2994E = 0;
        this.f2995F = new LinkedList();
        this.f3006Q = new a();
        this.f3009T = 30000;
        this.f3011a = (InetSocketAddress) Z1.m.o(inetSocketAddress, "address");
        this.f3012b = str;
        this.f3028r = c0050f.f2949j;
        this.f3016f = c0050f.f2954o;
        this.f3025o = (Executor) Z1.m.o(c0050f.f2941b, "executor");
        this.f3026p = new J0(c0050f.f2941b);
        this.f3027q = (ScheduledExecutorService) Z1.m.o(c0050f.f2943d, "scheduledExecutorService");
        this.f3023m = 3;
        SocketFactory socketFactory = c0050f.f2945f;
        this.f2990A = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.f2991B = c0050f.f2946g;
        this.f2992C = c0050f.f2947h;
        this.f2996G = (O2.b) Z1.m.o(c0050f.f2948i, "connectionSpec");
        this.f3015e = (Z1.r) Z1.m.o(rVar, "stopwatchFactory");
        this.f3017g = (P2.j) Z1.m.o(jVar, "variant");
        this.f3013c = S.h("okhttp", str2);
        this.f3008S = d4;
        this.f3002M = (Runnable) Z1.m.o(runnable, "tooManyPingsRunnable");
        this.f3003N = c0050f.f2956q;
        this.f3005P = c0050f.f2944e.a();
        this.f3022l = K.a(getClass(), inetSocketAddress.toString());
        this.f3031u = C0353a.c().d(Q.f1953b, c0353a).a();
        this.f3004O = c0050f.f2957r;
        a0();
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f3039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ N2.a f3040b;

        public c(CountDownLatch countDownLatch, N2.a aVar) {
            this.f3039a = countDownLatch;
            this.f3040b = aVar;
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
            Socket socketT;
            SSLSession session;
            Socket socket;
            try {
                this.f3039a.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            O3.f fVarB = O3.i.b(new a());
            try {
                try {
                    i iVar2 = i.this;
                    D d4 = iVar2.f3008S;
                    if (d4 == null) {
                        socketT = iVar2.f2990A.createSocket(i.this.f3011a.getAddress(), i.this.f3011a.getPort());
                    } else {
                        if (!(d4.b() instanceof InetSocketAddress)) {
                            throw l0.f1229s.q("Unsupported SocketAddress implementation " + i.this.f3008S.b().getClass()).c();
                        }
                        i iVar3 = i.this;
                        socketT = iVar3.T(iVar3.f3008S.c(), (InetSocketAddress) i.this.f3008S.b(), i.this.f3008S.d(), i.this.f3008S.a());
                    }
                    Socket socket2 = socketT;
                    if (i.this.f2991B != null) {
                        SSLSocket sSLSocketB = o.b(i.this.f2991B, i.this.f2992C, socket2, i.this.W(), i.this.X(), i.this.f2996G);
                        session = sSLSocketB.getSession();
                        socket = sSLSocketB;
                    } else {
                        session = null;
                        socket = socket2;
                    }
                    socket.setTcpNoDelay(true);
                    O3.f fVarB2 = O3.i.b(O3.i.e(socket));
                    this.f3040b.P(O3.i.d(socket), socket);
                    i iVar4 = i.this;
                    iVar4.f3031u = iVar4.f3031u.d().d(C.f1009a, socket.getRemoteSocketAddress()).d(C.f1010b, socket.getLocalSocketAddress()).d(C.f1011c, session).d(Q.f1952a, session == null ? i0.NONE : i0.PRIVACY_AND_INTEGRITY).a();
                    i iVar5 = i.this;
                    iVar5.f3030t = iVar5.new e(iVar5.f3017g.a(fVarB2, true));
                    synchronized (i.this.f3021k) {
                        try {
                            i.this.f2993D = (Socket) Z1.m.o(socket, "socket");
                            if (session != null) {
                                i.this.f3007R = new E.b(new E.c(session));
                            }
                        } finally {
                        }
                    }
                } catch (m0 e4) {
                    i.this.k0(0, P2.a.INTERNAL_ERROR, e4.a());
                    iVar = i.this;
                    eVar = iVar.new e(iVar.f3017g.a(fVarB, true));
                    iVar.f3030t = eVar;
                } catch (Exception e5) {
                    i.this.g(e5);
                    iVar = i.this;
                    eVar = iVar.new e(iVar.f3017g.a(fVarB, true));
                    iVar.f3030t = eVar;
                }
            } catch (Throwable th) {
                i iVar6 = i.this;
                iVar6.f3030t = iVar6.new e(iVar6.f3017g.a(fVarB, true));
                throw th;
            }
        }

        public class a implements t {
            public a() {
            }

            @Override // O3.t
            public long v(O3.d dVar, long j4) {
                return -1L;
            }

            @Override // O3.t, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        }
    }

    public class e implements b.a, Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public P2.b f3045b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f3044a = new j(Level.FINE, i.class);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3046c = true;

        public e(P2.b bVar) {
            this.f3045b = bVar;
        }

        @Override // P2.b.a
        public void a(int i4, P2.a aVar) {
            this.f3044a.h(j.a.INBOUND, i4, aVar);
            l0 l0VarE = i.p0(aVar).e("Rst Stream");
            boolean z4 = l0VarE.m() == l0.b.CANCELLED || l0VarE.m() == l0.b.DEADLINE_EXCEEDED;
            synchronized (i.this.f3021k) {
                try {
                    h hVar = (h) i.this.f3024n.get(Integer.valueOf(i4));
                    if (hVar != null) {
                        U2.c.d("OkHttpClientTransport$ClientFrameHandler.rstStream", hVar.A().h0());
                        i.this.V(i4, l0VarE, aVar == P2.a.REFUSED_STREAM ? InterfaceC0443s.a.REFUSED : InterfaceC0443s.a.PROCESSED, z4, null, null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        @Override // P2.b.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(int r8, long r9) {
            /*
                r7 = this;
                N2.j r0 = r7.f3044a
                N2.j$a r1 = N2.j.a.INBOUND
                r0.k(r1, r8, r9)
                r0 = 0
                int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r0 != 0) goto L2c
                java.lang.String r9 = "Received 0 flow control window increment."
                if (r8 != 0) goto L19
                N2.i r8 = N2.i.this
                P2.a r10 = P2.a.PROTOCOL_ERROR
                N2.i.B(r8, r10, r9)
                return
            L19:
                N2.i r0 = N2.i.this
                K2.l0 r10 = K2.l0.f1229s
                K2.l0 r2 = r10.q(r9)
                M2.s$a r3 = M2.InterfaceC0443s.a.PROCESSED
                P2.a r5 = P2.a.PROTOCOL_ERROR
                r6 = 0
                r4 = 0
                r1 = r8
                r0.V(r1, r2, r3, r4, r5, r6)
                return
            L2c:
                r1 = r8
                N2.i r8 = N2.i.this
                java.lang.Object r8 = N2.i.k(r8)
                monitor-enter(r8)
                if (r1 != 0) goto L46
                N2.i r0 = N2.i.this     // Catch: java.lang.Throwable -> L43
                N2.r r0 = N2.i.x(r0)     // Catch: java.lang.Throwable -> L43
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
                N2.i r0 = N2.i.this     // Catch: java.lang.Throwable -> L43
                java.util.Map r0 = N2.i.G(r0)     // Catch: java.lang.Throwable -> L43
                java.lang.Integer r2 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L43
                java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L43
                N2.h r0 = (N2.h) r0     // Catch: java.lang.Throwable -> L43
                if (r0 == 0) goto L6b
                N2.i r2 = N2.i.this     // Catch: java.lang.Throwable -> L43
                N2.r r2 = N2.i.x(r2)     // Catch: java.lang.Throwable -> L43
                N2.h$b r0 = r0.A()     // Catch: java.lang.Throwable -> L43
                N2.r$c r0 = r0.b0()     // Catch: java.lang.Throwable -> L43
                int r9 = (int) r9     // Catch: java.lang.Throwable -> L43
                r2.g(r0, r9)     // Catch: java.lang.Throwable -> L43
                goto L75
            L6b:
                N2.i r9 = N2.i.this     // Catch: java.lang.Throwable -> L43
                boolean r9 = r9.c0(r1)     // Catch: java.lang.Throwable -> L43
                if (r9 != 0) goto L75
                r9 = 1
                goto L76
            L75:
                r9 = 0
            L76:
                monitor-exit(r8)     // Catch: java.lang.Throwable -> L43
                if (r9 == 0) goto L91
                N2.i r8 = N2.i.this
                P2.a r9 = P2.a.PROTOCOL_ERROR
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r0 = "Received window_update for unknown stream: "
                r10.append(r0)
                r10.append(r1)
                java.lang.String r10 = r10.toString()
                N2.i.B(r8, r9, r10)
            L91:
                return
            L92:
                monitor-exit(r8)     // Catch: java.lang.Throwable -> L43
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: N2.i.e.b(int, long):void");
        }

        @Override // P2.b.a
        public void c(boolean z4, int i4, int i5) {
            W w4;
            long j4 = (((long) i4) << 32) | (((long) i5) & KeyboardMap.kValueMask);
            this.f3044a.e(j.a.INBOUND, j4);
            if (!z4) {
                synchronized (i.this.f3021k) {
                    i.this.f3019i.c(true, i4, i5);
                }
                return;
            }
            synchronized (i.this.f3021k) {
                try {
                    w4 = null;
                    if (i.this.f3034x == null) {
                        i.f2989W.warning("Received unexpected ping ack. No ping outstanding");
                    } else if (i.this.f3034x.h() == j4) {
                        W w5 = i.this.f3034x;
                        i.this.f3034x = null;
                        w4 = w5;
                    } else {
                        i.f2989W.log(Level.WARNING, String.format(Locale.US, "Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(i.this.f3034x.h()), Long.valueOf(j4)));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (w4 != null) {
                w4.d();
            }
        }

        @Override // P2.b.a
        public void d(boolean z4, P2.i iVar) {
            boolean zF;
            this.f3044a.i(j.a.INBOUND, iVar);
            synchronized (i.this.f3021k) {
                try {
                    if (n.b(iVar, 4)) {
                        i.this.f2994E = n.a(iVar, 4);
                    }
                    if (n.b(iVar, 7)) {
                        zF = i.this.f3020j.f(n.a(iVar, 7));
                    } else {
                        zF = false;
                    }
                    if (this.f3046c) {
                        i iVar2 = i.this;
                        iVar2.f3031u = iVar2.f3018h.e(i.this.f3031u);
                        i.this.f3018h.a();
                        this.f3046c = false;
                    }
                    i.this.f3019i.H(iVar);
                    if (zF) {
                        i.this.f3020j.h();
                    }
                    i.this.l0();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // P2.b.a
        public void f(boolean z4, boolean z5, int i4, int i5, List list, P2.e eVar) {
            l0 l0VarQ;
            boolean z6;
            int iK;
            this.f3044a.d(j.a.INBOUND, i4, list, z5);
            if (i.this.f3003N == Integer.MAX_VALUE || (iK = k(list)) <= i.this.f3003N) {
                l0VarQ = null;
            } else {
                l0VarQ = l0.f1224n.q(String.format(Locale.US, "Response %s metadata larger than %d: %d", z5 ? "trailer" : "header", Integer.valueOf(i.this.f3003N), Integer.valueOf(iK)));
            }
            synchronized (i.this.f3021k) {
                try {
                    h hVar = (h) i.this.f3024n.get(Integer.valueOf(i4));
                    z6 = false;
                    if (hVar == null) {
                        if (i.this.c0(i4)) {
                            i.this.f3019i.a(i4, P2.a.STREAM_CLOSED);
                        } else {
                            z6 = true;
                        }
                    } else if (l0VarQ == null) {
                        U2.c.d("OkHttpClientTransport$ClientFrameHandler.headers", hVar.A().h0());
                        hVar.A().j0(list, z5);
                    } else {
                        if (!z5) {
                            i.this.f3019i.a(i4, P2.a.CANCEL);
                        }
                        hVar.A().N(l0VarQ, false, new Z());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z6) {
                i.this.f0(P2.a.PROTOCOL_ERROR, "Received header for unknown stream: " + i4);
            }
        }

        @Override // P2.b.a
        public void g(int i4, P2.a aVar, O3.g gVar) {
            this.f3044a.c(j.a.INBOUND, i4, aVar, gVar);
            if (aVar == P2.a.ENHANCE_YOUR_CALM) {
                String strZ = gVar.z();
                i.f2989W.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, strZ));
                if ("too_many_pings".equals(strZ)) {
                    i.this.f3002M.run();
                }
            }
            l0 l0VarE = S.h.i(aVar.f3465a).e("Received Goaway");
            if (gVar.v() > 0) {
                l0VarE = l0VarE.e(gVar.z());
            }
            i.this.k0(i4, null, l0VarE);
        }

        @Override // P2.b.a
        public void i(boolean z4, int i4, O3.f fVar, int i5, int i6) {
            this.f3044a.b(j.a.INBOUND, i4, fVar.q(), i5, z4);
            h hVarZ = i.this.Z(i4);
            if (hVarZ != null) {
                long j4 = i5;
                fVar.Y(j4);
                O3.d dVar = new O3.d();
                dVar.c0(fVar.q(), j4);
                U2.c.d("OkHttpClientTransport$ClientFrameHandler.data", hVarZ.A().h0());
                synchronized (i.this.f3021k) {
                    hVarZ.A().i0(dVar, z4, i6 - i5);
                }
            } else {
                if (!i.this.c0(i4)) {
                    i.this.f0(P2.a.PROTOCOL_ERROR, "Received data for unknown stream: " + i4);
                    return;
                }
                synchronized (i.this.f3021k) {
                    i.this.f3019i.a(i4, P2.a.STREAM_CLOSED);
                }
                fVar.skip(i5);
            }
            i.E(i.this, i6);
            if (i.this.f3029s >= i.this.f3016f * 0.5f) {
                synchronized (i.this.f3021k) {
                    i.this.f3019i.b(0, i.this.f3029s);
                }
                i.this.f3029s = 0;
            }
        }

        @Override // P2.b.a
        public void j(int i4, int i5, List list) {
            this.f3044a.g(j.a.INBOUND, i4, i5, list);
            synchronized (i.this.f3021k) {
                i.this.f3019i.a(i4, P2.a.PROTOCOL_ERROR);
            }
        }

        public final int k(List list) {
            long jV = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                P2.d dVar = (P2.d) list.get(i4);
                jV += (long) (dVar.f3475a.v() + 32 + dVar.f3476b.v());
            }
            return (int) Math.min(jV, 2147483647L);
        }

        @Override // java.lang.Runnable
        public void run() {
            l0 l0VarQ;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.f3045b.w(this)) {
                try {
                    if (i.this.f2997H != null) {
                        i.this.f2997H.m();
                    }
                } catch (Throwable th) {
                    try {
                        i.this.k0(0, P2.a.PROTOCOL_ERROR, l0.f1229s.q("error in frame handler").p(th));
                        try {
                            this.f3045b.close();
                        } catch (IOException e4) {
                            e = e4;
                            i.f2989W.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                        } catch (RuntimeException e5) {
                            if (!"bio == null".equals(e5.getMessage())) {
                                throw e5;
                            }
                        }
                    } catch (Throwable th2) {
                        try {
                            this.f3045b.close();
                        } catch (IOException e6) {
                            i.f2989W.log(Level.INFO, "Exception closing frame reader", (Throwable) e6);
                        } catch (RuntimeException e7) {
                            if (!"bio == null".equals(e7.getMessage())) {
                                throw e7;
                            }
                        }
                        i.this.f3018h.b();
                        Thread.currentThread().setName(name);
                        throw th2;
                    }
                }
            }
            synchronized (i.this.f3021k) {
                l0VarQ = i.this.f3032v;
            }
            if (l0VarQ == null) {
                l0VarQ = l0.f1230t.q("End of stream or IOException");
            }
            i.this.k0(0, P2.a.INTERNAL_ERROR, l0VarQ);
            try {
                this.f3045b.close();
            } catch (IOException e8) {
                e = e8;
                i.f2989W.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
            } catch (RuntimeException e9) {
                if (!"bio == null".equals(e9.getMessage())) {
                    throw e9;
                }
            }
            i.this.f3018h.b();
            Thread.currentThread().setName(name);
        }

        @Override // P2.b.a
        public void e() {
        }

        @Override // P2.b.a
        public void h(int i4, int i5, int i6, boolean z4) {
        }
    }
}
