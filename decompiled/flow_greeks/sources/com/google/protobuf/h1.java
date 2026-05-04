package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h1 f6995c = new h1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f6997b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f6996a = new m0();

    public static h1 a() {
        return f6995c;
    }

    public m1 b(Class cls, m1 m1Var) {
        c0.b(cls, "messageType");
        c0.b(m1Var, com.amazon.device.simplesignin.a.a.a.E);
        return (m1) this.f6997b.putIfAbsent(cls, m1Var);
    }

    public m1 c(Class cls) {
        m1 m1VarB;
        c0.b(cls, "messageType");
        m1 m1VarA = (m1) this.f6997b.get(cls);
        return (m1VarA != null || (m1VarB = b(cls, (m1VarA = this.f6996a.a(cls)))) == null) ? m1VarA : m1VarB;
    }

    public m1 d(Object obj) {
        return c(obj.getClass());
    }
}
