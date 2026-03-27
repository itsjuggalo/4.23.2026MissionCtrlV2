package U;

import N1.C;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.AbstractC0358o;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0362t;

/* JADX INFO: loaded from: classes.dex */
public final class k implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0358o f3068a;

    public k(EmojiCompatInitializer emojiCompatInitializer, AbstractC0358o abstractC0358o) {
        this.f3068a = abstractC0358o;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void a(InterfaceC0362t interfaceC0362t) {
        (Build.VERSION.SDK_INT >= 28 ? b.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new C(1), 500L);
        this.f3068a.b(this);
    }
}
