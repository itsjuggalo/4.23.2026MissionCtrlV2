package com.amazon.a.b;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4677a = "license";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4678b = "customerId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4679c = "deviceId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f4682f;

    public g(Map<String, String> map) throws com.amazon.a.a.n.a.a.g {
        if (map == null) {
            throw com.amazon.a.a.n.a.a.g.d();
        }
        this.f4680d = a(f4677a, map);
        this.f4681e = a(f4678b, map);
        this.f4682f = a(f4679c, map);
    }

    private String a(String str, Map<String, String> map) throws com.amazon.a.a.n.a.a.g {
        String str2 = map.get(str);
        if (a(str2)) {
            throw com.amazon.a.a.n.a.a.g.a(str);
        }
        return str2;
    }

    public String b() {
        return this.f4682f;
    }

    public String c() {
        return this.f4680d;
    }

    private boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public String a() {
        return this.f4681e;
    }
}
