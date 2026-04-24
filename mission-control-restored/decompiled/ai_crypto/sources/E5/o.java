package E5;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1680b;

    public o(Object obj, Object obj2) {
        this.f1679a = obj;
        this.f1680b = obj2;
    }

    public final Object a() {
        return this.f1679a;
    }

    public final Object b() {
        return this.f1680b;
    }

    public final Object c() {
        return this.f1679a;
    }

    public final Object d() {
        return this.f1680b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return kotlin.jvm.internal.r.b(this.f1679a, oVar.f1679a) && kotlin.jvm.internal.r.b(this.f1680b, oVar.f1680b);
    }

    public int hashCode() {
        Object obj = this.f1679a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f1680b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f1679a + ", " + this.f1680b + ')';
    }
}
