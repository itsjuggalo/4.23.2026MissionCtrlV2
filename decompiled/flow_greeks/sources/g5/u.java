package g5;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p000authapi.zba;
import com.google.android.gms.internal.p000authapi.zbc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends zba implements IInterface {
    public u(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void H(t tVar, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, tVar);
        zbc.zbb(parcelZba, googleSignInOptions);
        zbb(102, parcelZba);
    }

    public final void I(t tVar, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, tVar);
        zbc.zbb(parcelZba, googleSignInOptions);
        zbb(103, parcelZba);
    }
}
