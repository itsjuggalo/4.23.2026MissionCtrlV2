package com.bumptech.glide;

import W0.t;
import W0.v;
import a1.o;
import a1.p;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import l1.C2312a;
import l1.C2313b;
import l1.C2314c;
import l1.C2315d;
import r1.AbstractC2670a;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f14763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2312a f14764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l1.e f14765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l1.f f14766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bumptech.glide.load.data.f f14767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i1.f f14768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C2313b f14769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C2315d f14770h = new C2315d();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C2314c f14771i = new C2314c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final S.d f14772j;

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    public static class c extends a {
        public c(Class cls, Class cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public c(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public c(Object obj, List list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + obj);
        }
    }

    public static class d extends a {
        public d(Class cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class e extends a {
        public e(Class cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public h() {
        S.d dVarE = AbstractC2670a.e();
        this.f14772j = dVarE;
        this.f14763a = new p(dVarE);
        this.f14764b = new C2312a();
        this.f14765c = new l1.e();
        this.f14766d = new l1.f();
        this.f14767e = new com.bumptech.glide.load.data.f();
        this.f14768f = new i1.f();
        this.f14769g = new C2313b();
        r(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }

    public h a(Class cls, U0.d dVar) {
        this.f14764b.a(cls, dVar);
        return this;
    }

    public h b(Class cls, U0.k kVar) {
        this.f14766d.a(cls, kVar);
        return this;
    }

    public h c(Class cls, Class cls2, U0.j jVar) {
        e("legacy_append", cls, cls2, jVar);
        return this;
    }

    public h d(Class cls, Class cls2, o oVar) {
        this.f14763a.a(cls, cls2, oVar);
        return this;
    }

    public h e(String str, Class cls, Class cls2, U0.j jVar) {
        this.f14765c.a(str, jVar, cls, cls2);
        return this;
    }

    public final List f(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f14765c.d(cls, cls2)) {
            for (Class cls5 : this.f14768f.b(cls4, cls3)) {
                arrayList.add(new W0.i(cls, cls4, cls5, this.f14765c.b(cls, cls4), this.f14768f.a(cls4, cls5), this.f14772j));
            }
        }
        return arrayList;
    }

    public List g() {
        List listB = this.f14769g.b();
        if (listB.isEmpty()) {
            throw new b();
        }
        return listB;
    }

    public t h(Class cls, Class cls2, Class cls3) {
        t tVarA = this.f14771i.a(cls, cls2, cls3);
        if (this.f14771i.c(tVarA)) {
            return null;
        }
        if (tVarA == null) {
            List listF = f(cls, cls2, cls3);
            tVarA = listF.isEmpty() ? null : new t(cls, cls2, cls3, listF, this.f14772j);
            this.f14771i.d(cls, cls2, cls3, tVarA);
        }
        return tVarA;
    }

    public List i(Object obj) {
        return this.f14763a.d(obj);
    }

    public List j(Class cls, Class cls2, Class cls3) {
        List listA = this.f14770h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList();
            Iterator it = this.f14763a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class cls4 : this.f14765c.d((Class) it.next(), cls2)) {
                    if (!this.f14768f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.f14770h.b(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    public U0.k k(v vVar) {
        U0.k kVarB = this.f14766d.b(vVar.d());
        if (kVarB != null) {
            return kVarB;
        }
        throw new d(vVar.d());
    }

    public com.bumptech.glide.load.data.e l(Object obj) {
        return this.f14767e.a(obj);
    }

    public U0.d m(Object obj) {
        U0.d dVarB = this.f14764b.b(obj.getClass());
        if (dVarB != null) {
            return dVarB;
        }
        throw new e(obj.getClass());
    }

    public boolean n(v vVar) {
        return this.f14766d.b(vVar.d()) != null;
    }

    public h o(ImageHeaderParser imageHeaderParser) {
        this.f14769g.a(imageHeaderParser);
        return this;
    }

    public h p(e.a aVar) {
        this.f14767e.b(aVar);
        return this;
    }

    public h q(Class cls, Class cls2, i1.e eVar) {
        this.f14768f.c(cls, cls2, eVar);
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
        this.f14765c.e(arrayList);
        return this;
    }
}
