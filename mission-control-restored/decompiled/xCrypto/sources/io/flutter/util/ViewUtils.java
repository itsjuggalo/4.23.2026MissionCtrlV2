package io.flutter.util;

import A0.k;
import A0.l;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import io.flutter.util.ViewUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewUtils {

    public interface DisplayUpdater {
        void updateDisplayMetrics(float f4, float f5, float f6);
    }

    public interface ViewVisitor {
        boolean run(View view);
    }

    public static /* synthetic */ boolean b(Class[] clsArr, View view) {
        for (Class cls : clsArr) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static void calculateMaximumDisplayMetrics(Context context, DisplayUpdater displayUpdater) {
        Activity activity = getActivity(context);
        if (activity != null) {
            k kVarA = l.b().a(activity);
            displayUpdater.updateDisplayMetrics(kVarA.a().width(), kVarA.a().height(), context.getResources().getDisplayMetrics().density);
        }
    }

    public static boolean childHasFocus(View view) {
        return traverseHierarchy(view, new ViewVisitor() { // from class: J2.b
            @Override // io.flutter.util.ViewUtils.ViewVisitor
            public final boolean run(View view2) {
                return view2.hasFocus();
            }
        });
    }

    public static Activity getActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean hasChildViewOfType(View view, final Class<? extends View>[] clsArr) {
        return traverseHierarchy(view, new ViewVisitor() { // from class: J2.a
            @Override // io.flutter.util.ViewUtils.ViewVisitor
            public final boolean run(View view2) {
                return ViewUtils.b(clsArr, view2);
            }
        });
    }

    public static boolean traverseHierarchy(View view, ViewVisitor viewVisitor) {
        if (view == null) {
            return false;
        }
        if (viewVisitor.run(view)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                if (traverseHierarchy(viewGroup.getChildAt(i4), viewVisitor)) {
                    return true;
                }
            }
        }
        return false;
    }
}
