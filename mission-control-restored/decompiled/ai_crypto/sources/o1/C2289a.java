package o1;

/* JADX INFO: renamed from: o1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2289a extends AbstractC2292d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f20009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnumC2294f f20011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC2295g f20012d;

    public C2289a(Integer num, Object obj, EnumC2294f enumC2294f, AbstractC2295g abstractC2295g, AbstractC2293e abstractC2293e) {
        this.f20009a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f20010b = obj;
        if (enumC2294f == null) {
            throw new NullPointerException("Null priority");
        }
        this.f20011c = enumC2294f;
        this.f20012d = abstractC2295g;
    }

    @Override // o1.AbstractC2292d
    public Integer a() {
        return this.f20009a;
    }

    @Override // o1.AbstractC2292d
    public AbstractC2293e b() {
        return null;
    }

    @Override // o1.AbstractC2292d
    public Object c() {
        return this.f20010b;
    }

    @Override // o1.AbstractC2292d
    public EnumC2294f d() {
        return this.f20011c;
    }

    @Override // o1.AbstractC2292d
    public AbstractC2295g e() {
        return this.f20012d;
    }

    public boolean equals(Object obj) {
        AbstractC2295g abstractC2295g;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2292d)) {
            return false;
        }
        AbstractC2292d abstractC2292d = (AbstractC2292d) obj;
        Integer num = this.f20009a;
        if (num != null ? num.equals(abstractC2292d.a()) : abstractC2292d.a() == null) {
            if (this.f20010b.equals(abstractC2292d.c()) && this.f20011c.equals(abstractC2292d.d()) && ((abstractC2295g = this.f20012d) != null ? abstractC2295g.equals(abstractC2292d.e()) : abstractC2292d.e() == null)) {
                abstractC2292d.b();
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f20009a;
        int iHashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f20010b.hashCode()) * 1000003) ^ this.f20011c.hashCode()) * 1000003;
        AbstractC2295g abstractC2295g = this.f20012d;
        return (iHashCode ^ (abstractC2295g != null ? abstractC2295g.hashCode() : 0)) * 1000003;
    }

    public String toString() {
        return "Event{code=" + this.f20009a + ", payload=" + this.f20010b + ", priority=" + this.f20011c + ", productData=" + this.f20012d + ", eventContext=" + ((Object) null) + "}";
    }
}
