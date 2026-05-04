package l4;

import l4.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f15375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i4.d f15377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.h f15378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i4.c f15379e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p f15380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public i4.d f15382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i4.h f15383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public i4.c f15384e;

        @Override // l4.o.a
        public o a() {
            String str = "";
            if (this.f15380a == null) {
                str = " transportContext";
            }
            if (this.f15381b == null) {
                str = str + " transportName";
            }
            if (this.f15382c == null) {
                str = str + " event";
            }
            if (this.f15383d == null) {
                str = str + " transformer";
            }
            if (this.f15384e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f15380a, this.f15381b, this.f15382c, this.f15383d, this.f15384e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // l4.o.a
        public o.a b(i4.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f15384e = cVar;
            return this;
        }

        @Override // l4.o.a
        public o.a c(i4.d dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null event");
            }
            this.f15382c = dVar;
            return this;
        }

        @Override // l4.o.a
        public o.a d(i4.h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f15383d = hVar;
            return this;
        }

        @Override // l4.o.a
        public o.a e(p pVar) {
            if (pVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f15380a = pVar;
            return this;
        }

        @Override // l4.o.a
        public o.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f15381b = str;
            return this;
        }
    }

    @Override // l4.o
    public i4.c b() {
        return this.f15379e;
    }

    @Override // l4.o
    public i4.d c() {
        return this.f15377c;
    }

    @Override // l4.o
    public i4.h e() {
        return this.f15378d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f15375a.equals(oVar.f()) && this.f15376b.equals(oVar.g()) && this.f15377c.equals(oVar.c()) && this.f15378d.equals(oVar.e()) && this.f15379e.equals(oVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // l4.o
    public p f() {
        return this.f15375a;
    }

    @Override // l4.o
    public String g() {
        return this.f15376b;
    }

    public int hashCode() {
        return ((((((((this.f15375a.hashCode() ^ 1000003) * 1000003) ^ this.f15376b.hashCode()) * 1000003) ^ this.f15377c.hashCode()) * 1000003) ^ this.f15378d.hashCode()) * 1000003) ^ this.f15379e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f15375a + ", transportName=" + this.f15376b + ", event=" + this.f15377c + ", transformer=" + this.f15378d + ", encoding=" + this.f15379e + "}";
    }

    public c(p pVar, String str, i4.d dVar, i4.h hVar, i4.c cVar) {
        this.f15375a = pVar;
        this.f15376b = str;
        this.f15377c = dVar;
        this.f15378d = hVar;
        this.f15379e = cVar;
    }
}
