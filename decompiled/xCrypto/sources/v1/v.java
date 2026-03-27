package v1;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public interface v extends IInterface {
    void B(Status status);

    void F(GoogleSignInAccount googleSignInAccount, Status status);

    void K(Status status);
}
