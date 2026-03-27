package z1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: z1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class ServiceConnectionC1983a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16079a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue f16080b = new LinkedBlockingQueue();

    public IBinder a() {
        AbstractC0940s.j("BlockingServiceConnection.getService() called on main thread");
        if (this.f16079a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f16079a = true;
        return (IBinder) this.f16080b.take();
    }

    public IBinder b(long j4, TimeUnit timeUnit) throws TimeoutException {
        AbstractC0940s.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f16079a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f16079a = true;
        IBinder iBinder = (IBinder) this.f16080b.poll(j4, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f16080b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
