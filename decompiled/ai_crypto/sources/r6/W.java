package r6;

/* JADX INFO: loaded from: classes2.dex */
public final class W implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final W f22852a = new W();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22853b = V.f22849a;

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        throw new n6.g("'kotlin.Nothing' does not have instances");
    }

    @Override // n6.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(q6.f encoder, Void value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        throw new n6.g("'kotlin.Nothing' cannot be serialized");
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22853b;
    }
}
