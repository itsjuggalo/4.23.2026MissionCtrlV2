package l1;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f15212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f15213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f15214c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f15217c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15219e;

        public a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f15217c = obj;
            this.f15219e |= Integer.MIN_VALUE;
            return n.i(n.this, this);
        }
    }

    public n(File file, e0 serializer) {
        kotlin.jvm.internal.t.f(file, "file");
        kotlin.jvm.internal.t.f(serializer, "serializer");
        this.f15212a = file;
        this.f15213b = serializer;
        this.f15214c = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [l1.n] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, l1.n] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [l1.n] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object i(l1.n r7, gd.e r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof l1.n.a
            if (r0 == 0) goto L13
            r0 = r8
            l1.n$a r0 = (l1.n.a) r0
            int r1 = r0.f15219e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15219e = r1
            goto L18
        L13:
            l1.n$a r0 = new l1.n$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f15217c
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f15219e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.f15215a
            java.io.Closeable r7 = (java.io.Closeable) r7
            cd.s.b(r8)     // Catch: java.lang.Throwable -> L32
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
            java.lang.Object r7 = r0.f15216b
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r2 = r0.f15215a
            l1.n r2 = (l1.n) r2
            cd.s.b(r8)     // Catch: java.lang.Throwable -> L49
            goto L6b
        L49:
            r8 = move-exception
            goto L76
        L4b:
            cd.s.b(r8)
            r7.f()
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L7c
            java.io.File r2 = r7.f15212a     // Catch: java.io.FileNotFoundException -> L7c
            r8.<init>(r2)     // Catch: java.io.FileNotFoundException -> L7c
            l1.e0 r2 = r7.f15213b     // Catch: java.lang.Throwable -> L71
            r0.f15215a = r7     // Catch: java.lang.Throwable -> L71
            r0.f15216b = r8     // Catch: java.lang.Throwable -> L71
            r0.f15219e = r4     // Catch: java.lang.Throwable -> L71
            java.lang.Object r2 = r2.a(r8, r0)     // Catch: java.lang.Throwable -> L71
            if (r2 != r1) goto L67
            goto L99
        L67:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L6b:
            nd.b.a(r7, r5)     // Catch: java.io.FileNotFoundException -> L6f
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
            nd.b.a(r7, r8)     // Catch: java.io.FileNotFoundException -> L6f
            throw r4     // Catch: java.io.FileNotFoundException -> L6f
        L7c:
            java.io.File r8 = r7.f15212a
            boolean r8 = r8.exists()
            if (r8 == 0) goto Lab
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r2 = r7.f15212a
            r8.<init>(r2)
            l1.e0 r7 = r7.f15213b     // Catch: java.lang.Throwable -> La1
            r0.f15215a = r8     // Catch: java.lang.Throwable -> La1
            r0.f15216b = r5     // Catch: java.lang.Throwable -> La1
            r0.f15219e = r3     // Catch: java.lang.Throwable -> La1
            java.lang.Object r7 = r7.a(r8, r0)     // Catch: java.lang.Throwable -> La1
            if (r7 != r1) goto L9a
        L99:
            return r1
        L9a:
            r6 = r8
            r8 = r7
            r7 = r6
        L9d:
            nd.b.a(r7, r5)
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
            nd.b.a(r7, r8)
            throw r0
        Lab:
            l1.e0 r7 = r7.f15213b
            java.lang.Object r7 = r7.b()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.n.i(l1.n, gd.e):java.lang.Object");
    }

    @Override // l1.c0
    public Object a(gd.e eVar) {
        return i(this, eVar);
    }

    @Override // l1.c
    public void close() {
        this.f15214c.set(true);
    }

    public final void f() {
        if (this.f15214c.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    public final File g() {
        return this.f15212a;
    }

    public final e0 h() {
        return this.f15213b;
    }
}
