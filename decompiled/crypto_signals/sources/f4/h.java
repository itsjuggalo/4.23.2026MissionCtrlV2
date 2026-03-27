package f4;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f6489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f6490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f6491d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h.class == obj.getClass()) {
            h hVar = (h) obj;
            if (this.f6488a.equals(hVar.f6488a) && this.f6489b.equals(hVar.f6489b) && Objects.equals(this.f6490c, hVar.f6490c) && this.f6491d.equals(hVar.f6491d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f6488a, this.f6489b, this.f6490c, this.f6491d);
    }
}
