package xa;

import kotlin.jvm.internal.t;
import lg.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f24754c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f24755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f24756b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f24757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f24758b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f24760d;

        public b(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f24758b = obj;
            this.f24760d |= Integer.MIN_VALUE;
            return j.this.f(this);
        }
    }

    public j(o localOverrideSettings, o remoteSettings) {
        t.f(localOverrideSettings, "localOverrideSettings");
        t.f(remoteSettings, "remoteSettings");
        this.f24755a = localOverrideSettings;
        this.f24756b = remoteSettings;
    }

    public final double a() {
        Double d10 = this.f24755a.d();
        if (d10 != null) {
            double dDoubleValue = d10.doubleValue();
            if (d(dDoubleValue)) {
                return dDoubleValue;
            }
        }
        Double d11 = this.f24756b.d();
        if (d11 == null) {
            return 1.0d;
        }
        double dDoubleValue2 = d11.doubleValue();
        if (d(dDoubleValue2)) {
            return dDoubleValue2;
        }
        return 1.0d;
    }

    public final long b() {
        lg.a aVarB = this.f24755a.b();
        if (aVarB != null) {
            long jC0 = aVarB.c0();
            if (e(jC0)) {
                return jC0;
            }
        }
        lg.a aVarB2 = this.f24756b.b();
        if (aVarB2 != null) {
            long jC02 = aVarB2.c0();
            if (e(jC02)) {
                return jC02;
            }
        }
        a.C0282a c0282a = lg.a.f15679b;
        return lg.c.s(30, lg.d.f15690f);
    }

    public final boolean c() {
        Boolean boolA = this.f24755a.a();
        if (boolA != null) {
            return boolA.booleanValue();
        }
        Boolean boolA2 = this.f24756b.a();
        if (boolA2 != null) {
            return boolA2.booleanValue();
        }
        return true;
    }

    public final boolean d(double d10) {
        return 0.0d <= d10 && d10 <= 1.0d;
    }

    public final boolean e(long j10) {
        return lg.a.V(j10) && lg.a.M(j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r6.c(r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(gd.e r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof xa.j.b
            if (r0 == 0) goto L13
            r0 = r6
            xa.j$b r0 = (xa.j.b) r0
            int r1 = r0.f24760d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f24760d = r1
            goto L18
        L13:
            xa.j$b r0 = new xa.j$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f24758b
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f24760d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            cd.s.b(r6)
            goto L5b
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.f24757a
            xa.j r2 = (xa.j) r2
            cd.s.b(r6)
            goto L4d
        L3c:
            cd.s.b(r6)
            xa.o r6 = r5.f24755a
            r0.f24757a = r5
            r0.f24760d = r4
            java.lang.Object r6 = r6.c(r0)
            if (r6 != r1) goto L4c
            goto L5a
        L4c:
            r2 = r5
        L4d:
            xa.o r6 = r2.f24756b
            r2 = 0
            r0.f24757a = r2
            r0.f24760d = r3
            java.lang.Object r6 = r6.c(r0)
            if (r6 != r1) goto L5b
        L5a:
            return r1
        L5b:
            cd.h0 r6 = cd.h0.f3852a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: xa.j.f(gd.e):java.lang.Object");
    }
}
