package l4;

import java.util.Objects;

/* JADX INFO: renamed from: l4.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2171d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2171d f18317d = new C2171d("", "", false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2171d f18318e = new C2171d("\n", "  ", true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18321c;

    public C2171d(String str, String str2, boolean z7) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f18319a = str;
        this.f18320b = str2;
        this.f18321c = z7;
    }

    public String a() {
        return this.f18320b;
    }

    public String b() {
        return this.f18319a;
    }

    public boolean c() {
        return this.f18321c;
    }
}
