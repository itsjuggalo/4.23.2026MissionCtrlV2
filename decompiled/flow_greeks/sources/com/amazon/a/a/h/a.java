package com.amazon.a.a.h;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4274a = "name";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4275b = "time";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f4276c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, String> f4277d;

    public a(String str) {
        HashMap map = new HashMap();
        this.f4277d = map;
        map.put("name", str);
        map.put(f4275b, String.valueOf(System.currentTimeMillis()));
    }

    public a a(String str, String str2) {
        this.f4277d.put(str, str2);
        return this;
    }

    public String toString() {
        return "Metric: [" + this.f4277d.toString() + "]";
    }

    public Map<String, String> a() {
        return this.f4277d;
    }
}
