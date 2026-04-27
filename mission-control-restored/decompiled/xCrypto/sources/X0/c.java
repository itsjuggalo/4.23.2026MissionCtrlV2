package X0;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5534a;

    public c(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f5534a = str;
    }

    public static c b(String str) {
        return new c(str);
    }

    public String a() {
        return this.f5534a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.f5534a.equals(((c) obj).f5534a);
        }
        return false;
    }

    public int hashCode() {
        return this.f5534a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f5534a + "\"}";
    }
}
