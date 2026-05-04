package com.amazon.a.a.o;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException(str + " must not be null");
    }

    public static void a(String str, String str2) {
        if (a(str)) {
            throw new IllegalArgumentException(str2 + " must not be null or empty");
        }
    }

    public static void a(Collection<? extends Object> collection, String str) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException(str + " must not be empty");
        }
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
