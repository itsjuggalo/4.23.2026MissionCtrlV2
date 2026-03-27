package S1;

import android.os.Bundle;
import android.util.SparseArray;
import e2.InterfaceC1230b;
import java.util.Objects;

/* JADX INFO: renamed from: S1.l4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0619l4 implements InterfaceC1230b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B6 f4730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4731b;

    public C0619l4(C0540b5 c0540b5, B6 b6) {
        this.f4730a = b6;
        Objects.requireNonNull(c0540b5);
        this.f4731b = c0540b5;
    }

    @Override // e2.InterfaceC1230b
    public final void a(Throwable th) {
        C0540b5 c0540b5 = this.f4731b;
        c0540b5.h();
        c0540b5.Y(false);
        C0658q3 c0658q3 = c0540b5.f4245a;
        int iC0 = (c0658q3.w().H(null, AbstractC0569f2.f4543U0) ? c0540b5.c0(th) : 2) - 1;
        if (iC0 == 0) {
            c0658q3.a().r().c("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", C2.x(c0540b5.f4245a.L().q()), C2.x(th.toString()));
            c0540b5.a0(1);
            c0540b5.v0().add(this.f4730a);
            return;
        }
        if (iC0 != 1) {
            c0658q3.a().o().c("registerTriggerAsync failed. Dropping URI. App ID, Throwable", C2.x(c0540b5.f4245a.L().q()), th);
            b();
            c0540b5.a0(1);
            c0540b5.w0();
            return;
        }
        c0540b5.v0().add(this.f4730a);
        if (c0540b5.Z() > ((Integer) AbstractC0569f2.f4612x0.b(null)).intValue()) {
            c0540b5.a0(1);
            c0658q3.a().r().c("registerTriggerAsync failed. May try later. App ID, throwable", C2.x(c0540b5.f4245a.L().q()), C2.x(th.toString()));
        } else {
            c0658q3.a().r().d("registerTriggerAsync failed. App ID, delay in seconds, throwable", C2.x(c0540b5.f4245a.L().q()), C2.x(String.valueOf(c0540b5.Z())), C2.x(th.toString()));
            c0540b5.U(c0540b5.Z());
            int iZ = c0540b5.Z();
            c0540b5.a0(iZ + iZ);
        }
    }

    public final void b() {
        C0658q3 c0658q3 = this.f4731b.f4245a;
        SparseArray sparseArrayR = c0658q3.x().r();
        B6 b6 = this.f4730a;
        sparseArrayR.put(b6.f3873c, Long.valueOf(b6.f3872b));
        Q2 q2X = c0658q3.x();
        int[] iArr = new int[sparseArrayR.size()];
        long[] jArr = new long[sparseArrayR.size()];
        for (int i4 = 0; i4 < sparseArrayR.size(); i4++) {
            iArr[i4] = sparseArrayR.keyAt(i4);
            jArr[i4] = ((Long) sparseArrayR.valueAt(i4)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        q2X.f4193o.b(bundle);
    }

    @Override // e2.InterfaceC1230b
    public final void onSuccess(Object obj) {
        C0540b5 c0540b5 = this.f4731b;
        c0540b5.h();
        b();
        c0540b5.Y(false);
        c0540b5.a0(1);
        c0540b5.f4245a.a().v().b("Successfully registered trigger URI", this.f4730a.f3871a);
        c0540b5.w0();
    }
}
