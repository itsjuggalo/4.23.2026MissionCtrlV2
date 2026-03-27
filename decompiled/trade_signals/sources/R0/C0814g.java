package R0;

import org.json.JSONObject;

/* JADX INFO: renamed from: R0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0814g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6965a;

    public C0814g(String str) {
        this.f6965a = new JSONObject(str).optString("countryCode");
    }

    public String a() {
        return this.f6965a;
    }
}
