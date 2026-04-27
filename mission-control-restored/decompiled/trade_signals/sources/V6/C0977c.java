package V6;

import java.nio.charset.Charset;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: V6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0977c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0977c f8955a = new C0977c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f8956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f8957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f8958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f8959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f8960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f8961g;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        AbstractC2304t.e(charsetForName, "forName(...)");
        f8956b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        AbstractC2304t.e(charsetForName2, "forName(...)");
        f8957c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        AbstractC2304t.e(charsetForName3, "forName(...)");
        f8958d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        AbstractC2304t.e(charsetForName4, "forName(...)");
        f8959e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        AbstractC2304t.e(charsetForName5, "forName(...)");
        f8960f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        AbstractC2304t.e(charsetForName6, "forName(...)");
        f8961g = charsetForName6;
    }
}
