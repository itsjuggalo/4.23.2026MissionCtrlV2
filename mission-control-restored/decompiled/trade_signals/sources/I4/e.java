package I4;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f4240a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f4241a = new ArrayList(20);

        public b b(String str, String str2) {
            this.f4241a.add(str);
            this.f4241a.add(str2.trim());
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
            for (int i8 = 0; i8 < length; i8++) {
                char cCharAt = str.charAt(i8);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i8), str));
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("value == null");
            }
            int length2 = str2.length();
            for (int i9 = 0; i9 < length2; i9++) {
                char cCharAt2 = str2.charAt(i9);
                if (cCharAt2 <= 31 || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i9), str2));
                }
            }
        }

        public b e(String str) {
            int i8 = 0;
            while (i8 < this.f4241a.size()) {
                if (str.equalsIgnoreCase((String) this.f4241a.get(i8))) {
                    this.f4241a.remove(i8);
                    this.f4241a.remove(i8);
                    i8 -= 2;
                }
                i8 += 2;
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

    public e(b bVar) {
        this.f4240a = (String[]) bVar.f4241a.toArray(new String[bVar.f4241a.size()]);
    }

    public String a(int i8) {
        int i9 = i8 * 2;
        if (i9 < 0) {
            return null;
        }
        String[] strArr = this.f4240a;
        if (i9 >= strArr.length) {
            return null;
        }
        return strArr[i9];
    }

    public int b() {
        return this.f4240a.length / 2;
    }

    public String c(int i8) {
        int i9 = (i8 * 2) + 1;
        if (i9 < 0) {
            return null;
        }
        String[] strArr = this.f4240a;
        if (i9 >= strArr.length) {
            return null;
        }
        return strArr[i9];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iB = b();
        for (int i8 = 0; i8 < iB; i8++) {
            sb.append(a(i8));
            sb.append(": ");
            sb.append(c(i8));
            sb.append("\n");
        }
        return sb.toString();
    }
}
