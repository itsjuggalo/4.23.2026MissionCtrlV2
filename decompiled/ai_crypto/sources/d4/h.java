package d4;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f13380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f13381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f13382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f13383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f13384e;

    public h(Boolean bool, Double d7, Integer num, Integer num2, Long l7) {
        this.f13380a = bool;
        this.f13381b = d7;
        this.f13382c = num;
        this.f13383d = num2;
        this.f13384e = l7;
    }

    public final Integer a() {
        return this.f13383d;
    }

    public final Long b() {
        return this.f13384e;
    }

    public final Boolean c() {
        return this.f13380a;
    }

    public final Integer d() {
        return this.f13382c;
    }

    public final Double e() {
        return this.f13381b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return r.b(this.f13380a, hVar.f13380a) && r.b(this.f13381b, hVar.f13381b) && r.b(this.f13382c, hVar.f13382c) && r.b(this.f13383d, hVar.f13383d) && r.b(this.f13384e, hVar.f13384e);
    }

    public int hashCode() {
        Boolean bool = this.f13380a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d7 = this.f13381b;
        int iHashCode2 = (iHashCode + (d7 == null ? 0 : d7.hashCode())) * 31;
        Integer num = this.f13382c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f13383d;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l7 = this.f13384e;
        return iHashCode4 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfigs(sessionEnabled=" + this.f13380a + ", sessionSamplingRate=" + this.f13381b + ", sessionRestartTimeout=" + this.f13382c + ", cacheDuration=" + this.f13383d + ", cacheUpdatedTime=" + this.f13384e + ')';
    }
}
