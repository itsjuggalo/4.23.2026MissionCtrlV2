package L1;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.google.android.gms.common.api.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f3649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f3650b;

    public c(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f3650b = googleSignInAccount;
        this.f3649a = status;
    }

    public GoogleSignInAccount a() {
        return this.f3650b;
    }

    @Override // com.google.android.gms.common.api.k
    public Status getStatus() {
        return this.f3649a;
    }
}
