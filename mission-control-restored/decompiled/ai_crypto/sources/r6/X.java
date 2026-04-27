package r6;

/* JADX INFO: loaded from: classes2.dex */
public final class X implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n6.b f22854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6.e f22855b;

    public X(n6.b serializer) {
        kotlin.jvm.internal.r.f(serializer, "serializer");
        this.f22854a = serializer;
        this.f22855b = new j0(serializer.getDescriptor());
    }

    @Override // n6.a
    public Object deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return decoder.t() ? decoder.l(this.f22854a) : decoder.m();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && X.class == obj.getClass() && kotlin.jvm.internal.r.b(this.f22854a, ((X) obj).f22854a);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return this.f22855b;
    }

    public int hashCode() {
        return this.f22854a.hashCode();
    }

    @Override // n6.h
    public void serialize(q6.f encoder, Object obj) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        if (obj == null) {
            encoder.e();
        } else {
            encoder.q();
            encoder.s(this.f22854a, obj);
        }
    }
}
