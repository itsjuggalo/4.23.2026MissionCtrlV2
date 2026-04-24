package z1;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.A0;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.W;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class y extends A0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16119a;

    public y(byte[] bArr) {
        AbstractC0940s.a(bArr.length == 25);
        this.f16119a = Arrays.hashCode(bArr);
    }

    public static byte[] c(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e4) {
            throw new AssertionError(e4);
        }
    }

    public abstract byte[] a0();

    public final boolean equals(Object obj) {
        J1.a aVarZzd;
        if (obj != null && (obj instanceof W)) {
            try {
                W w4 = (W) obj;
                if (w4.zzc() == this.f16119a && (aVarZzd = w4.zzd()) != null) {
                    return Arrays.equals(a0(), (byte[]) J1.b.c(aVarZzd));
                }
                return false;
            } catch (RemoteException e4) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f16119a;
    }

    @Override // com.google.android.gms.common.internal.W
    public final int zzc() {
        return this.f16119a;
    }

    @Override // com.google.android.gms.common.internal.W
    public final J1.a zzd() {
        return J1.b.f(a0());
    }
}
