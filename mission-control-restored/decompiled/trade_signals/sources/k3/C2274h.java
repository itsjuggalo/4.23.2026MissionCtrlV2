package k3;

import h3.C1875k;
import h3.p;

/* JADX INFO: renamed from: k3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2274h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f20373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C1875k f20374b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2274h.class != obj.getClass()) {
            return false;
        }
        C2274h c2274h = (C2274h) obj;
        if (this.f20373a.equals(c2274h.f20373a)) {
            return this.f20374b.equals(c2274h.f20374b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f20373a.hashCode() * 31) + this.f20374b.hashCode();
    }
}
