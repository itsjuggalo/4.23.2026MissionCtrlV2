package s2;

import java.util.Map;

/* JADX INFO: renamed from: s2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1000c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f9545c;

    public C1000c(String str, long j4, Map additionalCustomKeys) {
        kotlin.jvm.internal.j.e(additionalCustomKeys, "additionalCustomKeys");
        this.f9543a = str;
        this.f9544b = j4;
        this.f9545c = additionalCustomKeys;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1000c)) {
            return false;
        }
        C1000c c1000c = (C1000c) obj;
        return kotlin.jvm.internal.j.a(this.f9543a, c1000c.f9543a) && this.f9544b == c1000c.f9544b && kotlin.jvm.internal.j.a(this.f9545c, c1000c.f9545c);
    }

    public final int hashCode() {
        return this.f9545c.hashCode() + ((Long.hashCode(this.f9544b) + (this.f9543a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "EventMetadata(sessionId=" + this.f9543a + ", timestamp=" + this.f9544b + ", additionalCustomKeys=" + this.f9545c + ')';
    }
}
