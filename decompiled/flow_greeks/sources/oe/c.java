package oe;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f17944b = new c("METHOD_RETURN_TYPE", 0, "METHOD");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f17945c = new c("VALUE_PARAMETER", 1, "PARAMETER");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f17946d = new c("FIELD", 2, "FIELD");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f17947e = new c("TYPE_USE", 3, "TYPE_USE");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f17948f = new c("TYPE_PARAMETER_BOUNDS", 4, "TYPE_USE");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f17949g = new c("TYPE_PARAMETER", 5, "TYPE_PARAMETER");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ c[] f17950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ jd.a f17951i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17952a;

    static {
        c[] cVarArrA = a();
        f17950h = cVarArrA;
        f17951i = jd.b.a(cVarArrA);
    }

    public c(String str, int i10, String str2) {
        this.f17952a = str2;
    }

    public static final /* synthetic */ c[] a() {
        return new c[]{f17944b, f17945c, f17946d, f17947e, f17948f, f17949g};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f17950h.clone();
    }

    public final String b() {
        return this.f17952a;
    }
}
