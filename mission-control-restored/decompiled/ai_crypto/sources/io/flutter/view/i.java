package io.flutter.view;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static i f17054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static b f17055f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlutterJNI f17057b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f17056a = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f17058c = new c(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlutterJNI.b f17059d = new a();

    public class a implements FlutterJNI.b {
        public a() {
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.b
        public void a(long j7) {
            Choreographer.getInstance().postFrameCallback(b(j7));
        }

        public final Choreographer.FrameCallback b(long j7) {
            if (i.this.f17058c == null) {
                return i.this.new c(j7);
            }
            i.this.f17058c.f17063a = j7;
            c cVar = i.this.f17058c;
            i.this.f17058c = null;
            return cVar;
        }
    }

    public class b implements DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DisplayManager f17061a;

        public b(DisplayManager displayManager) {
            this.f17061a = displayManager;
        }

        public void a() {
            this.f17061a.registerDisplayListener(this, null);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i7) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i7) {
            if (i7 == 0) {
                float refreshRate = this.f17061a.getDisplay(0).getRefreshRate();
                i.this.f17056a = (long) (1.0E9d / ((double) refreshRate));
                i.this.f17057b.setRefreshRateFPS(refreshRate);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i7) {
        }
    }

    public class c implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f17063a;

        public c(long j7) {
            this.f17063a = j7;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j7) {
            long jNanoTime = System.nanoTime() - j7;
            i.this.f17057b.onVsync(jNanoTime < 0 ? 0L : jNanoTime, i.this.f17056a, this.f17063a);
            i.this.f17058c = this;
        }
    }

    public i(FlutterJNI flutterJNI) {
        this.f17057b = flutterJNI;
    }

    public static i f(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (f17054e == null) {
            f17054e = new i(flutterJNI);
        }
        if (f17055f == null) {
            i iVar = f17054e;
            Objects.requireNonNull(iVar);
            b bVar = iVar.new b(displayManager);
            f17055f = bVar;
            bVar.a();
        }
        if (f17054e.f17056a == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            f17054e.f17056a = (long) (1.0E9d / ((double) refreshRate));
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return f17054e;
    }

    public void g() {
        this.f17057b.setAsyncWaitForVsyncDelegate(this.f17059d);
    }
}
