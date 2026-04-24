package Z6;

import Y6.E0;
import android.os.Looper;
import d7.r;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements r {
    @Override // d7.r
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // d7.r
    public E0 b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new d(f.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // d7.r
    public int c() {
        return 1073741823;
    }
}
