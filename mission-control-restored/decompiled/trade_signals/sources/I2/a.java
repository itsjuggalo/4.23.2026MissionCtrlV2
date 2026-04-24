package I2;

import H2.c;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f4063a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f4064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final S3.b f4065c;

    public a(Context context, S3.b bVar) {
        this.f4064b = context;
        this.f4065c = bVar;
    }

    public c a(String str) {
        return new c(this.f4064b, this.f4065c, str);
    }

    public synchronized c b(String str) {
        try {
            if (!this.f4063a.containsKey(str)) {
                this.f4063a.put(str, a(str));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (c) this.f4063a.get(str);
    }
}
