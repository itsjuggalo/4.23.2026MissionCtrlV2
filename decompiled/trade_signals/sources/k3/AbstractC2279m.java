package k3;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import c3.e;
import com.revenuecat.purchases.common.Constants;
import h3.C1875k;
import h3.p;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import l2.C2329m;

/* JADX INFO: renamed from: k3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2279m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f20387a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: k3.m$a */
    public class a implements e.InterfaceC0230e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2329m f20388a;

        public a(C2329m c2329m) {
            this.f20388a = c2329m;
        }

        @Override // c3.e.InterfaceC0230e
        public void a(c3.c cVar, c3.e eVar) {
            if (cVar != null) {
                this.f20388a.b(cVar.i());
            } else {
                this.f20388a.c(null);
            }
        }
    }

    public static int a(int i8, int i9) {
        if (i8 < i9) {
            return -1;
        }
        return i8 == i9 ? 0 : 1;
    }

    public static int b(long j8, long j9) {
        if (j8 < j9) {
            return -1;
        }
        return j8 == j9 ? 0 : 1;
    }

    public static String c(double d8) {
        StringBuilder sb = new StringBuilder(16);
        long jDoubleToLongBits = Double.doubleToLongBits(d8);
        for (int i8 = 7; i8 >= 0; i8--) {
            int i9 = (int) ((jDoubleToLongBits >>> (i8 * 8)) & 255);
            char[] cArr = f20387a;
            sb.append(cArr[(i9 >> 4) & 15]);
            sb.append(cArr[i9 & 15]);
        }
        return sb.toString();
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static String e(String str) {
        int iIndexOf = str.indexOf("//");
        if (iIndexOf == -1) {
            throw new c3.d("Firebase Database URL is missing URL scheme");
        }
        String strSubstring = str.substring(iIndexOf + 2);
        int iIndexOf2 = strSubstring.indexOf("/");
        if (iIndexOf2 == -1) {
            return "";
        }
        int iIndexOf3 = strSubstring.indexOf("?");
        int i8 = iIndexOf2 + 1;
        return iIndexOf3 != -1 ? strSubstring.substring(i8, iIndexOf3) : strSubstring.substring(i8);
    }

    public static void f(boolean z7) {
        g(z7, "");
    }

    public static void g(boolean z7, String str) {
        if (z7) {
            return;
        }
        Log.w("FirebaseDatabase", "Assertion failed: " + str);
    }

    public static C2274h h(String str) {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if (scheme == null) {
                throw new IllegalArgumentException("Database URL does not specify a URL scheme");
            }
            String host = uri.getHost();
            if (host == null) {
                throw new IllegalArgumentException("Database URL does not specify a valid host");
            }
            String queryParameter = uri.getQueryParameter("ns");
            if (queryParameter == null) {
                queryParameter = host.split("\\.", -1)[0].toLowerCase(Locale.US);
            }
            p pVar = new p();
            pVar.f18578a = host.toLowerCase(Locale.US);
            int port = uri.getPort();
            if (port != -1) {
                pVar.f18579b = scheme.equals("https") || scheme.equals("wss");
                pVar.f18578a += Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + port;
            } else {
                pVar.f18579b = true;
            }
            pVar.f18581d = pVar.f18578a;
            pVar.f18580c = queryParameter;
            String strReplace = e(str).replace("+", " ");
            AbstractC2280n.i(strReplace);
            C2274h c2274h = new C2274h();
            c2274h.f20374b = new C1875k(strReplace);
            c2274h.f20373a = pVar;
            return c2274h;
        } catch (Exception e8) {
            throw new c3.d("Invalid Firebase Database url specified: " + str, e8);
        }
    }

    public static String i(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        } catch (NoSuchAlgorithmException e8) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", e8);
        }
    }

    public static String j(String str) {
        String strReplace = str.indexOf(92) != -1 ? str.replace("\\", "\\\\") : str;
        if (str.indexOf(34) != -1) {
            strReplace = strReplace.replace("\"", "\\\"");
        }
        return '\"' + strReplace + '\"';
    }

    public static Integer k(String str) {
        boolean z7;
        int i8;
        if (str.length() > 11 || str.length() == 0) {
            return null;
        }
        int i9 = 0;
        if (str.charAt(0) == '-') {
            z7 = true;
            if (str.length() == 1) {
                return null;
            }
            i9 = 1;
        } else {
            z7 = false;
        }
        long j8 = 0;
        while (i9 < str.length()) {
            char cCharAt = str.charAt(i9);
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            j8 = (j8 * 10) + ((long) (cCharAt - '0'));
            i9++;
        }
        if (z7) {
            long j9 = -j8;
            if (j9 < -2147483648L) {
                return null;
            }
            i8 = (int) j9;
        } else {
            if (j8 > 2147483647L) {
                return null;
            }
            i8 = (int) j8;
        }
        return Integer.valueOf(i8);
    }

    public static C2273g l(e.InterfaceC0230e interfaceC0230e) {
        if (interfaceC0230e != null) {
            return new C2273g(null, interfaceC0230e);
        }
        C2329m c2329m = new C2329m();
        return new C2273g(c2329m.a(), new a(c2329m));
    }
}
