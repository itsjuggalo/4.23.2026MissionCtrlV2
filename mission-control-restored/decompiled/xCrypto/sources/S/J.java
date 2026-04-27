package S;

import Z2.i;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public final class J implements i.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f3600c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f3601d = "Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J f3602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0525k f3603b;

    public static final class a {

        /* JADX INFO: renamed from: S.J$a$a, reason: collision with other inner class name */
        public static final class C0061a implements i.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0061a f3604a = new C0061a();
        }

        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public J(J j4, C0525k instance) {
        kotlin.jvm.internal.r.f(instance, "instance");
        this.f3602a = j4;
        this.f3603b = instance;
    }

    public final void a(InterfaceC0523i candidate) {
        kotlin.jvm.internal.r.f(candidate, "candidate");
        if (this.f3603b == candidate) {
            throw new IllegalStateException(f3601d.toString());
        }
        J j4 = this.f3602a;
        if (j4 != null) {
            j4.a(candidate);
        }
    }

    @Override // Z2.i.b, Z2.i
    public Object fold(Object obj, i3.o oVar) {
        return i.b.a.a(this, obj, oVar);
    }

    @Override // Z2.i.b, Z2.i
    public i.b get(i.c cVar) {
        return i.b.a.b(this, cVar);
    }

    @Override // Z2.i.b
    public i.c getKey() {
        return a.C0061a.f3604a;
    }

    @Override // Z2.i.b, Z2.i
    public Z2.i minusKey(i.c cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // Z2.i
    public Z2.i plus(Z2.i iVar) {
        return i.b.a.d(this, iVar);
    }
}
