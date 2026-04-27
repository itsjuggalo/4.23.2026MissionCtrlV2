package T;

import android.os.Build;
import android.view.View;

/* JADX INFO: renamed from: T.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0943z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f7883a;

    /* JADX INFO: renamed from: T.z$a */
    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f7884a;

        public a(View view) {
            this.f7884a = view;
        }
    }

    /* JADX INFO: renamed from: T.z$b */
    public static class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f7885b;

        public b(View view) {
            super(view);
            this.f7885b = view;
        }
    }

    /* JADX INFO: renamed from: T.z$c */
    public static class c {
    }

    public C0943z(View view) {
        this.f7883a = Build.VERSION.SDK_INT >= 30 ? new b(view) : new a(view);
    }
}
