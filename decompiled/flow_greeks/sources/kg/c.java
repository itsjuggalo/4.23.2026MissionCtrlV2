package kg;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14856a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f14857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f14858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f14859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f14860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f14861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f14862g;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.t.e(charsetForName, "forName(...)");
        f14857b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.t.e(charsetForName2, "forName(...)");
        f14858c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.t.e(charsetForName3, "forName(...)");
        f14859d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.t.e(charsetForName4, "forName(...)");
        f14860e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.t.e(charsetForName5, "forName(...)");
        f14861f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.t.e(charsetForName6, "forName(...)");
        f14862g = charsetForName6;
    }
}
