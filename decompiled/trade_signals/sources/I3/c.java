package I3;

import H3.k;
import H3.l;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R3.i f4075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f4076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayoutInflater f4077c;

    public c(k kVar, LayoutInflater layoutInflater, R3.i iVar) {
        this.f4076b = kVar;
        this.f4077c = layoutInflater;
        this.f4075a = iVar;
    }

    public static void i(Button button, String str) {
        try {
            Drawable drawableI = M.a.i(button.getBackground());
            M.a.e(drawableI, Color.parseColor(str));
            button.setBackground(drawableI);
        } catch (IllegalArgumentException e8) {
            l.e("Error parsing background color: " + e8.toString());
        }
    }

    public static void k(Button button, R3.d dVar) {
        String strB = dVar.c().b();
        i(button, dVar.b());
        button.setText(dVar.c().c());
        button.setTextColor(Color.parseColor(strB));
    }

    public boolean a() {
        return false;
    }

    public k b() {
        return this.f4076b;
    }

    public abstract View c();

    public View.OnClickListener d() {
        return null;
    }

    public abstract ImageView e();

    public abstract ViewGroup f();

    public abstract ViewTreeObserver.OnGlobalLayoutListener g(Map map, View.OnClickListener onClickListener);

    public void h(Button button, View.OnClickListener onClickListener) {
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
    }

    public void j(View view, String str) {
        if (view == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            view.setBackgroundColor(Color.parseColor(str));
        } catch (IllegalArgumentException e8) {
            l.e("Error parsing background color: " + e8.toString() + " color: " + str);
        }
    }
}
