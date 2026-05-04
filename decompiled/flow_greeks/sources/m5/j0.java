package m5;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.t1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends n5.a {
    public static final Parcelable.Creator<j0> CREATOR = new k0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f15938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15940d;

    public j0(String str, z zVar, boolean z10, boolean z11) {
        this.f15937a = str;
        this.f15938b = zVar;
        this.f15939c = z10;
        this.f15940d = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.f15937a;
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, str, false);
        z zVar = this.f15938b;
        if (zVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zVar = null;
        }
        n5.c.s(parcel, 2, zVar, false);
        n5.c.g(parcel, 3, this.f15939c);
        n5.c.g(parcel, 4, this.f15940d);
        n5.c.b(parcel, iA);
    }

    public j0(String str, IBinder iBinder, boolean z10, boolean z11) {
        this.f15937a = str;
        a0 a0Var = null;
        if (iBinder != null) {
            try {
                w5.a aVarZzd = t1.H(iBinder).zzd();
                byte[] bArr = aVarZzd == null ? null : (byte[]) w5.b.I(aVarZzd);
                if (bArr != null) {
                    a0Var = new a0(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e10) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e10);
            }
        }
        this.f15938b = a0Var;
        this.f15939c = z10;
        this.f15940d = z11;
    }
}
