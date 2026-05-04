package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.a0;
import com.google.gson.internal.u;
import com.google.gson.v;
import gb.c;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class CollectionTypeAdapterFactory implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f6685a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class Adapter<E> extends TypeAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TypeAdapter f6686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a0 f6687b;

        public Adapter(Gson gson, Type type, TypeAdapter typeAdapter, a0 a0Var) {
            this.f6686a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f6687b = a0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection c(gb.a aVar) throws IOException {
            if (aVar.n0() == gb.b.NULL) {
                aVar.j0();
                return null;
            }
            Collection collection = (Collection) this.f6687b.a();
            aVar.c();
            while (aVar.Z()) {
                collection.add(this.f6686a.c(aVar));
            }
            aVar.E();
            return collection;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(c cVar, Collection collection) throws IOException {
            if (collection == null) {
                cVar.a0();
                return;
            }
            cVar.o();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f6686a.e(cVar, it.next());
            }
            cVar.E();
        }
    }

    public CollectionTypeAdapterFactory(u uVar) {
        this.f6685a = uVar;
    }

    @Override // com.google.gson.v
    public TypeAdapter create(Gson gson, fb.a aVar) {
        Type typeD = aVar.d();
        Class clsC = aVar.c();
        if (!Collection.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type typeH = com.google.gson.internal.b.h(typeD, clsC);
        return new Adapter(gson, typeH, gson.k(fb.a.b(typeH)), this.f6685a.t(aVar));
    }
}
