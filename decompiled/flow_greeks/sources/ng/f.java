package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f17115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f17117c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f17118d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f17119e;

        public a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f17118d = obj;
            this.f17119e |= Integer.MIN_VALUE;
            return f.c(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f17120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f17121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f17122c;

        public b(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f17121b = obj;
            this.f17122c |= Integer.MIN_VALUE;
            return f.b(null, this);
        }
    }

    public static final Object a(u0[] u0VarArr, gd.e eVar) {
        return u0VarArr.length == 0 ? dd.r.k() : new e(u0VarArr).c(eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.util.Collection r4, gd.e r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof ng.f.b
            if (r0 == 0) goto L13
            r0 = r5
            ng.f$b r0 = (ng.f.b) r0
            int r1 = r0.f17122c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17122c = r1
            goto L18
        L13:
            ng.f$b r0 = new ng.f$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f17121b
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f17122c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f17120a
            java.util.Iterator r4 = (java.util.Iterator) r4
            cd.s.b(r5)
            goto L3c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            cd.s.b(r5)
            java.util.Iterator r4 = r4.iterator()
        L3c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L53
            java.lang.Object r5 = r4.next()
            ng.y1 r5 = (ng.y1) r5
            r0.f17120a = r4
            r0.f17122c = r3
            java.lang.Object r5 = r5.join(r0)
            if (r5 != r1) goto L3c
            return r1
        L53:
            cd.h0 r4 = cd.h0.f3852a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ng.f.b(java.util.Collection, gd.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0052 -> B:19:0x0055). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(ng.y1[] r6, gd.e r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof ng.f.a
            if (r0 == 0) goto L13
            r0 = r7
            ng.f$a r0 = (ng.f.a) r0
            int r1 = r0.f17119e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17119e = r1
            goto L18
        L13:
            ng.f$a r0 = new ng.f$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f17118d
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f17119e
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            int r6 = r0.f17117c
            int r2 = r0.f17116b
            java.lang.Object r4 = r0.f17115a
            ng.y1[] r4 = (ng.y1[]) r4
            cd.s.b(r7)
            r7 = r4
            goto L55
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            cd.s.b(r7)
            int r7 = r6.length
            r2 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L42:
            if (r2 >= r6) goto L57
            r4 = r7[r2]
            r0.f17115a = r7
            r0.f17116b = r2
            r0.f17117c = r6
            r0.f17119e = r3
            java.lang.Object r4 = r4.join(r0)
            if (r4 != r1) goto L55
            return r1
        L55:
            int r2 = r2 + r3
            goto L42
        L57:
            cd.h0 r6 = cd.h0.f3852a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ng.f.c(ng.y1[], gd.e):java.lang.Object");
    }
}
