package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.d;
import o.a0;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements d.b, h, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f6334c = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f6335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6336b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.d.b
    public boolean a(e eVar) {
        return this.f6335a.H(eVar, 0);
    }

    public int getWindowAnimations() {
        return this.f6336b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        a((e) getAdapter().getItem(i4));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        a0 a0VarR = a0.r(context, attributeSet, f6334c, i4, 0);
        if (a0VarR.o(0)) {
            setBackgroundDrawable(a0VarR.f(0));
        }
        if (a0VarR.o(1)) {
            setDivider(a0VarR.f(1));
        }
        a0VarR.s();
    }
}
