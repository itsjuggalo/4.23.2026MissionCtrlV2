package n4;

import Z3.v;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f8593d = new g();

    @Override // Z3.v
    public final Object f(byte b3, ByteBuffer byteBuffer) {
        switch (b3) {
            case -127:
                Object objE = e(byteBuffer);
                if (objE == null) {
                    return null;
                }
                return h.values()[((Long) objE).intValue()];
            case -126:
                ArrayList arrayList = (ArrayList) e(byteBuffer);
                f fVar = new f();
                List list = (List) arrayList.get(0);
                if (list == null) {
                    throw new IllegalStateException("Nonnull field \"scopes\" is null.");
                }
                fVar.f8587a = list;
                h hVar = (h) arrayList.get(1);
                if (hVar == null) {
                    throw new IllegalStateException("Nonnull field \"signInType\" is null.");
                }
                fVar.f8588b = hVar;
                fVar.f8589c = (String) arrayList.get(2);
                fVar.f8590d = (String) arrayList.get(3);
                fVar.e = (String) arrayList.get(4);
                Boolean bool = (Boolean) arrayList.get(5);
                if (bool == null) {
                    throw new IllegalStateException("Nonnull field \"forceCodeForRefreshToken\" is null.");
                }
                fVar.f8591f = bool;
                fVar.f8592g = (String) arrayList.get(6);
                return fVar;
            case -125:
                ArrayList arrayList2 = (ArrayList) e(byteBuffer);
                i iVar = new i();
                iVar.f8596a = (String) arrayList2.get(0);
                String str = (String) arrayList2.get(1);
                if (str == null) {
                    throw new IllegalStateException("Nonnull field \"email\" is null.");
                }
                iVar.f8597b = str;
                String str2 = (String) arrayList2.get(2);
                if (str2 == null) {
                    throw new IllegalStateException("Nonnull field \"id\" is null.");
                }
                iVar.f8598c = str2;
                iVar.f8599d = (String) arrayList2.get(3);
                iVar.e = (String) arrayList2.get(4);
                iVar.f8600f = (String) arrayList2.get(5);
                return iVar;
            default:
                return super.f(b3, byteBuffer);
        }
    }

    @Override // Z3.v
    public final void k(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        if (obj instanceof h) {
            byteArrayOutputStream.write(129);
            k(byteArrayOutputStream, obj == null ? null : Integer.valueOf(((h) obj).f8595a));
            return;
        }
        if (obj instanceof f) {
            byteArrayOutputStream.write(130);
            f fVar = (f) obj;
            fVar.getClass();
            ArrayList arrayList = new ArrayList(7);
            arrayList.add(fVar.f8587a);
            arrayList.add(fVar.f8588b);
            arrayList.add(fVar.f8589c);
            arrayList.add(fVar.f8590d);
            arrayList.add(fVar.e);
            arrayList.add(fVar.f8591f);
            arrayList.add(fVar.f8592g);
            k(byteArrayOutputStream, arrayList);
            return;
        }
        if (!(obj instanceof i)) {
            super.k(byteArrayOutputStream, obj);
            return;
        }
        byteArrayOutputStream.write(131);
        i iVar = (i) obj;
        iVar.getClass();
        ArrayList arrayList2 = new ArrayList(6);
        arrayList2.add(iVar.f8596a);
        arrayList2.add(iVar.f8597b);
        arrayList2.add(iVar.f8598c);
        arrayList2.add(iVar.f8599d);
        arrayList2.add(iVar.e);
        arrayList2.add(iVar.f8600f);
        k(byteArrayOutputStream, arrayList2);
    }
}
