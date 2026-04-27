package com.google.protobuf;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: com.google.protobuf.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0491v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile C0491v f5805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0491v f5806b;

    static {
        C0491v c0491v = new C0491v();
        Map map = Collections.EMPTY_MAP;
        f5806b = c0491v;
    }

    public static C0491v a() {
        C0491v c0491v;
        C0491v c0491v2 = f5805a;
        if (c0491v2 != null) {
            return c0491v2;
        }
        synchronized (C0491v.class) {
            try {
                c0491v = f5805a;
                if (c0491v == null) {
                    Class cls = AbstractC0489u.f5801a;
                    C0491v c0491v3 = null;
                    if (cls != null) {
                        try {
                            c0491v3 = (C0491v) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
                        } catch (Exception unused) {
                        }
                    }
                    c0491v = c0491v3 != null ? c0491v3 : f5806b;
                    f5805a = c0491v;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0491v;
    }
}
