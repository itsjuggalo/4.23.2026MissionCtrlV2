package z1;

import H1.InterfaceC0586d;
import android.content.Context;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class v implements Closeable {

    public interface a {
        v a();

        a b(Context context);
    }

    public abstract InterfaceC0586d a();

    public abstract u c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a().close();
    }
}
