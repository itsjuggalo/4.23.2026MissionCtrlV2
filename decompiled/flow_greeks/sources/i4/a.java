package i4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f11795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f11797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f11798d;

    public a(Integer num, Object obj, f fVar, g gVar, e eVar) {
        this.f11795a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f11796b = obj;
        if (fVar == null) {
            throw new NullPointerException("Null priority");
        }
        this.f11797c = fVar;
        this.f11798d = gVar;
    }

    @Override // i4.d
    public Integer a() {
        return this.f11795a;
    }

    @Override // i4.d
    public e b() {
        return null;
    }

    @Override // i4.d
    public Object c() {
        return this.f11796b;
    }

    @Override // i4.d
    public f d() {
        return this.f11797c;
    }

    @Override // i4.d
    public g e() {
        return this.f11798d;
    }

    public boolean equals(Object obj) {
        g gVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            Integer num = this.f11795a;
            if (num != null ? num.equals(dVar.a()) : dVar.a() == null) {
                if (this.f11796b.equals(dVar.c()) && this.f11797c.equals(dVar.d()) && ((gVar = this.f11798d) != null ? gVar.equals(dVar.e()) : dVar.e() == null)) {
                    dVar.b();
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f11795a;
        int iHashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f11796b.hashCode()) * 1000003) ^ this.f11797c.hashCode()) * 1000003;
        g gVar = this.f11798d;
        return (iHashCode ^ (gVar != null ? gVar.hashCode() : 0)) * 1000003;
    }

    public String toString() {
        return "Event{code=" + this.f11795a + ", payload=" + this.f11796b + ", priority=" + this.f11797c + ", productData=" + this.f11798d + ", eventContext=" + ((Object) null) + "}";
    }
}
