package g4;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: g4.P, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1801P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f18069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1816e f18070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f18072g;

    public C1801P(String sessionId, String firstSessionId, int i8, long j8, C1816e dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        AbstractC2304t.f(sessionId, "sessionId");
        AbstractC2304t.f(firstSessionId, "firstSessionId");
        AbstractC2304t.f(dataCollectionStatus, "dataCollectionStatus");
        AbstractC2304t.f(firebaseInstallationId, "firebaseInstallationId");
        AbstractC2304t.f(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        this.f18066a = sessionId;
        this.f18067b = firstSessionId;
        this.f18068c = i8;
        this.f18069d = j8;
        this.f18070e = dataCollectionStatus;
        this.f18071f = firebaseInstallationId;
        this.f18072g = firebaseAuthenticationToken;
    }

    public final C1816e a() {
        return this.f18070e;
    }

    public final long b() {
        return this.f18069d;
    }

    public final String c() {
        return this.f18072g;
    }

    public final String d() {
        return this.f18071f;
    }

    public final String e() {
        return this.f18067b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1801P)) {
            return false;
        }
        C1801P c1801p = (C1801P) obj;
        return AbstractC2304t.b(this.f18066a, c1801p.f18066a) && AbstractC2304t.b(this.f18067b, c1801p.f18067b) && this.f18068c == c1801p.f18068c && this.f18069d == c1801p.f18069d && AbstractC2304t.b(this.f18070e, c1801p.f18070e) && AbstractC2304t.b(this.f18071f, c1801p.f18071f) && AbstractC2304t.b(this.f18072g, c1801p.f18072g);
    }

    public final String f() {
        return this.f18066a;
    }

    public final int g() {
        return this.f18068c;
    }

    public int hashCode() {
        return (((((((((((this.f18066a.hashCode() * 31) + this.f18067b.hashCode()) * 31) + Integer.hashCode(this.f18068c)) * 31) + Long.hashCode(this.f18069d)) * 31) + this.f18070e.hashCode()) * 31) + this.f18071f.hashCode()) * 31) + this.f18072g.hashCode();
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.f18066a + ", firstSessionId=" + this.f18067b + ", sessionIndex=" + this.f18068c + ", eventTimestampUs=" + this.f18069d + ", dataCollectionStatus=" + this.f18070e + ", firebaseInstallationId=" + this.f18071f + ", firebaseAuthenticationToken=" + this.f18072g + ')';
    }
}
