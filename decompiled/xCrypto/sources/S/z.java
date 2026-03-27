package S;

import a3.AbstractC0787c;
import b3.AbstractC0866d;
import t3.AbstractC1851z;
import t3.InterfaceC1847x;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3.a f3824a = C3.c.b(false, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1847x f3825b = AbstractC1851z.b(null, 1, null);

    public static final class a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f3828c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3830e;

        public a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3828c = obj;
            this.f3830e |= Integer.MIN_VALUE;
            return z.this.c(this);
        }
    }

    public final Object a(Z2.e eVar) {
        Object objAwait = this.f3825b.await(eVar);
        return objAwait == AbstractC0787c.e() ? objAwait : W2.E.f5463a;
    }

    public abstract Object b(Z2.e eVar);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(Z2.e r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof S.z.a
            if (r0 == 0) goto L13
            r0 = r7
            S.z$a r0 = (S.z.a) r0
            int r1 = r0.f3830e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3830e = r1
            goto L18
        L13:
            S.z$a r0 = new S.z$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f3828c
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f3830e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r1 = r0.f3827b
            C3.a r1 = (C3.a) r1
            java.lang.Object r0 = r0.f3826a
            S.z r0 = (S.z) r0
            W2.q.b(r7)     // Catch: java.lang.Throwable -> L35
            goto L8b
        L35:
            r7 = move-exception
            goto L96
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3f:
            java.lang.Object r2 = r0.f3827b
            C3.a r2 = (C3.a) r2
            java.lang.Object r4 = r0.f3826a
            S.z r4 = (S.z) r4
            W2.q.b(r7)
            r7 = r2
            goto L6a
        L4c:
            W2.q.b(r7)
            t3.x r7 = r6.f3825b
            boolean r7 = r7.isCompleted()
            if (r7 == 0) goto L5a
            W2.E r7 = W2.E.f5463a
            return r7
        L5a:
            C3.a r7 = r6.f3824a
            r0.f3826a = r6
            r0.f3827b = r7
            r0.f3830e = r4
            java.lang.Object r2 = r7.d(r5, r0)
            if (r2 != r1) goto L69
            goto L88
        L69:
            r4 = r6
        L6a:
            t3.x r2 = r4.f3825b     // Catch: java.lang.Throwable -> L78
            boolean r2 = r2.isCompleted()     // Catch: java.lang.Throwable -> L78
            if (r2 == 0) goto L7c
            W2.E r0 = W2.E.f5463a     // Catch: java.lang.Throwable -> L78
            r7.c(r5)
            return r0
        L78:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto L96
        L7c:
            r0.f3826a = r4     // Catch: java.lang.Throwable -> L78
            r0.f3827b = r7     // Catch: java.lang.Throwable -> L78
            r0.f3830e = r3     // Catch: java.lang.Throwable -> L78
            java.lang.Object r0 = r4.b(r0)     // Catch: java.lang.Throwable -> L78
            if (r0 != r1) goto L89
        L88:
            return r1
        L89:
            r1 = r7
            r0 = r4
        L8b:
            t3.x r7 = r0.f3825b     // Catch: java.lang.Throwable -> L35
            W2.E r0 = W2.E.f5463a     // Catch: java.lang.Throwable -> L35
            r7.K(r0)     // Catch: java.lang.Throwable -> L35
            r1.c(r5)
            return r0
        L96:
            r1.c(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: S.z.c(Z2.e):java.lang.Object");
    }
}
