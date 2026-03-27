package N1;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class W extends E0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f1409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1410d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final U f1411f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final U f1412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final U f1413l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final U f1414m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final U f1415n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final U f1416o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final U f1417p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final U f1418q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final U f1419r;

    public W(C0138v0 c0138v0) {
        super(c0138v0);
        this.f1409c = (char) 0;
        this.f1410d = -1L;
        this.f1411f = new U(this, 6, false, false);
        this.f1412k = new U(this, 6, true, false);
        this.f1413l = new U(this, 6, false, true);
        this.f1414m = new U(this, 5, false, false);
        this.f1415n = new U(this, 5, true, false);
        this.f1416o = new U(this, 5, false, true);
        this.f1417p = new U(this, 4, false, false);
        this.f1418q = new U(this, 3, false, false);
        this.f1419r = new U(this, 2, false, false);
    }

    public static String A(boolean z6, String str, Object obj, Object obj2, Object obj3) {
        String strB = B(obj, z6);
        String strB2 = B(obj2, z6);
        String strB3 = B(obj3, z6);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strB)) {
            sb.append(str2);
            sb.append(strB);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strB2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strB2);
        }
        if (!TextUtils.isEmpty(strB3)) {
            sb.append(str3);
            sb.append(strB3);
        }
        return sb.toString();
    }

    public static String B(Object obj, boolean z6) {
        int iLastIndexOf;
        String className;
        int iLastIndexOf2;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z6) {
                return obj.toString();
            }
            Long l6 = (Long) obj;
            if (Math.abs(l6.longValue()) < 100) {
                return obj.toString();
            }
            char cCharAt = obj.toString().charAt(0);
            String strValueOf = String.valueOf(Math.abs(l6.longValue()));
            long jRound = Math.round(Math.pow(10.0d, strValueOf.length() - 1));
            long jRound2 = Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            int length = String.valueOf(jRound).length();
            String str = cCharAt == '-' ? "-" : "";
            StringBuilder sb = new StringBuilder(str.length() + str.length() + length + 3 + String.valueOf(jRound2).length());
            sb.append(str);
            sb.append(jRound);
            sb.append("...");
            sb.append(str);
            sb.append(jRound2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof V ? ((V) obj).f1398a : z6 ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z6 ? th.getClass().getName() : th.toString());
        String canonicalName = C0138v0.class.getCanonicalName();
        String strSubstring = (TextUtils.isEmpty(canonicalName) || (iLastIndexOf = canonicalName.lastIndexOf(46)) == -1) ? "" : canonicalName.substring(0, iLastIndexOf);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length2 = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length2) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                if (((TextUtils.isEmpty(className) || (iLastIndexOf2 = className.lastIndexOf(46)) == -1) ? "" : className.substring(0, iLastIndexOf2)).equals(strSubstring)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
            }
            i++;
        }
        return sb2.toString();
    }

    public static V x(String str) {
        if (str == null) {
            return null;
        }
        return new V(str);
    }

    @Override // N1.E0
    public final boolean q() {
        return false;
    }

    public final U t() {
        return this.f1411f;
    }

    public final U u() {
        return this.f1414m;
    }

    public final U v() {
        return this.f1418q;
    }

    public final U w() {
        return this.f1419r;
    }

    public final void y(int i, boolean z6, boolean z7, String str, Object obj, Object obj2, Object obj3) {
        if (!z6 && Log.isLoggable(z(), i)) {
            Log.println(i, z(), A(false, str, obj, obj2, obj3));
        }
        if (z7 || i < 5) {
            return;
        }
        com.google.android.gms.common.internal.I.g(str);
        C0126r0 c0126r0 = ((C0138v0) this.f1130a).f1815k;
        if (c0126r0 == null) {
            Log.println(6, z(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!c0126r0.f1239b) {
                Log.println(6, z(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i >= 9) {
                i = 8;
            }
            c0126r0.y(new T(this, i, str, obj, obj2, obj3));
        }
    }

    public final String z() {
        String str;
        synchronized (this) {
            try {
                if (this.e == null) {
                    ((C0138v0) ((C0138v0) this.f1130a).f1813d.f1130a).getClass();
                    this.e = "FA";
                }
                com.google.android.gms.common.internal.I.g(this.e);
                str = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
