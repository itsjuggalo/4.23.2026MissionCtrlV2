package com.amazon.a.a.j;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9729a = "RESPONSE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9730b = "RESET_OFFSET";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9731d = "RECEIPT_STRING";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9732e = "KIWI_EXECUTION_RESULT_CODE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9733f = "RECEIPT_DELIVERED";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9734g = "PURCHASE_REQUEST_ID";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9735h = "userId";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ boolean f9736i = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f9737c = new HashMap();

    public Object a(String str) {
        return this.f9737c.get(str);
    }

    public boolean b(String str) {
        return this.f9737c.containsKey(str);
    }

    public Object c(String str) {
        return this.f9737c.remove(str);
    }

    public void a(String str, Object obj) {
        this.f9737c.put(str, obj);
    }

    public Object b() {
        return this.f9737c.get(f9729a);
    }

    public void c() {
        this.f9737c.remove(f9729a);
    }

    public boolean a(Class cls) {
        return b(f9729a) && a(f9729a).getClass().equals(cls);
    }

    public void a() {
        this.f9737c.clear();
    }

    public void a(Object obj) {
        if (!f9736i && obj == null) {
            throw new AssertionError();
        }
        this.f9737c.put(f9729a, obj);
    }
}
