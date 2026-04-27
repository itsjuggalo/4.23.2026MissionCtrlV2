package o1;

/* JADX INFO: renamed from: o1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2291c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20014a;

    public C2291c(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f20014a = str;
    }

    public static C2291c b(String str) {
        return new C2291c(str);
    }

    public String a() {
        return this.f20014a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2291c) {
            return this.f20014a.equals(((C2291c) obj).f20014a);
        }
        return false;
    }

    public int hashCode() {
        return this.f20014a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f20014a + "\"}";
    }
}
