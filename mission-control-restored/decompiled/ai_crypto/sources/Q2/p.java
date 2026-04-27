package Q2;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.C1210v;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f4509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f4510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f4511g;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f4513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f4515d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f4516e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f4517f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f4518g;

        public p a() {
            return new p(this.f4513b, this.f4512a, this.f4514c, this.f4515d, this.f4516e, this.f4517f, this.f4518g);
        }

        public b b(String str) {
            this.f4512a = AbstractC1207s.f(str, "ApiKey must be set.");
            return this;
        }

        public b c(String str) {
            this.f4513b = AbstractC1207s.f(str, "ApplicationId must be set.");
            return this;
        }

        public b d(String str) {
            this.f4514c = str;
            return this;
        }

        public b e(String str) {
            this.f4515d = str;
            return this;
        }

        public b f(String str) {
            this.f4516e = str;
            return this;
        }

        public b g(String str) {
            this.f4518g = str;
            return this;
        }

        public b h(String str) {
            this.f4517f = str;
            return this;
        }
    }

    public static p a(Context context) {
        C1210v c1210v = new C1210v(context);
        String strA = c1210v.a("google_app_id");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new p(strA, c1210v.a("google_api_key"), c1210v.a("firebase_database_url"), c1210v.a("ga_trackingId"), c1210v.a("gcm_defaultSenderId"), c1210v.a("google_storage_bucket"), c1210v.a("project_id"));
    }

    public String b() {
        return this.f4505a;
    }

    public String c() {
        return this.f4506b;
    }

    public String d() {
        return this.f4507c;
    }

    public String e() {
        return this.f4508d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return AbstractC1206q.b(this.f4506b, pVar.f4506b) && AbstractC1206q.b(this.f4505a, pVar.f4505a) && AbstractC1206q.b(this.f4507c, pVar.f4507c) && AbstractC1206q.b(this.f4508d, pVar.f4508d) && AbstractC1206q.b(this.f4509e, pVar.f4509e) && AbstractC1206q.b(this.f4510f, pVar.f4510f) && AbstractC1206q.b(this.f4511g, pVar.f4511g);
    }

    public String f() {
        return this.f4509e;
    }

    public String g() {
        return this.f4511g;
    }

    public String h() {
        return this.f4510f;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f4506b, this.f4505a, this.f4507c, this.f4508d, this.f4509e, this.f4510f, this.f4511g);
    }

    public String toString() {
        return AbstractC1206q.d(this).a("applicationId", this.f4506b).a("apiKey", this.f4505a).a("databaseUrl", this.f4507c).a("gcmSenderId", this.f4509e).a("storageBucket", this.f4510f).a("projectId", this.f4511g).toString();
    }

    public p(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AbstractC1207s.o(!W1.q.b(str), "ApplicationId must be set.");
        this.f4506b = str;
        this.f4505a = str2;
        this.f4507c = str3;
        this.f4508d = str4;
        this.f4509e = str5;
        this.f4510f = str6;
        this.f4511g = str7;
    }
}
