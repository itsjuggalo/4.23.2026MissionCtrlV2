package e8;

import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f8470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f8471e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8474c;

    static {
        HashMap map = new HashMap();
        f8470d = map;
        map.put(-1, "The transaction needs to be run again with current data");
        map.put(-2, "The server indicated that this operation failed");
        map.put(-3, "This client does not have permission to perform this operation");
        map.put(-4, "The operation had to be aborted due to a network disconnect");
        map.put(-6, "The supplied auth token has expired");
        map.put(-7, "The supplied auth token was invalid");
        map.put(-8, "The transaction had too many retries");
        map.put(-9, "The transaction was overridden by a subsequent set");
        map.put(-10, "The service is unavailable");
        map.put(-11, "User code called from the Firebase Database runloop threw an exception:\n");
        map.put(-24, "The operation could not be performed due to a network error");
        map.put(-25, "The write was canceled by the user.");
        map.put(-999, FlutterFirebaseDatabaseException.UNKNOWN_ERROR_MESSAGE);
        HashMap map2 = new HashMap();
        f8471e = map2;
        map2.put("datastale", -1);
        map2.put("failure", -2);
        map2.put("permission_denied", -3);
        map2.put("disconnected", -4);
        map2.put("expired_token", -6);
        map2.put("invalid_token", -7);
        map2.put("maxretries", -8);
        map2.put("overriddenbyset", -9);
        map2.put("unavailable", -10);
        map2.put("network_error", -24);
        map2.put("write_canceled", -25);
    }

    public c(int i10, String str) {
        this(i10, str, null);
    }

    public static c a(int i10) {
        Map map = f8470d;
        if (map.containsKey(Integer.valueOf(i10))) {
            return new c(i10, (String) map.get(Integer.valueOf(i10)), null);
        }
        throw new IllegalArgumentException("Invalid Firebase Database error code: " + i10);
    }

    public static c b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new c(-11, ((String) f8470d.get(-11)) + stringWriter.toString());
    }

    public static c c(String str) {
        return d(str, null);
    }

    public static c d(String str, String str2) {
        return e(str, str2, null);
    }

    public static c e(String str, String str2, String str3) {
        Integer num = (Integer) f8471e.get(str.toLowerCase(Locale.US));
        if (num == null) {
            num = -999;
        }
        if (str2 == null) {
            str2 = (String) f8470d.get(num);
        }
        return new c(num.intValue(), str2, str3);
    }

    public int f() {
        return this.f8472a;
    }

    public String g() {
        return this.f8474c;
    }

    public String h() {
        return this.f8473b;
    }

    public d i() {
        return new d("Firebase Database error: " + this.f8473b);
    }

    public String toString() {
        return "DatabaseError: " + this.f8473b;
    }

    public c(int i10, String str, String str2) {
        this.f8472a = i10;
        this.f8473b = str;
        this.f8474c = str2 == null ? "" : str2;
    }
}
