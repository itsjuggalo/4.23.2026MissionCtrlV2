package Z5;

import java.nio.charset.Charset;

/* JADX INFO: renamed from: Z5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0796c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0796c f6017a = new C0796c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f6018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f6019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f6020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f6021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f6022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f6023g;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.r.e(charsetForName, "forName(...)");
        f6018b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.r.e(charsetForName2, "forName(...)");
        f6019c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.r.e(charsetForName3, "forName(...)");
        f6020d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.r.e(charsetForName4, "forName(...)");
        f6021e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.r.e(charsetForName5, "forName(...)");
        f6022f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.r.e(charsetForName6, "forName(...)");
        f6023g = charsetForName6;
    }
}
