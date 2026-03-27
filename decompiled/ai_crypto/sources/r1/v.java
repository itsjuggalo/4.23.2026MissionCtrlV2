package r1;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;
import z1.InterfaceC2859d;

/* JADX INFO: loaded from: classes.dex */
public abstract class v implements Closeable {

    public interface a {
        v a();

        a b(Context context);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        h().close();
    }

    public abstract InterfaceC2859d h();

    public abstract u i();
}
