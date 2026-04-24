package com.amazon.a.a.h;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9647a = "name";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9648b = "time";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f9649c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, String> f9650d;

    public a(String str) {
        HashMap map = new HashMap();
        this.f9650d = map;
        map.put("name", str);
        map.put(f9648b, String.valueOf(System.currentTimeMillis()));
    }

    public a a(String str, String str2) {
        this.f9650d.put(str, str2);
        return this;
    }

    public String toString() {
        return "Metric: [" + this.f9650d.toString() + "]";
    }

    public Map<String, String> a() {
        return this.f9650d;
    }
}
