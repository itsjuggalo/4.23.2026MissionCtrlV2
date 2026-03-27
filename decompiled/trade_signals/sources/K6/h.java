package K6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f4802b = new h("CAPTURED_TYPE_SCOPE", 0, "No member resolution should be done on captured type, it used only during constraint system resolution");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f4803c = new h("INTEGER_LITERAL_TYPE_SCOPE", 1, "Scope for integer literal type (%s)");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f4804d = new h("ERASED_RECEIVER_TYPE_SCOPE", 2, "Error scope for erased receiver type");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f4805e = new h("SCOPE_FOR_ABBREVIATION_TYPE", 3, "Scope for abbreviation %s");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f4806f = new h("STUB_TYPE_SCOPE", 4, "Scope for stub type %s");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h f4807g = new h("NON_CLASSIFIER_SUPER_TYPE_SCOPE", 5, "A scope for common supertype which is not a normal classifier");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f4808h = new h("ERROR_TYPE_SCOPE", 6, "Scope for error type %s");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final h f4809i = new h("UNSUPPORTED_TYPE_SCOPE", 7, "Scope for unsupported type %s");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final h f4810j = new h("SCOPE_FOR_ERROR_CLASS", 8, "Error scope for class %s with arguments: %s");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final h f4811k = new h("SCOPE_FOR_ERROR_RESOLUTION_CANDIDATE", 9, "Error resolution candidate for call %s");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ h[] f4812l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f4813m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4814a;

    static {
        h[] hVarArrA = a();
        f4812l = hVarArrA;
        f4813m = AbstractC2875b.a(hVarArrA);
    }

    public h(String str, int i8, String str2) {
        this.f4814a = str2;
    }

    public static final /* synthetic */ h[] a() {
        return new h[]{f4802b, f4803c, f4804d, f4805e, f4806f, f4807g, f4808h, f4809i, f4810j, f4811k};
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f4812l.clone();
    }

    public final String b() {
        return this.f4814a;
    }
}
