package io.flutter.plugin.platform;

import android.app.Activity;
import android.hardware.display.VirtualDisplay;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class z {
    public static final w i = new w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SingleViewPresentation f7219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f7220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0704a f7221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7222d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f7223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f7224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VirtualDisplay f7225h;

    public z(Activity activity, C0704a c0704a, VirtualDisplay virtualDisplay, f fVar, g gVar, j jVar, int i6) {
        this.f7220b = activity;
        this.f7221c = c0704a;
        this.f7223f = gVar;
        this.f7224g = jVar;
        this.e = i6;
        this.f7225h = virtualDisplay;
        this.f7222d = activity.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(activity, this.f7225h.getDisplay(), fVar, c0704a, i6, jVar);
        this.f7219a = singleViewPresentation;
        singleViewPresentation.show();
    }

    public final View a() {
        SingleViewPresentation singleViewPresentation = this.f7219a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }
}
