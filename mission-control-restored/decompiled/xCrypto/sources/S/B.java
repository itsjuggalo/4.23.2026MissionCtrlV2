package S;

import t3.AbstractC1822k;
import t3.InterfaceC1846w0;
import t3.L;
import v3.h;

/* JADX INFO: loaded from: classes.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L f3570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i3.o f3571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v3.d f3572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0516b f3573d;

    public static final class a extends kotlin.jvm.internal.s implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i3.k f3574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ B f3575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i3.o f3576c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i3.k kVar, B b4, i3.o oVar) {
            super(1);
            this.f3574a = kVar;
            this.f3575b = b4;
            this.f3576c = oVar;
        }

        public final void a(Throwable th) {
            W2.E e4;
            this.f3574a.invoke(th);
            this.f3575b.f3572c.k(th);
            do {
                Object objF = v3.h.f(this.f3575b.f3572c.d());
                if (objF != null) {
                    this.f3576c.invoke(objF, th);
                    e4 = W2.E.f5463a;
                } else {
                    e4 = null;
                }
            } while (e4 != null);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return W2.E.f5463a;
        }
    }

    public static final class b extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3578b;

        public b(Z2.e eVar) {
            super(2, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return B.this.new b(eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
        
            if (r1.invoke(r6, r5) != r0) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[PHI: r1 r6
          0x0051: PHI (r1v1 i3.o) = (r1v2 i3.o), (r1v4 i3.o) binds: [B:13:0x004e, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]
          0x0051: PHI (r6v5 java.lang.Object) = (r6v12 java.lang.Object), (r6v0 java.lang.Object) binds: [B:13:0x004e, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005a -> B:18:0x005d). Please report as a decompilation issue!!! */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = a3.AbstractC0787c.e()
                int r1 = r5.f3578b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                W2.q.b(r6)
                goto L5d
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                java.lang.Object r1 = r5.f3577a
                i3.o r1 = (i3.o) r1
                W2.q.b(r6)
                goto L51
            L22:
                W2.q.b(r6)
                S.B r6 = S.B.this
                S.b r6 = S.B.c(r6)
                int r6 = r6.b()
                if (r6 <= 0) goto L6c
            L31:
                S.B r6 = S.B.this
                t3.L r6 = S.B.d(r6)
                t3.M.f(r6)
                S.B r6 = S.B.this
                i3.o r1 = S.B.a(r6)
                S.B r6 = S.B.this
                v3.d r6 = S.B.b(r6)
                r5.f3577a = r1
                r5.f3578b = r3
                java.lang.Object r6 = r6.c(r5)
                if (r6 != r0) goto L51
                goto L5c
            L51:
                r4 = 0
                r5.f3577a = r4
                r5.f3578b = r2
                java.lang.Object r6 = r1.invoke(r6, r5)
                if (r6 != r0) goto L5d
            L5c:
                return r0
            L5d:
                S.B r6 = S.B.this
                S.b r6 = S.B.c(r6)
                int r6 = r6.a()
                if (r6 != 0) goto L31
                W2.E r6 = W2.E.f5463a
                return r6
            L6c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "Check failed."
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: S.B.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((b) create(l4, eVar)).invokeSuspend(W2.E.f5463a);
        }
    }

    public B(L scope, i3.k onComplete, i3.o onUndeliveredElement, i3.o consumeMessage) {
        kotlin.jvm.internal.r.f(scope, "scope");
        kotlin.jvm.internal.r.f(onComplete, "onComplete");
        kotlin.jvm.internal.r.f(onUndeliveredElement, "onUndeliveredElement");
        kotlin.jvm.internal.r.f(consumeMessage, "consumeMessage");
        this.f3570a = scope;
        this.f3571b = consumeMessage;
        this.f3572c = v3.g.b(Integer.MAX_VALUE, null, null, 6, null);
        this.f3573d = new C0516b(0);
        InterfaceC1846w0 interfaceC1846w0 = (InterfaceC1846w0) scope.l().get(InterfaceC1846w0.f15039M);
        if (interfaceC1846w0 != null) {
            interfaceC1846w0.invokeOnCompletion(new a(onComplete, this, onUndeliveredElement));
        }
    }

    public final void e(Object obj) throws Throwable {
        Object objM = this.f3572c.m(obj);
        if (objM instanceof h.a) {
            Throwable thE = v3.h.e(objM);
            if (thE != null) {
                throw thE;
            }
            throw new v3.o("Channel was closed normally");
        }
        if (!v3.h.i(objM)) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.f3573d.c() == 0) {
            AbstractC1822k.d(this.f3570a, null, null, new b(null), 3, null);
        }
    }
}
