package p7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p7.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2612e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f22452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f22454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f22455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f22456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EnumC2608a f22457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f22458j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f22459k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f22460l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f22461m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22462n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f22463o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f22464p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public r7.e f22465q;

    public C2612e(AbstractC2609b json) {
        AbstractC2304t.f(json, "json");
        this.f22449a = json.f().i();
        this.f22450b = json.f().j();
        this.f22451c = json.f().k();
        this.f22452d = json.f().q();
        this.f22453e = json.f().m();
        this.f22454f = json.f().n();
        this.f22455g = json.f().g();
        this.f22456h = json.f().e();
        this.f22457i = json.f().f();
        this.f22458j = json.f().o();
        json.f().l();
        this.f22459k = json.f().h();
        this.f22460l = json.f().d();
        this.f22461m = json.f().a();
        this.f22462n = json.f().b();
        this.f22463o = json.f().c();
        this.f22464p = json.f().p();
        this.f22465q = json.a();
    }

    public final C2614g a() {
        if (this.f22464p) {
            if (!AbstractC2304t.b(this.f22456h, "type")) {
                throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
            }
            if (this.f22457i != EnumC2608a.f22436c) {
                throw new IllegalArgumentException("useArrayPolymorphism option can only be used if classDiscriminatorMode in a default POLYMORPHIC state.".toString());
            }
        }
        if (this.f22453e) {
            if (!AbstractC2304t.b(this.f22454f, "    ")) {
                String str = this.f22454f;
                for (int i8 = 0; i8 < str.length(); i8++) {
                    char cCharAt = str.charAt(i8);
                    if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.f22454f).toString());
                    }
                }
            }
        } else if (!AbstractC2304t.b(this.f22454f, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
        }
        return new C2614g(this.f22449a, this.f22451c, this.f22452d, this.f22463o, this.f22453e, this.f22450b, this.f22454f, this.f22455g, this.f22464p, this.f22456h, this.f22462n, this.f22458j, null, this.f22459k, this.f22460l, this.f22461m, this.f22457i);
    }

    public final r7.e b() {
        return this.f22465q;
    }

    public final void c(String str) {
        AbstractC2304t.f(str, "<set-?>");
        this.f22456h = str;
    }

    public final void d(boolean z7) {
        this.f22449a = z7;
    }

    public final void e(boolean z7) {
        this.f22450b = z7;
    }

    public final void f(boolean z7) {
        this.f22451c = z7;
    }

    public final void g(r7.e eVar) {
        AbstractC2304t.f(eVar, "<set-?>");
        this.f22465q = eVar;
    }
}
