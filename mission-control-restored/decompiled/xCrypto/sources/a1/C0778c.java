package a1;

import a1.o;

/* JADX INFO: renamed from: a1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0778c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f6061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final X0.d f6063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final X0.h f6064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final X0.c f6065e;

    /* JADX INFO: renamed from: a1.c$b */
    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p f6066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public X0.d f6068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public X0.h f6069d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public X0.c f6070e;

        @Override // a1.o.a
        public o a() {
            String str = "";
            if (this.f6066a == null) {
                str = " transportContext";
            }
            if (this.f6067b == null) {
                str = str + " transportName";
            }
            if (this.f6068c == null) {
                str = str + " event";
            }
            if (this.f6069d == null) {
                str = str + " transformer";
            }
            if (this.f6070e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new C0778c(this.f6066a, this.f6067b, this.f6068c, this.f6069d, this.f6070e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // a1.o.a
        public o.a b(X0.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f6070e = cVar;
            return this;
        }

        @Override // a1.o.a
        public o.a c(X0.d dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null event");
            }
            this.f6068c = dVar;
            return this;
        }

        @Override // a1.o.a
        public o.a d(X0.h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f6069d = hVar;
            return this;
        }

        @Override // a1.o.a
        public o.a e(p pVar) {
            if (pVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f6066a = pVar;
            return this;
        }

        @Override // a1.o.a
        public o.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f6067b = str;
            return this;
        }
    }

    @Override // a1.o
    public X0.c b() {
        return this.f6065e;
    }

    @Override // a1.o
    public X0.d c() {
        return this.f6063c;
    }

    @Override // a1.o
    public X0.h e() {
        return this.f6064d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f6061a.equals(oVar.f()) && this.f6062b.equals(oVar.g()) && this.f6063c.equals(oVar.c()) && this.f6064d.equals(oVar.e()) && this.f6065e.equals(oVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // a1.o
    public p f() {
        return this.f6061a;
    }

    @Override // a1.o
    public String g() {
        return this.f6062b;
    }

    public int hashCode() {
        return ((((((((this.f6061a.hashCode() ^ 1000003) * 1000003) ^ this.f6062b.hashCode()) * 1000003) ^ this.f6063c.hashCode()) * 1000003) ^ this.f6064d.hashCode()) * 1000003) ^ this.f6065e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f6061a + ", transportName=" + this.f6062b + ", event=" + this.f6063c + ", transformer=" + this.f6064d + ", encoding=" + this.f6065e + "}";
    }

    public C0778c(p pVar, String str, X0.d dVar, X0.h hVar, X0.c cVar) {
        this.f6061a = pVar;
        this.f6062b = str;
        this.f6063c = dVar;
        this.f6064d = hVar;
        this.f6065e = cVar;
    }
}
