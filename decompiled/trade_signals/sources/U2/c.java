package U2;

import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.M;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f8106c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(String sessionId, long j8) {
        this(sessionId, j8, null, 4, null);
        AbstractC2304t.f(sessionId, "sessionId");
    }

    public final Map a() {
        return this.f8106c;
    }

    public final String b() {
        return this.f8104a;
    }

    public final long c() {
        return this.f8105b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return AbstractC2304t.b(this.f8104a, cVar.f8104a) && this.f8105b == cVar.f8105b && AbstractC2304t.b(this.f8106c, cVar.f8106c);
    }

    public int hashCode() {
        return (((this.f8104a.hashCode() * 31) + Long.hashCode(this.f8105b)) * 31) + this.f8106c.hashCode();
    }

    public String toString() {
        return "EventMetadata(sessionId=" + this.f8104a + ", timestamp=" + this.f8105b + ", additionalCustomKeys=" + this.f8106c + ')';
    }

    public c(String sessionId, long j8, Map additionalCustomKeys) {
        AbstractC2304t.f(sessionId, "sessionId");
        AbstractC2304t.f(additionalCustomKeys, "additionalCustomKeys");
        this.f8104a = sessionId;
        this.f8105b = j8;
        this.f8106c = additionalCustomKeys;
    }

    public /* synthetic */ c(String str, long j8, Map map, int i8, AbstractC2296k abstractC2296k) {
        this(str, j8, (i8 & 4) != 0 ? M.h() : map);
    }
}
