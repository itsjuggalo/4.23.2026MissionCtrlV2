package B3;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f131b;

    public a(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f130a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f131b = list;
    }

    @Override // B3.q
    public List b() {
        return this.f131b;
    }

    @Override // B3.q
    public String c() {
        return this.f130a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f130a.equals(qVar.c()) && this.f131b.equals(qVar.b());
    }

    public int hashCode() {
        return ((this.f130a.hashCode() ^ 1000003) * 1000003) ^ this.f131b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f130a + ", usedDates=" + this.f131b + "}";
    }
}
