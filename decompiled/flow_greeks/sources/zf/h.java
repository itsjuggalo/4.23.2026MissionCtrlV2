package zf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f26477b = new h("CAPTURED_TYPE_SCOPE", 0, "No member resolution should be done on captured type, it used only during constraint system resolution");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f26478c = new h("INTEGER_LITERAL_TYPE_SCOPE", 1, "Scope for integer literal type (%s)");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f26479d = new h("ERASED_RECEIVER_TYPE_SCOPE", 2, "Error scope for erased receiver type");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f26480e = new h("SCOPE_FOR_ABBREVIATION_TYPE", 3, "Scope for abbreviation %s");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f26481f = new h("STUB_TYPE_SCOPE", 4, "Scope for stub type %s");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h f26482g = new h("NON_CLASSIFIER_SUPER_TYPE_SCOPE", 5, "A scope for common supertype which is not a normal classifier");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f26483h = new h("ERROR_TYPE_SCOPE", 6, "Scope for error type %s");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final h f26484i = new h("UNSUPPORTED_TYPE_SCOPE", 7, "Scope for unsupported type %s");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final h f26485j = new h("SCOPE_FOR_ERROR_CLASS", 8, "Error scope for class %s with arguments: %s");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final h f26486k = new h("SCOPE_FOR_ERROR_RESOLUTION_CANDIDATE", 9, "Error resolution candidate for call %s");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ h[] f26487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ jd.a f26488m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f26489a;

    static {
        h[] hVarArrA = a();
        f26487l = hVarArrA;
        f26488m = jd.b.a(hVarArrA);
    }

    public h(String str, int i10, String str2) {
        this.f26489a = str2;
    }

    public static final /* synthetic */ h[] a() {
        return new h[]{f26477b, f26478c, f26479d, f26480e, f26481f, f26482g, f26483h, f26484i, f26485j, f26486k};
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f26487l.clone();
    }

    public final String b() {
        return this.f26489a;
    }
}
