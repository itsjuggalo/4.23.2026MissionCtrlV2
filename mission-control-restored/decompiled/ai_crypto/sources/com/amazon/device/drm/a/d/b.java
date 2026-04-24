package com.amazon.device.drm.a.d;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b implements com.amazon.device.drm.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class, Class> f10268a;

    static {
        HashMap map = new HashMap();
        f10268a = map;
        map.put(com.amazon.device.drm.a.c.class, c.class);
    }

    @Override // com.amazon.device.drm.a.b
    public <T> Class<T> a(Class<T> cls) {
        return f10268a.get(cls);
    }
}
