package com.amazon.a.a.j;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4356a = "RESPONSE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4357b = "RESET_OFFSET";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f4358d = "RECEIPT_STRING";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f4359e = "KIWI_EXECUTION_RESULT_CODE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f4360f = "RECEIPT_DELIVERED";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f4361g = "PURCHASE_REQUEST_ID";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f4362h = "userId";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ boolean f4363i = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f4364c = new HashMap();

    public Object a(String str) {
        return this.f4364c.get(str);
    }

    public boolean b(String str) {
        return this.f4364c.containsKey(str);
    }

    public Object c(String str) {
        return this.f4364c.remove(str);
    }

    public void a(String str, Object obj) {
        this.f4364c.put(str, obj);
    }

    public Object b() {
        return this.f4364c.get(f4356a);
    }

    public void c() {
        this.f4364c.remove(f4356a);
    }

    public boolean a(Class cls) {
        return b(f4356a) && a(f4356a).getClass().equals(cls);
    }

    public void a() {
        this.f4364c.clear();
    }

    public void a(Object obj) {
        if (!f4363i && obj == null) {
            throw new AssertionError();
        }
        this.f4364c.put(f4356a, obj);
    }
}
