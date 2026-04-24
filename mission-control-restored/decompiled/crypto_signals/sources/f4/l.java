package f4;

import Z3.v;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f6494d = new l();

    @Override // Z3.v
    public final Object f(byte b3, ByteBuffer byteBuffer) {
        if (b3 != -127) {
            if (b3 != -126) {
                return super.f(b3, byteBuffer);
            }
            ArrayList arrayList = (ArrayList) e(byteBuffer);
            h hVar = new h();
            String str = (String) arrayList.get(0);
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"name\" is null.");
            }
            hVar.f6488a = str;
            g gVar = (g) arrayList.get(1);
            if (gVar == null) {
                throw new IllegalStateException("Nonnull field \"options\" is null.");
            }
            hVar.f6489b = gVar;
            hVar.f6490c = (Boolean) arrayList.get(2);
            Map map = (Map) arrayList.get(3);
            if (map == null) {
                throw new IllegalStateException("Nonnull field \"pluginConstants\" is null.");
            }
            hVar.f6491d = map;
            return hVar;
        }
        ArrayList arrayList2 = (ArrayList) e(byteBuffer);
        g gVar2 = new g();
        String str2 = (String) arrayList2.get(0);
        if (str2 == null) {
            throw new IllegalStateException("Nonnull field \"apiKey\" is null.");
        }
        gVar2.f6476a = str2;
        String str3 = (String) arrayList2.get(1);
        if (str3 == null) {
            throw new IllegalStateException("Nonnull field \"appId\" is null.");
        }
        gVar2.f6477b = str3;
        String str4 = (String) arrayList2.get(2);
        if (str4 == null) {
            throw new IllegalStateException("Nonnull field \"messagingSenderId\" is null.");
        }
        gVar2.f6478c = str4;
        String str5 = (String) arrayList2.get(3);
        if (str5 == null) {
            throw new IllegalStateException("Nonnull field \"projectId\" is null.");
        }
        gVar2.f6479d = str5;
        gVar2.e = (String) arrayList2.get(4);
        gVar2.f6480f = (String) arrayList2.get(5);
        gVar2.f6481g = (String) arrayList2.get(6);
        gVar2.f6482h = (String) arrayList2.get(7);
        gVar2.i = (String) arrayList2.get(8);
        gVar2.f6483j = (String) arrayList2.get(9);
        gVar2.f6484k = (String) arrayList2.get(10);
        gVar2.f6485l = (String) arrayList2.get(11);
        gVar2.f6486m = (String) arrayList2.get(12);
        gVar2.f6487n = (String) arrayList2.get(13);
        return gVar2;
    }

    @Override // Z3.v
    public final void k(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        if (!(obj instanceof g)) {
            if (!(obj instanceof h)) {
                super.k(byteArrayOutputStream, obj);
                return;
            }
            byteArrayOutputStream.write(130);
            h hVar = (h) obj;
            hVar.getClass();
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(hVar.f6488a);
            arrayList.add(hVar.f6489b);
            arrayList.add(hVar.f6490c);
            arrayList.add(hVar.f6491d);
            k(byteArrayOutputStream, arrayList);
            return;
        }
        byteArrayOutputStream.write(129);
        g gVar = (g) obj;
        gVar.getClass();
        ArrayList arrayList2 = new ArrayList(14);
        arrayList2.add(gVar.f6476a);
        arrayList2.add(gVar.f6477b);
        arrayList2.add(gVar.f6478c);
        arrayList2.add(gVar.f6479d);
        arrayList2.add(gVar.e);
        arrayList2.add(gVar.f6480f);
        arrayList2.add(gVar.f6481g);
        arrayList2.add(gVar.f6482h);
        arrayList2.add(gVar.i);
        arrayList2.add(gVar.f6483j);
        arrayList2.add(gVar.f6484k);
        arrayList2.add(gVar.f6485l);
        arrayList2.add(gVar.f6486m);
        arrayList2.add(gVar.f6487n);
        k(byteArrayOutputStream, arrayList2);
    }
}
