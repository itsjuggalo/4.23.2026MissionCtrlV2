package K3;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f1358j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f1359k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f1360l;

    public f(boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, String prettyPrintIndent, boolean z10, boolean z11, String classDiscriminator, boolean z12, boolean z13, r rVar) {
        kotlin.jvm.internal.r.f(prettyPrintIndent, "prettyPrintIndent");
        kotlin.jvm.internal.r.f(classDiscriminator, "classDiscriminator");
        this.f1349a = z4;
        this.f1350b = z5;
        this.f1351c = z6;
        this.f1352d = z7;
        this.f1353e = z8;
        this.f1354f = z9;
        this.f1355g = prettyPrintIndent;
        this.f1356h = z10;
        this.f1357i = z11;
        this.f1358j = classDiscriminator;
        this.f1359k = z12;
        this.f1360l = z13;
    }

    public final boolean a() {
        return this.f1359k;
    }

    public final boolean b() {
        return this.f1352d;
    }

    public final String c() {
        return this.f1358j;
    }

    public final boolean d() {
        return this.f1356h;
    }

    public final boolean e() {
        return this.f1349a;
    }

    public final boolean f() {
        return this.f1354f;
    }

    public final boolean g() {
        return this.f1350b;
    }

    public final r h() {
        return null;
    }

    public final boolean i() {
        return this.f1353e;
    }

    public final String j() {
        return this.f1355g;
    }

    public final boolean k() {
        return this.f1360l;
    }

    public final boolean l() {
        return this.f1357i;
    }

    public final boolean m() {
        return this.f1351c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f1349a + ", ignoreUnknownKeys=" + this.f1350b + ", isLenient=" + this.f1351c + ", allowStructuredMapKeys=" + this.f1352d + ", prettyPrint=" + this.f1353e + ", explicitNulls=" + this.f1354f + ", prettyPrintIndent='" + this.f1355g + "', coerceInputValues=" + this.f1356h + ", useArrayPolymorphism=" + this.f1357i + ", classDiscriminator='" + this.f1358j + "', allowSpecialFloatingPointValues=" + this.f1359k + ", useAlternativeNames=" + this.f1360l + ", namingStrategy=" + ((Object) null) + ')';
    }

    public /* synthetic */ f(boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, String str, boolean z10, boolean z11, String str2, boolean z12, boolean z13, r rVar, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? false : z4, (i4 & 2) != 0 ? false : z5, (i4 & 4) != 0 ? false : z6, (i4 & 8) != 0 ? false : z7, (i4 & 16) != 0 ? false : z8, (i4 & 32) != 0 ? true : z9, (i4 & 64) != 0 ? "    " : str, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? false : z10, (i4 & 256) != 0 ? false : z11, (i4 & 512) != 0 ? "type" : str2, (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0 ? z12 : false, (i4 & 2048) == 0 ? z13 : true, (i4 & 4096) != 0 ? null : rVar);
    }
}
