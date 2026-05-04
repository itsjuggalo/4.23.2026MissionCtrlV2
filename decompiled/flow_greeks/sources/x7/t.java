package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends f0.e.d.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f24628d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.a.c.AbstractC0444a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f24630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f24632d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f24633e;

        @Override // x7.f0.e.d.a.c.AbstractC0444a
        public f0.e.d.a.c a() {
            String str;
            if (this.f24633e == 7 && (str = this.f24629a) != null) {
                return new t(str, this.f24630b, this.f24631c, this.f24632d);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24629a == null) {
                sb2.append(" processName");
            }
            if ((this.f24633e & 1) == 0) {
                sb2.append(" pid");
            }
            if ((this.f24633e & 2) == 0) {
                sb2.append(" importance");
            }
            if ((this.f24633e & 4) == 0) {
                sb2.append(" defaultProcess");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.a.c.AbstractC0444a
        public f0.e.d.a.c.AbstractC0444a b(boolean z10) {
            this.f24632d = z10;
            this.f24633e = (byte) (this.f24633e | 4);
            return this;
        }

        @Override // x7.f0.e.d.a.c.AbstractC0444a
        public f0.e.d.a.c.AbstractC0444a c(int i10) {
            this.f24631c = i10;
            this.f24633e = (byte) (this.f24633e | 2);
            return this;
        }

        @Override // x7.f0.e.d.a.c.AbstractC0444a
        public f0.e.d.a.c.AbstractC0444a d(int i10) {
            this.f24630b = i10;
            this.f24633e = (byte) (this.f24633e | 1);
            return this;
        }

        @Override // x7.f0.e.d.a.c.AbstractC0444a
        public f0.e.d.a.c.AbstractC0444a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f24629a = str;
            return this;
        }
    }

    @Override // x7.f0.e.d.a.c
    public int b() {
        return this.f24627c;
    }

    @Override // x7.f0.e.d.a.c
    public int c() {
        return this.f24626b;
    }

    @Override // x7.f0.e.d.a.c
    public String d() {
        return this.f24625a;
    }

    @Override // x7.f0.e.d.a.c
    public boolean e() {
        return this.f24628d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.a.c) {
            f0.e.d.a.c cVar = (f0.e.d.a.c) obj;
            if (this.f24625a.equals(cVar.d()) && this.f24626b == cVar.c() && this.f24627c == cVar.b() && this.f24628d == cVar.e()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f24625a.hashCode() ^ 1000003) * 1000003) ^ this.f24626b) * 1000003) ^ this.f24627c) * 1000003) ^ (this.f24628d ? 1231 : 1237);
    }

    public String toString() {
        return "ProcessDetails{processName=" + this.f24625a + ", pid=" + this.f24626b + ", importance=" + this.f24627c + ", defaultProcess=" + this.f24628d + "}";
    }

    public t(String str, int i10, int i11, boolean z10) {
        this.f24625a = str;
        this.f24626b = i10;
        this.f24627c = i11;
        this.f24628d = z10;
    }
}
