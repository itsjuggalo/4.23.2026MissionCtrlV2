package r3;

import java.nio.charset.Charset;

/* JADX INFO: renamed from: r3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1756c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1756c f14562a = new C1756c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f14563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f14564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f14565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f14566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f14567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f14568g;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.r.e(charsetForName, "forName(...)");
        f14563b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.r.e(charsetForName2, "forName(...)");
        f14564c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.r.e(charsetForName3, "forName(...)");
        f14565d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.r.e(charsetForName4, "forName(...)");
        f14566e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.r.e(charsetForName5, "forName(...)");
        f14567f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.r.e(charsetForName6, "forName(...)");
        f14568g = charsetForName6;
    }
}
