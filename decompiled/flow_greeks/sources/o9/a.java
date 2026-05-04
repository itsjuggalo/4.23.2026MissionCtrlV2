package o9;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f17662b;

    public a(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f17661a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f17662b = list;
    }

    @Override // o9.q
    public List b() {
        return this.f17662b;
    }

    @Override // o9.q
    public String c() {
        return this.f17661a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f17661a.equals(qVar.c()) && this.f17662b.equals(qVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f17661a.hashCode() ^ 1000003) * 1000003) ^ this.f17662b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f17661a + ", usedDates=" + this.f17662b + "}";
    }
}
