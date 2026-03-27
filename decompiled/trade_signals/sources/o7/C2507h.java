package o7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.d;

/* JADX INFO: renamed from: o7.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2507h implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2507h f22167a = new C2507h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22168b = new q0("kotlin.Boolean", d.a.f21500a);

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return Boolean.valueOf(decoder.g());
    }

    public void b(n7.f encoder, boolean z7) {
        AbstractC2304t.f(encoder, "encoder");
        encoder.k(z7);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22168b;
    }

    @Override // k7.k
    public /* bridge */ /* synthetic */ void serialize(n7.f fVar, Object obj) {
        b(fVar, ((Boolean) obj).booleanValue());
    }
}
