package okhttp3;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class HttpUrl {

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8785a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8786b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8787c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList f8788d;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.f8788d = arrayList;
            arrayList.add("");
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("//");
            if (!this.f8785a.isEmpty() || !this.f8786b.isEmpty()) {
                sb.append(this.f8785a);
                if (!this.f8786b.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f8786b);
                }
                sb.append('@');
            }
            int i = this.f8787c;
            if (i != -1) {
                if (i == -1) {
                    String str = null;
                    i = str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
                }
                sb.append(':');
                sb.append(i);
            }
            ArrayList arrayList = this.f8788d;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                sb.append('/');
                sb.append((String) arrayList.get(i6));
            }
            return sb.toString();
        }
    }

    public static void a(StringBuilder sb, List list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof HttpUrl)) {
            return false;
        }
        ((HttpUrl) obj).getClass();
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return null;
    }
}
