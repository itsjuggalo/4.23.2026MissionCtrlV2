package t2;

import java.util.List;

/* JADX INFO: renamed from: t2.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1116D extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9946d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f9947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f9948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f9949h;
    public final List i;

    public C1116D(int i, String str, int i6, int i7, long j4, long j6, long j7, String str2, List list) {
        this.f9943a = i;
        this.f9944b = str;
        this.f9945c = i6;
        this.f9946d = i7;
        this.e = j4;
        this.f9947f = j6;
        this.f9948g = j7;
        this.f9949h = str2;
        this.i = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q0) {
            q0 q0Var = (q0) obj;
            if (this.f9943a == ((C1116D) q0Var).f9943a) {
                C1116D c1116d = (C1116D) q0Var;
                if (this.f9944b.equals(c1116d.f9944b) && this.f9945c == c1116d.f9945c && this.f9946d == c1116d.f9946d && this.e == c1116d.e && this.f9947f == c1116d.f9947f && this.f9948g == c1116d.f9948g) {
                    String str = c1116d.f9949h;
                    String str2 = this.f9949h;
                    if (str2 != null ? str2.equals(str) : str == null) {
                        List list = c1116d.i;
                        List list2 = this.i;
                        if (list2 != null ? list2.equals(list) : list == null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f9943a ^ 1000003) * 1000003) ^ this.f9944b.hashCode()) * 1000003) ^ this.f9945c) * 1000003) ^ this.f9946d) * 1000003;
        long j4 = this.e;
        int i = (iHashCode ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j6 = this.f9947f;
        int i6 = (i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        long j7 = this.f9948g;
        int i7 = (i6 ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        String str = this.f9949h;
        int iHashCode2 = (i7 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.i;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "ApplicationExitInfo{pid=" + this.f9943a + ", processName=" + this.f9944b + ", reasonCode=" + this.f9945c + ", importance=" + this.f9946d + ", pss=" + this.e + ", rss=" + this.f9947f + ", timestamp=" + this.f9948g + ", traceFile=" + this.f9949h + ", buildIdMappingForArch=" + this.i + "}";
    }
}
