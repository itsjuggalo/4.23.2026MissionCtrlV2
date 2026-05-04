package d3;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7816e;

    public x(String str) {
        this.f7812a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f7813b = jSONObject.optString("productId");
        String strOptString = jSONObject.optString("type");
        this.f7814c = strOptString;
        this.f7815d = jSONObject.has("statusCode") ? jSONObject.optInt("statusCode") : 0;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.f7816e = jSONObject.optString("serializedDocid");
    }

    public String a() {
        return this.f7813b;
    }

    public String b() {
        return this.f7814c;
    }

    public String c() {
        return this.f7816e;
    }

    public int d() {
        return this.f7815d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return TextUtils.equals(this.f7812a, ((x) obj).f7812a);
        }
        return false;
    }

    public int hashCode() {
        return this.f7812a.hashCode();
    }

    public String toString() {
        return "UnfetchedProduct{productId='" + this.f7813b + "', productType='" + this.f7814c + "', statusCode=" + this.f7815d + "}";
    }
}
