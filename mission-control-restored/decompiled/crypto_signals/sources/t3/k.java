package t3;

/* JADX INFO: loaded from: classes.dex */
public final class k extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v3.m f10248a = new v3.m(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof k) && ((k) obj).f10248a.equals(this.f10248a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f10248a.hashCode();
    }
}
