package V2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3236b;

    public a(String str, ArrayList arrayList) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f3235a = str;
        this.f3236b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f3235a.equals(aVar.f3235a) && this.f3236b.equals(aVar.f3236b);
    }

    public final int hashCode() {
        return ((this.f3235a.hashCode() ^ 1000003) * 1000003) ^ this.f3236b.hashCode();
    }

    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.f3235a + ", usedDates=" + this.f3236b + "}";
    }
}
