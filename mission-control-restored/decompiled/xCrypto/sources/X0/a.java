package X0;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f5529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f5531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f5532d;

    public a(Integer num, Object obj, f fVar, g gVar, e eVar) {
        this.f5529a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f5530b = obj;
        if (fVar == null) {
            throw new NullPointerException("Null priority");
        }
        this.f5531c = fVar;
        this.f5532d = gVar;
    }

    @Override // X0.d
    public Integer a() {
        return this.f5529a;
    }

    @Override // X0.d
    public e b() {
        return null;
    }

    @Override // X0.d
    public Object c() {
        return this.f5530b;
    }

    @Override // X0.d
    public f d() {
        return this.f5531c;
    }

    @Override // X0.d
    public g e() {
        return this.f5532d;
    }

    public boolean equals(Object obj) {
        g gVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            Integer num = this.f5529a;
            if (num != null ? num.equals(dVar.a()) : dVar.a() == null) {
                if (this.f5530b.equals(dVar.c()) && this.f5531c.equals(dVar.d()) && ((gVar = this.f5532d) != null ? gVar.equals(dVar.e()) : dVar.e() == null)) {
                    dVar.b();
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f5529a;
        int iHashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f5530b.hashCode()) * 1000003) ^ this.f5531c.hashCode()) * 1000003;
        g gVar = this.f5532d;
        return (iHashCode ^ (gVar != null ? gVar.hashCode() : 0)) * 1000003;
    }

    public String toString() {
        return "Event{code=" + this.f5529a + ", payload=" + this.f5530b + ", priority=" + this.f5531c + ", productData=" + this.f5532d + ", eventContext=" + ((Object) null) + "}";
    }
}
