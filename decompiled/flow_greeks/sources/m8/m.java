package m8;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.revenuecat.purchases.common.Constants;
import e8.e;
import j8.q;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f16112a = "0123456789abcdef".toCharArray();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements e.InterfaceC0157e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f16113a;

        public a(TaskCompletionSource taskCompletionSource) {
            this.f16113a = taskCompletionSource;
        }

        @Override // e8.e.InterfaceC0157e
        public void a(e8.c cVar, e8.e eVar) {
            if (cVar != null) {
                this.f16113a.setException(cVar.i());
            } else {
                this.f16113a.setResult(null);
            }
        }
    }

    public static int a(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    public static int b(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j10 == j11 ? 0 : 1;
    }

    public static String c(double d10) {
        StringBuilder sb2 = new StringBuilder(16);
        long jDoubleToLongBits = Double.doubleToLongBits(d10);
        for (int i10 = 7; i10 >= 0; i10--) {
            int i11 = (int) ((jDoubleToLongBits >>> (i10 * 8)) & 255);
            char[] cArr = f16112a;
            sb2.append(cArr[(i11 >> 4) & 15]);
            sb2.append(cArr[i11 & 15]);
        }
        return sb2.toString();
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
            throw new e8.d("Firebase Database URL is missing URL scheme");
        }
        String strSubstring = str.substring(iIndexOf + 2);
        int iIndexOf2 = strSubstring.indexOf("/");
        if (iIndexOf2 == -1) {
            return "";
        }
        int iIndexOf3 = strSubstring.indexOf("?");
        return iIndexOf3 != -1 ? strSubstring.substring(iIndexOf2 + 1, iIndexOf3) : strSubstring.substring(iIndexOf2 + 1);
    }

    public static void f(boolean z10) {
        g(z10, "");
    }

    public static void g(boolean z10, String str) {
        if (z10) {
            return;
        }
        Log.w("FirebaseDatabase", "Assertion failed: " + str);
    }

    public static h h(String str) {
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
            q qVar = new q();
            qVar.f14135a = host.toLowerCase(Locale.US);
            int port = uri.getPort();
            if (port != -1) {
                qVar.f14136b = scheme.equals("https") || scheme.equals("wss");
                qVar.f14135a += Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + port;
            } else {
                qVar.f14136b = true;
            }
            qVar.f14138d = qVar.f14135a;
            qVar.f14137c = queryParameter;
            String strReplace = e(str).replace("+", " ");
            n.i(strReplace);
            h hVar = new h();
            hVar.f16099b = new j8.l(strReplace);
            hVar.f16098a = qVar;
            return hVar;
        } catch (Exception e10) {
            throw new e8.d("Invalid Firebase Database url specified: " + str, e10);
        }
    }

    public static String i(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", e10);
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
        boolean z10;
        if (str.length() > 11 || str.length() == 0) {
            return null;
        }
        int i10 = 0;
        if (str.charAt(0) == '-') {
            z10 = true;
            if (str.length() == 1) {
                return null;
            }
            i10 = 1;
        } else {
            z10 = false;
        }
        long j10 = 0;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            j10 = (j10 * 10) + ((long) (cCharAt - '0'));
            i10++;
        }
        if (!z10) {
            if (j10 > 2147483647L) {
                return null;
            }
            return Integer.valueOf((int) j10);
        }
        long j11 = -j10;
        if (j11 < -2147483648L) {
            return null;
        }
        return Integer.valueOf((int) j11);
    }

    public static g l(e.InterfaceC0157e interfaceC0157e) {
        if (interfaceC0157e != null) {
            return new g(null, interfaceC0157e);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        return new g(taskCompletionSource.getTask(), new a(taskCompletionSource));
    }
}
