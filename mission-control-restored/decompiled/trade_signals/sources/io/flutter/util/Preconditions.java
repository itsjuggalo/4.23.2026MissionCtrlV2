package io.flutter.util;

/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static <T> T checkNotNull(T t8) {
        t8.getClass();
        return t8;
    }

    public static void checkState(boolean z7) {
        if (!z7) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z7, Object obj) {
        if (!z7) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
