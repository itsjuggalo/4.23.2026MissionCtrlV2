package v2;

/* JADX INFO: renamed from: v2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2849o extends AbstractC2845k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f23768a;

    public C2849o(Object obj) {
        this.f23768a = obj;
    }

    @Override // v2.AbstractC2845k
    public Object b() {
        return this.f23768a;
    }

    @Override // v2.AbstractC2845k
    public boolean c() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2849o) {
            return this.f23768a.equals(((C2849o) obj).f23768a);
        }
        return false;
    }

    public int hashCode() {
        return this.f23768a.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.f23768a + ")";
    }
}
