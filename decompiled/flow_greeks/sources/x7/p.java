package x7;

import java.util.List;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends f0.e.d.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f24591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f0.e.d.a.b.c f24592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f24593e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.a.b.c.AbstractC0437a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f24596c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f0.e.d.a.b.c f24597d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f24598e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f24599f;

        @Override // x7.f0.e.d.a.b.c.AbstractC0437a
        public f0.e.d.a.b.c a() {
            String str;
            List list;
            if (this.f24599f == 1 && (str = this.f24594a) != null && (list = this.f24596c) != null) {
                return new p(str, this.f24595b, list, this.f24597d, this.f24598e);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24594a == null) {
                sb2.append(" type");
            }
            if (this.f24596c == null) {
                sb2.append(" frames");
            }
            if ((1 & this.f24599f) == 0) {
                sb2.append(" overflowCount");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.a.b.c.AbstractC0437a
        public f0.e.d.a.b.c.AbstractC0437a b(f0.e.d.a.b.c cVar) {
            this.f24597d = cVar;
            return this;
        }

        @Override // x7.f0.e.d.a.b.c.AbstractC0437a
        public f0.e.d.a.b.c.AbstractC0437a c(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f24596c = list;
            return this;
        }

        @Override // x7.f0.e.d.a.b.c.AbstractC0437a
        public f0.e.d.a.b.c.AbstractC0437a d(int i10) {
            this.f24598e = i10;
            this.f24599f = (byte) (this.f24599f | 1);
            return this;
        }

        @Override // x7.f0.e.d.a.b.c.AbstractC0437a
        public f0.e.d.a.b.c.AbstractC0437a e(String str) {
            this.f24595b = str;
            return this;
        }

        @Override // x7.f0.e.d.a.b.c.AbstractC0437a
        public f0.e.d.a.b.c.AbstractC0437a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f24594a = str;
            return this;
        }
    }

    @Override // x7.f0.e.d.a.b.c
    public f0.e.d.a.b.c b() {
        return this.f24592d;
    }

    @Override // x7.f0.e.d.a.b.c
    public List c() {
        return this.f24591c;
    }

    @Override // x7.f0.e.d.a.b.c
    public int d() {
        return this.f24593e;
    }

    @Override // x7.f0.e.d.a.b.c
    public String e() {
        return this.f24590b;
    }

    public boolean equals(Object obj) {
        String str;
        f0.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.a.b.c) {
            f0.e.d.a.b.c cVar2 = (f0.e.d.a.b.c) obj;
            if (this.f24589a.equals(cVar2.f()) && ((str = this.f24590b) != null ? str.equals(cVar2.e()) : cVar2.e() == null) && this.f24591c.equals(cVar2.c()) && ((cVar = this.f24592d) != null ? cVar.equals(cVar2.b()) : cVar2.b() == null) && this.f24593e == cVar2.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // x7.f0.e.d.a.b.c
    public String f() {
        return this.f24589a;
    }

    public int hashCode() {
        int iHashCode = (this.f24589a.hashCode() ^ 1000003) * 1000003;
        String str = this.f24590b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f24591c.hashCode()) * 1000003;
        f0.e.d.a.b.c cVar = this.f24592d;
        return ((iHashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f24593e;
    }

    public String toString() {
        return "Exception{type=" + this.f24589a + ", reason=" + this.f24590b + ", frames=" + this.f24591c + ", causedBy=" + this.f24592d + ", overflowCount=" + this.f24593e + "}";
    }

    public p(String str, String str2, List list, f0.e.d.a.b.c cVar, int i10) {
        this.f24589a = str;
        this.f24590b = str2;
        this.f24591c = list;
        this.f24592d = cVar;
        this.f24593e = i10;
    }
}
