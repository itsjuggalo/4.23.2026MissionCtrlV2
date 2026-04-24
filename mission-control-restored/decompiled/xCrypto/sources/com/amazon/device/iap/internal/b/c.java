package com.amazon.device.iap.internal.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9156a = "KEY_TIMESTAMP";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9157b = "KEY_REQUEST_ID";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9158c = "KEY_USER_ID";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9159d = "KEY_RECEIPT_STRING";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f9162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f9163h;

    public c(String str, String str2, String str3, long j4) {
        this.f9160e = str;
        this.f9161f = str2;
        this.f9163h = str3;
        this.f9162g = j4;
    }

    public String a() {
        return this.f9160e;
    }

    public String b() {
        return this.f9163h;
    }

    public String c() {
        return this.f9161f;
    }

    public long d() {
        return this.f9162g;
    }

    public String e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f9158c, this.f9160e);
        jSONObject.put(f9159d, this.f9161f);
        jSONObject.put(f9157b, this.f9163h);
        jSONObject.put(f9156a, this.f9162g);
        return jSONObject.toString();
    }

    public static c a(String str) throws b {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new c(jSONObject.getString(f9158c), jSONObject.getString(f9159d), jSONObject.getString(f9157b), jSONObject.getLong(f9156a));
        } catch (Throwable th) {
            throw new b("Input invalid for PendingReceipt Object:" + str, th);
        }
    }
}
