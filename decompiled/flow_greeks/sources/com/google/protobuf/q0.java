package com.google.protobuf;

import com.google.protobuf.n0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class q0 implements p0 {
    public static int i(int i10, Object obj, Object obj2) {
        o0 o0Var = (o0) obj;
        n0 n0Var = (n0) obj2;
        int iA = 0;
        if (o0Var.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : o0Var.entrySet()) {
            iA += n0Var.a(i10, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    public static o0 j(Object obj, Object obj2) {
        o0 o0VarM = (o0) obj;
        o0 o0Var = (o0) obj2;
        if (!o0Var.isEmpty()) {
            if (!o0VarM.j()) {
                o0VarM = o0VarM.m();
            }
            o0VarM.l(o0Var);
        }
        return o0VarM;
    }

    @Override // com.google.protobuf.p0
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // com.google.protobuf.p0
    public Object b(Object obj) {
        ((o0) obj).k();
        return obj;
    }

    @Override // com.google.protobuf.p0
    public n0.a c(Object obj) {
        return ((n0) obj).c();
    }

    @Override // com.google.protobuf.p0
    public Map d(Object obj) {
        return (o0) obj;
    }

    @Override // com.google.protobuf.p0
    public Object e(Object obj) {
        return o0.f().m();
    }

    @Override // com.google.protobuf.p0
    public int f(int i10, Object obj, Object obj2) {
        return i(i10, obj, obj2);
    }

    @Override // com.google.protobuf.p0
    public boolean g(Object obj) {
        return !((o0) obj).j();
    }

    @Override // com.google.protobuf.p0
    public Map h(Object obj) {
        return (o0) obj;
    }
}
