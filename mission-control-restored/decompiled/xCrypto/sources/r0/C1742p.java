package r0;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import r0.AbstractC1738l;

/* JADX INFO: renamed from: r0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1742p extends AbstractC1738l {

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public int f14461P;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public ArrayList f14459I = new ArrayList();

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f14460O = true;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f14462Q = false;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public int f14463R = 0;

    /* JADX INFO: renamed from: r0.p$a */
    public class a extends AbstractC1739m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1738l f14464a;

        public a(AbstractC1738l abstractC1738l) {
            this.f14464a = abstractC1738l;
        }

        @Override // r0.AbstractC1738l.f
        public void b(AbstractC1738l abstractC1738l) {
            this.f14464a.T();
            abstractC1738l.P(this);
        }
    }

    /* JADX INFO: renamed from: r0.p$b */
    public static class b extends AbstractC1739m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C1742p f14466a;

        public b(C1742p c1742p) {
            this.f14466a = c1742p;
        }

        @Override // r0.AbstractC1738l.f
        public void b(AbstractC1738l abstractC1738l) {
            C1742p c1742p = this.f14466a;
            int i4 = c1742p.f14461P - 1;
            c1742p.f14461P = i4;
            if (i4 == 0) {
                c1742p.f14462Q = false;
                c1742p.p();
            }
            abstractC1738l.P(this);
        }

        @Override // r0.AbstractC1739m, r0.AbstractC1738l.f
        public void e(AbstractC1738l abstractC1738l) {
            C1742p c1742p = this.f14466a;
            if (c1742p.f14462Q) {
                return;
            }
            c1742p.a0();
            this.f14466a.f14462Q = true;
        }
    }

    @Override // r0.AbstractC1738l
    public void N(View view) {
        super.N(view);
        int size = this.f14459I.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((AbstractC1738l) this.f14459I.get(i4)).N(view);
        }
    }

    @Override // r0.AbstractC1738l
    public void R(View view) {
        super.R(view);
        int size = this.f14459I.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((AbstractC1738l) this.f14459I.get(i4)).R(view);
        }
    }

    @Override // r0.AbstractC1738l
    public void T() {
        if (this.f14459I.isEmpty()) {
            a0();
            p();
            return;
        }
        o0();
        if (this.f14460O) {
            Iterator it = this.f14459I.iterator();
            while (it.hasNext()) {
                ((AbstractC1738l) it.next()).T();
            }
            return;
        }
        for (int i4 = 1; i4 < this.f14459I.size(); i4++) {
            ((AbstractC1738l) this.f14459I.get(i4 - 1)).a(new a((AbstractC1738l) this.f14459I.get(i4)));
        }
        AbstractC1738l abstractC1738l = (AbstractC1738l) this.f14459I.get(0);
        if (abstractC1738l != null) {
            abstractC1738l.T();
        }
    }

    @Override // r0.AbstractC1738l
    public void V(AbstractC1738l.e eVar) {
        super.V(eVar);
        this.f14463R |= 8;
        int size = this.f14459I.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((AbstractC1738l) this.f14459I.get(i4)).V(eVar);
        }
    }

    @Override // r0.AbstractC1738l
    public void X(AbstractC1733g abstractC1733g) {
        super.X(abstractC1733g);
        this.f14463R |= 4;
        if (this.f14459I != null) {
            for (int i4 = 0; i4 < this.f14459I.size(); i4++) {
                ((AbstractC1738l) this.f14459I.get(i4)).X(abstractC1733g);
            }
        }
    }

    @Override // r0.AbstractC1738l
    public void Y(AbstractC1741o abstractC1741o) {
        super.Y(abstractC1741o);
        this.f14463R |= 2;
        int size = this.f14459I.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((AbstractC1738l) this.f14459I.get(i4)).Y(abstractC1741o);
        }
    }

    @Override // r0.AbstractC1738l
    public String b0(String str) {
        String strB0 = super.b0(str);
        for (int i4 = 0; i4 < this.f14459I.size(); i4++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strB0);
            sb.append("\n");
            sb.append(((AbstractC1738l) this.f14459I.get(i4)).b0(str + "  "));
            strB0 = sb.toString();
        }
        return strB0;
    }

    @Override // r0.AbstractC1738l
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public C1742p a(AbstractC1738l.f fVar) {
        return (C1742p) super.a(fVar);
    }

    @Override // r0.AbstractC1738l
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public C1742p b(View view) {
        for (int i4 = 0; i4 < this.f14459I.size(); i4++) {
            ((AbstractC1738l) this.f14459I.get(i4)).b(view);
        }
        return (C1742p) super.b(view);
    }

    public C1742p e0(AbstractC1738l abstractC1738l) {
        f0(abstractC1738l);
        long j4 = this.f14420c;
        if (j4 >= 0) {
            abstractC1738l.U(j4);
        }
        if ((this.f14463R & 1) != 0) {
            abstractC1738l.W(s());
        }
        if ((this.f14463R & 2) != 0) {
            w();
            abstractC1738l.Y(null);
        }
        if ((this.f14463R & 4) != 0) {
            abstractC1738l.X(v());
        }
        if ((this.f14463R & 8) != 0) {
            abstractC1738l.V(r());
        }
        return this;
    }

    @Override // r0.AbstractC1738l
    public void f() {
        super.f();
        int size = this.f14459I.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((AbstractC1738l) this.f14459I.get(i4)).f();
        }
    }

    public final void f0(AbstractC1738l abstractC1738l) {
        this.f14459I.add(abstractC1738l);
        abstractC1738l.f14435r = this;
    }

    @Override // r0.AbstractC1738l
    public void g(s sVar) {
        if (G(sVar.f14471b)) {
            for (AbstractC1738l abstractC1738l : this.f14459I) {
                if (abstractC1738l.G(sVar.f14471b)) {
                    abstractC1738l.g(sVar);
                    sVar.f14472c.add(abstractC1738l);
                }
            }
        }
    }

    public AbstractC1738l g0(int i4) {
        if (i4 < 0 || i4 >= this.f14459I.size()) {
            return null;
        }
        return (AbstractC1738l) this.f14459I.get(i4);
    }

    public int h0() {
        return this.f14459I.size();
    }

    @Override // r0.AbstractC1738l
    public void i(s sVar) {
        super.i(sVar);
        int size = this.f14459I.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((AbstractC1738l) this.f14459I.get(i4)).i(sVar);
        }
    }

    @Override // r0.AbstractC1738l
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public C1742p P(AbstractC1738l.f fVar) {
        return (C1742p) super.P(fVar);
    }

    @Override // r0.AbstractC1738l
    public void j(s sVar) {
        if (G(sVar.f14471b)) {
            for (AbstractC1738l abstractC1738l : this.f14459I) {
                if (abstractC1738l.G(sVar.f14471b)) {
                    abstractC1738l.j(sVar);
                    sVar.f14472c.add(abstractC1738l);
                }
            }
        }
    }

    @Override // r0.AbstractC1738l
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public C1742p Q(View view) {
        for (int i4 = 0; i4 < this.f14459I.size(); i4++) {
            ((AbstractC1738l) this.f14459I.get(i4)).Q(view);
        }
        return (C1742p) super.Q(view);
    }

    @Override // r0.AbstractC1738l
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public C1742p U(long j4) {
        ArrayList arrayList;
        super.U(j4);
        if (this.f14420c >= 0 && (arrayList = this.f14459I) != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((AbstractC1738l) this.f14459I.get(i4)).U(j4);
            }
        }
        return this;
    }

    @Override // r0.AbstractC1738l
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C1742p W(TimeInterpolator timeInterpolator) {
        this.f14463R |= 1;
        ArrayList arrayList = this.f14459I;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((AbstractC1738l) this.f14459I.get(i4)).W(timeInterpolator);
            }
        }
        return (C1742p) super.W(timeInterpolator);
    }

    @Override // r0.AbstractC1738l
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public AbstractC1738l clone() {
        C1742p c1742p = (C1742p) super.clone();
        c1742p.f14459I = new ArrayList();
        int size = this.f14459I.size();
        for (int i4 = 0; i4 < size; i4++) {
            c1742p.f0(((AbstractC1738l) this.f14459I.get(i4)).clone());
        }
        return c1742p;
    }

    public C1742p m0(int i4) {
        if (i4 == 0) {
            this.f14460O = true;
            return this;
        }
        if (i4 == 1) {
            this.f14460O = false;
            return this;
        }
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i4);
    }

    @Override // r0.AbstractC1738l
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public C1742p Z(long j4) {
        return (C1742p) super.Z(j4);
    }

    @Override // r0.AbstractC1738l
    public void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        long jY = y();
        int size = this.f14459I.size();
        for (int i4 = 0; i4 < size; i4++) {
            AbstractC1738l abstractC1738l = (AbstractC1738l) this.f14459I.get(i4);
            if (jY > 0 && (this.f14460O || i4 == 0)) {
                long jY2 = abstractC1738l.y();
                if (jY2 > 0) {
                    abstractC1738l.Z(jY2 + jY);
                } else {
                    abstractC1738l.Z(jY);
                }
            }
            abstractC1738l.o(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    public final void o0() {
        b bVar = new b(this);
        Iterator it = this.f14459I.iterator();
        while (it.hasNext()) {
            ((AbstractC1738l) it.next()).a(bVar);
        }
        this.f14461P = this.f14459I.size();
    }
}
