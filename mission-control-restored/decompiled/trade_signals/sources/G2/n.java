package G2;

import W1.p;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1293m;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.google.android.gms.common.internal.C1297q;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f2189g;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f2192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f2193d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f2194e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f2195f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f2196g;

        public n a() {
            return new n(this.f2191b, this.f2190a, this.f2192c, this.f2193d, this.f2194e, this.f2195f, this.f2196g);
        }

        public b b(String str) {
            this.f2190a = AbstractC1294n.e(str, "ApiKey must be set.");
            return this;
        }

        public b c(String str) {
            this.f2191b = AbstractC1294n.e(str, "ApplicationId must be set.");
            return this;
        }

        public b d(String str) {
            this.f2192c = str;
            return this;
        }

        public b e(String str) {
            this.f2193d = str;
            return this;
        }

        public b f(String str) {
            this.f2194e = str;
            return this;
        }

        public b g(String str) {
            this.f2196g = str;
            return this;
        }

        public b h(String str) {
            this.f2195f = str;
            return this;
        }
    }

    public n(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AbstractC1294n.n(!p.a(str), "ApplicationId must be set.");
        this.f2184b = str;
        this.f2183a = str2;
        this.f2185c = str3;
        this.f2186d = str4;
        this.f2187e = str5;
        this.f2188f = str6;
        this.f2189g = str7;
    }

    public static n a(Context context) {
        C1297q c1297q = new C1297q(context);
        String strA = c1297q.a("google_app_id");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new n(strA, c1297q.a("google_api_key"), c1297q.a("firebase_database_url"), c1297q.a("ga_trackingId"), c1297q.a("gcm_defaultSenderId"), c1297q.a("google_storage_bucket"), c1297q.a("project_id"));
    }

    public String b() {
        return this.f2183a;
    }

    public String c() {
        return this.f2184b;
    }

    public String d() {
        return this.f2185c;
    }

    public String e() {
        return this.f2186d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return AbstractC1293m.a(this.f2184b, nVar.f2184b) && AbstractC1293m.a(this.f2183a, nVar.f2183a) && AbstractC1293m.a(this.f2185c, nVar.f2185c) && AbstractC1293m.a(this.f2186d, nVar.f2186d) && AbstractC1293m.a(this.f2187e, nVar.f2187e) && AbstractC1293m.a(this.f2188f, nVar.f2188f) && AbstractC1293m.a(this.f2189g, nVar.f2189g);
    }

    public String f() {
        return this.f2187e;
    }

    public String g() {
        return this.f2189g;
    }

    public String h() {
        return this.f2188f;
    }

    public int hashCode() {
        return AbstractC1293m.b(this.f2184b, this.f2183a, this.f2185c, this.f2186d, this.f2187e, this.f2188f, this.f2189g);
    }

    public String toString() {
        return AbstractC1293m.c(this).a("applicationId", this.f2184b).a("apiKey", this.f2183a).a("databaseUrl", this.f2185c).a("gcmSenderId", this.f2187e).a("storageBucket", this.f2188f).a("projectId", this.f2189g).toString();
    }
}
