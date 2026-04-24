package Z3;

import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4003c;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.f4001a = i;
        this.f4003c = obj;
        this.f4002b = obj2;
    }

    @Override // Z3.e
    public final void a(ByteBuffer byteBuffer) {
        switch (this.f4001a) {
            case 0:
                e3.w wVar = (e3.w) this.f4003c;
                try {
                    ((c) this.f4002b).f(((m) wVar.f6193d).b(byteBuffer));
                } catch (RuntimeException e) {
                    Log.e("BasicMessageChannel#" + ((String) wVar.f6191b), "Failed to handle message reply", e);
                    return;
                }
                break;
            default:
                q qVar = (q) this.f4003c;
                p pVar = (p) this.f4002b;
                try {
                    if (byteBuffer == null) {
                        pVar.b();
                    } else {
                        try {
                            pVar.c(qVar.f4017c.f(byteBuffer));
                        } catch (j e2) {
                            pVar.a(e2.f4010b, e2.f4009a, e2.getMessage());
                        }
                    }
                } catch (RuntimeException e6) {
                    Log.e("MethodChannel#" + qVar.f4016b, "Failed to handle method call result", e6);
                    return;
                }
                break;
        }
    }
}
