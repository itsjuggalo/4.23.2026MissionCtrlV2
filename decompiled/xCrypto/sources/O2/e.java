package O2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f3254a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f3255a = new ArrayList(20);

        public b b(String str, String str2) {
            this.f3255a.add(str);
            this.f3255a.add(str2.trim());
            return this;
        }

        public e c() {
            return new e(this);
        }

        public final void d(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i4 = 0; i4 < length; i4++) {
                char cCharAt = str.charAt(i4);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i4), str));
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("value == null");
            }
            int length2 = str2.length();
            for (int i5 = 0; i5 < length2; i5++) {
                char cCharAt2 = str2.charAt(i5);
                if (cCharAt2 <= 31 || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i5), str2));
                }
            }
        }

        public b e(String str) {
            int i4 = 0;
            while (i4 < this.f3255a.size()) {
                if (str.equalsIgnoreCase((String) this.f3255a.get(i4))) {
                    this.f3255a.remove(i4);
                    this.f3255a.remove(i4);
                    i4 -= 2;
                }
                i4 += 2;
            }
            return this;
        }

        public b f(String str, String str2) {
            d(str, str2);
            e(str);
            b(str, str2);
            return this;
        }
    }

    public String a(int i4) {
        int i5 = i4 * 2;
        if (i5 < 0) {
            return null;
        }
        String[] strArr = this.f3254a;
        if (i5 >= strArr.length) {
            return null;
        }
        return strArr[i5];
    }

    public int b() {
        return this.f3254a.length / 2;
    }

    public String c(int i4) {
        int i5 = (i4 * 2) + 1;
        if (i5 < 0) {
            return null;
        }
        String[] strArr = this.f3254a;
        if (i5 >= strArr.length) {
            return null;
        }
        return strArr[i5];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iB = b();
        for (int i4 = 0; i4 < iB; i4++) {
            sb.append(a(i4));
            sb.append(": ");
            sb.append(c(i4));
            sb.append("\n");
        }
        return sb.toString();
    }

    public e(b bVar) {
        this.f3254a = (String[]) bVar.f3255a.toArray(new String[bVar.f3255a.size()]);
    }
}
