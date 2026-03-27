package okhttp3.internal.http;

import java.net.Proxy;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* JADX INFO: loaded from: classes2.dex */
public final class RequestLine {
    private RequestLine() {
    }

    public static String a(Request request, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.g());
        sb.append(' ');
        if (b(request, type)) {
            sb.append(request.i());
        } else {
            sb.append(c(request.i()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static boolean b(Request request, Proxy.Type type) {
        return !request.f() && type == Proxy.Type.HTTP;
    }

    public static String c(HttpUrl httpUrl) {
        String strG = httpUrl.g();
        String strI = httpUrl.i();
        if (strI == null) {
            return strG;
        }
        return strG + '?' + strI;
    }
}
