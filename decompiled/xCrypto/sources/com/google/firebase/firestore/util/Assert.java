package com.google.firebase.firestore.util;

/* JADX INFO: loaded from: classes.dex */
public class Assert {
    public static AssertionError fail(String str, Object... objArr) {
        throw new AssertionError(format(str, objArr));
    }

    private static String format(String str, Object... objArr) {
        return "INTERNAL ASSERTION FAILED: " + String.format(str, objArr);
    }

    public static void hardAssert(boolean z4, String str, Object... objArr) {
        if (!z4) {
            throw fail(str, objArr);
        }
    }

    public static <T> T hardAssertNonNull(T t4, String str, Object... objArr) {
        if (t4 != null) {
            return t4;
        }
        throw fail(str, objArr);
    }

    public static AssertionError fail(Throwable th, String str, Object... objArr) {
        throw ApiUtil.newAssertionError(format(str, objArr), th);
    }
}
