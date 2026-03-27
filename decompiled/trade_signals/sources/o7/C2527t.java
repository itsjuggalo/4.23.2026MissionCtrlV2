package o7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.d;

/* JADX INFO: renamed from: o7.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2527t implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2527t f22207a = new C2527t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22208b = new q0("kotlin.Double", d.C0358d.f21503a);

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Double deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return Double.valueOf(decoder.H());
    }

    public void b(n7.f encoder, double d8) {
        AbstractC2304t.f(encoder, "encoder");
        encoder.h(d8);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22208b;
    }

    @Override // k7.k
    public /* bridge */ /* synthetic */ void serialize(n7.f fVar, Object obj) {
        b(fVar, ((Number) obj).doubleValue());
    }
}
