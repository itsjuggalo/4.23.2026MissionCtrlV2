package com.google.firebase.sessions;

import android.content.Context;
import b0.InterfaceC1178i;
import com.google.firebase.sessions.b;
import i4.AbstractC1925d;
import i4.InterfaceC1923b;
import n5.InterfaceC2426a;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InterfaceC1923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f15935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f15936b;

    public d(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        this.f15935a = interfaceC2426a;
        this.f15936b = interfaceC2426a2;
    }

    public static d a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        return new d(interfaceC2426a, interfaceC2426a2);
    }

    public static InterfaceC1178i c(Context context, InterfaceC2711i interfaceC2711i) {
        return (InterfaceC1178i) AbstractC1925d.d(b.InterfaceC0256b.f15932a.i(context, interfaceC2711i));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC1178i get() {
        return c((Context) this.f15935a.get(), (InterfaceC2711i) this.f15936b.get());
    }
}
