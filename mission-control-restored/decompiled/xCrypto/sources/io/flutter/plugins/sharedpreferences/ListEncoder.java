package io.flutter.plugins.sharedpreferences;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ListEncoder implements SharedPreferencesListEncoder {
    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesListEncoder
    public List<String> decode(String listString) throws ClassNotFoundException, IOException {
        kotlin.jvm.internal.r.f(listString, "listString");
        Object object = new StringListObjectInputStream(new ByteArrayInputStream(Base64.decode(listString, 0))).readObject();
        kotlin.jvm.internal.r.d(object, "null cannot be cast to non-null type kotlin.collections.List<*>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : (List) object) {
            if (obj instanceof String) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // io.flutter.plugins.sharedpreferences.SharedPreferencesListEncoder
    public String encode(List<String> list) throws IOException {
        kotlin.jvm.internal.r.f(list, "list");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.flush();
        String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        kotlin.jvm.internal.r.e(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
