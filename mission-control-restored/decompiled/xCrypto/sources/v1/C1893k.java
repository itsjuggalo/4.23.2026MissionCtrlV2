package v1;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import u1.C1864c;

/* JADX INFO: renamed from: v1.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1893k extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f15303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GoogleSignInOptions f15304b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1893k(com.google.android.gms.common.api.f fVar, Context context, GoogleSignInOptions googleSignInOptions) {
        super(fVar);
        this.f15303a = context;
        this.f15304b = googleSignInOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ com.google.android.gms.common.api.k createFailedResult(Status status) {
        return new C1864c(null, status);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0901e
    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) {
        ((w) ((C1891i) bVar).getService()).f(new BinderC1892j(this), this.f15304b);
    }
}
