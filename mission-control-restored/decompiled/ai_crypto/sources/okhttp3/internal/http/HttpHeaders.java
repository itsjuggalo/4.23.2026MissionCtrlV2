package okhttp3.internal.http;

import com.amazon.a.a.o.b.f;
import com.google.android.gms.common.api.a;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import w6.C2795h;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpHeaders {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2795h f20829a = C2795h.j("\"\\");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2795h f20830b = C2795h.j("\t ,=");

    private HttpHeaders() {
    }

    public static long a(Headers headers) {
        return j(headers.c("Content-Length"));
    }

    public static long b(Response response) {
        return a(response.M());
    }

    public static boolean c(Response response) {
        if (response.y0().g().equals("HEAD")) {
            return false;
        }
        int iA = response.A();
        return (((iA >= 100 && iA < 200) || iA == 204 || iA == 304) && b(response) == -1 && !"chunked".equalsIgnoreCase(response.H("Transfer-Encoding"))) ? false : true;
    }

    public static boolean d(Headers headers) {
        return k(headers).contains("*");
    }

    public static boolean e(Response response) {
        return d(response.M());
    }

    public static int f(String str, int i7) {
        try {
            long j7 = Long.parseLong(str);
            if (j7 > 2147483647L) {
                return a.e.API_PRIORITY_OTHER;
            }
            if (j7 < 0) {
                return 0;
            }
            return (int) j7;
        } catch (NumberFormatException unused) {
            return i7;
        }
    }

    public static void g(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar == CookieJar.f20468a) {
            return;
        }
        List listF = Cookie.f(httpUrl, headers);
        if (listF.isEmpty()) {
            return;
        }
        cookieJar.a(httpUrl, listF);
    }

    public static int h(String str, int i7, String str2) {
        while (i7 < str.length() && str2.indexOf(str.charAt(i7)) == -1) {
            i7++;
        }
        return i7;
    }

    public static int i(String str, int i7) {
        char cCharAt;
        while (i7 < str.length() && ((cCharAt = str.charAt(i7)) == ' ' || cCharAt == '\t')) {
            i7++;
        }
        return i7;
    }

    public static long j(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Set k(Headers headers) {
        Set setEmptySet = Collections.emptySet();
        int iG = headers.g();
        for (int i7 = 0; i7 < iG; i7++) {
            if ("Vary".equalsIgnoreCase(headers.e(i7))) {
                String strH = headers.h(i7);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strH.split(f.f9989a)) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static Set l(Response response) {
        return k(response.M());
    }

    public static Headers m(Headers headers, Headers headers2) {
        Set setK = k(headers2);
        if (setK.isEmpty()) {
            return new Headers.Builder().d();
        }
        Headers.Builder builder = new Headers.Builder();
        int iG = headers.g();
        for (int i7 = 0; i7 < iG; i7++) {
            String strE = headers.e(i7);
            if (setK.contains(strE)) {
                builder.a(strE, headers.h(i7));
            }
        }
        return builder.d();
    }

    public static Headers n(Response response) {
        return m(response.T().y0().e(), response.M());
    }

    public static boolean o(Response response, Headers headers, Request request) {
        for (String str : l(response)) {
            if (!Util.p(headers.i(str), request.d(str))) {
                return false;
            }
        }
        return true;
    }
}
