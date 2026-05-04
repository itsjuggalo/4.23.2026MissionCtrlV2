package dg;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8114b;

    public a(Object obj, Object obj2) {
        this.f8113a = obj;
        this.f8114b = obj2;
    }

    public final Object a() {
        return this.f8113a;
    }

    public final Object b() {
        return this.f8114b;
    }

    public final Object c() {
        return this.f8113a;
    }

    public final Object d() {
        return this.f8114b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return t.b(this.f8113a, aVar.f8113a) && t.b(this.f8114b, aVar.f8114b);
    }

    public int hashCode() {
        Object obj = this.f8113a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f8114b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.f8113a + ", upper=" + this.f8114b + ')';
    }
}
