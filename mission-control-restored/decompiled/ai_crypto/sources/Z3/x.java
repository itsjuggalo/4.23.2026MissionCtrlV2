package Z3;

/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6008d;

    public x(String sessionId, String firstSessionId, int i7, long j7) {
        kotlin.jvm.internal.r.f(sessionId, "sessionId");
        kotlin.jvm.internal.r.f(firstSessionId, "firstSessionId");
        this.f6005a = sessionId;
        this.f6006b = firstSessionId;
        this.f6007c = i7;
        this.f6008d = j7;
    }

    public final String a() {
        return this.f6006b;
    }

    public final String b() {
        return this.f6005a;
    }

    public final int c() {
        return this.f6007c;
    }

    public final long d() {
        return this.f6008d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return kotlin.jvm.internal.r.b(this.f6005a, xVar.f6005a) && kotlin.jvm.internal.r.b(this.f6006b, xVar.f6006b) && this.f6007c == xVar.f6007c && this.f6008d == xVar.f6008d;
    }

    public int hashCode() {
        return (((((this.f6005a.hashCode() * 31) + this.f6006b.hashCode()) * 31) + Integer.hashCode(this.f6007c)) * 31) + Long.hashCode(this.f6008d);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.f6005a + ", firstSessionId=" + this.f6006b + ", sessionIndex=" + this.f6007c + ", sessionStartTimestampUs=" + this.f6008d + ')';
    }
}
