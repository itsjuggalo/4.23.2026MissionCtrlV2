package S1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzbp;
import com.google.android.gms.internal.measurement.zzbq;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class S2 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ T2 f4232b;

    public S2(T2 t22, String str) {
        Objects.requireNonNull(t22);
        this.f4232b = t22;
        this.f4231a = str;
    }

    public final /* synthetic */ String a() {
        return this.f4231a;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f4232b.f4244a.a().r().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzbq zzbqVarZzb = zzbp.zzb(iBinder);
            if (zzbqVarZzb == null) {
                this.f4232b.f4244a.a().r().a("Install Referrer Service implementation was not found");
                return;
            }
            C0658q3 c0658q3 = this.f4232b.f4244a;
            c0658q3.a().w().a("Install Referrer Service connected");
            c0658q3.b().t(new R2(this, zzbqVarZzb, this));
        } catch (RuntimeException e4) {
            this.f4232b.f4244a.a().r().b("Exception occurred while calling Install Referrer API", e4);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f4232b.f4244a.a().w().a("Install Referrer Service disconnected");
    }
}
