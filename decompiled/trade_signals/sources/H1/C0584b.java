package H1;

/* JADX INFO: renamed from: H1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0584b extends AbstractC0593k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z1.p f3621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z1.i f3622c;

    public C0584b(long j8, z1.p pVar, z1.i iVar) {
        this.f3620a = j8;
        if (pVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f3621b = pVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f3622c = iVar;
    }

    @Override // H1.AbstractC0593k
    public z1.i b() {
        return this.f3622c;
    }

    @Override // H1.AbstractC0593k
    public long c() {
        return this.f3620a;
    }

    @Override // H1.AbstractC0593k
    public z1.p d() {
        return this.f3621b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0593k)) {
            return false;
        }
        AbstractC0593k abstractC0593k = (AbstractC0593k) obj;
        return this.f3620a == abstractC0593k.c() && this.f3621b.equals(abstractC0593k.d()) && this.f3622c.equals(abstractC0593k.b());
    }

    public int hashCode() {
        long j8 = this.f3620a;
        return ((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ this.f3621b.hashCode()) * 1000003) ^ this.f3622c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f3620a + ", transportContext=" + this.f3621b + ", event=" + this.f3622c + "}";
    }
}
