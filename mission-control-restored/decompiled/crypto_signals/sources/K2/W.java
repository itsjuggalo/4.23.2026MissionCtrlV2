package K2;

/* JADX INFO: loaded from: classes.dex */
public final class W implements V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public X f881a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || W.class != obj.getClass()) {
            return false;
        }
        return this.f881a.equals(((W) obj).f881a);
    }

    public final int hashCode() {
        return this.f881a.hashCode();
    }

    public final String toString() {
        return "MemoryCacheSettings{gcSettings=" + this.f881a + "}";
    }
}
