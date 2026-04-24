package o4;

import Z3.v;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class q extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f8720d = new q();

    @Override // Z3.v
    public final Object f(byte b3, ByteBuffer byteBuffer) {
        switch (b3) {
            case -127:
                Object objE = e(byteBuffer);
                if (objE == null) {
                    return null;
                }
                return r.values()[((Long) objE).intValue()];
            case -126:
                Object objE2 = e(byteBuffer);
                if (objE2 == null) {
                    return null;
                }
                return t.values()[((Long) objE2).intValue()];
            case -125:
                Object objE3 = e(byteBuffer);
                if (objE3 == null) {
                    return null;
                }
                return k.values()[((Long) objE3).intValue()];
            case -124:
                ArrayList arrayList = (ArrayList) e(byteBuffer);
                m mVar = new m();
                Boolean bool = (Boolean) arrayList.get(0);
                if (bool == null) {
                    throw new IllegalStateException("Nonnull field \"allowMultiple\" is null.");
                }
                mVar.f8711a = bool;
                Boolean bool2 = (Boolean) arrayList.get(1);
                if (bool2 == null) {
                    throw new IllegalStateException("Nonnull field \"usePhotoPicker\" is null.");
                }
                mVar.f8712b = bool2;
                mVar.f8713c = (Long) arrayList.get(2);
                return mVar;
            case -123:
                ArrayList arrayList2 = (ArrayList) e(byteBuffer);
                o oVar = new o();
                oVar.f8716a = (Double) arrayList2.get(0);
                oVar.f8717b = (Double) arrayList2.get(1);
                Long l6 = (Long) arrayList2.get(2);
                if (l6 == null) {
                    throw new IllegalStateException("Nonnull field \"quality\" is null.");
                }
                oVar.f8718c = l6;
                return oVar;
            case -122:
                ArrayList arrayList3 = (ArrayList) e(byteBuffer);
                p pVar = new p();
                o oVar2 = (o) arrayList3.get(0);
                if (oVar2 == null) {
                    throw new IllegalStateException("Nonnull field \"imageSelectionOptions\" is null.");
                }
                pVar.f8719a = oVar2;
                return pVar;
            case -121:
                ArrayList arrayList4 = (ArrayList) e(byteBuffer);
                u uVar = new u();
                uVar.f8727a = (Long) arrayList4.get(0);
                return uVar;
            case -120:
                ArrayList arrayList5 = (ArrayList) e(byteBuffer);
                s sVar = new s();
                t tVar = (t) arrayList5.get(0);
                if (tVar == null) {
                    throw new IllegalStateException("Nonnull field \"type\" is null.");
                }
                sVar.f8723a = tVar;
                sVar.f8724b = (r) arrayList5.get(1);
                return sVar;
            case -119:
                ArrayList arrayList6 = (ArrayList) e(byteBuffer);
                i iVar = new i();
                String str = (String) arrayList6.get(0);
                if (str == null) {
                    throw new IllegalStateException("Nonnull field \"code\" is null.");
                }
                iVar.f8701a = str;
                iVar.f8702b = (String) arrayList6.get(1);
                return iVar;
            case -118:
                ArrayList arrayList7 = (ArrayList) e(byteBuffer);
                j jVar = new j();
                k kVar = (k) arrayList7.get(0);
                if (kVar == null) {
                    throw new IllegalStateException("Nonnull field \"type\" is null.");
                }
                jVar.f8703a = kVar;
                jVar.f8704b = (i) arrayList7.get(1);
                List list = (List) arrayList7.get(2);
                if (list == null) {
                    throw new IllegalStateException("Nonnull field \"paths\" is null.");
                }
                jVar.f8705c = list;
                return jVar;
            default:
                return super.f(b3, byteBuffer);
        }
    }

    @Override // Z3.v
    public final void k(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        if (obj instanceof r) {
            byteArrayOutputStream.write(129);
            k(byteArrayOutputStream, obj != null ? Integer.valueOf(((r) obj).f8722a) : null);
            return;
        }
        if (obj instanceof t) {
            byteArrayOutputStream.write(130);
            k(byteArrayOutputStream, obj != null ? Integer.valueOf(((t) obj).f8726a) : null);
            return;
        }
        if (obj instanceof k) {
            byteArrayOutputStream.write(131);
            k(byteArrayOutputStream, obj != null ? Integer.valueOf(((k) obj).f8709a) : null);
            return;
        }
        if (obj instanceof m) {
            byteArrayOutputStream.write(132);
            m mVar = (m) obj;
            mVar.getClass();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(mVar.f8711a);
            arrayList.add(mVar.f8712b);
            arrayList.add(mVar.f8713c);
            k(byteArrayOutputStream, arrayList);
            return;
        }
        if (obj instanceof o) {
            byteArrayOutputStream.write(133);
            o oVar = (o) obj;
            oVar.getClass();
            ArrayList arrayList2 = new ArrayList(3);
            arrayList2.add(oVar.f8716a);
            arrayList2.add(oVar.f8717b);
            arrayList2.add(oVar.f8718c);
            k(byteArrayOutputStream, arrayList2);
            return;
        }
        if (obj instanceof p) {
            byteArrayOutputStream.write(134);
            p pVar = (p) obj;
            pVar.getClass();
            ArrayList arrayList3 = new ArrayList(1);
            arrayList3.add(pVar.f8719a);
            k(byteArrayOutputStream, arrayList3);
            return;
        }
        if (obj instanceof u) {
            byteArrayOutputStream.write(135);
            u uVar = (u) obj;
            uVar.getClass();
            ArrayList arrayList4 = new ArrayList(1);
            arrayList4.add(uVar.f8727a);
            k(byteArrayOutputStream, arrayList4);
            return;
        }
        if (obj instanceof s) {
            byteArrayOutputStream.write(136);
            s sVar = (s) obj;
            sVar.getClass();
            ArrayList arrayList5 = new ArrayList(2);
            arrayList5.add(sVar.f8723a);
            arrayList5.add(sVar.f8724b);
            k(byteArrayOutputStream, arrayList5);
            return;
        }
        if (obj instanceof i) {
            byteArrayOutputStream.write(137);
            i iVar = (i) obj;
            iVar.getClass();
            ArrayList arrayList6 = new ArrayList(2);
            arrayList6.add(iVar.f8701a);
            arrayList6.add(iVar.f8702b);
            k(byteArrayOutputStream, arrayList6);
            return;
        }
        if (!(obj instanceof j)) {
            super.k(byteArrayOutputStream, obj);
            return;
        }
        byteArrayOutputStream.write(138);
        j jVar = (j) obj;
        jVar.getClass();
        ArrayList arrayList7 = new ArrayList(3);
        arrayList7.add(jVar.f8703a);
        arrayList7.add(jVar.f8704b);
        arrayList7.add(jVar.f8705c);
        k(byteArrayOutputStream, arrayList7);
    }
}
