package m5;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.t1;
import com.google.android.gms.common.internal.u1;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z extends t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15963a;

    public z(byte[] bArr) {
        com.google.android.gms.common.internal.s.a(bArr.length == 25);
        this.f15963a = Arrays.hashCode(bArr);
    }

    public static byte[] J(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public abstract byte[] I();

    public final boolean equals(Object obj) {
        w5.a aVarZzd;
        if (!(obj instanceof u1)) {
            return false;
        }
        try {
            u1 u1Var = (u1) obj;
            if (u1Var.zze() == this.f15963a && (aVarZzd = u1Var.zzd()) != null) {
                return Arrays.equals(I(), (byte[]) w5.b.I(aVarZzd));
            }
            return false;
        } catch (RemoteException e10) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            return false;
        }
    }

    public final int hashCode() {
        return this.f15963a;
    }

    @Override // com.google.android.gms.common.internal.u1
    public final w5.a zzd() {
        return w5.b.J(I());
    }

    @Override // com.google.android.gms.common.internal.u1
    public final int zze() {
        return this.f15963a;
    }
}
