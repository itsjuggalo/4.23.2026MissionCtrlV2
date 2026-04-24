package R1;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.InterfaceC1169f;
import com.google.android.gms.common.api.internal.InterfaceC1178o;
import com.google.android.gms.common.internal.C1194e;
import com.google.android.gms.common.internal.C1214z;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a.AbstractC0178a {
    @Override // com.google.android.gms.common.api.a.AbstractC0178a
    public final /* synthetic */ a.f buildClient(Context context, Looper looper, C1194e c1194e, Object obj, InterfaceC1169f interfaceC1169f, InterfaceC1178o interfaceC1178o) {
        return new e(context, looper, c1194e, (C1214z) obj, interfaceC1169f, interfaceC1178o);
    }
}
