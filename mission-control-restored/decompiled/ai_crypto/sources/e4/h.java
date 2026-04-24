package e4;

import android.net.Uri;
import com.revenuecat.purchases.common.Constants;
import u3.C2752a;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f13632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f13633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f13634c;

    public h(Uri uri, C2752a c2752a) {
        Uri uri2;
        this.f13634c = uri;
        if (c2752a == null) {
            uri2 = f4.e.f14121k;
        } else {
            uri2 = Uri.parse("http://" + c2752a.a() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + c2752a.b() + "/v0");
        }
        this.f13632a = uri2;
        Uri.Builder builderAppendEncodedPath = uri2.buildUpon().appendPath("b").appendEncodedPath(uri.getAuthority());
        String strA = AbstractC1482d.a(uri.getPath());
        if (strA.length() > 0 && !"/".equals(strA)) {
            builderAppendEncodedPath = builderAppendEncodedPath.appendPath("o").appendPath(strA);
        }
        this.f13633b = builderAppendEncodedPath.build();
    }

    public Uri a() {
        return this.f13634c;
    }

    public Uri b() {
        return this.f13632a;
    }

    public Uri c() {
        return this.f13633b;
    }
}
