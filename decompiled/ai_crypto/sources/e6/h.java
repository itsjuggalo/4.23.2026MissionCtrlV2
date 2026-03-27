package e6;

import E5.E;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class h {

    public static final class a extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f13900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f13901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f13902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f13903e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f13904f;

        public a(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f13903e = obj;
            this.f13904f |= Integer.MIN_VALUE;
            return h.c(null, null, false, this);
        }
    }

    public static final Object b(e eVar, d6.s sVar, H5.d dVar) throws Throwable {
        Object objC = c(eVar, sVar, true, dVar);
        return objC == I5.c.e() ? objC : E.f1657a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0036, B:24:0x0062, B:28:0x0077, B:30:0x007f, B:20:0x0054, B:23:0x005e), top: B:42:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0091 -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(e6.e r6, d6.s r7, boolean r8, H5.d r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof e6.h.a
            if (r0 == 0) goto L13
            r0 = r9
            e6.h$a r0 = (e6.h.a) r0
            int r1 = r0.f13904f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13904f = r1
            goto L18
        L13:
            e6.h$a r0 = new e6.h$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f13903e
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f13904f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            boolean r8 = r0.f13902d
            java.lang.Object r6 = r0.f13901c
            d6.f r6 = (d6.f) r6
            java.lang.Object r7 = r0.f13900b
            d6.s r7 = (d6.s) r7
            java.lang.Object r2 = r0.f13899a
            e6.e r2 = (e6.e) r2
            E5.q.b(r9)     // Catch: java.lang.Throwable -> L3c
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
            boolean r8 = r0.f13902d
            java.lang.Object r6 = r0.f13901c
            d6.f r6 = (d6.f) r6
            java.lang.Object r7 = r0.f13900b
            d6.s r7 = (d6.s) r7
            java.lang.Object r2 = r0.f13899a
            e6.e r2 = (e6.e) r2
            E5.q.b(r9)     // Catch: java.lang.Throwable -> L3c
            goto L77
        L58:
            E5.q.b(r9)
            e6.f.j(r6)
            d6.f r9 = r7.iterator()     // Catch: java.lang.Throwable -> L3c
        L62:
            r0.f13899a = r6     // Catch: java.lang.Throwable -> L3c
            r0.f13900b = r7     // Catch: java.lang.Throwable -> L3c
            r0.f13901c = r9     // Catch: java.lang.Throwable -> L3c
            r0.f13902d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f13904f = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r2 = r9.b(r0)     // Catch: java.lang.Throwable -> L3c
            if (r2 != r1) goto L73
            return r1
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
            r0.f13899a = r2     // Catch: java.lang.Throwable -> L3c
            r0.f13900b = r7     // Catch: java.lang.Throwable -> L3c
            r0.f13901c = r6     // Catch: java.lang.Throwable -> L3c
            r0.f13902d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f13904f = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r9 = r2.d(r9, r0)     // Catch: java.lang.Throwable -> L3c
            if (r9 != r1) goto L39
            return r1
        L94:
            if (r8 == 0) goto L9a
            r6 = 0
            d6.k.a(r7, r6)
        L9a:
            E5.E r6 = E5.E.f1657a
            return r6
        L9d:
            throw r6     // Catch: java.lang.Throwable -> L9e
        L9e:
            r9 = move-exception
            if (r8 == 0) goto La4
            d6.k.a(r7, r6)
        La4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.h.c(e6.e, d6.s, boolean, H5.d):java.lang.Object");
    }
}
