package io.flutter.util;

/* JADX INFO: loaded from: classes3.dex */
public final class Preconditions {
    private Preconditions() {
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

    public static void checkState(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
