package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i;
import com.google.gson.internal.a0;
import com.google.gson.internal.e0;
import com.google.gson.internal.u;
import com.google.gson.internal.w;
import com.google.gson.n;
import com.google.gson.p;
import com.google.gson.v;
import gb.c;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class MapTypeAdapterFactory implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f6703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6704b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class Adapter<K, V> extends TypeAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TypeAdapter f6705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TypeAdapter f6706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a0 f6707c;

        public Adapter(Gson gson, Type type, TypeAdapter typeAdapter, Type type2, TypeAdapter typeAdapter2, a0 a0Var) {
            this.f6705a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f6706b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f6707c = a0Var;
        }

        public final String f(i iVar) {
            if (!iVar.r()) {
                if (iVar.p()) {
                    return "null";
                }
                throw new AssertionError();
            }
            n nVarE = iVar.e();
            if (nVarE.L()) {
                return String.valueOf(nVarE.A());
            }
            if (nVarE.G()) {
                return Boolean.toString(nVarE.a());
            }
            if (nVarE.R()) {
                return nVarE.f();
            }
            throw new AssertionError();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map c(gb.a aVar) throws IOException {
            gb.b bVarN0 = aVar.n0();
            if (bVarN0 == gb.b.NULL) {
                aVar.j0();
                return null;
            }
            Map map = (Map) this.f6707c.a();
            if (bVarN0 != gb.b.BEGIN_ARRAY) {
                aVar.e();
                while (aVar.Z()) {
                    w.f6848a.a(aVar);
                    Object objC = this.f6705a.c(aVar);
                    if (map.put(objC, this.f6706b.c(aVar)) != null) {
                        throw new p("duplicate key: " + objC);
                    }
                }
                aVar.G();
                return map;
            }
            aVar.c();
            while (aVar.Z()) {
                aVar.c();
                Object objC2 = this.f6705a.c(aVar);
                if (map.put(objC2, this.f6706b.c(aVar)) != null) {
                    throw new p("duplicate key: " + objC2);
                }
                aVar.E();
            }
            aVar.E();
            return map;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(c cVar, Map map) throws IOException {
            if (map == null) {
                cVar.a0();
                return;
            }
            if (!MapTypeAdapterFactory.this.f6704b) {
                cVar.u();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.R(String.valueOf(entry.getKey()));
                    this.f6706b.e(cVar, entry.getValue());
                }
                cVar.G();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i10 = 0;
            boolean z10 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                i iVarD = this.f6705a.d(entry2.getKey());
                arrayList.add(iVarD);
                arrayList2.add(entry2.getValue());
                z10 |= iVarD.g() || iVarD.q();
            }
            if (!z10) {
                cVar.u();
                int size = arrayList.size();
                while (i10 < size) {
                    cVar.R(f((i) arrayList.get(i10)));
                    this.f6706b.e(cVar, arrayList2.get(i10));
                    i10++;
                }
                cVar.G();
                return;
            }
            cVar.o();
            int size2 = arrayList.size();
            while (i10 < size2) {
                cVar.o();
                e0.b((i) arrayList.get(i10), cVar);
                this.f6706b.e(cVar, arrayList2.get(i10));
                cVar.E();
                i10++;
            }
            cVar.E();
        }
    }

    public MapTypeAdapterFactory(u uVar, boolean z10) {
        this.f6703a = uVar;
        this.f6704b = z10;
    }

    public final TypeAdapter a(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.f6763f : gson.k(fb.a.b(type));
    }

    @Override // com.google.gson.v
    public TypeAdapter create(Gson gson, fb.a aVar) {
        Type typeD = aVar.d();
        Class clsC = aVar.c();
        if (!Map.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type[] typeArrJ = com.google.gson.internal.b.j(typeD, clsC);
        return new Adapter(gson, typeArrJ[0], a(gson, typeArrJ[0]), typeArrJ[1], gson.k(fb.a.b(typeArrJ[1])), this.f6703a.t(aVar));
    }
}
