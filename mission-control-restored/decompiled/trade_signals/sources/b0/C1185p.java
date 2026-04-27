package b0;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2707e;
import u5.AbstractC2777d;

/* JADX INFO: renamed from: b0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1185p implements K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f12785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final E f12786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f12787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0 f12788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f12789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h7.a f12790f;

    /* JADX INFO: renamed from: b0.p$a */
    public static final class a extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f12791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f12792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f12794d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12796f;

        public a(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f12794d = obj;
            this.f12796f |= Integer.MIN_VALUE;
            return C1185p.this.e(null, this);
        }
    }

    /* JADX INFO: renamed from: b0.p$b */
    public static final class b extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f12797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f12798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f12799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f12800d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f12801e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12803g;

        public b(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f12801e = obj;
            this.f12803g |= Integer.MIN_VALUE;
            return C1185p.this.a(null, this);
        }
    }

    public C1185p(File file, E serializer, t coordinator, Function0 onClose) {
        AbstractC2304t.f(file, "file");
        AbstractC2304t.f(serializer, "serializer");
        AbstractC2304t.f(coordinator, "coordinator");
        AbstractC2304t.f(onClose, "onClose");
        this.f12785a = file;
        this.f12786b = serializer;
        this.f12787c = coordinator;
        this.f12788d = onClose;
        this.f12789e = new AtomicBoolean(false);
        this.f12790f = h7.g.b(false, 1, null);
    }

    private final void f() {
        if (!(!this.f12789e.get())) {
            throw new IllegalStateException("StorageConnection has already been disposed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb A[Catch: all -> 0x00f0, IOException -> 0x00f2, TRY_ENTER, TryCatch #0 {all -> 0x00f0, blocks: (B:35:0x00bb, B:37:0x00c1, B:40:0x00ca, B:41:0x00ef, B:46:0x00f5, B:49:0x00fd, B:58:0x010c, B:60:0x0112, B:61:0x0115, B:56:0x010a, B:55:0x0107, B:24:0x007a, B:25:0x0096), top: B:64:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd A[Catch: all -> 0x00f0, IOException -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:35:0x00bb, B:37:0x00c1, B:40:0x00ca, B:41:0x00ef, B:46:0x00f5, B:49:0x00fd, B:58:0x010c, B:60:0x0112, B:61:0x0115, B:56:0x010a, B:55:0x0107, B:24:0x007a, B:25:0x0096), top: B:64:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [h7.a, int] */
    @Override // b0.K
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(B5.o r10, s5.InterfaceC2707e r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.C1185p.a(B5.o, s5.e):java.lang.Object");
    }

    @Override // b0.K
    public t c() {
        return this.f12787c;
    }

    @Override // b0.InterfaceC1172c
    public void close() {
        this.f12789e.set(true);
        this.f12788d.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b A[Catch: all -> 0x007c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x007c, blocks: (B:31:0x007b, B:40:0x008c, B:39:0x0089, B:36:0x0084), top: B:52:0x0022, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v11, types: [b0.p] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2, types: [b0.p$a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [b0.p] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [b0.p] */
    /* JADX WARN: Type inference failed for: r9v0, types: [B5.p] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // b0.K
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(B5.p r9, s5.InterfaceC2707e r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof b0.C1185p.a
            if (r0 == 0) goto L13
            r0 = r10
            b0.p$a r0 = (b0.C1185p.a) r0
            int r1 = r0.f12796f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12796f = r1
            goto L18
        L13:
            b0.p$a r0 = new b0.p$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f12794d
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f12796f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            boolean r9 = r0.f12793c
            java.lang.Object r1 = r0.f12792b
            b0.c r1 = (b0.InterfaceC1172c) r1
            java.lang.Object r0 = r0.f12791a
            b0.p r0 = (b0.C1185p) r0
            o5.AbstractC2491s.b(r10)     // Catch: java.lang.Throwable -> L34
            goto L6b
        L34:
            r10 = move-exception
            goto L84
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            o5.AbstractC2491s.b(r10)
            r8.f()
            h7.a r10 = r8.f12790f
            boolean r10 = h7.a.C0316a.a(r10, r4, r3, r4)
            b0.n r2 = new b0.n     // Catch: java.lang.Throwable -> L8d
            java.io.File r5 = r8.f12785a     // Catch: java.lang.Throwable -> L8d
            b0.E r6 = r8.f12786b     // Catch: java.lang.Throwable -> L8d
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L8d
            java.lang.Boolean r5 = u5.AbstractC2775b.a(r10)     // Catch: java.lang.Throwable -> L7e
            r0.f12791a = r8     // Catch: java.lang.Throwable -> L7e
            r0.f12792b = r2     // Catch: java.lang.Throwable -> L7e
            r0.f12793c = r10     // Catch: java.lang.Throwable -> L7e
            r0.f12796f = r3     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r9 = r9.invoke(r2, r5, r0)     // Catch: java.lang.Throwable -> L7e
            if (r9 != r1) goto L66
            return r1
        L66:
            r0 = r8
            r1 = r2
            r7 = r10
            r10 = r9
            r9 = r7
        L6b:
            r1.close()     // Catch: java.lang.Throwable -> L70
            r1 = r4
            goto L71
        L70:
            r1 = move-exception
        L71:
            if (r1 != 0) goto L7b
            if (r9 == 0) goto L7a
            h7.a r9 = r0.f12790f
            h7.a.C0316a.b(r9, r4, r3, r4)
        L7a:
            return r10
        L7b:
            throw r1     // Catch: java.lang.Throwable -> L7c
        L7c:
            r10 = move-exception
            goto L92
        L7e:
            r9 = move-exception
            r0 = r8
            r1 = r2
            r7 = r10
            r10 = r9
            r9 = r7
        L84:
            r1.close()     // Catch: java.lang.Throwable -> L88
            goto L8c
        L88:
            r1 = move-exception
            o5.AbstractC2477e.a(r10, r1)     // Catch: java.lang.Throwable -> L7c
        L8c:
            throw r10     // Catch: java.lang.Throwable -> L7c
        L8d:
            r9 = move-exception
            r0 = r8
            r7 = r10
            r10 = r9
            r9 = r7
        L92:
            if (r9 == 0) goto L99
            h7.a r9 = r0.f12790f
            h7.a.C0316a.b(r9, r4, r3, r4)
        L99:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.C1185p.e(B5.p, s5.e):java.lang.Object");
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
