package o5;

import java.io.Serializable;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f21994c;

    public v(Object obj, Object obj2, Object obj3) {
        this.f21992a = obj;
        this.f21993b = obj2;
        this.f21994c = obj3;
    }

    public final Object a() {
        return this.f21992a;
    }

    public final Object b() {
        return this.f21993b;
    }

    public final Object c() {
        return this.f21994c;
    }

    public final Object d() {
        return this.f21994c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return AbstractC2304t.b(this.f21992a, vVar.f21992a) && AbstractC2304t.b(this.f21993b, vVar.f21993b) && AbstractC2304t.b(this.f21994c, vVar.f21994c);
    }

    public int hashCode() {
        Object obj = this.f21992a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f21993b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f21994c;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f21992a + ", " + this.f21993b + ", " + this.f21994c + ')';
    }
}
