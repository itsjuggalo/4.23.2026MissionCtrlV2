package s6;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f23038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f23039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f23040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f23041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f23042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f23043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f23044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f23045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f23046k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f23047l;

    public f(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, String prettyPrintIndent, boolean z13, boolean z14, String classDiscriminator, boolean z15, boolean z16, r rVar) {
        kotlin.jvm.internal.r.f(prettyPrintIndent, "prettyPrintIndent");
        kotlin.jvm.internal.r.f(classDiscriminator, "classDiscriminator");
        this.f23036a = z7;
        this.f23037b = z8;
        this.f23038c = z9;
        this.f23039d = z10;
        this.f23040e = z11;
        this.f23041f = z12;
        this.f23042g = prettyPrintIndent;
        this.f23043h = z13;
        this.f23044i = z14;
        this.f23045j = classDiscriminator;
        this.f23046k = z15;
        this.f23047l = z16;
    }

    public final boolean a() {
        return this.f23046k;
    }

    public final boolean b() {
        return this.f23039d;
    }

    public final String c() {
        return this.f23045j;
    }

    public final boolean d() {
        return this.f23043h;
    }

    public final boolean e() {
        return this.f23036a;
    }

    public final boolean f() {
        return this.f23041f;
    }

    public final boolean g() {
        return this.f23037b;
    }

    public final r h() {
        return null;
    }

    public final boolean i() {
        return this.f23040e;
    }

    public final String j() {
        return this.f23042g;
    }

    public final boolean k() {
        return this.f23047l;
    }

    public final boolean l() {
        return this.f23044i;
    }

    public final boolean m() {
        return this.f23038c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f23036a + ", ignoreUnknownKeys=" + this.f23037b + ", isLenient=" + this.f23038c + ", allowStructuredMapKeys=" + this.f23039d + ", prettyPrint=" + this.f23040e + ", explicitNulls=" + this.f23041f + ", prettyPrintIndent='" + this.f23042g + "', coerceInputValues=" + this.f23043h + ", useArrayPolymorphism=" + this.f23044i + ", classDiscriminator='" + this.f23045j + "', allowSpecialFloatingPointValues=" + this.f23046k + ", useAlternativeNames=" + this.f23047l + ", namingStrategy=" + ((Object) null) + ')';
    }

    public /* synthetic */ f(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, String str, boolean z13, boolean z14, String str2, boolean z15, boolean z16, r rVar, int i7, AbstractC2148j abstractC2148j) {
        this((i7 & 1) != 0 ? false : z7, (i7 & 2) != 0 ? false : z8, (i7 & 4) != 0 ? false : z9, (i7 & 8) != 0 ? false : z10, (i7 & 16) != 0 ? false : z11, (i7 & 32) != 0 ? true : z12, (i7 & 64) != 0 ? "    " : str, (i7 & 128) != 0 ? false : z13, (i7 & 256) != 0 ? false : z14, (i7 & 512) != 0 ? "type" : str2, (i7 & 1024) == 0 ? z15 : false, (i7 & 2048) == 0 ? z16 : true, (i7 & 4096) != 0 ? null : rVar);
    }
}
