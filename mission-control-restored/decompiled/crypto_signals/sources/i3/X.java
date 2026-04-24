package i3;

/* JADX INFO: loaded from: classes.dex */
public final class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6884d;
    public final C0684k e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f6885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f6886g;

    public X(String sessionId, String firstSessionId, int i, long j4, C0684k c0684k, String str, String firebaseAuthenticationToken) {
        kotlin.jvm.internal.j.e(sessionId, "sessionId");
        kotlin.jvm.internal.j.e(firstSessionId, "firstSessionId");
        kotlin.jvm.internal.j.e(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        this.f6881a = sessionId;
        this.f6882b = firstSessionId;
        this.f6883c = i;
        this.f6884d = j4;
        this.e = c0684k;
        this.f6885f = str;
        this.f6886g = firebaseAuthenticationToken;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X)) {
            return false;
        }
        X x6 = (X) obj;
        return kotlin.jvm.internal.j.a(this.f6881a, x6.f6881a) && kotlin.jvm.internal.j.a(this.f6882b, x6.f6882b) && this.f6883c == x6.f6883c && this.f6884d == x6.f6884d && kotlin.jvm.internal.j.a(this.e, x6.e) && kotlin.jvm.internal.j.a(this.f6885f, x6.f6885f) && kotlin.jvm.internal.j.a(this.f6886g, x6.f6886g);
    }

    public final int hashCode() {
        return this.f6886g.hashCode() + ((this.f6885f.hashCode() + ((this.e.hashCode() + ((Long.hashCode(this.f6884d) + ((Integer.hashCode(this.f6883c) + ((this.f6882b.hashCode() + (this.f6881a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "SessionInfo(sessionId=" + this.f6881a + ", firstSessionId=" + this.f6882b + ", sessionIndex=" + this.f6883c + ", eventTimestampUs=" + this.f6884d + ", dataCollectionStatus=" + this.e + ", firebaseInstallationId=" + this.f6885f + ", firebaseAuthenticationToken=" + this.f6886g + ')';
    }
}
