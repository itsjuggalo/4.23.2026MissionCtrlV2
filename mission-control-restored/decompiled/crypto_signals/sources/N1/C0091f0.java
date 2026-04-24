package N1;

import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: renamed from: N1.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0091f0 implements P2.C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1606d;
    public Object e;

    public /* synthetic */ C0091f0(U1 u12) {
        Objects.requireNonNull(u12);
        this.e = u12;
    }

    public void a(Q2.h hVar) {
        ((P2.P) this.f1604b).e0("INSERT OR REPLACE INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)", t2.u0.m(hVar.f2674a), Long.valueOf(u()));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(long r11, com.google.android.gms.internal.measurement.zzhs r13) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N1.C0091f0.b(long, com.google.android.gms.internal.measurement.zzhs):boolean");
    }

    @Override // P2.C
    public void c(Q2.h hVar) {
        a(hVar);
    }

    public void d() {
        C0097h0 c0097h0 = (C0097h0) this.e;
        c0097h0.p();
        ((C0138v0) c0097h0.f1130a).f1819o.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = c0097h0.t().edit();
        editorEdit.remove((String) this.f1605c);
        editorEdit.remove((String) this.f1606d);
        editorEdit.putLong((String) this.f1604b, jCurrentTimeMillis);
        editorEdit.apply();
    }

    @Override // P2.C
    public void e(A.c cVar) {
        this.e = cVar;
    }

    @Override // P2.C
    public void i(P2.X x6) {
        ((P2.P) this.f1604b).e.c(x6.b(u()));
    }

    @Override // P2.C
    public void j(Q2.h hVar) {
        a(hVar);
    }

    @Override // P2.C
    public void l() {
        D1.b.w("Committing a transaction without having started one", this.f1603a != -1, new Object[0]);
        this.f1603a = -1L;
    }

    @Override // P2.C
    public void o() {
        D1.b.w("Starting a transaction without committing the previous one", this.f1603a == -1, new Object[0]);
        N2.A a6 = (N2.A) this.f1605c;
        long j4 = a6.f1899a + 1;
        a6.f1899a = j4;
        this.f1603a = j4;
    }

    @Override // P2.C
    public void q(Q2.h hVar) {
        a(hVar);
    }

    @Override // P2.C
    public void t(Q2.h hVar) {
        a(hVar);
    }

    @Override // P2.C
    public long u() {
        D1.b.w("Attempting to get a sequence number outside of a transaction", this.f1603a != -1, new Object[0]);
        return this.f1603a;
    }
}
