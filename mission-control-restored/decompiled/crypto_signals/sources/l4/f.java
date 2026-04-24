package l4;

import Z3.v;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f8165d = new f();

    @Override // Z3.v
    public final Object f(byte b3, ByteBuffer byteBuffer) {
        Long lValueOf;
        switch (b3) {
            case -128:
                ArrayList arrayList = (ArrayList) e(byteBuffer);
                h hVar = new h();
                hVar.f8167a = (Map) arrayList.get(0);
                return hVar;
            case -127:
                ArrayList arrayList2 = (ArrayList) e(byteBuffer);
                i iVar = new i();
                Object obj = arrayList2.get(0);
                if (obj == null) {
                    lValueOf = null;
                } else {
                    lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
                }
                if (lValueOf == null) {
                    throw new IllegalStateException("Nonnull field \"maxResults\" is null.");
                }
                iVar.f8168a = lValueOf;
                iVar.f8169b = (String) arrayList2.get(1);
                return iVar;
            case -126:
                ArrayList arrayList3 = (ArrayList) e(byteBuffer);
                j jVar = new j();
                List list = (List) arrayList3.get(0);
                if (list == null) {
                    throw new IllegalStateException("Nonnull field \"items\" is null.");
                }
                jVar.f8170a = list;
                jVar.f8171b = (String) arrayList3.get(1);
                List list2 = (List) arrayList3.get(2);
                if (list2 == null) {
                    throw new IllegalStateException("Nonnull field \"prefixs\" is null.");
                }
                jVar.f8172c = list2;
                return jVar;
            case -125:
                ArrayList arrayList4 = (ArrayList) e(byteBuffer);
                k kVar = new k();
                kVar.f8173a = (String) arrayList4.get(0);
                kVar.f8174b = (String) arrayList4.get(1);
                kVar.f8175c = (String) arrayList4.get(2);
                kVar.f8176d = (String) arrayList4.get(3);
                kVar.e = (String) arrayList4.get(4);
                kVar.f8177f = (Map) arrayList4.get(5);
                return kVar;
            case -124:
                ArrayList arrayList5 = (ArrayList) e(byteBuffer);
                l lVar = new l();
                String str = (String) arrayList5.get(0);
                if (str == null) {
                    throw new IllegalStateException("Nonnull field \"appName\" is null.");
                }
                lVar.f8178a = str;
                lVar.f8179b = (String) arrayList5.get(1);
                String str2 = (String) arrayList5.get(2);
                if (str2 == null) {
                    throw new IllegalStateException("Nonnull field \"bucket\" is null.");
                }
                lVar.f8180c = str2;
                return lVar;
            case -123:
                ArrayList arrayList6 = (ArrayList) e(byteBuffer);
                m mVar = new m();
                String str3 = (String) arrayList6.get(0);
                if (str3 == null) {
                    throw new IllegalStateException("Nonnull field \"bucket\" is null.");
                }
                mVar.f8181a = str3;
                String str4 = (String) arrayList6.get(1);
                if (str4 == null) {
                    throw new IllegalStateException("Nonnull field \"fullPath\" is null.");
                }
                mVar.f8182b = str4;
                String str5 = (String) arrayList6.get(2);
                if (str5 == null) {
                    throw new IllegalStateException("Nonnull field \"name\" is null.");
                }
                mVar.f8183c = str5;
                return mVar;
            default:
                return super.f(b3, byteBuffer);
        }
    }

    @Override // Z3.v
    public final void k(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        if (obj instanceof h) {
            byteArrayOutputStream.write(128);
            h hVar = (h) obj;
            hVar.getClass();
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(hVar.f8167a);
            k(byteArrayOutputStream, arrayList);
            return;
        }
        if (obj instanceof i) {
            byteArrayOutputStream.write(129);
            i iVar = (i) obj;
            iVar.getClass();
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(iVar.f8168a);
            arrayList2.add(iVar.f8169b);
            k(byteArrayOutputStream, arrayList2);
            return;
        }
        if (obj instanceof j) {
            byteArrayOutputStream.write(130);
            j jVar = (j) obj;
            jVar.getClass();
            ArrayList arrayList3 = new ArrayList(3);
            arrayList3.add(jVar.f8170a);
            arrayList3.add(jVar.f8171b);
            arrayList3.add(jVar.f8172c);
            k(byteArrayOutputStream, arrayList3);
            return;
        }
        if (obj instanceof k) {
            byteArrayOutputStream.write(131);
            k kVar = (k) obj;
            kVar.getClass();
            ArrayList arrayList4 = new ArrayList(6);
            arrayList4.add(kVar.f8173a);
            arrayList4.add(kVar.f8174b);
            arrayList4.add(kVar.f8175c);
            arrayList4.add(kVar.f8176d);
            arrayList4.add(kVar.e);
            arrayList4.add(kVar.f8177f);
            k(byteArrayOutputStream, arrayList4);
            return;
        }
        if (obj instanceof l) {
            byteArrayOutputStream.write(132);
            l lVar = (l) obj;
            lVar.getClass();
            ArrayList arrayList5 = new ArrayList(3);
            arrayList5.add(lVar.f8178a);
            arrayList5.add(lVar.f8179b);
            arrayList5.add(lVar.f8180c);
            k(byteArrayOutputStream, arrayList5);
            return;
        }
        if (!(obj instanceof m)) {
            super.k(byteArrayOutputStream, obj);
            return;
        }
        byteArrayOutputStream.write(133);
        m mVar = (m) obj;
        mVar.getClass();
        ArrayList arrayList6 = new ArrayList(3);
        arrayList6.add(mVar.f8181a);
        arrayList6.add(mVar.f8182b);
        arrayList6.add(mVar.f8183c);
        k(byteArrayOutputStream, arrayList6);
    }
}
