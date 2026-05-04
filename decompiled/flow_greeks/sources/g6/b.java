package g6;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a.AbstractC0094a {
    @Override // com.google.android.gms.common.api.a.AbstractC0094a
    public final /* bridge */ /* synthetic */ a.f buildClient(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, Object obj, g.b bVar, g.c cVar) {
        return new h6.a(context, looper, true, eVar, h6.a.e(eVar), bVar, cVar);
    }
}
