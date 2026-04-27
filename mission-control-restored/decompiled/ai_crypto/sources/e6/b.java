package e6;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Q5.o f13893e;

    public static final class a extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13895b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13897d;

        public a(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f13895b = obj;
            this.f13897d |= Integer.MIN_VALUE;
            return b.this.f(null, this);
        }
    }

    public /* synthetic */ b(Q5.o oVar, H5.g gVar, int i7, d6.a aVar, int i8, AbstractC2148j abstractC2148j) {
        this(oVar, (i8 & 2) != 0 ? H5.h.f2671a : gVar, (i8 & 4) != 0 ? -2 : i7, (i8 & 8) != 0 ? d6.a.SUSPEND : aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // e6.c, f6.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(d6.r r5, H5.d r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof e6.b.a
            if (r0 == 0) goto L13
            r0 = r6
            e6.b$a r0 = (e6.b.a) r0
            int r1 = r0.f13897d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13897d = r1
            goto L18
        L13:
            e6.b$a r0 = new e6.b$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f13895b
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f13897d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f13894a
            d6.r r5 = (d6.r) r5
            E5.q.b(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            E5.q.b(r6)
            r0.f13894a = r5
            r0.f13897d = r3
            java.lang.Object r6 = super.f(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            boolean r5 = r5.m()
            if (r5 == 0) goto L4c
            E5.E r5 = E5.E.f1657a
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.b.f(d6.r, H5.d):java.lang.Object");
    }

    @Override // f6.e
    public f6.e g(H5.g gVar, int i7, d6.a aVar) {
        return new b(this.f13893e, gVar, i7, aVar);
    }

    public b(Q5.o oVar, H5.g gVar, int i7, d6.a aVar) {
        super(oVar, gVar, i7, aVar);
        this.f13893e = oVar;
    }
}
