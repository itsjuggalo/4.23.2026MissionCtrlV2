package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class Excluder implements com.google.gson.v, Cloneable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Excluder f6662g = new Excluder();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f6663a = -1.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6664b = 136;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6665c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f6667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f6668f;

    public Excluder() {
        List list = Collections.EMPTY_LIST;
        this.f6667e = list;
        this.f6668f = list;
    }

    public static boolean d(Class cls) {
        return cls.isMemberClass() && !eb.a.n(cls);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean b(Class cls, boolean z10) {
        if (this.f6663a != -1.0d && !h((cb.d) cls.getAnnotation(cb.d.class), (cb.e) cls.getAnnotation(cb.e.class))) {
            return true;
        }
        if (!this.f6665c && d(cls)) {
            return true;
        }
        if (!z10 && !Enum.class.isAssignableFrom(cls) && eb.a.l(cls)) {
            return true;
        }
        Iterator it = (z10 ? this.f6667e : this.f6668f).iterator();
        if (!it.hasNext()) {
            return false;
        }
        android.support.v4.media.session.b.a(it.next());
        throw null;
    }

    public boolean c(Field field, boolean z10) {
        cb.a aVar;
        if ((this.f6664b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f6663a != -1.0d && !h((cb.d) field.getAnnotation(cb.d.class), (cb.e) field.getAnnotation(cb.e.class))) || field.isSynthetic()) {
            return true;
        }
        if ((this.f6666d && ((aVar = (cb.a) field.getAnnotation(cb.a.class)) == null || (!z10 ? aVar.deserialize() : aVar.serialize()))) || b(field.getType(), z10)) {
            return true;
        }
        List list = z10 ? this.f6667e : this.f6668f;
        if (list.isEmpty()) {
            return false;
        }
        new com.google.gson.a(field);
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        android.support.v4.media.session.b.a(it.next());
        throw null;
    }

    @Override // com.google.gson.v
    public TypeAdapter create(final Gson gson, final fb.a aVar) {
        Class clsC = aVar.c();
        final boolean zB = b(clsC, true);
        final boolean zB2 = b(clsC, false);
        if (zB || zB2) {
            return new TypeAdapter() { // from class: com.google.gson.internal.Excluder.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public volatile TypeAdapter f6669a;

                @Override // com.google.gson.TypeAdapter
                public Object c(gb.a aVar2) throws IOException {
                    if (!zB2) {
                        return f().c(aVar2);
                    }
                    aVar2.x0();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void e(gb.c cVar, Object obj) throws IOException {
                    if (zB) {
                        cVar.a0();
                    } else {
                        f().e(cVar, obj);
                    }
                }

                public final TypeAdapter f() {
                    TypeAdapter typeAdapter = this.f6669a;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter typeAdapterM = gson.m(Excluder.this, aVar);
                    this.f6669a = typeAdapterM;
                    return typeAdapterM;
                }
            };
        }
        return null;
    }

    public final boolean f(cb.d dVar) {
        if (dVar != null) {
            return this.f6663a >= dVar.value();
        }
        return true;
    }

    public final boolean g(cb.e eVar) {
        if (eVar != null) {
            return this.f6663a < eVar.value();
        }
        return true;
    }

    public final boolean h(cb.d dVar, cb.e eVar) {
        return f(dVar) && g(eVar);
    }
}
