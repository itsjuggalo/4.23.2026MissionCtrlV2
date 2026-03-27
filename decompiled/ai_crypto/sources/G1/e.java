package G1;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.C1194e;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a.AbstractC0178a {
    @Override // com.google.android.gms.common.api.a.AbstractC0178a
    public final /* synthetic */ a.f buildClient(Context context, Looper looper, C1194e c1194e, Object obj, f.b bVar, f.c cVar) {
        return new M1.i(context, looper, c1194e, (GoogleSignInOptions) obj, bVar, cVar);
    }

    @Override // com.google.android.gms.common.api.a.e
    public final /* bridge */ /* synthetic */ List getImpliedScopes(Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.D();
    }
}
