package X0;

/* JADX INFO: loaded from: classes.dex */
public final class r extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f3492a;

    public r(q qVar) {
        this.f3492a = qVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof E) {
            return this.f3492a.equals(((r) ((E) obj)).f3492a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3492a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f3492a + "}";
    }
}
