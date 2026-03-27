package C0;

import C0.AbstractC0453l;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: C0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0457p extends AbstractC0453l {

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public int f567Q;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public ArrayList f565I = new ArrayList();

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f566P = true;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f568R = false;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public int f569S = 0;

    /* JADX INFO: renamed from: C0.p$a */
    public class a extends AbstractC0454m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0453l f570a;

        public a(AbstractC0453l abstractC0453l) {
            this.f570a = abstractC0453l;
        }

        @Override // C0.AbstractC0453l.f
        public void d(AbstractC0453l abstractC0453l) {
            this.f570a.W();
            abstractC0453l.S(this);
        }
    }

    /* JADX INFO: renamed from: C0.p$b */
    public static class b extends AbstractC0454m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0457p f572a;

        public b(C0457p c0457p) {
            this.f572a = c0457p;
        }

        @Override // C0.AbstractC0453l.f
        public void d(AbstractC0453l abstractC0453l) {
            C0457p c0457p = this.f572a;
            int i8 = c0457p.f567Q - 1;
            c0457p.f567Q = i8;
            if (i8 == 0) {
                c0457p.f568R = false;
                c0457p.s();
            }
            abstractC0453l.S(this);
        }

        @Override // C0.AbstractC0454m, C0.AbstractC0453l.f
        public void e(AbstractC0453l abstractC0453l) {
            C0457p c0457p = this.f572a;
            if (c0457p.f568R) {
                return;
            }
            c0457p.d0();
            this.f572a.f568R = true;
        }
    }

    @Override // C0.AbstractC0453l
    public void Q(View view) {
        super.Q(view);
        int size = this.f565I.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((AbstractC0453l) this.f565I.get(i8)).Q(view);
        }
    }

    @Override // C0.AbstractC0453l
    public void U(View view) {
        super.U(view);
        int size = this.f565I.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((AbstractC0453l) this.f565I.get(i8)).U(view);
        }
    }

    @Override // C0.AbstractC0453l
    public void W() {
        if (this.f565I.isEmpty()) {
            d0();
            s();
            return;
        }
        r0();
        if (this.f566P) {
            Iterator it = this.f565I.iterator();
            while (it.hasNext()) {
                ((AbstractC0453l) it.next()).W();
            }
            return;
        }
        for (int i8 = 1; i8 < this.f565I.size(); i8++) {
            ((AbstractC0453l) this.f565I.get(i8 - 1)).b(new a((AbstractC0453l) this.f565I.get(i8)));
        }
        AbstractC0453l abstractC0453l = (AbstractC0453l) this.f565I.get(0);
        if (abstractC0453l != null) {
            abstractC0453l.W();
        }
    }

    @Override // C0.AbstractC0453l
    public void Y(AbstractC0453l.e eVar) {
        super.Y(eVar);
        this.f569S |= 8;
        int size = this.f565I.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((AbstractC0453l) this.f565I.get(i8)).Y(eVar);
        }
    }

    @Override // C0.AbstractC0453l
    public void a0(AbstractC0448g abstractC0448g) {
        super.a0(abstractC0448g);
        this.f569S |= 4;
        if (this.f565I != null) {
            for (int i8 = 0; i8 < this.f565I.size(); i8++) {
                ((AbstractC0453l) this.f565I.get(i8)).a0(abstractC0448g);
            }
        }
    }

    @Override // C0.AbstractC0453l
    public void b0(AbstractC0456o abstractC0456o) {
        super.b0(abstractC0456o);
        this.f569S |= 2;
        int size = this.f565I.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((AbstractC0453l) this.f565I.get(i8)).b0(abstractC0456o);
        }
    }

    @Override // C0.AbstractC0453l
    public String e0(String str) {
        String strE0 = super.e0(str);
        for (int i8 = 0; i8 < this.f565I.size(); i8++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strE0);
            sb.append("\n");
            sb.append(((AbstractC0453l) this.f565I.get(i8)).e0(str + "  "));
            strE0 = sb.toString();
        }
        return strE0;
    }

    @Override // C0.AbstractC0453l
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public C0457p b(AbstractC0453l.f fVar) {
        return (C0457p) super.b(fVar);
    }

    @Override // C0.AbstractC0453l
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public C0457p c(View view) {
        for (int i8 = 0; i8 < this.f565I.size(); i8++) {
            ((AbstractC0453l) this.f565I.get(i8)).c(view);
        }
        return (C0457p) super.c(view);
    }

    @Override // C0.AbstractC0453l
    public void h() {
        super.h();
        int size = this.f565I.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((AbstractC0453l) this.f565I.get(i8)).h();
        }
    }

    public C0457p h0(AbstractC0453l abstractC0453l) {
        i0(abstractC0453l);
        long j8 = this.f526c;
        if (j8 >= 0) {
            abstractC0453l.X(j8);
        }
        if ((this.f569S & 1) != 0) {
            abstractC0453l.Z(v());
        }
        if ((this.f569S & 2) != 0) {
            z();
            abstractC0453l.b0(null);
        }
        if ((this.f569S & 4) != 0) {
            abstractC0453l.a0(y());
        }
        if ((this.f569S & 8) != 0) {
            abstractC0453l.Y(u());
        }
        return this;
    }

    @Override // C0.AbstractC0453l
    public void i(s sVar) {
        if (J(sVar.f577b)) {
            for (AbstractC0453l abstractC0453l : this.f565I) {
                if (abstractC0453l.J(sVar.f577b)) {
                    abstractC0453l.i(sVar);
                    sVar.f578c.add(abstractC0453l);
                }
            }
        }
    }

    public final void i0(AbstractC0453l abstractC0453l) {
        this.f565I.add(abstractC0453l);
        abstractC0453l.f541r = this;
    }

    public AbstractC0453l j0(int i8) {
        if (i8 < 0 || i8 >= this.f565I.size()) {
            return null;
        }
        return (AbstractC0453l) this.f565I.get(i8);
    }

    @Override // C0.AbstractC0453l
    public void k(s sVar) {
        super.k(sVar);
        int size = this.f565I.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((AbstractC0453l) this.f565I.get(i8)).k(sVar);
        }
    }

    public int k0() {
        return this.f565I.size();
    }

    @Override // C0.AbstractC0453l
    public void l(s sVar) {
        if (J(sVar.f577b)) {
            for (AbstractC0453l abstractC0453l : this.f565I) {
                if (abstractC0453l.J(sVar.f577b)) {
                    abstractC0453l.l(sVar);
                    sVar.f578c.add(abstractC0453l);
                }
            }
        }
    }

    @Override // C0.AbstractC0453l
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C0457p S(AbstractC0453l.f fVar) {
        return (C0457p) super.S(fVar);
    }

    @Override // C0.AbstractC0453l
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public C0457p T(View view) {
        for (int i8 = 0; i8 < this.f565I.size(); i8++) {
            ((AbstractC0453l) this.f565I.get(i8)).T(view);
        }
        return (C0457p) super.T(view);
    }

    @Override // C0.AbstractC0453l
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public C0457p X(long j8) {
        ArrayList arrayList;
        super.X(j8);
        if (this.f526c >= 0 && (arrayList = this.f565I) != null) {
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                ((AbstractC0453l) this.f565I.get(i8)).X(j8);
            }
        }
        return this;
    }

    @Override // C0.AbstractC0453l
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public C0457p Z(TimeInterpolator timeInterpolator) {
        this.f569S |= 1;
        ArrayList arrayList = this.f565I;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                ((AbstractC0453l) this.f565I.get(i8)).Z(timeInterpolator);
            }
        }
        return (C0457p) super.Z(timeInterpolator);
    }

    @Override // C0.AbstractC0453l
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public AbstractC0453l clone() {
        C0457p c0457p = (C0457p) super.clone();
        c0457p.f565I = new ArrayList();
        int size = this.f565I.size();
        for (int i8 = 0; i8 < size; i8++) {
            c0457p.i0(((AbstractC0453l) this.f565I.get(i8)).clone());
        }
        return c0457p;
    }

    public C0457p p0(int i8) {
        if (i8 == 0) {
            this.f566P = true;
        } else {
            if (i8 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i8);
            }
            this.f566P = false;
        }
        return this;
    }

    @Override // C0.AbstractC0453l
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public C0457p c0(long j8) {
        return (C0457p) super.c0(j8);
    }

    @Override // C0.AbstractC0453l
    public void r(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        long jB = B();
        int size = this.f565I.size();
        for (int i8 = 0; i8 < size; i8++) {
            AbstractC0453l abstractC0453l = (AbstractC0453l) this.f565I.get(i8);
            if (jB > 0 && (this.f566P || i8 == 0)) {
                long jB2 = abstractC0453l.B();
                if (jB2 > 0) {
                    abstractC0453l.c0(jB2 + jB);
                } else {
                    abstractC0453l.c0(jB);
                }
            }
            abstractC0453l.r(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    public final void r0() {
        b bVar = new b(this);
        Iterator it = this.f565I.iterator();
        while (it.hasNext()) {
            ((AbstractC0453l) it.next()).b(bVar);
        }
        this.f567Q = this.f565I.size();
    }
}
