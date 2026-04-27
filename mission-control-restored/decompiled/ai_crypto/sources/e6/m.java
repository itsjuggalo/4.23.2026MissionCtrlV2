package e6;

import E5.E;
import kotlin.jvm.internal.D;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class m {

    public static final class a implements e6.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e6.d f13939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Q5.o f13940b;

        public a(e6.d dVar, Q5.o oVar) {
            this.f13939a = dVar;
            this.f13940b = oVar;
        }

        @Override // e6.d
        public Object b(e eVar, H5.d dVar) {
            Object objB = this.f13939a.b(new b(new D(), eVar, this.f13940b), dVar);
            return objB == I5.c.e() ? objB : E.f1657a;
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ D f13941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f13942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Q5.o f13943c;

        public static final class a extends J5.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f13944a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f13945b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f13946c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f13948e;

            public a(H5.d dVar) {
                super(dVar);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) {
                this.f13946c = obj;
                this.f13948e |= Integer.MIN_VALUE;
                return b.this.d(null, this);
            }
        }

        public b(D d7, e eVar, Q5.o oVar) {
            this.f13941a = d7;
            this.f13942b = eVar;
            this.f13943c = oVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // e6.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object d(java.lang.Object r7, H5.d r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof e6.m.b.a
                if (r0 == 0) goto L13
                r0 = r8
                e6.m$b$a r0 = (e6.m.b.a) r0
                int r1 = r0.f13948e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13948e = r1
                goto L18
            L13:
                e6.m$b$a r0 = new e6.m$b$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f13946c
                java.lang.Object r1 = I5.c.e()
                int r2 = r0.f13948e
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L45
                if (r2 == r5) goto L41
                if (r2 == r4) goto L37
                if (r2 != r3) goto L2f
                E5.q.b(r8)
                goto L88
            L2f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L37:
                java.lang.Object r7 = r0.f13945b
                java.lang.Object r2 = r0.f13944a
                e6.m$b r2 = (e6.m.b) r2
                E5.q.b(r8)
                goto L6c
            L41:
                E5.q.b(r8)
                goto L59
            L45:
                E5.q.b(r8)
                kotlin.jvm.internal.D r8 = r6.f13941a
                boolean r8 = r8.f18246a
                if (r8 == 0) goto L5c
                e6.e r8 = r6.f13942b
                r0.f13948e = r5
                java.lang.Object r7 = r8.d(r7, r0)
                if (r7 != r1) goto L59
                return r1
            L59:
                E5.E r7 = E5.E.f1657a
                return r7
            L5c:
                Q5.o r8 = r6.f13943c
                r0.f13944a = r6
                r0.f13945b = r7
                r0.f13948e = r4
                java.lang.Object r8 = r8.invoke(r7, r0)
                if (r8 != r1) goto L6b
                return r1
            L6b:
                r2 = r6
            L6c:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L8b
                kotlin.jvm.internal.D r8 = r2.f13941a
                r8.f18246a = r5
                e6.e r8 = r2.f13942b
                r2 = 0
                r0.f13944a = r2
                r0.f13945b = r2
                r0.f13948e = r3
                java.lang.Object r7 = r8.d(r7, r0)
                if (r7 != r1) goto L88
                return r1
            L88:
                E5.E r7 = E5.E.f1657a
                return r7
            L8b:
                E5.E r7 = E5.E.f1657a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: e6.m.b.d(java.lang.Object, H5.d):java.lang.Object");
        }
    }

    public static final class c implements e6.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e6.d f13949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Q5.o f13950b;

        public static final class a extends J5.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f13951a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f13952b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f13954d;

            public a(H5.d dVar) {
                super(dVar);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) {
                this.f13951a = obj;
                this.f13952b |= Integer.MIN_VALUE;
                return c.this.b(null, this);
            }
        }

        public c(e6.d dVar, Q5.o oVar) {
            this.f13949a = dVar;
            this.f13950b = oVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // e6.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(e6.e r6, H5.d r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof e6.m.c.a
                if (r0 == 0) goto L13
                r0 = r7
                e6.m$c$a r0 = (e6.m.c.a) r0
                int r1 = r0.f13952b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13952b = r1
                goto L18
            L13:
                e6.m$c$a r0 = new e6.m$c$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f13951a
                java.lang.Object r1 = I5.c.e()
                int r2 = r0.f13952b
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r6 = r0.f13954d
                e6.m$d r6 = (e6.m.d) r6
                E5.q.b(r7)     // Catch: f6.a -> L2d
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
                E5.q.b(r7)
                e6.d r7 = r5.f13949a
                e6.m$d r2 = new e6.m$d
                Q5.o r4 = r5.f13950b
                r2.<init>(r4, r6)
                r0.f13954d = r2     // Catch: f6.a -> L4e
                r0.f13952b = r3     // Catch: f6.a -> L4e
                java.lang.Object r6 = r7.b(r2, r0)     // Catch: f6.a -> L4e
                if (r6 != r1) goto L53
                return r1
            L4e:
                r7 = move-exception
                r6 = r2
            L50:
                f6.j.a(r7, r6)
            L53:
                E5.E r6 = E5.E.f1657a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: e6.m.c.b(e6.e, H5.d):java.lang.Object");
        }
    }

    public static final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q5.o f13955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f13956b;

        public static final class a extends J5.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f13957a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f13958b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f13959c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f13961e;

            public a(H5.d dVar) {
                super(dVar);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) {
                this.f13958b = obj;
                this.f13959c |= Integer.MIN_VALUE;
                return d.this.d(null, this);
            }
        }

        public d(Q5.o oVar, e eVar) {
            this.f13955a = oVar;
            this.f13956b = eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // e6.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object d(java.lang.Object r8, H5.d r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof e6.m.d.a
                if (r0 == 0) goto L13
                r0 = r9
                e6.m$d$a r0 = (e6.m.d.a) r0
                int r1 = r0.f13959c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13959c = r1
                goto L18
            L13:
                e6.m$d$a r0 = new e6.m$d$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.f13958b
                java.lang.Object r1 = I5.c.e()
                int r2 = r0.f13959c
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r8 = r0.f13957a
                e6.m$d r8 = (e6.m.d) r8
                E5.q.b(r9)
                goto L7c
            L30:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L38:
                java.lang.Object r8 = r0.f13961e
                java.lang.Object r2 = r0.f13957a
                e6.m$d r2 = (e6.m.d) r2
                E5.q.b(r9)
                r6 = r9
                r9 = r8
                r8 = r2
                r2 = r6
                goto L63
            L46:
                E5.q.b(r9)
                Q5.o r9 = r7.f13955a
                r0.f13957a = r7
                r0.f13961e = r8
                r0.f13959c = r4
                r2 = 6
                kotlin.jvm.internal.p.a(r2)
                java.lang.Object r9 = r9.invoke(r8, r0)
                r2 = 7
                kotlin.jvm.internal.p.a(r2)
                if (r9 != r1) goto L60
                return r1
            L60:
                r2 = r9
                r9 = r8
                r8 = r7
            L63:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L7b
                e6.e r2 = r8.f13956b
                r0.f13957a = r8
                r5 = 0
                r0.f13961e = r5
                r0.f13959c = r3
                java.lang.Object r9 = r2.d(r9, r0)
                if (r9 != r1) goto L7c
                return r1
            L7b:
                r4 = 0
            L7c:
                if (r4 == 0) goto L81
                E5.E r8 = E5.E.f1657a
                return r8
            L81:
                f6.a r9 = new f6.a
                r9.<init>(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: e6.m.d.d(java.lang.Object, H5.d):java.lang.Object");
        }
    }

    public static final e6.d a(e6.d dVar, Q5.o oVar) {
        return new a(dVar, oVar);
    }

    public static final e6.d b(e6.d dVar, Q5.o oVar) {
        return new c(dVar, oVar);
    }
}
