package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

/* JADX INFO: loaded from: classes2.dex */
public final class Cookie {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f20453j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f20454k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f20455l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f20456m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f20461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f20462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f20463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f20464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f20465i;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f20466a = 253402300799999L;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f20467b = "/";
    }

    public Cookie(String str, String str2, long j7, String str3, String str4, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f20457a = str;
        this.f20458b = str2;
        this.f20459c = j7;
        this.f20460d = str3;
        this.f20461e = str4;
        this.f20462f = z7;
        this.f20463g = z8;
        this.f20465i = z9;
        this.f20464h = z10;
    }

    public static int a(String str, int i7, int i8, boolean z7) {
        while (i7 < i8) {
            char cCharAt = str.charAt(i7);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z7)) {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.I(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1 A[PHI: r0
      0x00c1: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:41:0x00bf, B:52:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static okhttp3.Cookie d(long r23, okhttp3.HttpUrl r25, java.lang.String r26) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.d(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
    }

    public static Cookie e(HttpUrl httpUrl, String str) {
        return d(System.currentTimeMillis(), httpUrl, str);
    }

    public static List f(HttpUrl httpUrl, Headers headers) {
        List listI = headers.i("Set-Cookie");
        int size = listI.size();
        ArrayList arrayList = null;
        for (int i7 = 0; i7 < size; i7++) {
            Cookie cookieE = e(httpUrl, (String) listI.get(i7));
            if (cookieE != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(cookieE);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public static String g(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strD = Util.d(str);
        if (strD != null) {
            return strD;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long h(java.lang.String r12, int r13, int r14) {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.h(java.lang.String, int, int):long");
    }

    public static long i(String str) {
        try {
            long j7 = Long.parseLong(str);
            if (j7 <= 0) {
                return Long.MIN_VALUE;
            }
            return j7;
        } catch (NumberFormatException e7) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e7;
        }
    }

    public String c() {
        return this.f20457a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return cookie.f20457a.equals(this.f20457a) && cookie.f20458b.equals(this.f20458b) && cookie.f20460d.equals(this.f20460d) && cookie.f20461e.equals(this.f20461e) && cookie.f20459c == this.f20459c && cookie.f20462f == this.f20462f && cookie.f20463g == this.f20463g && cookie.f20464h == this.f20464h && cookie.f20465i == this.f20465i;
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.f20457a.hashCode()) * 31) + this.f20458b.hashCode()) * 31) + this.f20460d.hashCode()) * 31) + this.f20461e.hashCode()) * 31;
        long j7 = this.f20459c;
        return ((((((((iHashCode + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (!this.f20462f ? 1 : 0)) * 31) + (!this.f20463g ? 1 : 0)) * 31) + (!this.f20464h ? 1 : 0)) * 31) + (!this.f20465i ? 1 : 0);
    }

    public String j(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f20457a);
        sb.append('=');
        sb.append(this.f20458b);
        if (this.f20464h) {
            if (this.f20459c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.a(new Date(this.f20459c)));
            }
        }
        if (!this.f20465i) {
            sb.append("; domain=");
            if (z7) {
                sb.append(".");
            }
            sb.append(this.f20460d);
        }
        sb.append("; path=");
        sb.append(this.f20461e);
        if (this.f20462f) {
            sb.append("; secure");
        }
        if (this.f20463g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String k() {
        return this.f20458b;
    }

    public String toString() {
        return j(false);
    }
}
