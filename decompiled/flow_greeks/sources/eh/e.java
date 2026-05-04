package eh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f8995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f8996i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8998k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8999l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9000m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9001n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9002o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f9003p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public gh.e f9004q;

    public e(b json) {
        kotlin.jvm.internal.t.f(json, "json");
        this.f8988a = json.f().i();
        this.f8989b = json.f().j();
        this.f8990c = json.f().k();
        this.f8991d = json.f().q();
        this.f8992e = json.f().m();
        this.f8993f = json.f().n();
        this.f8994g = json.f().g();
        this.f8995h = json.f().e();
        this.f8996i = json.f().f();
        this.f8997j = json.f().o();
        json.f().l();
        this.f8998k = json.f().h();
        this.f8999l = json.f().d();
        this.f9000m = json.f().a();
        this.f9001n = json.f().b();
        this.f9002o = json.f().c();
        this.f9003p = json.f().p();
        this.f9004q = json.a();
    }

    public final g a() {
        if (this.f9003p) {
            if (!kotlin.jvm.internal.t.b(this.f8995h, "type")) {
                throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified");
            }
            if (this.f8996i != a.f8967c) {
                throw new IllegalArgumentException("useArrayPolymorphism option can only be used if classDiscriminatorMode in a default POLYMORPHIC state.");
            }
        }
        if (this.f8992e) {
            if (!kotlin.jvm.internal.t.b(this.f8993f, "    ")) {
                String str = this.f8993f;
                for (int i10 = 0; i10 < str.length(); i10++) {
                    char cCharAt = str.charAt(i10);
                    if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.f8993f).toString());
                    }
                }
            }
        } else if (!kotlin.jvm.internal.t.b(this.f8993f, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        return new g(this.f8988a, this.f8990c, this.f8991d, this.f9002o, this.f8992e, this.f8989b, this.f8993f, this.f8994g, this.f9003p, this.f8995h, this.f9001n, this.f8997j, null, this.f8998k, this.f8999l, this.f9000m, this.f8996i);
    }

    public final gh.e b() {
        return this.f9004q;
    }

    public final void c(String str) {
        kotlin.jvm.internal.t.f(str, "<set-?>");
        this.f8995h = str;
    }

    public final void d(boolean z10) {
        this.f8988a = z10;
    }

    public final void e(boolean z10) {
        this.f8989b = z10;
    }

    public final void f(boolean z10) {
        this.f8990c = z10;
    }

    public final void g(gh.e eVar) {
        kotlin.jvm.internal.t.f(eVar, "<set-?>");
        this.f9004q = eVar;
    }
}
