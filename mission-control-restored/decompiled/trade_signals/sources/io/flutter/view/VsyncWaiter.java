package io.flutter.view;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class VsyncWaiter {
    private static VsyncWaiter instance;
    private static DisplayListener listener;
    private FlutterJNI flutterJNI;
    private long refreshPeriodNanos = -1;
    private FrameCallback frameCallback = new FrameCallback(0);
    private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate() { // from class: io.flutter.view.VsyncWaiter.1
        private Choreographer.FrameCallback obtainFrameCallback(long j8) {
            if (VsyncWaiter.this.frameCallback == null) {
                return VsyncWaiter.this.new FrameCallback(j8);
            }
            VsyncWaiter.this.frameCallback.cookie = j8;
            FrameCallback frameCallback = VsyncWaiter.this.frameCallback;
            VsyncWaiter.this.frameCallback = null;
            return frameCallback;
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate
        public void asyncWaitForVsync(long j8) {
            Choreographer.getInstance().postFrameCallback(obtainFrameCallback(j8));
        }
    };

    public class DisplayListener implements DisplayManager.DisplayListener {
        private DisplayManager displayManager;

        public DisplayListener(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i8) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i8) {
            if (i8 == 0) {
                float refreshRate = this.displayManager.getDisplay(0).getRefreshRate();
                VsyncWaiter.this.refreshPeriodNanos = (long) (1.0E9d / ((double) refreshRate));
                VsyncWaiter.this.flutterJNI.setRefreshRateFPS(refreshRate);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i8) {
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, null);
        }
    }

    public class FrameCallback implements Choreographer.FrameCallback {
        private long cookie;

        public FrameCallback(long j8) {
            this.cookie = j8;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j8) {
            long jNanoTime = System.nanoTime() - j8;
            VsyncWaiter.this.flutterJNI.onVsync(jNanoTime < 0 ? 0L : jNanoTime, VsyncWaiter.this.refreshPeriodNanos, this.cookie);
            VsyncWaiter.this.frameCallback = this;
        }
    }

    private VsyncWaiter(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    public static VsyncWaiter getInstance(float f8, FlutterJNI flutterJNI) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI);
        }
        flutterJNI.setRefreshRateFPS(f8);
        VsyncWaiter vsyncWaiter = instance;
        vsyncWaiter.refreshPeriodNanos = (long) (1.0E9d / ((double) f8));
        return vsyncWaiter;
    }

    public static void reset() {
        instance = null;
        listener = null;
    }

    public void init() {
        this.flutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
    }

    public static VsyncWaiter getInstance(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI);
        }
        if (listener == null) {
            VsyncWaiter vsyncWaiter = instance;
            Objects.requireNonNull(vsyncWaiter);
            DisplayListener displayListener = vsyncWaiter.new DisplayListener(displayManager);
            listener = displayListener;
            displayListener.register();
        }
        if (instance.refreshPeriodNanos == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            instance.refreshPeriodNanos = (long) (1.0E9d / ((double) refreshRate));
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return instance;
    }
}
