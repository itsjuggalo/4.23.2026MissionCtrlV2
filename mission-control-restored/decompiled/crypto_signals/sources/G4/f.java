package G4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f530b;

    public f(Object obj, Object obj2) {
        this.f529a = obj;
        this.f530b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.j.a(this.f529a, fVar.f529a) && kotlin.jvm.internal.j.a(this.f530b, fVar.f530b);
    }

    public final int hashCode() {
        Object obj = this.f529a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f530b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f529a + ", " + this.f530b + ')';
    }
}
