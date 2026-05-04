package l1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f15234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f15235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f15236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0 f15237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f15238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final wg.a f15239f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f15242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f15243d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15245f;

        public a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f15243d = obj;
            this.f15245f |= Integer.MIN_VALUE;
            return p.this.b(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f15248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f15249d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f15250e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f15252g;

        public b(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f15250e = obj;
            this.f15252g |= Integer.MIN_VALUE;
            return p.this.e(null, this);
        }
    }

    public p(File file, e0 serializer, t coordinator, Function0 onClose) {
        kotlin.jvm.internal.t.f(file, "file");
        kotlin.jvm.internal.t.f(serializer, "serializer");
        kotlin.jvm.internal.t.f(coordinator, "coordinator");
        kotlin.jvm.internal.t.f(onClose, "onClose");
        this.f15234a = file;
        this.f15235b = serializer;
        this.f15236c = coordinator;
        this.f15237d = onClose;
        this.f15238e = new AtomicBoolean(false);
        this.f15239f = wg.g.b(false, 1, null);
    }

    private final void f() {
        if (this.f15238e.get()) {
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
    /* JADX WARN: Type inference failed for: r0v12, types: [l1.p] */
    /* JADX WARN: Type inference failed for: r0v14, types: [l1.p] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, l1.p$a] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [l1.p] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [pd.p] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // l1.k0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(pd.p r8, gd.e r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof l1.p.a
            if (r0 == 0) goto L13
            r0 = r9
            l1.p$a r0 = (l1.p.a) r0
            int r1 = r0.f15245f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15245f = r1
            goto L18
        L13:
            l1.p$a r0 = new l1.p$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f15243d
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f15245f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            boolean r8 = r0.f15242c
            java.lang.Object r1 = r0.f15241b
            l1.c r1 = (l1.c) r1
            java.lang.Object r0 = r0.f15240a
            l1.p r0 = (l1.p) r0
            cd.s.b(r9)     // Catch: java.lang.Throwable -> L34
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
            cd.s.b(r9)
            r7.f()
            wg.a r9 = r7.f15239f
            boolean r9 = wg.a.C0420a.a(r9, r4, r3, r4)
            l1.n r2 = new l1.n     // Catch: java.lang.Throwable -> L8d
            java.io.File r5 = r7.f15234a     // Catch: java.lang.Throwable -> L8d
            l1.e0 r6 = r7.f15235b     // Catch: java.lang.Throwable -> L8d
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L8d
            java.lang.Boolean r5 = id.b.a(r9)     // Catch: java.lang.Throwable -> L7e
            r0.f15240a = r7     // Catch: java.lang.Throwable -> L7e
            r0.f15241b = r2     // Catch: java.lang.Throwable -> L7e
            r0.f15242c = r9     // Catch: java.lang.Throwable -> L7e
            r0.f15245f = r3     // Catch: java.lang.Throwable -> L7e
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
            wg.a r8 = r0.f15239f
            wg.a.C0420a.b(r8, r4, r3, r4)
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
            cd.e.a(r9, r1)     // Catch: java.lang.Throwable -> L7c
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
            wg.a r8 = r0.f15239f
            wg.a.C0420a.b(r8, r4, r3, r4)
        L99:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.p.b(pd.p, gd.e):java.lang.Object");
    }

    @Override // l1.c
    public void close() {
        this.f15238e.set(true);
        this.f15237d.invoke();
    }

    @Override // l1.k0
    public t d() {
        return this.f15236c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb A[Catch: all -> 0x00f0, IOException -> 0x00f2, TRY_ENTER, TryCatch #0 {all -> 0x00f0, blocks: (B:35:0x00bb, B:37:0x00c1, B:40:0x00ca, B:41:0x00ef, B:46:0x00f5, B:49:0x00fd, B:58:0x010c, B:60:0x0112, B:61:0x0115, B:56:0x010a, B:55:0x0107, B:24:0x007a, B:25:0x0096), top: B:64:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd A[Catch: all -> 0x00f0, IOException -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:35:0x00bb, B:37:0x00c1, B:40:0x00ca, B:41:0x00ef, B:46:0x00f5, B:49:0x00fd, B:58:0x010c, B:60:0x0112, B:61:0x0115, B:56:0x010a, B:55:0x0107, B:24:0x007a, B:25:0x0096), top: B:64:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int, wg.a] */
    @Override // l1.k0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(pd.o r10, gd.e r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.p.e(pd.o, gd.e):java.lang.Object");
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
