package t0;

import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f20562a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f20563a;

        public a(View view) {
            this.f20563a = view;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f20564b;

        public b(View view) {
            super(view);
            this.f20564b = view;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {
    }

    public y(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f20562a = new b(view);
        } else {
            this.f20562a = new a(view);
        }
    }
}
