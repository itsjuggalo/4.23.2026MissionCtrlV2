package r1;

import o1.AbstractC2292d;
import o1.C2291c;
import o1.InterfaceC2296h;
import r1.o;

/* JADX INFO: renamed from: r1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2575c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f22396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2292d f22398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2296h f22399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C2291c f22400e;

    /* JADX INFO: renamed from: r1.c$b */
    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p f22401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AbstractC2292d f22403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public InterfaceC2296h f22404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C2291c f22405e;

        @Override // r1.o.a
        public o a() {
            String str = "";
            if (this.f22401a == null) {
                str = " transportContext";
            }
            if (this.f22402b == null) {
                str = str + " transportName";
            }
            if (this.f22403c == null) {
                str = str + " event";
            }
            if (this.f22404d == null) {
                str = str + " transformer";
            }
            if (this.f22405e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new C2575c(this.f22401a, this.f22402b, this.f22403c, this.f22404d, this.f22405e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // r1.o.a
        public o.a b(C2291c c2291c) {
            if (c2291c == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f22405e = c2291c;
            return this;
        }

        @Override // r1.o.a
        public o.a c(AbstractC2292d abstractC2292d) {
            if (abstractC2292d == null) {
                throw new NullPointerException("Null event");
            }
            this.f22403c = abstractC2292d;
            return this;
        }

        @Override // r1.o.a
        public o.a d(InterfaceC2296h interfaceC2296h) {
            if (interfaceC2296h == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f22404d = interfaceC2296h;
            return this;
        }

        @Override // r1.o.a
        public o.a e(p pVar) {
            if (pVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f22401a = pVar;
            return this;
        }

        @Override // r1.o.a
        public o.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f22402b = str;
            return this;
        }
    }

    @Override // r1.o
    public C2291c b() {
        return this.f22400e;
    }

    @Override // r1.o
    public AbstractC2292d c() {
        return this.f22398c;
    }

    @Override // r1.o
    public InterfaceC2296h e() {
        return this.f22399d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f22396a.equals(oVar.f()) && this.f22397b.equals(oVar.g()) && this.f22398c.equals(oVar.c()) && this.f22399d.equals(oVar.e()) && this.f22400e.equals(oVar.b());
    }

    @Override // r1.o
    public p f() {
        return this.f22396a;
    }

    @Override // r1.o
    public String g() {
        return this.f22397b;
    }

    public int hashCode() {
        return ((((((((this.f22396a.hashCode() ^ 1000003) * 1000003) ^ this.f22397b.hashCode()) * 1000003) ^ this.f22398c.hashCode()) * 1000003) ^ this.f22399d.hashCode()) * 1000003) ^ this.f22400e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f22396a + ", transportName=" + this.f22397b + ", event=" + this.f22398c + ", transformer=" + this.f22399d + ", encoding=" + this.f22400e + "}";
    }

    public C2575c(p pVar, String str, AbstractC2292d abstractC2292d, InterfaceC2296h interfaceC2296h, C2291c c2291c) {
        this.f22396a = pVar;
        this.f22397b = str;
        this.f22398c = abstractC2292d;
        this.f22399d = interfaceC2296h;
        this.f22400e = c2291c;
    }
}
