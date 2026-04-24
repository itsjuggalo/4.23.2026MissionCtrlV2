package t2;

import s3.AbstractC1024h;

/* JADX INFO: renamed from: t2.T, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1131T extends x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10025d;

    public C1131T(long j4, long j6, String str, String str2) {
        this.f10022a = j4;
        this.f10023b = j6;
        this.f10024c = str;
        this.f10025d = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x0) {
            x0 x0Var = (x0) obj;
            if (this.f10022a == ((C1131T) x0Var).f10022a) {
                C1131T c1131t = (C1131T) x0Var;
                if (this.f10023b == c1131t.f10023b && this.f10024c.equals(c1131t.f10024c)) {
                    String str = c1131t.f10025d;
                    String str2 = this.f10025d;
                    if (str2 != null ? str2.equals(str) : str == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f10022a;
        long j6 = this.f10023b;
        int iHashCode = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003) ^ this.f10024c.hashCode()) * 1000003;
        String str = this.f10025d;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BinaryImage{baseAddress=");
        sb.append(this.f10022a);
        sb.append(", size=");
        sb.append(this.f10023b);
        sb.append(", name=");
        sb.append(this.f10024c);
        sb.append(", uuid=");
        return AbstractC1024h.d(sb, this.f10025d, "}");
    }
}
