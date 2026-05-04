package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f22640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f22641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f22642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f22643g;

    public p0(String sessionId, String firstSessionId, int i10, long j10, e dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        kotlin.jvm.internal.t.f(sessionId, "sessionId");
        kotlin.jvm.internal.t.f(firstSessionId, "firstSessionId");
        kotlin.jvm.internal.t.f(dataCollectionStatus, "dataCollectionStatus");
        kotlin.jvm.internal.t.f(firebaseInstallationId, "firebaseInstallationId");
        kotlin.jvm.internal.t.f(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        this.f22637a = sessionId;
        this.f22638b = firstSessionId;
        this.f22639c = i10;
        this.f22640d = j10;
        this.f22641e = dataCollectionStatus;
        this.f22642f = firebaseInstallationId;
        this.f22643g = firebaseAuthenticationToken;
    }

    public final e a() {
        return this.f22641e;
    }

    public final long b() {
        return this.f22640d;
    }

    public final String c() {
        return this.f22643g;
    }

    public final String d() {
        return this.f22642f;
    }

    public final String e() {
        return this.f22638b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return kotlin.jvm.internal.t.b(this.f22637a, p0Var.f22637a) && kotlin.jvm.internal.t.b(this.f22638b, p0Var.f22638b) && this.f22639c == p0Var.f22639c && this.f22640d == p0Var.f22640d && kotlin.jvm.internal.t.b(this.f22641e, p0Var.f22641e) && kotlin.jvm.internal.t.b(this.f22642f, p0Var.f22642f) && kotlin.jvm.internal.t.b(this.f22643g, p0Var.f22643g);
    }

    public final String f() {
        return this.f22637a;
    }

    public final int g() {
        return this.f22639c;
    }

    public int hashCode() {
        return (((((((((((this.f22637a.hashCode() * 31) + this.f22638b.hashCode()) * 31) + Integer.hashCode(this.f22639c)) * 31) + Long.hashCode(this.f22640d)) * 31) + this.f22641e.hashCode()) * 31) + this.f22642f.hashCode()) * 31) + this.f22643g.hashCode();
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.f22637a + ", firstSessionId=" + this.f22638b + ", sessionIndex=" + this.f22639c + ", eventTimestampUs=" + this.f22640d + ", dataCollectionStatus=" + this.f22641e + ", firebaseInstallationId=" + this.f22642f + ", firebaseAuthenticationToken=" + this.f22643g + ')';
    }
}
