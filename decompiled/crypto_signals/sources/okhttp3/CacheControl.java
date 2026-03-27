package okhttp3;

import com.google.android.gms.common.api.f;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class CacheControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8730a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8736h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f8737j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f8740m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8731b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8732c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8733d = -1;
    public final boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8734f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f8735g = false;
    public final int i = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f8738k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f8739l = false;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8742b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8743c;
    }

    static {
        Builder builder = new Builder();
        builder.f8741a = true;
        new CacheControl(builder);
        Builder builder2 = new Builder();
        builder2.f8743c = true;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        int i = f.API_PRIORITY_OTHER;
        long seconds = timeUnit.toSeconds(f.API_PRIORITY_OTHER);
        if (seconds <= 2147483647L) {
            i = (int) seconds;
        }
        builder2.f8742b = i;
        new CacheControl(builder2);
    }

    public CacheControl(Builder builder) {
        this.f8730a = builder.f8741a;
        this.f8736h = builder.f8742b;
        this.f8737j = builder.f8743c;
    }

    public final String toString() {
        String string;
        String str = this.f8740m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f8730a) {
            sb.append("no-cache, ");
        }
        if (this.f8731b) {
            sb.append("no-store, ");
        }
        int i = this.f8732c;
        if (i != -1) {
            sb.append("max-age=");
            sb.append(i);
            sb.append(", ");
        }
        int i6 = this.f8733d;
        if (i6 != -1) {
            sb.append("s-maxage=");
            sb.append(i6);
            sb.append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f8734f) {
            sb.append("public, ");
        }
        if (this.f8735g) {
            sb.append("must-revalidate, ");
        }
        int i7 = this.f8736h;
        if (i7 != -1) {
            sb.append("max-stale=");
            sb.append(i7);
            sb.append(", ");
        }
        int i8 = this.i;
        if (i8 != -1) {
            sb.append("min-fresh=");
            sb.append(i8);
            sb.append(", ");
        }
        if (this.f8737j) {
            sb.append("only-if-cached, ");
        }
        if (this.f8738k) {
            sb.append("no-transform, ");
        }
        if (this.f8739l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            string = "";
        } else {
            sb.delete(sb.length() - 2, sb.length());
            string = sb.toString();
        }
        this.f8740m = string;
        return string;
    }
}
