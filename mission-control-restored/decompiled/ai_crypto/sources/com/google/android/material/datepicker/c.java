package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import n2.AbstractC2252a;
import z2.AbstractC2880b;
import z2.AbstractC2881c;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f11513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f11515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f11516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f11517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f11518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f11519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f11520h;

    public c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC2880b.c(context, AbstractC2252a.f19112p, h.class.getCanonicalName()), n2.j.f19537o2);
        this.f11513a = b.a(context, typedArrayObtainStyledAttributes.getResourceId(n2.j.f19558r2, 0));
        this.f11519g = b.a(context, typedArrayObtainStyledAttributes.getResourceId(n2.j.f19544p2, 0));
        this.f11514b = b.a(context, typedArrayObtainStyledAttributes.getResourceId(n2.j.f19551q2, 0));
        this.f11515c = b.a(context, typedArrayObtainStyledAttributes.getResourceId(n2.j.f19565s2, 0));
        ColorStateList colorStateListA = AbstractC2881c.a(context, typedArrayObtainStyledAttributes, n2.j.f19572t2);
        this.f11516d = b.a(context, typedArrayObtainStyledAttributes.getResourceId(n2.j.f19586v2, 0));
        this.f11517e = b.a(context, typedArrayObtainStyledAttributes.getResourceId(n2.j.f19579u2, 0));
        this.f11518f = b.a(context, typedArrayObtainStyledAttributes.getResourceId(n2.j.f19593w2, 0));
        Paint paint = new Paint();
        this.f11520h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
