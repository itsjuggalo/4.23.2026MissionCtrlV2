package com.google.protobuf;

import com.google.protobuf.O;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class S implements Q {
    public static int i(int i4, Object obj, Object obj2) {
        P p4 = (P) obj;
        O o4 = (O) obj2;
        int iA = 0;
        if (p4.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : p4.entrySet()) {
            iA += o4.a(i4, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    public static P j(Object obj, Object obj2) {
        P pL = (P) obj;
        P p4 = (P) obj2;
        if (!p4.isEmpty()) {
            if (!pL.i()) {
                pL = pL.l();
            }
            pL.k(p4);
        }
        return pL;
    }

    @Override // com.google.protobuf.Q
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // com.google.protobuf.Q
    public Object b(Object obj) {
        ((P) obj).j();
        return obj;
    }

    @Override // com.google.protobuf.Q
    public O.a c(Object obj) {
        return ((O) obj).c();
    }

    @Override // com.google.protobuf.Q
    public Map d(Object obj) {
        return (P) obj;
    }

    @Override // com.google.protobuf.Q
    public Object e(Object obj) {
        return P.e().l();
    }

    @Override // com.google.protobuf.Q
    public int f(int i4, Object obj, Object obj2) {
        return i(i4, obj, obj2);
    }

    @Override // com.google.protobuf.Q
    public boolean g(Object obj) {
        return !((P) obj).i();
    }

    @Override // com.google.protobuf.Q
    public Map h(Object obj) {
        return (P) obj;
    }
}
