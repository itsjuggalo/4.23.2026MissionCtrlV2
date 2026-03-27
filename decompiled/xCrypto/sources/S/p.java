package S;

import b3.AbstractC0866d;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final class p implements F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f3794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A f3795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f3796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0 f3797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f3798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C3.a f3799f;

    public static final class a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f3803d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3805f;

        public a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3803d = obj;
            this.f3805f |= Integer.MIN_VALUE;
            return p.this.a(null, this);
        }
    }

    public static final class b extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f3808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f3809d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f3810e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3812g;

        public b(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3810e = obj;
            this.f3812g |= Integer.MIN_VALUE;
            return p.this.b(null, this);
        }
    }

    public p(File file, A serializer, t coordinator, Function0 onClose) {
        kotlin.jvm.internal.r.f(file, "file");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        kotlin.jvm.internal.r.f(coordinator, "coordinator");
        kotlin.jvm.internal.r.f(onClose, "onClose");
        this.f3794a = file;
        this.f3795b = serializer;
        this.f3796c = coordinator;
        this.f3797d = onClose;
        this.f3798e = new AtomicBoolean(false);
        this.f3799f = C3.c.b(false, 1, null);
    }

    private final void f() {
        if (this.f3798e.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b A[Catch: all -> 0x007c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x007c, blocks: (B:31:0x007b, B:40:0x008c, B:39:0x0089, B:36:0x0084), top: B:52:0x0022, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [S.p] */
    /* JADX WARN: Type inference failed for: r0v14, types: [S.p] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [S.p$a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [S.p] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [i3.p] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // S.F
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(i3.p r8, Z2.e r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof S.p.a
            if (r0 == 0) goto L13
            r0 = r9
            S.p$a r0 = (S.p.a) r0
            int r1 = r0.f3805f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3805f = r1
            goto L18
        L13:
            S.p$a r0 = new S.p$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f3803d
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f3805f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            boolean r8 = r0.f3802c
            java.lang.Object r1 = r0.f3801b
            S.c r1 = (S.InterfaceC0517c) r1
            java.lang.Object r0 = r0.f3800a
            S.p r0 = (S.p) r0
            W2.q.b(r9)     // Catch: java.lang.Throwable -> L34
            goto L6b
        L34:
            r9 = move-exception
            goto L84
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            W2.q.b(r9)
            r7.f()
            C3.a r9 = r7.f3799f
            boolean r9 = C3.a.C0008a.a(r9, r4, r3, r4)
            S.n r2 = new S.n     // Catch: java.lang.Throwable -> L8d
            java.io.File r5 = r7.f3794a     // Catch: java.lang.Throwable -> L8d
            S.A r6 = r7.f3795b     // Catch: java.lang.Throwable -> L8d
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L8d
            java.lang.Boolean r5 = b3.AbstractC0864b.a(r9)     // Catch: java.lang.Throwable -> L7e
            r0.f3800a = r7     // Catch: java.lang.Throwable -> L7e
            r0.f3801b = r2     // Catch: java.lang.Throwable -> L7e
            r0.f3802c = r9     // Catch: java.lang.Throwable -> L7e
            r0.f3805f = r3     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r8 = r8.invoke(r2, r5, r0)     // Catch: java.lang.Throwable -> L7e
            if (r8 != r1) goto L66
            return r1
        L66:
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            r1 = r2
        L6b:
            r1.close()     // Catch: java.lang.Throwable -> L70
            r1 = r4
            goto L71
        L70:
            r1 = move-exception
        L71:
            if (r1 != 0) goto L7b
            if (r8 == 0) goto L7a
            C3.a r8 = r0.f3799f
            C3.a.C0008a.b(r8, r4, r3, r4)
        L7a:
            return r9
        L7b:
            throw r1     // Catch: java.lang.Throwable -> L7c
        L7c:
            r9 = move-exception
            goto L92
        L7e:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            r1 = r2
        L84:
            r1.close()     // Catch: java.lang.Throwable -> L88
            goto L8c
        L88:
            r1 = move-exception
            W2.AbstractC0737e.a(r9, r1)     // Catch: java.lang.Throwable -> L7c
        L8c:
            throw r9     // Catch: java.lang.Throwable -> L7c
        L8d:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
        L92:
            if (r8 == 0) goto L99
            C3.a r8 = r0.f3799f
            C3.a.C0008a.b(r8, r4, r3, r4)
        L99:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: S.p.a(i3.p, Z2.e):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb A[Catch: all -> 0x00f0, IOException -> 0x00f2, TRY_ENTER, TryCatch #0 {all -> 0x00f0, blocks: (B:35:0x00bb, B:37:0x00c1, B:40:0x00ca, B:41:0x00ef, B:46:0x00f5, B:49:0x00fd, B:58:0x010c, B:60:0x0112, B:61:0x0115, B:56:0x010a, B:55:0x0107, B:24:0x007a, B:25:0x0096), top: B:64:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd A[Catch: all -> 0x00f0, IOException -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:35:0x00bb, B:37:0x00c1, B:40:0x00ca, B:41:0x00ef, B:46:0x00f5, B:49:0x00fd, B:58:0x010c, B:60:0x0112, B:61:0x0115, B:56:0x010a, B:55:0x0107, B:24:0x007a, B:25:0x0096), top: B:64:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [C3.a, int] */
    @Override // S.F
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(i3.o r10, Z2.e r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S.p.b(i3.o, Z2.e):java.lang.Object");
    }

    @Override // S.F
    public t c() {
        return this.f3796c;
    }

    @Override // S.InterfaceC0517c
    public void close() {
        this.f3798e.set(true);
        this.f3797d.invoke();
    }

    public final void g(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return;
            }
            throw new IOException("Unable to create parent directories of " + file);
        }
    }
}
