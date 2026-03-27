package L3;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f3653b;

    public a(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f3652a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f3653b = list;
    }

    @Override // L3.l
    public List b() {
        return this.f3653b;
    }

    @Override // L3.l
    public String c() {
        return this.f3652a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f3652a.equals(lVar.c()) && this.f3653b.equals(lVar.b());
    }

    public int hashCode() {
        return ((this.f3652a.hashCode() ^ 1000003) * 1000003) ^ this.f3653b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f3652a + ", usedDates=" + this.f3653b + "}";
    }
}
