package m1;

import U0.l;
import W0.j;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import d1.r;
import d1.t;
import h1.AbstractC1854i;
import h1.C1848c;
import h1.C1851f;
import java.util.Map;
import p1.C2542a;
import q1.AbstractC2628k;
import q1.AbstractC2629l;
import q1.C2619b;

/* JADX INFO: renamed from: m1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2342a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21250a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f21254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f21256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21257h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f21262m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f21264o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21265p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f21269t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Resources.Theme f21270u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f21271v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f21272w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f21273x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f21275z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f21251b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f21252c = j.f9130e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bumptech.glide.g f21253d = com.bumptech.glide.g.NORMAL;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21258i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21259j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21260k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public U0.f f21261l = C2542a.c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f21263n = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public U0.h f21266q = new U0.h();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map f21267r = new C2619b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Class f21268s = Object.class;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f21274y = true;

    public static boolean I(int i8, int i9) {
        return (i8 & i9) != 0;
    }

    public final boolean A() {
        return this.f21275z;
    }

    public final boolean B() {
        return this.f21272w;
    }

    public final boolean C() {
        return this.f21271v;
    }

    public final boolean D(AbstractC2342a abstractC2342a) {
        return Float.compare(abstractC2342a.f21251b, this.f21251b) == 0 && this.f21255f == abstractC2342a.f21255f && AbstractC2629l.d(this.f21254e, abstractC2342a.f21254e) && this.f21257h == abstractC2342a.f21257h && AbstractC2629l.d(this.f21256g, abstractC2342a.f21256g) && this.f21265p == abstractC2342a.f21265p && AbstractC2629l.d(this.f21264o, abstractC2342a.f21264o) && this.f21258i == abstractC2342a.f21258i && this.f21259j == abstractC2342a.f21259j && this.f21260k == abstractC2342a.f21260k && this.f21262m == abstractC2342a.f21262m && this.f21263n == abstractC2342a.f21263n && this.f21272w == abstractC2342a.f21272w && this.f21273x == abstractC2342a.f21273x && this.f21252c.equals(abstractC2342a.f21252c) && this.f21253d == abstractC2342a.f21253d && this.f21266q.equals(abstractC2342a.f21266q) && this.f21267r.equals(abstractC2342a.f21267r) && this.f21268s.equals(abstractC2342a.f21268s) && AbstractC2629l.d(this.f21261l, abstractC2342a.f21261l) && AbstractC2629l.d(this.f21270u, abstractC2342a.f21270u);
    }

    public final boolean E() {
        return this.f21258i;
    }

    public final boolean F() {
        return H(8);
    }

    public boolean G() {
        return this.f21274y;
    }

    public final boolean H(int i8) {
        return I(this.f21250a, i8);
    }

    public final boolean J() {
        return this.f21262m;
    }

    public final boolean K() {
        return AbstractC2629l.t(this.f21260k, this.f21259j);
    }

    public AbstractC2342a L() {
        this.f21269t = true;
        return P();
    }

    public AbstractC2342a M(int i8, int i9) {
        if (this.f21271v) {
            return clone().M(i8, i9);
        }
        this.f21260k = i8;
        this.f21259j = i9;
        this.f21250a |= 512;
        return Q();
    }

    public AbstractC2342a N(int i8) {
        if (this.f21271v) {
            return clone().N(i8);
        }
        this.f21257h = i8;
        int i9 = this.f21250a | 128;
        this.f21256g = null;
        this.f21250a = i9 & (-65);
        return Q();
    }

    public AbstractC2342a O(com.bumptech.glide.g gVar) {
        if (this.f21271v) {
            return clone().O(gVar);
        }
        this.f21253d = (com.bumptech.glide.g) AbstractC2628k.d(gVar);
        this.f21250a |= 8;
        return Q();
    }

    public final AbstractC2342a Q() {
        if (this.f21269t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return P();
    }

    public AbstractC2342a R(U0.g gVar, Object obj) {
        if (this.f21271v) {
            return clone().R(gVar, obj);
        }
        AbstractC2628k.d(gVar);
        AbstractC2628k.d(obj);
        this.f21266q.e(gVar, obj);
        return Q();
    }

    public AbstractC2342a S(U0.f fVar) {
        if (this.f21271v) {
            return clone().S(fVar);
        }
        this.f21261l = (U0.f) AbstractC2628k.d(fVar);
        this.f21250a |= 1024;
        return Q();
    }

    public AbstractC2342a T(float f8) {
        if (this.f21271v) {
            return clone().T(f8);
        }
        if (f8 < 0.0f || f8 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f21251b = f8;
        this.f21250a |= 2;
        return Q();
    }

    public AbstractC2342a U(boolean z7) {
        if (this.f21271v) {
            return clone().U(true);
        }
        this.f21258i = !z7;
        this.f21250a |= 256;
        return Q();
    }

    public AbstractC2342a V(l lVar) {
        return W(lVar, true);
    }

    public AbstractC2342a W(l lVar, boolean z7) {
        if (this.f21271v) {
            return clone().W(lVar, z7);
        }
        t tVar = new t(lVar, z7);
        X(Bitmap.class, lVar, z7);
        X(Drawable.class, tVar, z7);
        X(BitmapDrawable.class, tVar.c(), z7);
        X(C1848c.class, new C1851f(lVar), z7);
        return Q();
    }

    public AbstractC2342a X(Class cls, l lVar, boolean z7) {
        if (this.f21271v) {
            return clone().X(cls, lVar, z7);
        }
        AbstractC2628k.d(cls);
        AbstractC2628k.d(lVar);
        this.f21267r.put(cls, lVar);
        int i8 = this.f21250a;
        this.f21263n = true;
        this.f21250a = 67584 | i8;
        this.f21274y = false;
        if (z7) {
            this.f21250a = i8 | 198656;
            this.f21262m = true;
        }
        return Q();
    }

    public AbstractC2342a Y(boolean z7) {
        if (this.f21271v) {
            return clone().Y(z7);
        }
        this.f21275z = z7;
        this.f21250a |= 1048576;
        return Q();
    }

    public AbstractC2342a b(AbstractC2342a abstractC2342a) {
        if (this.f21271v) {
            return clone().b(abstractC2342a);
        }
        if (I(abstractC2342a.f21250a, 2)) {
            this.f21251b = abstractC2342a.f21251b;
        }
        if (I(abstractC2342a.f21250a, 262144)) {
            this.f21272w = abstractC2342a.f21272w;
        }
        if (I(abstractC2342a.f21250a, 1048576)) {
            this.f21275z = abstractC2342a.f21275z;
        }
        if (I(abstractC2342a.f21250a, 4)) {
            this.f21252c = abstractC2342a.f21252c;
        }
        if (I(abstractC2342a.f21250a, 8)) {
            this.f21253d = abstractC2342a.f21253d;
        }
        if (I(abstractC2342a.f21250a, 16)) {
            this.f21254e = abstractC2342a.f21254e;
            this.f21255f = 0;
            this.f21250a &= -33;
        }
        if (I(abstractC2342a.f21250a, 32)) {
            this.f21255f = abstractC2342a.f21255f;
            this.f21254e = null;
            this.f21250a &= -17;
        }
        if (I(abstractC2342a.f21250a, 64)) {
            this.f21256g = abstractC2342a.f21256g;
            this.f21257h = 0;
            this.f21250a &= -129;
        }
        if (I(abstractC2342a.f21250a, 128)) {
            this.f21257h = abstractC2342a.f21257h;
            this.f21256g = null;
            this.f21250a &= -65;
        }
        if (I(abstractC2342a.f21250a, 256)) {
            this.f21258i = abstractC2342a.f21258i;
        }
        if (I(abstractC2342a.f21250a, 512)) {
            this.f21260k = abstractC2342a.f21260k;
            this.f21259j = abstractC2342a.f21259j;
        }
        if (I(abstractC2342a.f21250a, 1024)) {
            this.f21261l = abstractC2342a.f21261l;
        }
        if (I(abstractC2342a.f21250a, 4096)) {
            this.f21268s = abstractC2342a.f21268s;
        }
        if (I(abstractC2342a.f21250a, 8192)) {
            this.f21264o = abstractC2342a.f21264o;
            this.f21265p = 0;
            this.f21250a &= -16385;
        }
        if (I(abstractC2342a.f21250a, 16384)) {
            this.f21265p = abstractC2342a.f21265p;
            this.f21264o = null;
            this.f21250a &= -8193;
        }
        if (I(abstractC2342a.f21250a, 32768)) {
            this.f21270u = abstractC2342a.f21270u;
        }
        if (I(abstractC2342a.f21250a, 65536)) {
            this.f21263n = abstractC2342a.f21263n;
        }
        if (I(abstractC2342a.f21250a, 131072)) {
            this.f21262m = abstractC2342a.f21262m;
        }
        if (I(abstractC2342a.f21250a, 2048)) {
            this.f21267r.putAll(abstractC2342a.f21267r);
            this.f21274y = abstractC2342a.f21274y;
        }
        if (I(abstractC2342a.f21250a, 524288)) {
            this.f21273x = abstractC2342a.f21273x;
        }
        if (!this.f21263n) {
            this.f21267r.clear();
            int i8 = this.f21250a;
            this.f21262m = false;
            this.f21250a = i8 & (-133121);
            this.f21274y = true;
        }
        this.f21250a |= abstractC2342a.f21250a;
        this.f21266q.d(abstractC2342a.f21266q);
        return Q();
    }

    public AbstractC2342a c() {
        if (this.f21269t && !this.f21271v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f21271v = true;
        return L();
    }

    @Override // 
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC2342a clone() {
        try {
            AbstractC2342a abstractC2342a = (AbstractC2342a) super.clone();
            U0.h hVar = new U0.h();
            abstractC2342a.f21266q = hVar;
            hVar.d(this.f21266q);
            C2619b c2619b = new C2619b();
            abstractC2342a.f21267r = c2619b;
            c2619b.putAll(this.f21267r);
            abstractC2342a.f21269t = false;
            abstractC2342a.f21271v = false;
            return abstractC2342a;
        } catch (CloneNotSupportedException e8) {
            throw new RuntimeException(e8);
        }
    }

    public AbstractC2342a e(Class cls) {
        if (this.f21271v) {
            return clone().e(cls);
        }
        this.f21268s = (Class) AbstractC2628k.d(cls);
        this.f21250a |= 4096;
        return Q();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC2342a) {
            return D((AbstractC2342a) obj);
        }
        return false;
    }

    public AbstractC2342a g(j jVar) {
        if (this.f21271v) {
            return clone().g(jVar);
        }
        this.f21252c = (j) AbstractC2628k.d(jVar);
        this.f21250a |= 4;
        return Q();
    }

    public AbstractC2342a h(U0.b bVar) {
        AbstractC2628k.d(bVar);
        return R(r.f16801f, bVar).R(AbstractC1854i.f18381a, bVar);
    }

    public int hashCode() {
        return AbstractC2629l.o(this.f21270u, AbstractC2629l.o(this.f21261l, AbstractC2629l.o(this.f21268s, AbstractC2629l.o(this.f21267r, AbstractC2629l.o(this.f21266q, AbstractC2629l.o(this.f21253d, AbstractC2629l.o(this.f21252c, AbstractC2629l.p(this.f21273x, AbstractC2629l.p(this.f21272w, AbstractC2629l.p(this.f21263n, AbstractC2629l.p(this.f21262m, AbstractC2629l.n(this.f21260k, AbstractC2629l.n(this.f21259j, AbstractC2629l.p(this.f21258i, AbstractC2629l.o(this.f21264o, AbstractC2629l.n(this.f21265p, AbstractC2629l.o(this.f21256g, AbstractC2629l.n(this.f21257h, AbstractC2629l.o(this.f21254e, AbstractC2629l.n(this.f21255f, AbstractC2629l.l(this.f21251b)))))))))))))))))))));
    }

    public final j i() {
        return this.f21252c;
    }

    public final int j() {
        return this.f21255f;
    }

    public final Drawable k() {
        return this.f21254e;
    }

    public final Drawable l() {
        return this.f21264o;
    }

    public final int m() {
        return this.f21265p;
    }

    public final boolean o() {
        return this.f21273x;
    }

    public final U0.h p() {
        return this.f21266q;
    }

    public final int q() {
        return this.f21259j;
    }

    public final int r() {
        return this.f21260k;
    }

    public final Drawable s() {
        return this.f21256g;
    }

    public final int t() {
        return this.f21257h;
    }

    public final com.bumptech.glide.g u() {
        return this.f21253d;
    }

    public final Class v() {
        return this.f21268s;
    }

    public final U0.f w() {
        return this.f21261l;
    }

    public final float x() {
        return this.f21251b;
    }

    public final Resources.Theme y() {
        return this.f21270u;
    }

    public final Map z() {
        return this.f21267r;
    }

    public final AbstractC2342a P() {
        return this;
    }
}
