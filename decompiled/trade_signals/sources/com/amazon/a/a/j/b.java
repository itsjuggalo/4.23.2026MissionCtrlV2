package com.amazon.a.a.j;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13840a = "RESPONSE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13841b = "RESET_OFFSET";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13842d = "RECEIPT_STRING";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13843e = "KIWI_EXECUTION_RESULT_CODE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13844f = "RECEIPT_DELIVERED";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13845g = "PURCHASE_REQUEST_ID";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13846h = "userId";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ boolean f13847i = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f13848c = new HashMap();

    public Object a(String str) {
        return this.f13848c.get(str);
    }

    public Object b() {
        return this.f13848c.get(f13840a);
    }

    public Object c(String str) {
        return this.f13848c.remove(str);
    }

    public void a() {
        this.f13848c.clear();
    }

    public boolean b(String str) {
        return this.f13848c.containsKey(str);
    }

    public void c() {
        this.f13848c.remove(f13840a);
    }

    public void a(Object obj) {
        if (!f13847i && obj == null) {
            throw new AssertionError();
        }
        this.f13848c.put(f13840a, obj);
    }

    public void a(String str, Object obj) {
        this.f13848c.put(str, obj);
    }

    public boolean a(Class cls) {
        return b(f13840a) && a(f13840a).getClass().equals(cls);
    }
}
