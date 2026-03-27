package l;

import D.C;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import com.cryptosignals.ap.android.R;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f8028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8030d;
    public View e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f8033h;
    public k i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f8034j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8031f = 8388611;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l f8035k = new l(this);

    public n(int i, Context context, View view, i iVar, boolean z6) {
        this.f8027a = context;
        this.f8028b = iVar;
        this.e = view;
        this.f8029c = z6;
        this.f8030d = i;
    }

    public final k a() {
        k sVar;
        if (this.i == null) {
            Context context = this.f8027a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            m.a(defaultDisplay, point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                sVar = new f(context, this.e, this.f8030d, this.f8029c);
            } else {
                View view = this.e;
                Context context2 = this.f8027a;
                boolean z6 = this.f8029c;
                sVar = new s(this.f8030d, context2, view, this.f8028b, z6);
            }
            sVar.l(this.f8028b);
            sVar.r(this.f8035k);
            sVar.n(this.e);
            sVar.e(this.f8033h);
            sVar.o(this.f8032g);
            sVar.p(this.f8031f);
            this.i = sVar;
        }
        return this.i;
    }

    public final boolean b() {
        k kVar = this.i;
        return kVar != null && kVar.j();
    }

    public void c() {
        this.i = null;
        l lVar = this.f8034j;
        if (lVar != null) {
            lVar.onDismiss();
        }
    }

    public final void d(int i, int i6, boolean z6, boolean z7) {
        k kVarA = a();
        kVarA.s(z7);
        if (z6) {
            int i7 = this.f8031f;
            View view = this.e;
            Field field = C.f194a;
            if ((Gravity.getAbsoluteGravity(i7, view.getLayoutDirection()) & 7) == 5) {
                i -= this.e.getWidth();
            }
            kVarA.q(i);
            kVarA.t(i6);
            int i8 = (int) ((this.f8027a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            kVarA.f8025a = new Rect(i - i8, i6 - i8, i + i8, i6 + i8);
        }
        kVarA.b();
    }
}
