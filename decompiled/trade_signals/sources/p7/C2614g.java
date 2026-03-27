package p7;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p7.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2614g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f22467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f22469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f22470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f22471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f22472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f22473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f22474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f22475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f22476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f22477l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f22478m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f22479n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f22480o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public EnumC2608a f22481p;

    public C2614g(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, String prettyPrintIndent, boolean z13, boolean z14, String classDiscriminator, boolean z15, boolean z16, y yVar, boolean z17, boolean z18, boolean z19, EnumC2608a classDiscriminatorMode) {
        AbstractC2304t.f(prettyPrintIndent, "prettyPrintIndent");
        AbstractC2304t.f(classDiscriminator, "classDiscriminator");
        AbstractC2304t.f(classDiscriminatorMode, "classDiscriminatorMode");
        this.f22466a = z7;
        this.f22467b = z8;
        this.f22468c = z9;
        this.f22469d = z10;
        this.f22470e = z11;
        this.f22471f = z12;
        this.f22472g = prettyPrintIndent;
        this.f22473h = z13;
        this.f22474i = z14;
        this.f22475j = classDiscriminator;
        this.f22476k = z15;
        this.f22477l = z16;
        this.f22478m = z17;
        this.f22479n = z18;
        this.f22480o = z19;
        this.f22481p = classDiscriminatorMode;
    }

    public final boolean a() {
        return this.f22480o;
    }

    public final boolean b() {
        return this.f22476k;
    }

    public final boolean c() {
        return this.f22469d;
    }

    public final boolean d() {
        return this.f22479n;
    }

    public final String e() {
        return this.f22475j;
    }

    public final EnumC2608a f() {
        return this.f22481p;
    }

    public final boolean g() {
        return this.f22473h;
    }

    public final boolean h() {
        return this.f22478m;
    }

    public final boolean i() {
        return this.f22466a;
    }

    public final boolean j() {
        return this.f22471f;
    }

    public final boolean k() {
        return this.f22467b;
    }

    public final y l() {
        return null;
    }

    public final boolean m() {
        return this.f22470e;
    }

    public final String n() {
        return this.f22472g;
    }

    public final boolean o() {
        return this.f22477l;
    }

    public final boolean p() {
        return this.f22474i;
    }

    public final boolean q() {
        return this.f22468c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f22466a + ", ignoreUnknownKeys=" + this.f22467b + ", isLenient=" + this.f22468c + ", allowStructuredMapKeys=" + this.f22469d + ", prettyPrint=" + this.f22470e + ", explicitNulls=" + this.f22471f + ", prettyPrintIndent='" + this.f22472g + "', coerceInputValues=" + this.f22473h + ", useArrayPolymorphism=" + this.f22474i + ", classDiscriminator='" + this.f22475j + "', allowSpecialFloatingPointValues=" + this.f22476k + ", useAlternativeNames=" + this.f22477l + ", namingStrategy=" + ((Object) null) + ", decodeEnumsCaseInsensitive=" + this.f22478m + ", allowTrailingComma=" + this.f22479n + ", allowComments=" + this.f22480o + ", classDiscriminatorMode=" + this.f22481p + ')';
    }

    public /* synthetic */ C2614g(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, String str, boolean z13, boolean z14, String str2, boolean z15, boolean z16, y yVar, boolean z17, boolean z18, boolean z19, EnumC2608a enumC2608a, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? false : z7, (i8 & 2) != 0 ? false : z8, (i8 & 4) != 0 ? false : z9, (i8 & 8) != 0 ? false : z10, (i8 & 16) != 0 ? false : z11, (i8 & 32) != 0 ? true : z12, (i8 & 64) != 0 ? "    " : str, (i8 & 128) != 0 ? false : z13, (i8 & 256) != 0 ? false : z14, (i8 & 512) != 0 ? "type" : str2, (i8 & 1024) != 0 ? false : z15, (i8 & 2048) == 0 ? z16 : true, (i8 & 4096) != 0 ? null : yVar, (i8 & 8192) != 0 ? false : z17, (i8 & 16384) != 0 ? false : z18, (i8 & 32768) != 0 ? false : z19, (i8 & 65536) != 0 ? EnumC2608a.f22436c : enumC2608a);
    }
}
