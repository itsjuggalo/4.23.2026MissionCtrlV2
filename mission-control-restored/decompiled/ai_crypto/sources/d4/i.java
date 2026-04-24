package d4;

import Q2.n;
import a6.C0929a;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f13385c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f13386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f13387b;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final i a() {
            return ((com.google.firebase.sessions.b) n.a(Q2.c.f4486a).k(com.google.firebase.sessions.b.class)).e();
        }

        public a() {
        }
    }

    public static final class b extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13389b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13391d;

        public b(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f13389b = obj;
            this.f13391d |= Integer.MIN_VALUE;
            return i.this.f(this);
        }
    }

    public i(m localOverrideSettings, m remoteSettings) {
        r.f(localOverrideSettings, "localOverrideSettings");
        r.f(remoteSettings, "remoteSettings");
        this.f13386a = localOverrideSettings;
        this.f13387b = remoteSettings;
    }

    public final double a() {
        Double d7 = this.f13386a.d();
        if (d7 != null) {
            double dDoubleValue = d7.doubleValue();
            if (d(dDoubleValue)) {
                return dDoubleValue;
            }
        }
        Double d8 = this.f13387b.d();
        if (d8 == null) {
            return 1.0d;
        }
        double dDoubleValue2 = d8.doubleValue();
        if (d(dDoubleValue2)) {
            return dDoubleValue2;
        }
        return 1.0d;
    }

    public final long b() {
        C0929a c0929aC = this.f13386a.c();
        if (c0929aC != null) {
            long jM = c0929aC.M();
            if (e(jM)) {
                return jM;
            }
        }
        C0929a c0929aC2 = this.f13387b.c();
        if (c0929aC2 != null) {
            long jM2 = c0929aC2.M();
            if (e(jM2)) {
                return jM2;
            }
        }
        C0929a.C0116a c0116a = C0929a.f6400b;
        return a6.c.s(30, a6.d.f6411f);
    }

    public final boolean c() {
        Boolean boolA = this.f13386a.a();
        if (boolA != null) {
            return boolA.booleanValue();
        }
        Boolean boolA2 = this.f13387b.a();
        if (boolA2 != null) {
            return boolA2.booleanValue();
        }
        return true;
    }

    public final boolean d(double d7) {
        return 0.0d <= d7 && d7 <= 1.0d;
    }

    public final boolean e(long j7) {
        return C0929a.F(j7) && C0929a.A(j7);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(H5.d r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof d4.i.b
            if (r0 == 0) goto L13
            r0 = r6
            d4.i$b r0 = (d4.i.b) r0
            int r1 = r0.f13391d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13391d = r1
            goto L18
        L13:
            d4.i$b r0 = new d4.i$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f13389b
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f13391d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            E5.q.b(r6)
            goto L5b
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.f13388a
            d4.i r2 = (d4.i) r2
            E5.q.b(r6)
            goto L4d
        L3c:
            E5.q.b(r6)
            d4.m r6 = r5.f13386a
            r0.f13388a = r5
            r0.f13391d = r4
            java.lang.Object r6 = r6.b(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r2 = r5
        L4d:
            d4.m r6 = r2.f13387b
            r2 = 0
            r0.f13388a = r2
            r0.f13391d = r3
            java.lang.Object r6 = r6.b(r0)
            if (r6 != r1) goto L5b
            return r1
        L5b:
            E5.E r6 = E5.E.f1657a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.i.f(H5.d):java.lang.Object");
    }
}
