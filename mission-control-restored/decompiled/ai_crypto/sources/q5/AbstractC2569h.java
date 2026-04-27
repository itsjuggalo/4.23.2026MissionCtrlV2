package q5;

import R0.k;
import R0.l;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: q5.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2569h {

    /* JADX INFO: renamed from: q5.h$a */
    public interface a {
        void a(float f7, float f8, float f9);
    }

    /* JADX INFO: renamed from: q5.h$b */
    public interface b {
        boolean a(View view);
    }

    public static void c(Context context, a aVar) {
        Activity activityE = e(context);
        if (activityE != null) {
            k kVarA = l.b().a(activityE);
            aVar.a(kVarA.a().width(), kVarA.a().height(), context.getResources().getDisplayMetrics().density);
        }
    }

    public static boolean d(View view) {
        return i(view, new b() { // from class: q5.g
            @Override // q5.AbstractC2569h.b
            public final boolean a(View view2) {
                return view2.hasFocus();
            }
        });
    }

    public static Activity e(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return e(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean f(View view, final Class[] clsArr) {
        return i(view, new b() { // from class: q5.f
            @Override // q5.AbstractC2569h.b
            public final boolean a(View view2) {
                return AbstractC2569h.h(clsArr, view2);
            }
        });
    }

    public static /* synthetic */ boolean h(Class[] clsArr, View view) {
        for (Class cls : clsArr) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(View view, b bVar) {
        if (view == null) {
            return false;
        }
        if (bVar.a(view)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                if (i(viewGroup.getChildAt(i7), bVar)) {
                    return true;
                }
            }
        }
        return false;
    }
}
