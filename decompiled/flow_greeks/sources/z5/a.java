package z5;

import a6.u;
import android.app.Activity;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.internal.fido.zzo;
import com.google.android.gms.internal.fido.zzp;
import com.google.android.gms.internal.fido.zzs;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f25598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f25599b;

    static {
        a.g gVar = new a.g();
        f25598a = gVar;
        f25599b = new com.google.android.gms.common.api.a("Fido.FIDO2_API", new zzo(), gVar);
    }

    public a(Activity activity) {
        super(activity, f25599b, a.d.J, new com.google.android.gms.common.api.internal.a());
    }

    public Task g(final u uVar) {
        return doRead(v.a().b(new q() { // from class: z5.b
            @Override // com.google.android.gms.common.api.internal.q
            public final void accept(Object obj, Object obj2) {
                ((zzs) ((zzp) obj).getService()).zzc(new c(this.f25600a, (TaskCompletionSource) obj2), uVar);
            }
        }).e(5407).a());
    }
}
