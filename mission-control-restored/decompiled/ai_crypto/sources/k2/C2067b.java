package k2;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.C1194e;
import l2.C2156a;

/* JADX INFO: renamed from: k2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2067b extends a.AbstractC0178a {
    @Override // com.google.android.gms.common.api.a.AbstractC0178a
    public final /* bridge */ /* synthetic */ a.f buildClient(Context context, Looper looper, C1194e c1194e, Object obj, f.b bVar, f.c cVar) {
        return new C2156a(context, looper, true, c1194e, C2156a.e(c1194e), bVar, cVar);
    }
}
