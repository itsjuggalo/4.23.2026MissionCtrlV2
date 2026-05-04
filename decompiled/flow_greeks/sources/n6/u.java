package n6;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f16674d = new u(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f16675c;

    public u(Object[] objArr, int i10) {
        this.f16675c = objArr;
    }

    @Override // n6.s, n6.p
    public final int a(Object[] objArr, int i10) {
        System.arraycopy(this.f16675c, 0, objArr, 0, 0);
        return 0;
    }

    @Override // n6.p
    public final int c() {
        return 0;
    }

    @Override // n6.p
    public final int d() {
        return 0;
    }

    @Override // n6.p
    public final Object[] e() {
        return this.f16675c;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        m.a(i10, 0, FirebaseAnalytics.Param.INDEX);
        Object obj = this.f16675c[i10];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return 0;
    }
}
