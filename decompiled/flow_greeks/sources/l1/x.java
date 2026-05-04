package l1;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.functions.Function0;
import l1.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements t {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f15263j = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f15264k = "Resource deadlock would occur";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f15265l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f15266m = 60000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gd.i f15267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f15268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qg.d f15269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f15271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f15272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final wg.a f15273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final cd.k f15274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final cd.k f15275i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: l1.x$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0270a extends id.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f15276a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public long f15277b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f15278c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f15280e;

            public C0270a(gd.e eVar) {
                super(eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) {
                this.f15278c = obj;
                this.f15280e |= Integer.MIN_VALUE;
                return a.this.b(null, this);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007c -> B:27:0x007f). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object b(java.io.FileOutputStream r14, gd.e r15) throws java.lang.Throwable {
            /*
                r13 = this;
                boolean r0 = r15 instanceof l1.x.a.C0270a
                if (r0 == 0) goto L13
                r0 = r15
                l1.x$a$a r0 = (l1.x.a.C0270a) r0
                int r1 = r0.f15280e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15280e = r1
                goto L18
            L13:
                l1.x$a$a r0 = new l1.x$a$a
                r0.<init>(r15)
            L18:
                java.lang.Object r15 = r0.f15278c
                java.lang.Object r1 = hd.c.f()
                int r2 = r0.f15280e
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L39
                if (r2 != r4) goto L31
                long r5 = r0.f15277b
                java.lang.Object r14 = r0.f15276a
                java.io.FileOutputStream r14 = (java.io.FileOutputStream) r14
                cd.s.b(r15)
                r15 = r0
                goto L7f
            L31:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r15)
                throw r14
            L39:
                cd.s.b(r15)
                long r5 = l1.x.i()
                r15 = r0
            L41:
                long r7 = l1.x.k()
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            */
            //  java.lang.String r2 = "lockFileStream.getChanne…LUE, /* shared= */ false)"
            /*
                if (r0 > 0) goto L83
                java.nio.channels.FileChannel r7 = r14.getChannel()     // Catch: java.io.IOException -> L5f
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r12 = 0
                r8 = 0
                java.nio.channels.FileLock r0 = r7.lock(r8, r10, r12)     // Catch: java.io.IOException -> L5f
                kotlin.jvm.internal.t.e(r0, r2)     // Catch: java.io.IOException -> L5f
                return r0
            L5f:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()
                if (r2 == 0) goto L82
                java.lang.String r7 = l1.x.h()
                r8 = 0
                r9 = 0
                boolean r2 = kg.c0.P(r2, r7, r8, r3, r9)
                if (r2 != r4) goto L82
                r15.f15276a = r14
                r15.f15277b = r5
                r15.f15280e = r4
                java.lang.Object r0 = ng.x0.a(r5, r15)
                if (r0 != r1) goto L7f
                return r1
            L7f:
                long r7 = (long) r3
                long r5 = r5 * r7
                goto L41
            L82:
                throw r0
            L83:
                java.nio.channels.FileChannel r7 = r14.getChannel()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r12 = 0
                r8 = 0
                java.nio.channels.FileLock r14 = r7.lock(r8, r10, r12)
                kotlin.jvm.internal.t.e(r14, r2)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: l1.x.a.b(java.io.FileOutputStream, gd.e):java.lang.Object");
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15281a;

        public b(gd.e eVar) {
            super(2, eVar);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return x.this.new b(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            hd.c.f();
            if (this.f15281a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cd.s.b(obj);
            return id.b.c(x.this.r().b());
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, gd.e eVar) {
            return ((b) create(n0Var, eVar)).invokeSuspend(cd.h0.f3852a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15283a;

        public c(gd.e eVar) {
            super(2, eVar);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return x.this.new c(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            hd.c.f();
            if (this.f15283a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cd.s.b(obj);
            return id.b.c(x.this.r().c());
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, gd.e eVar) {
            return ((c) create(n0Var, eVar)).invokeSuspend(cd.h0.f3852a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends kotlin.jvm.internal.v implements Function0 {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends kotlin.jvm.internal.v implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ x f15286a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(x xVar) {
                super(0);
                this.f15286a = xVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() throws IOException {
                x xVar = this.f15286a;
                File fileP = xVar.p(xVar.f15271e);
                this.f15286a.n(fileP);
                return fileP;
            }
        }

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f0 invoke() {
            f0.a aVar = f0.f15010b;
            aVar.d();
            return aVar.a(new a(x.this));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f15289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f15290d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15292f;

        public e(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f15290d = obj;
            this.f15292f |= Integer.MIN_VALUE;
            return x.this.c(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends kotlin.jvm.internal.v implements Function0 {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final File invoke() throws IOException {
            x xVar = x.this;
            File fileP = xVar.p(xVar.f15270d);
            x.this.n(fileP);
            return fileP;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f15296c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15297d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f15298e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f15300g;

        public g(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f15298e = obj;
            this.f15300g |= Integer.MIN_VALUE;
            return x.this.b(null, this);
        }
    }

    public x(gd.i context, File file) {
        kotlin.jvm.internal.t.f(context, "context");
        kotlin.jvm.internal.t.f(file, "file");
        this.f15267a = context;
        this.f15268b = file;
        this.f15269c = a0.f14987c.e(file);
        this.f15270d = ".lock";
        this.f15271e = ".version";
        this.f15272f = "fcntl failed: EAGAIN";
        this.f15273g = wg.g.b(false, 1, null);
        this.f15274h = cd.l.b(new f());
        this.f15275i = cd.l.b(new d());
    }

    @Override // l1.t
    public Object a(gd.e eVar) {
        return this.f15275i.d() ? id.b.c(r().c()) : ng.i.g(this.f15267a, new c(null), eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e6 A[Catch: all -> 0x00ea, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00ea, blocks: (B:59:0x00e6, B:71:0x0101, B:72:0x0104), top: B:91:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0101 A[Catch: all -> 0x00ea, TRY_ENTER, TryCatch #7 {all -> 0x00ea, blocks: (B:59:0x00e6, B:71:0x0101, B:72:0x0104), top: B:91:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0110  */
    /* JADX WARN: Type inference failed for: r2v0, types: [pd.o] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, l1.x$g] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [wg.a] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int, java.io.Closeable] */
    @Override // l1.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(pd.o r19, gd.e r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.x.b(pd.o, gd.e):java.lang.Object");
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb A[Catch: all -> 0x00bf, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00bf, blocks: (B:42:0x00bb, B:56:0x00d9, B:57:0x00dc), top: B:78:0x0024, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d9 A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #7 {all -> 0x00bf, blocks: (B:42:0x00bb, B:56:0x00d9, B:57:0x00dc), top: B:78:0x0024, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10, types: [wg.a] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [wg.a] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.Closeable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [wg.a] */
    @Override // l1.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(pd.k r9, gd.e r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.x.c(pd.k, gd.e):java.lang.Object");
    }

    @Override // l1.t
    public Object d(gd.e eVar) {
        return this.f15275i.d() ? id.b.c(r().b()) : ng.i.g(this.f15267a, new b(null), eVar);
    }

    @Override // l1.t
    public qg.d e() {
        return this.f15269c;
    }

    public final void n(File file) throws IOException {
        o(file);
        if (file.exists()) {
            return;
        }
        file.createNewFile();
    }

    public final void o(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return;
            }
            throw new IOException("Unable to create parent directories of " + file);
        }
    }

    public final File p(String str) {
        return new File(this.f15268b.getAbsolutePath() + str);
    }

    public final File q() {
        return (File) this.f15274h.getValue();
    }

    public final f0 r() {
        return (f0) this.f15275i.getValue();
    }
}
