package F4;

import v2.AbstractC2842h;
import v2.AbstractC2844j;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final N f1621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final N f1622e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f1624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f1625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public N f1626d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public N f1627e;

        public E a() {
            AbstractC2848n.o(this.f1623a, com.amazon.a.a.o.b.f14051c);
            AbstractC2848n.o(this.f1624b, "severity");
            AbstractC2848n.o(this.f1625c, "timestampNanos");
            AbstractC2848n.u(this.f1626d == null || this.f1627e == null, "at least one of channelRef and subchannelRef must be null");
            return new E(this.f1623a, this.f1624b, this.f1625c.longValue(), this.f1626d, this.f1627e);
        }

        public a b(String str) {
            this.f1623a = str;
            return this;
        }

        public a c(b bVar) {
            this.f1624b = bVar;
            return this;
        }

        public a d(N n8) {
            this.f1627e = n8;
            return this;
        }

        public a e(long j8) {
            this.f1625c = Long.valueOf(j8);
            return this;
        }
    }

    public enum b {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    public E(String str, b bVar, long j8, N n8, N n9) {
        this.f1618a = str;
        this.f1619b = (b) AbstractC2848n.o(bVar, "severity");
        this.f1620c = j8;
        this.f1621d = n8;
        this.f1622e = n9;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof E)) {
            return false;
        }
        E e8 = (E) obj;
        return AbstractC2844j.a(this.f1618a, e8.f1618a) && AbstractC2844j.a(this.f1619b, e8.f1619b) && this.f1620c == e8.f1620c && AbstractC2844j.a(this.f1621d, e8.f1621d) && AbstractC2844j.a(this.f1622e, e8.f1622e);
    }

    public int hashCode() {
        return AbstractC2844j.b(this.f1618a, this.f1619b, Long.valueOf(this.f1620c), this.f1621d, this.f1622e);
    }

    public String toString() {
        return AbstractC2842h.b(this).d(com.amazon.a.a.o.b.f14051c, this.f1618a).d("severity", this.f1619b).c("timestampNanos", this.f1620c).d("channelRef", this.f1621d).d("subchannelRef", this.f1622e).toString();
    }
}
