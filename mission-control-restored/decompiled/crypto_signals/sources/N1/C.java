package N1;

import android.os.Trace;
import com.google.android.gms.internal.measurement.zzkm;
import z.AbstractC1453k;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ C f1119b = new C(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1120a;

    public /* synthetic */ C(int i) {
        this.f1120a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1120a) {
            case 0:
                zzkm.zzc();
                return;
            default:
                try {
                    int i = AbstractC1453k.f11728a;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (U.j.f3060j != null) {
                        U.j.a().c();
                        break;
                    }
                    Trace.endSection();
                    return;
                } catch (Throwable th) {
                    int i6 = AbstractC1453k.f11728a;
                    Trace.endSection();
                    throw th;
                }
        }
    }
}
