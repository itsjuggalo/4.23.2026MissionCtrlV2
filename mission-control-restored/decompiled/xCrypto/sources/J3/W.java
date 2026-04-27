package J3;

/* JADX INFO: loaded from: classes3.dex */
public final class W implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final W f895a = new W();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f896b = V.f892a;

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        throw new F3.g("'kotlin.Nothing' does not have instances");
    }

    @Override // F3.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(I3.f encoder, Void value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        throw new F3.g("'kotlin.Nothing' cannot be serialized");
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f896b;
    }
}
