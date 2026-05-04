package cd;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3883c;

    public v(Object obj, Object obj2, Object obj3) {
        this.f3881a = obj;
        this.f3882b = obj2;
        this.f3883c = obj3;
    }

    public final Object a() {
        return this.f3881a;
    }

    public final Object b() {
        return this.f3882b;
    }

    public final Object c() {
        return this.f3883c;
    }

    public final Object d() {
        return this.f3883c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return kotlin.jvm.internal.t.b(this.f3881a, vVar.f3881a) && kotlin.jvm.internal.t.b(this.f3882b, vVar.f3882b) && kotlin.jvm.internal.t.b(this.f3883c, vVar.f3883c);
    }

    public int hashCode() {
        Object obj = this.f3881a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f3882b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f3883c;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f3881a + ", " + this.f3882b + ", " + this.f3883c + ')';
    }
}
