package okhttp3.internal.connection;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class StreamAllocation {

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
    }

    public final String toString() {
        RealConnection realConnection;
        synchronized (this) {
            realConnection = null;
        }
        realConnection.getClass();
        realConnection.toString();
        throw null;
    }
}
