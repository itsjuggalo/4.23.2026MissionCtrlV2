package X0;

/* JADX INFO: loaded from: classes.dex */
public final class q extends D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f3491a;

    public q(Integer num) {
        this.f3491a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        Integer num = this.f3491a;
        q qVar = (q) ((D) obj);
        return num == null ? qVar.f3491a == null : num.equals(qVar.f3491a);
    }

    public final int hashCode() {
        Integer num = this.f3491a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public final String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f3491a + "}";
    }
}
