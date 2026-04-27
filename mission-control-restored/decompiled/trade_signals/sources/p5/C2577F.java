package p5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p5.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2577F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f22366b;

    public C2577F(int i8, Object obj) {
        this.f22365a = i8;
        this.f22366b = obj;
    }

    public final int a() {
        return this.f22365a;
    }

    public final Object b() {
        return this.f22366b;
    }

    public final int c() {
        return this.f22365a;
    }

    public final Object d() {
        return this.f22366b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2577F)) {
            return false;
        }
        C2577F c2577f = (C2577F) obj;
        return this.f22365a == c2577f.f22365a && AbstractC2304t.b(this.f22366b, c2577f.f22366b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f22365a) * 31;
        Object obj = this.f22366b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f22365a + ", value=" + this.f22366b + ')';
    }
}
