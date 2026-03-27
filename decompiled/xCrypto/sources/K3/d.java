package K3;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f1345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1346k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1347l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public M3.e f1348m;

    public d(a json) {
        kotlin.jvm.internal.r.f(json, "json");
        this.f1336a = json.f().e();
        this.f1337b = json.f().f();
        this.f1338c = json.f().g();
        this.f1339d = json.f().m();
        this.f1340e = json.f().b();
        this.f1341f = json.f().i();
        this.f1342g = json.f().j();
        this.f1343h = json.f().d();
        this.f1344i = json.f().l();
        this.f1345j = json.f().c();
        this.f1346k = json.f().a();
        this.f1347l = json.f().k();
        json.f().h();
        this.f1348m = json.a();
    }

    public final f a() {
        if (this.f1344i && !kotlin.jvm.internal.r.b(this.f1345j, "type")) {
            throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified");
        }
        if (this.f1341f) {
            if (!kotlin.jvm.internal.r.b(this.f1342g, "    ")) {
                String str = this.f1342g;
                for (int i4 = 0; i4 < str.length(); i4++) {
                    char cCharAt = str.charAt(i4);
                    if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.f1342g).toString());
                    }
                }
            }
        } else if (!kotlin.jvm.internal.r.b(this.f1342g, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        return new f(this.f1336a, this.f1338c, this.f1339d, this.f1340e, this.f1341f, this.f1337b, this.f1342g, this.f1343h, this.f1344i, this.f1345j, this.f1346k, this.f1347l, null);
    }

    public final M3.e b() {
        return this.f1348m;
    }

    public final void c(String str) {
        kotlin.jvm.internal.r.f(str, "<set-?>");
        this.f1345j = str;
    }

    public final void d(boolean z4) {
        this.f1336a = z4;
    }

    public final void e(boolean z4) {
        this.f1337b = z4;
    }

    public final void f(boolean z4) {
        this.f1338c = z4;
    }

    public final void g(M3.e eVar) {
        kotlin.jvm.internal.r.f(eVar, "<set-?>");
        this.f1348m = eVar;
    }
}
