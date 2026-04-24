package U1;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.C0927e;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a.AbstractC0145a {
    @Override // com.google.android.gms.common.api.a.AbstractC0145a
    public final /* bridge */ /* synthetic */ a.f buildClient(Context context, Looper looper, C0927e c0927e, Object obj, f.b bVar, f.c cVar) {
        return new V1.a(context, looper, true, c0927e, V1.a.e(c0927e), bVar, cVar);
    }
}
