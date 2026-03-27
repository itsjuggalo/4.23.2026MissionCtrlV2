package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i0 f12660c = new i0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f12662b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f12661a = new M();

    public static i0 a() {
        return f12660c;
    }

    public n0 b(Class cls, n0 n0Var) {
        C.b(cls, "messageType");
        C.b(n0Var, com.amazon.device.simplesignin.a.a.a.f10445E);
        return (n0) this.f12662b.putIfAbsent(cls, n0Var);
    }

    public n0 c(Class cls) {
        C.b(cls, "messageType");
        n0 n0Var = (n0) this.f12662b.get(cls);
        if (n0Var != null) {
            return n0Var;
        }
        n0 n0VarA = this.f12661a.a(cls);
        n0 n0VarB = b(cls, n0VarA);
        return n0VarB != null ? n0VarB : n0VarA;
    }

    public n0 d(Object obj) {
        return c(obj.getClass());
    }
}
