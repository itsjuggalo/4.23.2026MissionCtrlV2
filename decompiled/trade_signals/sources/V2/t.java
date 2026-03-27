package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class t extends F.e.d.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8870d;

    public static final class b extends F.e.d.a.c.AbstractC0136a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8874d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f8875e;

        @Override // V2.F.e.d.a.c.AbstractC0136a
        public F.e.d.a.c a() {
            String str;
            if (this.f8875e == 7 && (str = this.f8871a) != null) {
                return new t(str, this.f8872b, this.f8873c, this.f8874d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8871a == null) {
                sb.append(" processName");
            }
            if ((this.f8875e & 1) == 0) {
                sb.append(" pid");
            }
            if ((this.f8875e & 2) == 0) {
                sb.append(" importance");
            }
            if ((this.f8875e & 4) == 0) {
                sb.append(" defaultProcess");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.a.c.AbstractC0136a
        public F.e.d.a.c.AbstractC0136a b(boolean z7) {
            this.f8874d = z7;
            this.f8875e = (byte) (this.f8875e | 4);
            return this;
        }

        @Override // V2.F.e.d.a.c.AbstractC0136a
        public F.e.d.a.c.AbstractC0136a c(int i8) {
            this.f8873c = i8;
            this.f8875e = (byte) (this.f8875e | 2);
            return this;
        }

        @Override // V2.F.e.d.a.c.AbstractC0136a
        public F.e.d.a.c.AbstractC0136a d(int i8) {
            this.f8872b = i8;
            this.f8875e = (byte) (this.f8875e | 1);
            return this;
        }

        @Override // V2.F.e.d.a.c.AbstractC0136a
        public F.e.d.a.c.AbstractC0136a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f8871a = str;
            return this;
        }
    }

    public t(String str, int i8, int i9, boolean z7) {
        this.f8867a = str;
        this.f8868b = i8;
        this.f8869c = i9;
        this.f8870d = z7;
    }

    @Override // V2.F.e.d.a.c
    public int b() {
        return this.f8869c;
    }

    @Override // V2.F.e.d.a.c
    public int c() {
        return this.f8868b;
    }

    @Override // V2.F.e.d.a.c
    public String d() {
        return this.f8867a;
    }

    @Override // V2.F.e.d.a.c
    public boolean e() {
        return this.f8870d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d.a.c)) {
            return false;
        }
        F.e.d.a.c cVar = (F.e.d.a.c) obj;
        return this.f8867a.equals(cVar.d()) && this.f8868b == cVar.c() && this.f8869c == cVar.b() && this.f8870d == cVar.e();
    }

    public int hashCode() {
        return ((((((this.f8867a.hashCode() ^ 1000003) * 1000003) ^ this.f8868b) * 1000003) ^ this.f8869c) * 1000003) ^ (this.f8870d ? 1231 : 1237);
    }

    public String toString() {
        return "ProcessDetails{processName=" + this.f8867a + ", pid=" + this.f8868b + ", importance=" + this.f8869c + ", defaultProcess=" + this.f8870d + "}";
    }
}
