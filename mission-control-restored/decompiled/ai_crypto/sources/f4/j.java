package f4;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JSONObject f14141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f14142n;

    public j(e4.h hVar, Q2.g gVar, JSONObject jSONObject, String str) {
        super(hVar, gVar);
        this.f14141m = jSONObject;
        this.f14142n = str;
        if (TextUtils.isEmpty(str)) {
            this.f14123a = new IllegalArgumentException("mContentType is null or empty");
        }
        super.G("X-Goog-Upload-Protocol", "resumable");
        super.G("X-Goog-Upload-Command", "start");
        super.G("X-Goog-Upload-Header-Content-Type", str);
    }

    @Override // f4.e
    public String e() {
        return "POST";
    }

    @Override // f4.e
    public JSONObject g() {
        return this.f14141m;
    }

    @Override // f4.e
    public Map l() {
        HashMap map = new HashMap();
        map.put("name", j());
        map.put("uploadType", "resumable");
        return map;
    }

    @Override // f4.e
    public Uri u() {
        String authority = s().a().getAuthority();
        Uri.Builder builderBuildUpon = s().b().buildUpon();
        builderBuildUpon.appendPath("b");
        builderBuildUpon.appendPath(authority);
        builderBuildUpon.appendPath("o");
        return builderBuildUpon.build();
    }
}
