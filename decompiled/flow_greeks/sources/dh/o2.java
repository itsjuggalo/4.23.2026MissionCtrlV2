package dh;

import bh.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o2 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o2 f8200a = new o2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f8201b = new p1("kotlin.uuid.Uuid", d.i.f3379a);

    @Override // zg.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public mg.a deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return mg.a.f16432c.c(decoder.m());
    }

    @Override // zg.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(ch.f encoder, mg.a value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        encoder.F(value.toString());
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f8201b;
    }
}
