package z1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.A0;

/* JADX INFO: renamed from: z1.H, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1977H extends A1.a {
    public static final Parcelable.Creator<C1977H> CREATOR = new C1978I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f16070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f16072d;

    public C1977H(String str, y yVar, boolean z4, boolean z5) {
        this.f16069a = str;
        this.f16070b = yVar;
        this.f16071c = z4;
        this.f16072d = z5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        String str = this.f16069a;
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, str, false);
        y yVar = this.f16070b;
        if (yVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            yVar = null;
        }
        A1.c.s(parcel, 2, yVar, false);
        A1.c.g(parcel, 3, this.f16071c);
        A1.c.g(parcel, 4, this.f16072d);
        A1.c.b(parcel, iA);
    }

    public C1977H(String str, IBinder iBinder, boolean z4, boolean z5) {
        this.f16069a = str;
        z zVar = null;
        if (iBinder != null) {
            try {
                J1.a aVarZzd = A0.b(iBinder).zzd();
                byte[] bArr = aVarZzd == null ? null : (byte[]) J1.b.c(aVarZzd);
                if (bArr != null) {
                    zVar = new z(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e4) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e4);
            }
        }
        this.f16070b = zVar;
        this.f16071c = z4;
        this.f16072d = z5;
    }
}
