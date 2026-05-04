package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f22653c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22655b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: ua.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0389a extends id.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f22656a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f22657b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f22659d;

            public C0389a(gd.e eVar) {
                super(eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) {
                this.f22657b = obj;
                this.f22659d |= Integer.MIN_VALUE;
                return a.this.a(null, this);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
        
            if (r10 == r1) goto L33;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r10v17 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [ga.h] */
        /* JADX WARN: Type inference failed for: r9v0, types: [ga.h, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Type inference failed for: r9v15 */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v18 */
        /* JADX WARN: Type inference failed for: r9v19 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v20 */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Type inference failed for: r9v7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(ga.h r9, gd.e r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof ua.t.a.C0389a
                if (r0 == 0) goto L13
                r0 = r10
                ua.t$a$a r0 = (ua.t.a.C0389a) r0
                int r1 = r0.f22659d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f22659d = r1
                goto L18
            L13:
                ua.t$a$a r0 = new ua.t$a$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.f22657b
                java.lang.Object r1 = hd.c.f()
                int r2 = r0.f22659d
                java.lang.String r3 = "FirebaseSessions"
                r4 = 2
                r5 = 1
                java.lang.String r6 = ""
                if (r2 == 0) goto L48
                if (r2 == r5) goto L3e
                if (r2 != r4) goto L36
                java.lang.Object r9 = r0.f22656a
                java.lang.String r9 = (java.lang.String) r9
                cd.s.b(r10)     // Catch: java.lang.Exception -> L34
                goto L85
            L34:
                r10 = move-exception
                goto L8c
            L36:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L3e:
                java.lang.Object r9 = r0.f22656a
                ga.h r9 = (ga.h) r9
                cd.s.b(r10)     // Catch: java.lang.Exception -> L46
                goto L60
            L46:
                r10 = move-exception
                goto L6a
            L48:
                cd.s.b(r10)
                r10 = 0
                com.google.android.gms.tasks.Task r10 = r9.a(r10)     // Catch: java.lang.Exception -> L46
                java.lang.String r2 = "getToken(...)"
                kotlin.jvm.internal.t.e(r10, r2)     // Catch: java.lang.Exception -> L46
                r0.f22656a = r9     // Catch: java.lang.Exception -> L46
                r0.f22659d = r5     // Catch: java.lang.Exception -> L46
                java.lang.Object r10 = xg.b.a(r10, r0)     // Catch: java.lang.Exception -> L46
                if (r10 != r1) goto L60
                goto L84
            L60:
                ga.m r10 = (ga.m) r10     // Catch: java.lang.Exception -> L46
                java.lang.String r10 = r10.b()     // Catch: java.lang.Exception -> L46
                r7 = r10
                r10 = r9
                r9 = r7
                goto L71
            L6a:
                java.lang.String r2 = "Error getting authentication token."
                android.util.Log.w(r3, r2, r10)
                r10 = r9
                r9 = r6
            L71:
                com.google.android.gms.tasks.Task r10 = r10.getId()     // Catch: java.lang.Exception -> L34
                java.lang.String r2 = "getId(...)"
                kotlin.jvm.internal.t.e(r10, r2)     // Catch: java.lang.Exception -> L34
                r0.f22656a = r9     // Catch: java.lang.Exception -> L34
                r0.f22659d = r4     // Catch: java.lang.Exception -> L34
                java.lang.Object r10 = xg.b.a(r10, r0)     // Catch: java.lang.Exception -> L34
                if (r10 != r1) goto L85
            L84:
                return r1
            L85:
                java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L34
                if (r10 != 0) goto L8a
                goto L91
            L8a:
                r6 = r10
                goto L91
            L8c:
                java.lang.String r0 = "Error getting Firebase installation id ."
                android.util.Log.w(r3, r0, r10)
            L91:
                ua.t r10 = new ua.t
                r0 = 0
                r10.<init>(r6, r9, r0)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ua.t.a.a(ga.h, gd.e):java.lang.Object");
        }

        public a() {
        }
    }

    public /* synthetic */ t(String str, String str2, kotlin.jvm.internal.k kVar) {
        this(str, str2);
    }

    public final String a() {
        return this.f22655b;
    }

    public final String b() {
        return this.f22654a;
    }

    public t(String str, String str2) {
        this.f22654a = str;
        this.f22655b = str2;
    }
}
