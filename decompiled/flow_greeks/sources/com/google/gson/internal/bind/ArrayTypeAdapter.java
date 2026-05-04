package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.v;
import gb.c;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f6682c = new v() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.v
        public TypeAdapter create(Gson gson, fb.a aVar) {
            Type typeD = aVar.d();
            if (!(typeD instanceof GenericArrayType) && (!(typeD instanceof Class) || !((Class) typeD).isArray())) {
                return null;
            }
            Type typeG = com.google.gson.internal.b.g(typeD);
            return new ArrayTypeAdapter(gson, gson.k(fb.a.b(typeG)), com.google.gson.internal.b.k(typeG));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f6683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter f6684b;

    public ArrayTypeAdapter(Gson gson, TypeAdapter typeAdapter, Class cls) {
        this.f6684b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f6683a = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public Object c(gb.a aVar) throws IOException {
        if (aVar.n0() == gb.b.NULL) {
            aVar.j0();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.c();
        while (aVar.Z()) {
            arrayList.add(this.f6684b.c(aVar));
        }
        aVar.E();
        int size = arrayList.size();
        if (!this.f6683a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f6683a, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.f6683a, size);
        for (int i10 = 0; i10 < size; i10++) {
            Array.set(objNewInstance, i10, arrayList.get(i10));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public void e(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.a0();
            return;
        }
        cVar.o();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f6684b.e(cVar, Array.get(obj, i10));
        }
        cVar.E();
    }
}
