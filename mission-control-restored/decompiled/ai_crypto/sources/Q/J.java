package Q;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4373a;

    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f4374a;

        public a(View view) {
            this.f4374a = view;
        }
    }

    public static class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f4375b;

        public b(View view) {
            super(view);
            this.f4375b = view;
        }
    }

    public static class c {
    }

    public J(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f4373a = new b(view);
        } else {
            this.f4373a = new a(view);
        }
    }
}
