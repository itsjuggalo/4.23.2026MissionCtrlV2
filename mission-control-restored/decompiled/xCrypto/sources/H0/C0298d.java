package H0;

import org.json.JSONObject;

/* JADX INFO: renamed from: H0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0298d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f661a;

    public C0298d(String str) {
        this.f661a = new JSONObject(str).optString("countryCode");
    }

    public String a() {
        return this.f661a;
    }
}
