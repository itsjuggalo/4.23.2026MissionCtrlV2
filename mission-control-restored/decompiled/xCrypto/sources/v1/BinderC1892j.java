package v1;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import u1.C1864c;

/* JADX INFO: renamed from: v1.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1892j extends AbstractBinderC1887e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1893k f15302a;

    public BinderC1892j(C1893k c1893k) {
        this.f15302a = c1893k;
    }

    @Override // v1.AbstractBinderC1887e, v1.v
    public final void F(GoogleSignInAccount googleSignInAccount, Status status) {
        if (googleSignInAccount != null) {
            C1893k c1893k = this.f15302a;
            r.c(c1893k.f15303a).e(c1893k.f15304b, googleSignInAccount);
        }
        this.f15302a.setResult(new C1864c(googleSignInAccount, status));
    }
}
