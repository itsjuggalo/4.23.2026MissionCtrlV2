package c6;

import android.os.Looper;
import b6.I0;
import g6.t;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements t {
    @Override // g6.t
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // g6.t
    public I0 b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new d(f.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // g6.t
    public int c() {
        return 1073741823;
    }
}
