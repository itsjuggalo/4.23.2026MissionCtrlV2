package tb;

import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import tb.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h1 extends rb.v0 {
    public static final Logger H = Logger.getLogger(h1.class.getName());
    public static final long I = TimeUnit.MINUTES.toMillis(30);
    public static final long J = TimeUnit.SECONDS.toMillis(1);
    public static final p1 K = l2.c(r0.f21644u);
    public static final rb.v L = rb.v.c();
    public static final rb.o M = rb.o.a();
    public static final Method N;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public final c F;
    public final b G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p1 f21385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p1 f21386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f21387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public rb.d1 f21388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f21389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f21390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rb.b f21391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SocketAddress f21392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f21393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f21394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f21395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f21396l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public rb.v f21397m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public rb.o f21398n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f21399o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21400p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21401q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f21402r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f21403s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f21404t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public rb.e0 f21405u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f21406v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map f21407w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f21408x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public rb.g1 f21409y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f21410z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        int a();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        u a();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements b {
        public d() {
        }

        @Override // tb.h1.b
        public int a() {
            return 443;
        }
    }

    static {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
            Class cls2 = Boolean.TYPE;
            declaredMethod = cls.getDeclaredMethod("getClientInterceptor", cls2, cls2, cls2, cls2);
        } catch (ClassNotFoundException e10) {
            H.log(Level.FINE, "Unable to apply census stats", (Throwable) e10);
            declaredMethod = null;
        } catch (NoSuchMethodException e11) {
            H.log(Level.FINE, "Unable to apply census stats", (Throwable) e11);
            declaredMethod = null;
        }
        N = declaredMethod;
    }

    public h1(String str, c cVar, b bVar) {
        this(str, null, null, cVar, bVar);
    }

    @Override // rb.v0
    public rb.u0 a() {
        return new i1(new g1(this, this.F.a(), new f0.a(), l2.c(r0.f21644u), r0.f21646w, f(), q2.f21623a));
    }

    public int e() {
        return this.G.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List f() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List r1 = r10.f21387c
            r0.<init>(r1)
            java.util.List r1 = rb.i0.a()
            r2 = 0
            if (r1 == 0) goto L13
            r0.addAll(r1)
            r1 = 1
            goto L14
        L13:
            r1 = r2
        L14:
            java.lang.String r3 = "Unable to apply census stats"
            r4 = 0
            if (r1 != 0) goto L5d
            boolean r5 = r10.f21410z
            if (r5 == 0) goto L5d
            java.lang.reflect.Method r5 = tb.h1.N
            if (r5 == 0) goto L57
            boolean r6 = r10.A     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            boolean r7 = r10.B     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            boolean r8 = r10.C     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            boolean r9 = r10.D     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7, r8, r9}     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Object r5 = r5.invoke(r4, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            rb.h r5 = (rb.h) r5     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            goto L58
        L44:
            r5 = move-exception
            goto L48
        L46:
            r5 = move-exception
            goto L50
        L48:
            java.util.logging.Logger r6 = tb.h1.H
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r3, r5)
            goto L57
        L50:
            java.util.logging.Logger r6 = tb.h1.H
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r3, r5)
        L57:
            r5 = r4
        L58:
            if (r5 == 0) goto L5d
            r0.add(r2, r5)
        L5d:
            if (r1 != 0) goto La3
            boolean r1 = r10.E
            if (r1 == 0) goto La3
            java.lang.String r1 = "io.grpc.census.InternalCensusTracingAccessor"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L77 java.lang.IllegalAccessException -> L79 java.lang.NoSuchMethodException -> L7b java.lang.ClassNotFoundException -> L7d
            java.lang.String r5 = "getClientInterceptor"
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r5, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L77 java.lang.IllegalAccessException -> L79 java.lang.NoSuchMethodException -> L7b java.lang.ClassNotFoundException -> L7d
            java.lang.Object r1 = r1.invoke(r4, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L77 java.lang.IllegalAccessException -> L79 java.lang.NoSuchMethodException -> L7b java.lang.ClassNotFoundException -> L7d
            rb.h r1 = (rb.h) r1     // Catch: java.lang.reflect.InvocationTargetException -> L77 java.lang.IllegalAccessException -> L79 java.lang.NoSuchMethodException -> L7b java.lang.ClassNotFoundException -> L7d
            r4 = r1
            goto L9e
        L77:
            r1 = move-exception
            goto L7f
        L79:
            r1 = move-exception
            goto L87
        L7b:
            r1 = move-exception
            goto L8f
        L7d:
            r1 = move-exception
            goto L97
        L7f:
            java.util.logging.Logger r5 = tb.h1.H
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r5.log(r6, r3, r1)
            goto L9e
        L87:
            java.util.logging.Logger r5 = tb.h1.H
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r5.log(r6, r3, r1)
            goto L9e
        L8f:
            java.util.logging.Logger r5 = tb.h1.H
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r5.log(r6, r3, r1)
            goto L9e
        L97:
            java.util.logging.Logger r5 = tb.h1.H
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r5.log(r6, r3, r1)
        L9e:
            if (r4 == 0) goto La3
            r0.add(r2, r4)
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.h1.f():java.util.List");
    }

    public h1(String str, rb.e eVar, rb.b bVar, c cVar, b bVar2) {
        p1 p1Var = K;
        this.f21385a = p1Var;
        this.f21386b = p1Var;
        this.f21387c = new ArrayList();
        this.f21388d = rb.d1.b();
        this.f21389e = new ArrayList();
        this.f21395k = "pick_first";
        this.f21397m = L;
        this.f21398n = M;
        this.f21399o = I;
        this.f21400p = 5;
        this.f21401q = 5;
        this.f21402r = 16777216L;
        this.f21403s = 1048576L;
        this.f21404t = true;
        this.f21405u = rb.e0.g();
        this.f21408x = true;
        this.f21410z = true;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.f21390f = (String) p6.n.o(str, "target");
        this.f21391g = bVar;
        this.F = (c) p6.n.o(cVar, "clientTransportFactoryBuilder");
        this.f21392h = null;
        if (bVar2 != null) {
            this.G = bVar2;
        } else {
            this.G = new d();
        }
    }
}
