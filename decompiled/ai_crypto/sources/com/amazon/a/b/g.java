package com.amazon.a.b;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10068a = "license";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10069b = "customerId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10070c = "deviceId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f10073f;

    public g(Map<String, String> map) throws com.amazon.a.a.n.a.a.g {
        if (map == null) {
            throw com.amazon.a.a.n.a.a.g.d();
        }
        this.f10071d = a(f10068a, map);
        this.f10072e = a(f10069b, map);
        this.f10073f = a(f10070c, map);
    }

    private String a(String str, Map<String, String> map) throws com.amazon.a.a.n.a.a.g {
        String str2 = map.get(str);
        if (a(str2)) {
            throw com.amazon.a.a.n.a.a.g.a(str);
        }
        return str2;
    }

    public String b() {
        return this.f10073f;
    }

    public String c() {
        return this.f10071d;
    }

    private boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public String a() {
        return this.f10072e;
    }
}
