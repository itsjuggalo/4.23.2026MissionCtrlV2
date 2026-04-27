package I2;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class f extends t implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f2957a;

    public f(Comparator comparator) {
        this.f2957a = (Comparator) H2.m.n(comparator);
    }

    @Override // I2.t, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f2957a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return this.f2957a.equals(((f) obj).f2957a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2957a.hashCode();
    }

    public String toString() {
        return this.f2957a.toString();
    }
}
