package u1;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: u1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1864c implements com.google.android.gms.common.api.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f15097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f15098b;

    public C1864c(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f15098b = googleSignInAccount;
        this.f15097a = status;
    }

    public GoogleSignInAccount a() {
        return this.f15098b;
    }

    @Override // com.google.android.gms.common.api.k
    public Status getStatus() {
        return this.f15097a;
    }
}
