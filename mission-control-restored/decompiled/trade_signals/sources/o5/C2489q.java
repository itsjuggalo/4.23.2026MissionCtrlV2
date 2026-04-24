package o5;

import java.io.Serializable;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o5.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2489q implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21980b;

    public C2489q(Object obj, Object obj2) {
        this.f21979a = obj;
        this.f21980b = obj2;
    }

    public final Object a() {
        return this.f21979a;
    }

    public final Object b() {
        return this.f21980b;
    }

    public final Object c() {
        return this.f21979a;
    }

    public final Object d() {
        return this.f21980b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2489q)) {
            return false;
        }
        C2489q c2489q = (C2489q) obj;
        return AbstractC2304t.b(this.f21979a, c2489q.f21979a) && AbstractC2304t.b(this.f21980b, c2489q.f21980b);
    }

    public int hashCode() {
        Object obj = this.f21979a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f21980b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f21979a + ", " + this.f21980b + ')';
    }
}
