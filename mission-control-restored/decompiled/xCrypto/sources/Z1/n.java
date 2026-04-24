package Z1;

/* JADX INFO: loaded from: classes.dex */
public final class n extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5983a;

    public n(Object obj) {
        this.f5983a = obj;
    }

    @Override // Z1.j
    public Object b() {
        return this.f5983a;
    }

    @Override // Z1.j
    public boolean c() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f5983a.equals(((n) obj).f5983a);
        }
        return false;
    }

    public int hashCode() {
        return this.f5983a.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.f5983a + ")";
    }
}
