package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public abstract class H1 extends Z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J1 f15167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public J1 f15168b;

    public H1(J1 j12) {
        this.f15167a = j12;
        if (j12.x()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f15168b = j12.n();
    }

    public static void c(Object obj, Object obj2) {
        C1369m2.a().b(obj.getClass()).e(obj, obj2);
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final H1 clone() {
        H1 h12 = (H1) this.f15167a.f(5, null, null);
        h12.f15168b = zzg();
        return h12;
    }

    public final H1 e(J1 j12) {
        if (!this.f15167a.equals(j12)) {
            if (!this.f15168b.x()) {
                j();
            }
            c(this.f15168b, j12);
        }
        return this;
    }

    public final J1 g() {
        J1 j1Zzg = zzg();
        if (j1Zzg.j()) {
            return j1Zzg;
        }
        throw new C1408u2(j1Zzg);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1329e2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public J1 zzg() {
        if (!this.f15168b.x()) {
            return this.f15168b;
        }
        this.f15168b.t();
        return this.f15168b;
    }

    public final void i() {
        if (this.f15168b.x()) {
            return;
        }
        j();
    }

    public void j() {
        J1 j1N = this.f15167a.n();
        c(j1N, this.f15168b);
        this.f15168b = j1N;
    }
}
