package v1;

import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: v1.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1894l extends AbstractBinderC1887e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1895m f15305a;

    public BinderC1894l(C1895m c1895m) {
        this.f15305a = c1895m;
    }

    @Override // v1.AbstractBinderC1887e, v1.v
    public final void K(Status status) {
        this.f15305a.setResult(status);
    }
}
