package m;

import android.widget.AbsListView;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q {
    public static boolean a(AbsListView absListView) {
        return absListView.isSelectedChildViewEnabled();
    }

    public static void b(AbsListView absListView, boolean z6) {
        absListView.setSelectedChildViewEnabled(z6);
    }
}
