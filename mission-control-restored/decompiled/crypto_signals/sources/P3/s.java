package P3;

import P2.C0217o;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.KeyEvent;
import io.flutter.view.FlutterCallbackInformation;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import s1.C0994k;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f2594d;
    public final /* synthetic */ Object e;

    public /* synthetic */ s(t tVar, z zVar, long j4, KeyEvent keyEvent, int i) {
        this.f2591a = i;
        this.f2592b = tVar;
        this.f2593c = zVar;
        this.f2594d = j4;
        this.e = keyEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2591a) {
            case 0:
                t tVar = (t) this.f2592b;
                tVar.getClass();
                tVar.c(false, Long.valueOf(((z) this.f2593c).f2608b), Long.valueOf(this.f2594d), ((KeyEvent) this.e).getEventTime());
                break;
            case 1:
                t tVar2 = (t) this.f2592b;
                tVar2.getClass();
                tVar2.c(false, Long.valueOf(((z) this.f2593c).f2608b), Long.valueOf(this.f2594d), ((KeyEvent) this.e).getEventTime());
                break;
            default:
                f.d dVar = (f.d) this.f2592b;
                dVar.getClass();
                String str = (String) ((C0217o) ((T3.d) this.f2593c).f3044d).f2474c;
                AssetManager assets = y5.a.f11721b.getAssets();
                if (!((AtomicBoolean) dVar.f6383c).get()) {
                    g3.c cVar = (g3.c) this.e;
                    if (cVar != null) {
                        Log.i("FLTFireBGExecutor", "Creating background FlutterEngine instance, with args: " + Arrays.toString(cVar.b()));
                        dVar.f6384d = new Q3.c(y5.a.f11721b, cVar.b());
                    } else {
                        Log.i("FLTFireBGExecutor", "Creating background FlutterEngine instance.");
                        dVar.f6384d = new Q3.c(y5.a.f11721b, null);
                    }
                    FlutterCallbackInformation flutterCallbackInformationLookupCallbackInformation = FlutterCallbackInformation.lookupCallbackInformation(this.f2594d);
                    if (flutterCallbackInformationLookupCallbackInformation != null) {
                        R3.b bVar = ((Q3.c) dVar.f6384d).f2707c;
                        Z3.q qVar = new Z3.q(bVar, "plugins.flutter.io/firebase_messaging_background");
                        dVar.f6382b = qVar;
                        qVar.b(dVar);
                        bVar.a(new C0994k(assets, str, flutterCallbackInformationLookupCallbackInformation, 18));
                    } else {
                        Log.e("FLTFireBGExecutor", "Failed to find registered callback");
                    }
                }
                break;
        }
    }

    public /* synthetic */ s(f.d dVar, T3.d dVar2, g3.c cVar, long j4) {
        this.f2591a = 2;
        this.f2592b = dVar;
        this.f2593c = dVar2;
        this.e = cVar;
        this.f2594d = j4;
    }
}
