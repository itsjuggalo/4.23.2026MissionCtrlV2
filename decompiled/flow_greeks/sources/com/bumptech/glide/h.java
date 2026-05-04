package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import i3.t;
import i3.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m3.o;
import m3.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f5226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x3.a f5227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x3.e f5228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x3.f f5229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bumptech.glide.load.data.f f5230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u3.f f5231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x3.b f5232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x3.d f5233h = new x3.d();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x3.c f5234i = new x3.c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s0.c f5235j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends a {
        public c(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public c(Object obj, List list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + obj);
        }

        public c(Class cls, Class cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d extends a {
        public d(Class cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e extends a {
        public e(Class cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public h() {
        s0.c cVarE = d4.a.e();
        this.f5235j = cVarE;
        this.f5226a = new p(cVarE);
        this.f5227b = new x3.a();
        this.f5228c = new x3.e();
        this.f5229d = new x3.f();
        this.f5230e = new com.bumptech.glide.load.data.f();
        this.f5231f = new u3.f();
        this.f5232g = new x3.b();
        r(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }

    public h a(Class cls, g3.d dVar) {
        this.f5227b.a(cls, dVar);
        return this;
    }

    public h b(Class cls, g3.k kVar) {
        this.f5229d.a(cls, kVar);
        return this;
    }

    public h c(Class cls, Class cls2, g3.j jVar) {
        e("legacy_append", cls, cls2, jVar);
        return this;
    }

    public h d(Class cls, Class cls2, o oVar) {
        this.f5226a.a(cls, cls2, oVar);
        return this;
    }

    public h e(String str, Class cls, Class cls2, g3.j jVar) {
        this.f5228c.a(str, jVar, cls, cls2);
        return this;
    }

    public final List f(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f5228c.d(cls, cls2)) {
            for (Class cls5 : this.f5231f.b(cls4, cls3)) {
                arrayList.add(new i3.i(cls, cls4, cls5, this.f5228c.b(cls, cls4), this.f5231f.a(cls4, cls5), this.f5235j));
            }
        }
        return arrayList;
    }

    public List g() {
        List listB = this.f5232g.b();
        if (listB.isEmpty()) {
            throw new b();
        }
        return listB;
    }

    public t h(Class cls, Class cls2, Class cls3) {
        Class cls4;
        Class cls5;
        Class cls6;
        t tVarA = this.f5234i.a(cls, cls2, cls3);
        t tVar = null;
        if (this.f5234i.c(tVarA)) {
            return null;
        }
        if (tVarA != null) {
            return tVarA;
        }
        List listF = f(cls, cls2, cls3);
        if (listF.isEmpty()) {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
        } else {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
            tVar = new t(cls4, cls5, cls6, listF, this.f5235j);
        }
        this.f5234i.d(cls4, cls5, cls6, tVar);
        return tVar;
    }

    public List i(Object obj) {
        return this.f5226a.d(obj);
    }

    public List j(Class cls, Class cls2, Class cls3) {
        List listA = this.f5233h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList();
            Iterator it = this.f5226a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class cls4 : this.f5228c.d((Class) it.next(), cls2)) {
                    if (!this.f5231f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.f5233h.b(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    public g3.k k(v vVar) {
        g3.k kVarB = this.f5229d.b(vVar.d());
        if (kVarB != null) {
            return kVarB;
        }
        throw new d(vVar.d());
    }

    public com.bumptech.glide.load.data.e l(Object obj) {
        return this.f5230e.a(obj);
    }

    public g3.d m(Object obj) {
        g3.d dVarB = this.f5227b.b(obj.getClass());
        if (dVarB != null) {
            return dVarB;
        }
        throw new e(obj.getClass());
    }

    public boolean n(v vVar) {
        return this.f5229d.b(vVar.d()) != null;
    }

    public h o(ImageHeaderParser imageHeaderParser) {
        this.f5232g.a(imageHeaderParser);
        return this;
    }

    public h p(e.a aVar) {
        this.f5230e.b(aVar);
        return this;
    }

    public h q(Class cls, Class cls2, u3.e eVar) {
        this.f5231f.c(cls, cls2, eVar);
        return this;
    }

    public final h r(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        this.f5228c.e(arrayList);
        return this;
    }
}
