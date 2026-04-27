package u1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.I;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: u1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC1199a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10271a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f10272b = new LinkedBlockingQueue();

    public final IBinder a() {
        I.f("BlockingServiceConnection.getService() called on main thread");
        if (this.f10271a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f10271a = true;
        return (IBinder) this.f10272b.take();
    }

    public final IBinder b() throws TimeoutException {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        I.f("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f10271a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f10271a = true;
        IBinder iBinder = (IBinder) this.f10272b.poll(10000L, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f10272b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
