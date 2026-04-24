package G1;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J1.a f2088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2089b;

    public b(J1.a aVar, Map map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f2088a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f2089b = map;
    }

    @Override // G1.f
    public J1.a e() {
        return this.f2088a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f2088a.equals(fVar.e()) && this.f2089b.equals(fVar.h());
    }

    @Override // G1.f
    public Map h() {
        return this.f2089b;
    }

    public int hashCode() {
        return ((this.f2088a.hashCode() ^ 1000003) * 1000003) ^ this.f2089b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f2088a + ", values=" + this.f2089b + "}";
    }
}
