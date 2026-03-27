package Z1;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.I;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3977d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3979g;

    public m(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i = B1.e.f120a;
        I.i("ApplicationId must be set.", true ^ (str == null || str.trim().isEmpty()));
        this.f3975b = str;
        this.f3974a = str2;
        this.f3976c = str3;
        this.f3977d = str4;
        this.e = str5;
        this.f3978f = str6;
        this.f3979g = str7;
    }

    public static m a(Context context) {
        Y3.d dVar = new Y3.d(context);
        String strB = dVar.B("google_app_id");
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return new m(strB, dVar.B("google_api_key"), dVar.B("firebase_database_url"), dVar.B("ga_trackingId"), dVar.B("gcm_defaultSenderId"), dVar.B("google_storage_bucket"), dVar.B("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return I.j(this.f3975b, mVar.f3975b) && I.j(this.f3974a, mVar.f3974a) && I.j(this.f3976c, mVar.f3976c) && I.j(this.f3977d, mVar.f3977d) && I.j(this.e, mVar.e) && I.j(this.f3978f, mVar.f3978f) && I.j(this.f3979g, mVar.f3979g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3975b, this.f3974a, this.f3976c, this.f3977d, this.e, this.f3978f, this.f3979g});
    }

    public final String toString() {
        Y3.d dVar = new Y3.d(this);
        dVar.h(this.f3975b, "applicationId");
        dVar.h(this.f3974a, "apiKey");
        dVar.h(this.f3976c, "databaseUrl");
        dVar.h(this.e, "gcmSenderId");
        dVar.h(this.f3978f, "storageBucket");
        dVar.h(this.f3979g, "projectId");
        return dVar.toString();
    }
}
