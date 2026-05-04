package com.revenuecat.purchases.storage;

import cd.h0;
import kotlin.Metadata;
import kotlin.jvm.internal.v;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"H", "T", "", "exception", "Lcd/h0;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class KeyedDeferredValueStore$forgettingFailure$1$1 extends v implements k {
    final /* synthetic */ H $key;
    final /* synthetic */ KeyedDeferredValueStore<H, T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyedDeferredValueStore$forgettingFailure$1$1(KeyedDeferredValueStore<H, T> keyedDeferredValueStore, H h10) {
        super(1);
        this.this$0 = keyedDeferredValueStore;
        this.$key = h10;
    }

    @Override // pd.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return h0.f3852a;
    }

    public final void invoke(Throwable th) {
        if (th != null) {
            KeyedDeferredValueStore<H, T> keyedDeferredValueStore = this.this$0;
            Object obj = this.$key;
            synchronized (((KeyedDeferredValueStore) keyedDeferredValueStore).lock) {
                keyedDeferredValueStore.getDeferred().remove(obj);
                h0 h0Var = h0.f3852a;
            }
        }
    }
}
