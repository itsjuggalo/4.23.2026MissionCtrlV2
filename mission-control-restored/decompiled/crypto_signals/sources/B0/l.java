package B0;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f106a;

    public l(List list) {
        this.f106a = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !l.class.equals(obj.getClass())) {
            return false;
        }
        return this.f106a.equals(((l) obj).f106a);
    }

    public final int hashCode() {
        return this.f106a.hashCode();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Iterable, java.lang.Object] */
    public final String toString() {
        return H4.h.h0(this.f106a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", null, 56);
    }
}
