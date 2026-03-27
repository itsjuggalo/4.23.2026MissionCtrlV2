package okhttp3.internal.http2;

import a3.d;
import java.util.Locale;
import okhttp3.internal.Util;
import u5.AbstractC1245b;
import u5.j;

/* JADX INFO: loaded from: classes.dex */
public final class Header {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f8854d;
    public static final j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f8855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j f8856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final j f8857h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f8858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f8859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8860c;

    public interface Listener {
    }

    static {
        j jVar = j.f10527d;
        AbstractC1245b.e(":");
        f8854d = AbstractC1245b.e(":status");
        e = AbstractC1245b.e(":method");
        f8855f = AbstractC1245b.e(":path");
        f8856g = AbstractC1245b.e(":scheme");
        f8857h = AbstractC1245b.e(":authority");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(String str, String str2) {
        this(AbstractC1245b.e(str), AbstractC1245b.e(str2));
        j jVar = j.f10527d;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Header) {
            Header header = (Header) obj;
            if (this.f8858a.equals(header.f8858a) && this.f8859b.equals(header.f8859b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f8859b.hashCode() + ((this.f8858a.hashCode() + 527) * 31);
    }

    public final String toString() {
        String strS = this.f8858a.s();
        String strS2 = this.f8859b.s();
        byte[] bArr = Util.f8827a;
        Locale locale = Locale.US;
        return d.k(strS, ": ", strS2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(j jVar, String str) {
        this(jVar, AbstractC1245b.e(str));
        j jVar2 = j.f10527d;
    }

    public Header(j jVar, j jVar2) {
        this.f8858a = jVar;
        this.f8859b = jVar2;
        this.f8860c = jVar2.d() + jVar.d() + 32;
    }
}
