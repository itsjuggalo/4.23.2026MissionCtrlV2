package r4;

import Z3.v;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: renamed from: r4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0975c extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0975c f9471d = new C0975c();

    @Override // Z3.v
    public final Object f(byte b3, ByteBuffer byteBuffer) {
        if (b3 != -127) {
            if (b3 != -126) {
                return super.f(b3, byteBuffer);
            }
            ArrayList arrayList = (ArrayList) e(byteBuffer);
            C0973a c0973a = new C0973a();
            Boolean bool = (Boolean) arrayList.get(0);
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"showTitle\" is null.");
            }
            c0973a.f9469a = bool;
            return c0973a;
        }
        ArrayList arrayList2 = (ArrayList) e(byteBuffer);
        C0977e c0977e = new C0977e();
        Boolean bool2 = (Boolean) arrayList2.get(0);
        if (bool2 == null) {
            throw new IllegalStateException("Nonnull field \"enableJavaScript\" is null.");
        }
        c0977e.f9474a = bool2;
        Boolean bool3 = (Boolean) arrayList2.get(1);
        if (bool3 == null) {
            throw new IllegalStateException("Nonnull field \"enableDomStorage\" is null.");
        }
        c0977e.f9475b = bool3;
        Map map = (Map) arrayList2.get(2);
        if (map == null) {
            throw new IllegalStateException("Nonnull field \"headers\" is null.");
        }
        c0977e.f9476c = map;
        return c0977e;
    }

    @Override // Z3.v
    public final void k(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        if (obj instanceof C0977e) {
            byteArrayOutputStream.write(129);
            C0977e c0977e = (C0977e) obj;
            c0977e.getClass();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(c0977e.f9474a);
            arrayList.add(c0977e.f9475b);
            arrayList.add(c0977e.f9476c);
            k(byteArrayOutputStream, arrayList);
            return;
        }
        if (!(obj instanceof C0973a)) {
            super.k(byteArrayOutputStream, obj);
            return;
        }
        byteArrayOutputStream.write(130);
        C0973a c0973a = (C0973a) obj;
        c0973a.getClass();
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add(c0973a.f9469a);
        k(byteArrayOutputStream, arrayList2);
    }
}
