package x7;

import java.util.List;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends f0.e.d.a.b.AbstractC0440e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f24609c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.a.b.AbstractC0440e.AbstractC0441a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f24611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f24612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte f24613d;

        @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0441a
        public f0.e.d.a.b.AbstractC0440e a() {
            String str;
            List list;
            if (this.f24613d == 1 && (str = this.f24610a) != null && (list = this.f24612c) != null) {
                return new r(str, this.f24611b, list);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24610a == null) {
                sb2.append(" name");
            }
            if ((1 & this.f24613d) == 0) {
                sb2.append(" importance");
            }
            if (this.f24612c == null) {
                sb2.append(" frames");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0441a
        public f0.e.d.a.b.AbstractC0440e.AbstractC0441a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f24612c = list;
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0441a
        public f0.e.d.a.b.AbstractC0440e.AbstractC0441a c(int i10) {
            this.f24611b = i10;
            this.f24613d = (byte) (this.f24613d | 1);
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0441a
        public f0.e.d.a.b.AbstractC0440e.AbstractC0441a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f24610a = str;
            return this;
        }
    }

    @Override // x7.f0.e.d.a.b.AbstractC0440e
    public List b() {
        return this.f24609c;
    }

    @Override // x7.f0.e.d.a.b.AbstractC0440e
    public int c() {
        return this.f24608b;
    }

    @Override // x7.f0.e.d.a.b.AbstractC0440e
    public String d() {
        return this.f24607a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.a.b.AbstractC0440e) {
            f0.e.d.a.b.AbstractC0440e abstractC0440e = (f0.e.d.a.b.AbstractC0440e) obj;
            if (this.f24607a.equals(abstractC0440e.d()) && this.f24608b == abstractC0440e.c() && this.f24609c.equals(abstractC0440e.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f24607a.hashCode() ^ 1000003) * 1000003) ^ this.f24608b) * 1000003) ^ this.f24609c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f24607a + ", importance=" + this.f24608b + ", frames=" + this.f24609c + "}";
    }

    public r(String str, int i10, List list) {
        this.f24607a = str;
        this.f24608b = i10;
        this.f24609c = list;
    }
}
