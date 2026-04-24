package T3;

import P3.s;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f3036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f3037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Handler f3038d;
    public final /* synthetic */ s e;

    public /* synthetic */ b(d dVar, Context context, Handler handler, s sVar, int i) {
        this.f3035a = i;
        this.f3036b = dVar;
        this.f3037c = context;
        this.f3038d = handler;
        this.e = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3035a) {
            case 0:
                d dVar = this.f3036b;
                try {
                    Looper mainLooper = Looper.getMainLooper();
                    (Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(mainLooper) : new Handler(mainLooper)).post(new b(dVar, this.f3037c, this.f3038d, this.e, 1));
                    return;
                } catch (Exception e) {
                    Log.e("FlutterLoader", "Flutter initialization failed.", e);
                    throw new RuntimeException(e);
                }
            default:
                this.f3036b.a(this.f3037c.getApplicationContext(), null);
                this.f3038d.post(this.e);
                return;
        }
    }
}
