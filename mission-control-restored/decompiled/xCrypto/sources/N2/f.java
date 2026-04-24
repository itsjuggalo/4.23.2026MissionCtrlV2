package N2;

import K2.AbstractC0358f;
import K2.AbstractC0376y;
import K2.W;
import K2.r0;
import M2.C0415d0;
import M2.C0420g;
import M2.C0425i0;
import M2.InterfaceC0441q0;
import M2.InterfaceC0447u;
import M2.InterfaceC0451w;
import M2.L0;
import M2.M0;
import M2.S;
import M2.U0;
import O2.b;
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

/* JADX INFO: loaded from: classes3.dex */
public final class f extends AbstractC0376y {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Logger f2910r = Logger.getLogger(f.class.getName());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final O2.b f2911s = new b.C0053b(O2.b.f3236f).f(O2.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, O2.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, O2.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, O2.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, O2.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, O2.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256).i(O2.k.TLS_1_2).h(true).e();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f2912t = TimeUnit.DAYS.toNanos(1000);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final L0.d f2913u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final InterfaceC0441q0 f2914v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final EnumSet f2915w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0425i0 f2916a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SocketFactory f2920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SSLSocketFactory f2921f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HostnameVerifier f2923h;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2929n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public U0.b f2917b = U0.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0441q0 f2918c = f2914v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0441q0 f2919d = M0.c(S.f1976v);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public O2.b f2924i = f2911s;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f2925j = c.TLS;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f2926k = Long.MAX_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f2927l = S.f1968n;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2928m = 65535;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2930o = 4194304;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2931p = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f2932q = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2922g = false;

    public class a implements L0.d {
        @Override // M2.L0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // M2.L0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Executor a() {
            return Executors.newCachedThreadPool(S.j("grpc-okhttp-%d", true));
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f2934b;

        static {
            int[] iArr = new int[c.values().length];
            f2934b = iArr;
            try {
                iArr[c.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2934b[c.TLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[N2.e.values().length];
            f2933a = iArr2;
            try {
                iArr2[N2.e.TLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2933a[N2.e.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum c {
        TLS,
        PLAINTEXT
    }

    public final class d implements C0425i0.b {
        public d() {
        }

        @Override // M2.C0425i0.b
        public int a() {
            return f.this.i();
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this();
        }
    }

    public final class e implements C0425i0.c {
        public e() {
        }

        @Override // M2.C0425i0.c
        public InterfaceC0447u a() {
            return f.this.f();
        }

        public /* synthetic */ e(f fVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: N2.f$f, reason: collision with other inner class name */
    public static final class C0050f implements InterfaceC0447u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0441q0 f2940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f2941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InterfaceC0441q0 f2942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ScheduledExecutorService f2943d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final U0.b f2944e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SocketFactory f2945f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final SSLSocketFactory f2946g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final HostnameVerifier f2947h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final O2.b f2948i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f2949j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f2950k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f2951l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final C0420g f2952m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final long f2953n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f2954o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f2955p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f2956q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f2957r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f2958s;

        /* JADX INFO: renamed from: N2.f$f$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0420g.b f2959a;

            public a(C0420g.b bVar) {
                this.f2959a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f2959a.a();
            }
        }

        public /* synthetic */ C0050f(InterfaceC0441q0 interfaceC0441q0, InterfaceC0441q0 interfaceC0441q02, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, O2.b bVar, int i4, boolean z4, long j4, long j5, int i5, boolean z5, int i6, U0.b bVar2, boolean z6, a aVar) {
            this(interfaceC0441q0, interfaceC0441q02, socketFactory, sSLSocketFactory, hostnameVerifier, bVar, i4, z4, j4, j5, i5, z5, i6, bVar2, z6);
        }

        @Override // M2.InterfaceC0447u
        public InterfaceC0451w I(SocketAddress socketAddress, InterfaceC0447u.a aVar, AbstractC0358f abstractC0358f) {
            if (this.f2958s) {
                throw new IllegalStateException("The transport factory is closed.");
            }
            C0420g.b bVarD = this.f2952m.d();
            i iVar = new i(this, (InetSocketAddress) socketAddress, aVar.a(), aVar.d(), aVar.b(), aVar.c(), new a(bVarD));
            if (this.f2950k) {
                iVar.U(true, bVarD.b(), this.f2953n, this.f2955p);
            }
            return iVar;
        }

        @Override // M2.InterfaceC0447u
        public ScheduledExecutorService R() {
            return this.f2943d;
        }

        @Override // M2.InterfaceC0447u
        public Collection b0() {
            return f.j();
        }

        @Override // M2.InterfaceC0447u, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f2958s) {
                return;
            }
            this.f2958s = true;
            this.f2940a.b(this.f2941b);
            this.f2942c.b(this.f2943d);
        }

        public C0050f(InterfaceC0441q0 interfaceC0441q0, InterfaceC0441q0 interfaceC0441q02, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, O2.b bVar, int i4, boolean z4, long j4, long j5, int i5, boolean z5, int i6, U0.b bVar2, boolean z6) {
            this.f2940a = interfaceC0441q0;
            this.f2941b = (Executor) interfaceC0441q0.a();
            this.f2942c = interfaceC0441q02;
            this.f2943d = (ScheduledExecutorService) interfaceC0441q02.a();
            this.f2945f = socketFactory;
            this.f2946g = sSLSocketFactory;
            this.f2947h = hostnameVerifier;
            this.f2948i = bVar;
            this.f2949j = i4;
            this.f2950k = z4;
            this.f2951l = j4;
            this.f2952m = new C0420g("keepalive time nanos", j4);
            this.f2953n = j5;
            this.f2954o = i5;
            this.f2955p = z5;
            this.f2956q = i6;
            this.f2957r = z6;
            this.f2944e = (U0.b) Z1.m.o(bVar2, "transportTracerFactory");
        }
    }

    static {
        a aVar = new a();
        f2913u = aVar;
        f2914v = M0.c(aVar);
        f2915w = EnumSet.of(r0.MTLS, r0.CUSTOM_MANAGERS);
    }

    public f(String str) {
        a aVar = null;
        this.f2916a = new C0425i0(str, new e(this, aVar), new d(this, aVar));
    }

    public static f h(String str) {
        return new f(str);
    }

    public static Collection j() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // K2.AbstractC0376y
    public W e() {
        return this.f2916a;
    }

    public C0050f f() {
        return new C0050f(this.f2918c, this.f2919d, this.f2920e, g(), this.f2923h, this.f2924i, this.f2930o, this.f2926k != Long.MAX_VALUE, this.f2926k, this.f2927l, this.f2928m, this.f2929n, this.f2931p, this.f2917b, false, null);
    }

    public SSLSocketFactory g() {
        int i4 = b.f2934b[this.f2925j.ordinal()];
        if (i4 == 1) {
            return null;
        }
        if (i4 != 2) {
            throw new RuntimeException("Unknown negotiation type: " + this.f2925j);
        }
        try {
            if (this.f2921f == null) {
                this.f2921f = SSLContext.getInstance("Default", O2.h.e().g()).getSocketFactory();
            }
            return this.f2921f;
        } catch (GeneralSecurityException e4) {
            throw new RuntimeException("TLS Provider failure", e4);
        }
    }

    public int i() {
        int i4 = b.f2934b[this.f2925j.ordinal()];
        if (i4 == 1) {
            return 80;
        }
        if (i4 == 2) {
            return 443;
        }
        throw new AssertionError(this.f2925j + " not handled");
    }

    @Override // K2.W
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public f c(long j4, TimeUnit timeUnit) {
        Z1.m.e(j4 > 0, "keepalive time must be positive");
        long nanos = timeUnit.toNanos(j4);
        this.f2926k = nanos;
        long jL = C0415d0.l(nanos);
        this.f2926k = jL;
        if (jL >= f2912t) {
            this.f2926k = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // K2.W
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public f d() {
        Z1.m.u(!this.f2922g, "Cannot change security when using ChannelCredentials");
        this.f2925j = c.PLAINTEXT;
        return this;
    }
}
