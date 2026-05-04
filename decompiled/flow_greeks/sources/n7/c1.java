package n7;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzba;
import com.google.android.gms.internal.p002firebaseauthapi.zzcl;
import com.google.android.gms.internal.p002firebaseauthapi.zzco;
import com.google.android.gms.internal.p002firebaseauthapi.zzcv;
import com.google.android.gms.internal.p002firebaseauthapi.zzmy;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c1 f16720c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzmy f16722b;

    public c1(String str, zzmy zzmyVar) {
        this.f16721a = str;
        this.f16722b = zzmyVar;
    }

    public static c1 b(Context context, String str) {
        c1 c1Var = f16720c;
        if (c1Var == null || !Objects.equals(c1Var.f16721a, str)) {
            f16720c = new c1(str, e(context, str));
        }
        return f16720c;
    }

    public static zzmy c(Context context, String str) {
        return new zzmy.zza().zza(context, "StorageCryptoKeyset", f(str)).zza(zzcv.zzb).zza(String.format("android-keystore://firebear_main_key_id_for_storage_crypto.%s", str)).zza();
    }

    public static zzmy e(Context context, String str) {
        try {
            zzcl.zza();
            return c(context, str);
        } catch (IOException | GeneralSecurityException e10) {
            Log.e("FirebearStorageCryptoHelper", "Exception encountered during crypto setup:\n" + e10.getMessage());
            if (e10 instanceof GeneralSecurityException) {
                context.getSharedPreferences(f(str), 0).edit().remove("StorageCryptoKeyset").apply();
                try {
                    return c(context, str);
                } catch (IOException | GeneralSecurityException e11) {
                    Log.e("FirebearStorageCryptoHelper", "Exception encountered during second attempt to crypto setup:\n" + e11.getMessage());
                    return null;
                }
            }
            return null;
        }
    }

    public static String f(String str) {
        return String.format("com.google.firebase.auth.api.crypto.%s", str);
    }

    public final String a(String str) {
        String str2;
        com.google.android.gms.common.internal.s.k(str);
        zzmy zzmyVar = this.f16722b;
        if (zzmyVar == null) {
            Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to decrypt data");
            return null;
        }
        try {
            synchronized (zzmyVar) {
                str2 = new String(((zzba) this.f16722b.zza().zza(zzco.zza(), zzba.class)).zza(Base64.decode(str, 2), null), StandardCharsets.UTF_8);
            }
            return str2;
        } catch (IllegalArgumentException | GeneralSecurityException e10) {
            Log.e("FirebearStorageCryptoHelper", "Exception encountered while decrypting bytes:\n" + e10.getMessage());
            return null;
        }
    }

    public final String d(String str) {
        String strEncodeToString;
        com.google.android.gms.common.internal.s.k(str);
        zzmy zzmyVar = this.f16722b;
        if (zzmyVar == null) {
            Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to encrypt data");
            return null;
        }
        try {
            synchronized (zzmyVar) {
                strEncodeToString = Base64.encodeToString(((zzba) this.f16722b.zza().zza(zzco.zza(), zzba.class)).zzb(str.getBytes(StandardCharsets.UTF_8), null), 2);
            }
            return strEncodeToString;
        } catch (GeneralSecurityException e10) {
            Log.e("FirebearStorageCryptoHelper", "Exception encountered while encrypting bytes:\n" + e10.getMessage());
            return null;
        }
    }
}
