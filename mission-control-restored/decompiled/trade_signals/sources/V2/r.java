package V2;

import V2.F;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class r extends F.e.d.a.b.AbstractC0132e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f8851c;

    public static final class b extends F.e.d.a.b.AbstractC0132e.AbstractC0133a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f8854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte f8855d;

        @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0133a
        public F.e.d.a.b.AbstractC0132e a() {
            String str;
            List list;
            if (this.f8855d == 1 && (str = this.f8852a) != null && (list = this.f8854c) != null) {
                return new r(str, this.f8853b, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8852a == null) {
                sb.append(" name");
            }
            if ((1 & this.f8855d) == 0) {
                sb.append(" importance");
            }
            if (this.f8854c == null) {
                sb.append(" frames");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0133a
        public F.e.d.a.b.AbstractC0132e.AbstractC0133a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f8854c = list;
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0133a
        public F.e.d.a.b.AbstractC0132e.AbstractC0133a c(int i8) {
            this.f8853b = i8;
            this.f8855d = (byte) (this.f8855d | 1);
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0133a
        public F.e.d.a.b.AbstractC0132e.AbstractC0133a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f8852a = str;
            return this;
        }
    }

    public r(String str, int i8, List list) {
        this.f8849a = str;
        this.f8850b = i8;
        this.f8851c = list;
    }

    @Override // V2.F.e.d.a.b.AbstractC0132e
    public List b() {
        return this.f8851c;
    }

    @Override // V2.F.e.d.a.b.AbstractC0132e
    public int c() {
        return this.f8850b;
    }

    @Override // V2.F.e.d.a.b.AbstractC0132e
    public String d() {
        return this.f8849a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d.a.b.AbstractC0132e)) {
            return false;
        }
        F.e.d.a.b.AbstractC0132e abstractC0132e = (F.e.d.a.b.AbstractC0132e) obj;
        return this.f8849a.equals(abstractC0132e.d()) && this.f8850b == abstractC0132e.c() && this.f8851c.equals(abstractC0132e.b());
    }

    public int hashCode() {
        return ((((this.f8849a.hashCode() ^ 1000003) * 1000003) ^ this.f8850b) * 1000003) ^ this.f8851c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f8849a + ", importance=" + this.f8850b + ", frames=" + this.f8851c + "}";
    }
}
