package Z5;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final W5.g f6035b;

    public e(String value, W5.g range) {
        kotlin.jvm.internal.r.f(value, "value");
        kotlin.jvm.internal.r.f(range, "range");
        this.f6034a = value;
        this.f6035b = range;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return kotlin.jvm.internal.r.b(this.f6034a, eVar.f6034a) && kotlin.jvm.internal.r.b(this.f6035b, eVar.f6035b);
    }

    public int hashCode() {
        return (this.f6034a.hashCode() * 31) + this.f6035b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f6034a + ", range=" + this.f6035b + ')';
    }
}
