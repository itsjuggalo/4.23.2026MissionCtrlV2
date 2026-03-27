package N2;

/* JADX INFO: loaded from: classes.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q2.j f1908b;

    public C(int i, Q2.j jVar) {
        this.f1907a = i;
        this.f1908b = jVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C)) {
            return false;
        }
        C c6 = (C) obj;
        return this.f1907a == c6.f1907a && this.f1908b.equals(c6.f1908b);
    }

    public final int hashCode() {
        return this.f1908b.hashCode() + ((S.i.c(this.f1907a) + 899) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1907a == 1 ? "" : "-");
        sb.append(this.f1908b.c());
        return sb.toString();
    }
}
