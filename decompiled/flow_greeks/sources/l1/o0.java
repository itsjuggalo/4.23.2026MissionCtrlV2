package l1;

import gd.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 implements i.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f15229c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f15230d = "Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f15231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f15232b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: l1.o0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0269a implements i.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0269a f15233a = new C0269a();
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public o0(o0 o0Var, k instance) {
        kotlin.jvm.internal.t.f(instance, "instance");
        this.f15231a = o0Var;
        this.f15232b = instance;
    }

    public final void a(i candidate) {
        kotlin.jvm.internal.t.f(candidate, "candidate");
        if (this.f15232b == candidate) {
            throw new IllegalStateException(f15230d.toString());
        }
        o0 o0Var = this.f15231a;
        if (o0Var != null) {
            o0Var.a(candidate);
        }
    }

    @Override // gd.i.b, gd.i
    public Object fold(Object obj, pd.o oVar) {
        return i.b.a.a(this, obj, oVar);
    }

    @Override // gd.i.b, gd.i
    public i.b get(i.c cVar) {
        return i.b.a.b(this, cVar);
    }

    @Override // gd.i.b
    public i.c getKey() {
        return a.C0269a.f15233a;
    }

    @Override // gd.i.b, gd.i
    public gd.i minusKey(i.c cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // gd.i
    public gd.i plus(gd.i iVar) {
        return i.b.a.d(this, iVar);
    }
}
