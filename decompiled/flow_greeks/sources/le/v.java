package le;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends h implements ve.m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Enum f15647c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(ef.f fVar, Enum value) {
        super(fVar, null);
        kotlin.jvm.internal.t.f(value, "value");
        this.f15647c = value;
    }

    @Override // ve.m
    public ef.b b() {
        Class<?> enclosingClass = this.f15647c.getClass();
        if (!enclosingClass.isEnum()) {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        kotlin.jvm.internal.t.c(enclosingClass);
        return f.e(enclosingClass);
    }

    @Override // ve.m
    public ef.f d() {
        return ef.f.k(this.f15647c.name());
    }
}
