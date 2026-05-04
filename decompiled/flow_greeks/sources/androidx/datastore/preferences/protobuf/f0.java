package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.c0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements e0 {
    public static int i(int i10, Object obj, Object obj2) {
        d0 d0Var = (d0) obj;
        c0 c0Var = (c0) obj2;
        int iA = 0;
        if (d0Var.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : d0Var.entrySet()) {
            iA += c0Var.a(i10, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    public static d0 j(Object obj, Object obj2) {
        d0 d0VarM = (d0) obj;
        d0 d0Var = (d0) obj2;
        if (!d0Var.isEmpty()) {
            if (!d0VarM.j()) {
                d0VarM = d0VarM.m();
            }
            d0VarM.l(d0Var);
        }
        return d0VarM;
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public Object b(Object obj) {
        ((d0) obj).k();
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public c0.a c(Object obj) {
        return ((c0) obj).c();
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public Map d(Object obj) {
        return (d0) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public Object e(Object obj) {
        return d0.f().m();
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public int f(int i10, Object obj, Object obj2) {
        return i(i10, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public boolean g(Object obj) {
        return !((d0) obj).j();
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public Map h(Object obj) {
        return (d0) obj;
    }
}
