package c0;

import E5.E;
import b6.AbstractC1106z;
import b6.InterfaceC1102x;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k6.a f9293a = k6.c.b(false, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1102x f9294b = AbstractC1106z.b(null, 1, null);

    public static final class a extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f9295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f9296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f9297c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9299e;

        public a(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f9297c = obj;
            this.f9299e |= Integer.MIN_VALUE;
            return s.this.c(this);
        }
    }

    public final Object a(H5.d dVar) {
        Object objAwait = this.f9294b.await(dVar);
        return objAwait == I5.c.e() ? objAwait : E.f1657a;
    }

    public abstract Object b(H5.d dVar);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(H5.d r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof c0.s.a
            if (r0 == 0) goto L13
            r0 = r7
            c0.s$a r0 = (c0.s.a) r0
            int r1 = r0.f9299e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9299e = r1
            goto L18
        L13:
            c0.s$a r0 = new c0.s$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f9297c
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f9299e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r1 = r0.f9296b
            k6.a r1 = (k6.a) r1
            java.lang.Object r0 = r0.f9295a
            c0.s r0 = (c0.s) r0
            E5.q.b(r7)     // Catch: java.lang.Throwable -> L35
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
            java.lang.Object r2 = r0.f9296b
            k6.a r2 = (k6.a) r2
            java.lang.Object r4 = r0.f9295a
            c0.s r4 = (c0.s) r4
            E5.q.b(r7)
            r7 = r2
            goto L6a
        L4c:
            E5.q.b(r7)
            b6.x r7 = r6.f9294b
            boolean r7 = r7.isCompleted()
            if (r7 == 0) goto L5a
            E5.E r7 = E5.E.f1657a
            return r7
        L5a:
            k6.a r7 = r6.f9293a
            r0.f9295a = r6
            r0.f9296b = r7
            r0.f9299e = r4
            java.lang.Object r2 = r7.d(r5, r0)
            if (r2 != r1) goto L69
            return r1
        L69:
            r4 = r6
        L6a:
            b6.x r2 = r4.f9294b     // Catch: java.lang.Throwable -> L78
            boolean r2 = r2.isCompleted()     // Catch: java.lang.Throwable -> L78
            if (r2 == 0) goto L7c
            E5.E r0 = E5.E.f1657a     // Catch: java.lang.Throwable -> L78
            r7.c(r5)
            return r0
        L78:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto L96
        L7c:
            r0.f9295a = r4     // Catch: java.lang.Throwable -> L78
            r0.f9296b = r7     // Catch: java.lang.Throwable -> L78
            r0.f9299e = r3     // Catch: java.lang.Throwable -> L78
            java.lang.Object r0 = r4.b(r0)     // Catch: java.lang.Throwable -> L78
            if (r0 != r1) goto L89
            return r1
        L89:
            r1 = r7
            r0 = r4
        L8b:
            b6.x r7 = r0.f9294b     // Catch: java.lang.Throwable -> L35
            E5.E r0 = E5.E.f1657a     // Catch: java.lang.Throwable -> L35
            r7.X(r0)     // Catch: java.lang.Throwable -> L35
            r1.c(r5)
            return r0
        L96:
            r1.c(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.s.c(H5.d):java.lang.Object");
    }
}
