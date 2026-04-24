package r1;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.s;

/* JADX INFO: loaded from: classes.dex */
public final class c implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f9452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f9453b;

    public c(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f9453b = googleSignInAccount;
        this.f9452a = status;
    }

    @Override // com.google.android.gms.common.api.s
    public final Status getStatus() {
        return this.f9452a;
    }
}
