package com.amazon.device.iap.internal.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14452a = "KEY_TIMESTAMP";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14453b = "KEY_REQUEST_ID";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14454c = "KEY_USER_ID";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14455d = "KEY_RECEIPT_STRING";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f14457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f14458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f14459h;

    public c(String str, String str2, String str3, long j8) {
        this.f14456e = str;
        this.f14457f = str2;
        this.f14459h = str3;
        this.f14458g = j8;
    }

    public static c a(String str) throws b {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new c(jSONObject.getString(f14454c), jSONObject.getString(f14455d), jSONObject.getString(f14453b), jSONObject.getLong(f14452a));
        } catch (Throwable th) {
            throw new b("Input invalid for PendingReceipt Object:" + str, th);
        }
    }

    public String b() {
        return this.f14459h;
    }

    public String c() {
        return this.f14457f;
    }

    public long d() {
        return this.f14458g;
    }

    public String e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f14454c, this.f14456e);
        jSONObject.put(f14455d, this.f14457f);
        jSONObject.put(f14453b, this.f14459h);
        jSONObject.put(f14452a, this.f14458g);
        return jSONObject.toString();
    }

    public String a() {
        return this.f14456e;
    }
}
