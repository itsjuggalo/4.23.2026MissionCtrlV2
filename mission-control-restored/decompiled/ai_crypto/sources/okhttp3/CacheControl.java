package okhttp3;

import com.google.android.gms.common.api.a;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class CacheControl {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final CacheControl f20276n = new Builder().c().a();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final CacheControl f20277o = new Builder().d().b(a.e.API_PRIORITY_OTHER, TimeUnit.SECONDS).a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f20279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f20282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f20283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f20284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f20285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f20286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f20287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f20288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f20289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f20290m;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f20292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20293c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20294d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f20295e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f20296f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f20297g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f20298h;

        public CacheControl a() {
            return new CacheControl(this);
        }

        public Builder b(int i7, TimeUnit timeUnit) {
            if (i7 >= 0) {
                long seconds = timeUnit.toSeconds(i7);
                this.f20294d = seconds > 2147483647L ? a.e.API_PRIORITY_OTHER : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i7);
        }

        public Builder c() {
            this.f20291a = true;
            return this;
        }

        public Builder d() {
            this.f20296f = true;
            return this;
        }
    }

    public CacheControl(boolean z7, boolean z8, int i7, int i8, boolean z9, boolean z10, boolean z11, int i9, int i10, boolean z12, boolean z13, boolean z14, String str) {
        this.f20278a = z7;
        this.f20279b = z8;
        this.f20280c = i7;
        this.f20281d = i8;
        this.f20282e = z9;
        this.f20283f = z10;
        this.f20284g = z11;
        this.f20285h = i9;
        this.f20286i = i10;
        this.f20287j = z12;
        this.f20288k = z13;
        this.f20289l = z14;
        this.f20290m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static okhttp3.CacheControl k(okhttp3.Headers r22) {
        /*
            Method dump skipped, instruction units count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.k(okhttp3.Headers):okhttp3.CacheControl");
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f20278a) {
            sb.append("no-cache, ");
        }
        if (this.f20279b) {
            sb.append("no-store, ");
        }
        if (this.f20280c != -1) {
            sb.append("max-age=");
            sb.append(this.f20280c);
            sb.append(", ");
        }
        if (this.f20281d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f20281d);
            sb.append(", ");
        }
        if (this.f20282e) {
            sb.append("private, ");
        }
        if (this.f20283f) {
            sb.append("public, ");
        }
        if (this.f20284g) {
            sb.append("must-revalidate, ");
        }
        if (this.f20285h != -1) {
            sb.append("max-stale=");
            sb.append(this.f20285h);
            sb.append(", ");
        }
        if (this.f20286i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f20286i);
            sb.append(", ");
        }
        if (this.f20287j) {
            sb.append("only-if-cached, ");
        }
        if (this.f20288k) {
            sb.append("no-transform, ");
        }
        if (this.f20289l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean b() {
        return this.f20282e;
    }

    public boolean c() {
        return this.f20283f;
    }

    public int d() {
        return this.f20280c;
    }

    public int e() {
        return this.f20285h;
    }

    public int f() {
        return this.f20286i;
    }

    public boolean g() {
        return this.f20284g;
    }

    public boolean h() {
        return this.f20278a;
    }

    public boolean i() {
        return this.f20279b;
    }

    public boolean j() {
        return this.f20287j;
    }

    public String toString() {
        String str = this.f20290m;
        if (str != null) {
            return str;
        }
        String strA = a();
        this.f20290m = strA;
        return strA;
    }

    public CacheControl(Builder builder) {
        this.f20278a = builder.f20291a;
        this.f20279b = builder.f20292b;
        this.f20280c = builder.f20293c;
        this.f20281d = -1;
        this.f20282e = false;
        this.f20283f = false;
        this.f20284g = false;
        this.f20285h = builder.f20294d;
        this.f20286i = builder.f20295e;
        this.f20287j = builder.f20296f;
        this.f20288k = builder.f20297g;
        this.f20289l = builder.f20298h;
    }
}
