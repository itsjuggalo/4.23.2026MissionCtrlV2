package I0;

import I0.AbstractC0571l;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: I0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0575p extends AbstractC0571l {

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public int f2845P;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public ArrayList f2843I = new ArrayList();

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f2844O = true;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f2846Q = false;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public int f2847R = 0;

    /* JADX INFO: renamed from: I0.p$a */
    public class a extends AbstractC0572m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0571l f2848a;

        public a(AbstractC0571l abstractC0571l) {
            this.f2848a = abstractC0571l;
        }

        @Override // I0.AbstractC0571l.f
        public void e(AbstractC0571l abstractC0571l) {
            this.f2848a.T();
            abstractC0571l.P(this);
        }
    }

    /* JADX INFO: renamed from: I0.p$b */
    public static class b extends AbstractC0572m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C0575p f2850a;

        public b(C0575p c0575p) {
            this.f2850a = c0575p;
        }

        @Override // I0.AbstractC0572m, I0.AbstractC0571l.f
        public void c(AbstractC0571l abstractC0571l) {
            C0575p c0575p = this.f2850a;
            if (c0575p.f2846Q) {
                return;
            }
            c0575p.a0();
            this.f2850a.f2846Q = true;
        }

        @Override // I0.AbstractC0571l.f
        public void e(AbstractC0571l abstractC0571l) {
            C0575p c0575p = this.f2850a;
            int i7 = c0575p.f2845P - 1;
            c0575p.f2845P = i7;
            if (i7 == 0) {
                c0575p.f2846Q = false;
                c0575p.p();
            }
            abstractC0571l.P(this);
        }
    }

    @Override // I0.AbstractC0571l
    public void N(View view) {
        super.N(view);
        int size = this.f2843I.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0571l) this.f2843I.get(i7)).N(view);
        }
    }

    @Override // I0.AbstractC0571l
    public void R(View view) {
        super.R(view);
        int size = this.f2843I.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0571l) this.f2843I.get(i7)).R(view);
        }
    }

    @Override // I0.AbstractC0571l
    public void T() {
        if (this.f2843I.isEmpty()) {
            a0();
            p();
            return;
        }
        o0();
        if (this.f2844O) {
            Iterator it = this.f2843I.iterator();
            while (it.hasNext()) {
                ((AbstractC0571l) it.next()).T();
            }
            return;
        }
        for (int i7 = 1; i7 < this.f2843I.size(); i7++) {
            ((AbstractC0571l) this.f2843I.get(i7 - 1)).a(new a((AbstractC0571l) this.f2843I.get(i7)));
        }
        AbstractC0571l abstractC0571l = (AbstractC0571l) this.f2843I.get(0);
        if (abstractC0571l != null) {
            abstractC0571l.T();
        }
    }

    @Override // I0.AbstractC0571l
    public void V(AbstractC0571l.e eVar) {
        super.V(eVar);
        this.f2847R |= 8;
        int size = this.f2843I.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0571l) this.f2843I.get(i7)).V(eVar);
        }
    }

    @Override // I0.AbstractC0571l
    public void X(AbstractC0566g abstractC0566g) {
        super.X(abstractC0566g);
        this.f2847R |= 4;
        if (this.f2843I != null) {
            for (int i7 = 0; i7 < this.f2843I.size(); i7++) {
                ((AbstractC0571l) this.f2843I.get(i7)).X(abstractC0566g);
            }
        }
    }

    @Override // I0.AbstractC0571l
    public void Y(AbstractC0574o abstractC0574o) {
        super.Y(abstractC0574o);
        this.f2847R |= 2;
        int size = this.f2843I.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0571l) this.f2843I.get(i7)).Y(abstractC0574o);
        }
    }

    @Override // I0.AbstractC0571l
    public String b0(String str) {
        String strB0 = super.b0(str);
        for (int i7 = 0; i7 < this.f2843I.size(); i7++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strB0);
            sb.append("\n");
            sb.append(((AbstractC0571l) this.f2843I.get(i7)).b0(str + "  "));
            strB0 = sb.toString();
        }
        return strB0;
    }

    @Override // I0.AbstractC0571l
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public C0575p a(AbstractC0571l.f fVar) {
        return (C0575p) super.a(fVar);
    }

    @Override // I0.AbstractC0571l
    public void cancel() {
        super.cancel();
        int size = this.f2843I.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0571l) this.f2843I.get(i7)).cancel();
        }
    }

    @Override // I0.AbstractC0571l
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public C0575p b(View view) {
        for (int i7 = 0; i7 < this.f2843I.size(); i7++) {
            ((AbstractC0571l) this.f2843I.get(i7)).b(view);
        }
        return (C0575p) super.b(view);
    }

    public C0575p e0(AbstractC0571l abstractC0571l) {
        f0(abstractC0571l);
        long j7 = this.f2804c;
        if (j7 >= 0) {
            abstractC0571l.U(j7);
        }
        if ((this.f2847R & 1) != 0) {
            abstractC0571l.W(s());
        }
        if ((this.f2847R & 2) != 0) {
            w();
            abstractC0571l.Y(null);
        }
        if ((this.f2847R & 4) != 0) {
            abstractC0571l.X(v());
        }
        if ((this.f2847R & 8) != 0) {
            abstractC0571l.V(r());
        }
        return this;
    }

    @Override // I0.AbstractC0571l
    public void f(s sVar) {
        if (G(sVar.f2855b)) {
            for (AbstractC0571l abstractC0571l : this.f2843I) {
                if (abstractC0571l.G(sVar.f2855b)) {
                    abstractC0571l.f(sVar);
                    sVar.f2856c.add(abstractC0571l);
                }
            }
        }
    }

    public final void f0(AbstractC0571l abstractC0571l) {
        this.f2843I.add(abstractC0571l);
        abstractC0571l.f2819r = this;
    }

    public AbstractC0571l g0(int i7) {
        if (i7 < 0 || i7 >= this.f2843I.size()) {
            return null;
        }
        return (AbstractC0571l) this.f2843I.get(i7);
    }

    public int h0() {
        return this.f2843I.size();
    }

    @Override // I0.AbstractC0571l
    public void i(s sVar) {
        super.i(sVar);
        int size = this.f2843I.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((AbstractC0571l) this.f2843I.get(i7)).i(sVar);
        }
    }

    @Override // I0.AbstractC0571l
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public C0575p P(AbstractC0571l.f fVar) {
        return (C0575p) super.P(fVar);
    }

    @Override // I0.AbstractC0571l
    public void j(s sVar) {
        if (G(sVar.f2855b)) {
            for (AbstractC0571l abstractC0571l : this.f2843I) {
                if (abstractC0571l.G(sVar.f2855b)) {
                    abstractC0571l.j(sVar);
                    sVar.f2856c.add(abstractC0571l);
                }
            }
        }
    }

    @Override // I0.AbstractC0571l
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public C0575p Q(View view) {
        for (int i7 = 0; i7 < this.f2843I.size(); i7++) {
            ((AbstractC0571l) this.f2843I.get(i7)).Q(view);
        }
        return (C0575p) super.Q(view);
    }

    @Override // I0.AbstractC0571l
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public C0575p U(long j7) {
        ArrayList arrayList;
        super.U(j7);
        if (this.f2804c >= 0 && (arrayList = this.f2843I) != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((AbstractC0571l) this.f2843I.get(i7)).U(j7);
            }
        }
        return this;
    }

    @Override // I0.AbstractC0571l
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C0575p W(TimeInterpolator timeInterpolator) {
        this.f2847R |= 1;
        ArrayList arrayList = this.f2843I;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((AbstractC0571l) this.f2843I.get(i7)).W(timeInterpolator);
            }
        }
        return (C0575p) super.W(timeInterpolator);
    }

    @Override // I0.AbstractC0571l
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public AbstractC0571l clone() {
        C0575p c0575p = (C0575p) super.clone();
        c0575p.f2843I = new ArrayList();
        int size = this.f2843I.size();
        for (int i7 = 0; i7 < size; i7++) {
            c0575p.f0(((AbstractC0571l) this.f2843I.get(i7)).clone());
        }
        return c0575p;
    }

    public C0575p m0(int i7) {
        if (i7 == 0) {
            this.f2844O = true;
        } else {
            if (i7 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i7);
            }
            this.f2844O = false;
        }
        return this;
    }

    @Override // I0.AbstractC0571l
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public C0575p Z(long j7) {
        return (C0575p) super.Z(j7);
    }

    @Override // I0.AbstractC0571l
    public void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        long jY = y();
        int size = this.f2843I.size();
        for (int i7 = 0; i7 < size; i7++) {
            AbstractC0571l abstractC0571l = (AbstractC0571l) this.f2843I.get(i7);
            if (jY > 0 && (this.f2844O || i7 == 0)) {
                long jY2 = abstractC0571l.y();
                if (jY2 > 0) {
                    abstractC0571l.Z(jY2 + jY);
                } else {
                    abstractC0571l.Z(jY);
                }
            }
            abstractC0571l.o(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    public final void o0() {
        b bVar = new b(this);
        Iterator it = this.f2843I.iterator();
        while (it.hasNext()) {
            ((AbstractC0571l) it.next()).a(bVar);
        }
        this.f2845P = this.f2843I.size();
    }
}
