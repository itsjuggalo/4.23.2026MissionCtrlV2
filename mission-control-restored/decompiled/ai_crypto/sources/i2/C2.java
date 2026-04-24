package i2;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class C2 extends U3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f15038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f15040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final A2 f15041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final A2 f15042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final A2 f15043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final A2 f15044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final A2 f15045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final A2 f15046k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final A2 f15047l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final A2 f15048m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final A2 f15049n;

    public C2(C1898q3 c1898q3) {
        super(c1898q3);
        this.f15038c = (char) 0;
        this.f15039d = -1L;
        this.f15041f = new A2(this, 6, false, false);
        this.f15042g = new A2(this, 6, true, false);
        this.f15043h = new A2(this, 6, false, true);
        this.f15044i = new A2(this, 5, false, false);
        this.f15045j = new A2(this, 5, true, false);
        this.f15046k = new A2(this, 5, false, true);
        this.f15047l = new A2(this, 4, false, false);
        this.f15048m = new A2(this, 3, false, false);
        this.f15049n = new A2(this, 2, false, false);
    }

    public static String A(boolean z7, String str, Object obj, Object obj2, Object obj3) {
        String strB = B(z7, obj);
        String strB2 = B(z7, obj2);
        String strB3 = B(z7, obj3);
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

    public static String B(boolean z7, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i7 = 0;
        if (obj instanceof Long) {
            if (!z7) {
                return obj.toString();
            }
            Long l7 = (Long) obj;
            if (Math.abs(l7.longValue()) < 100) {
                return obj.toString();
            }
            char cCharAt = obj.toString().charAt(0);
            String strValueOf = String.valueOf(Math.abs(l7.longValue()));
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
            return obj instanceof B2 ? ((B2) obj).a() : z7 ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z7 ? th.getClass().getName() : th.toString());
        String strC = C(C1898q3.class.getCanonicalName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length2 = stackTrace.length;
        while (true) {
            if (i7 >= length2) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i7];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && C(className).equals(strC)) {
                sb2.append(": ");
                sb2.append(stackTraceElement);
                break;
            }
            i7++;
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
        return this.f15038c;
    }

    public final /* synthetic */ void E(char c7) {
        this.f15038c = c7;
    }

    public final /* synthetic */ long F() {
        return this.f15039d;
    }

    public final /* synthetic */ void G(long j7) {
        this.f15039d = 130000L;
    }

    @Override // i2.U3
    public final boolean i() {
        return false;
    }

    public final A2 o() {
        return this.f15041f;
    }

    public final A2 p() {
        return this.f15042g;
    }

    public final A2 q() {
        return this.f15043h;
    }

    public final A2 r() {
        return this.f15044i;
    }

    public final A2 s() {
        return this.f15045j;
    }

    public final A2 t() {
        return this.f15046k;
    }

    public final A2 u() {
        return this.f15047l;
    }

    public final A2 v() {
        return this.f15048m;
    }

    public final A2 w() {
        return this.f15049n;
    }

    public final void y(int i7, boolean z7, boolean z8, String str, Object obj, Object obj2, Object obj3) {
        if (!z7 && Log.isLoggable(z(), i7)) {
            Log.println(i7, z(), A(false, str, obj, obj2, obj3));
        }
        if (z8 || i7 < 5) {
            return;
        }
        AbstractC1207s.k(str);
        C1834i3 c1834i3A = this.f15404a.A();
        if (c1834i3A == null) {
            Log.println(6, z(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!c1834i3A.k()) {
                Log.println(6, z(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i7 >= 9) {
                i7 = 8;
            }
            c1834i3A.t(new RunnableC1969z2(this, i7, str, obj, obj2, obj3));
        }
    }

    public final String z() {
        String str;
        synchronized (this) {
            try {
                if (this.f15040e == null) {
                    this.f15040e = this.f15404a.w().u();
                }
                AbstractC1207s.k(this.f15040e);
                str = this.f15040e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
