package com.google.protobuf;

import com.google.protobuf.V;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.google.protobuf.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1229a implements V {
    protected int memoizedHashCode = 0;

    /* JADX INFO: renamed from: com.google.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0200a implements V.a {
        public static void k(Iterable iterable, List list) {
            C.a(iterable);
            if (!(iterable instanceof J)) {
                if (iterable instanceof g0) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    l(iterable, list);
                    return;
                }
            }
            List listO = ((J) iterable).o();
            J j7 = (J) list;
            int size = list.size();
            for (Object obj : listO) {
                if (obj == null) {
                    String str = "Element at index " + (j7.size() - size) + " is null.";
                    for (int size2 = j7.size() - 1; size2 >= size; size2--) {
                        j7.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof AbstractC1240i) {
                    j7.i((AbstractC1240i) obj);
                } else {
                    j7.add((String) obj);
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

        public static u0 m(V v7) {
            return new u0(v7);
        }
    }

    public static void k(Iterable iterable, List list) {
        AbstractC0200a.k(iterable, list);
    }

    @Override // com.google.protobuf.V
    public void e(OutputStream outputStream) {
        AbstractC1243l abstractC1243lA0 = AbstractC1243l.a0(outputStream, AbstractC1243l.E(b()));
        f(abstractC1243lA0);
        abstractC1243lA0.X();
    }

    @Override // com.google.protobuf.V
    public byte[] i() {
        try {
            byte[] bArr = new byte[b()];
            AbstractC1243l abstractC1243lB0 = AbstractC1243l.b0(bArr);
            f(abstractC1243lB0);
            abstractC1243lB0.d();
            return bArr;
        } catch (IOException e7) {
            throw new RuntimeException(m("byte array"), e7);
        }
    }

    public abstract int l(n0 n0Var);

    public final String m(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public u0 n() {
        return new u0(this);
    }
}
