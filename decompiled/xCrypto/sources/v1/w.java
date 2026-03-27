package v1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p000authapi.zba;
import com.google.android.gms.internal.p000authapi.zbc;

/* JADX INFO: loaded from: classes.dex */
public final class w extends zba implements IInterface {
    public w(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void b(v vVar, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, vVar);
        zbc.zbc(parcelZba, googleSignInOptions);
        zbb(103, parcelZba);
    }

    public final void c(v vVar, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, vVar);
        zbc.zbc(parcelZba, googleSignInOptions);
        zbb(102, parcelZba);
    }

    public final void f(v vVar, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, vVar);
        zbc.zbc(parcelZba, googleSignInOptions);
        zbb(101, parcelZba);
    }
}
