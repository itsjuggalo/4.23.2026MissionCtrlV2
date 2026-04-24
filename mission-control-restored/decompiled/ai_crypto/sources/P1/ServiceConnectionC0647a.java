package P1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: P1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class ServiceConnectionC0647a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4282a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue f4283b = new LinkedBlockingQueue();

    public IBinder a() {
        AbstractC1207s.j("BlockingServiceConnection.getService() called on main thread");
        if (this.f4282a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f4282a = true;
        return (IBinder) this.f4283b.take();
    }

    public IBinder b(long j7, TimeUnit timeUnit) throws TimeoutException {
        AbstractC1207s.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f4282a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f4282a = true;
        IBinder iBinder = (IBinder) this.f4283b.poll(j7, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4283b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
