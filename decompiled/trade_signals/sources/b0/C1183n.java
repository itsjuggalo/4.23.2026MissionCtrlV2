package b0;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2707e;
import u5.AbstractC2777d;

/* JADX INFO: renamed from: b0.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1183n implements InterfaceC1169C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f12769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final E f12770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f12771c;

    /* JADX INFO: renamed from: b0.n$a */
    public static final class a extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f12772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f12773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f12774c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12776e;

        public a(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f12774c = obj;
            this.f12776e |= Integer.MIN_VALUE;
            return C1183n.i(C1183n.this, this);
        }
    }

    public C1183n(File file, E serializer) {
        AbstractC2304t.f(file, "file");
        AbstractC2304t.f(serializer, "serializer");
        this.f12769a = file;
        this.f12770b = serializer;
        this.f12771c = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [b0.n] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [b0.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [b0.n] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object i(b0.C1183n r7, s5.InterfaceC2707e r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof b0.C1183n.a
            if (r0 == 0) goto L13
            r0 = r8
            b0.n$a r0 = (b0.C1183n.a) r0
            int r1 = r0.f12776e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12776e = r1
            goto L18
        L13:
            b0.n$a r0 = new b0.n$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f12774c
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f12776e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.f12772a
            java.io.Closeable r7 = (java.io.Closeable) r7
            o5.AbstractC2491s.b(r8)     // Catch: java.lang.Throwable -> L32
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
            java.lang.Object r7 = r0.f12773b
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r2 = r0.f12772a
            b0.n r2 = (b0.C1183n) r2
            o5.AbstractC2491s.b(r8)     // Catch: java.lang.Throwable -> L49
            goto L6b
        L49:
            r8 = move-exception
            goto L76
        L4b:
            o5.AbstractC2491s.b(r8)
            r7.f()
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L7c
            java.io.File r2 = r7.f12769a     // Catch: java.io.FileNotFoundException -> L7c
            r8.<init>(r2)     // Catch: java.io.FileNotFoundException -> L7c
            b0.E r2 = r7.f12770b     // Catch: java.lang.Throwable -> L71
            r0.f12772a = r7     // Catch: java.lang.Throwable -> L71
            r0.f12773b = r8     // Catch: java.lang.Throwable -> L71
            r0.f12776e = r4     // Catch: java.lang.Throwable -> L71
            java.lang.Object r2 = r2.c(r8, r0)     // Catch: java.lang.Throwable -> L71
            if (r2 != r1) goto L67
            return r1
        L67:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L6b:
            z5.AbstractC3014b.a(r7, r5)     // Catch: java.io.FileNotFoundException -> L6f
            goto Lb1
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
            z5.AbstractC3014b.a(r7, r8)     // Catch: java.io.FileNotFoundException -> L6f
            throw r4     // Catch: java.io.FileNotFoundException -> L6f
        L7c:
            java.io.File r8 = r7.f12769a
            boolean r8 = r8.exists()
            if (r8 == 0) goto Lab
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r2 = r7.f12769a
            r8.<init>(r2)
            b0.E r7 = r7.f12770b     // Catch: java.lang.Throwable -> La1
            r0.f12772a = r8     // Catch: java.lang.Throwable -> La1
            r0.f12773b = r5     // Catch: java.lang.Throwable -> La1
            r0.f12776e = r3     // Catch: java.lang.Throwable -> La1
            java.lang.Object r7 = r7.c(r8, r0)     // Catch: java.lang.Throwable -> La1
            if (r7 != r1) goto L9a
            return r1
        L9a:
            r6 = r8
            r8 = r7
            r7 = r6
        L9d:
            z5.AbstractC3014b.a(r7, r5)
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
            z5.AbstractC3014b.a(r7, r8)
            throw r0
        Lab:
            b0.E r7 = r7.f12770b
            java.lang.Object r8 = r7.a()
        Lb1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.C1183n.i(b0.n, s5.e):java.lang.Object");
    }

    @Override // b0.InterfaceC1169C
    public Object b(InterfaceC2707e interfaceC2707e) {
        return i(this, interfaceC2707e);
    }

    @Override // b0.InterfaceC1172c
    public void close() {
        this.f12771c.set(true);
    }

    public final void f() {
        if (!(!this.f12771c.get())) {
            throw new IllegalStateException("This scope has already been closed.".toString());
        }
    }

    public final File g() {
        return this.f12769a;
    }

    public final E h() {
        return this.f12770b;
    }
}
