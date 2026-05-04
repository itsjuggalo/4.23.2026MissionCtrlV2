package le;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends h implements ve.o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f15649c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(ef.f fVar, Object value) {
        super(fVar, null);
        kotlin.jvm.internal.t.f(value, "value");
        this.f15649c = value;
    }

    @Override // ve.o
    public Object getValue() {
        return this.f15649c;
    }
}
