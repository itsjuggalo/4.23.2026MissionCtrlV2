package H2;

/* JADX INFO: loaded from: classes.dex */
public final class n extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2608a;

    public n(Object obj) {
        this.f2608a = obj;
    }

    @Override // H2.j
    public Object b() {
        return this.f2608a;
    }

    @Override // H2.j
    public boolean c() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f2608a.equals(((n) obj).f2608a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2608a.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.f2608a + ")";
    }
}
