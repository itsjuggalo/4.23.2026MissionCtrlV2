package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x0 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f8248a = new x0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f8249b = w0.f8241a;

    @Override // zg.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        throw new zg.j("'kotlin.Nothing' does not have instances");
    }

    @Override // zg.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(ch.f encoder, Void value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        throw new zg.j("'kotlin.Nothing' cannot be serialized");
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f8249b;
    }
}
