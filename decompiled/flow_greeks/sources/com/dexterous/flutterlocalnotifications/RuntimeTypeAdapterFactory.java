package com.dexterous.flutterlocalnotifications;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i;
import com.google.gson.internal.e0;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.v;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public final class RuntimeTypeAdapterFactory<T> implements v {
    private final Class<?> baseType;
    private final Map<String, Class<?>> labelToSubtype = new LinkedHashMap();
    private final Map<Class<?>, String> subtypeToLabel = new LinkedHashMap();
    private final String typeFieldName;

    private RuntimeTypeAdapterFactory(Class<?> cls, String str) {
        if (str == null || cls == null) {
            throw null;
        }
        this.baseType = cls;
        this.typeFieldName = str;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls, String str) {
        return new RuntimeTypeAdapterFactory<>(cls, str);
    }

    @Override // com.google.gson.v
    public <R> TypeAdapter create(Gson gson, fb.a<R> aVar) {
        if (aVar.c() != this.baseType) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Class<?>> entry : this.labelToSubtype.entrySet()) {
            TypeAdapter typeAdapterM = gson.m(this, fb.a.a(entry.getValue()));
            linkedHashMap.put(entry.getKey(), typeAdapterM);
            linkedHashMap2.put(entry.getValue(), typeAdapterM);
        }
        return new TypeAdapter() { // from class: com.dexterous.flutterlocalnotifications.RuntimeTypeAdapterFactory.1
            @Override // com.google.gson.TypeAdapter
            public Object c(gb.a aVar2) {
                i iVarA = e0.a(aVar2);
                i iVarW = iVarA.d().w(RuntimeTypeAdapterFactory.this.typeFieldName);
                if (iVarW == null) {
                    throw new m("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " because it does not define a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
                }
                String strF = iVarW.f();
                TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap.get(strF);
                if (typeAdapter != null) {
                    return typeAdapter.a(iVarA);
                }
                throw new m("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " subtype named " + strF + "; did you forget to register a subtype?");
            }

            @Override // com.google.gson.TypeAdapter
            public void e(gb.c cVar, Object obj) {
                Class<?> cls = obj.getClass();
                String str = (String) RuntimeTypeAdapterFactory.this.subtypeToLabel.get(cls);
                TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap2.get(cls);
                if (typeAdapter == null) {
                    throw new m("cannot serialize " + cls.getName() + "; did you forget to register a subtype?");
                }
                l lVarD = typeAdapter.d(obj).d();
                if (lVarD.v(RuntimeTypeAdapterFactory.this.typeFieldName)) {
                    throw new m("cannot serialize " + cls.getName() + " because it already defines a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
                }
                l lVar = new l();
                lVar.s(RuntimeTypeAdapterFactory.this.typeFieldName, new n(str));
                for (Map.Entry entry2 : lVarD.u()) {
                    lVar.s((String) entry2.getKey(), (i) entry2.getValue());
                }
                e0.b(lVar, cVar);
            }
        }.b();
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls, String str) {
        if (cls == null || str == null) {
            throw null;
        }
        if (this.subtypeToLabel.containsKey(cls) || this.labelToSubtype.containsKey(str)) {
            throw new IllegalArgumentException("types and labels must be unique");
        }
        this.labelToSubtype.put(str, cls);
        this.subtypeToLabel.put(cls, str);
        return this;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls) {
        return new RuntimeTypeAdapterFactory<>(cls, "type");
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls) {
        return registerSubtype(cls, cls.getSimpleName());
    }
}
