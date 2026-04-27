package Y;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

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

        public static void d(PopupWindow popupWindow, int i8) {
            popupWindow.setWindowLayoutType(i8);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z7) {
        a.c(popupWindow, z7);
    }

    public static void b(PopupWindow popupWindow, int i8) {
        a.d(popupWindow, i8);
    }

    public static void c(PopupWindow popupWindow, View view, int i8, int i9, int i10) {
        popupWindow.showAsDropDown(view, i8, i9, i10);
    }
}
