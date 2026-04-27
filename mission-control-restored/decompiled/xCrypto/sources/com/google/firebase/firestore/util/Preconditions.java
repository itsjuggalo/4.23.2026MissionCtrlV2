package com.google.firebase.firestore.util;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class Preconditions {
    public static void checkArgument(boolean z4, String str, Object... objArr) {
        if (!z4) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T checkNotNull(T t4) {
        t4.getClass();
        return t4;
    }

    public static void checkState(boolean z4) {
        if (!z4) {
            throw new IllegalStateException();
        }
    }

    public static <T> T checkNotNull(T t4, Object obj) {
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z4, String str) {
        if (!z4) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T checkNotNull(T t4, String str, Object... objArr) {
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException(String.format(Locale.US, str, objArr));
    }
}
