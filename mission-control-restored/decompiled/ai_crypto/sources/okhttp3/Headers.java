package okhttp3;

import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class Headers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f20489a;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f20490a = new ArrayList(20);

        public Builder a(String str, String str2) {
            Headers.a(str);
            Headers.b(str2, str);
            return c(str, str2);
        }

        public Builder b(String str) {
            int iIndexOf = str.indexOf(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 1);
            return iIndexOf != -1 ? c(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR) ? c("", str.substring(1)) : c("", str);
        }

        public Builder c(String str, String str2) {
            this.f20490a.add(str);
            this.f20490a.add(str2.trim());
            return this;
        }

        public Headers d() {
            return new Headers(this);
        }

        public String e(String str) {
            for (int size = this.f20490a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.f20490a.get(size))) {
                    return (String) this.f20490a.get(size + 1);
                }
            }
            return null;
        }

        public Builder f(String str) {
            int i7 = 0;
            while (i7 < this.f20490a.size()) {
                if (str.equalsIgnoreCase((String) this.f20490a.get(i7))) {
                    this.f20490a.remove(i7);
                    this.f20490a.remove(i7);
                    i7 -= 2;
                }
                i7 += 2;
            }
            return this;
        }

        public Builder g(String str, String str2) {
            Headers.a(str);
            Headers.b(str2, str);
            f(str);
            c(str, str2);
            return this;
        }
    }

    public Headers(Builder builder) {
        List list = builder.f20490a;
        this.f20489a = (String[]) list.toArray(new String[list.size()]);
    }

    public static void a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                throw new IllegalArgumentException(Util.q("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i7), str));
            }
        }
    }

    public static void b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                throw new IllegalArgumentException(Util.q("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i7), str2, str));
            }
        }
    }

    public static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public String c(String str) {
        return d(this.f20489a, str);
    }

    public String e(int i7) {
        return this.f20489a[i7 * 2];
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).f20489a, this.f20489a);
    }

    public Builder f() {
        Builder builder = new Builder();
        Collections.addAll(builder.f20490a, this.f20489a);
        return builder;
    }

    public int g() {
        return this.f20489a.length / 2;
    }

    public String h(int i7) {
        return this.f20489a[(i7 * 2) + 1];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f20489a);
    }

    public List i(String str) {
        int iG = g();
        ArrayList arrayList = null;
        for (int i7 = 0; i7 < iG; i7++) {
            if (str.equalsIgnoreCase(e(i7))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(h(i7));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iG = g();
        for (int i7 = 0; i7 < iG; i7++) {
            sb.append(e(i7));
            sb.append(": ");
            sb.append(h(i7));
            sb.append("\n");
        }
        return sb.toString();
    }
}
