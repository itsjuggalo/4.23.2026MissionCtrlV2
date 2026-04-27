package e6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: e6.a$a, reason: collision with other inner class name */
    public static final class C0238a extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13890b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13892d;

        public C0238a(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f13890b = obj;
            this.f13892d |= Integer.MIN_VALUE;
            return a.this.b(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // e6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(e6.e r6, H5.d r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof e6.a.C0238a
            if (r0 == 0) goto L13
            r0 = r7
            e6.a$a r0 = (e6.a.C0238a) r0
            int r1 = r0.f13892d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13892d = r1
            goto L18
        L13:
            e6.a$a r0 = new e6.a$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f13890b
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f13892d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.f13889a
            f6.n r6 = (f6.n) r6
            E5.q.b(r7)     // Catch: java.lang.Throwable -> L2d
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
            E5.q.b(r7)
            f6.n r7 = new f6.n
            H5.g r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f13889a = r7     // Catch: java.lang.Throwable -> L55
            r0.f13892d = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.d(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            E5.E r6 = E5.E.f1657a
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
        throw new UnsupportedOperationException("Method not decompiled: e6.a.b(e6.e, H5.d):java.lang.Object");
    }

    public abstract Object d(e eVar, H5.d dVar);
}
