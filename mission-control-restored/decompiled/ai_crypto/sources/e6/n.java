package e6;

import kotlin.jvm.internal.G;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class n {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ G f13962a;

        public a(G g7) {
            this.f13962a = g7;
        }

        @Override // e6.e
        public Object d(Object obj, H5.d dVar) {
            this.f13962a.f18249a = obj;
            throw new f6.a(this);
        }
    }

    public static final class b extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f13964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f13965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13966d;

        public b(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f13965c = obj;
            this.f13966d |= Integer.MIN_VALUE;
            return f.k(null, this);
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ G f13967a;

        public c(G g7) {
            this.f13967a = g7;
        }

        @Override // e6.e
        public Object d(Object obj, H5.d dVar) {
            this.f13967a.f18249a = obj;
            throw new f6.a(this);
        }
    }

    public static final class d extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f13969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f13970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13971d;

        public d(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f13970c = obj;
            this.f13971d |= Integer.MIN_VALUE;
            return f.l(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(e6.d r4, H5.d r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof e6.n.b
            if (r0 == 0) goto L13
            r0 = r5
            e6.n$b r0 = (e6.n.b) r0
            int r1 = r0.f13966d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13966d = r1
            goto L18
        L13:
            e6.n$b r0 = new e6.n$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f13965c
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f13966d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f13964b
            e6.n$a r4 = (e6.n.a) r4
            java.lang.Object r0 = r0.f13963a
            kotlin.jvm.internal.G r0 = (kotlin.jvm.internal.G) r0
            E5.q.b(r5)     // Catch: f6.a -> L31
            goto L62
        L31:
            r5 = move-exception
            goto L5f
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            E5.q.b(r5)
            kotlin.jvm.internal.G r5 = new kotlin.jvm.internal.G
            r5.<init>()
            g6.F r2 = f6.m.f14209a
            r5.f18249a = r2
            e6.n$a r2 = new e6.n$a
            r2.<init>(r5)
            r0.f13963a = r5     // Catch: f6.a -> L5b
            r0.f13964b = r2     // Catch: f6.a -> L5b
            r0.f13966d = r3     // Catch: f6.a -> L5b
            java.lang.Object r4 = r4.b(r2, r0)     // Catch: f6.a -> L5b
            if (r4 != r1) goto L59
            return r1
        L59:
            r0 = r5
            goto L62
        L5b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5f:
            f6.j.a(r5, r4)
        L62:
            java.lang.Object r4 = r0.f18249a
            g6.F r5 = f6.m.f14209a
            if (r4 == r5) goto L69
            return r4
        L69:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.n.a(e6.d, H5.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(e6.d r4, H5.d r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof e6.n.d
            if (r0 == 0) goto L13
            r0 = r5
            e6.n$d r0 = (e6.n.d) r0
            int r1 = r0.f13971d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13971d = r1
            goto L18
        L13:
            e6.n$d r0 = new e6.n$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f13970c
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f13971d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f13969b
            e6.n$c r4 = (e6.n.c) r4
            java.lang.Object r0 = r0.f13968a
            kotlin.jvm.internal.G r0 = (kotlin.jvm.internal.G) r0
            E5.q.b(r5)     // Catch: f6.a -> L31
            goto L5e
        L31:
            r5 = move-exception
            goto L5b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            E5.q.b(r5)
            kotlin.jvm.internal.G r5 = new kotlin.jvm.internal.G
            r5.<init>()
            e6.n$c r2 = new e6.n$c
            r2.<init>(r5)
            r0.f13968a = r5     // Catch: f6.a -> L57
            r0.f13969b = r2     // Catch: f6.a -> L57
            r0.f13971d = r3     // Catch: f6.a -> L57
            java.lang.Object r4 = r4.b(r2, r0)     // Catch: f6.a -> L57
            if (r4 != r1) goto L55
            return r1
        L55:
            r0 = r5
            goto L5e
        L57:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5b:
            f6.j.a(r5, r4)
        L5e:
            java.lang.Object r4 = r0.f18249a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.n.b(e6.d, H5.d):java.lang.Object");
    }
}
