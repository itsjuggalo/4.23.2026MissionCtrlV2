package z1;

/* JADX INFO: renamed from: z1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2857b extends AbstractC2866k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f26001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r1.p f26002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r1.i f26003c;

    public C2857b(long j7, r1.p pVar, r1.i iVar) {
        this.f26001a = j7;
        if (pVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f26002b = pVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f26003c = iVar;
    }

    @Override // z1.AbstractC2866k
    public r1.i b() {
        return this.f26003c;
    }

    @Override // z1.AbstractC2866k
    public long c() {
        return this.f26001a;
    }

    @Override // z1.AbstractC2866k
    public r1.p d() {
        return this.f26002b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2866k)) {
            return false;
        }
        AbstractC2866k abstractC2866k = (AbstractC2866k) obj;
        return this.f26001a == abstractC2866k.c() && this.f26002b.equals(abstractC2866k.d()) && this.f26003c.equals(abstractC2866k.b());
    }

    public int hashCode() {
        long j7 = this.f26001a;
        return ((((((int) (j7 ^ (j7 >>> 32))) ^ 1000003) * 1000003) ^ this.f26002b.hashCode()) * 1000003) ^ this.f26003c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f26001a + ", transportContext=" + this.f26002b + ", event=" + this.f26003c + "}";
    }
}
