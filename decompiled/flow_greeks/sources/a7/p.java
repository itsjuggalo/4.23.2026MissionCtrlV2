package a7;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f332g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f336d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f337e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f338f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f339g;

        public p a() {
            return new p(this.f334b, this.f333a, this.f335c, this.f336d, this.f337e, this.f338f, this.f339g);
        }

        public b b(String str) {
            this.f333a = com.google.android.gms.common.internal.s.f(str, "ApiKey must be set.");
            return this;
        }

        public b c(String str) {
            this.f334b = com.google.android.gms.common.internal.s.f(str, "ApplicationId must be set.");
            return this;
        }

        public b d(String str) {
            this.f335c = str;
            return this;
        }

        public b e(String str) {
            this.f336d = str;
            return this;
        }

        public b f(String str) {
            this.f337e = str;
            return this;
        }

        public b g(String str) {
            this.f339g = str;
            return this;
        }

        public b h(String str) {
            this.f338f = str;
            return this;
        }
    }

    public static p a(Context context) {
        v vVar = new v(context);
        String strA = vVar.a("google_app_id");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new p(strA, vVar.a("google_api_key"), vVar.a("firebase_database_url"), vVar.a("ga_trackingId"), vVar.a("gcm_defaultSenderId"), vVar.a("google_storage_bucket"), vVar.a("project_id"));
    }

    public String b() {
        return this.f326a;
    }

    public String c() {
        return this.f327b;
    }

    public String d() {
        return this.f328c;
    }

    public String e() {
        return this.f329d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return com.google.android.gms.common.internal.q.b(this.f327b, pVar.f327b) && com.google.android.gms.common.internal.q.b(this.f326a, pVar.f326a) && com.google.android.gms.common.internal.q.b(this.f328c, pVar.f328c) && com.google.android.gms.common.internal.q.b(this.f329d, pVar.f329d) && com.google.android.gms.common.internal.q.b(this.f330e, pVar.f330e) && com.google.android.gms.common.internal.q.b(this.f331f, pVar.f331f) && com.google.android.gms.common.internal.q.b(this.f332g, pVar.f332g);
    }

    public String f() {
        return this.f330e;
    }

    public String g() {
        return this.f332g;
    }

    public String h() {
        return this.f331f;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f327b, this.f326a, this.f328c, this.f329d, this.f330e, this.f331f, this.f332g);
    }

    public String toString() {
        return com.google.android.gms.common.internal.q.d(this).a("applicationId", this.f327b).a("apiKey", this.f326a).a("databaseUrl", this.f328c).a("gcmSenderId", this.f330e).a("storageBucket", this.f331f).a("projectId", this.f332g).toString();
    }

    public p(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.google.android.gms.common.internal.s.o(!t5.p.b(str), "ApplicationId must be set.");
        this.f327b = str;
        this.f326a = str2;
        this.f328c = str3;
        this.f329d = str4;
        this.f330e = str5;
        this.f331f = str6;
        this.f332g = str7;
    }
}
