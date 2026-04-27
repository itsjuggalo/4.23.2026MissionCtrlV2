package S;

import b3.AbstractC0866d;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class n implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f3778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A f3779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f3780c;

    public static final class a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f3783c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3785e;

        public a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3783c = obj;
            this.f3785e |= Integer.MIN_VALUE;
            return n.i(n.this, this);
        }
    }

    public n(File file, A serializer) {
        kotlin.jvm.internal.r.f(file, "file");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        this.f3778a = file;
        this.f3779b = serializer;
        this.f3780c = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [S.n] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [S.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [S.n] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object i(S.n r7, Z2.e r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof S.n.a
            if (r0 == 0) goto L13
            r0 = r8
            S.n$a r0 = (S.n.a) r0
            int r1 = r0.f3785e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3785e = r1
            goto L18
        L13:
            S.n$a r0 = new S.n$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f3783c
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f3785e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.f3781a
            java.io.Closeable r7 = (java.io.Closeable) r7
            W2.q.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L9d
        L32:
            r8 = move-exception
            goto La5
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            java.lang.Object r7 = r0.f3782b
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r2 = r0.f3781a
            S.n r2 = (S.n) r2
            W2.q.b(r8)     // Catch: java.lang.Throwable -> L49
            goto L6b
        L49:
            r8 = move-exception
            goto L76
        L4b:
            W2.q.b(r8)
            r7.f()
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L7c
            java.io.File r2 = r7.f3778a     // Catch: java.io.FileNotFoundException -> L7c
            r8.<init>(r2)     // Catch: java.io.FileNotFoundException -> L7c
            S.A r2 = r7.f3779b     // Catch: java.lang.Throwable -> L71
            r0.f3781a = r7     // Catch: java.lang.Throwable -> L71
            r0.f3782b = r8     // Catch: java.lang.Throwable -> L71
            r0.f3785e = r4     // Catch: java.lang.Throwable -> L71
            java.lang.Object r2 = r2.b(r8, r0)     // Catch: java.lang.Throwable -> L71
            if (r2 != r1) goto L67
            goto L99
        L67:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L6b:
            g3.b.a(r7, r5)     // Catch: java.io.FileNotFoundException -> L6f
            return r8
        L6f:
            r7 = r2
            goto L7c
        L71:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L76:
            throw r8     // Catch: java.lang.Throwable -> L77
        L77:
            r4 = move-exception
            g3.b.a(r7, r8)     // Catch: java.io.FileNotFoundException -> L6f
            throw r4     // Catch: java.io.FileNotFoundException -> L6f
        L7c:
            java.io.File r8 = r7.f3778a
            boolean r8 = r8.exists()
            if (r8 == 0) goto Lab
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r2 = r7.f3778a
            r8.<init>(r2)
            S.A r7 = r7.f3779b     // Catch: java.lang.Throwable -> La1
            r0.f3781a = r8     // Catch: java.lang.Throwable -> La1
            r0.f3782b = r5     // Catch: java.lang.Throwable -> La1
            r0.f3785e = r3     // Catch: java.lang.Throwable -> La1
            java.lang.Object r7 = r7.b(r8, r0)     // Catch: java.lang.Throwable -> La1
            if (r7 != r1) goto L9a
        L99:
            return r1
        L9a:
            r6 = r8
            r8 = r7
            r7 = r6
        L9d:
            g3.b.a(r7, r5)
            return r8
        La1:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        La5:
            throw r8     // Catch: java.lang.Throwable -> La6
        La6:
            r0 = move-exception
            g3.b.a(r7, r8)
            throw r0
        Lab:
            S.A r7 = r7.f3779b
            java.lang.Object r7 = r7.a()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: S.n.i(S.n, Z2.e):java.lang.Object");
    }

    @Override // S.InterfaceC0517c
    public void close() {
        this.f3780c.set(true);
    }

    @Override // S.y
    public Object e(Z2.e eVar) {
        return i(this, eVar);
    }

    public final void f() {
        if (this.f3780c.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    public final File g() {
        return this.f3778a;
    }

    public final A h() {
        return this.f3779b;
    }
}
