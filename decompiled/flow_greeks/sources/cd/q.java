package cd;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3869b;

    public q(Object obj, Object obj2) {
        this.f3868a = obj;
        this.f3869b = obj2;
    }

    public final Object a() {
        return this.f3868a;
    }

    public final Object b() {
        return this.f3869b;
    }

    public final Object c() {
        return this.f3868a;
    }

    public final Object d() {
        return this.f3869b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return kotlin.jvm.internal.t.b(this.f3868a, qVar.f3868a) && kotlin.jvm.internal.t.b(this.f3869b, qVar.f3869b);
    }

    public int hashCode() {
        Object obj = this.f3868a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f3869b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f3868a + ", " + this.f3869b + ')';
    }
}
