package com.amazon.device.iap.internal.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4950a = "KEY_TIMESTAMP";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4951b = "KEY_REQUEST_ID";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4952c = "KEY_USER_ID";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f4953d = "KEY_RECEIPT_STRING";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f4955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f4956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f4957h;

    public c(String str, String str2, String str3, long j10) {
        this.f4954e = str;
        this.f4955f = str2;
        this.f4957h = str3;
        this.f4956g = j10;
    }

    public String a() {
        return this.f4954e;
    }

    public String b() {
        return this.f4957h;
    }

    public String c() {
        return this.f4955f;
    }

    public long d() {
        return this.f4956g;
    }

    public String e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f4952c, this.f4954e);
        jSONObject.put(f4953d, this.f4955f);
        jSONObject.put(f4951b, this.f4957h);
        jSONObject.put(f4950a, this.f4956g);
        return jSONObject.toString();
    }

    public static c a(String str) throws b {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new c(jSONObject.getString(f4952c), jSONObject.getString(f4953d), jSONObject.getString(f4951b), jSONObject.getLong(f4950a));
        } catch (Throwable th) {
            throw new b("Input invalid for PendingReceipt Object:" + str, th);
        }
    }
}
