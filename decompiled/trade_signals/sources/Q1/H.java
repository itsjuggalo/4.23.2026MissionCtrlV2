package Q1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.q0;

/* JADX INFO: loaded from: classes.dex */
public final class H extends T1.a {
    public static final Parcelable.Creator<H> CREATOR = new I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f6667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6669d;

    public H(String str, y yVar, boolean z7, boolean z8) {
        this.f6666a = str;
        this.f6667b = yVar;
        this.f6668c = z7;
        this.f6669d = z8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        String str = this.f6666a;
        int iA = T1.c.a(parcel);
        T1.c.p(parcel, 1, str, false);
        y yVar = this.f6667b;
        if (yVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            yVar = null;
        }
        T1.c.i(parcel, 2, yVar, false);
        T1.c.c(parcel, 3, this.f6668c);
        T1.c.c(parcel, 4, this.f6669d);
        T1.c.b(parcel, iA);
    }

    public H(String str, IBinder iBinder, boolean z7, boolean z8) {
        this.f6666a = str;
        z zVar = null;
        if (iBinder != null) {
            try {
                Z1.a aVarZzd = q0.E(iBinder).zzd();
                byte[] bArr = aVarZzd == null ? null : (byte[]) Z1.b.F(aVarZzd);
                if (bArr != null) {
                    zVar = new z(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e8) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e8);
            }
        }
        this.f6667b = zVar;
        this.f6668c = z7;
        this.f6669d = z8;
    }
}
