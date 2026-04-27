package S1;

import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class Z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7 f4325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4326b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4327c = d();

    public Z6(b7 b7Var) {
        this.f4325a = b7Var;
    }

    public final void a() {
        this.f4326b++;
        this.f4327c = d();
    }

    public final boolean b() {
        return this.f4325a.f().currentTimeMillis() >= this.f4327c;
    }

    public final /* synthetic */ long c() {
        return this.f4327c;
    }

    public final long d() {
        b7 b7Var = this.f4325a;
        AbstractC0940s.k(b7Var);
        long jLongValue = ((Long) AbstractC0569f2.f4607v.b(null)).longValue();
        long jLongValue2 = ((Long) AbstractC0569f2.f4609w.b(null)).longValue();
        for (int i4 = 1; i4 < this.f4326b; i4++) {
            jLongValue += jLongValue;
            if (jLongValue >= jLongValue2) {
                break;
            }
        }
        return b7Var.f().currentTimeMillis() + Math.min(jLongValue, jLongValue2);
    }
}
