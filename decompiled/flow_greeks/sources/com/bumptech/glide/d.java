package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import c4.f;
import com.bumptech.glide.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l f5203k = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3.b f5204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f.b f5205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z3.b f5206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b.a f5207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f5208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f5209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i3.k f5210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f5211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f5212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y3.f f5213j;

    public d(Context context, j3.b bVar, f.b bVar2, z3.b bVar3, b.a aVar, Map map, List list, i3.k kVar, e eVar, int i10) {
        super(context.getApplicationContext());
        this.f5204a = bVar;
        this.f5206c = bVar3;
        this.f5207d = aVar;
        this.f5208e = list;
        this.f5209f = map;
        this.f5210g = kVar;
        this.f5211h = eVar;
        this.f5212i = i10;
        this.f5205b = c4.f.a(bVar2);
    }

    public j3.b a() {
        return this.f5204a;
    }

    public List b() {
        return this.f5208e;
    }

    public synchronized y3.f c() {
        try {
            if (this.f5213j == null) {
                this.f5213j = (y3.f) this.f5207d.build().K();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f5213j;
    }

    public l d(Class cls) {
        l lVar = (l) this.f5209f.get(cls);
        if (lVar == null) {
            for (Map.Entry entry : this.f5209f.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    lVar = (l) entry.getValue();
                }
            }
        }
        return lVar == null ? f5203k : lVar;
    }

    public i3.k e() {
        return this.f5210g;
    }

    public e f() {
        return this.f5211h;
    }

    public int g() {
        return this.f5212i;
    }

    public h h() {
        return (h) this.f5205b.get();
    }
}
