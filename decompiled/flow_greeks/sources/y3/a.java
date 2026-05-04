package y3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c4.k;
import c4.l;
import i3.j;
import java.util.Map;
import p3.p;
import p3.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25183a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f25187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f25189g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25190h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f25195m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f25197o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f25198p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f25202t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Resources.Theme f25203u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f25204v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f25205w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f25206x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f25208z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f25184b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f25185c = j.f11669e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bumptech.glide.g f25186d = com.bumptech.glide.g.NORMAL;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f25191i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25192j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25193k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g3.f f25194l = b4.a.c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f25196n = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public g3.h f25199q = new g3.h();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map f25200r = new c4.b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Class f25201s = Object.class;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f25207y = true;

    public static boolean H(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public final boolean A() {
        return this.f25205w;
    }

    public final boolean B() {
        return this.f25204v;
    }

    public final boolean C(a aVar) {
        return Float.compare(aVar.f25184b, this.f25184b) == 0 && this.f25188f == aVar.f25188f && l.d(this.f25187e, aVar.f25187e) && this.f25190h == aVar.f25190h && l.d(this.f25189g, aVar.f25189g) && this.f25198p == aVar.f25198p && l.d(this.f25197o, aVar.f25197o) && this.f25191i == aVar.f25191i && this.f25192j == aVar.f25192j && this.f25193k == aVar.f25193k && this.f25195m == aVar.f25195m && this.f25196n == aVar.f25196n && this.f25205w == aVar.f25205w && this.f25206x == aVar.f25206x && this.f25185c.equals(aVar.f25185c) && this.f25186d == aVar.f25186d && this.f25199q.equals(aVar.f25199q) && this.f25200r.equals(aVar.f25200r) && this.f25201s.equals(aVar.f25201s) && l.d(this.f25194l, aVar.f25194l) && l.d(this.f25203u, aVar.f25203u);
    }

    public final boolean D() {
        return this.f25191i;
    }

    public final boolean E() {
        return G(8);
    }

    public boolean F() {
        return this.f25207y;
    }

    public final boolean G(int i10) {
        return H(this.f25183a, i10);
    }

    public final boolean I() {
        return this.f25195m;
    }

    public final boolean J() {
        return l.t(this.f25193k, this.f25192j);
    }

    public a K() {
        this.f25202t = true;
        return O();
    }

    public a L(int i10, int i11) {
        if (this.f25204v) {
            return clone().L(i10, i11);
        }
        this.f25193k = i10;
        this.f25192j = i11;
        this.f25183a |= 512;
        return P();
    }

    public a M(int i10) {
        if (this.f25204v) {
            return clone().M(i10);
        }
        this.f25190h = i10;
        int i11 = this.f25183a | 128;
        this.f25189g = null;
        this.f25183a = i11 & (-65);
        return P();
    }

    public a N(com.bumptech.glide.g gVar) {
        if (this.f25204v) {
            return clone().N(gVar);
        }
        this.f25186d = (com.bumptech.glide.g) k.e(gVar);
        this.f25183a |= 8;
        return P();
    }

    public final a P() {
        if (this.f25202t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return O();
    }

    public a Q(g3.g gVar, Object obj) {
        if (this.f25204v) {
            return clone().Q(gVar, obj);
        }
        k.e(gVar);
        k.e(obj);
        this.f25199q.e(gVar, obj);
        return P();
    }

    public a R(g3.f fVar) {
        if (this.f25204v) {
            return clone().R(fVar);
        }
        this.f25194l = (g3.f) k.e(fVar);
        this.f25183a |= 1024;
        return P();
    }

    public a S(float f10) {
        if (this.f25204v) {
            return clone().S(f10);
        }
        if (f10 < 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f25184b = f10;
        this.f25183a |= 2;
        return P();
    }

    public a T(boolean z10) {
        if (this.f25204v) {
            return clone().T(true);
        }
        this.f25191i = !z10;
        this.f25183a |= 256;
        return P();
    }

    public a U(g3.l lVar) {
        return V(lVar, true);
    }

    public a V(g3.l lVar, boolean z10) {
        if (this.f25204v) {
            return clone().V(lVar, z10);
        }
        r rVar = new r(lVar, z10);
        W(Bitmap.class, lVar, z10);
        W(Drawable.class, rVar, z10);
        W(BitmapDrawable.class, rVar.c(), z10);
        W(t3.c.class, new t3.f(lVar), z10);
        return P();
    }

    public a W(Class cls, g3.l lVar, boolean z10) {
        if (this.f25204v) {
            return clone().W(cls, lVar, z10);
        }
        k.e(cls);
        k.e(lVar);
        this.f25200r.put(cls, lVar);
        int i10 = this.f25183a;
        this.f25196n = true;
        this.f25183a = 67584 | i10;
        this.f25207y = false;
        if (z10) {
            this.f25183a = i10 | 198656;
            this.f25195m = true;
        }
        return P();
    }

    public a X(boolean z10) {
        if (this.f25204v) {
            return clone().X(z10);
        }
        this.f25208z = z10;
        this.f25183a |= 1048576;
        return P();
    }

    public a a(a aVar) {
        if (this.f25204v) {
            return clone().a(aVar);
        }
        if (H(aVar.f25183a, 2)) {
            this.f25184b = aVar.f25184b;
        }
        if (H(aVar.f25183a, 262144)) {
            this.f25205w = aVar.f25205w;
        }
        if (H(aVar.f25183a, 1048576)) {
            this.f25208z = aVar.f25208z;
        }
        if (H(aVar.f25183a, 4)) {
            this.f25185c = aVar.f25185c;
        }
        if (H(aVar.f25183a, 8)) {
            this.f25186d = aVar.f25186d;
        }
        if (H(aVar.f25183a, 16)) {
            this.f25187e = aVar.f25187e;
            this.f25188f = 0;
            this.f25183a &= -33;
        }
        if (H(aVar.f25183a, 32)) {
            this.f25188f = aVar.f25188f;
            this.f25187e = null;
            this.f25183a &= -17;
        }
        if (H(aVar.f25183a, 64)) {
            this.f25189g = aVar.f25189g;
            this.f25190h = 0;
            this.f25183a &= -129;
        }
        if (H(aVar.f25183a, 128)) {
            this.f25190h = aVar.f25190h;
            this.f25189g = null;
            this.f25183a &= -65;
        }
        if (H(aVar.f25183a, 256)) {
            this.f25191i = aVar.f25191i;
        }
        if (H(aVar.f25183a, 512)) {
            this.f25193k = aVar.f25193k;
            this.f25192j = aVar.f25192j;
        }
        if (H(aVar.f25183a, 1024)) {
            this.f25194l = aVar.f25194l;
        }
        if (H(aVar.f25183a, 4096)) {
            this.f25201s = aVar.f25201s;
        }
        if (H(aVar.f25183a, 8192)) {
            this.f25197o = aVar.f25197o;
            this.f25198p = 0;
            this.f25183a &= -16385;
        }
        if (H(aVar.f25183a, 16384)) {
            this.f25198p = aVar.f25198p;
            this.f25197o = null;
            this.f25183a &= -8193;
        }
        if (H(aVar.f25183a, 32768)) {
            this.f25203u = aVar.f25203u;
        }
        if (H(aVar.f25183a, 65536)) {
            this.f25196n = aVar.f25196n;
        }
        if (H(aVar.f25183a, 131072)) {
            this.f25195m = aVar.f25195m;
        }
        if (H(aVar.f25183a, 2048)) {
            this.f25200r.putAll(aVar.f25200r);
            this.f25207y = aVar.f25207y;
        }
        if (H(aVar.f25183a, 524288)) {
            this.f25206x = aVar.f25206x;
        }
        if (!this.f25196n) {
            this.f25200r.clear();
            int i10 = this.f25183a;
            this.f25195m = false;
            this.f25183a = i10 & (-133121);
            this.f25207y = true;
        }
        this.f25183a |= aVar.f25183a;
        this.f25199q.d(aVar.f25199q);
        return P();
    }

    public a b() {
        if (this.f25202t && !this.f25204v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f25204v = true;
        return K();
    }

    @Override // 
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            g3.h hVar = new g3.h();
            aVar.f25199q = hVar;
            hVar.d(this.f25199q);
            c4.b bVar = new c4.b();
            aVar.f25200r = bVar;
            bVar.putAll(this.f25200r);
            aVar.f25202t = false;
            aVar.f25204v = false;
            return aVar;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public a d(Class cls) {
        if (this.f25204v) {
            return clone().d(cls);
        }
        this.f25201s = (Class) k.e(cls);
        this.f25183a |= 4096;
        return P();
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return C((a) obj);
        }
        return false;
    }

    public a f(j jVar) {
        if (this.f25204v) {
            return clone().f(jVar);
        }
        this.f25185c = (j) k.e(jVar);
        this.f25183a |= 4;
        return P();
    }

    public a g(g3.b bVar) {
        k.e(bVar);
        return Q(p.f18262f, bVar).Q(t3.i.f20724a, bVar);
    }

    public final j h() {
        return this.f25185c;
    }

    public int hashCode() {
        return l.o(this.f25203u, l.o(this.f25194l, l.o(this.f25201s, l.o(this.f25200r, l.o(this.f25199q, l.o(this.f25186d, l.o(this.f25185c, l.p(this.f25206x, l.p(this.f25205w, l.p(this.f25196n, l.p(this.f25195m, l.n(this.f25193k, l.n(this.f25192j, l.p(this.f25191i, l.o(this.f25197o, l.n(this.f25198p, l.o(this.f25189g, l.n(this.f25190h, l.o(this.f25187e, l.n(this.f25188f, l.l(this.f25184b)))))))))))))))))))));
    }

    public final int i() {
        return this.f25188f;
    }

    public final Drawable j() {
        return this.f25187e;
    }

    public final Drawable k() {
        return this.f25197o;
    }

    public final int l() {
        return this.f25198p;
    }

    public final boolean m() {
        return this.f25206x;
    }

    public final g3.h n() {
        return this.f25199q;
    }

    public final int o() {
        return this.f25192j;
    }

    public final int p() {
        return this.f25193k;
    }

    public final Drawable q() {
        return this.f25189g;
    }

    public final int r() {
        return this.f25190h;
    }

    public final com.bumptech.glide.g s() {
        return this.f25186d;
    }

    public final Class t() {
        return this.f25201s;
    }

    public final g3.f v() {
        return this.f25194l;
    }

    public final float w() {
        return this.f25184b;
    }

    public final Resources.Theme x() {
        return this.f25203u;
    }

    public final Map y() {
        return this.f25200r;
    }

    public final boolean z() {
        return this.f25208z;
    }

    public final a O() {
        return this;
    }
}
