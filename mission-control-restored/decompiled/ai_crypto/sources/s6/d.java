package s6;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f23027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f23029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f23030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f23031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f23032j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f23033k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f23034l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public u6.e f23035m;

    public d(a json) {
        kotlin.jvm.internal.r.f(json, "json");
        this.f23023a = json.f().e();
        this.f23024b = json.f().f();
        this.f23025c = json.f().g();
        this.f23026d = json.f().m();
        this.f23027e = json.f().b();
        this.f23028f = json.f().i();
        this.f23029g = json.f().j();
        this.f23030h = json.f().d();
        this.f23031i = json.f().l();
        this.f23032j = json.f().c();
        this.f23033k = json.f().a();
        this.f23034l = json.f().k();
        json.f().h();
        this.f23035m = json.a();
    }

    public final f a() {
        if (this.f23031i && !kotlin.jvm.internal.r.b(this.f23032j, "type")) {
            throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified");
        }
        if (this.f23028f) {
            if (!kotlin.jvm.internal.r.b(this.f23029g, "    ")) {
                String str = this.f23029g;
                for (int i7 = 0; i7 < str.length(); i7++) {
                    char cCharAt = str.charAt(i7);
                    if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.f23029g).toString());
                    }
                }
            }
        } else if (!kotlin.jvm.internal.r.b(this.f23029g, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        return new f(this.f23023a, this.f23025c, this.f23026d, this.f23027e, this.f23028f, this.f23024b, this.f23029g, this.f23030h, this.f23031i, this.f23032j, this.f23033k, this.f23034l, null);
    }

    public final u6.e b() {
        return this.f23035m;
    }

    public final void c(String str) {
        kotlin.jvm.internal.r.f(str, "<set-?>");
        this.f23032j = str;
    }

    public final void d(boolean z7) {
        this.f23023a = z7;
    }

    public final void e(boolean z7) {
        this.f23024b = z7;
    }

    public final void f(boolean z7) {
        this.f23025c = z7;
    }

    public final void g(u6.e eVar) {
        kotlin.jvm.internal.r.f(eVar, "<set-?>");
        this.f23035m = eVar;
    }
}
