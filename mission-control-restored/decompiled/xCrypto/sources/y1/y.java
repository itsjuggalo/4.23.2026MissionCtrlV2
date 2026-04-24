package y1;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Messenger f15910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f15911b;

    public y(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if (Objects.equals(interfaceDescriptor, "android.os.IMessenger")) {
            this.f15910a = new Messenger(iBinder);
            this.f15911b = null;
        } else {
            if (!Objects.equals(interfaceDescriptor, "com.google.android.gms.iid.IMessengerCompat")) {
                Log.w("MessengerIpcClient", "Invalid interface descriptor: ".concat(String.valueOf(interfaceDescriptor)));
                throw new RemoteException();
            }
            this.f15911b = new l(iBinder);
            this.f15910a = null;
        }
    }

    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f15910a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        l lVar = this.f15911b;
        if (lVar == null) {
            throw new IllegalStateException("Both messengers are null");
        }
        lVar.b(message);
    }
}
