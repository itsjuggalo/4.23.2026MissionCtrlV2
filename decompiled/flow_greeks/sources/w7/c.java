package w7;

import dd.o0;
import java.util.Map;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f23691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f23692c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(String sessionId, long j10) {
        this(sessionId, j10, null, 4, null);
        t.f(sessionId, "sessionId");
    }

    public final Map a() {
        return this.f23692c;
    }

    public final String b() {
        return this.f23690a;
    }

    public final long c() {
        return this.f23691b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return t.b(this.f23690a, cVar.f23690a) && this.f23691b == cVar.f23691b && t.b(this.f23692c, cVar.f23692c);
    }

    public int hashCode() {
        return (((this.f23690a.hashCode() * 31) + Long.hashCode(this.f23691b)) * 31) + this.f23692c.hashCode();
    }

    public String toString() {
        return "EventMetadata(sessionId=" + this.f23690a + ", timestamp=" + this.f23691b + ", additionalCustomKeys=" + this.f23692c + ')';
    }

    public c(String sessionId, long j10, Map additionalCustomKeys) {
        t.f(sessionId, "sessionId");
        t.f(additionalCustomKeys, "additionalCustomKeys");
        this.f23690a = sessionId;
        this.f23691b = j10;
        this.f23692c = additionalCustomKeys;
    }

    public /* synthetic */ c(String str, long j10, Map map, int i10, kotlin.jvm.internal.k kVar) {
        this(str, j10, (i10 & 4) != 0 ? o0.h() : map);
    }
}
