package i4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11800a;

    public c(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f11800a = str;
    }

    public static c b(String str) {
        return new c(str);
    }

    public String a() {
        return this.f11800a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.f11800a.equals(((c) obj).f11800a);
        }
        return false;
    }

    public int hashCode() {
        return this.f11800a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f11800a + "\"}";
    }
}
