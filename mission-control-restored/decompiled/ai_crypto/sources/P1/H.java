package P1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.A0;

/* JADX INFO: loaded from: classes.dex */
public final class H extends Q1.a {
    public static final Parcelable.Creator<H> CREATOR = new I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f4273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4275d;

    public H(String str, y yVar, boolean z7, boolean z8) {
        this.f4272a = str;
        this.f4273b = yVar;
        this.f4274c = z7;
        this.f4275d = z8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        String str = this.f4272a;
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, str, false);
        y yVar = this.f4273b;
        if (yVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            yVar = null;
        }
        Q1.c.s(parcel, 2, yVar, false);
        Q1.c.g(parcel, 3, this.f4274c);
        Q1.c.g(parcel, 4, this.f4275d);
        Q1.c.b(parcel, iA);
    }

    public H(String str, IBinder iBinder, boolean z7, boolean z8) {
        this.f4272a = str;
        z zVar = null;
        if (iBinder != null) {
            try {
                Z1.a aVarZzd = A0.b(iBinder).zzd();
                byte[] bArr = aVarZzd == null ? null : (byte[]) Z1.b.c(aVarZzd);
                if (bArr != null) {
                    zVar = new z(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e7) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e7);
            }
        }
        this.f4273b = zVar;
        this.f4274c = z7;
        this.f4275d = z8;
    }
}
