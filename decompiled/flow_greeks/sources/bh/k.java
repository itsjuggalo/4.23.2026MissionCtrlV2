package bh;

import bh.m;
import cd.h0;
import dd.n;
import dh.q1;
import kg.c0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static final e b(String serialName, d kind) {
        t.f(serialName, "serialName");
        t.f(kind, "kind");
        if (c0.e0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        return q1.a(serialName, kind);
    }

    public static final e c(String serialName, e[] typeParameters, pd.k builderAction) {
        t.f(serialName, "serialName");
        t.f(typeParameters, "typeParameters");
        t.f(builderAction, "builderAction");
        if (c0.e0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        a aVar = new a(serialName);
        builderAction.invoke(aVar);
        return new h(serialName, m.a.f3402a, aVar.f().size(), n.z0(typeParameters), aVar);
    }

    public static final e d(String serialName, l kind, e[] typeParameters, pd.k builder) {
        t.f(serialName, "serialName");
        t.f(kind, "kind");
        t.f(typeParameters, "typeParameters");
        t.f(builder, "builder");
        if (c0.e0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (t.b(kind, m.a.f3402a)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        a aVar = new a(serialName);
        builder.invoke(aVar);
        return new h(serialName, kind, aVar.f().size(), n.z0(typeParameters), aVar);
    }

    public static /* synthetic */ e e(String str, l lVar, e[] eVarArr, pd.k kVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            kVar = new pd.k() { // from class: bh.j
                @Override // pd.k
                public final Object invoke(Object obj2) {
                    return k.f((a) obj2);
                }
            };
        }
        return d(str, lVar, eVarArr, kVar);
    }

    public static final h0 f(a aVar) {
        t.f(aVar, "<this>");
        return h0.f3852a;
    }
}
