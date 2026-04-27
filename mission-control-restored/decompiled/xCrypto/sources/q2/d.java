package q2;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f14209d = new d("", "", false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f14210e = new d("\n", "  ", true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14213c;

    public d(String str, String str2, boolean z4) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f14211a = str;
        this.f14212b = str2;
        this.f14213c = z4;
    }

    public String a() {
        return this.f14212b;
    }

    public String b() {
        return this.f14211a;
    }

    public boolean c() {
        return this.f14213c;
    }
}
