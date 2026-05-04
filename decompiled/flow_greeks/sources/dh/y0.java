package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y0 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zg.b f8255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bh.e f8256b;

    public y0(zg.b serializer) {
        kotlin.jvm.internal.t.f(serializer, "serializer");
        this.f8255a = serializer;
        this.f8256b = new r1(serializer.getDescriptor());
    }

    @Override // zg.a
    public Object deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return decoder.t() ? decoder.E(this.f8255a) : decoder.l();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && y0.class == obj.getClass() && kotlin.jvm.internal.t.b(this.f8255a, ((y0) obj).f8255a);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return this.f8256b;
    }

    public int hashCode() {
        return this.f8255a.hashCode();
    }

    @Override // zg.k
    public void serialize(ch.f encoder, Object obj) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        if (obj == null) {
            encoder.f();
        } else {
            encoder.u();
            encoder.B(this.f8255a, obj);
        }
    }
}
