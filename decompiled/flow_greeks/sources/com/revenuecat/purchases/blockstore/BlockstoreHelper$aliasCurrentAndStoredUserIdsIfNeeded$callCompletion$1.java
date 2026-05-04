package com.revenuecat.purchases.blockstore;

import cd.h0;
import cd.s;
import gd.e;
import hd.c;
import id.f;
import id.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import ng.n0;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {1, 8, 0})
@f(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1", f = "BlockstoreHelper.kt", l = {}, m = "invokeSuspend")
public final class BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1 extends m implements o {
    final /* synthetic */ Function0 $callback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1(Function0 function0, e eVar) {
        super(2, eVar);
        this.$callback = function0;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1(this.$callback, eVar);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        c.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        s.b(obj);
        this.$callback.invoke();
        return h0.f3852a;
    }

    @Override // pd.o
    public final Object invoke(n0 n0Var, e eVar) {
        return ((BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
    }
}
