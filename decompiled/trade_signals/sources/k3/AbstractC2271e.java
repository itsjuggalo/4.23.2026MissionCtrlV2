package k3;

import java.util.Iterator;
import p3.AbstractC2557k;
import p3.C2547a;
import p3.C2549c;
import p3.C2552f;
import p3.C2558l;
import p3.C2559m;
import p3.C2566t;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: k3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2271e {
    public static long a(AbstractC2557k abstractC2557k) {
        long length = 8;
        if (!(abstractC2557k instanceof C2552f) && !(abstractC2557k instanceof C2558l)) {
            if (abstractC2557k instanceof C2547a) {
                length = 4;
            } else {
                if (!(abstractC2557k instanceof C2566t)) {
                    throw new IllegalArgumentException("Unknown leaf node type: " + abstractC2557k.getClass());
                }
                length = ((long) ((String) abstractC2557k.getValue()).length()) + 2;
            }
        }
        return abstractC2557k.o().isEmpty() ? length : length + 24 + a((AbstractC2557k) abstractC2557k.o());
    }

    public static long b(InterfaceC2560n interfaceC2560n) {
        if (interfaceC2560n.isEmpty()) {
            return 4L;
        }
        if (interfaceC2560n.x()) {
            return a((AbstractC2557k) interfaceC2560n);
        }
        AbstractC2279m.g(interfaceC2560n instanceof C2549c, "Unexpected node type: " + interfaceC2560n.getClass());
        Iterator it = interfaceC2560n.iterator();
        long length = 1;
        while (it.hasNext()) {
            C2559m c2559m = (C2559m) it.next();
            length = length + ((long) c2559m.c().b().length()) + 4 + b(c2559m.d());
        }
        return !interfaceC2560n.o().isEmpty() ? length + 12 + a((AbstractC2557k) interfaceC2560n.o()) : length;
    }

    public static int c(InterfaceC2560n interfaceC2560n) {
        int iC = 0;
        if (interfaceC2560n.isEmpty()) {
            return 0;
        }
        if (interfaceC2560n.x()) {
            return 1;
        }
        AbstractC2279m.g(interfaceC2560n instanceof C2549c, "Unexpected node type: " + interfaceC2560n.getClass());
        Iterator it = interfaceC2560n.iterator();
        while (it.hasNext()) {
            iC += c(((C2559m) it.next()).d());
        }
        return iC;
    }
}
