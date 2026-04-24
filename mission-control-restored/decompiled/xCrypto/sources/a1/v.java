package a1;

import android.content.Context;
import i1.InterfaceC1297d;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class v implements Closeable {

    public interface a {
        a a(Context context);

        v build();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        e().close();
    }

    public abstract InterfaceC1297d e();

    public abstract u f();
}
