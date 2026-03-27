package w3;

import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: w3.a$a, reason: collision with other inner class name */
    public static final class C0253a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f15584b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15586d;

        public C0253a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f15584b = obj;
            this.f15586d |= Integer.MIN_VALUE;
            return a.this.collect(null, this);
        }
    }

    public abstract Object c(e eVar, Z2.e eVar2);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // w3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(w3.e r6, Z2.e r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof w3.a.C0253a
            if (r0 == 0) goto L13
            r0 = r7
            w3.a$a r0 = (w3.a.C0253a) r0
            int r1 = r0.f15586d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15586d = r1
            goto L18
        L13:
            w3.a$a r0 = new w3.a$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f15584b
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f15586d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.f15583a
            x3.n r6 = (x3.n) r6
            W2.q.b(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r7 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            W2.q.b(r7)
            x3.n r7 = new x3.n
            Z2.i r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f15583a = r7     // Catch: java.lang.Throwable -> L55
            r0.f15586d = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.c(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            W2.E r6 = W2.E.f5463a
            return r6
        L55:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L59:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.a.collect(w3.e, Z2.e):java.lang.Object");
    }
}
