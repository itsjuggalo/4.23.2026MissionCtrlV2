package Z3;

import android.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f5973a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5976d;

    static {
        String strEncodeToString = Base64.encodeToString(Z5.t.o(t.f5972a.e()), 10);
        f5974b = strEncodeToString;
        f5975c = "firebase_session_" + strEncodeToString + "_data";
        f5976d = "firebase_session_" + strEncodeToString + "_settings";
    }

    public final String a() {
        return f5975c;
    }

    public final String b() {
        return f5976d;
    }
}
