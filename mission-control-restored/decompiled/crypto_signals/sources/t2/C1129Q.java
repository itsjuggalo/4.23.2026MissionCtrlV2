package t2;

import java.util.List;

/* JADX INFO: renamed from: t2.Q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1129Q extends E0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1130S f10012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f10013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f10014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f10015d;
    public final D0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f10016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10017g;

    public C1129Q(C1130S c1130s, List list, List list2, Boolean bool, D0 d02, List list3, int i) {
        this.f10012a = c1130s;
        this.f10013b = list;
        this.f10014c = list2;
        this.f10015d = bool;
        this.e = d02;
        this.f10016f = list3;
        this.f10017g = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof E0)) {
            return false;
        }
        C1129Q c1129q = (C1129Q) ((E0) obj);
        if (!this.f10012a.equals(c1129q.f10012a)) {
            return false;
        }
        List list = this.f10013b;
        if (list == null) {
            if (c1129q.f10013b != null) {
                return false;
            }
        } else if (!list.equals(c1129q.f10013b)) {
            return false;
        }
        List list2 = this.f10014c;
        if (list2 == null) {
            if (c1129q.f10014c != null) {
                return false;
            }
        } else if (!list2.equals(c1129q.f10014c)) {
            return false;
        }
        Boolean bool = this.f10015d;
        if (bool == null) {
            if (c1129q.f10015d != null) {
                return false;
            }
        } else if (!bool.equals(c1129q.f10015d)) {
            return false;
        }
        D0 d02 = this.e;
        if (d02 == null) {
            if (c1129q.e != null) {
                return false;
            }
        } else if (!d02.equals(c1129q.e)) {
            return false;
        }
        List list3 = this.f10016f;
        if (list3 == null) {
            if (c1129q.f10016f != null) {
                return false;
            }
        } else if (!list3.equals(c1129q.f10016f)) {
            return false;
        }
        return this.f10017g == c1129q.f10017g;
    }

    public final int hashCode() {
        int iHashCode = (this.f10012a.hashCode() ^ 1000003) * 1000003;
        List list = this.f10013b;
        int iHashCode2 = (iHashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f10014c;
        int iHashCode3 = (iHashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f10015d;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        D0 d02 = this.e;
        int iHashCode5 = (iHashCode4 ^ (d02 == null ? 0 : d02.hashCode())) * 1000003;
        List list3 = this.f10016f;
        return ((iHashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.f10017g;
    }

    public final String toString() {
        return "Application{execution=" + this.f10012a + ", customAttributes=" + this.f10013b + ", internalKeys=" + this.f10014c + ", background=" + this.f10015d + ", currentProcessDetails=" + this.e + ", appProcessDetails=" + this.f10016f + ", uiOrientation=" + this.f10017g + "}";
    }
}
