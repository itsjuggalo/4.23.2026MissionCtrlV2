package l1;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends n implements p0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f15255c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15257e;

        public a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f15255c = obj;
            this.f15257e |= Integer.MIN_VALUE;
            return q.this.c(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(File file, e0 serializer) {
        super(file, serializer);
        kotlin.jvm.internal.t.f(file, "file");
        kotlin.jvm.internal.t.f(serializer, "serializer");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // l1.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.Object r6, gd.e r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof l1.q.a
            if (r0 == 0) goto L13
            r0 = r7
            l1.q$a r0 = (l1.q.a) r0
            int r1 = r0.f15257e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15257e = r1
            goto L18
        L13:
            l1.q$a r0 = new l1.q$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f15255c
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f15257e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.f15254b
            java.io.FileOutputStream r6 = (java.io.FileOutputStream) r6
            java.lang.Object r0 = r0.f15253a
            java.io.Closeable r0 = (java.io.Closeable) r0
            cd.s.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L62
        L31:
            r6 = move-exception
            goto L74
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            cd.s.b(r7)
            r5.f()
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r2 = r5.g()
            r7.<init>(r2)
            l1.e0 r2 = r5.h()     // Catch: java.lang.Throwable -> L72
            l1.n0 r4 = new l1.n0     // Catch: java.lang.Throwable -> L72
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L72
            r0.f15253a = r7     // Catch: java.lang.Throwable -> L72
            r0.f15254b = r7     // Catch: java.lang.Throwable -> L72
            r0.f15257e = r3     // Catch: java.lang.Throwable -> L72
            java.lang.Object r6 = r2.c(r6, r4, r0)     // Catch: java.lang.Throwable -> L72
            if (r6 != r1) goto L60
            return r1
        L60:
            r6 = r7
            r0 = r6
        L62:
            java.io.FileDescriptor r6 = r6.getFD()     // Catch: java.lang.Throwable -> L31
            r6.sync()     // Catch: java.lang.Throwable -> L31
            cd.h0 r6 = cd.h0.f3852a     // Catch: java.lang.Throwable -> L31
            r6 = 0
            nd.b.a(r0, r6)
            cd.h0 r6 = cd.h0.f3852a
            return r6
        L72:
            r6 = move-exception
            r0 = r7
        L74:
            throw r6     // Catch: java.lang.Throwable -> L75
        L75:
            r7 = move-exception
            nd.b.a(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.q.c(java.lang.Object, gd.e):java.lang.Object");
    }
}
