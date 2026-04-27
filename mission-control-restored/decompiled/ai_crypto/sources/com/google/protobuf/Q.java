package com.google.protobuf;

import com.google.protobuf.N;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Q implements P {
    public static int i(int i7, Object obj, Object obj2) {
        O o7 = (O) obj;
        N n7 = (N) obj2;
        int iA = 0;
        if (o7.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : o7.entrySet()) {
            iA += n7.a(i7, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    public static O j(Object obj, Object obj2) {
        O oM = (O) obj;
        O o7 = (O) obj2;
        if (!o7.isEmpty()) {
            if (!oM.j()) {
                oM = oM.m();
            }
            oM.l(o7);
        }
        return oM;
    }

    @Override // com.google.protobuf.P
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // com.google.protobuf.P
    public Object b(Object obj) {
        ((O) obj).k();
        return obj;
    }

    @Override // com.google.protobuf.P
    public N.a c(Object obj) {
        return ((N) obj).c();
    }

    @Override // com.google.protobuf.P
    public Map d(Object obj) {
        return (O) obj;
    }

    @Override // com.google.protobuf.P
    public Object e(Object obj) {
        return O.e().m();
    }

    @Override // com.google.protobuf.P
    public int f(int i7, Object obj, Object obj2) {
        return i(i7, obj, obj2);
    }

    @Override // com.google.protobuf.P
    public boolean g(Object obj) {
        return !((O) obj).j();
    }

    @Override // com.google.protobuf.P
    public Map h(Object obj) {
        return (O) obj;
    }
}
