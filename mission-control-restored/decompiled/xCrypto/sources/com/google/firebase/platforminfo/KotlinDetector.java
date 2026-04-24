package com.google.firebase.platforminfo;

import W2.h;

/* JADX INFO: loaded from: classes.dex */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return h.f5473f.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
