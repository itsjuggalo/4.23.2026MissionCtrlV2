package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.h;
import com.google.gson.internal.u;
import com.google.gson.v;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f6697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f6698d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f6699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f6700b = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class DummyTypeAdapterFactory implements v {
        private DummyTypeAdapterFactory() {
        }

        @Override // com.google.gson.v
        public TypeAdapter create(Gson gson, fb.a aVar) {
            throw new AssertionError("Factory should not be used");
        }
    }

    static {
        f6697c = new DummyTypeAdapterFactory();
        f6698d = new DummyTypeAdapterFactory();
    }

    public JsonAdapterAnnotationTypeAdapterFactory(u uVar) {
        this.f6699a = uVar;
    }

    public static Object a(u uVar, Class cls) {
        return uVar.t(fb.a.a(cls)).a();
    }

    public static cb.b b(Class cls) {
        return (cb.b) cls.getAnnotation(cb.b.class);
    }

    public TypeAdapter c(u uVar, Gson gson, fb.a aVar, cb.b bVar, boolean z10) {
        TypeAdapter typeAdapterCreate;
        Object objA = a(uVar, bVar.value());
        boolean zNullSafe = bVar.nullSafe();
        if (objA instanceof TypeAdapter) {
            typeAdapterCreate = (TypeAdapter) objA;
        } else if (objA instanceof v) {
            v vVarE = (v) objA;
            if (z10) {
                vVarE = e(aVar.c(), vVarE);
            }
            typeAdapterCreate = vVarE.create(gson, aVar);
        } else {
            if (!(objA instanceof h)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            TreeTypeAdapter treeTypeAdapter = new TreeTypeAdapter(null, objA instanceof h ? (h) objA : null, gson, aVar, z10 ? f6697c : f6698d, zNullSafe);
            zNullSafe = false;
            typeAdapterCreate = treeTypeAdapter;
        }
        return (typeAdapterCreate == null || !zNullSafe) ? typeAdapterCreate : typeAdapterCreate.b();
    }

    @Override // com.google.gson.v
    public TypeAdapter create(Gson gson, fb.a aVar) {
        cb.b bVarB = b(aVar.c());
        if (bVarB == null) {
            return null;
        }
        return c(this.f6699a, gson, aVar, bVarB, true);
    }

    public boolean d(fb.a aVar, v vVar) {
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(vVar);
        if (vVar == f6697c) {
            return true;
        }
        Class clsC = aVar.c();
        v vVar2 = (v) this.f6700b.get(clsC);
        if (vVar2 != null) {
            return vVar2 == vVar;
        }
        cb.b bVarB = b(clsC);
        if (bVarB == null) {
            return false;
        }
        Class clsValue = bVarB.value();
        return v.class.isAssignableFrom(clsValue) && e(clsC, (v) a(this.f6699a, clsValue)) == vVar;
    }

    public final v e(Class cls, v vVar) {
        v vVar2 = (v) this.f6700b.putIfAbsent(cls, vVar);
        return vVar2 != null ? vVar2 : vVar;
    }
}
