package M2;

import Q2.n;

/* JADX INFO: loaded from: classes.dex */
public final class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f1084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f1085c;

    public i(String str, h hVar, n nVar) {
        this.f1083a = str;
        this.f1084b = hVar;
        this.f1085c = nVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f1083a.equals(iVar.f1083a) && this.f1084b.equals(iVar.f1084b)) {
            return this.f1085c.equals(iVar.f1085c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1085c.f2688a.hashCode() + ((this.f1084b.hashCode() + (this.f1083a.hashCode() * 31)) * 31);
    }
}
