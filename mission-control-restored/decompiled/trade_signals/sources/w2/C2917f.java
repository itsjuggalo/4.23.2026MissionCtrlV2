package w2;

import java.io.Serializable;
import java.util.Comparator;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: w2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2917f extends t implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f24005a;

    public C2917f(Comparator comparator) {
        this.f24005a = (Comparator) AbstractC2848n.n(comparator);
    }

    @Override // w2.t, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f24005a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2917f) {
            return this.f24005a.equals(((C2917f) obj).f24005a);
        }
        return false;
    }

    public int hashCode() {
        return this.f24005a.hashCode();
    }

    public String toString() {
        return this.f24005a.toString();
    }
}
