package m7;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e2 extends n7.s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f16004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f16005c;

    public e2(FirebaseAuth firebaseAuth, String str, e eVar) {
        this.f16003a = str;
        this.f16004b = eVar;
        Objects.requireNonNull(firebaseAuth);
        this.f16005c = firebaseAuth;
    }

    @Override // n7.s0
    public final Task c(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Email link sign in for " + this.f16003a + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for email link sign in for " + this.f16003a);
        }
        FirebaseAuth firebaseAuth = this.f16005c;
        return firebaseAuth.f6027e.zzb(firebaseAuth.f6023a, this.f16003a, this.f16004b, this.f16005c.f6033k, str);
    }
}
