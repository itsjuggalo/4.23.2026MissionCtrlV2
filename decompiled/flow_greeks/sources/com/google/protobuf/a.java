package com.google.protobuf;

import com.google.protobuf.u0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements u0 {
    protected int memoizedHashCode = 0;

    /* JADX INFO: renamed from: com.google.protobuf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractC0113a implements u0.a {
        public static void k(Iterable iterable, List list) {
            c0.a(iterable);
            if (!(iterable instanceof j0)) {
                if (iterable instanceof f1) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    l(iterable, list);
                    return;
                }
            }
            List listK = ((j0) iterable).k();
            j0 j0Var = (j0) list;
            int size = list.size();
            for (Object obj : listK) {
                if (obj == null) {
                    String str = "Element at index " + (j0Var.size() - size) + " is null.";
                    for (int size2 = j0Var.size() - 1; size2 >= size; size2--) {
                        j0Var.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof i) {
                    j0Var.o((i) obj);
                } else {
                    j0Var.add((String) obj);
                }
            }
        }

        public static void l(Iterable iterable, List list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
        }

        public static t1 m(u0 u0Var) {
            return new t1(u0Var);
        }
    }

    public static void k(Iterable iterable, List list) {
        AbstractC0113a.k(iterable, list);
    }

    @Override // com.google.protobuf.u0
    public void f(OutputStream outputStream) {
        l lVarA0 = l.a0(outputStream, l.E(b()));
        g(lVarA0);
        lVarA0.X();
    }

    @Override // com.google.protobuf.u0
    public byte[] i() {
        try {
            byte[] bArr = new byte[b()];
            l lVarB0 = l.b0(bArr);
            g(lVarB0);
            lVarB0.d();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException(m("byte array"), e10);
        }
    }

    public abstract int l(m1 m1Var);

    public final String m(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public t1 n() {
        return new t1(this);
    }
}
