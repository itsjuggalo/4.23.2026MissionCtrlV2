package a2;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class f extends t implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f6128a;

    public f(Comparator comparator) {
        this.f6128a = (Comparator) Z1.m.n(comparator);
    }

    @Override // a2.t, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f6128a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return this.f6128a.equals(((f) obj).f6128a);
        }
        return false;
    }

    public int hashCode() {
        return this.f6128a.hashCode();
    }

    public String toString() {
        return this.f6128a.toString();
    }
}
