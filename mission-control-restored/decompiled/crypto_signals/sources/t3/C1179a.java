package t3;

/* JADX INFO: renamed from: t3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1179a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1179a f10230d = new C1179a("", "", false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10233c;

    static {
        new C1179a("\n", "  ", true);
    }

    public C1179a(String str, String str2, boolean z6) {
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f10231a = str;
        this.f10232b = str2;
        this.f10233c = z6;
    }
}
