package u1;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.D;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: renamed from: u1.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1213o extends zzb implements D {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f10305b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10306a;

    public AbstractBinderC1213o(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        I.b(bArr.length == 25);
        this.f10306a = Arrays.hashCode(bArr);
    }

    public static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public abstract byte[] b();

    public final boolean equals(Object obj) {
        E1.a aVarZzd;
        if (obj != null && (obj instanceof D)) {
            try {
                D d4 = (D) obj;
                if (d4.zzc() == this.f10306a && (aVarZzd = d4.zzd()) != null) {
                    return Arrays.equals(b(), (byte[]) E1.b.b(aVarZzd));
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f10306a;
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i6) {
        if (i == 1) {
            E1.a aVarZzd = zzd();
            parcel2.writeNoException();
            zzc.zze(parcel2, aVarZzd);
        } else {
            if (i != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.f10306a);
        }
        return true;
    }

    @Override // com.google.android.gms.common.internal.D
    public final int zzc() {
        return this.f10306a;
    }

    @Override // com.google.android.gms.common.internal.D
    public final E1.a zzd() {
        return new E1.b(b());
    }
}
