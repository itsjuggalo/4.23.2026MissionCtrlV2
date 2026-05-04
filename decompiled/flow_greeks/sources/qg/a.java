package qg;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: qg.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0331a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f19109b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19111d;

        public C0331a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f19109b = obj;
            this.f19111d |= Integer.MIN_VALUE;
            return a.this.collect(null, this);
        }
    }

    public abstract Object c(e eVar, gd.e eVar2);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // qg.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(qg.e r6, gd.e r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof qg.a.C0331a
            if (r0 == 0) goto L13
            r0 = r7
            qg.a$a r0 = (qg.a.C0331a) r0
            int r1 = r0.f19111d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f19111d = r1
            goto L18
        L13:
            qg.a$a r0 = new qg.a$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f19109b
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f19111d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.f19108a
            rg.o r6 = (rg.o) r6
            cd.s.b(r7)     // Catch: java.lang.Throwable -> L2d
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
            cd.s.b(r7)
            rg.o r7 = new rg.o
            gd.i r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f19108a = r7     // Catch: java.lang.Throwable -> L55
            r0.f19111d = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.c(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            cd.h0 r6 = cd.h0.f3852a
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
        throw new UnsupportedOperationException("Method not decompiled: qg.a.collect(qg.e, gd.e):java.lang.Object");
    }
}
