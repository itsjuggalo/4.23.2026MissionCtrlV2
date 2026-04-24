package K2;

import com.google.protobuf.AbstractC0472l;

/* JADX INFO: renamed from: K2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0057h implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0472l f933a;

    public C0057h(AbstractC0472l abstractC0472l) {
        this.f933a = abstractC0472l;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return U2.r.c(this.f933a, ((C0057h) obj).f933a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0057h) {
            return this.f933a.equals(((C0057h) obj).f933a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f933a.hashCode();
    }

    public final String toString() {
        return "Blob { bytes=" + U2.r.i(this.f933a) + " }";
    }
}
