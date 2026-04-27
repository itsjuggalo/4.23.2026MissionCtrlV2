package H;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f484a;

    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f485a;

        public a(View view) {
            this.f485a = view;
        }
    }

    public static class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f486b;

        public b(View view) {
            super(view);
            this.f486b = view;
        }
    }

    public static class c {
    }

    public A(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f484a = new b(view);
        } else {
            this.f484a = new a(view);
        }
    }
}
