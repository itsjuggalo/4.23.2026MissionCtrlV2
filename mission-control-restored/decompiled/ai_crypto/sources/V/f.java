package V;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public static class a {
        public static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        public static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        public static void c(PopupWindow popupWindow, boolean z7) {
            popupWindow.setOverlapAnchor(z7);
        }

        public static void d(PopupWindow popupWindow, int i7) {
            popupWindow.setWindowLayoutType(i7);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z7) {
        a.c(popupWindow, z7);
    }

    public static void b(PopupWindow popupWindow, int i7) {
        a.d(popupWindow, i7);
    }

    public static void c(PopupWindow popupWindow, View view, int i7, int i8, int i9) {
        popupWindow.showAsDropDown(view, i7, i8, i9);
    }
}
