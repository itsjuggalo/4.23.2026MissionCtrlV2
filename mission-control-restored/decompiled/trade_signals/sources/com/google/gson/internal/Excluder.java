package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import l4.InterfaceC2335a;
import n4.AbstractC2425a;
import o4.C2462a;
import p4.C2568a;
import p4.C2570c;

/* JADX INFO: loaded from: classes.dex */
public final class Excluder implements com.google.gson.v, Cloneable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Excluder f16020g = new Excluder();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16024d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f16021a = -1.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16022b = 136;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16023c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f16025e = Collections.emptyList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f16026f = Collections.emptyList();

    public static boolean e(Class cls) {
        return cls.isMemberClass() && !AbstractC2425a.n(cls);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e8) {
            throw new AssertionError(e8);
        }
    }

    public boolean c(Class cls, boolean z7) {
        if (this.f16021a != -1.0d && !i((l4.d) cls.getAnnotation(l4.d.class), (l4.e) cls.getAnnotation(l4.e.class))) {
            return true;
        }
        if (!this.f16023c && e(cls)) {
            return true;
        }
        if (!z7 && !Enum.class.isAssignableFrom(cls) && AbstractC2425a.l(cls)) {
            return true;
        }
        Iterator it = (z7 ? this.f16025e : this.f16026f).iterator();
        if (!it.hasNext()) {
            return false;
        }
        android.support.v4.media.session.b.a(it.next());
        throw null;
    }

    @Override // com.google.gson.v
    public TypeAdapter create(final Gson gson, final C2462a c2462a) {
        Class clsC = c2462a.c();
        final boolean zC = c(clsC, true);
        final boolean zC2 = c(clsC, false);
        if (zC || zC2) {
            return new TypeAdapter() { // from class: com.google.gson.internal.Excluder.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public volatile TypeAdapter f16027a;

                @Override // com.google.gson.TypeAdapter
                public Object c(C2568a c2568a) throws IOException {
                    if (!zC2) {
                        return f().c(c2568a);
                    }
                    c2568a.H0();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void e(C2570c c2570c, Object obj) throws IOException {
                    if (zC) {
                        c2570c.R();
                    } else {
                        f().e(c2570c, obj);
                    }
                }

                public final TypeAdapter f() {
                    TypeAdapter typeAdapter = this.f16027a;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter typeAdapterM = gson.m(Excluder.this, c2462a);
                    this.f16027a = typeAdapterM;
                    return typeAdapterM;
                }
            };
        }
        return null;
    }

    public boolean d(Field field, boolean z7) {
        InterfaceC2335a interfaceC2335a;
        if ((this.f16022b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f16021a != -1.0d && !i((l4.d) field.getAnnotation(l4.d.class), (l4.e) field.getAnnotation(l4.e.class))) || field.isSynthetic()) {
            return true;
        }
        if ((this.f16024d && ((interfaceC2335a = (InterfaceC2335a) field.getAnnotation(InterfaceC2335a.class)) == null || (!z7 ? interfaceC2335a.deserialize() : interfaceC2335a.serialize()))) || c(field.getType(), z7)) {
            return true;
        }
        List list = z7 ? this.f16025e : this.f16026f;
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

    public final boolean g(l4.d dVar) {
        if (dVar != null) {
            return this.f16021a >= dVar.value();
        }
        return true;
    }

    public final boolean h(l4.e eVar) {
        if (eVar != null) {
            return this.f16021a < eVar.value();
        }
        return true;
    }

    public final boolean i(l4.d dVar, l4.e eVar) {
        return g(dVar) && h(eVar);
    }
}
