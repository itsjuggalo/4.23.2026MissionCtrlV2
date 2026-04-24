package io.flutter.plugins.sharedpreferences;

import W2.E;
import a3.AbstractC0787c;
import b3.InterfaceC0868f;
import java.util.List;
import t3.L;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC0868f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getKeys$prefs$1", f = "SharedPreferencesPlugin.kt", l = {248}, m = "invokeSuspend")
public final class SharedPreferencesPlugin$getKeys$prefs$1 extends b3.l implements i3.o {
    final /* synthetic */ List<String> $allowList;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$getKeys$prefs$1(SharedPreferencesPlugin sharedPreferencesPlugin, List<String> list, Z2.e eVar) {
        super(2, eVar);
        this.this$0 = sharedPreferencesPlugin;
        this.$allowList = list;
    }

    @Override // b3.AbstractC0863a
    public final Z2.e create(Object obj, Z2.e eVar) {
        return new SharedPreferencesPlugin$getKeys$prefs$1(this.this$0, this.$allowList, eVar);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.label;
        if (i4 != 0) {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            W2.q.b(obj);
            return obj;
        }
        W2.q.b(obj);
        SharedPreferencesPlugin sharedPreferencesPlugin = this.this$0;
        List<String> list = this.$allowList;
        this.label = 1;
        Object prefs = sharedPreferencesPlugin.getPrefs(list, this);
        return prefs == objE ? objE : prefs;
    }

    @Override // i3.o
    public final Object invoke(L l4, Z2.e eVar) {
        return ((SharedPreferencesPlugin$getKeys$prefs$1) create(l4, eVar)).invokeSuspend(E.f5463a);
    }
}
