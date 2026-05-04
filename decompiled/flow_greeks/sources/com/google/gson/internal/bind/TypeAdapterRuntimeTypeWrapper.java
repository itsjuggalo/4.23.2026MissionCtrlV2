package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import gb.c;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f6755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter f6756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f6757c;

    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter typeAdapter, Type type) {
        this.f6755a = gson;
        this.f6756b = typeAdapter;
        this.f6757c = type;
    }

    public static Type f(Type type, Object obj) {
        return obj != null ? ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type : type;
    }

    public static boolean g(TypeAdapter typeAdapter) {
        TypeAdapter typeAdapterF;
        while ((typeAdapter instanceof SerializationDelegatingTypeAdapter) && (typeAdapterF = ((SerializationDelegatingTypeAdapter) typeAdapter).f()) != typeAdapter) {
            typeAdapter = typeAdapterF;
        }
        return typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    @Override // com.google.gson.TypeAdapter
    public Object c(gb.a aVar) {
        return this.f6756b.c(aVar);
    }

    @Override // com.google.gson.TypeAdapter
    public void e(c cVar, Object obj) {
        TypeAdapter typeAdapterK = this.f6756b;
        Type typeF = f(this.f6757c, obj);
        if (typeF != this.f6757c) {
            typeAdapterK = this.f6755a.k(fb.a.b(typeF));
            if ((typeAdapterK instanceof ReflectiveTypeAdapterFactory.Adapter) && !g(this.f6756b)) {
                typeAdapterK = this.f6756b;
            }
        }
        typeAdapterK.e(cVar, obj);
    }
}
