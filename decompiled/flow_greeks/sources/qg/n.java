package qg;

import kotlin.jvm.internal.m0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class n {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0 f19181a;

        public a(m0 m0Var) {
            this.f19181a = m0Var;
        }

        @Override // qg.e
        public Object emit(Object obj, gd.e eVar) {
            this.f19181a.f14947a = obj;
            throw new rg.a(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f19183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f19184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19185d;

        public b(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f19184c = obj;
            this.f19185d |= Integer.MIN_VALUE;
            return f.l(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0 f19186a;

        public c(m0 m0Var) {
            this.f19186a = m0Var;
        }

        @Override // qg.e
        public Object emit(Object obj, gd.e eVar) {
            this.f19186a.f14947a = obj;
            throw new rg.a(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f19188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f19189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19190d;

        public d(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f19189c = obj;
            this.f19190d |= Integer.MIN_VALUE;
            return f.m(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(qg.d r4, gd.e r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof qg.n.b
            if (r0 == 0) goto L13
            r0 = r5
            qg.n$b r0 = (qg.n.b) r0
            int r1 = r0.f19185d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f19185d = r1
            goto L18
        L13:
            qg.n$b r0 = new qg.n$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f19184c
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f19185d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f19183b
            qg.n$a r4 = (qg.n.a) r4
            java.lang.Object r0 = r0.f19182a
            kotlin.jvm.internal.m0 r0 = (kotlin.jvm.internal.m0) r0
            cd.s.b(r5)     // Catch: rg.a -> L31
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
            cd.s.b(r5)
            kotlin.jvm.internal.m0 r5 = new kotlin.jvm.internal.m0
            r5.<init>()
            sg.d0 r2 = rg.m.f19904a
            r5.f14947a = r2
            qg.n$a r2 = new qg.n$a
            r2.<init>(r5)
            r0.f19182a = r5     // Catch: rg.a -> L5b
            r0.f19183b = r2     // Catch: rg.a -> L5b
            r0.f19185d = r3     // Catch: rg.a -> L5b
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: rg.a -> L5b
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
            rg.j.a(r5, r4)
        L62:
            java.lang.Object r4 = r0.f14947a
            sg.d0 r5 = rg.m.f19904a
            if (r4 == r5) goto L69
            return r4
        L69:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: qg.n.a(qg.d, gd.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(qg.d r4, gd.e r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof qg.n.d
            if (r0 == 0) goto L13
            r0 = r5
            qg.n$d r0 = (qg.n.d) r0
            int r1 = r0.f19190d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f19190d = r1
            goto L18
        L13:
            qg.n$d r0 = new qg.n$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f19189c
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f19190d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f19188b
            qg.n$c r4 = (qg.n.c) r4
            java.lang.Object r0 = r0.f19187a
            kotlin.jvm.internal.m0 r0 = (kotlin.jvm.internal.m0) r0
            cd.s.b(r5)     // Catch: rg.a -> L31
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
            cd.s.b(r5)
            kotlin.jvm.internal.m0 r5 = new kotlin.jvm.internal.m0
            r5.<init>()
            qg.n$c r2 = new qg.n$c
            r2.<init>(r5)
            r0.f19187a = r5     // Catch: rg.a -> L57
            r0.f19188b = r2     // Catch: rg.a -> L57
            r0.f19190d = r3     // Catch: rg.a -> L57
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: rg.a -> L57
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
            rg.j.a(r5, r4)
        L5e:
            java.lang.Object r4 = r0.f14947a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: qg.n.b(qg.d, gd.e):java.lang.Object");
    }
}
