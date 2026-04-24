package androidx.emoji2.text;

import I0.a;
import U.j;
import U.k;
import U.p;
import android.content.Context;
import androidx.lifecycle.C0364v;
import androidx.lifecycle.InterfaceC0362t;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import r0.C0963a;
import r0.b;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements b {
    @Override // r0.b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // r0.b
    public final Object b(Context context) {
        Object objB;
        a aVar = new a();
        aVar.f623a = context.getApplicationContext();
        p pVar = new p(aVar);
        pVar.f3088b = 1;
        if (j.f3060j == null) {
            synchronized (j.i) {
                try {
                    if (j.f3060j == null) {
                        j.f3060j = new j(pVar);
                    }
                } finally {
                }
            }
        }
        C0963a c0963aC = C0963a.c(context);
        c0963aC.getClass();
        synchronized (C0963a.e) {
            try {
                objB = c0963aC.f9440a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = c0963aC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        C0364v c0364vH = ((InterfaceC0362t) objB).h();
        c0364vH.a(new k(this, c0364vH));
        return Boolean.TRUE;
    }
}
