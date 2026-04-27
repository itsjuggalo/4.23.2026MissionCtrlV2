package o7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.d;

/* JADX INFO: loaded from: classes2.dex */
public final class P0 implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final P0 f22136a = new P0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22137b = new q0("kotlin.uuid.Uuid", d.i.f21508a);

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public X6.b deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return X6.b.f9452c.c(decoder.q());
    }

    @Override // k7.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(n7.f encoder, X6.b value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        encoder.E(value.toString());
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22137b;
    }
}
