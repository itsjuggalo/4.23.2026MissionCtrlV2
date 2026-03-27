package j4;

import W6.a;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2707e;
import u5.AbstractC2777d;

/* JADX INFO: renamed from: j4.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2223j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f20074c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f20075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f20076b;

    /* JADX INFO: renamed from: j4.j$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: j4.j$b */
    public static final class b extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f20077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f20078b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20080d;

        public b(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f20078b = obj;
            this.f20080d |= Integer.MIN_VALUE;
            return C2223j.this.f(this);
        }
    }

    public C2223j(o localOverrideSettings, o remoteSettings) {
        AbstractC2304t.f(localOverrideSettings, "localOverrideSettings");
        AbstractC2304t.f(remoteSettings, "remoteSettings");
        this.f20075a = localOverrideSettings;
        this.f20076b = remoteSettings;
    }

    public final double a() {
        Double dC = this.f20075a.c();
        if (dC != null) {
            double dDoubleValue = dC.doubleValue();
            if (d(dDoubleValue)) {
                return dDoubleValue;
            }
        }
        Double dC2 = this.f20076b.c();
        if (dC2 == null) {
            return 1.0d;
        }
        double dDoubleValue2 = dC2.doubleValue();
        if (d(dDoubleValue2)) {
            return dDoubleValue2;
        }
        return 1.0d;
    }

    public final long b() {
        W6.a aVarB = this.f20075a.b();
        if (aVarB != null) {
            long jC0 = aVarB.c0();
            if (e(jC0)) {
                return jC0;
            }
        }
        W6.a aVarB2 = this.f20076b.b();
        if (aVarB2 != null) {
            long jC02 = aVarB2.c0();
            if (e(jC02)) {
                return jC02;
            }
        }
        a.C0149a c0149a = W6.a.f9306b;
        return W6.c.s(30, W6.d.f9317f);
    }

    public final boolean c() {
        Boolean boolA = this.f20075a.a();
        if (boolA != null) {
            return boolA.booleanValue();
        }
        Boolean boolA2 = this.f20076b.a();
        if (boolA2 != null) {
            return boolA2.booleanValue();
        }
        return true;
    }

    public final boolean d(double d8) {
        return 0.0d <= d8 && d8 <= 1.0d;
    }

    public final boolean e(long j8) {
        return W6.a.V(j8) && W6.a.Q(j8);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(s5.InterfaceC2707e r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof j4.C2223j.b
            if (r0 == 0) goto L13
            r0 = r6
            j4.j$b r0 = (j4.C2223j.b) r0
            int r1 = r0.f20080d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20080d = r1
            goto L18
        L13:
            j4.j$b r0 = new j4.j$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20078b
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f20080d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            o5.AbstractC2491s.b(r6)
            goto L5b
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.f20077a
            j4.j r2 = (j4.C2223j) r2
            o5.AbstractC2491s.b(r6)
            goto L4d
        L3c:
            o5.AbstractC2491s.b(r6)
            j4.o r6 = r5.f20075a
            r0.f20077a = r5
            r0.f20080d = r4
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r2 = r5
        L4d:
            j4.o r6 = r2.f20076b
            r2 = 0
            r0.f20077a = r2
            r0.f20080d = r3
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L5b
            return r1
        L5b:
            o5.H r6 = o5.C2470H.f21956a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.C2223j.f(s5.e):java.lang.Object");
    }
}
