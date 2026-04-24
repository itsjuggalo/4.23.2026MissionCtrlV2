package J3;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends L {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f926c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(H3.e primitive) {
        super(primitive, null);
        kotlin.jvm.internal.r.f(primitive, "primitive");
        this.f926c = primitive.a() + "Array";
    }

    @Override // H3.e
    public String a() {
        return this.f926c;
    }
}
