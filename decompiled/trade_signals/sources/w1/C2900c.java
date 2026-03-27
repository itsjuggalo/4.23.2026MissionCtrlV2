package w1;

/* JADX INFO: renamed from: w1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2900c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23988a;

    public C2900c(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f23988a = str;
    }

    public static C2900c b(String str) {
        return new C2900c(str);
    }

    public String a() {
        return this.f23988a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2900c) {
            return this.f23988a.equals(((C2900c) obj).f23988a);
        }
        return false;
    }

    public int hashCode() {
        return this.f23988a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f23988a + "\"}";
    }
}
