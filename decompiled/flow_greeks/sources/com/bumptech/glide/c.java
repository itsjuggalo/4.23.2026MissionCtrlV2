package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.b;
import com.bumptech.glide.e;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import k3.a;
import k3.i;
import v3.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i3.k f5187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j3.d f5188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j3.b f5189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k3.h f5190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l3.b f5191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l3.b f5192h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a.InterfaceC0251a f5193i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k3.i f5194j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public v3.c f5195k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o.b f5198n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l3.b f5199o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f5200p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List f5201q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5185a = new w.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e.a f5186b = new e.a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5196l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b.a f5197m = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements b.a {
        public a() {
        }

        @Override // com.bumptech.glide.b.a
        public y3.f build() {
            return new y3.f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
    }

    /* JADX INFO: renamed from: com.bumptech.glide.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0092c {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e {
    }

    public com.bumptech.glide.b a(Context context, List list, w3.a aVar) {
        if (this.f5191g == null) {
            this.f5191g = l3.b.K();
        }
        if (this.f5192h == null) {
            this.f5192h = l3.b.E();
        }
        if (this.f5199o == null) {
            this.f5199o = l3.b.u();
        }
        if (this.f5194j == null) {
            this.f5194j = new i.a(context).a();
        }
        if (this.f5195k == null) {
            this.f5195k = new v3.e();
        }
        if (this.f5188d == null) {
            int iB = this.f5194j.b();
            if (iB > 0) {
                this.f5188d = new j3.k(iB);
            } else {
                this.f5188d = new j3.e();
            }
        }
        if (this.f5189e == null) {
            this.f5189e = new j3.i(this.f5194j.a());
        }
        if (this.f5190f == null) {
            this.f5190f = new k3.g(this.f5194j.d());
        }
        if (this.f5193i == null) {
            this.f5193i = new k3.f(context);
        }
        if (this.f5187c == null) {
            this.f5187c = new i3.k(this.f5190f, this.f5193i, this.f5192h, this.f5191g, l3.b.N(), this.f5199o, this.f5200p);
        }
        List list2 = this.f5201q;
        if (list2 == null) {
            this.f5201q = Collections.EMPTY_LIST;
        } else {
            this.f5201q = Collections.unmodifiableList(list2);
        }
        return new com.bumptech.glide.b(context, this.f5187c, this.f5190f, this.f5188d, this.f5189e, new o(this.f5198n), this.f5195k, this.f5196l, this.f5197m, this.f5185a, this.f5201q, list, aVar, this.f5186b.b());
    }

    public void b(o.b bVar) {
        this.f5198n = bVar;
    }
}
