package W2;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5486b;

    public o(Object obj, Object obj2) {
        this.f5485a = obj;
        this.f5486b = obj2;
    }

    public final Object a() {
        return this.f5485a;
    }

    public final Object b() {
        return this.f5486b;
    }

    public final Object c() {
        return this.f5485a;
    }

    public final Object d() {
        return this.f5486b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return kotlin.jvm.internal.r.b(this.f5485a, oVar.f5485a) && kotlin.jvm.internal.r.b(this.f5486b, oVar.f5486b);
    }

    public int hashCode() {
        Object obj = this.f5485a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f5486b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f5485a + ", " + this.f5486b + ')';
    }
}
