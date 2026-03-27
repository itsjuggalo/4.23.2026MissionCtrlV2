package w1;

/* JADX INFO: renamed from: w1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2898a extends AbstractC2901d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f23983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f23984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnumC2903f f23985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC2904g f23986d;

    public C2898a(Integer num, Object obj, EnumC2903f enumC2903f, AbstractC2904g abstractC2904g, AbstractC2902e abstractC2902e) {
        this.f23983a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f23984b = obj;
        if (enumC2903f == null) {
            throw new NullPointerException("Null priority");
        }
        this.f23985c = enumC2903f;
        this.f23986d = abstractC2904g;
    }

    @Override // w1.AbstractC2901d
    public Integer a() {
        return this.f23983a;
    }

    @Override // w1.AbstractC2901d
    public AbstractC2902e b() {
        return null;
    }

    @Override // w1.AbstractC2901d
    public Object c() {
        return this.f23984b;
    }

    @Override // w1.AbstractC2901d
    public EnumC2903f d() {
        return this.f23985c;
    }

    @Override // w1.AbstractC2901d
    public AbstractC2904g e() {
        return this.f23986d;
    }

    public boolean equals(Object obj) {
        AbstractC2904g abstractC2904g;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2901d)) {
            return false;
        }
        AbstractC2901d abstractC2901d = (AbstractC2901d) obj;
        Integer num = this.f23983a;
        if (num != null ? num.equals(abstractC2901d.a()) : abstractC2901d.a() == null) {
            if (this.f23984b.equals(abstractC2901d.c()) && this.f23985c.equals(abstractC2901d.d()) && ((abstractC2904g = this.f23986d) != null ? abstractC2904g.equals(abstractC2901d.e()) : abstractC2901d.e() == null)) {
                abstractC2901d.b();
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f23983a;
        int iHashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f23984b.hashCode()) * 1000003) ^ this.f23985c.hashCode()) * 1000003;
        AbstractC2904g abstractC2904g = this.f23986d;
        return (iHashCode ^ (abstractC2904g != null ? abstractC2904g.hashCode() : 0)) * 1000003;
    }

    public String toString() {
        return "Event{code=" + this.f23983a + ", payload=" + this.f23984b + ", priority=" + this.f23985c + ", productData=" + this.f23986d + ", eventContext=" + ((Object) null) + "}";
    }
}
