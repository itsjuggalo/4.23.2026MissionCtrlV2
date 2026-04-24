package t2;

/* JADX INFO: renamed from: t2.P, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1128P extends K0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1129Q f10009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1143c0 f10010d;
    public final C1145d0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1153h0 f10011f;

    public C1128P(long j4, String str, C1129Q c1129q, C1143c0 c1143c0, C1145d0 c1145d0, C1153h0 c1153h0) {
        this.f10007a = j4;
        this.f10008b = str;
        this.f10009c = c1129q;
        this.f10010d = c1143c0;
        this.e = c1145d0;
        this.f10011f = c1153h0;
    }

    public final C1127O a() {
        C1127O c1127o = new C1127O();
        c1127o.f10000a = this.f10007a;
        c1127o.f10001b = this.f10008b;
        c1127o.f10002c = this.f10009c;
        c1127o.f10003d = this.f10010d;
        c1127o.e = this.e;
        c1127o.f10004f = this.f10011f;
        c1127o.f10005g = (byte) 1;
        return c1127o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof K0)) {
            return false;
        }
        C1128P c1128p = (C1128P) ((K0) obj);
        if (this.f10007a != c1128p.f10007a) {
            return false;
        }
        if (!this.f10008b.equals(c1128p.f10008b) || !this.f10009c.equals(c1128p.f10009c) || !this.f10010d.equals(c1128p.f10010d)) {
            return false;
        }
        C1145d0 c1145d0 = c1128p.e;
        C1145d0 c1145d02 = this.e;
        if (c1145d02 == null) {
            if (c1145d0 != null) {
                return false;
            }
        } else if (!c1145d02.equals(c1145d0)) {
            return false;
        }
        C1153h0 c1153h0 = c1128p.f10011f;
        C1153h0 c1153h02 = this.f10011f;
        return c1153h02 == null ? c1153h0 == null : c1153h02.equals(c1153h0);
    }

    public final int hashCode() {
        long j4 = this.f10007a;
        int iHashCode = (((((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f10008b.hashCode()) * 1000003) ^ this.f10009c.hashCode()) * 1000003) ^ this.f10010d.hashCode()) * 1000003;
        C1145d0 c1145d0 = this.e;
        int iHashCode2 = (iHashCode ^ (c1145d0 == null ? 0 : c1145d0.hashCode())) * 1000003;
        C1153h0 c1153h0 = this.f10011f;
        return iHashCode2 ^ (c1153h0 != null ? c1153h0.hashCode() : 0);
    }

    public final String toString() {
        return "Event{timestamp=" + this.f10007a + ", type=" + this.f10008b + ", app=" + this.f10009c + ", device=" + this.f10010d + ", log=" + this.e + ", rollouts=" + this.f10011f + "}";
    }
}
