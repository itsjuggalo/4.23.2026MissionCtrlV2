package Z3;

/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0785e f5852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5854g;

    public D(String sessionId, String firstSessionId, int i7, long j7, C0785e dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        kotlin.jvm.internal.r.f(sessionId, "sessionId");
        kotlin.jvm.internal.r.f(firstSessionId, "firstSessionId");
        kotlin.jvm.internal.r.f(dataCollectionStatus, "dataCollectionStatus");
        kotlin.jvm.internal.r.f(firebaseInstallationId, "firebaseInstallationId");
        kotlin.jvm.internal.r.f(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        this.f5848a = sessionId;
        this.f5849b = firstSessionId;
        this.f5850c = i7;
        this.f5851d = j7;
        this.f5852e = dataCollectionStatus;
        this.f5853f = firebaseInstallationId;
        this.f5854g = firebaseAuthenticationToken;
    }

    public final C0785e a() {
        return this.f5852e;
    }

    public final long b() {
        return this.f5851d;
    }

    public final String c() {
        return this.f5854g;
    }

    public final String d() {
        return this.f5853f;
    }

    public final String e() {
        return this.f5849b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d7 = (D) obj;
        return kotlin.jvm.internal.r.b(this.f5848a, d7.f5848a) && kotlin.jvm.internal.r.b(this.f5849b, d7.f5849b) && this.f5850c == d7.f5850c && this.f5851d == d7.f5851d && kotlin.jvm.internal.r.b(this.f5852e, d7.f5852e) && kotlin.jvm.internal.r.b(this.f5853f, d7.f5853f) && kotlin.jvm.internal.r.b(this.f5854g, d7.f5854g);
    }

    public final String f() {
        return this.f5848a;
    }

    public final int g() {
        return this.f5850c;
    }

    public int hashCode() {
        return (((((((((((this.f5848a.hashCode() * 31) + this.f5849b.hashCode()) * 31) + Integer.hashCode(this.f5850c)) * 31) + Long.hashCode(this.f5851d)) * 31) + this.f5852e.hashCode()) * 31) + this.f5853f.hashCode()) * 31) + this.f5854g.hashCode();
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.f5848a + ", firstSessionId=" + this.f5849b + ", sessionIndex=" + this.f5850c + ", eventTimestampUs=" + this.f5851d + ", dataCollectionStatus=" + this.f5852e + ", firebaseInstallationId=" + this.f5853f + ", firebaseAuthenticationToken=" + this.f5854g + ')';
    }
}
