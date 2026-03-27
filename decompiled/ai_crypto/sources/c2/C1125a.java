package c2;

import android.app.Activity;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.AbstractC1186x;
import com.google.android.gms.common.api.internal.C1164a;
import com.google.android.gms.common.api.internal.InterfaceC1181s;
import com.google.android.gms.internal.fido.zzo;
import com.google.android.gms.internal.fido.zzp;
import com.google.android.gms.internal.fido.zzs;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import d2.C1448u;

/* JADX INFO: renamed from: c2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1125a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f9333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f9334b;

    static {
        a.g gVar = new a.g();
        f9333a = gVar;
        f9334b = new com.google.android.gms.common.api.a("Fido.FIDO2_API", new zzo(), gVar);
    }

    public C1125a(Activity activity) {
        super(activity, f9334b, a.d.f10852M, new C1164a());
    }

    public Task d(final C1448u c1448u) {
        return doRead(AbstractC1186x.a().b(new InterfaceC1181s() { // from class: c2.b
            @Override // com.google.android.gms.common.api.internal.InterfaceC1181s
            public final void accept(Object obj, Object obj2) {
                C1125a c1125a = this.f9335a;
                C1448u c1448u2 = c1448u;
                ((zzs) ((zzp) obj).getService()).zzc(new BinderC1127c(c1125a, (TaskCompletionSource) obj2), c1448u2);
            }
        }).e(5407).a());
    }
}
