package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2098w extends AbstractC2074F.e.d.AbstractC0285e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2074F.e.d.AbstractC0285e.b f17970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17973d;

    /* JADX INFO: renamed from: k3.w$b */
    public static final class b extends AbstractC2074F.e.d.AbstractC0285e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractC2074F.e.d.AbstractC0285e.b f17974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f17977d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f17978e;

        @Override // k3.AbstractC2074F.e.d.AbstractC0285e.a
        public AbstractC2074F.e.d.AbstractC0285e a() {
            AbstractC2074F.e.d.AbstractC0285e.b bVar;
            String str;
            String str2;
            if (this.f17978e == 1 && (bVar = this.f17974a) != null && (str = this.f17975b) != null && (str2 = this.f17976c) != null) {
                return new C2098w(bVar, str, str2, this.f17977d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17974a == null) {
                sb.append(" rolloutVariant");
            }
            if (this.f17975b == null) {
                sb.append(" parameterKey");
            }
            if (this.f17976c == null) {
                sb.append(" parameterValue");
            }
            if ((1 & this.f17978e) == 0) {
                sb.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.AbstractC0285e.a
        public AbstractC2074F.e.d.AbstractC0285e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f17975b = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.AbstractC0285e.a
        public AbstractC2074F.e.d.AbstractC0285e.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f17976c = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.AbstractC0285e.a
        public AbstractC2074F.e.d.AbstractC0285e.a d(AbstractC2074F.e.d.AbstractC0285e.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null rolloutVariant");
            }
            this.f17974a = bVar;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.AbstractC0285e.a
        public AbstractC2074F.e.d.AbstractC0285e.a e(long j7) {
            this.f17977d = j7;
            this.f17978e = (byte) (this.f17978e | 1);
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.AbstractC0285e
    public String b() {
        return this.f17971b;
    }

    @Override // k3.AbstractC2074F.e.d.AbstractC0285e
    public String c() {
        return this.f17972c;
    }

    @Override // k3.AbstractC2074F.e.d.AbstractC0285e
    public AbstractC2074F.e.d.AbstractC0285e.b d() {
        return this.f17970a;
    }

    @Override // k3.AbstractC2074F.e.d.AbstractC0285e
    public long e() {
        return this.f17973d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d.AbstractC0285e)) {
            return false;
        }
        AbstractC2074F.e.d.AbstractC0285e abstractC0285e = (AbstractC2074F.e.d.AbstractC0285e) obj;
        return this.f17970a.equals(abstractC0285e.d()) && this.f17971b.equals(abstractC0285e.b()) && this.f17972c.equals(abstractC0285e.c()) && this.f17973d == abstractC0285e.e();
    }

    public int hashCode() {
        int iHashCode = (((((this.f17970a.hashCode() ^ 1000003) * 1000003) ^ this.f17971b.hashCode()) * 1000003) ^ this.f17972c.hashCode()) * 1000003;
        long j7 = this.f17973d;
        return iHashCode ^ ((int) (j7 ^ (j7 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutVariant=" + this.f17970a + ", parameterKey=" + this.f17971b + ", parameterValue=" + this.f17972c + ", templateVersion=" + this.f17973d + "}";
    }

    public C2098w(AbstractC2074F.e.d.AbstractC0285e.b bVar, String str, String str2, long j7) {
        this.f17970a = bVar;
        this.f17971b = str;
        this.f17972c = str2;
        this.f17973d = j7;
    }
}
