package p6;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18328a;

    public o(Object obj) {
        this.f18328a = obj;
    }

    @Override // p6.k
    public Object b() {
        return this.f18328a;
    }

    @Override // p6.k
    public boolean c() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof o) {
            return this.f18328a.equals(((o) obj).f18328a);
        }
        return false;
    }

    public int hashCode() {
        return this.f18328a.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + this.f18328a + ")";
    }
}
