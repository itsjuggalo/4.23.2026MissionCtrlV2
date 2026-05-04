package eh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f9012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f9015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f9016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f9017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f9018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f9019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f9020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f9021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f9022p;

    public g(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String prettyPrintIndent, boolean z16, boolean z17, String classDiscriminator, boolean z18, boolean z19, y yVar, boolean z20, boolean z21, boolean z22, a classDiscriminatorMode) {
        kotlin.jvm.internal.t.f(prettyPrintIndent, "prettyPrintIndent");
        kotlin.jvm.internal.t.f(classDiscriminator, "classDiscriminator");
        kotlin.jvm.internal.t.f(classDiscriminatorMode, "classDiscriminatorMode");
        this.f9007a = z10;
        this.f9008b = z11;
        this.f9009c = z12;
        this.f9010d = z13;
        this.f9011e = z14;
        this.f9012f = z15;
        this.f9013g = prettyPrintIndent;
        this.f9014h = z16;
        this.f9015i = z17;
        this.f9016j = classDiscriminator;
        this.f9017k = z18;
        this.f9018l = z19;
        this.f9019m = z20;
        this.f9020n = z21;
        this.f9021o = z22;
        this.f9022p = classDiscriminatorMode;
    }

    public final boolean a() {
        return this.f9021o;
    }

    public final boolean b() {
        return this.f9017k;
    }

    public final boolean c() {
        return this.f9010d;
    }

    public final boolean d() {
        return this.f9020n;
    }

    public final String e() {
        return this.f9016j;
    }

    public final a f() {
        return this.f9022p;
    }

    public final boolean g() {
        return this.f9014h;
    }

    public final boolean h() {
        return this.f9019m;
    }

    public final boolean i() {
        return this.f9007a;
    }

    public final boolean j() {
        return this.f9012f;
    }

    public final boolean k() {
        return this.f9008b;
    }

    public final y l() {
        return null;
    }

    public final boolean m() {
        return this.f9011e;
    }

    public final String n() {
        return this.f9013g;
    }

    public final boolean o() {
        return this.f9018l;
    }

    public final boolean p() {
        return this.f9015i;
    }

    public final boolean q() {
        return this.f9009c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f9007a + ", ignoreUnknownKeys=" + this.f9008b + ", isLenient=" + this.f9009c + ", allowStructuredMapKeys=" + this.f9010d + ", prettyPrint=" + this.f9011e + ", explicitNulls=" + this.f9012f + ", prettyPrintIndent='" + this.f9013g + "', coerceInputValues=" + this.f9014h + ", useArrayPolymorphism=" + this.f9015i + ", classDiscriminator='" + this.f9016j + "', allowSpecialFloatingPointValues=" + this.f9017k + ", useAlternativeNames=" + this.f9018l + ", namingStrategy=" + ((Object) null) + ", decodeEnumsCaseInsensitive=" + this.f9019m + ", allowTrailingComma=" + this.f9020n + ", allowComments=" + this.f9021o + ", classDiscriminatorMode=" + this.f9022p + ')';
    }

    public /* synthetic */ g(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, String str, boolean z16, boolean z17, String str2, boolean z18, boolean z19, y yVar, boolean z20, boolean z21, boolean z22, a aVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? false : z12, (i10 & 8) != 0 ? false : z13, (i10 & 16) != 0 ? false : z14, (i10 & 32) != 0 ? true : z15, (i10 & 64) != 0 ? "    " : str, (i10 & 128) != 0 ? false : z16, (i10 & 256) != 0 ? false : z17, (i10 & 512) != 0 ? "type" : str2, (i10 & 1024) != 0 ? false : z18, (i10 & 2048) == 0 ? z19 : true, (i10 & 4096) != 0 ? null : yVar, (i10 & 8192) != 0 ? false : z20, (i10 & 16384) != 0 ? false : z21, (i10 & 32768) != 0 ? false : z22, (i10 & 65536) != 0 ? a.f8967c : aVar);
    }
}
