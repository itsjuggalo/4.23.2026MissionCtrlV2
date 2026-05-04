package n2;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import n2.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p extends l {
    public int R;
    public ArrayList I = new ArrayList();
    public boolean Q = true;
    public boolean S = false;
    public int T = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f16589a;

        public a(l lVar) {
            this.f16589a = lVar;
        }

        @Override // n2.l.f
        public void d(l lVar) {
            this.f16589a.V();
            lVar.R(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p f16591a;

        public b(p pVar) {
            this.f16591a = pVar;
        }

        @Override // n2.m, n2.l.f
        public void b(l lVar) {
            p pVar = this.f16591a;
            if (pVar.S) {
                return;
            }
            pVar.c0();
            this.f16591a.S = true;
        }

        @Override // n2.l.f
        public void d(l lVar) {
            p pVar = this.f16591a;
            int i10 = pVar.R - 1;
            pVar.R = i10;
            if (i10 == 0) {
                pVar.S = false;
                pVar.q();
            }
            lVar.R(this);
        }
    }

    @Override // n2.l
    public void P(View view) {
        super.P(view);
        int size = this.I.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((l) this.I.get(i10)).P(view);
        }
    }

    @Override // n2.l
    public void T(View view) {
        super.T(view);
        int size = this.I.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((l) this.I.get(i10)).T(view);
        }
    }

    @Override // n2.l
    public void V() {
        if (this.I.isEmpty()) {
            c0();
            q();
            return;
        }
        q0();
        if (this.Q) {
            Iterator it = this.I.iterator();
            while (it.hasNext()) {
                ((l) it.next()).V();
            }
            return;
        }
        for (int i10 = 1; i10 < this.I.size(); i10++) {
            ((l) this.I.get(i10 - 1)).a(new a((l) this.I.get(i10)));
        }
        l lVar = (l) this.I.get(0);
        if (lVar != null) {
            lVar.V();
        }
    }

    @Override // n2.l
    public void X(l.e eVar) {
        super.X(eVar);
        this.T |= 8;
        int size = this.I.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((l) this.I.get(i10)).X(eVar);
        }
    }

    @Override // n2.l
    public void Z(g gVar) {
        super.Z(gVar);
        this.T |= 4;
        if (this.I != null) {
            for (int i10 = 0; i10 < this.I.size(); i10++) {
                ((l) this.I.get(i10)).Z(gVar);
            }
        }
    }

    @Override // n2.l
    public void a0(o oVar) {
        super.a0(oVar);
        this.T |= 2;
        int size = this.I.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((l) this.I.get(i10)).a0(oVar);
        }
    }

    @Override // n2.l
    public String d0(String str) {
        String strD0 = super.d0(str);
        for (int i10 = 0; i10 < this.I.size(); i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strD0);
            sb2.append("\n");
            sb2.append(((l) this.I.get(i10)).d0(str + "  "));
            strD0 = sb2.toString();
        }
        return strD0;
    }

    @Override // n2.l
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public p a(l.f fVar) {
        return (p) super.a(fVar);
    }

    @Override // n2.l
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public p b(View view) {
        for (int i10 = 0; i10 < this.I.size(); i10++) {
            ((l) this.I.get(i10)).b(view);
        }
        return (p) super.b(view);
    }

    @Override // n2.l
    public void g() {
        super.g();
        int size = this.I.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((l) this.I.get(i10)).g();
        }
    }

    public p g0(l lVar) {
        h0(lVar);
        long j10 = this.f16550c;
        if (j10 >= 0) {
            lVar.W(j10);
        }
        if ((this.T & 1) != 0) {
            lVar.Y(t());
        }
        if ((this.T & 2) != 0) {
            y();
            lVar.a0(null);
        }
        if ((this.T & 4) != 0) {
            lVar.Z(x());
        }
        if ((this.T & 8) != 0) {
            lVar.X(s());
        }
        return this;
    }

    @Override // n2.l
    public void h(r rVar) {
        if (I(rVar.f16596b)) {
            for (l lVar : this.I) {
                if (lVar.I(rVar.f16596b)) {
                    lVar.h(rVar);
                    rVar.f16597c.add(lVar);
                }
            }
        }
    }

    public final void h0(l lVar) {
        this.I.add(lVar);
        lVar.f16565r = this;
    }

    public l i0(int i10) {
        if (i10 < 0 || i10 >= this.I.size()) {
            return null;
        }
        return (l) this.I.get(i10);
    }

    @Override // n2.l
    public void j(r rVar) {
        super.j(rVar);
        int size = this.I.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((l) this.I.get(i10)).j(rVar);
        }
    }

    public int j0() {
        return this.I.size();
    }

    @Override // n2.l
    public void k(r rVar) {
        if (I(rVar.f16596b)) {
            for (l lVar : this.I) {
                if (lVar.I(rVar.f16596b)) {
                    lVar.k(rVar);
                    rVar.f16597c.add(lVar);
                }
            }
        }
    }

    @Override // n2.l
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public p R(l.f fVar) {
        return (p) super.R(fVar);
    }

    @Override // n2.l
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public p S(View view) {
        for (int i10 = 0; i10 < this.I.size(); i10++) {
            ((l) this.I.get(i10)).S(view);
        }
        return (p) super.S(view);
    }

    @Override // n2.l
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public p W(long j10) {
        ArrayList arrayList;
        super.W(j10);
        if (this.f16550c >= 0 && (arrayList = this.I) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((l) this.I.get(i10)).W(j10);
            }
        }
        return this;
    }

    @Override // n2.l
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public l clone() {
        p pVar = (p) super.clone();
        pVar.I = new ArrayList();
        int size = this.I.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVar.h0(((l) this.I.get(i10)).clone());
        }
        return pVar;
    }

    @Override // n2.l
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public p Y(TimeInterpolator timeInterpolator) {
        this.T |= 1;
        ArrayList arrayList = this.I;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((l) this.I.get(i10)).Y(timeInterpolator);
            }
        }
        return (p) super.Y(timeInterpolator);
    }

    public p o0(int i10) {
        if (i10 == 0) {
            this.Q = true;
            return this;
        }
        if (i10 == 1) {
            this.Q = false;
            return this;
        }
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
    }

    @Override // n2.l
    public void p(ViewGroup viewGroup, s sVar, s sVar2, ArrayList arrayList, ArrayList arrayList2) {
        long jA = A();
        int size = this.I.size();
        for (int i10 = 0; i10 < size; i10++) {
            l lVar = (l) this.I.get(i10);
            if (jA > 0 && (this.Q || i10 == 0)) {
                long jA2 = lVar.A();
                if (jA2 > 0) {
                    lVar.b0(jA2 + jA);
                } else {
                    lVar.b0(jA);
                }
            }
            lVar.p(viewGroup, sVar, sVar2, arrayList, arrayList2);
        }
    }

    @Override // n2.l
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public p b0(long j10) {
        return (p) super.b0(j10);
    }

    public final void q0() {
        b bVar = new b(this);
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(bVar);
        }
        this.R = this.I.size();
    }
}
