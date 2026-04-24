package i3;

/* JADX INFO: loaded from: classes.dex */
public final class N {
    public static final M Companion = new M();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6851d;

    public /* synthetic */ N(int i, String str, String str2, int i6, long j4) {
        if (15 != (i & 15)) {
            p5.k.a(i, 15, L.f6847a.d());
            throw null;
        }
        this.f6848a = str;
        this.f6849b = str2;
        this.f6850c = i6;
        this.f6851d = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N)) {
            return false;
        }
        N n6 = (N) obj;
        return kotlin.jvm.internal.j.a(this.f6848a, n6.f6848a) && kotlin.jvm.internal.j.a(this.f6849b, n6.f6849b) && this.f6850c == n6.f6850c && this.f6851d == n6.f6851d;
    }

    public final int hashCode() {
        return Long.hashCode(this.f6851d) + ((Integer.hashCode(this.f6850c) + ((this.f6849b.hashCode() + (this.f6848a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "SessionDetails(sessionId=" + this.f6848a + ", firstSessionId=" + this.f6849b + ", sessionIndex=" + this.f6850c + ", sessionStartTimestampUs=" + this.f6851d + ')';
    }

    public N(String str, String str2, int i, long j4) {
        this.f6848a = str;
        this.f6849b = str2;
        this.f6850c = i;
        this.f6851d = j4;
    }
}
