package U1;

/* JADX INFO: loaded from: classes.dex */
public final class i extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3109a;

    public i(Object obj) {
        this.f3109a = obj;
    }

    @Override // U1.g
    public final Object a() {
        return this.f3109a;
    }

    @Override // U1.g
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f3109a.equals(((i) obj).f3109a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3109a.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.f3109a + ")";
    }
}
