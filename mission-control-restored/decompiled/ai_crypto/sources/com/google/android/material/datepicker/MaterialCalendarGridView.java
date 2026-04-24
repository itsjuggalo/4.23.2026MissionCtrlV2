package com.google.android.material.datepicker;

import Q.C0660a;
import Q.N;
import R.x;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f11490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11491b;

    public class a extends C0660a {
        public a() {
        }

        @Override // Q.C0660a
        public void g(View view, x xVar) {
            super.g(view, xVar);
            xVar.l0(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(int i7, Rect rect) {
        if (i7 == 33) {
            setSelection(getAdapter().g());
        } else if (i7 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i7, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public l getAdapter() {
        return (l) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        l adapter = getAdapter();
        adapter.getClass();
        int iMax = Math.max(adapter.b(), getFirstVisiblePosition());
        int iMin = Math.min(adapter.g(), getLastVisiblePosition());
        adapter.getItem(iMax);
        adapter.getItem(iMin);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z7, int i7, Rect rect) {
        if (z7) {
            a(i7, rect);
        } else {
            super.onFocusChanged(false, i7, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i7, KeyEvent keyEvent) {
        if (!super.onKeyDown(i7, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i7) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i7, int i8) {
        if (!this.f11491b) {
            super.onMeasure(i7, i8);
            return;
        }
        super.onMeasure(i7, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i7) {
        if (i7 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i7);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f11490a = r.i();
        if (i.b2(getContext())) {
            setNextFocusLeftId(n2.e.f19188a);
            setNextFocusRightId(n2.e.f19190c);
        }
        this.f11491b = i.c2(getContext());
        N.l0(this, new a());
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof l)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), l.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
