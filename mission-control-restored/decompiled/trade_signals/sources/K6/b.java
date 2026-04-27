package K6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f4781b = new b("ERROR_CLASS", 0, "<Error class: %s>");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f4782c = new b("ERROR_FUNCTION", 1, "<Error function>");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f4783d = new b("ERROR_SCOPE", 2, "<Error scope>");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f4784e = new b("ERROR_MODULE", 3, "<Error module>");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f4785f = new b("ERROR_PROPERTY", 4, "<Error property>");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f4786g = new b("ERROR_TYPE", 5, "[Error type: %s]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f4787h = new b("PARENT_OF_ERROR_SCOPE", 6, "<Fake parent for error lexical scope>");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ b[] f4788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f4789j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4790a;

    static {
        b[] bVarArrA = a();
        f4788i = bVarArrA;
        f4789j = AbstractC2875b.a(bVarArrA);
    }

    public b(String str, int i8, String str2) {
        this.f4790a = str2;
    }

    public static final /* synthetic */ b[] a() {
        return new b[]{f4781b, f4782c, f4783d, f4784e, f4785f, f4786g, f4787h};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f4788i.clone();
    }

    public final String b() {
        return this.f4790a;
    }
}
