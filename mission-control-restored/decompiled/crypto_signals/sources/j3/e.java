package j3;

import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7760a;

    public e(String sessionId) {
        j.e(sessionId, "sessionId");
        this.f7760a = sessionId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && j.a(this.f7760a, ((e) obj).f7760a);
    }

    public final int hashCode() {
        return this.f7760a.hashCode();
    }

    public final String toString() {
        return "SessionDetails(sessionId=" + this.f7760a + ')';
    }
}
