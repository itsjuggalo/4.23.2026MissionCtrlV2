package x7;

import java.util.List;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends f0.e.d.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0.e.d.a.b.c f24571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0.a f24572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f0.e.d.a.b.AbstractC0438d f24573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f24574e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.a.b.AbstractC0436b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f24575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f0.e.d.a.b.c f24576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f0.a f24577c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f0.e.d.a.b.AbstractC0438d f24578d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f24579e;

        @Override // x7.f0.e.d.a.b.AbstractC0436b
        public f0.e.d.a.b a() {
            List list;
            f0.e.d.a.b.AbstractC0438d abstractC0438d = this.f24578d;
            if (abstractC0438d != null && (list = this.f24579e) != null) {
                return new n(this.f24575a, this.f24576b, this.f24577c, abstractC0438d, list);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24578d == null) {
                sb2.append(" signal");
            }
            if (this.f24579e == null) {
                sb2.append(" binaries");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.a.b.AbstractC0436b
        public f0.e.d.a.b.AbstractC0436b b(f0.a aVar) {
            this.f24577c = aVar;
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0436b
        public f0.e.d.a.b.AbstractC0436b c(List list) {
            if (list == null) {
                throw new NullPointerException("Null binaries");
            }
            this.f24579e = list;
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0436b
        public f0.e.d.a.b.AbstractC0436b d(f0.e.d.a.b.c cVar) {
            this.f24576b = cVar;
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0436b
        public f0.e.d.a.b.AbstractC0436b e(f0.e.d.a.b.AbstractC0438d abstractC0438d) {
            if (abstractC0438d == null) {
                throw new NullPointerException("Null signal");
            }
            this.f24578d = abstractC0438d;
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0436b
        public f0.e.d.a.b.AbstractC0436b f(List list) {
            this.f24575a = list;
            return this;
        }
    }

    @Override // x7.f0.e.d.a.b
    public f0.a b() {
        return this.f24572c;
    }

    @Override // x7.f0.e.d.a.b
    public List c() {
        return this.f24574e;
    }

    @Override // x7.f0.e.d.a.b
    public f0.e.d.a.b.c d() {
        return this.f24571b;
    }

    @Override // x7.f0.e.d.a.b
    public f0.e.d.a.b.AbstractC0438d e() {
        return this.f24573d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.a.b) {
            f0.e.d.a.b bVar = (f0.e.d.a.b) obj;
            List list = this.f24570a;
            if (list != null ? list.equals(bVar.f()) : bVar.f() == null) {
                f0.e.d.a.b.c cVar = this.f24571b;
                if (cVar != null ? cVar.equals(bVar.d()) : bVar.d() == null) {
                    f0.a aVar = this.f24572c;
                    if (aVar != null ? aVar.equals(bVar.b()) : bVar.b() == null) {
                        if (this.f24573d.equals(bVar.e()) && this.f24574e.equals(bVar.c())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // x7.f0.e.d.a.b
    public List f() {
        return this.f24570a;
    }

    public int hashCode() {
        List list = this.f24570a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        f0.e.d.a.b.c cVar = this.f24571b;
        int iHashCode2 = (iHashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        f0.a aVar = this.f24572c;
        return ((((iHashCode2 ^ (aVar != null ? aVar.hashCode() : 0)) * 1000003) ^ this.f24573d.hashCode()) * 1000003) ^ this.f24574e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f24570a + ", exception=" + this.f24571b + ", appExitInfo=" + this.f24572c + ", signal=" + this.f24573d + ", binaries=" + this.f24574e + "}";
    }

    public n(List list, f0.e.d.a.b.c cVar, f0.a aVar, f0.e.d.a.b.AbstractC0438d abstractC0438d, List list2) {
        this.f24570a = list;
        this.f24571b = cVar;
        this.f24572c = aVar;
        this.f24573d = abstractC0438d;
        this.f24574e = list2;
    }
}
