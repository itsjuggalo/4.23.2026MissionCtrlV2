package d0;

import b0.InterfaceC1169C;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2707e;
import u5.AbstractC2777d;
import u7.AbstractC2817j;
import u7.M;

/* JADX INFO: renamed from: d0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1610b implements InterfaceC1169C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2817j f16697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final M f16698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f16699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1609a f16700d;

    /* JADX INFO: renamed from: d0.b$a */
    public static final class a extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f16701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f16702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f16703c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f16705e;

        public a(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f16703c = obj;
            this.f16705e |= Integer.MIN_VALUE;
            return C1610b.j(C1610b.this, this);
        }
    }

    public C1610b(AbstractC2817j fileSystem, M path, c serializer) {
        AbstractC2304t.f(fileSystem, "fileSystem");
        AbstractC2304t.f(path, "path");
        AbstractC2304t.f(serializer, "serializer");
        this.f16697a = fileSystem;
        this.f16698b = path;
        this.f16699c = serializer;
        this.f16700d = new C1609a(false);
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
    public static /* synthetic */ java.lang.Object j(d0.C1610b r7, s5.InterfaceC2707e r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.C1610b.j(d0.b, s5.e):java.lang.Object");
    }

    @Override // b0.InterfaceC1169C
    public Object b(InterfaceC2707e interfaceC2707e) {
        return j(this, interfaceC2707e);
    }

    @Override // b0.InterfaceC1172c
    public void close() {
        this.f16700d.b(true);
    }

    public final void f() {
        if (!(!this.f16700d.a())) {
            throw new IllegalStateException("This scope has already been closed.".toString());
        }
    }

    public final AbstractC2817j g() {
        return this.f16697a;
    }

    public final M h() {
        return this.f16698b;
    }

    public final c i() {
        return this.f16699c;
    }
}
