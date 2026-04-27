package w3;

import W2.E;
import a3.AbstractC0787c;
import b3.AbstractC0866d;
import kotlin.jvm.internal.D;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class m {

    public static final class a implements w3.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w3.d f15633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i3.o f15634b;

        public a(w3.d dVar, i3.o oVar) {
            this.f15633a = dVar;
            this.f15634b = oVar;
        }

        @Override // w3.d
        public Object collect(e eVar, Z2.e eVar2) {
            Object objCollect = this.f15633a.collect(new b(new D(), eVar, this.f15634b), eVar2);
            return objCollect == AbstractC0787c.e() ? objCollect : E.f5463a;
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ D f15635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f15636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i3.o f15637c;

        public static final class a extends AbstractC0866d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f15638a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f15639b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f15640c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f15642e;

            public a(Z2.e eVar) {
                super(eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) {
                this.f15640c = obj;
                this.f15642e |= Integer.MIN_VALUE;
                return b.this.emit(null, this);
            }
        }

        public b(D d4, e eVar, i3.o oVar) {
            this.f15635a = d4;
            this.f15636b = eVar;
            this.f15637c = oVar;
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
        @Override // w3.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(java.lang.Object r7, Z2.e r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof w3.m.b.a
                if (r0 == 0) goto L13
                r0 = r8
                w3.m$b$a r0 = (w3.m.b.a) r0
                int r1 = r0.f15642e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15642e = r1
                goto L18
            L13:
                w3.m$b$a r0 = new w3.m$b$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f15640c
                java.lang.Object r1 = a3.AbstractC0787c.e()
                int r2 = r0.f15642e
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L45
                if (r2 == r5) goto L41
                if (r2 == r4) goto L37
                if (r2 != r3) goto L2f
                W2.q.b(r8)
                goto L88
            L2f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L37:
                java.lang.Object r7 = r0.f15639b
                java.lang.Object r2 = r0.f15638a
                w3.m$b r2 = (w3.m.b) r2
                W2.q.b(r8)
                goto L6c
            L41:
                W2.q.b(r8)
                goto L59
            L45:
                W2.q.b(r8)
                kotlin.jvm.internal.D r8 = r6.f15635a
                boolean r8 = r8.f13408a
                if (r8 == 0) goto L5c
                w3.e r8 = r6.f15636b
                r0.f15642e = r5
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L59
                goto L87
            L59:
                W2.E r7 = W2.E.f5463a
                return r7
            L5c:
                i3.o r8 = r6.f15637c
                r0.f15638a = r6
                r0.f15639b = r7
                r0.f15642e = r4
                java.lang.Object r8 = r8.invoke(r7, r0)
                if (r8 != r1) goto L6b
                goto L87
            L6b:
                r2 = r6
            L6c:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L8b
                kotlin.jvm.internal.D r8 = r2.f15635a
                r8.f13408a = r5
                w3.e r8 = r2.f15636b
                r2 = 0
                r0.f15638a = r2
                r0.f15639b = r2
                r0.f15642e = r3
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L88
            L87:
                return r1
            L88:
                W2.E r7 = W2.E.f5463a
                return r7
            L8b:
                W2.E r7 = W2.E.f5463a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: w3.m.b.emit(java.lang.Object, Z2.e):java.lang.Object");
        }
    }

    public static final class c implements w3.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w3.d f15643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i3.o f15644b;

        public static final class a extends AbstractC0866d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f15645a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f15646b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f15648d;

            public a(Z2.e eVar) {
                super(eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) {
                this.f15645a = obj;
                this.f15646b |= Integer.MIN_VALUE;
                return c.this.collect(null, this);
            }
        }

        public c(w3.d dVar, i3.o oVar) {
            this.f15643a = dVar;
            this.f15644b = oVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // w3.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(w3.e r6, Z2.e r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof w3.m.c.a
                if (r0 == 0) goto L13
                r0 = r7
                w3.m$c$a r0 = (w3.m.c.a) r0
                int r1 = r0.f15646b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15646b = r1
                goto L18
            L13:
                w3.m$c$a r0 = new w3.m$c$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f15645a
                java.lang.Object r1 = a3.AbstractC0787c.e()
                int r2 = r0.f15646b
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r6 = r0.f15648d
                w3.m$d r6 = (w3.m.d) r6
                W2.q.b(r7)     // Catch: x3.a -> L2d
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
                W2.q.b(r7)
                w3.d r7 = r5.f15643a
                w3.m$d r2 = new w3.m$d
                i3.o r4 = r5.f15644b
                r2.<init>(r4, r6)
                r0.f15648d = r2     // Catch: x3.a -> L4e
                r0.f15646b = r3     // Catch: x3.a -> L4e
                java.lang.Object r6 = r7.collect(r2, r0)     // Catch: x3.a -> L4e
                if (r6 != r1) goto L53
                return r1
            L4e:
                r7 = move-exception
                r6 = r2
            L50:
                x3.j.a(r7, r6)
            L53:
                W2.E r6 = W2.E.f5463a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: w3.m.c.collect(w3.e, Z2.e):java.lang.Object");
        }
    }

    public static final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i3.o f15649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f15650b;

        public static final class a extends AbstractC0866d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f15651a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f15652b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f15653c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f15655e;

            public a(Z2.e eVar) {
                super(eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) {
                this.f15652b = obj;
                this.f15653c |= Integer.MIN_VALUE;
                return d.this.emit(null, this);
            }
        }

        public d(i3.o oVar, e eVar) {
            this.f15649a = oVar;
            this.f15650b = eVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
        
            if (r2.emit(r9, r0) == r1) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // w3.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object emit(java.lang.Object r8, Z2.e r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof w3.m.d.a
                if (r0 == 0) goto L13
                r0 = r9
                w3.m$d$a r0 = (w3.m.d.a) r0
                int r1 = r0.f15653c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15653c = r1
                goto L18
            L13:
                w3.m$d$a r0 = new w3.m$d$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.f15652b
                java.lang.Object r1 = a3.AbstractC0787c.e()
                int r2 = r0.f15653c
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r8 = r0.f15651a
                w3.m$d r8 = (w3.m.d) r8
                W2.q.b(r9)
                goto L7c
            L30:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L38:
                java.lang.Object r8 = r0.f15655e
                java.lang.Object r2 = r0.f15651a
                w3.m$d r2 = (w3.m.d) r2
                W2.q.b(r9)
                r6 = r9
                r9 = r8
                r8 = r2
                r2 = r6
                goto L63
            L46:
                W2.q.b(r9)
                i3.o r9 = r7.f15649a
                r0.f15651a = r7
                r0.f15655e = r8
                r0.f15653c = r4
                r2 = 6
                kotlin.jvm.internal.p.a(r2)
                java.lang.Object r9 = r9.invoke(r8, r0)
                r2 = 7
                kotlin.jvm.internal.p.a(r2)
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
                w3.e r2 = r8.f15650b
                r0.f15651a = r8
                r5 = 0
                r0.f15655e = r5
                r0.f15653c = r3
                java.lang.Object r9 = r2.emit(r9, r0)
                if (r9 != r1) goto L7c
            L7a:
                return r1
            L7b:
                r4 = 0
            L7c:
                if (r4 == 0) goto L81
                W2.E r8 = W2.E.f5463a
                return r8
            L81:
                x3.a r9 = new x3.a
                r9.<init>(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: w3.m.d.emit(java.lang.Object, Z2.e):java.lang.Object");
        }
    }

    public static final w3.d a(w3.d dVar, i3.o oVar) {
        return new a(dVar, oVar);
    }

    public static final w3.d b(w3.d dVar, i3.o oVar) {
        return new c(dVar, oVar);
    }
}
