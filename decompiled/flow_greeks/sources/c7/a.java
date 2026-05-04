package c7;

import android.content.Context;
import b7.c;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3704a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fa.b f3706c;

    public a(Context context, fa.b bVar) {
        this.f3705b = context;
        this.f3706c = bVar;
    }

    public c a(String str) {
        return new c(this.f3705b, this.f3706c, str);
    }

    public synchronized c b(String str) {
        try {
            if (!this.f3704a.containsKey(str)) {
                this.f3704a.put(str, a(str));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (c) this.f3704a.get(str);
    }
}
