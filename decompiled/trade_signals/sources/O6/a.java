package O6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6240b;

    public a(Object obj, Object obj2) {
        this.f6239a = obj;
        this.f6240b = obj2;
    }

    public final Object a() {
        return this.f6239a;
    }

    public final Object b() {
        return this.f6240b;
    }

    public final Object c() {
        return this.f6239a;
    }

    public final Object d() {
        return this.f6240b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return AbstractC2304t.b(this.f6239a, aVar.f6239a) && AbstractC2304t.b(this.f6240b, aVar.f6240b);
    }

    public int hashCode() {
        Object obj = this.f6239a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f6240b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.f6239a + ", upper=" + this.f6240b + ')';
    }
}
