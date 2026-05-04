package com.amazon.a.b;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i implements com.amazon.a.a.n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f4689a = new com.amazon.a.a.o.c("DRMSuccessTask");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4690b = "com.amazon.drm.AmazonLicenseVerificationCallback";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4691c = "onDRMSuccess";

    @Override // com.amazon.a.a.n.a
    public void a() {
        Method methodA;
        Class<?> clsA = com.amazon.a.a.o.d.a(f4690b);
        if (clsA == null || (methodA = a(clsA, f4691c)) == null) {
            return;
        }
        if (com.amazon.a.a.o.c.f4603a) {
            f4689a.a("Invoking callback: " + methodA.getName());
        }
        try {
            methodA.invoke(null, null);
            if (com.amazon.a.a.o.c.f4603a) {
                f4689a.a("Callback invoked.");
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
                if (com.amazon.a.a.o.c.f4603a) {
                    f4689a.a("No exception thrown, but method '" + str + "' was not found, this should not happen. ");
                }
                return null;
            }
            declaredMethod.setAccessible(true);
            if (!com.amazon.a.a.o.d.c(declaredMethod)) {
                if (com.amazon.a.a.o.c.f4603a) {
                    f4689a.a("Callback " + str + " isn't static, ignoring...");
                }
                return null;
            }
            if (!com.amazon.a.a.o.d.b(declaredMethod)) {
                if (com.amazon.a.a.o.c.f4603a) {
                    f4689a.a("Callback " + str + " returns a value, ignoring...");
                }
                return null;
            }
            if (!com.amazon.a.a.o.d.a(declaredMethod)) {
                return declaredMethod;
            }
            if (com.amazon.a.a.o.c.f4603a) {
                f4689a.a("Callback " + str + " takes parameters, ignoring...");
            }
            return null;
        } catch (NoSuchMethodException unused) {
            if (com.amazon.a.a.o.c.f4603a) {
                f4689a.a("Did not find method " + str);
            }
            return null;
        }
    }
}
