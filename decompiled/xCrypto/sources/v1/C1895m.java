package v1;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;

/* JADX INFO: renamed from: v1.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1895m extends p {
    public C1895m(com.google.android.gms.common.api.f fVar) {
        super(fVar);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0901e
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        C1891i c1891i = (C1891i) bVar;
        ((w) c1891i.getService()).c(new BinderC1894l(this), c1891i.e());
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.api.k createFailedResult(Status status) {
        return status;
    }
}
