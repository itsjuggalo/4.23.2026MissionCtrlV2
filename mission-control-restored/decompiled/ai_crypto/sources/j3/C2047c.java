package j3;

import F5.J;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: j3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2047c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f17384c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2047c(String sessionId, long j7) {
        this(sessionId, j7, null, 4, null);
        r.f(sessionId, "sessionId");
    }

    public final Map a() {
        return this.f17384c;
    }

    public final String b() {
        return this.f17382a;
    }

    public final long c() {
        return this.f17383b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2047c)) {
            return false;
        }
        C2047c c2047c = (C2047c) obj;
        return r.b(this.f17382a, c2047c.f17382a) && this.f17383b == c2047c.f17383b && r.b(this.f17384c, c2047c.f17384c);
    }

    public int hashCode() {
        return (((this.f17382a.hashCode() * 31) + Long.hashCode(this.f17383b)) * 31) + this.f17384c.hashCode();
    }

    public String toString() {
        return "EventMetadata(sessionId=" + this.f17382a + ", timestamp=" + this.f17383b + ", additionalCustomKeys=" + this.f17384c + ')';
    }

    public C2047c(String sessionId, long j7, Map additionalCustomKeys) {
        r.f(sessionId, "sessionId");
        r.f(additionalCustomKeys, "additionalCustomKeys");
        this.f17382a = sessionId;
        this.f17383b = j7;
        this.f17384c = additionalCustomKeys;
    }

    public /* synthetic */ C2047c(String str, long j7, Map map, int i7, AbstractC2148j abstractC2148j) {
        this(str, j7, (i7 & 4) != 0 ? J.e() : map);
    }
}
