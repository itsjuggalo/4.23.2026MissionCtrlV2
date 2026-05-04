package v9;

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
import u9.k;
import u9.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ea.i f23165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f23166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayoutInflater f23167c;

    public c(k kVar, LayoutInflater layoutInflater, ea.i iVar) {
        this.f23166b = kVar;
        this.f23167c = layoutInflater;
        this.f23165a = iVar;
    }

    public static void i(Button button, String str) {
        try {
            Drawable drawableI = m0.a.i(button.getBackground());
            m0.a.e(drawableI, Color.parseColor(str));
            button.setBackground(drawableI);
        } catch (IllegalArgumentException e10) {
            l.e("Error parsing background color: " + e10.toString());
        }
    }

    public static void k(Button button, ea.d dVar) {
        String strB = dVar.c().b();
        i(button, dVar.b());
        button.setText(dVar.c().c());
        button.setTextColor(Color.parseColor(strB));
    }

    public boolean a() {
        return false;
    }

    public k b() {
        return this.f23166b;
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
        } catch (IllegalArgumentException e10) {
            l.e("Error parsing background color: " + e10.toString() + " color: " + str);
        }
    }
}
