package fe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f9469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f9470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final yf.g f9471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wf.i f9472d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f9468f = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(e1.class, "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f9467e = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final e1 a(e classDescriptor, wf.n storageManager, yf.g kotlinTypeRefinerForOwnerModule, pd.k scopeFactory) {
            kotlin.jvm.internal.t.f(classDescriptor, "classDescriptor");
            kotlin.jvm.internal.t.f(storageManager, "storageManager");
            kotlin.jvm.internal.t.f(kotlinTypeRefinerForOwnerModule, "kotlinTypeRefinerForOwnerModule");
            kotlin.jvm.internal.t.f(scopeFactory, "scopeFactory");
            return new e1(classDescriptor, storageManager, scopeFactory, kotlinTypeRefinerForOwnerModule, null);
        }

        public a() {
        }
    }

    public /* synthetic */ e1(e eVar, wf.n nVar, pd.k kVar, yf.g gVar, kotlin.jvm.internal.k kVar2) {
        this(eVar, nVar, kVar, gVar);
    }

    public static final qf.k d(e1 e1Var, yf.g gVar) {
        return (qf.k) e1Var.f9470b.invoke(gVar);
    }

    public static final qf.k f(e1 e1Var) {
        return (qf.k) e1Var.f9470b.invoke(e1Var.f9471c);
    }

    public final qf.k c(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.d(nf.e.s(this.f9469a))) {
            return e();
        }
        xf.u1 u1VarK = this.f9469a.k();
        kotlin.jvm.internal.t.e(u1VarK, "getTypeConstructor(...)");
        return !kotlinTypeRefiner.e(u1VarK) ? e() : kotlinTypeRefiner.c(this.f9469a, new d1(this, kotlinTypeRefiner));
    }

    public final qf.k e() {
        return (qf.k) wf.m.a(this.f9472d, this, f9468f[0]);
    }

    public e1(e eVar, wf.n nVar, pd.k kVar, yf.g gVar) {
        this.f9469a = eVar;
        this.f9470b = kVar;
        this.f9471c = gVar;
        this.f9472d = nVar.e(new c1(this));
    }
}
