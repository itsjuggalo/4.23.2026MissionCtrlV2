package i3;

/* JADX INFO: loaded from: classes.dex */
public final class U implements Q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final double f6868f = Math.random();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f6869g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z1.h f6870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Y2.e f6871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l3.m f6872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0685l f6873d;
    public final I4.i e;

    public U(Z1.h firebaseApp, Y2.e firebaseInstallations, l3.m sessionSettings, C0685l eventGDTLogger, I4.i backgroundDispatcher) {
        kotlin.jvm.internal.j.e(firebaseApp, "firebaseApp");
        kotlin.jvm.internal.j.e(firebaseInstallations, "firebaseInstallations");
        kotlin.jvm.internal.j.e(sessionSettings, "sessionSettings");
        kotlin.jvm.internal.j.e(eventGDTLogger, "eventGDTLogger");
        kotlin.jvm.internal.j.e(backgroundDispatcher, "backgroundDispatcher");
        this.f6870a = firebaseApp;
        this.f6871b = firebaseInstallations;
        this.f6872c = sessionSettings;
        this.f6873d = eventGDTLogger;
        this.e = backgroundDispatcher;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
    
        if (r7.b(r0) == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(i3.U r6, K4.c r7) {
        /*
            r6.getClass()
            boolean r0 = r7 instanceof i3.T
            if (r0 == 0) goto L16
            r0 = r7
            i3.T r0 = (i3.T) r0
            int r1 = r0.f6867d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f6867d = r1
            goto L1b
        L16:
            i3.T r0 = new i3.T
            r0.<init>(r6, r7)
        L1b:
            java.lang.Object r7 = r0.f6865b
            J4.a r1 = J4.a.f791a
            int r2 = r0.f6867d
            r3 = 1
            r4 = 2
            java.lang.String r5 = "FirebaseSessions"
            if (r2 == 0) goto L3f
            if (r2 == r3) goto L39
            if (r2 != r4) goto L31
            i3.U r6 = r0.f6864a
            a.AbstractC0284a.E(r7)
            goto L83
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            i3.U r6 = r0.f6864a
            a.AbstractC0284a.E(r7)
            goto L4f
        L3f:
            a.AbstractC0284a.E(r7)
            j3.c r7 = j3.c.f7755a
            r0.f6864a = r6
            r0.f6867d = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r1) goto L4f
            goto L82
        L4f:
            java.util.Map r7 = (java.util.Map) r7
            java.util.Collection r7 = r7.values()
            if (r7 == 0) goto L5e
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L5e
            goto Lbf
        L5e:
            java.util.Iterator r7 = r7.iterator()
        L62:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto Lbf
            java.lang.Object r2 = r7.next()
            q2.j r2 = (q2.C0931j) r2
            i2.a r2 = r2.f9184a
            boolean r2 = r2.a()
            if (r2 == 0) goto L62
            l3.m r7 = r6.f6872c
            r0.f6864a = r6
            r0.f6867d = r4
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r1) goto L83
        L82:
            return r1
        L83:
            l3.m r7 = r6.f6872c
            l3.t r0 = r7.f8132a
            java.lang.Boolean r0 = r0.a()
            if (r0 == 0) goto L92
            boolean r3 = r0.booleanValue()
            goto L9e
        L92:
            l3.t r7 = r7.f8133b
            java.lang.Boolean r7 = r7.a()
            if (r7 == 0) goto L9e
            boolean r3 = r7.booleanValue()
        L9e:
            if (r3 != 0) goto La8
            java.lang.String r6 = "Sessions SDK disabled through settings API. Events will not be sent."
            android.util.Log.d(r5, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        La8:
            l3.m r6 = r6.f6872c
            double r6 = r6.a()
            double r0 = i3.U.f6868f
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto Lb7
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            return r6
        Lb7:
            java.lang.String r6 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r5, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        Lbf:
            java.lang.String r6 = "Sessions SDK disabled through data collection. Events will not be sent."
            android.util.Log.d(r5, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.U.a(i3.U, K4.c):java.lang.Object");
    }
}
