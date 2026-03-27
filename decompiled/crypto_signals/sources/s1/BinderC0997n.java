package s1;

import N1.C0146y;
import android.os.Binder;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.internal.p000authapi.zbb;
import m1.AbstractC0858a;
import org.json.JSONException;
import r1.C0964a;

/* JADX INFO: renamed from: s1.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC0997n extends zbb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RevocationBoundService f9533a;

    public BinderC0997n(RevocationBoundService revocationBoundService) {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
        this.f9533a = revocationBoundService;
    }

    public final void a() {
        if (!B1.c.e(this.f9533a, Binder.getCallingUid())) {
            throw new SecurityException(a3.d.i("Calling UID ", Binder.getCallingUid(), " is not Google Play services."));
        }
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i6) {
        GoogleSignInOptions googleSignInOptionsN;
        String strD;
        RevocationBoundService revocationBoundService = this.f9533a;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            a();
            C0994k.Y(revocationBoundService).Z();
            return true;
        }
        a();
        C0985b c0985bA = C0985b.a(revocationBoundService);
        GoogleSignInAccount googleSignInAccountB = c0985bA.b();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f5027o;
        if (googleSignInAccountB != null) {
            String strD2 = c0985bA.d("defaultGoogleSignInAccount");
            if (TextUtils.isEmpty(strD2) || (strD = c0985bA.d(C0985b.f("googleSignInOptions", strD2))) == null) {
                googleSignInOptionsN = null;
                googleSignInOptions = googleSignInOptionsN;
            } else {
                try {
                    googleSignInOptionsN = GoogleSignInOptions.n(strD);
                } catch (JSONException unused) {
                    googleSignInOptionsN = null;
                }
                googleSignInOptions = googleSignInOptionsN;
            }
        }
        GoogleSignInOptions googleSignInOptions2 = googleSignInOptions;
        I.g(googleSignInOptions2);
        C0964a c0964a = new C0964a(revocationBoundService, null, AbstractC0858a.f8453a, googleSignInOptions2, new com.google.android.gms.common.api.k(new C0146y(21), Looper.getMainLooper()));
        if (googleSignInAccountB != null) {
            c0964a.d();
        } else {
            c0964a.signOut();
        }
        return true;
    }
}
