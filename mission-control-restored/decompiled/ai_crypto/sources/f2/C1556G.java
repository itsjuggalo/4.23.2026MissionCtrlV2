package f2;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.C1194e;
import com.google.android.gms.internal.location.zzaz;

/* JADX INFO: renamed from: f2.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1556G extends a.AbstractC0178a {
    @Override // com.google.android.gms.common.api.a.AbstractC0178a
    public final /* bridge */ /* synthetic */ a.f buildClient(Context context, Looper looper, C1194e c1194e, Object obj, f.b bVar, f.c cVar) {
        return new zzaz(context, looper, bVar, cVar, "locationServices", c1194e);
    }
}
