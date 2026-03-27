package Q1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.AbstractC1294n;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: Q1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class ServiceConnectionC0789a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6676a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue f6677b = new LinkedBlockingQueue();

    public IBinder a(long j8, TimeUnit timeUnit) throws TimeoutException {
        AbstractC1294n.i("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f6676a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f6676a = true;
        IBinder iBinder = (IBinder) this.f6677b.poll(j8, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f6677b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
