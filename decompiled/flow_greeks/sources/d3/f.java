package d3;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7637a;

    public f(String str) {
        this.f7637a = new JSONObject(str).optString("countryCode");
    }

    public String a() {
        return this.f7637a;
    }
}
