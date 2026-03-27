package com.revenuecat.purchases.blockstore;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.InterfaceC0868f;
import b3.l;
import i3.o;
import kotlin.jvm.functions.Function0;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0868f(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1", f = "BlockstoreHelper.kt", l = {}, m = "invokeSuspend")
public final class BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1 extends l implements o {
    final /* synthetic */ Function0 $callback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1(Function0 function0, e eVar) {
        super(2, eVar);
        this.$callback = function0;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1(this.$callback, eVar);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC0787c.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.b(obj);
        this.$callback.invoke();
        return E.f5463a;
    }

    @Override // i3.o
    public final Object invoke(L l4, e eVar) {
        return ((BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1) create(l4, eVar)).invokeSuspend(E.f5463a);
    }
}
