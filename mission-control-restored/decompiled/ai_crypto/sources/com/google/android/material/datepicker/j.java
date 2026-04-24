package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class j<S> extends o {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f11590f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public com.google.android.material.datepicker.a f11591g0;

    public class a extends n {
        public a() {
        }
    }

    public static j G1(d dVar, int i7, com.google.android.material.datepicker.a aVar) {
        j jVar = new j();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i7);
        bundle.putParcelable("DATE_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        jVar.w1(bundle);
        return jVar;
    }

    @Override // m0.AbstractComponentCallbacksC2216p
    public void L0(Bundle bundle) {
        super.L0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f11590f0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f11591g0);
    }

    @Override // m0.AbstractComponentCallbacksC2216p
    public void p0(Bundle bundle) {
        super.p0(bundle);
        if (bundle == null) {
            bundle = r();
        }
        this.f11590f0 = bundle.getInt("THEME_RES_ID_KEY");
        android.support.v4.media.session.b.a(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f11591g0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // m0.AbstractComponentCallbacksC2216p
    public View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(t(), this.f11590f0));
        new a();
        throw null;
    }
}
