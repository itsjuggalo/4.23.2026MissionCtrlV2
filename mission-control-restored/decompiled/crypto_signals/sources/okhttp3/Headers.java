package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class Headers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f8783a;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f8784a = new ArrayList(20);
    }

    public Headers(Builder builder) {
        ArrayList arrayList = builder.f8784a;
        this.f8783a = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).f8783a, this.f8783a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8783a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.f8783a.length / 2;
        for (int i = 0; i < length; i++) {
            sb.append(this.f8783a[i * 2]);
            sb.append(": ");
            sb.append(this.f8783a[(i * 2) + 1]);
            sb.append("\n");
        }
        return sb.toString();
    }
}
