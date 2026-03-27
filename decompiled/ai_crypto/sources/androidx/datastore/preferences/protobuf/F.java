package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class F implements E {
    public static int i(int i7, Object obj, Object obj2) {
        D d7 = (D) obj;
        C c7 = (C) obj2;
        int iA = 0;
        if (d7.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : d7.entrySet()) {
            iA += c7.a(i7, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    public static D j(Object obj, Object obj2) {
        D dM = (D) obj;
        D d7 = (D) obj2;
        if (!d7.isEmpty()) {
            if (!dM.j()) {
                dM = dM.m();
            }
            dM.l(d7);
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
    public int f(int i7, Object obj, Object obj2) {
        return i(i7, obj, obj2);
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
