package com.amazon.a.a.j;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8544a = "RESPONSE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8545b = "RESET_OFFSET";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8546d = "RECEIPT_STRING";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8547e = "KIWI_EXECUTION_RESULT_CODE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f8548f = "RECEIPT_DELIVERED";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f8549g = "PURCHASE_REQUEST_ID";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f8550h = "userId";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ boolean f8551i = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f8552c = new HashMap();

    public Object a(String str) {
        return this.f8552c.get(str);
    }

    public boolean b(String str) {
        return this.f8552c.containsKey(str);
    }

    public Object c(String str) {
        return this.f8552c.remove(str);
    }

    public void a(String str, Object obj) {
        this.f8552c.put(str, obj);
    }

    public Object b() {
        return this.f8552c.get(f8544a);
    }

    public void c() {
        this.f8552c.remove(f8544a);
    }

    public boolean a(Class cls) {
        return b(f8544a) && a(f8544a).getClass().equals(cls);
    }

    public void a() {
        this.f8552c.clear();
    }

    public void a(Object obj) {
        if (!f8551i && obj == null) {
            throw new AssertionError();
        }
        this.f8552c.put(f8544a, obj);
    }
}
