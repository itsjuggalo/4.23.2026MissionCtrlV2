package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.w1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1416w1 implements G2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1412v1 f15533a;

    public C1416w1(AbstractC1412v1 abstractC1412v1) {
        Charset charset = P1.f15203a;
        this.f15533a = abstractC1412v1;
        abstractC1412v1.f15527a = this;
    }

    public static C1416w1 B(AbstractC1412v1 abstractC1412v1) {
        C1416w1 c1416w1 = abstractC1412v1.f15527a;
        return c1416w1 != null ? c1416w1 : new C1416w1(abstractC1412v1);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void A(int i8) {
        this.f15533a.u(i8, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void a(int i8, Object obj, InterfaceC1384p2 interfaceC1384p2) {
        AbstractC1412v1 abstractC1412v1 = this.f15533a;
        abstractC1412v1.u(i8, 3);
        interfaceC1384p2.b((InterfaceC1334f2) obj, abstractC1412v1.f15527a);
        abstractC1412v1.u(i8, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void b(int i8, List list) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.f15533a.k(i8, (AbstractC1378o1) list.get(i9));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void c(int i8, String str) {
        this.f15533a.t(i8, str);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void d(int i8, int i9) {
        this.f15533a.v(i8, i9);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void e(int i8, boolean z7) {
        this.f15533a.j(i8, z7);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void f(int i8, AbstractC1378o1 abstractC1378o1) {
        this.f15533a.k(i8, abstractC1378o1);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void g(int i8, long j8) {
        this.f15533a.x(i8, j8);
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
    @Override // com.google.android.gms.internal.play_billing.G2
    public final void h(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f15533a.j(i8, ((Boolean) list.get(i9)).booleanValue());
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v1 = this.f15533a;
        abstractC1412v1.u(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Boolean) list.get(i11)).booleanValue();
            i10++;
        }
        abstractC1412v1.w(i10);
        while (i9 < list.size()) {
            abstractC1412v1.i(((Boolean) list.get(i9)).booleanValue() ? (byte) 1 : (byte) 0);
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void i(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof K1)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.f15533a.l(i8, ((Integer) list.get(i9)).intValue());
                    i9++;
                }
                return;
            }
            AbstractC1412v1 abstractC1412v1 = this.f15533a;
            abstractC1412v1.u(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Integer) list.get(i11)).intValue();
                i10 += 4;
            }
            abstractC1412v1.w(i10);
            while (i9 < list.size()) {
                abstractC1412v1.m(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        K1 k12 = (K1) list;
        if (!z7) {
            while (i9 < k12.size()) {
                this.f15533a.l(i8, k12.d(i9));
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v12 = this.f15533a;
        abstractC1412v12.u(i8, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < k12.size(); i13++) {
            k12.d(i13);
            i12 += 4;
        }
        abstractC1412v12.w(i12);
        while (i9 < k12.size()) {
            abstractC1412v12.m(k12.d(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void j(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof K1)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.f15533a.p(i8, ((Integer) list.get(i9)).intValue());
                    i9++;
                }
                return;
            }
            AbstractC1412v1 abstractC1412v1 = this.f15533a;
            abstractC1412v1.u(i8, 2);
            int iD = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                iD += AbstractC1412v1.d(((Integer) list.get(i10)).intValue());
            }
            abstractC1412v1.w(iD);
            while (i9 < list.size()) {
                abstractC1412v1.q(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        K1 k12 = (K1) list;
        if (!z7) {
            while (i9 < k12.size()) {
                this.f15533a.p(i8, k12.d(i9));
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v12 = this.f15533a;
        abstractC1412v12.u(i8, 2);
        int iD2 = 0;
        for (int i11 = 0; i11 < k12.size(); i11++) {
            iD2 += AbstractC1412v1.d(k12.d(i11));
        }
        abstractC1412v12.w(iD2);
        while (i9 < k12.size()) {
            abstractC1412v12.q(k12.d(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void k(int i8, long j8) {
        this.f15533a.n(i8, j8);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void l(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof K1)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.f15533a.p(i8, ((Integer) list.get(i9)).intValue());
                    i9++;
                }
                return;
            }
            AbstractC1412v1 abstractC1412v1 = this.f15533a;
            abstractC1412v1.u(i8, 2);
            int iD = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                iD += AbstractC1412v1.d(((Integer) list.get(i10)).intValue());
            }
            abstractC1412v1.w(iD);
            while (i9 < list.size()) {
                abstractC1412v1.q(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        K1 k12 = (K1) list;
        if (!z7) {
            while (i9 < k12.size()) {
                this.f15533a.p(i8, k12.d(i9));
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v12 = this.f15533a;
        abstractC1412v12.u(i8, 2);
        int iD2 = 0;
        for (int i11 = 0; i11 < k12.size(); i11++) {
            iD2 += AbstractC1412v1.d(k12.d(i11));
        }
        abstractC1412v12.w(iD2);
        while (i9 < k12.size()) {
            abstractC1412v12.q(k12.d(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void m(int i8, int i9) {
        this.f15533a.p(i8, i9);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void n(int i8, long j8) {
        this.f15533a.x(i8, (j8 >> 63) ^ (j8 + j8));
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void o(int i8, Object obj, InterfaceC1384p2 interfaceC1384p2) {
        this.f15533a.s(i8, (InterfaceC1334f2) obj, interfaceC1384p2);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void p(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f15533a.n(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v1 = this.f15533a;
        abstractC1412v1.u(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).longValue();
            i10 += 8;
        }
        abstractC1412v1.w(i10);
        while (i9 < list.size()) {
            abstractC1412v1.o(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void q(int i8, float f8) {
        this.f15533a.l(i8, Float.floatToRawIntBits(f8));
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void r(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f15533a.x(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v1 = this.f15533a;
        abstractC1412v1.u(i8, 2);
        int iD = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iD += AbstractC1412v1.d(((Long) list.get(i10)).longValue());
        }
        abstractC1412v1.w(iD);
        while (i9 < list.size()) {
            abstractC1412v1.y(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void s(int i8, int i9) {
        this.f15533a.l(i8, i9);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void t(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f15533a.n(i8, Double.doubleToRawLongBits(((Double) list.get(i9)).doubleValue()));
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v1 = this.f15533a;
        abstractC1412v1.u(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Double) list.get(i11)).doubleValue();
            i10 += 8;
        }
        abstractC1412v1.w(i10);
        while (i9 < list.size()) {
            abstractC1412v1.o(Double.doubleToRawLongBits(((Double) list.get(i9)).doubleValue()));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void u(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f15533a.l(i8, Float.floatToRawIntBits(((Float) list.get(i9)).floatValue()));
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v1 = this.f15533a;
        abstractC1412v1.u(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Float) list.get(i11)).floatValue();
            i10 += 4;
        }
        abstractC1412v1.w(i10);
        while (i9 < list.size()) {
            abstractC1412v1.m(Float.floatToRawIntBits(((Float) list.get(i9)).floatValue()));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void v(int i8, int i9) {
        this.f15533a.v(i8, (i9 >> 31) ^ (i9 + i9));
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void w(int i8, long j8) {
        this.f15533a.n(i8, j8);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void x(int i8, List list) {
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.f15533a.t(i8, (String) list.get(i9));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void y(int i8, long j8) {
        this.f15533a.x(i8, j8);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void z(int i8) {
        this.f15533a.u(i8, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void zzA(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f15533a.n(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v1 = this.f15533a;
        abstractC1412v1.u(i8, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((Long) list.get(i11)).longValue();
            i10 += 8;
        }
        abstractC1412v1.w(i10);
        while (i9 < list.size()) {
            abstractC1412v1.o(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void zzC(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof K1)) {
            if (!z7) {
                while (i9 < list.size()) {
                    AbstractC1412v1 abstractC1412v1 = this.f15533a;
                    int iIntValue = ((Integer) list.get(i9)).intValue();
                    abstractC1412v1.v(i8, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i9++;
                }
                return;
            }
            AbstractC1412v1 abstractC1412v12 = this.f15533a;
            abstractC1412v12.u(i8, 2);
            int iC = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                int iIntValue2 = ((Integer) list.get(i10)).intValue();
                iC += AbstractC1412v1.c((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            abstractC1412v12.w(iC);
            while (i9 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i9)).intValue();
                abstractC1412v12.w((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i9++;
            }
            return;
        }
        K1 k12 = (K1) list;
        if (!z7) {
            while (i9 < k12.size()) {
                AbstractC1412v1 abstractC1412v13 = this.f15533a;
                int iD = k12.d(i9);
                abstractC1412v13.v(i8, (iD >> 31) ^ (iD + iD));
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v14 = this.f15533a;
        abstractC1412v14.u(i8, 2);
        int iC2 = 0;
        for (int i11 = 0; i11 < k12.size(); i11++) {
            int iD2 = k12.d(i11);
            iC2 += AbstractC1412v1.c((iD2 >> 31) ^ (iD2 + iD2));
        }
        abstractC1412v14.w(iC2);
        while (i9 < k12.size()) {
            int iD3 = k12.d(i9);
            abstractC1412v14.w((iD3 >> 31) ^ (iD3 + iD3));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void zzE(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                AbstractC1412v1 abstractC1412v1 = this.f15533a;
                long jLongValue = ((Long) list.get(i9)).longValue();
                abstractC1412v1.x(i8, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v12 = this.f15533a;
        abstractC1412v12.u(i8, 2);
        int iD = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            long jLongValue2 = ((Long) list.get(i10)).longValue();
            iD += AbstractC1412v1.d((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        abstractC1412v12.w(iD);
        while (i9 < list.size()) {
            long jLongValue3 = ((Long) list.get(i9)).longValue();
            abstractC1412v12.y((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void zzJ(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof K1)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.f15533a.v(i8, ((Integer) list.get(i9)).intValue());
                    i9++;
                }
                return;
            }
            AbstractC1412v1 abstractC1412v1 = this.f15533a;
            abstractC1412v1.u(i8, 2);
            int iC = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                iC += AbstractC1412v1.c(((Integer) list.get(i10)).intValue());
            }
            abstractC1412v1.w(iC);
            while (i9 < list.size()) {
                abstractC1412v1.w(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        K1 k12 = (K1) list;
        if (!z7) {
            while (i9 < k12.size()) {
                this.f15533a.v(i8, k12.d(i9));
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v12 = this.f15533a;
        abstractC1412v12.u(i8, 2);
        int iC2 = 0;
        for (int i11 = 0; i11 < k12.size(); i11++) {
            iC2 += AbstractC1412v1.c(k12.d(i11));
        }
        abstractC1412v12.w(iC2);
        while (i9 < k12.size()) {
            abstractC1412v12.w(k12.d(i9));
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void zzL(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!z7) {
            while (i9 < list.size()) {
                this.f15533a.x(i8, ((Long) list.get(i9)).longValue());
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v1 = this.f15533a;
        abstractC1412v1.u(i8, 2);
        int iD = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iD += AbstractC1412v1.d(((Long) list.get(i10)).longValue());
        }
        abstractC1412v1.w(iD);
        while (i9 < list.size()) {
            abstractC1412v1.y(((Long) list.get(i9)).longValue());
            i9++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void zzf(int i8, double d8) {
        this.f15533a.n(i8, Double.doubleToRawLongBits(d8));
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void zzi(int i8, int i9) {
        this.f15533a.p(i8, i9);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void zzk(int i8, int i9) {
        this.f15533a.l(i8, i9);
    }

    @Override // com.google.android.gms.internal.play_billing.G2
    public final void zzy(int i8, List list, boolean z7) {
        int i9 = 0;
        if (!(list instanceof K1)) {
            if (!z7) {
                while (i9 < list.size()) {
                    this.f15533a.l(i8, ((Integer) list.get(i9)).intValue());
                    i9++;
                }
                return;
            }
            AbstractC1412v1 abstractC1412v1 = this.f15533a;
            abstractC1412v1.u(i8, 2);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((Integer) list.get(i11)).intValue();
                i10 += 4;
            }
            abstractC1412v1.w(i10);
            while (i9 < list.size()) {
                abstractC1412v1.m(((Integer) list.get(i9)).intValue());
                i9++;
            }
            return;
        }
        K1 k12 = (K1) list;
        if (!z7) {
            while (i9 < k12.size()) {
                this.f15533a.l(i8, k12.d(i9));
                i9++;
            }
            return;
        }
        AbstractC1412v1 abstractC1412v12 = this.f15533a;
        abstractC1412v12.u(i8, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < k12.size(); i13++) {
            k12.d(i13);
            i12 += 4;
        }
        abstractC1412v12.w(i12);
        while (i9 < k12.size()) {
            abstractC1412v12.m(k12.d(i9));
            i9++;
        }
    }
}
