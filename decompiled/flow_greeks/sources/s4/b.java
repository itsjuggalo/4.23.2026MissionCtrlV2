package s4;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v4.a f19965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f19966b;

    public b(v4.a aVar, Map map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f19965a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f19966b = map;
    }

    @Override // s4.f
    public v4.a e() {
        return this.f19965a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f19965a.equals(fVar.e()) && this.f19966b.equals(fVar.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // s4.f
    public Map h() {
        return this.f19966b;
    }

    public int hashCode() {
        return ((this.f19965a.hashCode() ^ 1000003) * 1000003) ^ this.f19966b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f19965a + ", values=" + this.f19966b + "}";
    }
}
