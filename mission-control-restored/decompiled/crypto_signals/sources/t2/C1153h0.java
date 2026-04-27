package t2;

import java.util.List;

/* JADX INFO: renamed from: t2.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1153h0 extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10115a;

    public C1153h0(List list) {
        this.f10115a = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof J0)) {
            return false;
        }
        return this.f10115a.equals(((C1153h0) ((J0) obj)).f10115a);
    }

    public final int hashCode() {
        return this.f10115a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f10115a + "}";
    }
}
