package d3;

import android.os.Handler;
import android.os.Looper;
import h3.InterfaceC1874j;

/* JADX INFO: renamed from: d3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1632h implements InterfaceC1874j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f16855a = new Handler(Looper.getMainLooper());

    @Override // h3.InterfaceC1874j
    public void b(Runnable runnable) {
        this.f16855a.post(runnable);
    }

    @Override // h3.InterfaceC1874j
    public void a() {
    }
}
