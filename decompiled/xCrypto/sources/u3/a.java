package u3;

import android.os.Looper;
import java.util.List;
import t3.I0;
import y3.t;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements t {
    @Override // y3.t
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // y3.t
    public I0 b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new d(f.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // y3.t
    public int c() {
        return 1073741823;
    }
}
