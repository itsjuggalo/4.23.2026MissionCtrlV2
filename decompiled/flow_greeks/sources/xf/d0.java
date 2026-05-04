package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends d2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f24940e = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d2 f24941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d2 f24942d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final d2 a(d2 first, d2 second) {
            kotlin.jvm.internal.t.f(first, "first");
            kotlin.jvm.internal.t.f(second, "second");
            return first.f() ? second : second.f() ? first : new d0(first, second, null);
        }

        public a() {
        }
    }

    public /* synthetic */ d0(d2 d2Var, d2 d2Var2, kotlin.jvm.internal.k kVar) {
        this(d2Var, d2Var2);
    }

    public static final d2 i(d2 d2Var, d2 d2Var2) {
        return f24940e.a(d2Var, d2Var2);
    }

    @Override // xf.d2
    public boolean a() {
        return this.f24941c.a() || this.f24942d.a();
    }

    @Override // xf.d2
    public boolean b() {
        return this.f24941c.b() || this.f24942d.b();
    }

    @Override // xf.d2
    public ge.h d(ge.h annotations) {
        kotlin.jvm.internal.t.f(annotations, "annotations");
        return this.f24942d.d(this.f24941c.d(annotations));
    }

    @Override // xf.d2
    public a2 e(r0 key) {
        kotlin.jvm.internal.t.f(key, "key");
        a2 a2VarE = this.f24941c.e(key);
        return a2VarE == null ? this.f24942d.e(key) : a2VarE;
    }

    @Override // xf.d2
    public boolean f() {
        return false;
    }

    @Override // xf.d2
    public r0 g(r0 topLevelType, m2 position) {
        kotlin.jvm.internal.t.f(topLevelType, "topLevelType");
        kotlin.jvm.internal.t.f(position, "position");
        return this.f24942d.g(this.f24941c.g(topLevelType, position), position);
    }

    public d0(d2 d2Var, d2 d2Var2) {
        this.f24941c = d2Var;
        this.f24942d = d2Var2;
    }
}
