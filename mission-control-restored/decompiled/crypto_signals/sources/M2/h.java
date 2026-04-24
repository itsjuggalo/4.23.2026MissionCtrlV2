package M2;

import N2.K;

/* JADX INFO: loaded from: classes.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K f1081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1082b;

    public h(K k6, int i) {
        this.f1081a = k6;
        this.f1082b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f1081a.equals(hVar.f1081a) && this.f1082b == hVar.f1082b;
    }

    public final int hashCode() {
        return S.i.c(this.f1082b) + (this.f1081a.hashCode() * 31);
    }
}
