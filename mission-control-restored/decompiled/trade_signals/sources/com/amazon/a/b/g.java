package com.amazon.a.b;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14179a = "license";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14180b = "customerId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14181c = "deviceId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f14184f;

    public g(Map<String, String> map) throws com.amazon.a.a.n.a.a.g {
        if (map == null) {
            throw com.amazon.a.a.n.a.a.g.d();
        }
        this.f14182d = a(f14179a, map);
        this.f14183e = a(f14180b, map);
        this.f14184f = a(f14181c, map);
    }

    public String a() {
        return this.f14183e;
    }

    public String b() {
        return this.f14184f;
    }

    public String c() {
        return this.f14182d;
    }

    private String a(String str, Map<String, String> map) throws com.amazon.a.a.n.a.a.g {
        String str2 = map.get(str);
        if (a(str2)) {
            throw com.amazon.a.a.n.a.a.g.a(str);
        }
        return str2;
    }

    private boolean a(String str) {
        return str == null || str.length() == 0;
    }
}
