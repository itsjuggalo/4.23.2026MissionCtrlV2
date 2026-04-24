package S1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AbstractC0925c;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class Y5 implements ServiceConnection, AbstractC0925c.a, AbstractC0925c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f4306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile C0704w2 f4307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0565e6 f4308c;

    public Y5(C0565e6 c0565e6) {
        Objects.requireNonNull(c0565e6);
        this.f4308c = c0565e6;
    }

    public final void a(Intent intent) {
        C0565e6 c0565e6 = this.f4308c;
        c0565e6.h();
        Context contextE = c0565e6.f4245a.e();
        F1.b bVarB = F1.b.b();
        synchronized (this) {
            try {
                if (this.f4306a) {
                    this.f4308c.f4245a.a().w().a("Connection attempt already in progress");
                    return;
                }
                C0565e6 c0565e62 = this.f4308c;
                c0565e62.f4245a.a().w().a("Using local app measurement service");
                this.f4306a = true;
                bVarB.a(contextE, intent, c0565e62.M(), 129);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c.b
    public final void b(C1984b c1984b) {
        C0565e6 c0565e6 = this.f4308c;
        c0565e6.f4245a.b().o();
        C2 c2Y = c0565e6.f4245a.y();
        if (c2Y != null) {
            c2Y.w().b("Service connection failed", c1984b);
        }
        synchronized (this) {
            this.f4306a = false;
            this.f4307b = null;
        }
        this.f4308c.f4245a.b().t(new X5(this, c1984b));
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c.a
    public final void c(int i4) {
        C0658q3 c0658q3 = this.f4308c.f4245a;
        c0658q3.b().o();
        c0658q3.a().v().a("Service connection suspended");
        c0658q3.b().t(new U5(this));
    }

    public final void d() {
        if (this.f4307b != null && (this.f4307b.isConnected() || this.f4307b.isConnecting())) {
            this.f4307b.disconnect();
        }
        this.f4307b = null;
    }

    public final void e() {
        C0565e6 c0565e6 = this.f4308c;
        c0565e6.h();
        Context contextE = c0565e6.f4245a.e();
        synchronized (this) {
            try {
                if (this.f4306a) {
                    this.f4308c.f4245a.a().w().a("Connection attempt already in progress");
                    return;
                }
                if (this.f4307b != null && (this.f4307b.isConnecting() || this.f4307b.isConnected())) {
                    this.f4308c.f4245a.a().w().a("Already awaiting connection attempt");
                    return;
                }
                this.f4307b = new C0704w2(contextE, Looper.getMainLooper(), this, this);
                this.f4308c.f4245a.a().w().a("Connecting to remote service");
                this.f4306a = true;
                AbstractC0940s.k(this.f4307b);
                this.f4307b.checkAvailabilityAndConnect();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c.a
    public final void f(Bundle bundle) {
        this.f4308c.f4245a.b().o();
        synchronized (this) {
            try {
                AbstractC0940s.k(this.f4307b);
                this.f4308c.f4245a.b().t(new S5(this, (InterfaceC0601j2) this.f4307b.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f4307b = null;
                this.f4306a = false;
            }
        }
    }

    public final /* synthetic */ void g(boolean z4) {
        this.f4306a = false;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4308c.f4245a.b().o();
        synchronized (this) {
            if (iBinder == null) {
                this.f4306a = false;
                this.f4308c.f4245a.a().o().a("Service connected with null binder");
                return;
            }
            InterfaceC0601j2 c0577g2 = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    c0577g2 = iInterfaceQueryLocalInterface instanceof InterfaceC0601j2 ? (InterfaceC0601j2) iInterfaceQueryLocalInterface : new C0577g2(iBinder);
                    this.f4308c.f4245a.a().w().a("Bound to IMeasurementService interface");
                } else {
                    this.f4308c.f4245a.a().o().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f4308c.f4245a.a().o().a("Service connect failed to get IMeasurementService");
            }
            if (c0577g2 == null) {
                this.f4306a = false;
                try {
                    F1.b bVarB = F1.b.b();
                    C0565e6 c0565e6 = this.f4308c;
                    bVarB.c(c0565e6.f4245a.e(), c0565e6.M());
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f4308c.f4245a.b().t(new Q5(this, c0577g2));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C0658q3 c0658q3 = this.f4308c.f4245a;
        c0658q3.b().o();
        c0658q3.a().v().a("Service disconnected");
        c0658q3.b().t(new R5(this, componentName));
    }
}
