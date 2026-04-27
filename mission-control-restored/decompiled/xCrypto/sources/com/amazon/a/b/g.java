package com.amazon.a.b;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8883a = "license";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8884b = "customerId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8885c = "deviceId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f8887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f8888f;

    public g(Map<String, String> map) throws com.amazon.a.a.n.a.a.g {
        if (map == null) {
            throw com.amazon.a.a.n.a.a.g.d();
        }
        this.f8886d = a(f8883a, map);
        this.f8887e = a(f8884b, map);
        this.f8888f = a(f8885c, map);
    }

    private String a(String str, Map<String, String> map) throws com.amazon.a.a.n.a.a.g {
        String str2 = map.get(str);
        if (a(str2)) {
            throw com.amazon.a.a.n.a.a.g.a(str);
        }
        return str2;
    }

    public String b() {
        return this.f8888f;
    }

    public String c() {
        return this.f8886d;
    }

    private boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public String a() {
        return this.f8887e;
    }
}
