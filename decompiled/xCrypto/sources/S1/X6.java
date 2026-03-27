package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class X6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzid f4291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f4292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f4293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b7 f4295e;

    public /* synthetic */ X6(b7 b7Var, byte[] bArr) {
        Objects.requireNonNull(b7Var);
        this.f4295e = b7Var;
    }

    public static final long b(zzhs zzhsVar) {
        return ((zzhsVar.zzf() / 1000) / 60) / 60;
    }

    public final boolean a(long j4, zzhs zzhsVar) {
        AbstractC0940s.k(zzhsVar);
        if (this.f4293c == null) {
            this.f4293c = new ArrayList();
        }
        if (this.f4292b == null) {
            this.f4292b = new ArrayList();
        }
        if (!this.f4293c.isEmpty() && b((zzhs) this.f4293c.get(0)) != b(zzhsVar)) {
            return false;
        }
        long jZzcn = this.f4294d + ((long) zzhsVar.zzcn());
        b7 b7Var = this.f4295e;
        if (!b7Var.B0().H(null, AbstractC0569f2.f4571f1)) {
            b7Var.B0();
            if (jZzcn >= C0622m.o()) {
                return false;
            }
        } else if (!this.f4293c.isEmpty()) {
            b7Var.B0();
            if (jZzcn >= C0622m.o()) {
                return false;
            }
        }
        this.f4294d = jZzcn;
        this.f4293c.add(zzhsVar);
        this.f4292b.add(Long.valueOf(j4));
        int size = this.f4293c.size();
        b7Var.B0();
        return size < Math.max(1, ((Integer) AbstractC0569f2.f4584k.b(null)).intValue());
    }
}
