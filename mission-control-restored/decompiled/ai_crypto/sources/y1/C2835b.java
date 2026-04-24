package y1;

import java.util.Map;

/* JADX INFO: renamed from: y1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2835b extends AbstractC2839f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B1.a f25457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f25458b;

    public C2835b(B1.a aVar, Map map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f25457a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f25458b = map;
    }

    @Override // y1.AbstractC2839f
    public B1.a e() {
        return this.f25457a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2839f)) {
            return false;
        }
        AbstractC2839f abstractC2839f = (AbstractC2839f) obj;
        return this.f25457a.equals(abstractC2839f.e()) && this.f25458b.equals(abstractC2839f.h());
    }

    @Override // y1.AbstractC2839f
    public Map h() {
        return this.f25458b;
    }

    public int hashCode() {
        return ((this.f25457a.hashCode() ^ 1000003) * 1000003) ^ this.f25458b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f25457a + ", values=" + this.f25458b + "}";
    }
}
