package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.d;
import o.L;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements d.b, h, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f10377c = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f10378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10379b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.d.b
    public boolean a(e eVar) {
        return this.f10378a.I(eVar, 0);
    }

    public int getWindowAnimations() {
        return this.f10379b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i8, long j8) {
        a((e) getAdapter().getItem(i8));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        L lS = L.s(context, attributeSet, f10377c, i8, 0);
        if (lS.p(0)) {
            setBackgroundDrawable(lS.f(0));
        }
        if (lS.p(1)) {
            setDivider(lS.f(1));
        }
        lS.u();
    }
}
