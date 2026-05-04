package zf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f26456b = new b("ERROR_CLASS", 0, "<Error class: %s>");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f26457c = new b("ERROR_FUNCTION", 1, "<Error function>");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f26458d = new b("ERROR_SCOPE", 2, "<Error scope>");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f26459e = new b("ERROR_MODULE", 3, "<Error module>");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f26460f = new b("ERROR_PROPERTY", 4, "<Error property>");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f26461g = new b("ERROR_TYPE", 5, "[Error type: %s]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f26462h = new b("PARENT_OF_ERROR_SCOPE", 6, "<Fake parent for error lexical scope>");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ b[] f26463i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ jd.a f26464j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f26465a;

    static {
        b[] bVarArrA = a();
        f26463i = bVarArrA;
        f26464j = jd.b.a(bVarArrA);
    }

    public b(String str, int i10, String str2) {
        this.f26465a = str2;
    }

    public static final /* synthetic */ b[] a() {
        return new b[]{f26456b, f26457c, f26458d, f26459e, f26460f, f26461g, f26462h};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f26463i.clone();
    }

    public final String b() {
        return this.f26465a;
    }
}
