package com.amazon.device.iap.internal.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10341a = "KEY_TIMESTAMP";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10342b = "KEY_REQUEST_ID";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10343c = "KEY_USER_ID";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10344d = "KEY_RECEIPT_STRING";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f10346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f10347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f10348h;

    public c(String str, String str2, String str3, long j7) {
        this.f10345e = str;
        this.f10346f = str2;
        this.f10348h = str3;
        this.f10347g = j7;
    }

    public String a() {
        return this.f10345e;
    }

    public String b() {
        return this.f10348h;
    }

    public String c() {
        return this.f10346f;
    }

    public long d() {
        return this.f10347g;
    }

    public String e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f10343c, this.f10345e);
        jSONObject.put(f10344d, this.f10346f);
        jSONObject.put(f10342b, this.f10348h);
        jSONObject.put(f10341a, this.f10347g);
        return jSONObject.toString();
    }

    public static c a(String str) throws b {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new c(jSONObject.getString(f10343c), jSONObject.getString(f10344d), jSONObject.getString(f10342b), jSONObject.getLong(f10341a));
        } catch (Throwable th) {
            throw new b("Input invalid for PendingReceipt Object:" + str, th);
        }
    }
}
