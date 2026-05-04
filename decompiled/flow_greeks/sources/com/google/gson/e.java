package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Excluder f6641a = Excluder.f6662g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f6642b = q.f6879a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f6643c = b.f6628a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f6644d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f6645e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f6646f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6647g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6648h = Gson.B;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6649i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6650j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6651k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6652l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6653m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f6654n = Gson.A;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6655o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public s f6656p = Gson.f6595z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6657q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public u f6658r = Gson.D;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public u f6659s = Gson.E;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayDeque f6660t = new ArrayDeque();

    public static void a(String str, int i10, int i11, List list) {
        v vVarB;
        v vVarB2;
        boolean z10 = com.google.gson.internal.sql.a.f6838a;
        v vVarA = null;
        if (str != null && !str.trim().isEmpty()) {
            vVarB = DefaultDateTypeAdapter.a.f6691b.b(str);
            if (z10) {
                vVarA = com.google.gson.internal.sql.a.f6840c.b(str);
                vVarB2 = com.google.gson.internal.sql.a.f6839b.b(str);
            } else {
                vVarB2 = null;
            }
        } else {
            if (i10 == 2 && i11 == 2) {
                return;
            }
            v vVarA2 = DefaultDateTypeAdapter.a.f6691b.a(i10, i11);
            if (z10) {
                vVarA = com.google.gson.internal.sql.a.f6840c.a(i10, i11);
                v vVarA3 = com.google.gson.internal.sql.a.f6839b.a(i10, i11);
                vVarB = vVarA2;
                vVarB2 = vVarA3;
            } else {
                vVarB = vVarA2;
                vVarB2 = null;
            }
        }
        list.add(vVarB);
        if (z10) {
            list.add(vVarA);
            list.add(vVarB2);
        }
    }

    public static boolean c(Type type) {
        return type == Object.class;
    }

    public Gson b() {
        ArrayList arrayList = new ArrayList(this.f6645e.size() + this.f6646f.size() + 3);
        arrayList.addAll(this.f6645e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f6646f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f6648h, this.f6649i, this.f6650j, arrayList);
        return new Gson(this.f6641a, this.f6643c, new HashMap(this.f6644d), this.f6647g, this.f6651k, this.f6655o, this.f6653m, this.f6654n, this.f6656p, this.f6652l, this.f6657q, this.f6642b, this.f6648h, this.f6649i, this.f6650j, new ArrayList(this.f6645e), new ArrayList(this.f6646f), arrayList, this.f6658r, this.f6659s, new ArrayList(this.f6660t));
    }

    public e d(Type type, Object obj) {
        Objects.requireNonNull(type);
        com.google.gson.internal.a.a((obj instanceof h) || (obj instanceof TypeAdapter));
        if (c(type)) {
            throw new IllegalArgumentException("Cannot override built-in adapter for " + type);
        }
        if (obj instanceof h) {
            this.f6645e.add(TreeTypeAdapter.h(fb.a.b(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f6645e.add(TypeAdapters.a(fb.a.b(type), (TypeAdapter) obj));
        }
        return this;
    }

    public e e(v vVar) {
        Objects.requireNonNull(vVar);
        this.f6645e.add(vVar);
        return this;
    }
}
