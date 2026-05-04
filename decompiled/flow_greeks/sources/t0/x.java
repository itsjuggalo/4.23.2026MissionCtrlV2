package t0;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f20560a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScrollFeedbackProvider f20561a;

        public b(View view) {
            this.f20561a = ScrollFeedbackProvider.createProvider(view);
        }

        @Override // t0.x.d
        public void onScrollLimit(int i10, int i11, int i12, boolean z10) {
            this.f20561a.onScrollLimit(i10, i11, i12, z10);
        }

        @Override // t0.x.d
        public void onScrollProgress(int i10, int i11, int i12, int i13) {
            this.f20561a.onScrollProgress(i10, i11, i12, i13);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        void onScrollLimit(int i10, int i11, int i12, boolean z10);

        void onScrollProgress(int i10, int i11, int i12, int i13);
    }

    public x(View view) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f20560a = new b(view);
        } else {
            this.f20560a = new c();
        }
    }

    public static x a(View view) {
        return new x(view);
    }

    public void b(int i10, int i11, int i12, boolean z10) {
        this.f20560a.onScrollLimit(i10, i11, i12, z10);
    }

    public void c(int i10, int i11, int i12, int i13) {
        this.f20560a.onScrollProgress(i10, i11, i12, i13);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements d {
        public c() {
        }

        @Override // t0.x.d
        public void onScrollLimit(int i10, int i11, int i12, boolean z10) {
        }

        @Override // t0.x.d
        public void onScrollProgress(int i10, int i11, int i12, int i13) {
        }
    }
}
