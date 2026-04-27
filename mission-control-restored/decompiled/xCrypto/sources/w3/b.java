package w3;

import b3.AbstractC0866d;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i3.o f15587e;

    public static final class a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f15589b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15591d;

        public a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f15589b = obj;
            this.f15591d |= Integer.MIN_VALUE;
            return b.this.e(null, this);
        }
    }

    public /* synthetic */ b(i3.o oVar, Z2.i iVar, int i4, v3.a aVar, int i5, AbstractC1585j abstractC1585j) {
        this(oVar, (i5 & 2) != 0 ? Z2.j.f6012a : iVar, (i5 & 4) != 0 ? -2 : i4, (i5 & 8) != 0 ? v3.a.SUSPEND : aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // w3.c, x3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(v3.s r5, Z2.e r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof w3.b.a
            if (r0 == 0) goto L13
            r0 = r6
            w3.b$a r0 = (w3.b.a) r0
            int r1 = r0.f15591d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15591d = r1
            goto L18
        L13:
            w3.b$a r0 = new w3.b$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f15589b
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f15591d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f15588a
            v3.s r5 = (v3.s) r5
            W2.q.b(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            W2.q.b(r6)
            r0.f15588a = r5
            r0.f15591d = r3
            java.lang.Object r6 = super.e(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            boolean r5 = r5.n()
            if (r5 == 0) goto L4c
            W2.E r5 = W2.E.f5463a
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.b.e(v3.s, Z2.e):java.lang.Object");
    }

    @Override // x3.e
    public x3.e f(Z2.i iVar, int i4, v3.a aVar) {
        return new b(this.f15587e, iVar, i4, aVar);
    }

    public b(i3.o oVar, Z2.i iVar, int i4, v3.a aVar) {
        super(oVar, iVar, i4, aVar);
        this.f15587e = oVar;
    }
}
