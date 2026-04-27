package t2;

import java.util.List;

/* JADX INFO: renamed from: t2.J, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1122J extends N0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9973d;
    public final Long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f9974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C1123K f9975g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C1159k0 f9976h;
    public final C1157j0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C1126N f9977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f9978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f9979l;

    public C1122J(String str, String str2, String str3, long j4, Long l6, boolean z6, C1123K c1123k, C1159k0 c1159k0, C1157j0 c1157j0, C1126N c1126n, List list, int i) {
        this.f9970a = str;
        this.f9971b = str2;
        this.f9972c = str3;
        this.f9973d = j4;
        this.e = l6;
        this.f9974f = z6;
        this.f9975g = c1123k;
        this.f9976h = c1159k0;
        this.i = c1157j0;
        this.f9977j = c1126n;
        this.f9978k = list;
        this.f9979l = i;
    }

    public final C1121I a() {
        C1121I c1121i = new C1121I();
        c1121i.f9959a = this.f9970a;
        c1121i.f9960b = this.f9971b;
        c1121i.f9961c = this.f9972c;
        c1121i.f9962d = this.f9973d;
        c1121i.e = this.e;
        c1121i.f9963f = this.f9974f;
        c1121i.f9964g = this.f9975g;
        c1121i.f9965h = this.f9976h;
        c1121i.i = this.i;
        c1121i.f9966j = this.f9977j;
        c1121i.f9967k = this.f9978k;
        c1121i.f9968l = this.f9979l;
        c1121i.f9969m = (byte) 7;
        return c1121i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof N0)) {
            return false;
        }
        C1122J c1122j = (C1122J) ((N0) obj);
        if (!this.f9970a.equals(c1122j.f9970a)) {
            return false;
        }
        if (!this.f9971b.equals(c1122j.f9971b)) {
            return false;
        }
        String str = c1122j.f9972c;
        String str2 = this.f9972c;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (this.f9973d != c1122j.f9973d) {
            return false;
        }
        Long l6 = c1122j.e;
        Long l7 = this.e;
        if (l7 == null) {
            if (l6 != null) {
                return false;
            }
        } else if (!l7.equals(l6)) {
            return false;
        }
        if (this.f9974f != c1122j.f9974f || !this.f9975g.equals(c1122j.f9975g)) {
            return false;
        }
        C1159k0 c1159k0 = c1122j.f9976h;
        C1159k0 c1159k02 = this.f9976h;
        if (c1159k02 == null) {
            if (c1159k0 != null) {
                return false;
            }
        } else if (!c1159k02.equals(c1159k0)) {
            return false;
        }
        C1157j0 c1157j0 = c1122j.i;
        C1157j0 c1157j02 = this.i;
        if (c1157j02 == null) {
            if (c1157j0 != null) {
                return false;
            }
        } else if (!c1157j02.equals(c1157j0)) {
            return false;
        }
        C1126N c1126n = c1122j.f9977j;
        C1126N c1126n2 = this.f9977j;
        if (c1126n2 == null) {
            if (c1126n != null) {
                return false;
            }
        } else if (!c1126n2.equals(c1126n)) {
            return false;
        }
        List list = c1122j.f9978k;
        List list2 = this.f9978k;
        if (list2 == null) {
            if (list != null) {
                return false;
            }
        } else if (!list2.equals(list)) {
            return false;
        }
        return this.f9979l == c1122j.f9979l;
    }

    public final int hashCode() {
        int iHashCode = (((this.f9970a.hashCode() ^ 1000003) * 1000003) ^ this.f9971b.hashCode()) * 1000003;
        String str = this.f9972c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j4 = this.f9973d;
        int i = (iHashCode2 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        Long l6 = this.e;
        int iHashCode3 = (((((i ^ (l6 == null ? 0 : l6.hashCode())) * 1000003) ^ (this.f9974f ? 1231 : 1237)) * 1000003) ^ this.f9975g.hashCode()) * 1000003;
        C1159k0 c1159k0 = this.f9976h;
        int iHashCode4 = (iHashCode3 ^ (c1159k0 == null ? 0 : c1159k0.hashCode())) * 1000003;
        C1157j0 c1157j0 = this.i;
        int iHashCode5 = (iHashCode4 ^ (c1157j0 == null ? 0 : c1157j0.hashCode())) * 1000003;
        C1126N c1126n = this.f9977j;
        int iHashCode6 = (iHashCode5 ^ (c1126n == null ? 0 : c1126n.hashCode())) * 1000003;
        List list = this.f9978k;
        return ((iHashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f9979l;
    }

    public final String toString() {
        return "Session{generator=" + this.f9970a + ", identifier=" + this.f9971b + ", appQualitySessionId=" + this.f9972c + ", startedAt=" + this.f9973d + ", endedAt=" + this.e + ", crashed=" + this.f9974f + ", app=" + this.f9975g + ", user=" + this.f9976h + ", os=" + this.i + ", device=" + this.f9977j + ", events=" + this.f9978k + ", generatorType=" + this.f9979l + "}";
    }
}
