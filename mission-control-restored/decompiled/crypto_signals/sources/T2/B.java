package T2;

import com.google.protobuf.AbstractC0472l;

/* JADX INFO: loaded from: classes.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0472l f2897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final A2.e f2899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final A2.e f2900d;
    public final A2.e e;

    public B(AbstractC0472l abstractC0472l, boolean z6, A2.e eVar, A2.e eVar2, A2.e eVar3) {
        this.f2897a = abstractC0472l;
        this.f2898b = z6;
        this.f2899c = eVar;
        this.f2900d = eVar2;
        this.e = eVar3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || B.class != obj.getClass()) {
            return false;
        }
        B b3 = (B) obj;
        if (this.f2898b == b3.f2898b && this.f2897a.equals(b3.f2897a) && this.f2899c.equals(b3.f2899c) && this.f2900d.equals(b3.f2900d)) {
            return this.e.equals(b3.e);
        }
        return false;
    }

    public final int hashCode() {
        return this.e.f51a.hashCode() + ((this.f2900d.f51a.hashCode() + ((this.f2899c.f51a.hashCode() + (((this.f2897a.hashCode() * 31) + (this.f2898b ? 1 : 0)) * 31)) * 31)) * 31);
    }
}
