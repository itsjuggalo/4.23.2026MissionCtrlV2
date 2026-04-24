package w4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import u4.C1219a;
import u4.InterfaceC1227i;

/* JADX INFO: loaded from: classes.dex */
public abstract class W1 implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1219a f11142a = new C1219a("io.grpc.internal.GrpcAttributes.securityLevel");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1219a f11143b = new C1219a("io.grpc.internal.GrpcAttributes.clientEagAttrs");

    public static B0 n() {
        return C1383w1.e == null ? new C1383w1() : new C1328e(0);
    }

    public static Set o(Map map, String str) {
        u4.i0 i0VarValueOf;
        List listC = AbstractC1382w0.c(map, str);
        if (listC == null) {
            return null;
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(u4.i0.class);
        for (Object obj : listC) {
            if (obj instanceof Double) {
                Double d4 = (Double) obj;
                int iIntValue = d4.intValue();
                y5.a.X(obj, "Status code %s is not integral", ((double) iIntValue) == d4.doubleValue());
                i0VarValueOf = u4.j0.c(iIntValue).f10446a;
                y5.a.X(obj, "Status code %s is not valid", i0VarValueOf.f10431a == d4.intValue());
            } else {
                if (!(obj instanceof String)) {
                    throw new G4.e("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
                }
                try {
                    i0VarValueOf = u4.i0.valueOf((String) obj);
                } catch (IllegalArgumentException e) {
                    throw new G4.e("Status code " + obj + " is not valid", e);
                }
            }
            enumSetNoneOf.add(i0VarValueOf);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }

    public static List p(Map map) {
        String strH;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            List listC = AbstractC1382w0.c(map, "loadBalancingConfig");
            if (listC == null) {
                listC = null;
            } else {
                AbstractC1382w0.a(listC);
            }
            arrayList.addAll(listC);
        }
        if (arrayList.isEmpty() && (strH = AbstractC1382w0.h(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(strH.toLowerCase(Locale.ROOT), Collections.EMPTY_MAP));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static u4.c0 t(List list, u4.O o3) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            U1 u12 = (U1) it.next();
            String str = u12.f11125a;
            u4.N nB = o3.b(str);
            if (nB != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(W1.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                u4.c0 c0VarC = nB.c(u12.f11126b);
                return c0VarC.f10395a != null ? c0VarC : new u4.c0(new V1(nB, c0VarC.f10396b));
            }
            arrayList.add(str);
        }
        return new u4.c0(u4.j0.f10437g.g("None of " + arrayList + " specified by Service Config are available."));
    }

    public static List u(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            if (map.size() != 1) {
                throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
            }
            String str = (String) ((Map.Entry) map.entrySet().iterator().next()).getKey();
            arrayList.add(new U1(AbstractC1382w0.g(map, str), str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // w4.b2
    public void b(InterfaceC1227i interfaceC1227i) {
        ((AbstractC1319b) this).f11178d.b(interfaceC1227i);
    }

    @Override // w4.b2
    public void c(B4.a aVar) {
        try {
            if (!((AbstractC1319b) this).f11178d.c()) {
                ((AbstractC1319b) this).f11178d.e(aVar);
            }
        } finally {
            AbstractC1323c0.b(aVar);
        }
    }

    @Override // w4.b2
    public void e(int i) {
        x4.i iVar = ((x4.j) this).f11543n;
        iVar.getClass();
        E4.b.b();
        U.h hVar = new U.h(iVar, i, 2);
        synchronized (iVar.f11535w) {
            hVar.run();
        }
    }

    @Override // w4.b2
    public void flush() {
        Z z6 = ((AbstractC1319b) this).f11178d;
        if (z6.c()) {
            return;
        }
        z6.flush();
    }

    @Override // w4.b2
    public void k() {
        x4.i iVar = ((x4.j) this).f11543n;
        C1321b1 c1321b1 = iVar.f11160d;
        c1321b1.f11186a = iVar;
        iVar.f11157a = c1321b1;
    }

    public abstract int q();

    public abstract boolean r(T1 t12);

    public abstract void s(T1 t12);
}
