package z1;

import w1.AbstractC2901d;
import w1.C2900c;
import w1.InterfaceC2905h;
import z1.o;

/* JADX INFO: renamed from: z1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C3002c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f24677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2901d f24679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2905h f24680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C2900c f24681e;

    /* JADX INFO: renamed from: z1.c$b */
    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p f24682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AbstractC2901d f24684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public InterfaceC2905h f24685d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C2900c f24686e;

        @Override // z1.o.a
        public o a() {
            String str = "";
            if (this.f24682a == null) {
                str = " transportContext";
            }
            if (this.f24683b == null) {
                str = str + " transportName";
            }
            if (this.f24684c == null) {
                str = str + " event";
            }
            if (this.f24685d == null) {
                str = str + " transformer";
            }
            if (this.f24686e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new C3002c(this.f24682a, this.f24683b, this.f24684c, this.f24685d, this.f24686e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // z1.o.a
        public o.a b(C2900c c2900c) {
            if (c2900c == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f24686e = c2900c;
            return this;
        }

        @Override // z1.o.a
        public o.a c(AbstractC2901d abstractC2901d) {
            if (abstractC2901d == null) {
                throw new NullPointerException("Null event");
            }
            this.f24684c = abstractC2901d;
            return this;
        }

        @Override // z1.o.a
        public o.a d(InterfaceC2905h interfaceC2905h) {
            if (interfaceC2905h == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f24685d = interfaceC2905h;
            return this;
        }

        @Override // z1.o.a
        public o.a e(p pVar) {
            if (pVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f24682a = pVar;
            return this;
        }

        @Override // z1.o.a
        public o.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f24683b = str;
            return this;
        }
    }

    public C3002c(p pVar, String str, AbstractC2901d abstractC2901d, InterfaceC2905h interfaceC2905h, C2900c c2900c) {
        this.f24677a = pVar;
        this.f24678b = str;
        this.f24679c = abstractC2901d;
        this.f24680d = interfaceC2905h;
        this.f24681e = c2900c;
    }

    @Override // z1.o
    public C2900c b() {
        return this.f24681e;
    }

    @Override // z1.o
    public AbstractC2901d c() {
        return this.f24679c;
    }

    @Override // z1.o
    public InterfaceC2905h e() {
        return this.f24680d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f24677a.equals(oVar.f()) && this.f24678b.equals(oVar.g()) && this.f24679c.equals(oVar.c()) && this.f24680d.equals(oVar.e()) && this.f24681e.equals(oVar.b());
    }

    @Override // z1.o
    public p f() {
        return this.f24677a;
    }

    @Override // z1.o
    public String g() {
        return this.f24678b;
    }

    public int hashCode() {
        return ((((((((this.f24677a.hashCode() ^ 1000003) * 1000003) ^ this.f24678b.hashCode()) * 1000003) ^ this.f24679c.hashCode()) * 1000003) ^ this.f24680d.hashCode()) * 1000003) ^ this.f24681e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f24677a + ", transportName=" + this.f24678b + ", event=" + this.f24679c + ", transformer=" + this.f24680d + ", encoding=" + this.f24681e + "}";
    }
}
