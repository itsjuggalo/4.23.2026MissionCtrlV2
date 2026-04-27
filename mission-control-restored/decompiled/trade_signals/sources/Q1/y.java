package Q1;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.google.android.gms.common.internal.q0;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class y extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6716a;

    public y(byte[] bArr) {
        AbstractC1294n.a(bArr.length == 25);
        this.f6716a = Arrays.hashCode(bArr);
    }

    public static byte[] F(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e8) {
            throw new AssertionError(e8);
        }
    }

    public abstract byte[] G();

    public final boolean equals(Object obj) {
        Z1.a aVarZzd;
        if (obj != null && (obj instanceof com.google.android.gms.common.internal.L)) {
            try {
                com.google.android.gms.common.internal.L l8 = (com.google.android.gms.common.internal.L) obj;
                if (l8.zzc() == this.f6716a && (aVarZzd = l8.zzd()) != null) {
                    return Arrays.equals(G(), (byte[]) Z1.b.F(aVarZzd));
                }
                return false;
            } catch (RemoteException e8) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e8);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f6716a;
    }

    @Override // com.google.android.gms.common.internal.L
    public final int zzc() {
        return this.f6716a;
    }

    @Override // com.google.android.gms.common.internal.L
    public final Z1.a zzd() {
        return Z1.b.G(G());
    }
}
