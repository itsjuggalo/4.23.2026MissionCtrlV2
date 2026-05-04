package l1;

import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends i0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f15258b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Throwable finalException) {
        super(a.e.API_PRIORITY_OTHER, null);
        kotlin.jvm.internal.t.f(finalException, "finalException");
        this.f15258b = finalException;
    }

    public final Throwable b() {
        return this.f15258b;
    }
}
