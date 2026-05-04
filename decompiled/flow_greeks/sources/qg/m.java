package qg;

import cd.h0;
import kotlin.jvm.internal.k0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class m {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements qg.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qg.d f19158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ pd.o f19159b;

        public a(qg.d dVar, pd.o oVar) {
            this.f19158a = dVar;
            this.f19159b = oVar;
        }

        @Override // qg.d
        public Object collect(e eVar, gd.e eVar2) {
            Object objCollect = this.f19158a.collect(new b(new k0(), eVar, this.f19159b), eVar2);
            return objCollect == hd.c.f() ? objCollect : h0.f3852a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k0 f19160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f19161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ pd.o f19162c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends id.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f19163a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f19164b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f19165c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f19167e;

            public a(gd.e eVar) {
                super(eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) {
                this.f19165c = obj;
                this.f19167e |= Integer.MIN_VALUE;
                return b.this.emit(null, this);
            }
        }

        public b(k0 k0Var, e eVar, pd.o oVar) {
            this.f19160a = k0Var;
            this.f19161b = eVar;
            this.f19162c = oVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        
            if (r8.emit(r7, r0) == r1) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
        
            if (r8.emit(r7, r0) == r1) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // qg.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(java.lang.Object r7, gd.e r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof qg.m.b.a
                if (r0 == 0) goto L13
                r0 = r8
                qg.m$b$a r0 = (qg.m.b.a) r0
                int r1 = r0.f19167e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f19167e = r1
                goto L18
            L13:
                qg.m$b$a r0 = new qg.m$b$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f19165c
                java.lang.Object r1 = hd.c.f()
                int r2 = r0.f19167e
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L45
                if (r2 == r5) goto L41
                if (r2 == r4) goto L37
                if (r2 != r3) goto L2f
                cd.s.b(r8)
                goto L88
            L2f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L37:
                java.lang.Object r7 = r0.f19164b
                java.lang.Object r2 = r0.f19163a
                qg.m$b r2 = (qg.m.b) r2
                cd.s.b(r8)
                goto L6c
            L41:
                cd.s.b(r8)
                goto L59
            L45:
                cd.s.b(r8)
                kotlin.jvm.internal.k0 r8 = r6.f19160a
                boolean r8 = r8.f14943a
                if (r8 == 0) goto L5c
                qg.e r8 = r6.f19161b
                r0.f19167e = r5
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L59
                goto L87
            L59:
                cd.h0 r7 = cd.h0.f3852a
                return r7
            L5c:
                pd.o r8 = r6.f19162c
                r0.f19163a = r6
                r0.f19164b = r7
                r0.f19167e = r4
                java.lang.Object r8 = r8.invoke(r7, r0)
                if (r8 != r1) goto L6b
                goto L87
            L6b:
                r2 = r6
            L6c:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L8b
                kotlin.jvm.internal.k0 r8 = r2.f19160a
                r8.f14943a = r5
                qg.e r8 = r2.f19161b
                r2 = 0
                r0.f19163a = r2
                r0.f19164b = r2
                r0.f19167e = r3
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L88
            L87:
                return r1
            L88:
                cd.h0 r7 = cd.h0.f3852a
                return r7
            L8b:
                cd.h0 r7 = cd.h0.f3852a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: qg.m.b.emit(java.lang.Object, gd.e):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements qg.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qg.d f19168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ pd.o f19169b;

        public static final class a extends id.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f19170a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f19171b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f19173d;

            public a(gd.e eVar) {
                super(eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) {
                this.f19170a = obj;
                this.f19171b |= Integer.MIN_VALUE;
                return c.this.collect(null, this);
            }
        }

        public c(qg.d dVar, pd.o oVar) {
            this.f19168a = dVar;
            this.f19169b = oVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // qg.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(qg.e r6, gd.e r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof qg.m.c.a
                if (r0 == 0) goto L13
                r0 = r7
                qg.m$c$a r0 = (qg.m.c.a) r0
                int r1 = r0.f19171b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f19171b = r1
                goto L18
            L13:
                qg.m$c$a r0 = new qg.m$c$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f19170a
                java.lang.Object r1 = hd.c.f()
                int r2 = r0.f19171b
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r6 = r0.f19173d
                qg.m$d r6 = (qg.m.d) r6
                cd.s.b(r7)     // Catch: rg.a -> L2d
                goto L53
            L2d:
                r7 = move-exception
                goto L50
            L2f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L37:
                cd.s.b(r7)
                qg.d r7 = r5.f19168a
                qg.m$d r2 = new qg.m$d
                pd.o r4 = r5.f19169b
                r2.<init>(r4, r6)
                r0.f19173d = r2     // Catch: rg.a -> L4e
                r0.f19171b = r3     // Catch: rg.a -> L4e
                java.lang.Object r6 = r7.collect(r2, r0)     // Catch: rg.a -> L4e
                if (r6 != r1) goto L53
                return r1
            L4e:
                r7 = move-exception
                r6 = r2
            L50:
                rg.j.a(r7, r6)
            L53:
                cd.h0 r6 = cd.h0.f3852a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: qg.m.c.collect(qg.e, gd.e):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pd.o f19174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f19175b;

        public static final class a extends id.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f19176a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f19177b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f19178c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f19180e;

            public a(gd.e eVar) {
                super(eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) {
                this.f19177b = obj;
                this.f19178c |= Integer.MIN_VALUE;
                return d.this.emit(null, this);
            }
        }

        public d(pd.o oVar, e eVar) {
            this.f19174a = oVar;
            this.f19175b = eVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
        
            if (r2.emit(r9, r0) == r1) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // qg.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object emit(java.lang.Object r8, gd.e r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof qg.m.d.a
                if (r0 == 0) goto L13
                r0 = r9
                qg.m$d$a r0 = (qg.m.d.a) r0
                int r1 = r0.f19178c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f19178c = r1
                goto L18
            L13:
                qg.m$d$a r0 = new qg.m$d$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.f19177b
                java.lang.Object r1 = hd.c.f()
                int r2 = r0.f19178c
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r8 = r0.f19176a
                qg.m$d r8 = (qg.m.d) r8
                cd.s.b(r9)
                goto L7c
            L30:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L38:
                java.lang.Object r8 = r0.f19180e
                java.lang.Object r2 = r0.f19176a
                qg.m$d r2 = (qg.m.d) r2
                cd.s.b(r9)
                r6 = r9
                r9 = r8
                r8 = r2
                r2 = r6
                goto L63
            L46:
                cd.s.b(r9)
                pd.o r9 = r7.f19174a
                r0.f19176a = r7
                r0.f19180e = r8
                r0.f19178c = r4
                r2 = 6
                kotlin.jvm.internal.r.a(r2)
                java.lang.Object r9 = r9.invoke(r8, r0)
                r2 = 7
                kotlin.jvm.internal.r.a(r2)
                if (r9 != r1) goto L60
                goto L7a
            L60:
                r2 = r9
                r9 = r8
                r8 = r7
            L63:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L7b
                qg.e r2 = r8.f19175b
                r0.f19176a = r8
                r5 = 0
                r0.f19180e = r5
                r0.f19178c = r3
                java.lang.Object r9 = r2.emit(r9, r0)
                if (r9 != r1) goto L7c
            L7a:
                return r1
            L7b:
                r4 = 0
            L7c:
                if (r4 == 0) goto L81
                cd.h0 r8 = cd.h0.f3852a
                return r8
            L81:
                rg.a r9 = new rg.a
                r9.<init>(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: qg.m.d.emit(java.lang.Object, gd.e):java.lang.Object");
        }
    }

    public static final qg.d a(qg.d dVar, pd.o oVar) {
        return new a(dVar, oVar);
    }

    public static final qg.d b(qg.d dVar, pd.o oVar) {
        return new c(dVar, oVar);
    }
}
