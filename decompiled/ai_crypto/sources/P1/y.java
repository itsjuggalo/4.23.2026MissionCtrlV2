package P1;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.A0;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.W;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class y extends A0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4322a;

    public y(byte[] bArr) {
        AbstractC1207s.a(bArr.length == 25);
        this.f4322a = Arrays.hashCode(bArr);
    }

    public static byte[] c(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e7) {
            throw new AssertionError(e7);
        }
    }

    public abstract byte[] a0();

    public final boolean equals(Object obj) {
        Z1.a aVarZzd;
        if (obj != null && (obj instanceof W)) {
            try {
                W w7 = (W) obj;
                if (w7.zzc() == this.f4322a && (aVarZzd = w7.zzd()) != null) {
                    return Arrays.equals(a0(), (byte[]) Z1.b.c(aVarZzd));
                }
                return false;
            } catch (RemoteException e7) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e7);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4322a;
    }

    @Override // com.google.android.gms.common.internal.W
    public final int zzc() {
        return this.f4322a;
    }

    @Override // com.google.android.gms.common.internal.W
    public final Z1.a zzd() {
        return Z1.b.f(a0());
    }
}
