package com.google.protobuf;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.protobuf.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0450a {
    protected int memoizedHashCode;

    public static void b(List list, List list2) {
        Charset charset = M.f5651a;
        list.getClass();
        if (list instanceof T) {
            List listJ = ((T) list).j();
            T t6 = (T) list2;
            int size = list2.size();
            for (Object obj : listJ) {
                if (obj == null) {
                    String str = "Element at index " + (t6.size() - size) + " is null.";
                    for (int size2 = t6.size() - 1; size2 >= size; size2--) {
                        t6.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof AbstractC0472l) {
                    t6.e((AbstractC0472l) obj);
                } else {
                    t6.add((String) obj);
                }
            }
            return;
        }
        if (list instanceof InterfaceC0477n0) {
            list2.addAll(list);
            return;
        }
        if (list2 instanceof ArrayList) {
            ((ArrayList) list2).ensureCapacity(list.size() + list2.size());
        }
        int size3 = list2.size();
        for (Object obj2 : list) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list2.size() - size3) + " is null.";
                for (int size4 = list2.size() - 1; size4 >= size3; size4--) {
                    list2.remove(size4);
                }
                throw new NullPointerException(str2);
            }
            list2.add(obj2);
        }
    }

    public abstract int c(InterfaceC0488t0 interfaceC0488t0);

    public final byte[] d() {
        try {
            int iC = ((E) this).c(null);
            byte[] bArr = new byte[iC];
            Logger logger = AbstractC0485s.f5794d;
            C0482q c0482q = new C0482q(bArr, 0, iC);
            e(c0482q);
            if (c0482q.a0() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }

    public abstract void e(AbstractC0485s abstractC0485s);
}
