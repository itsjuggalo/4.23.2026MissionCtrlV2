package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z extends d2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d2 f25101c;

    public z(d2 substitution) {
        kotlin.jvm.internal.t.f(substitution, "substitution");
        this.f25101c = substitution;
    }

    @Override // xf.d2
    public boolean a() {
        return this.f25101c.a();
    }

    @Override // xf.d2
    public ge.h d(ge.h annotations) {
        kotlin.jvm.internal.t.f(annotations, "annotations");
        return this.f25101c.d(annotations);
    }

    @Override // xf.d2
    public a2 e(r0 key) {
        kotlin.jvm.internal.t.f(key, "key");
        return this.f25101c.e(key);
    }

    @Override // xf.d2
    public boolean f() {
        return this.f25101c.f();
    }

    @Override // xf.d2
    public r0 g(r0 topLevelType, m2 position) {
        kotlin.jvm.internal.t.f(topLevelType, "topLevelType");
        kotlin.jvm.internal.t.f(position, "position");
        return this.f25101c.g(topLevelType, position);
    }
}
