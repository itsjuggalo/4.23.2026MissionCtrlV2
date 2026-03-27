package o7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class Y implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Y f22151a = new Y();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22152b = X.f22148a;

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        throw new k7.j("'kotlin.Nothing' does not have instances");
    }

    @Override // k7.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(n7.f encoder, Void value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        throw new k7.j("'kotlin.Nothing' cannot be serialized");
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22152b;
    }
}
