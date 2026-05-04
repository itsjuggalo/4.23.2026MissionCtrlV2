package ub;

import com.google.android.gms.common.api.a;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import rb.q1;
import rb.v0;
import rb.y;
import tb.c1;
import tb.g;
import tb.h1;
import tb.k2;
import tb.l2;
import tb.p1;
import tb.r0;
import tb.t2;
import tb.u;
import tb.w;
import vb.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends y {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Logger f22759r = Logger.getLogger(f.class.getName());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final vb.b f22760s = new b.C0403b(vb.b.f23288f).g(vb.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, vb.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, vb.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, vb.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, vb.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, vb.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256).j(vb.k.TLS_1_2).h(true).e();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f22761t = TimeUnit.DAYS.toNanos(1000);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final k2.d f22762u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final p1 f22763v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final EnumSet f22764w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1 f22765a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SocketFactory f22769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SSLSocketFactory f22770f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HostnameVerifier f22772h;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22778n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t2.b f22766b = t2.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p1 f22767c = f22763v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p1 f22768d = l2.c(r0.f21645v);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public vb.b f22773i = f22760s;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f22774j = c.TLS;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f22775k = Long.MAX_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f22776l = r0.f21637n;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22777m = 65535;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22779o = 4194304;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f22780p = a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f22781q = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f22771g = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements k2.d {
        @Override // tb.k2.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // tb.k2.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Executor a() {
            return Executors.newCachedThreadPool(r0.j("grpc-okhttp-%d", true));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f22783b;

        static {
            int[] iArr = new int[c.values().length];
            f22783b = iArr;
            try {
                iArr[c.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22783b[c.TLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ub.e.values().length];
            f22782a = iArr2;
            try {
                iArr2[ub.e.TLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22782a[ub.e.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c {
        TLS,
        PLAINTEXT
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class d implements h1.b {
        public d() {
        }

        @Override // tb.h1.b
        public int a() {
            return f.this.i();
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class e implements h1.c {
        public e() {
        }

        @Override // tb.h1.c
        public u a() {
            return f.this.f();
        }

        public /* synthetic */ e(f fVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: ub.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0392f implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p1 f22789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f22790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p1 f22791c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ScheduledExecutorService f22792d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final t2.b f22793e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SocketFactory f22794f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final SSLSocketFactory f22795g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final HostnameVerifier f22796h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final vb.b f22797i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f22798j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f22799k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f22800l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final tb.g f22801m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final long f22802n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f22803o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f22804p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f22805q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f22806r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f22807s;

        /* JADX INFO: renamed from: ub.f$f$a */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g.b f22808a;

            public a(g.b bVar) {
                this.f22808a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f22808a.a();
            }
        }

        public /* synthetic */ C0392f(p1 p1Var, p1 p1Var2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, vb.b bVar, int i10, boolean z10, long j10, long j11, int i11, boolean z11, int i12, t2.b bVar2, boolean z12, a aVar) {
            this(p1Var, p1Var2, socketFactory, sSLSocketFactory, hostnameVerifier, bVar, i10, z10, j10, j11, i11, z11, i12, bVar2, z12);
        }

        @Override // tb.u
        public w I(SocketAddress socketAddress, u.a aVar, rb.f fVar) {
            if (this.f22807s) {
                throw new IllegalStateException("The transport factory is closed.");
            }
            g.b bVarD = this.f22801m.d();
            i iVar = new i(this, (InetSocketAddress) socketAddress, aVar.a(), aVar.d(), aVar.b(), aVar.c(), new a(bVarD));
            if (this.f22799k) {
                iVar.T(true, bVarD.b(), this.f22802n, this.f22804p);
            }
            return iVar;
        }

        @Override // tb.u
        public ScheduledExecutorService Q() {
            return this.f22792d;
        }

        @Override // tb.u
        public Collection Y() {
            return f.j();
        }

        @Override // tb.u, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f22807s) {
                return;
            }
            this.f22807s = true;
            this.f22789a.b(this.f22790b);
            this.f22791c.b(this.f22792d);
        }

        public C0392f(p1 p1Var, p1 p1Var2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, vb.b bVar, int i10, boolean z10, long j10, long j11, int i11, boolean z11, int i12, t2.b bVar2, boolean z12) {
            this.f22789a = p1Var;
            this.f22790b = (Executor) p1Var.a();
            this.f22791c = p1Var2;
            this.f22792d = (ScheduledExecutorService) p1Var2.a();
            this.f22794f = socketFactory;
            this.f22795g = sSLSocketFactory;
            this.f22796h = hostnameVerifier;
            this.f22797i = bVar;
            this.f22798j = i10;
            this.f22799k = z10;
            this.f22800l = j10;
            this.f22801m = new tb.g("keepalive time nanos", j10);
            this.f22802n = j11;
            this.f22803o = i11;
            this.f22804p = z11;
            this.f22805q = i12;
            this.f22806r = z12;
            this.f22793e = (t2.b) p6.n.o(bVar2, "transportTracerFactory");
        }
    }

    static {
        a aVar = new a();
        f22762u = aVar;
        f22763v = l2.c(aVar);
        f22764w = EnumSet.of(q1.MTLS, q1.CUSTOM_MANAGERS);
    }

    public f(String str) {
        a aVar = null;
        this.f22765a = new h1(str, new e(this, aVar), new d(this, aVar));
    }

    public static f h(String str) {
        return new f(str);
    }

    public static Collection j() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // rb.y
    public v0 e() {
        return this.f22765a;
    }

    public C0392f f() {
        return new C0392f(this.f22767c, this.f22768d, this.f22769e, g(), this.f22772h, this.f22773i, this.f22779o, this.f22775k != Long.MAX_VALUE, this.f22775k, this.f22776l, this.f22777m, this.f22778n, this.f22780p, this.f22766b, false, null);
    }

    public SSLSocketFactory g() {
        int i10 = b.f22783b[this.f22774j.ordinal()];
        if (i10 == 1) {
            return null;
        }
        if (i10 != 2) {
            throw new RuntimeException("Unknown negotiation type: " + this.f22774j);
        }
        try {
            if (this.f22770f == null) {
                this.f22770f = SSLContext.getInstance("Default", vb.h.e().g()).getSocketFactory();
            }
            return this.f22770f;
        } catch (GeneralSecurityException e10) {
            throw new RuntimeException("TLS Provider failure", e10);
        }
    }

    public int i() {
        int i10 = b.f22783b[this.f22774j.ordinal()];
        if (i10 == 1) {
            return 80;
        }
        if (i10 == 2) {
            return 443;
        }
        throw new AssertionError(this.f22774j + " not handled");
    }

    @Override // rb.v0
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public f c(long j10, TimeUnit timeUnit) {
        p6.n.e(j10 > 0, "keepalive time must be positive");
        long nanos = timeUnit.toNanos(j10);
        this.f22775k = nanos;
        long jL = c1.l(nanos);
        this.f22775k = jL;
        if (jL >= f22761t) {
            this.f22775k = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // rb.v0
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public f d() {
        p6.n.u(!this.f22771g, "Cannot change security when using ChannelCredentials");
        this.f22774j = c.PLAINTEXT;
        return this;
    }
}
