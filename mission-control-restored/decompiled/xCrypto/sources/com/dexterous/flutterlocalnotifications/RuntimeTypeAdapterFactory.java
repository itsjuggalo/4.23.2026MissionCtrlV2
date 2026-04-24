package com.dexterous.flutterlocalnotifications;

import java.util.LinkedHashMap;
import java.util.Map;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: loaded from: classes.dex */
public final class RuntimeTypeAdapterFactory<T> implements q2.x {
    private final Class<?> baseType;
    private final Map<String, Class<?>> labelToSubtype = new LinkedHashMap();
    private final Map<Class<?>, String> subtypeToLabel = new LinkedHashMap();
    private final String typeFieldName;

    public class a extends q2.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f9549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f9550b;

        public a(Map map, Map map2) {
            this.f9549a = map;
            this.f9550b = map2;
        }

        @Override // q2.w
        public Object c(C1946a c1946a) {
            q2.j jVarA = s2.F.a(c1946a);
            q2.j jVarT = jVarA.i().t(RuntimeTypeAdapterFactory.this.typeFieldName);
            if (jVarT == null) {
                throw new q2.n("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " because it does not define a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
            }
            String strL = jVarT.l();
            q2.w wVar = (q2.w) this.f9549a.get(strL);
            if (wVar != null) {
                return wVar.a(jVarA);
            }
            throw new q2.n("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " subtype named " + strL + "; did you forget to register a subtype?");
        }

        @Override // q2.w
        public void e(y2.c cVar, Object obj) {
            Class<?> cls = obj.getClass();
            String str = (String) RuntimeTypeAdapterFactory.this.subtypeToLabel.get(cls);
            q2.w wVar = (q2.w) this.f9550b.get(cls);
            if (wVar == null) {
                throw new q2.n("cannot serialize " + cls.getName() + "; did you forget to register a subtype?");
            }
            q2.m mVarI = wVar.d(obj).i();
            if (mVarI.s(RuntimeTypeAdapterFactory.this.typeFieldName)) {
                throw new q2.n("cannot serialize " + cls.getName() + " because it already defines a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
            }
            q2.m mVar = new q2.m();
            mVar.q(RuntimeTypeAdapterFactory.this.typeFieldName, new q2.o(str));
            for (Map.Entry entry : mVarI.r()) {
                mVar.q((String) entry.getKey(), (q2.j) entry.getValue());
            }
            s2.F.b(mVar, cVar);
        }
    }

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

    @Override // q2.x
    public <R> q2.w create(q2.e eVar, C1925a<R> c1925a) {
        if (c1925a.c() != this.baseType) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Class<?>> entry : this.labelToSubtype.entrySet()) {
            q2.w wVarM = eVar.m(this, C1925a.a(entry.getValue()));
            linkedHashMap.put(entry.getKey(), wVarM);
            linkedHashMap2.put(entry.getValue(), wVarM);
        }
        return new a(linkedHashMap, linkedHashMap2).b();
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
