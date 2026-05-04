package qg;

import cd.h0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class h {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f19119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f19120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f19121d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f19122e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19123f;

        public a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f19122e = obj;
            this.f19123f |= Integer.MIN_VALUE;
            return h.c(null, null, false, this);
        }
    }

    public static final Object b(e eVar, pg.w wVar, gd.e eVar2) throws Throwable {
        Object objC = c(eVar, wVar, true, eVar2);
        return objC == hd.c.f() ? objC : h0.f3852a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
    
        if (r2.emit(r9, r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0036, B:24:0x0062, B:28:0x0077, B:30:0x007f, B:20:0x0054, B:23:0x005e), top: B:42:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0091 -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(qg.e r6, pg.w r7, boolean r8, gd.e r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof qg.h.a
            if (r0 == 0) goto L13
            r0 = r9
            qg.h$a r0 = (qg.h.a) r0
            int r1 = r0.f19123f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f19123f = r1
            goto L18
        L13:
            qg.h$a r0 = new qg.h$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f19122e
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f19123f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            boolean r8 = r0.f19121d
            java.lang.Object r6 = r0.f19120c
            pg.i r6 = (pg.i) r6
            java.lang.Object r7 = r0.f19119b
            pg.w r7 = (pg.w) r7
            java.lang.Object r2 = r0.f19118a
            qg.e r2 = (qg.e) r2
            cd.s.b(r9)     // Catch: java.lang.Throwable -> L3c
        L39:
            r9 = r6
            r6 = r2
            goto L62
        L3c:
            r6 = move-exception
            goto L9d
        L3e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L46:
            boolean r8 = r0.f19121d
            java.lang.Object r6 = r0.f19120c
            pg.i r6 = (pg.i) r6
            java.lang.Object r7 = r0.f19119b
            pg.w r7 = (pg.w) r7
            java.lang.Object r2 = r0.f19118a
            qg.e r2 = (qg.e) r2
            cd.s.b(r9)     // Catch: java.lang.Throwable -> L3c
            goto L77
        L58:
            cd.s.b(r9)
            qg.f.k(r6)
            pg.i r9 = r7.iterator()     // Catch: java.lang.Throwable -> L3c
        L62:
            r0.f19118a = r6     // Catch: java.lang.Throwable -> L3c
            r0.f19119b = r7     // Catch: java.lang.Throwable -> L3c
            r0.f19120c = r9     // Catch: java.lang.Throwable -> L3c
            r0.f19121d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f19123f = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r2 = r9.a(r0)     // Catch: java.lang.Throwable -> L3c
            if (r2 != r1) goto L73
            goto L93
        L73:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L77:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L3c
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L3c
            if (r9 == 0) goto L94
            java.lang.Object r9 = r6.next()     // Catch: java.lang.Throwable -> L3c
            r0.f19118a = r2     // Catch: java.lang.Throwable -> L3c
            r0.f19119b = r7     // Catch: java.lang.Throwable -> L3c
            r0.f19120c = r6     // Catch: java.lang.Throwable -> L3c
            r0.f19121d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f19123f = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch: java.lang.Throwable -> L3c
            if (r9 != r1) goto L39
        L93:
            return r1
        L94:
            if (r8 == 0) goto L9a
            r6 = 0
            pg.n.a(r7, r6)
        L9a:
            cd.h0 r6 = cd.h0.f3852a
            return r6
        L9d:
            throw r6     // Catch: java.lang.Throwable -> L9e
        L9e:
            r9 = move-exception
            if (r8 == 0) goto La4
            pg.n.a(r7, r6)
        La4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: qg.h.c(qg.e, pg.w, boolean, gd.e):java.lang.Object");
    }
}
