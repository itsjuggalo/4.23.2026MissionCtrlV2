package S1;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class C2 extends U3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f3879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final A2 f3882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final A2 f3883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final A2 f3884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final A2 f3885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final A2 f3886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final A2 f3887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final A2 f3888l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final A2 f3889m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final A2 f3890n;

    public C2(C0658q3 c0658q3) {
        super(c0658q3);
        this.f3879c = (char) 0;
        this.f3880d = -1L;
        this.f3882f = new A2(this, 6, false, false);
        this.f3883g = new A2(this, 6, true, false);
        this.f3884h = new A2(this, 6, false, true);
        this.f3885i = new A2(this, 5, false, false);
        this.f3886j = new A2(this, 5, true, false);
        this.f3887k = new A2(this, 5, false, true);
        this.f3888l = new A2(this, 4, false, false);
        this.f3889m = new A2(this, 3, false, false);
        this.f3890n = new A2(this, 2, false, false);
    }

    public static String A(boolean z4, String str, Object obj, Object obj2, Object obj3) {
        String strB = B(z4, obj);
        String strB2 = B(z4, obj2);
        String strB3 = B(z4, obj3);
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

    public static String B(boolean z4, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i4 = 0;
        if (obj instanceof Long) {
            if (!z4) {
                return obj.toString();
            }
            Long l4 = (Long) obj;
            if (Math.abs(l4.longValue()) < 100) {
                return obj.toString();
            }
            char cCharAt = obj.toString().charAt(0);
            String strValueOf = String.valueOf(Math.abs(l4.longValue()));
            long jRound = Math.round(Math.pow(10.0d, strValueOf.length() - 1));
            long jRound2 = Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            int length = String.valueOf(jRound).length();
            String str = cCharAt == '-' ? "-" : "";
            StringBuilder sb = new StringBuilder(str.length() + length + 3 + str.length() + String.valueOf(jRound2).length());
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
            return obj instanceof B2 ? ((B2) obj).a() : z4 ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z4 ? th.getClass().getName() : th.toString());
        String strC = C(C0658q3.class.getCanonicalName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length2 = stackTrace.length;
        while (true) {
            if (i4 >= length2) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i4];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && C(className).equals(strC)) {
                sb2.append(": ");
                sb2.append(stackTraceElement);
                break;
            }
            i4++;
        }
        return sb2.toString();
    }

    public static String C(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(46)) == -1) ? "" : str.substring(0, iLastIndexOf);
    }

    public static Object x(String str) {
        if (str == null) {
            return null;
        }
        return new B2(str);
    }

    public final /* synthetic */ char D() {
        return this.f3879c;
    }

    public final /* synthetic */ void E(char c4) {
        this.f3879c = c4;
    }

    public final /* synthetic */ long F() {
        return this.f3880d;
    }

    public final /* synthetic */ void G(long j4) {
        this.f3880d = 130000L;
    }

    @Override // S1.U3
    public final boolean i() {
        return false;
    }

    public final A2 o() {
        return this.f3882f;
    }

    public final A2 p() {
        return this.f3883g;
    }

    public final A2 q() {
        return this.f3884h;
    }

    public final A2 r() {
        return this.f3885i;
    }

    public final A2 s() {
        return this.f3886j;
    }

    public final A2 t() {
        return this.f3887k;
    }

    public final A2 u() {
        return this.f3888l;
    }

    public final A2 v() {
        return this.f3889m;
    }

    public final A2 w() {
        return this.f3890n;
    }

    public final void y(int i4, boolean z4, boolean z5, String str, Object obj, Object obj2, Object obj3) {
        if (!z4 && Log.isLoggable(z(), i4)) {
            Log.println(i4, z(), A(false, str, obj, obj2, obj3));
        }
        if (z5 || i4 < 5) {
            return;
        }
        AbstractC0940s.k(str);
        C0594i3 c0594i3A = this.f4245a.A();
        if (c0594i3A == null) {
            Log.println(6, z(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!c0594i3A.k()) {
                Log.println(6, z(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i4 >= 9) {
                i4 = 8;
            }
            c0594i3A.t(new RunnableC0728z2(this, i4, str, obj, obj2, obj3));
        }
    }

    public final String z() {
        String str;
        synchronized (this) {
            try {
                if (this.f3881e == null) {
                    this.f3881e = this.f4245a.w().u();
                }
                AbstractC0940s.k(this.f3881e);
                str = this.f3881e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
