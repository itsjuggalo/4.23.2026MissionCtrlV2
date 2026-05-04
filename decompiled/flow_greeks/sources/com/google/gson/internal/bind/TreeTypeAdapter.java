package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.internal.e0;
import com.google.gson.o;
import com.google.gson.v;
import gb.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f6743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f6744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fb.a f6745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f6746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f6747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f6748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile TypeAdapter f6749g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class SingleTypeFactory implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fb.a f6750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f6751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class f6752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h f6753d;

        public SingleTypeFactory(Object obj, fb.a aVar, boolean z10, Class cls) {
            h hVar = obj instanceof h ? (h) obj : null;
            this.f6753d = hVar;
            com.google.gson.internal.a.a(hVar != null);
            this.f6750a = aVar;
            this.f6751b = z10;
            this.f6752c = cls;
        }

        @Override // com.google.gson.v
        public TypeAdapter create(Gson gson, fb.a aVar) {
            fb.a aVar2 = this.f6750a;
            if (aVar2 != null ? aVar2.equals(aVar) || (this.f6751b && this.f6750a.d() == aVar.c()) : this.f6752c.isAssignableFrom(aVar.c())) {
                return new TreeTypeAdapter(null, this.f6753d, gson, aVar, this);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b implements g {
        public b() {
        }
    }

    public TreeTypeAdapter(o oVar, h hVar, Gson gson, fb.a aVar, v vVar, boolean z10) {
        this.f6747e = new b();
        this.f6743a = hVar;
        this.f6744b = gson;
        this.f6745c = aVar;
        this.f6746d = vVar;
        this.f6748f = z10;
    }

    private TypeAdapter g() {
        TypeAdapter typeAdapter = this.f6749g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter typeAdapterM = this.f6744b.m(this.f6746d, this.f6745c);
        this.f6749g = typeAdapterM;
        return typeAdapterM;
    }

    public static v h(fb.a aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.d() == aVar.c(), null);
    }

    @Override // com.google.gson.TypeAdapter
    public Object c(gb.a aVar) {
        if (this.f6743a == null) {
            return g().c(aVar);
        }
        i iVarA = e0.a(aVar);
        if (this.f6748f && iVarA.p()) {
            return null;
        }
        return this.f6743a.a(iVarA, this.f6745c.d(), this.f6747e);
    }

    @Override // com.google.gson.TypeAdapter
    public void e(c cVar, Object obj) {
        g().e(cVar, obj);
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public TypeAdapter f() {
        return g();
    }

    public TreeTypeAdapter(o oVar, h hVar, Gson gson, fb.a aVar, v vVar) {
        this(oVar, hVar, gson, aVar, vVar, true);
    }
}
