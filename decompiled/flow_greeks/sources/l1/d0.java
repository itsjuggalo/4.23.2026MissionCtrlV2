package l1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wg.a f15001a = wg.g.b(false, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ng.x f15002b = ng.z.b(null, 1, null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f15005c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15007e;

        public a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f15005c = obj;
            this.f15007e |= Integer.MIN_VALUE;
            return d0.this.c(this);
        }
    }

    public final Object a(gd.e eVar) {
        Object objAwait = this.f15002b.await(eVar);
        return objAwait == hd.c.f() ? objAwait : cd.h0.f3852a;
    }

    public abstract Object b(gd.e eVar);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(gd.e r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof l1.d0.a
            if (r0 == 0) goto L13
            r0 = r7
            l1.d0$a r0 = (l1.d0.a) r0
            int r1 = r0.f15007e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15007e = r1
            goto L18
        L13:
            l1.d0$a r0 = new l1.d0$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f15005c
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f15007e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r1 = r0.f15004b
            wg.a r1 = (wg.a) r1
            java.lang.Object r0 = r0.f15003a
            l1.d0 r0 = (l1.d0) r0
            cd.s.b(r7)     // Catch: java.lang.Throwable -> L35
            goto L8b
        L35:
            r7 = move-exception
            goto L96
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3f:
            java.lang.Object r2 = r0.f15004b
            wg.a r2 = (wg.a) r2
            java.lang.Object r4 = r0.f15003a
            l1.d0 r4 = (l1.d0) r4
            cd.s.b(r7)
            r7 = r2
            goto L6a
        L4c:
            cd.s.b(r7)
            ng.x r7 = r6.f15002b
            boolean r7 = r7.isCompleted()
            if (r7 == 0) goto L5a
            cd.h0 r7 = cd.h0.f3852a
            return r7
        L5a:
            wg.a r7 = r6.f15001a
            r0.f15003a = r6
            r0.f15004b = r7
            r0.f15007e = r4
            java.lang.Object r2 = r7.d(r5, r0)
            if (r2 != r1) goto L69
            goto L88
        L69:
            r4 = r6
        L6a:
            ng.x r2 = r4.f15002b     // Catch: java.lang.Throwable -> L78
            boolean r2 = r2.isCompleted()     // Catch: java.lang.Throwable -> L78
            if (r2 == 0) goto L7c
            cd.h0 r0 = cd.h0.f3852a     // Catch: java.lang.Throwable -> L78
            r7.c(r5)
            return r0
        L78:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto L96
        L7c:
            r0.f15003a = r4     // Catch: java.lang.Throwable -> L78
            r0.f15004b = r7     // Catch: java.lang.Throwable -> L78
            r0.f15007e = r3     // Catch: java.lang.Throwable -> L78
            java.lang.Object r0 = r4.b(r0)     // Catch: java.lang.Throwable -> L78
            if (r0 != r1) goto L89
        L88:
            return r1
        L89:
            r1 = r7
            r0 = r4
        L8b:
            ng.x r7 = r0.f15002b     // Catch: java.lang.Throwable -> L35
            cd.h0 r0 = cd.h0.f3852a     // Catch: java.lang.Throwable -> L35
            r7.H(r0)     // Catch: java.lang.Throwable -> L35
            r1.c(r5)
            return r0
        L96:
            r1.c(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.d0.c(gd.e):java.lang.Object");
    }
}
