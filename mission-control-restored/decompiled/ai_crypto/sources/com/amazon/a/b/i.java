package com.amazon.a.b;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class i implements com.amazon.a.a.n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f10080a = new com.amazon.a.a.o.c("DRMSuccessTask");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10081b = "com.amazon.drm.AmazonLicenseVerificationCallback";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10082c = "onDRMSuccess";

    @Override // com.amazon.a.a.n.a
    public void a() {
        Method methodA;
        Class<?> clsA = com.amazon.a.a.o.d.a(f10081b);
        if (clsA == null || (methodA = a(clsA, f10082c)) == null) {
            return;
        }
        if (com.amazon.a.a.o.c.f9994a) {
            f10080a.a("Invoking callback: " + methodA.getName());
        }
        try {
            methodA.invoke(null, null);
            if (com.amazon.a.a.o.c.f9994a) {
                f10080a.a("Callback invoked.");
            }
        } catch (Exception unused) {
        }
    }

    private static Method a(Class<?> cls, String str) {
        com.amazon.a.a.o.a.a.a((Object) cls, "Class<?> target");
        com.amazon.a.a.o.a.a.a((Object) str, "String methodName");
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, null);
            if (declaredMethod == null) {
                if (com.amazon.a.a.o.c.f9994a) {
                    f10080a.a("No exception thrown, but method '" + str + "' was not found, this should not happen. ");
                }
                return null;
            }
            declaredMethod.setAccessible(true);
            if (!com.amazon.a.a.o.d.c(declaredMethod)) {
                if (com.amazon.a.a.o.c.f9994a) {
                    f10080a.a("Callback " + str + " isn't static, ignoring...");
                }
                return null;
            }
            if (!com.amazon.a.a.o.d.b(declaredMethod)) {
                if (com.amazon.a.a.o.c.f9994a) {
                    f10080a.a("Callback " + str + " returns a value, ignoring...");
                }
                return null;
            }
            if (!com.amazon.a.a.o.d.a(declaredMethod)) {
                return declaredMethod;
            }
            if (com.amazon.a.a.o.c.f9994a) {
                f10080a.a("Callback " + str + " takes parameters, ignoring...");
            }
            return null;
        } catch (NoSuchMethodException unused) {
            if (com.amazon.a.a.o.c.f9994a) {
                f10080a.a("Did not find method " + str);
            }
            return null;
        }
    }
}
