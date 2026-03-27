package l3;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final i Companion = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f8122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f8123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f8124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f8125d;
    public final Long e;

    public /* synthetic */ j(int i, Boolean bool, Double d4, Integer num, Integer num2, Long l6) {
        if (31 != (i & 31)) {
            p5.k.a(i, 31, h.f8121a.d());
            throw null;
        }
        this.f8122a = bool;
        this.f8123b = d4;
        this.f8124c = num;
        this.f8125d = num2;
        this.e = l6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return kotlin.jvm.internal.j.a(this.f8122a, jVar.f8122a) && kotlin.jvm.internal.j.a(this.f8123b, jVar.f8123b) && kotlin.jvm.internal.j.a(this.f8124c, jVar.f8124c) && kotlin.jvm.internal.j.a(this.f8125d, jVar.f8125d) && kotlin.jvm.internal.j.a(this.e, jVar.e);
    }

    public final int hashCode() {
        Boolean bool = this.f8122a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d4 = this.f8123b;
        int iHashCode2 = (iHashCode + (d4 == null ? 0 : d4.hashCode())) * 31;
        Integer num = this.f8124c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f8125d;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l6 = this.e;
        return iHashCode4 + (l6 != null ? l6.hashCode() : 0);
    }

    public final String toString() {
        return "SessionConfigs(sessionsEnabled=" + this.f8122a + ", sessionSamplingRate=" + this.f8123b + ", sessionTimeoutSeconds=" + this.f8124c + ", cacheDurationSeconds=" + this.f8125d + ", cacheUpdatedTimeSeconds=" + this.e + ')';
    }

    public j(Boolean bool, Double d4, Integer num, Integer num2, Long l6) {
        this.f8122a = bool;
        this.f8123b = d4;
        this.f8124c = num;
        this.f8125d = num2;
        this.e = l6;
    }
}
