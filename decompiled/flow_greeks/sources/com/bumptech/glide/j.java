package com.bumptech.glide;

import android.content.Context;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j extends y3.a implements Cloneable {
    public static final y3.f V = (y3.f) ((y3.f) ((y3.f) new y3.f().f(i3.j.f11667c)).N(g.LOW)).T(true);
    public final Context A;
    public final k B;
    public final Class C;
    public final b D;
    public final d E;
    public l F;
    public Object G;
    public List H;
    public j I;
    public j Q;
    public Float R;
    public boolean S = true;
    public boolean T;
    public boolean U;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f5241b;

        static {
            int[] iArr = new int[g.values().length];
            f5241b = iArr;
            try {
                iArr[g.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5241b[g.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5241b[g.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5241b[g.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f5240a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5240a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5240a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5240a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5240a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5240a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f5240a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f5240a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public j(b bVar, k kVar, Class cls, Context context) {
        this.D = bVar;
        this.B = kVar;
        this.C = cls;
        this.A = context;
        this.F = kVar.s(cls);
        this.E = bVar.i();
        f0(kVar.q());
        a(kVar.r());
    }

    public j Y(y3.e eVar) {
        if (B()) {
            return clone().Y(eVar);
        }
        if (eVar != null) {
            if (this.H == null) {
                this.H = new ArrayList();
            }
            this.H.add(eVar);
        }
        return (j) P();
    }

    @Override // y3.a
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public j a(y3.a aVar) {
        c4.k.e(aVar);
        return (j) super.a(aVar);
    }

    public final y3.c a0(z3.d dVar, y3.e eVar, y3.a aVar, Executor executor) {
        return b0(new Object(), dVar, eVar, null, this.F, aVar.s(), aVar.p(), aVar.o(), aVar, executor);
    }

    public final y3.c b0(Object obj, z3.d dVar, y3.e eVar, y3.d dVar2, l lVar, g gVar, int i10, int i11, y3.a aVar, Executor executor) {
        y3.b bVar;
        y3.d dVar3;
        Object obj2;
        z3.d dVar4;
        y3.e eVar2;
        l lVar2;
        g gVar2;
        int i12;
        int i13;
        y3.a aVar2;
        Executor executor2;
        j jVar;
        if (this.Q != null) {
            bVar = new y3.b(obj, dVar2);
            dVar3 = bVar;
            jVar = this;
            obj2 = obj;
            dVar4 = dVar;
            eVar2 = eVar;
            lVar2 = lVar;
            gVar2 = gVar;
            i12 = i10;
            i13 = i11;
            aVar2 = aVar;
            executor2 = executor;
        } else {
            bVar = null;
            dVar3 = dVar2;
            obj2 = obj;
            dVar4 = dVar;
            eVar2 = eVar;
            lVar2 = lVar;
            gVar2 = gVar;
            i12 = i10;
            i13 = i11;
            aVar2 = aVar;
            executor2 = executor;
            jVar = this;
        }
        y3.c cVarC0 = jVar.c0(obj2, dVar4, eVar2, dVar3, lVar2, gVar2, i12, i13, aVar2, executor2);
        if (bVar == null) {
            return cVarC0;
        }
        int iP = this.Q.p();
        int iO = this.Q.o();
        if (c4.l.t(i10, i11) && !this.Q.J()) {
            iP = aVar.p();
            iO = aVar.o();
        }
        j jVar2 = this.Q;
        y3.b bVar2 = bVar;
        bVar2.o(cVarC0, jVar2.b0(obj, dVar, eVar, bVar2, jVar2.F, jVar2.s(), iP, iO, this.Q, executor));
        return bVar2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final y3.c c0(Object obj, z3.d dVar, y3.e eVar, y3.d dVar2, l lVar, g gVar, int i10, int i11, y3.a aVar, Executor executor) {
        j jVar = this.I;
        if (jVar == null) {
            if (this.R == null) {
                return m0(obj, dVar, eVar, aVar, dVar2, lVar, gVar, i10, i11, executor);
            }
            y3.i iVar = new y3.i(obj, dVar2);
            iVar.n(m0(obj, dVar, eVar, aVar, iVar, lVar, gVar, i10, i11, executor), m0(obj, dVar, eVar, aVar.clone().S(this.R.floatValue()), iVar, lVar, e0(gVar), i10, i11, executor));
            return iVar;
        }
        if (this.U) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        l lVar2 = jVar.S ? lVar : jVar.F;
        g gVarS = jVar.E() ? this.I.s() : e0(gVar);
        int iP = this.I.p();
        int iO = this.I.o();
        if (c4.l.t(i10, i11) && !this.I.J()) {
            iP = aVar.p();
            iO = aVar.o();
        }
        y3.i iVar2 = new y3.i(obj, dVar2);
        y3.c cVarM0 = m0(obj, dVar, eVar, aVar, iVar2, lVar, gVar, i10, i11, executor);
        this.U = true;
        j jVar2 = this.I;
        y3.c cVarB0 = jVar2.b0(obj, dVar, eVar, iVar2, lVar2, gVarS, iP, iO, jVar2, executor);
        this.U = false;
        iVar2.n(cVarM0, cVarB0);
        return iVar2;
    }

    @Override // y3.a
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public j clone() {
        j jVar = (j) super.clone();
        jVar.F = jVar.F.clone();
        if (jVar.H != null) {
            jVar.H = new ArrayList(jVar.H);
        }
        j jVar2 = jVar.I;
        if (jVar2 != null) {
            jVar.I = jVar2.clone();
        }
        j jVar3 = jVar.Q;
        if (jVar3 != null) {
            jVar.Q = jVar3.clone();
        }
        return jVar;
    }

    public final g e0(g gVar) {
        int i10 = a.f5241b[gVar.ordinal()];
        if (i10 == 1) {
            return g.NORMAL;
        }
        if (i10 == 2) {
            return g.HIGH;
        }
        if (i10 == 3 || i10 == 4) {
            return g.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + s());
    }

    @Override // y3.a
    public boolean equals(Object obj) {
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (super.equals(jVar) && Objects.equals(this.C, jVar.C) && this.F.equals(jVar.F) && Objects.equals(this.G, jVar.G) && Objects.equals(this.H, jVar.H) && Objects.equals(this.I, jVar.I) && Objects.equals(this.Q, jVar.Q) && Objects.equals(this.R, jVar.R) && this.S == jVar.S && this.T == jVar.T) {
                return true;
            }
        }
        return false;
    }

    public final void f0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Y((y3.e) it.next());
        }
    }

    public z3.d g0(z3.d dVar) {
        return h0(dVar, null, c4.e.b());
    }

    public z3.d h0(z3.d dVar, y3.e eVar, Executor executor) {
        return i0(dVar, eVar, this, executor);
    }

    @Override // y3.a
    public int hashCode() {
        return c4.l.p(this.T, c4.l.p(this.S, c4.l.o(this.R, c4.l.o(this.Q, c4.l.o(this.I, c4.l.o(this.H, c4.l.o(this.G, c4.l.o(this.F, c4.l.o(this.C, super.hashCode())))))))));
    }

    public final z3.d i0(z3.d dVar, y3.e eVar, y3.a aVar, Executor executor) {
        c4.k.e(dVar);
        if (!this.T) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        y3.c cVarA0 = a0(dVar, eVar, aVar, executor);
        y3.c cVarJ = dVar.j();
        if (cVarA0.d(cVarJ) && !j0(aVar, cVarJ)) {
            if (!((y3.c) c4.k.e(cVarJ)).isRunning()) {
                cVarJ.h();
            }
            return dVar;
        }
        this.B.o(dVar);
        dVar.d(cVarA0);
        this.B.z(dVar, cVarA0);
        return dVar;
    }

    public final boolean j0(y3.a aVar, y3.c cVar) {
        return !aVar.D() && cVar.i();
    }

    public j k0(Object obj) {
        return l0(obj);
    }

    public final j l0(Object obj) {
        if (B()) {
            return clone().l0(obj);
        }
        this.G = obj;
        this.T = true;
        return (j) P();
    }

    public final y3.c m0(Object obj, z3.d dVar, y3.e eVar, y3.a aVar, y3.d dVar2, l lVar, g gVar, int i10, int i11, Executor executor) {
        Context context = this.A;
        d dVar3 = this.E;
        return y3.h.y(context, dVar3, obj, this.G, this.C, aVar, i10, i11, gVar, dVar, eVar, this.H, dVar2, dVar3.e(), lVar.b(), executor);
    }
}
