package com.google.protobuf;

import com.google.protobuf.J;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: com.google.protobuf.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1462a implements J {
    protected int memoizedHashCode = 0;

    /* JADX INFO: renamed from: com.google.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0263a implements J.a {
        public static void k(Iterable iterable, List list) {
            AbstractC1481u.a(iterable);
            if (!(iterable instanceof InterfaceC1486z)) {
                l(iterable, list);
                return;
            }
            List listK = ((InterfaceC1486z) iterable).k();
            InterfaceC1486z interfaceC1486z = (InterfaceC1486z) list;
            int size = list.size();
            for (Object obj : listK) {
                if (obj == null) {
                    String str = "Element at index " + (interfaceC1486z.size() - size) + " is null.";
                    for (int size2 = interfaceC1486z.size() - 1; size2 >= size; size2--) {
                        interfaceC1486z.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof AbstractC1467f) {
                    interfaceC1486z.q((AbstractC1467f) obj);
                } else {
                    interfaceC1486z.add((String) obj);
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

        public static e0 m(J j8) {
            return new e0(j8);
        }
    }

    public static void a(Iterable iterable, List list) {
        AbstractC0263a.k(iterable, list);
    }

    @Override // com.google.protobuf.J
    public void g(OutputStream outputStream) {
        AbstractC1470i abstractC1470iZ = AbstractC1470i.Z(outputStream, AbstractC1470i.D(c()));
        h(abstractC1470iZ);
        abstractC1470iZ.W();
    }

    @Override // com.google.protobuf.J
    public byte[] i() {
        try {
            byte[] bArr = new byte[c()];
            AbstractC1470i abstractC1470iA0 = AbstractC1470i.a0(bArr);
            h(abstractC1470iA0);
            abstractC1470iA0.c();
            return bArr;
        } catch (IOException e8) {
            throw new RuntimeException(l("byte array"), e8);
        }
    }

    public abstract int k(Y y7);

    public final String l(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public e0 m() {
        return new e0(this);
    }
}
