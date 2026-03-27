package M2;

import Q2.k;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f1061a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        return this.f1061a.equals(((b) obj).f1061a);
    }

    public final int hashCode() {
        return this.f1061a.hashCode();
    }
}
