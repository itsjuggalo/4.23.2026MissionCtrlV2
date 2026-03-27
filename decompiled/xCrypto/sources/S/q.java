package S;

import b3.AbstractC0866d;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class q extends n implements K {

    public static final class a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f3815c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3817e;

        public a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3815c = obj;
            this.f3817e |= Integer.MIN_VALUE;
            return q.this.d(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(File file, A serializer) {
        super(file, serializer);
        kotlin.jvm.internal.r.f(file, "file");
        kotlin.jvm.internal.r.f(serializer, "serializer");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // S.K
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.lang.Object r6, Z2.e r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof S.q.a
            if (r0 == 0) goto L13
            r0 = r7
            S.q$a r0 = (S.q.a) r0
            int r1 = r0.f3817e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3817e = r1
            goto L18
        L13:
            S.q$a r0 = new S.q$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f3815c
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f3817e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.f3814b
            java.io.FileOutputStream r6 = (java.io.FileOutputStream) r6
            java.lang.Object r0 = r0.f3813a
            java.io.Closeable r0 = (java.io.Closeable) r0
            W2.q.b(r7)     // Catch: java.lang.Throwable -> L31
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
            W2.q.b(r7)
            r5.f()
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r2 = r5.g()
            r7.<init>(r2)
            S.A r2 = r5.h()     // Catch: java.lang.Throwable -> L72
            S.I r4 = new S.I     // Catch: java.lang.Throwable -> L72
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L72
            r0.f3813a = r7     // Catch: java.lang.Throwable -> L72
            r0.f3814b = r7     // Catch: java.lang.Throwable -> L72
            r0.f3817e = r3     // Catch: java.lang.Throwable -> L72
            java.lang.Object r6 = r2.c(r6, r4, r0)     // Catch: java.lang.Throwable -> L72
            if (r6 != r1) goto L60
            return r1
        L60:
            r6 = r7
            r0 = r6
        L62:
            java.io.FileDescriptor r6 = r6.getFD()     // Catch: java.lang.Throwable -> L31
            r6.sync()     // Catch: java.lang.Throwable -> L31
            W2.E r6 = W2.E.f5463a     // Catch: java.lang.Throwable -> L31
            r6 = 0
            g3.b.a(r0, r6)
            W2.E r6 = W2.E.f5463a
            return r6
        L72:
            r6 = move-exception
            r0 = r7
        L74:
            throw r6     // Catch: java.lang.Throwable -> L75
        L75:
            r7 = move-exception
            g3.b.a(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: S.q.d(java.lang.Object, Z2.e):java.lang.Object");
    }
}
