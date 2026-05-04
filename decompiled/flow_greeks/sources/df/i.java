package df;

import bf.b;
import cd.q;
import cf.a;
import dd.a0;
import dd.r;
import dd.s;
import df.d;
import gf.i;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import ze.l;
import ze.n;
import ze.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f8111a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gf.g f8112b;

    static {
        gf.g gVarD = gf.g.d();
        cf.a.a(gVarD);
        t.e(gVarD, "apply(...)");
        f8112b = gVarD;
    }

    public static /* synthetic */ d.a d(i iVar, n nVar, bf.c cVar, bf.g gVar, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        return iVar.c(nVar, cVar, gVar, z10);
    }

    public static final boolean f(n proto) {
        t.f(proto, "proto");
        b.C0061b c0061bA = c.f8089a.a();
        Object objT = proto.t(cf.a.f4054e);
        t.e(objT, "getExtension(...)");
        Boolean boolD = c0061bA.d(((Number) objT).intValue());
        t.e(boolD, "get(...)");
        return boolD.booleanValue();
    }

    public static final q h(byte[] bytes, String[] strings) {
        t.f(bytes, "bytes");
        t.f(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new q(f8111a.k(byteArrayInputStream, strings), ze.c.w1(byteArrayInputStream, f8112b));
    }

    public static final q i(String[] data, String[] strings) {
        t.f(data, "data");
        t.f(strings, "strings");
        byte[] bArrE = a.e(data);
        t.e(bArrE, "decodeBytes(...)");
        return h(bArrE, strings);
    }

    public static final q j(String[] data, String[] strings) {
        t.f(data, "data");
        t.f(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.e(data));
        return new q(f8111a.k(byteArrayInputStream, strings), ze.i.E0(byteArrayInputStream, f8112b));
    }

    public static final q l(byte[] bytes, String[] strings) {
        t.f(bytes, "bytes");
        t.f(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new q(f8111a.k(byteArrayInputStream, strings), l.d0(byteArrayInputStream, f8112b));
    }

    public static final q m(String[] data, String[] strings) {
        t.f(data, "data");
        t.f(strings, "strings");
        byte[] bArrE = a.e(data);
        t.e(bArrE, "decodeBytes(...)");
        return l(bArrE, strings);
    }

    public final gf.g a() {
        return f8112b;
    }

    public final d.b b(ze.d proto, bf.c nameResolver, bf.g typeTable) {
        String strI0;
        t.f(proto, "proto");
        t.f(nameResolver, "nameResolver");
        t.f(typeTable, "typeTable");
        i.f constructorSignature = cf.a.f4050a;
        t.e(constructorSignature, "constructorSignature");
        a.c cVar = (a.c) bf.e.a(proto, constructorSignature);
        String string = (cVar == null || !cVar.z()) ? "<init>" : nameResolver.getString(cVar.x());
        if (cVar == null || !cVar.y()) {
            List<u> listM = proto.M();
            t.e(listM, "getValueParameterList(...)");
            ArrayList arrayList = new ArrayList(s.u(listM, 10));
            for (u uVar : listM) {
                i iVar = f8111a;
                t.c(uVar);
                String strG = iVar.g(bf.f.q(uVar, typeTable), nameResolver);
                if (strG == null) {
                    return null;
                }
                arrayList.add(strG);
            }
            strI0 = a0.i0(arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            strI0 = nameResolver.getString(cVar.w());
        }
        return new d.b(string, strI0);
    }

    public final d.a c(n proto, bf.c nameResolver, bf.g typeTable, boolean z10) {
        String strG;
        t.f(proto, "proto");
        t.f(nameResolver, "nameResolver");
        t.f(typeTable, "typeTable");
        i.f propertySignature = cf.a.f4053d;
        t.e(propertySignature, "propertySignature");
        a.d dVar = (a.d) bf.e.a(proto, propertySignature);
        if (dVar == null) {
            return null;
        }
        a.b bVarA = dVar.F() ? dVar.A() : null;
        if (bVarA == null && z10) {
            return null;
        }
        int iC0 = (bVarA == null || !bVarA.z()) ? proto.c0() : bVarA.x();
        if (bVarA == null || !bVarA.y()) {
            strG = g(bf.f.n(proto, typeTable), nameResolver);
            if (strG == null) {
                return null;
            }
        } else {
            strG = nameResolver.getString(bVarA.w());
        }
        return new d.a(nameResolver.getString(iC0), strG);
    }

    public final d.b e(ze.i proto, bf.c nameResolver, bf.g typeTable) {
        String string;
        t.f(proto, "proto");
        t.f(nameResolver, "nameResolver");
        t.f(typeTable, "typeTable");
        i.f methodSignature = cf.a.f4051b;
        t.e(methodSignature, "methodSignature");
        a.c cVar = (a.c) bf.e.a(proto, methodSignature);
        int iD0 = (cVar == null || !cVar.z()) ? proto.d0() : cVar.x();
        if (cVar == null || !cVar.y()) {
            List listO = r.o(bf.f.k(proto, typeTable));
            List<u> listP0 = proto.p0();
            t.e(listP0, "getValueParameterList(...)");
            ArrayList arrayList = new ArrayList(s.u(listP0, 10));
            for (u uVar : listP0) {
                t.c(uVar);
                arrayList.add(bf.f.q(uVar, typeTable));
            }
            List listS0 = a0.s0(listO, arrayList);
            ArrayList arrayList2 = new ArrayList(s.u(listS0, 10));
            Iterator it = listS0.iterator();
            while (it.hasNext()) {
                String strG = f8111a.g((ze.q) it.next(), nameResolver);
                if (strG == null) {
                    return null;
                }
                arrayList2.add(strG);
            }
            String strG2 = g(bf.f.m(proto, typeTable), nameResolver);
            if (strG2 == null) {
                return null;
            }
            string = a0.i0(arrayList2, "", "(", ")", 0, null, null, 56, null) + strG2;
        } else {
            string = nameResolver.getString(cVar.w());
        }
        return new d.b(nameResolver.getString(iD0), string);
    }

    public final String g(ze.q qVar, bf.c cVar) {
        if (qVar.l0()) {
            return b.b(cVar.a(qVar.W()));
        }
        return null;
    }

    public final f k(InputStream inputStream, String[] strArr) {
        a.e eVarD = a.e.D(inputStream, f8112b);
        t.e(eVarD, "parseDelimitedFrom(...)");
        return new f(eVarD, strArr);
    }
}
