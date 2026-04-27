package i1;

/* JADX INFO: renamed from: i1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1295b extends AbstractC1304k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1.p f12226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a1.i f12227c;

    public C1295b(long j4, a1.p pVar, a1.i iVar) {
        this.f12225a = j4;
        if (pVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f12226b = pVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f12227c = iVar;
    }

    @Override // i1.AbstractC1304k
    public a1.i b() {
        return this.f12227c;
    }

    @Override // i1.AbstractC1304k
    public long c() {
        return this.f12225a;
    }

    @Override // i1.AbstractC1304k
    public a1.p d() {
        return this.f12226b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1304k) {
            AbstractC1304k abstractC1304k = (AbstractC1304k) obj;
            if (this.f12225a == abstractC1304k.c() && this.f12226b.equals(abstractC1304k.d()) && this.f12227c.equals(abstractC1304k.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f12225a;
        return ((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f12226b.hashCode()) * 1000003) ^ this.f12227c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f12225a + ", transportContext=" + this.f12226b + ", event=" + this.f12227c + "}";
    }
}
