package f4;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d extends e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f14119m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f14120n;

    public d(e4.h hVar, Q2.g gVar, Integer num, String str) {
        super(hVar, gVar);
        this.f14119m = num;
        this.f14120n = str;
    }

    @Override // f4.e
    public String e() {
        return "GET";
    }

    @Override // f4.e
    public Map l() {
        HashMap map = new HashMap();
        String strJ = j();
        if (!strJ.isEmpty()) {
            map.put("prefix", strJ + "/");
        }
        map.put("delimiter", "/");
        Integer num = this.f14119m;
        if (num != null) {
            map.put("maxResults", Integer.toString(num.intValue()));
        }
        if (!TextUtils.isEmpty(this.f14120n)) {
            map.put("pageToken", this.f14120n);
        }
        return map;
    }

    @Override // f4.e
    public Uri u() {
        return Uri.parse(s().b() + "/b/" + s().a().getAuthority() + "/o");
    }
}
