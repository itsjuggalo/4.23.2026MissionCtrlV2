package R0;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: renamed from: R0.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0842y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7091e;

    public C0842y(String str) {
        this.f7087a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f7088b = jSONObject.optString("productId");
        String strOptString = jSONObject.optString("type");
        this.f7089c = strOptString;
        this.f7090d = jSONObject.has("statusCode") ? jSONObject.optInt("statusCode") : 0;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.f7091e = jSONObject.optString("serializedDocid");
    }

    public String a() {
        return this.f7088b;
    }

    public String b() {
        return this.f7089c;
    }

    public String c() {
        return this.f7091e;
    }

    public int d() {
        return this.f7090d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0842y) {
            return TextUtils.equals(this.f7087a, ((C0842y) obj).f7087a);
        }
        return false;
    }

    public int hashCode() {
        return this.f7087a.hashCode();
    }

    public String toString() {
        return "UnfetchedProduct{productId='" + this.f7088b + "', productType='" + this.f7089c + "', statusCode=" + this.f7090d + "}";
    }
}
