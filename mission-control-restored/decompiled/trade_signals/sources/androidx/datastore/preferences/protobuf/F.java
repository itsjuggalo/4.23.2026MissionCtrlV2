package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class F implements E {
    public static int i(int i8, Object obj, Object obj2) {
        D d8 = (D) obj;
        C c8 = (C) obj2;
        int iA = 0;
        if (d8.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : d8.entrySet()) {
            iA += c8.a(i8, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    public static D j(Object obj, Object obj2) {
        D dM = (D) obj;
        D d8 = (D) obj2;
        if (!d8.isEmpty()) {
            if (!dM.j()) {
                dM = dM.m();
            }
            dM.l(d8);
        }
        return dM;
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public Object b(Object obj) {
        ((D) obj).k();
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public C.a c(Object obj) {
        return ((C) obj).c();
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public Map d(Object obj) {
        return (D) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public Object e(Object obj) {
        return D.e().m();
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public int f(int i8, Object obj, Object obj2) {
        return i(i8, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public boolean g(Object obj) {
        return !((D) obj).j();
    }

    @Override // androidx.datastore.preferences.protobuf.E
    public Map h(Object obj) {
        return (D) obj;
    }
}
