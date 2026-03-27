package e0;

import c0.r;
import w6.AbstractC2798k;
import w6.Q;

/* JADX INFO: loaded from: classes.dex */
public class b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2798k f13513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q f13514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f13515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1468a f13516d;

    public static final class a extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f13518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f13519c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13521e;

        public a(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f13519c = obj;
            this.f13521e |= Integer.MIN_VALUE;
            return b.j(b.this, this);
        }
    }

    public b(AbstractC2798k fileSystem, Q path, c serializer) {
        kotlin.jvm.internal.r.f(fileSystem, "fileSystem");
        kotlin.jvm.internal.r.f(path, "path");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        this.f13513a = fileSystem;
        this.f13514b = path;
        this.f13515c = serializer;
        this.f13516d = new C1468a(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0090 A[Catch: FileNotFoundException -> 0x008a, TryCatch #8 {FileNotFoundException -> 0x008a, blocks: (B:46:0x0090, B:47:0x0094, B:42:0x0086, B:39:0x0081), top: B:82:0x0081, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094 A[Catch: FileNotFoundException -> 0x008a, TRY_LEAVE, TryCatch #8 {FileNotFoundException -> 0x008a, blocks: (B:46:0x0090, B:47:0x0094, B:42:0x0086, B:39:0x0081), top: B:82:0x0081, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object j(e0.b r7, H5.d r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.b.j(e0.b, H5.d):java.lang.Object");
    }

    @Override // c0.r
    public Object a(H5.d dVar) {
        return j(this, dVar);
    }

    @Override // c0.InterfaceC1113b
    public void close() {
        this.f13516d.b(true);
    }

    public final void f() {
        if (this.f13516d.a()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    public final AbstractC2798k g() {
        return this.f13513a;
    }

    public final Q h() {
        return this.f13514b;
    }

    public final c i() {
        return this.f13515c;
    }
}
