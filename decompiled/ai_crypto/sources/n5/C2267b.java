package n5;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: n5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2267b implements G {
    @Override // n5.G
    public String a(List list) throws IOException {
        kotlin.jvm.internal.r.f(list, "list");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.flush();
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        kotlin.jvm.internal.r.e(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    @Override // n5.G
    public List b(String listString) throws ClassNotFoundException, IOException {
        kotlin.jvm.internal.r.f(listString, "listString");
        Object object = new L(new ByteArrayInputStream(Base64.decode(listString, 0))).readObject();
        kotlin.jvm.internal.r.d(object, "null cannot be cast to non-null type kotlin.collections.List<*>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : (List) object) {
            if (obj instanceof String) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
