package J3;

/* JADX INFO: loaded from: classes3.dex */
public final class X implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F3.b f897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H3.e f898b;

    public X(F3.b serializer) {
        kotlin.jvm.internal.r.f(serializer, "serializer");
        this.f897a = serializer;
        this.f898b = new j0(serializer.getDescriptor());
    }

    @Override // F3.a
    public Object deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return decoder.t() ? decoder.p(this.f897a) : decoder.o();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && X.class == obj.getClass() && kotlin.jvm.internal.r.b(this.f897a, ((X) obj).f897a);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return this.f898b;
    }

    public int hashCode() {
        return this.f897a.hashCode();
    }

    @Override // F3.h
    public void serialize(I3.f encoder, Object obj) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        if (obj == null) {
            encoder.e();
        } else {
            encoder.r();
            encoder.z(this.f897a, obj);
        }
    }
}
