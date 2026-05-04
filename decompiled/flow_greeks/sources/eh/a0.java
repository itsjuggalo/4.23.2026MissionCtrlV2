package eh;

import bh.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f8970a = new a0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f8971b = bh.k.e("kotlinx.serialization.json.JsonNull", l.b.f3401a, new bh.e[0], null, 8, null);

    @Override // zg.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public z deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        r.g(decoder);
        if (decoder.t()) {
            throw new fh.y("Expected 'null' literal");
        }
        decoder.l();
        return z.INSTANCE;
    }

    @Override // zg.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(ch.f encoder, z value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        r.h(encoder);
        encoder.f();
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f8971b;
    }
}
