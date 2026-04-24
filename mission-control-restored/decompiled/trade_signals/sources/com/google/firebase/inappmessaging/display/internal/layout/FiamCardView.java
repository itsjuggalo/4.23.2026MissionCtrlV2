package com.google.firebase.inappmessaging.display.internal.layout;

import M3.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import v.AbstractC2832a;

/* JADX INFO: loaded from: classes.dex */
public class FiamCardView extends AbstractC2832a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f15573j;

    public FiamCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean boolA = this.f15573j.a(keyEvent);
        return boolA != null ? boolA.booleanValue() : super.dispatchKeyEvent(keyEvent);
    }

    public void setDismissListener(View.OnClickListener onClickListener) {
        this.f15573j = new a(this, onClickListener);
    }
}
