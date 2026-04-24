package Y0;

import org.json.JSONObject;

/* JADX INFO: renamed from: Y0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0719d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5588a;

    public C0719d(String str) {
        this.f5588a = new JSONObject(str).optString("countryCode");
    }

    public String a() {
        return this.f5588a;
    }
}
