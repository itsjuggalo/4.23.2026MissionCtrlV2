package com.google.firebase.storage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5574h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5568a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5569b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5570c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public P3.u f5571d = P3.u.k("");
    public String e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5572f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5573g = null;
    public String i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public P3.u f5575j = P3.u.k("");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public P3.u f5576k = P3.u.k("");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public P3.u f5577l = P3.u.k("");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public P3.u f5578m = P3.u.k("");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public P3.u f5579n = P3.u.k(Collections.EMPTY_MAP);

    public final JSONObject a() {
        HashMap map = new HashMap();
        P3.u uVar = this.f5571d;
        if (uVar.f2601b) {
            map.put("contentType", (String) uVar.f2602c);
        }
        if (this.f5579n.f2601b) {
            map.put("metadata", new JSONObject((Map) this.f5579n.f2602c));
        }
        P3.u uVar2 = this.f5575j;
        if (uVar2.f2601b) {
            map.put("cacheControl", (String) uVar2.f2602c);
        }
        P3.u uVar3 = this.f5576k;
        if (uVar3.f2601b) {
            map.put("contentDisposition", (String) uVar3.f2602c);
        }
        P3.u uVar4 = this.f5577l;
        if (uVar4.f2601b) {
            map.put("contentEncoding", (String) uVar4.f2602c);
        }
        P3.u uVar5 = this.f5578m;
        if (uVar5.f2601b) {
            map.put("contentLanguage", (String) uVar5.f2602c);
        }
        return new JSONObject(map);
    }
}
