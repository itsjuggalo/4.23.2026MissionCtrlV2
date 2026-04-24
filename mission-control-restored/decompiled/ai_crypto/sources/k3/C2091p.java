package k3;

import java.util.List;
import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2091p extends AbstractC2074F.e.d.a.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f17912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC2074F.e.d.a.b.c f17913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17914e;

    /* JADX INFO: renamed from: k3.p$b */
    public static final class b extends AbstractC2074F.e.d.a.b.c.AbstractC0276a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f17917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AbstractC2074F.e.d.a.b.c f17918d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f17919e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f17920f;

        @Override // k3.AbstractC2074F.e.d.a.b.c.AbstractC0276a
        public AbstractC2074F.e.d.a.b.c a() {
            String str;
            List list;
            if (this.f17920f == 1 && (str = this.f17915a) != null && (list = this.f17917c) != null) {
                return new C2091p(str, this.f17916b, list, this.f17918d, this.f17919e);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17915a == null) {
                sb.append(" type");
            }
            if (this.f17917c == null) {
                sb.append(" frames");
            }
            if ((1 & this.f17920f) == 0) {
                sb.append(" overflowCount");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.a.b.c.AbstractC0276a
        public AbstractC2074F.e.d.a.b.c.AbstractC0276a b(AbstractC2074F.e.d.a.b.c cVar) {
            this.f17918d = cVar;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.c.AbstractC0276a
        public AbstractC2074F.e.d.a.b.c.AbstractC0276a c(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f17917c = list;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.c.AbstractC0276a
        public AbstractC2074F.e.d.a.b.c.AbstractC0276a d(int i7) {
            this.f17919e = i7;
            this.f17920f = (byte) (this.f17920f | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.c.AbstractC0276a
        public AbstractC2074F.e.d.a.b.c.AbstractC0276a e(String str) {
            this.f17916b = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.c.AbstractC0276a
        public AbstractC2074F.e.d.a.b.c.AbstractC0276a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f17915a = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.a.b.c
    public AbstractC2074F.e.d.a.b.c b() {
        return this.f17913d;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.c
    public List c() {
        return this.f17912c;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.c
    public int d() {
        return this.f17914e;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.c
    public String e() {
        return this.f17911b;
    }

    public boolean equals(Object obj) {
        String str;
        AbstractC2074F.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d.a.b.c)) {
            return false;
        }
        AbstractC2074F.e.d.a.b.c cVar2 = (AbstractC2074F.e.d.a.b.c) obj;
        return this.f17910a.equals(cVar2.f()) && ((str = this.f17911b) != null ? str.equals(cVar2.e()) : cVar2.e() == null) && this.f17912c.equals(cVar2.c()) && ((cVar = this.f17913d) != null ? cVar.equals(cVar2.b()) : cVar2.b() == null) && this.f17914e == cVar2.d();
    }

    @Override // k3.AbstractC2074F.e.d.a.b.c
    public String f() {
        return this.f17910a;
    }

    public int hashCode() {
        int iHashCode = (this.f17910a.hashCode() ^ 1000003) * 1000003;
        String str = this.f17911b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f17912c.hashCode()) * 1000003;
        AbstractC2074F.e.d.a.b.c cVar = this.f17913d;
        return ((iHashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f17914e;
    }

    public String toString() {
        return "Exception{type=" + this.f17910a + ", reason=" + this.f17911b + ", frames=" + this.f17912c + ", causedBy=" + this.f17913d + ", overflowCount=" + this.f17914e + "}";
    }

    public C2091p(String str, String str2, List list, AbstractC2074F.e.d.a.b.c cVar, int i7) {
        this.f17910a = str;
        this.f17911b = str2;
        this.f17912c = list;
        this.f17913d = cVar;
        this.f17914e = i7;
    }
}
