package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public final class U {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final U f16320c = new U();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f16322b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z f16321a = new B();

    public static U a() {
        return f16320c;
    }

    public Y b(Class cls, Y y7) {
        AbstractC1481u.b(cls, "messageType");
        AbstractC1481u.b(y7, com.amazon.device.simplesignin.a.a.a.f14556E);
        return (Y) this.f16322b.putIfAbsent(cls, y7);
    }

    public Y c(Class cls) {
        AbstractC1481u.b(cls, "messageType");
        Y y7 = (Y) this.f16322b.get(cls);
        if (y7 != null) {
            return y7;
        }
        Y yA = this.f16321a.a(cls);
        Y yB = b(cls, yA);
        return yB != null ? yB : yA;
    }

    public Y d(Object obj) {
        return c(obj.getClass());
    }
}
