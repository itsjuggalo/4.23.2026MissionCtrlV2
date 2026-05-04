package n6;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f16669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f16670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ s f16671e;

    public r(s sVar, int i10, int i11) {
        this.f16671e = sVar;
        this.f16669c = i10;
        this.f16670d = i11;
    }

    @Override // n6.p
    public final int c() {
        return this.f16671e.d() + this.f16669c + this.f16670d;
    }

    @Override // n6.p
    public final int d() {
        return this.f16671e.d() + this.f16669c;
    }

    @Override // n6.p
    public final Object[] e() {
        return this.f16671e.e();
    }

    @Override // n6.s
    /* JADX INFO: renamed from: f */
    public final s subList(int i10, int i11) {
        m.c(i10, i11, this.f16670d);
        int i12 = this.f16669c;
        return this.f16671e.subList(i10 + i12, i11 + i12);
    }

    @Override // java.util.List
    public final Object get(int i10) {
        m.a(i10, this.f16670d, FirebaseAnalytics.Param.INDEX);
        return this.f16671e.get(i10 + this.f16669c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f16670d;
    }

    @Override // n6.s, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }
}
