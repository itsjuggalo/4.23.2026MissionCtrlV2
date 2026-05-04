package le;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends h implements ve.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f15643c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(ef.f fVar, Class klass) {
        super(fVar, null);
        kotlin.jvm.internal.t.f(klass, "klass");
        this.f15643c = klass;
    }

    @Override // ve.h
    public ve.x c() {
        return e0.f15612a.a(this.f15643c);
    }
}
