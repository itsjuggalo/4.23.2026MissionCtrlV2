package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2095t extends AbstractC2074F.e.d.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17949d;

    /* JADX INFO: renamed from: k3.t$b */
    public static final class b extends AbstractC2074F.e.d.a.c.AbstractC0283a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f17952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f17953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f17954e;

        @Override // k3.AbstractC2074F.e.d.a.c.AbstractC0283a
        public AbstractC2074F.e.d.a.c a() {
            String str;
            if (this.f17954e == 7 && (str = this.f17950a) != null) {
                return new C2095t(str, this.f17951b, this.f17952c, this.f17953d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17950a == null) {
                sb.append(" processName");
            }
            if ((this.f17954e & 1) == 0) {
                sb.append(" pid");
            }
            if ((this.f17954e & 2) == 0) {
                sb.append(" importance");
            }
            if ((this.f17954e & 4) == 0) {
                sb.append(" defaultProcess");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.a.c.AbstractC0283a
        public AbstractC2074F.e.d.a.c.AbstractC0283a b(boolean z7) {
            this.f17953d = z7;
            this.f17954e = (byte) (this.f17954e | 4);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.c.AbstractC0283a
        public AbstractC2074F.e.d.a.c.AbstractC0283a c(int i7) {
            this.f17952c = i7;
            this.f17954e = (byte) (this.f17954e | 2);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.c.AbstractC0283a
        public AbstractC2074F.e.d.a.c.AbstractC0283a d(int i7) {
            this.f17951b = i7;
            this.f17954e = (byte) (this.f17954e | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.c.AbstractC0283a
        public AbstractC2074F.e.d.a.c.AbstractC0283a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f17950a = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.a.c
    public int b() {
        return this.f17948c;
    }

    @Override // k3.AbstractC2074F.e.d.a.c
    public int c() {
        return this.f17947b;
    }

    @Override // k3.AbstractC2074F.e.d.a.c
    public String d() {
        return this.f17946a;
    }

    @Override // k3.AbstractC2074F.e.d.a.c
    public boolean e() {
        return this.f17949d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d.a.c)) {
            return false;
        }
        AbstractC2074F.e.d.a.c cVar = (AbstractC2074F.e.d.a.c) obj;
        return this.f17946a.equals(cVar.d()) && this.f17947b == cVar.c() && this.f17948c == cVar.b() && this.f17949d == cVar.e();
    }

    public int hashCode() {
        return ((((((this.f17946a.hashCode() ^ 1000003) * 1000003) ^ this.f17947b) * 1000003) ^ this.f17948c) * 1000003) ^ (this.f17949d ? 1231 : 1237);
    }

    public String toString() {
        return "ProcessDetails{processName=" + this.f17946a + ", pid=" + this.f17947b + ", importance=" + this.f17948c + ", defaultProcess=" + this.f17949d + "}";
    }

    public C2095t(String str, int i7, int i8, boolean z7) {
        this.f17946a = str;
        this.f17947b = i7;
        this.f17948c = i8;
        this.f17949d = z7;
    }
}
