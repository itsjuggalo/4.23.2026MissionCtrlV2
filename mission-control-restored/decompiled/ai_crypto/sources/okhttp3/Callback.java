package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface Callback {
    void a(Call call, Response response);

    void b(Call call, IOException iOException);
}
