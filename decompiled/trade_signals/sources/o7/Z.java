package o7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class Z implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k7.b f22153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m7.e f22154b;

    public Z(k7.b serializer) {
        AbstractC2304t.f(serializer, "serializer");
        this.f22153a = serializer;
        this.f22154b = new s0(serializer.getDescriptor());
    }

    @Override // k7.a
    public Object deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return decoder.t() ? decoder.v(this.f22153a) : decoder.o();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Z.class == obj.getClass() && AbstractC2304t.b(this.f22153a, ((Z) obj).f22153a);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return this.f22154b;
    }

    public int hashCode() {
        return this.f22153a.hashCode();
    }

    @Override // k7.k
    public void serialize(n7.f encoder, Object obj) {
        AbstractC2304t.f(encoder, "encoder");
        if (obj == null) {
            encoder.f();
        } else {
            encoder.o();
            encoder.C(this.f22153a, obj);
        }
    }
}
